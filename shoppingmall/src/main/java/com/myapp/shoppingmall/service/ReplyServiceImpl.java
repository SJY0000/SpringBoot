package com.myapp.shoppingmall.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myapp.shoppingmall.dao.ReplyMapper;
import com.myapp.shoppingmall.entities.ReplyVO;

@Service
public class ReplyServiceImpl implements ReplyService{

	@Autowired
	private ReplyMapper replyMapper;
	
	@Override
	public void enroll(ReplyVO reply) {
		replyMapper.enroll(reply);
	}

	@Override
	public List<ReplyVO> getReplyList(int reply_bno) {	
		return replyMapper.getReplyList(reply_bno);
	}

	@Override
	public int modify(ReplyVO reply) {
		return replyMapper.modify(reply);
	}

	@Override
	public int delete(int reply_no) {
		return replyMapper.delete(reply_no);
	}

}
