package com.myapp.pma.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
//import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Employee {
	@Id // 기본키 명시
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 자동생성(auto-increment), db 테이블 별로
	private Long employeeId;
	
	@NotBlank(message = "이름을 입력해 주세요.")	// 공백 또는 null 일때 출력
	@Size(min = 1, max = 20, message = "이름은 최대 20글자까지 입력할 수 있습니다.") // min ~ max 값을 벗어났을 때 메시지 출력
	private String firstName;
	
	@NotBlank(message = "성을 입력해 주세요.")	// 공백 또는 null 일때 출력
	@Size(min = 1, max = 2, message = "성은 최대 2글자까지 입력할 수 있습니다.") // min ~ max 값을 벗어났을 때 메시지 출력
	private String lastName;
	
	@NotBlank(message = "이메일을 입력해주세요.")
	@Email(message = "이메일이 올바르지 않습니다.")
	private String email;
	
//	@ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE,
//							CascadeType.PERSIST, CascadeType.REFRESH},
//				fetch = FetchType.LAZY)
	@ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE,
			 CascadeType.REFRESH},
				fetch = FetchType.LAZY)// n : 1 관계, 여러명의 직원 : 하나의 프로젝트
	// Cascade는 수정, 삭제 시 연관데이터 조작여부체크, Fetch는 lazy일 때 연관 테이블 데이터를 천천히
//	@JoinColumn(name = "project_id") // 테이블에 "project_id" column 넣기, 외래키 열
//	private Project project;
	@JoinTable(name = "project_employee", joinColumns = @JoinColumn(name = "employee_id"),
				inverseJoinColumns = @JoinColumn(name = "project_id"))
	// n : n 관계에서는 테이블을 만들고 생성한 테이블에 id를 넣고 다른 테이블의 id도 입력
	@JsonIgnore
	private List<Project> projects;
	
	
	// 빈 생성자객체 생성
	public Employee() {}

	// id 제외한 생성자객체 생성
	public Employee(String firstName, String lastName, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

//	public Project getProject() {
//		return project;
//	}
//
//	public void setProject(Project project) {
//		this.project = project;
//	}

	
	public List<Project> getProjects() {
		return projects;
	}
	
	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}
	
	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
