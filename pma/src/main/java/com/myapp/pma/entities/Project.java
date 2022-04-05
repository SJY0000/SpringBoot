package com.myapp.pma.entities;

import java.util.ArrayList;
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
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
//import javax.persistence.OneToMany;

@Entity // DB의 테이블과 연결될 클래스
public class Project {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long projectId; // 프로젝트 아이디 (CamelCase => DB project_id), 기본키(auto increment)
	
	@NotBlank(message = "프로젝트명을 입력해주세요.")
	@Size(min = 4, message = "최소 4글자 이상 입력해주세요")
	private String name; // 프로젝트 이름
	
	private String stage; // 프로젝트 상태 (시작전, 진행중, 완료)
	
	@NotBlank(message = "프로젝트 설명을 적어주세요.")
	private String description; // 설명

//	@OneToMany(mappedBy = "project") // 1 : n의 관계, 상호연관관계일 때 사용, ManyToOne의 변수명, Project 테이블에 맵핑
	@ManyToMany(cascade = { CascadeType.DETACH, CascadeType.MERGE,
			CascadeType.REFRESH }, fetch = FetchType.LAZY) // n : 1 관계, 여러명의 직원 : 하나의 프로젝트
														// Cascade는 수정, 삭제 시 연관데이터 조작여부체크, Fetch는 lazy일 때 연관 테이블 데이터를 천천히
	@JoinTable(name = "project_employee", joinColumns = @JoinColumn(name = "project_id"), 
				inverseJoinColumns = @JoinColumn(name = "employee_id"))
	// n : n 관계에서는 테이블을 만들고 생성한 테이블에 id를 넣고 다른 테이블의 id도 입력
	private List<Employee> employees;
 
	public Project() {
	}

	// id는 DB 자동생성으로 할 것이므로 빼기
	public Project(String name, String stage, String description) {
		super();
		this.name = name;
		this.stage = stage;
		this.description = description;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public Long getProjectId() {
		return projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStage() {
		return stage;
	}

	public void setStage(String stage) {
		this.stage = stage;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	// 프로젝트 객체에서 직원을 추가하는 메소드
	public void addEmployee(Employee emp) {
		if (employees == null) {
			employees = new ArrayList<>();
		}
		employees.add(emp);
	}

}
