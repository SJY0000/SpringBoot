package com.myapp.bbs.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.myapp.bbs.model.User;

@Mapper
public interface UserMapper {

	@Insert("insert into player values(#{email}, #{password}, #{name})")
	public int insert(User user);
	
	@Update("update player set password = #{password} where email = #{email}")
	public int update(User user);
	
	@Delete("delete from player where email = #{email}")
	public int delete(String email);
	
	@Select("select * from player")
	public List<User> selectAll();
	
	@Select("select * from player where email = #{email}")
	public User selectByEmail(String email);
}
