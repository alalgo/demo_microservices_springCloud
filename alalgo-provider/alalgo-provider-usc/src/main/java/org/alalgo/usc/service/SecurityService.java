package org.alalgo.usc.service;

import java.util.List;

import org.alalgo.usc.dos.Menu;
import org.alalgo.usc.dos.PermissionDO;
import org.alalgo.usc.dos.RoleDO;
import org.alalgo.usc.dos.UserDO;

public interface SecurityService {
	public List<UserDO> getUser(String username,int page,int countPerPage);
	public UserDO getUserByName(String username);
	public List<RoleDO> getRoleByUserId(Integer userId);
	public List<PermissionDO> getPermissionByUserId(Integer userId);
	
	public  void updateUser(UserDO userDO);
	public void insertUser(UserDO userDO) ;
	public List<Menu> getAllMenu();
	/**
	 * 测试spring 事务特性
	 *  
	 * @date: 2020年12月3日
	 * @author: security
	 */
	public void updateAll();
}
