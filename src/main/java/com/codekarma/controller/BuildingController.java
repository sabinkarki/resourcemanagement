package com.codekarma.controller;

import java.util.List;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.codekarma.domain.Building;
import com.codekarma.domain.Response;
import com.codekarma.exception.ResponseStatusException;
import com.codekarma.service.BuildingService;

@RequestMapping("/building")
@Controller
public class BuildingController {

	@Autowired
	BuildingService buildingService;

	@RequestMapping(value = { "/", "" }, method = RequestMethod.GET)
	public String index(Model model) {
		List<Building> buildingList = buildingService.getAllList();
		model.addAttribute("buildingList", buildingList);
		return "building/list";
	}

	@RequestMapping(value = { "/add" }, method = RequestMethod.GET)
	public String add(@ModelAttribute("building") Building Building, ModelMap model) {

		model.addAttribute("buttonName", "Save");
		model.addAttribute("title", "Add New");

		return "building/add";
	}

	@RequestMapping(value = { "/add" }, method = RequestMethod.POST)
	public String addSave(@Valid @ModelAttribute Building building, BindingResult result, ModelMap model) {

		model.addAttribute("buttonName", "Save");
		model.addAttribute("title", "Add New");

		if (result.hasErrors()) {
			return "building/add";
		}
		buildingService.add(building);

		return "building/detail";

	}

	@RequestMapping(value = { "/edit/{id}" }, method = RequestMethod.GET)
	public String edit(@PathVariable int id, ModelMap model) {

		Building building = buildingService.getDetail(id);
		if (building == null)
			throw new ResponseStatusException();
		model.addAttribute("buttonName", "Update");
		model.addAttribute("title", "Edit");
		model.addAttribute("building", building);
		return "building/add";
	}

	@RequestMapping(value = { "/edit/{id}" }, method = RequestMethod.POST)
	public String update(@PathVariable int id, @Valid @ModelAttribute Building building, BindingResult result,
			ModelMap model) {

		model.addAttribute("buttonName", "Update");
		model.addAttribute("title", "Edit");
		if (result.hasErrors()) {
			return "building/add";
		}
		buildingService.edit(building);
		return "building/detail";

	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	// @ResponseStatus(value = HttpStatus.NO_CONTENT)
	public @ResponseBody Response delete(@PathVariable int id, HttpServletRequest request) throws RuntimeException {
		buildingService.delete(id);
		Response response = new Response();
		response.setMessage("Record successfully deleted.");
		response.setSuccess(true);
		return response;
	}

}
