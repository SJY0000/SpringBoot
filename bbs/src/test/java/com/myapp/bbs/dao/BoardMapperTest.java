package com.myapp.bbs.dao;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.test.annotation.Rollback;

import com.myapp.bbs.model.BoardVO;
import com.myapp.bbs.model.Criteria;

import lombok.extern.java.Log;

@MybatisTest
@AutoConfigureTestDatabase(replace = Replace.NONE) // 실제 DB, 현재 연결되어있는 DB로 테스트
@Rollback(value = false)							// 테스트 할 때 rollback 하지않음(false)(기본적으로 rollback 하도록 돼있음(true)) 
@Log
public class BoardMapperTest {
	
	@Autowired
	private BoardMapper boardMapper;

	@Test
	public void Test() {
//		// 게시글 입력하기 테스트
//		BoardVO vo = new BoardVO();
//		
//		vo.setTitle("제목테스트");
//		vo.setContent("내용테스트");
//		vo.setWriter("테스터");
//		
//		boardMapper.enroll(vo);
//		
//		// 모든 게시글 불러오기 테스트
//		List<BoardVO> list = boardMapper.getList();
//		
//		for(BoardVO a : list) {
//			log.info("" + a); // "" 있어야 문자열로 인식해서 info메소드를 사용할 수 있음
//		}
//		
//		for(int i = 0 ; i < list.size() ; i++) {
//			log.info("" + list.get(i));
//		}
//		
//		list.forEach(board -> log.info("" + board));
		
//		// 게시글 불러오기 테스트 
//		int bno = 2;
//		
//		log.info("" + boardMapper.getPage(bno));
		
//		// 게시글 수정하기 테스트
//		BoardVO board = new BoardVO();
//		
//		board.setBno(1);
//		board.setTitle("수정된 제목");
//		board.setContent("수정된 내용");
//		
//		int result = boardMapper.modify(board);
//		
//		log.info("결과 : " + result);		// 1로 나오면 성공
		
//		// 게시글 삭제하기 테스트
//		int result = boardMapper.delete(9);
//		log.info("" + result);
		
//		// 페이징 
//		Criteria cri = new Criteria(); // 기본 생성자 생성 (1,10)(pageNum, amount)
//		cri.setPageNum(2);
//		cri.setAmount(5);
//		List<BoardVO> list = boardMapper.getListPaging(cri);
//		
//		list.forEach(board -> log.info("" + board));
		
//		// 총 게시글 갯수
//		int result = boardMapper.getTotal();
//		log.info("" + result);
		
	}
}
