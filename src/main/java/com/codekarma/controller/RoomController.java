package com.codekarma.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.hibernate.mapping.KeyValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.codekarma.domain.Building;
import com.codekarma.domain.Pair;
import com.codekarma.domain.Response;
import com.codekarma.domain.Room;
import com.codekarma.exception.ResponseStatusException;
import com.codekarma.service.BuildingService;
import com.codekarma.service.RoomService;

@RequestMapping("/room")
@Controller
public class RoomController {

	@Autowired
	RoomService roomService;
	
	@Autowired
	BuildingService buildingService;
	
	@RequestMapping(value = { "/", "" }, method = RequestMethod.GET)
	public String index(Model model) {
		List<Room> roomList = roomService.getAllList();
		model.addAttribute("roomList", roomList);
		return "room/list";
	}

	@RequestMapping(value = { "/add" }, method = RequestMethod.GET)
	public String add(@ModelAttribute("room") Room Room, ModelMap model) {

		Map<String, String> buildingList = buildingService.getOptionList();
		model.addAttribute("buildingList", buildingList);
		model.addAttribute("buttonName", "Save");
		model.addAttribute("title", "Add New");
		

		return "room/add";
	}

	@RequestMapping(value = { "/add" }, method = RequestMethod.POST)
	public String addSave(@Valid @ModelAttribute Room room, BindingResult result, ModelMap model, RedirectAttributes redirectAttributes) {

		if (result.hasErrors()) {
			Map<String, String> buildingList = buildingService.getOptionList();
			model.addAttribute("buildingList", buildingList);
			model.addAttribute("buttonName", "Save");
			model.addAttribute("title", "Add New");
			
			return "room/add";
		}
		roomService.add(room);
		redirectAttributes.addFlashAttribute(room);
		return "redirect:/room/detail";

	}
	
	@RequestMapping(value="/detail", method = RequestMethod.GET)
	public String detail()
	{
		return "room/detail";
		
	}

	@RequestMapping(value = { "/edit/{id}" }, method = RequestMethod.GET)
	public String edit(@PathVariable int id, ModelMap model) {
		
		Room room = roomService.getDetail(id);
		if (room == null)
			throw new ResponseStatusException();
		
		Map<String, String> buildingList = buildingService.getOptionList();
		model.addAttribute("buildingList", buildingList);
		model.addAttribute("room",room);
		model.addAttribute("buttonName", "Update");
		model.addAttribute("title", "Edit");
		
		return "room/add";
	}

	@RequestMapping(value = { "/edit/{id}" }, method = RequestMethod.POST)
	public String update(@PathVariable int id, @Valid @ModelAttribute Room room, BindingResult result, ModelMap model) {

		
		if (result.hasErrors()) {
			Map<String, String> buildingList = buildingService.getOptionList();
			model.addAttribute("buildingList", buildingList);
			model.addAttribute("buttonName", "Update");
			model.addAttribute("title", "Edit");
			return "room/add";
		}

		roomService.edit(room);
		
		return "room/detail";

	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public @ResponseBody Response delete(@PathVariable int id) throws RuntimeException {
		roomService.delete(id);
		Response response = new Response();
		response.setMessage("Record successfully deleted.");
		response.setSuccess(true);
		return response;
	}
	
	@RequestMapping(value="/forbuilding/{id}", method=RequestMethod.GET)
	public @ResponseBody List< Pair<Integer, String>> getRoomsInTheBuilding(@PathVariable("id") Integer buildingId){
		return buildingService.Rooms(buildingId);
	}

}
