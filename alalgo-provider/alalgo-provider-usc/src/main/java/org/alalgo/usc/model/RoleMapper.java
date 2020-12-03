package org.alalgo.usc.model;

import java.util.List;

import org.alalgo.usc.dos.RoleDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface RoleMapper {
	
	@Select("select r.* from user u left join UserRole ur on u.userId = ur.userId left join role r on ur.roleid = r.roleid where u.userid = #{userId}")
	public List<RoleDO> findRoleByUserId(Integer userId);
}
