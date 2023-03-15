package com.example.demo.controller;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.Login;
import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;
import com.example.demo.service.StudentServiceImpl;

@Controller
//@RequestMapping("/home")
public class StudentController {
	@Autowired
	public StudentServiceImpl stuImpl;
	@Autowired
	public StudentRepository repo;
	
	
	
	@GetMapping ("/students")
	public String listStudent (Model model) {
		model.addAttribute("students", stuImpl.getAllStudent());
		System.out.println(stuImpl.getAllStudent());
		return "students";
		
	}
	@GetMapping("/students/new")
	public String createNewStudent(Model model) {
		Student student=new Student();
		model.addAttribute("student", student);
		return "create_student";
	}
	@PostMapping("/students")
	public String saveStudent(@ModelAttribute("student") Student student) {
		stuImpl.saveStudent(student);
		return "redirect:/students";
	}
	
	
	@GetMapping("/students/edits/{id}")
	public String editById(@PathVariable int id, Model model) {
		model.addAttribute("student", stuImpl.getStudentById(id));
		return "edit_student";
	}
	@PostMapping("/students/{id}")
	public String upadateStudent(@PathVariable int id, @ModelAttribute("student") Student student,Model model){
		Student exitsStudent=stuImpl.getStudentById(id);
		exitsStudent.setId(id);
		exitsStudent.setFirstname(student.getFirstname());
		exitsStudent.setLastname(student.getLastname());
		exitsStudent.setEmail(student.getEmail());
		exitsStudent.setSeatNo(student.getSeatNo());
		exitsStudent.setDob(student.getDob());
		stuImpl.updateStudent(exitsStudent);
	return "redirect:/students";
		
	}
	@GetMapping("/students/{id}")
	public String deletStudent (@PathVariable int id) {
		stuImpl.deleteStuentById(id);
		return "redirect:/students";
	}
	@GetMapping("/student/login")
	public String studentLogin() {
		return "student_login";
	}
	@GetMapping("/student")
	public ModelAndView login() {
		ModelAndView mav=new ModelAndView("student");
		mav.addObject("student",new Student());
		return  mav ; 
	}
	@PostMapping("/singlerecord")
	public String login(@ModelAttribute("student") Student student, int seatNo, Model model) {
	Student stud=stuImpl.student(student.getSeatNo(), student.getDob());
	Student student1= stuImpl.getBySeatNo(seatNo);
	if(Objects.nonNull(stud)) {
		
		model.addAttribute("student1", student1);
		System.out.println(student1);
		System.out.print("in if............................................");
		return "singlerecord" ;
		
	}
	else {
		System.out.print("in else");
		return "redirect:/student/login";
	}
	
	}
	/*@GetMapping("/singlerecord/{seatNo}")
	public String getStudent(@PathVariable("seatNo") int seatNo) {
		//Student student1=stuImpl.;
		System.out.println("hi......................");
		Student student= stuImpl.getBySeatNo(seatNo);
		
		return "new";
	}*/
	@GetMapping("/new")
	public String new1() {
		return "new";
	}

}