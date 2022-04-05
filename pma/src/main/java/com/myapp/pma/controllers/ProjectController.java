package com.myapp.pma.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.myapp.pma.entities.Employee;
import com.myapp.pma.entities.Project;
import com.myapp.pma.services.EmployeeService;
import com.myapp.pma.services.ProjectService;

@Controller
@RequestMapping("/projects")
public class ProjectController {
	// Spring에서 repository객체를 처음에 자동생성해서 가지고 있다가
	// Autowired는 관련 객체를 필요할 때 자동으로 연결해준다.
	@Autowired
	private ProjectService projectService;

	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/new")
	public String displayPrjectForm(Model model) {
		Project p = new Project();
		
		model.addAttribute("project", p);
		
		List<Employee> empList = employeeService.findAll();
		
		model.addAttribute("empList", empList);
		
		return "projects/new-project";
	}
	

	@PostMapping("/save")
	public String createProject(@Valid Project project, Errors errors, Model model) {
		if (errors.hasErrors()) {
			// 유효성 검사를 할 객체인 project의 정보는 유지되어 넘어오지만 직원정보는 넘어오지 않기 때문에 유효성검사 에러 발생시 직원정보를 넘겨줘야함
			List<Employee> empList = employeeService.findAll();
			
			model.addAttribute("empList", empList);
			
			return "projects/new-project";
		}
		
		Long id = project.getProjectId();
		
		if(id != null) {
			projectService.update(project);
		} else {
			projectService.save(project);
		}
		
		return "redirect:/projects"; //post-redirect-get 패턴
	}
	
	@GetMapping
	public String displayProjects(Model model) {
		List<Project> projectList = projectService.findAll();
		
		model.addAttribute(projectList);
		
		return"projects/list-projects";
	}
	
	@GetMapping("/update")
	public String updateProjects(@RequestParam("id") long id, Model model) {
		Project project = projectService.findByProjectId(id);
		
		model.addAttribute("project", project);
		
		List<Employee> empList = employeeService.findAll();
		
		model.addAttribute("empList", empList);
		return "projects/new-project";
	}
	
	@GetMapping("/delete")
	public String deleteProjects(@RequestParam("id") long id) {
		projectService.delete(id);
		return "redirect:/projects";
		
	}
}
