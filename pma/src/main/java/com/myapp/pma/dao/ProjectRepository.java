package com.myapp.pma.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.myapp.pma.entities.Project;

// JPA 에서는 repostiory에 CRUD 가능한 인터페이스 crudRepository를 상속
public interface ProjectRepository extends CrudRepository<Project, Long> {
	// crudRepository에 이미 CRUD 코드가 다 만들어져 있어서 사용만 하면 됨. => JPA Hibernate가 구현코드도 다 자동생성
	@Override
	List<Project> findAll(); // 기존의 findAll() return 타입이 Itreable<Project>에서 변경
}
