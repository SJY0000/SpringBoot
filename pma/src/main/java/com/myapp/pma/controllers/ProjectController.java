package com.myapp.pma.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	
	// 프로젝트 생성할 때 직원 선택을하면 "employees"라는 이름의 List<Employee> 타입의 데이터를 변수로 받음
	@PostMapping("/save")
	public String createProject(Project project, @RequestParam("employees") List<Long> ids) {
		projectService.save(project); // DB에 project객체를 테이블에 저장
//		
//		// Project 생성 html에서 올라온 직원 id 값들을 입력하여 직원리스트를 가져와 각각의 직원에ㅔ게 프로젝트를 입력
//		Iterable<Employee> selectEmployees =  employeeRepository.findAllById(ids);
//		for(Employee emp : selectEmployees) {
//			emp.setProject(project); // 각각의 직원 객체에 프로젝트 입력하고
//			employeeRepository.save(emp); // DB에 다시 저장
//		}
		return "redirect:/projects/new"; //post-redirect-get 패턴
	}
	
	@GetMapping("/")
	public String displayProjects(Model model) {
		List<Project> projectList = projectService.findAll();
		
		model.addAttribute(projectList);
		
		return"projects/list-projects";
	}
}
