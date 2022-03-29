package com.myapp.pma.dto;

public interface EmployeeProject {
	// Spring이 자동으로 생성하게 Interface 사용
	// set은 필요없이 DB에서 쿼리 결과를 가져오기만 하면 됨
	public String getFirstName();
	public String getLastName();
	public String getCount(); 
}
