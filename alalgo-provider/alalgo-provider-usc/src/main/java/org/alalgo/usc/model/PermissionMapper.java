package org.alalgo.usc.model;

import java.util.List;

import org.alalgo.usc.dos.PermissionDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface PermissionMapper {
	
	@Select("select p.* from user u \r\n" + 
			"left join UserRole ur on u.userId = ur.userId \r\n" + 
			"left join role r on ur.roleid = r.roleid \r\n" + 
			"left join RolePermission rp on rp.roleid = r.roleid  \r\n" + 
			"left join Permission p on rp.permissionId = p.permissionId \r\n" + 
			"where u.userid = #{userId};")
	public List<PermissionDO> findPermissionByUserId(Integer userId);
}
