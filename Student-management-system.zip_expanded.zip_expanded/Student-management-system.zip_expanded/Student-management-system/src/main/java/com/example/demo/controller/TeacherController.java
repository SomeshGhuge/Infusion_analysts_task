package com.example.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.Teacher;
import com.example.demo.service.TeacherServiceImpl;

@Controller
public class TeacherController {
	
	@Autowired
	public TeacherServiceImpl teachImpl;
	
	
@GetMapping("/teachers")
public String listTeacher(Model model) {
	model.addAttribute("teachers", teachImpl.getAllTeacher());
	return "teachers";
	}
@GetMapping("/teachers/new")
public String createTeacher(Model model) {
	Teacher teacher=new Teacher();
	model.addAttribute("teacher", teacher);
	return "create_teacher";
}
@PostMapping("/teachers")
public String saveTeacher(@ModelAttribute("teacher") Teacher teacher) {
	teachImpl.saveTeacher(teacher);
	return "redirect:/teachers";

}
@GetMapping("/teachers/edits/{id}")
public String editById(@PathVariable int id, Model model) {
	model.addAttribute("teacher", teachImpl.getTeacherById(id)); 
	return "edit_teacher";
}
@PostMapping("/teachers/{id}")
public String updateTeacher(@PathVariable int id, @ModelAttribute("teacher") Teacher teacher, Model model) {
	Teacher existteacher=teachImpl.getTeacherById(id);
	existteacher.setId(id);
	existteacher.setName(teacher.getName());
	existteacher.setUsername(teacher.getUsername());
	existteacher.setPassword(teacher.getPassword());
	teachImpl.updateTeacher(existteacher);
	return "redirect:/teachers";
}
@GetMapping("/teachers/{id}")
public String deleteTeacher(@PathVariable int id) {
	teachImpl.deleteTeacher(id);
	return"redirect:/teachers";
}


}
