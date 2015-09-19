package com.codekarma.controller;

import java.io.File;
import java.io.IOException;
import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.codekarma.domain.Building;
import com.codekarma.domain.Category;
import com.codekarma.domain.Item;
import com.codekarma.domain.ResourceRequest;
import com.codekarma.domain.ResourceStatus;
import com.codekarma.exception.InvalidOperationException;
import com.codekarma.service.BuildingService;
import com.codekarma.service.CategoryService;
import com.codekarma.service.ResourcesService;

@Controller
@RequestMapping("/items")
public class ResourcesController {

	@Autowired
	ResourcesService resourcesService;
	@Autowired
	CategoryService categoryService;
	@Autowired
	BuildingService buildingService;

	@RequestMapping(value = "/item.add", method = RequestMethod.GET)
	public String getNewResourceForm(@ModelAttribute("newItem") Item item,
			Model model) {
		prepareForAdd(item, model);
		return "items/add";
	}

	private void prepareForAdd(Item item, Model model) {
		List<Category> categories = categoryService.getCategories();
		List<Building> buildings = buildingService.getAllList();
		Building b = new Building();
		b.setId(-10);
		b.setName("");
		buildings.add(0, b);
		model.addAttribute("categories", categories);
		model.addAttribute("buildings", buildings);
	}

	@RequestMapping(value = "/item.add", method = RequestMethod.POST)
	public String saveNewResource(@Valid @ModelAttribute("newItem") Item item,
			BindingResult result, RedirectAttributes redirectAttributes,
			HttpServletRequest request, Model model)
			throws IllegalStateException, IOException {
		if (result.hasErrors()) {
			prepareForAdd(item, model);
			return "items/add";
		}
		// image handling
		MultipartFile itemImage = item.getImage();
		if (itemImage != null && !itemImage.isEmpty()) {
			String physicalPath = request.getSession().getServletContext()
					.getRealPath("/")+ "\\resources\\itemsimages\\" 
					+ item.getImageUrl();
			itemImage.transferTo(new File(physicalPath));
		}
		// status update
		item.setStatus(ResourceStatus.AVAILABLE);
		Item inserted = resourcesService.addNewItem(item);
		redirectAttributes.addFlashAttribute("item", inserted);
		return "redirect:/items/item";
	}

	@RequestMapping(value = "/item")
	public String getItem() {
		return "items/item";
	}
	
	@RequestMapping(value="/detail/{id}")
	public String getItemDetail(@PathVariable("id") Long id, Model model){
		Item item = resourcesService.getById(id);
		model.addAttribute("item", item);
		return "items/item";
	}
	
	@RequestMapping(value= "/list", method=RequestMethod.GET)
	public String getItems(Model model){
		List<Item> items = resourcesService.getItems(15);
		model.addAttribute("resources", items);
		return "items/list";
	}
	
	@RequestMapping(value="/request/{id}")
	public String requestItem(@PathVariable("id") Long id, RedirectAttributes redirectAttributes, HttpServletRequest request){
		Principal principal = request.getUserPrincipal();
		if(principal == null){
			throw new InvalidOperationException("", "Couldn't retrieve principal from client's request.");
		}
		String username = principal.getName();
		ResourceRequest resourceRequest = resourcesService.addNewRequest(id, username);
		redirectAttributes.addFlashAttribute("request", resourceRequest);
		return "redirect:/items/requestadded";
	}
	
	@RequestMapping(value="/requestadded")
	public String getRequestAddedPage(){
		return "items/requestadded";
	}
	
	@RequestMapping(value="/requests.resolve")
	public String getRequestResolveForm(Model model){
		List<ResourceRequest> requests = resourcesService.getResourceRequests();
		model.addAttribute("requests", requests);
		return "items/allrequests";
	}
	
	@RequestMapping(value="/requestgranted/{requestId}")
	public String grantRequest(@PathVariable("requestId") Integer requestId){
		resourcesService.grantRequestForRequestId(requestId);
		return "redirect:/items/requests.resolve";
	}

	@RequestMapping(value="/requestdiscarded/{requestId}")
	public String discardRequest(@PathVariable("requestId") Integer requestId){
		resourcesService.discardRequestForRequestId(requestId);
		return "redirect:/items/requests.resolve";
	}
}
