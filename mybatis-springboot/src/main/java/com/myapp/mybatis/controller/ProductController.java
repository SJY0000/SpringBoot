package com.myapp.mybatis.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.myapp.mybatis.mapper.ProductMapper;
import com.myapp.mybatis.model.Product;


@RestController // view 없이 바로 return
@RequestMapping("/products")
public class ProductController {

	
	private ProductMapper productMapper;
	
	// 생성자 주입(객체를 생성자 주입으로 입력시 @Autowired 필요없음)
	public ProductController(ProductMapper productMapper) {
		this.productMapper = productMapper;
	}
	
	@GetMapping("/{id}")
	public  Product getProduct(@PathVariable("id") Long prodId) {
		// mybatis는 repository 대신 매퍼를 만듬 
		Product product = productMapper.selectProductById(prodId);
				
		return product;
	}
	@GetMapping
	public List<Product> getproductList() {
		List<Product> products = productMapper.selectAllProducts();
		
		return products;
	}
	@PostMapping	// Parameter로 prodName, prodPrice가 들어와야 한다.
	public void createProduct(@RequestParam("prodName") String prodName, @RequestParam("prodPrice") int prodPrice) {

		productMapper.insertProduct(new Product(prodName, prodPrice));
	}
	
	@PutMapping("/{id}")
	public void updateProduct(@PathVariable("id") Long prodId ,@RequestParam("prodName") String prodName, @RequestParam("prodPrice") int prodPrice) {
		
		productMapper.updateProduct(new Product(prodId, prodName, prodPrice));
	}
	@DeleteMapping("/{id}")
	public void deleteProduct(@PathVariable("id") Long prodId) {
		productMapper.deleteProductById(prodId);
	}
}
