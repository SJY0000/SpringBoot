package com.myapp.pma.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.myapp.pma.dto.EmployeeProject;
import com.myapp.pma.entities.Employee;

public interface EmployeeRepository extends PagingAndSortingRepository<Employee, Long>{
	// 자동으로 CRUD 객체 생성
	List<Employee> findAll();
	
	// 쿼리문을 실행하여 결과를 List로 Return함(dto의 EmployeeProject객체)
	@Query(nativeQuery = true, value =
			"SELECT LAST_NAME AS lastName ,FIRST_NAME AS firstName, COUNT(PROJECT_ID) AS count "
			+ "FROM EMPLOYEE e LEFT JOIN PROJECT_EMPLOYEE pe  ON e.EMPLOYEE_ID = pe.EMPLOYEE_ID "
			+ "GROUP BY e.EMPLOYEE_ID "
			+ "ORDER BY count  desc ")
	public List<EmployeeProject> employeeProjects();
	
	//새로 만든 쿼리문 id 입력해서 직원찾기
	Employee findByEmployeeId(Long id);
}
