package com.myapp.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.myapp.mybatis.model.Product;

@Mapper
public interface ProductMapper {

	// 구현이 안된 추상메소드들을 연결된 mapper폴더의 ProductMapper.xml에서 작성한다.
	Product selectProductById(Long id); // id로 제품 하나 검색
	List<Product> selectAllProducts();	// 모든 제품 검색
	void insertProduct(Product product);	// 제품 생성
	void updateProduct(Product product);	// 제품 수정
	void deleteProductById(Long id);	// 제품 삭제
}
