package com.kenrigtechservices.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kenrigtechservices.entity.Specialization;
import com.kenrigtechservices.service.ISpecializationService;

@Controller
@RequestMapping("/spec")
public class SpecializationController {
	@Autowired
	private ISpecializationService service;
	
	@GetMapping("/register")
	public String displayRegister() {
		return "SpecializationRegister";
	}
	@PostMapping("/save")
	public String saveForm(
			@ModelAttribute Specialization specialization,
			Model model
			) 
	{
		Integer id = service.saveSpecialization(specialization);
		String msg = "Record "+id+" is created";
		model.addAttribute("message",msg); 
		return "SpecializationRegister";
	}
	
	 @GetMapping("/all")
	 public String viewAll(
			 Model model,
			 @RequestParam(value="msg", required = false) String msg
			 ) {
		 List<Specialization> list = service.getAllSpecializations();
		 model.addAttribute("list",list);
		 model.addAttribute("msg", msg);
		 return "SpecializationData";
	 }
	 @GetMapping("/delete")
	 public String deletedata(
			 @RequestParam Integer id,
			 RedirectAttributes attributes
			 ) {
		 service.removeSpecialization(id);
		 attributes.addAttribute("msg", "Record "+ id +" is deleted");
		 return "redirect:all";
	 }
	 @GetMapping("/edit")
	 public String showEditPage(
			 @RequestParam Integer id,
			 Model model
			 ) {
		 Specialization spec = service.getOneSpecialization(id);
		 model.addAttribute("specialization",spec);
		 return "SpecializationEdit";
	 }
	 @PostMapping("/update")
	 public String updateData(
			 @ModelAttribute Specialization spec,
			 RedirectAttributes attr
			 ) {
		 service.updateSpecialization(spec);
		 attr.addAttribute("msg", "Record "+spec.getId()+" is updated");
		 return "redirect:all";
	 }
}
