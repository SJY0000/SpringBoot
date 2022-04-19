package com.myapp.bbs.model;

/**
 * 페이지 계산을 위한 클래스
 * 
 *
 */
public class Criteria {

	private int pageNum; // 현재 페이지
	
	private int amount; // 한 페이지당 보여질 게시글 수

	private int skip; // 스킵할 페이지 수 ((pageNum -1) * amount)
	
	public Criteria() { // 기본 생성자 -> 기본 세팅: pageNum = 1; amount = 10 
		this(1,10); // 전체 생성자를 통해 (1,10)을 입력해 객체 생성 -> Criteria(1,10)
	}
	
	public Criteria(int pageNum, int amount) {
		this.pageNum = pageNum;
		this.amount = amount;
		this.skip = (pageNum - 1) * amount;
	}

	public int getPageNum() {
		return pageNum;
	}

	// 새로 페이지 숫자를 설정 했을 때 skip도 같이 계산하여 입력
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
		this.skip = (pageNum - 1) * amount;
	}

	public int getAmount() {
		return amount;
	}

	// 페이지당 보여질 게시글 수를 새로 설정 했을 때 skip도 같이 계산하여 입력
	public void setAmount(int amount) {
		this.amount = amount;
		this.skip = (pageNum - 1) * amount;
	}

	public int getSkip() {
		return skip;
	}

	public void setSkip(int skip) {
		this.skip = skip;
	}

	@Override
	public String toString() {
		return "Criteria [pageNum=" + pageNum + ", amount=" + amount + ", skip=" + skip + "]";
	}
}
