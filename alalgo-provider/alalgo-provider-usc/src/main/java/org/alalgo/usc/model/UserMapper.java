package org.alalgo.usc.model;

import java.util.List;

import org.alalgo.usc.dos.UserDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.RowBounds;

@Mapper
public interface UserMapper {
	
	public List<UserDO> getUser(String username,RowBounds rowBounds);
	
   // @Update("update user set username=#{username},password=#{password},phoneNumber=#{phoneNumber},enable=#{enable} where userId=#{userId}")  	
    public void updateUser(UserDO userDO);
    
    public void insertUser(UserDO userDO);
}
