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
import com.myapp.pma.services.EmployeeService;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	/**
	 * 새 직원을 입력한다.
	 * @param model
	 * @return 새 직원 만드는 페이지
	 */
	@GetMapping("/new")
	public String displayPrjectForm(Model model) {
		Employee e = new Employee();
		
		model.addAttribute("employee", e);
		return "employees/new-employee";
	}
	/**
	 * 직원을 저장, 업데이트
	 * @param employee
	 * @return 직원 리스트 페이지
	 */
	@PostMapping("/save")
	public String createProject(@Valid Employee employee, Errors errors ) { // @Vailid Employee에 설정한 조건으로 유효성검사 실시, 유효성검사 실시 중 Error 발생시 Errors로 값이 넘어옴 
		// 유효성검사 실패하여 에러발생시 => 입력 페이지로 되돌아감
		if(errors.hasErrors()) return "employees/new-employee";
		
		Long id = employee.getEmployeeId(); // Long은 클래스 타입이라 null이 존재 할 수 있다.
		
		if(id != null) { // id가 있을 경우
			employeeService.update(employee); // 업데이트
		} else {
			employeeService.save(employee); // DB에 employee객체를 테이블에 새로저장		
		}
		return "redirect:/employees"; //post-redirect-get 패턴
	}
	/**
	 * 직원 리스트를 출력한다.
	 * @param model
	 * @return 직원 리스트 페이지
	 */
	@GetMapping
	public String displayEmployees(Model model) {
		List<Employee> employeeList = employeeService.findAll();
		model.addAttribute("employeeList", employeeList);
		
		return"employees/list-employees";
	}
	/**
	 * 새 직원 추가페이젱 업데이트 할 데이터를 보여준다
	 * @param id
	 * @param model
	 * @return 새 직원 만드는 페이지(데이터 입력)
	 */
	@GetMapping("/update")
	public String displayEmployeeUpdateForm(@RequestParam("id") long id, Model model) {
		// id로 DB에서 업데이트할 직원을 찾아서 화면(뷰)에 표시하기
		Employee employee = employeeService.findByEmployeeId(id); //DB에서 찾기
		model.addAttribute("employee", employee);
		return "employees/new-employee";
	}
	
	@GetMapping("/delete")
	public String deleteEmployee(@RequestParam("id") long id) {
		employeeService.deleteEmployee(id);
		return "redirect:/employees";
	}
}
