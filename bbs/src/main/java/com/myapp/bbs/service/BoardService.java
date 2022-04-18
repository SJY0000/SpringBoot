package com.myapp.bbs.service;

import java.util.List;

import com.myapp.bbs.model.BoardVO;

public interface BoardService {

	public void enroll(BoardVO board); // 게시판 글 등록
	
	public List<BoardVO> getList(); // 게시판 모든 글 불러오기
	
	public BoardVO getPage(int bno); // 게시글 불러오기
	
	public int modify(BoardVO board); // 게시글 수정하기
	
	public int delete(int bno); // 게시글 삭제
}
