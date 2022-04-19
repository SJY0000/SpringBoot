package com.myapp.bbs.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.myapp.bbs.model.BoardVO;
import com.myapp.bbs.model.Criteria;

@Mapper
public interface BoardMapper {

	public void enroll(BoardVO board); // 게시판 글 등록
	
	public List<BoardVO> getList(); // 게시판 모든 글 불러오기
	
	// pageNum , amount를 입력받아 개체 cri생성, 없으면 기본 (1,10)입력
	public List<BoardVO> getListPaging(Criteria cri); // 게시판 모든 글 불러오기(페이징 적용)
	
	public BoardVO getPage(int bno); // 게시글 불러오기
	
	public int modify(BoardVO board); // 게시글 수정
	
	public int delete(int bno); // 게시글 삭제
	
	public int getTotal(); // 게시글 총 갯수
}
