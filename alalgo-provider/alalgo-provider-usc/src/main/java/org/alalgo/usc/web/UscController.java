package org.alalgo.usc.web;

import java.util.List;

import org.alalgo.usc.api.service.SecurityServiceApi;
import org.alalgo.usc.dos.PermissionDO;
import org.alalgo.usc.dos.RoleDO;
import org.alalgo.usc.dos.UserDO;
import org.alalgo.usc.service.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UscController {	
	@Autowired
	private SecurityService securityService;
	@Autowired
	private SecurityServiceApi securityServiceApi;
	
    @GetMapping("/alluser")
    public List<UserDO> getUsers(int page,int countPerPage) {
    	return securityService.getUser(null,page,countPerPage);
    }	
    @GetMapping("/user")
    public List<UserDO> getUser(String username) {
        //return securityService.getUser(username);
    	return securityService.getUser(username,0,0);
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
    
}

