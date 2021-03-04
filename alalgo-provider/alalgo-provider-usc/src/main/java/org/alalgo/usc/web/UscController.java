package org.alalgo.usc.web;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.alalgo.usc.api.service.SecurityServiceApi;
import org.alalgo.usc.dos.PermissionDO;
import org.alalgo.usc.dos.RoleDO;
import org.alalgo.usc.dos.UserDO;
import org.alalgo.usc.service.SecurityService;
import org.alalgo.usc.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@RestController
public class UscController {	
	@Autowired
	private SecurityService securityService;
	@Autowired
	private SecurityServiceApi securityServiceApi;
	
    @GetMapping("/alluser")
    public List<UserDO> getUsers(int page,int countPerPage) {
    	return securityService.getAllUser(page,countPerPage);
    }	
    @GetMapping("/user")
    public UserDO getUser(int userId) {
        //return securityService.getUser(username);
    	return securityService.getUserById(userId);
    }
    @GetMapping("/updateuser")
    public String updateuser() {
    	UserDO userDO = new UserDO();
    	userDO.setUserId(123);
    	userDO.setUsername("caocao");
    	userDO.setPassword(new BCryptPasswordEncoder().encode("123456"));
    	securityService.updateUser(userDO);
    	return "success!";
    }       
    
    @GetMapping("/role")
    public List<RoleDO> getRoleByUserId(Integer userId) {
    	AnnotationConfigApplicationContext a;
        return securityService.getRoleByUserId(userId);
    }
    
    @GetMapping("/permission")
    public List<PermissionDO> getPermissionByUserId(Integer userId) {
        return securityService.getPermissionByUserId(userId);
    }
    //====== test rabbitmq
    @PostMapping("/regist")
    public ResultVO regist(UserDO userDO) {
    	userDO.setPassword(new BCryptPasswordEncoder().encode(userDO.getPassword()));
    	userDO.setCreateTime(new Date());
    	//userDO.setEnable(true);
    	securityService.insertUser(userDO);    	
    	return ResultVO.ok("注册成功");
    }  
    
    //======= test redis spring session
    @GetMapping("/login")
    public ResultVO login(int userId,String password,HttpSession session) {
    	UserDO userDO = securityService.getUserById(userId);
    	if(userDO == null) {
    		return ResultVO.error("用户不存在");
    	}
    	session.setAttribute("user", userDO);
    	return ResultVO.ok();
    }
    @GetMapping("/view")
    public ResultVO operatorAfterLogin(HttpSession session) {
    	UserDO userDO = (UserDO) session.getAttribute("user");
    	log.debug("session " + userDO);
    	if(userDO == null)
    		return ResultVO.error("no login.");
    	return ResultVO.ok();
    }
}

