package com.myapp.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.myapp.mybatis.model.User;

@Mapper // jpa의 repository와 같음
public interface UserMapper {

	@Select("select * from user where id = #{id}") // #{매개변수}, 메소드에 설정한 매개변수가 여기 들어감
	User getUser(String id); // id로 DB user테이블에서 찾아 User객체 Return

	@Select("select * from user")
	List<User> getUserList();

	@Insert("insert into user values (#{id}, #{name}, #{phone}, #{address})")
	void insertUser(String id, String name, String phone, String address);
	
	@Update("update user set name=#{name}, phone=#{phone}, address=#{address} where id=#{id}")
	int updateUser(String id, String name, String phone, String address);

	@Delete("delete from user where id=#{id}")
	void deleteUser(String id);
}
