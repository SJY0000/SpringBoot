package com.myapp.pma.api.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.myapp.pma.dao.EmployeeRepository;
import com.myapp.pma.entities.Employee;
import com.myapp.pma.services.EmployeeService;

@RestController
@RequestMapping("/app-api/employees")
public class EmployeeApiController {
	
	@Autowired
	private EmployeeService empserv;
	
	@Autowired
	private EmployeeRepository empRepo;
	
//	@GetMapping
//	public Iterable<Employee> getEmployees() {
//		return empserv.findAll();
//	}
	
	// Paging 적용 직원리스트
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public Iterable<Employee> findpaginatedEmployees(@RequestParam(value = "page", defaultValue = "0") int page,
														@RequestParam(value = "size", defaultValue = "5") int size) {
		
		//page설정 객체를 사용하려면 PagingAndSortingRepository를 참조한다.
		Pageable pageable = PageRequest.of(page, size);
		
		return empRepo.findAll(pageable);
	}
	
	@GetMapping("/{id}")
	public Employee getEmployeeById(@PathVariable("id") Long id) {
		return empserv.findByEmployeeId(id);
	}
	
	// 요청하는 body에 json 타입의 새 직원 데이터를 입력시 새로 직원 생성하고 그 직원을 Return
	// http.csrf().disable(); 해줘야 post 가능
	@PostMapping(consumes = "application/json")
	@ResponseStatus(HttpStatus.CREATED) // 상태 201 생성
	public void create(@RequestBody Employee employee) {
		empserv.save(employee);
	}
	
	// 전체 업데이트(bean파일 당 입력할 수 있는 내용을 모두 입력을 해줘야 Update 가능함) http put 메소드
	@PutMapping(consumes = "application/json")
	@ResponseStatus(HttpStatus.OK) // http 상태 메소드
	public Employee update(@RequestBody @Valid Employee employee) {
		
		return empRepo.save(employee); // id 가 있으면 Update, id가 없으면 Create
	}
	
	// 부분 업데이트
	@PutMapping(path = "/{id}", consumes = "application/json")
	public Employee update(@PathVariable("id") Long id, @RequestBody Employee employee) {
		Employee emp = empserv.findByEmployeeId(id); // Update 전에 데이터를 가져옴
		
		// null 값이 아니라면 
		if (employee.getEmail() != null) {
			emp.setEmail(employee.getEmail());
		} 
		if (employee.getFirstName() != null) {
			emp.setFirstName(employee.getFirstName());
		}
		if (employee.getLastName() != null) {
			emp.setLastName(employee.getLastName());
		}
		
		return empRepo.save(emp);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") Long id) {
		try {
			empserv.deleteEmployee(id);
		} catch (EmptyResultDataAccessException e) {
			System.out.println("삭제되지 않음"); // DB삭제 시 예외 발생
			e.printStackTrace();
		}
	}
	 
}
