package com.progg.controller;

 import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.progg.entity.Employee;
import com.progg.service.EmpService;
import org.springframework.ui.Model;

import jakarta.servlet.http.HttpSession;
import java.util.List;
@Controller
public class EmpController {
    
	@Autowired
	private EmpService service;
	
	
	
	@GetMapping("/")
	public String home(Model m) {
		List<Employee> emp=service.getAllEmp();
	    m.addAttribute("emp",emp);
		return "index";
	}
	
	@GetMapping("/addemp")
	public String addEmpForm() {
		return "add_emp";
	}
	
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable int id,Model m) {
		
		Employee e=service.getEmpById(id);
		m.addAttribute("emp",e);
		return "edit";
	}
	
	
	@PostMapping("/register")
	public String empRegister(@ModelAttribute Employee e,HttpSession session) {
        System.out.println(e);
		service.addEmp(e);
		session.setAttribute("msg","Employee Added Sucessfully..");
		return "redirect:/";
	}
	
	@PostMapping("/update")
	public String updateEmp(@ModelAttribute Employee e,HttpSession session) {
        System.out.println(e);
		service.addEmp(e);
		session.setAttribute("msg","Employee Data Update Sucessfully..");
		return "redirect:/";
	}
	@GetMapping("/delete/{id}")
	public String deleteEmp(@PathVariable int id,HttpSession session) {
		
		service.deleteEmp(id);
		session.setAttribute("msg","Employee Data Deleted Succeefully..");
		return "redirect:/";
	}
}
