package com.myapp.bbs.dao;

import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.test.annotation.Rollback;

import com.myapp.bbs.model.BoardVO;

@MybatisTest
@AutoConfigureTestDatabase(replace = Replace.NONE) // 실제 DB, 현재 연결되어있는 DB로 테스트
@Rollback(value = false)							// 테스트 할 때 rollback 하지않음(기본적으로 rollback 하도록 돼있음) 
public class BoardMapperTest {
	
	@Autowired
	private BoardMapper boardMapper;

	@Test
	public void Test() {
		BoardVO vo = new BoardVO();
		
		vo.setTitle("제목테스트");
		vo.setContent("내용테스트");
		vo.setWriter("테스터");
		
		boardMapper.enroll(vo);
	}
}
