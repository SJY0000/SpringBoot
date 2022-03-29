package com.myapp.pma;

//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.annotation.Bean;
//
//import com.myapp.pma.dao.EmployeeRepository;
//import com.myapp.pma.dao.ProjectRepository;
//import com.myapp.pma.entities.Employee;
//import com.myapp.pma.entities.Project;

@SpringBootApplication
public class PmaApplication {
	
//	@Autowired
//	private EmployeeRepository empRepo;
//	
//	@Autowired
//	private ProjectRepository proRepo;
	
	public static void main(String[] args) {
		SpringApplication.run(PmaApplication.class, args);
	}

	// 프로그램 실행시 자동으로 DB에 입력하는 코드
//	@Bean
//	CommandLineRunner runner() {
//		return args -> {
//			// 프로그램 실행시 코드
//			Employee emp1 = new Employee("길동", "홍", "hong@gmail.com");
//			Employee emp2 = new Employee("라니", "고", "go@gmail.com");
//			Employee emp3 = new Employee("스티븐", "킹", "king@gmail.com");
//
//			Employee emp4 = new Employee("날두", "호", "ho@gmail.com");
//			Employee emp5 = new Employee("펭수", "김", "kim@gmail.com");
//			Employee emp6 = new Employee("피터", "팬", "pen@gmail.com");
//
//			Employee emp7 = new Employee("순신", "이", "lee@gmail.com");
//			Employee emp8 = new Employee("감찬", "강", "kang@gmail.com");
//			Employee emp9 = new Employee("유신", "김", "yousin@gmail.com");
//
//			
//			Project pro1 = new Project("대형 프로젝트", "시작전", "할일이 많음");
//			Project pro2 = new Project("새 직원 인사",  "완료", "필요한 부서의 새 직원 고용");
//			Project pro3 = new Project("오피스 리모델링", "진행중", "오래된 오피스 환경을 새것처럼 리모델링");
//			Project pro4 = new Project("회사 보안 강화", "진행중", "출 입문 인증 지문센서 추가");
//				
//			
//			// project 에 직원들을 추가하고 , employee 객체에 프로젝트들을 추가한다.
//			// project에 새 메서드 작성
//			pro1.addEmployee(emp1);
//			pro1.addEmployee(emp2);
//			pro2.addEmployee(emp3);
//			pro3.addEmployee(emp1);
//			pro4.addEmployee(emp1);
//			pro4.addEmployee(emp3);
//			
//			empRepo.save(emp1);
//			empRepo.save(emp2);
//			empRepo.save(emp3);
//			empRepo.save(emp4);
//			empRepo.save(emp5);
//			empRepo.save(emp6);
//			empRepo.save(emp7);
//			empRepo.save(emp8);
//			empRepo.save(emp9);
//			
//			proRepo.save(pro1);
//			proRepo.save(pro2);
//			proRepo.save(pro3);
//			proRepo.save(pro4);
//
//
//		};
//	}
}
