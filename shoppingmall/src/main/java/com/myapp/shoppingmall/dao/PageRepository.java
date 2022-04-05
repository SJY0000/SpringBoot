package com.myapp.shoppingmall.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myapp.shoppingmall.entities.Page;

public interface PageRepository extends JpaRepository<Page, Integer> {
	// List<Page>로 리턴되는 findAll() 등 여러 메소드가 이미 생성되어 있음
}
