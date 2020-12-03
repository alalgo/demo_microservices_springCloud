package org.alalgo.Authserver.web;

import java.security.Principal;
import java.util.List;

import org.alalgo.Authserver.dos.OauthClientDetailsDo;
import org.alalgo.Authserver.service.OauthClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
	@Autowired
	private OauthClientService oauthClientService;
	
    @GetMapping("/user")
    public Principal user(Principal user) {
        return user;
    }
    
    @GetMapping("/oauthclients")
    public List<OauthClientDetailsDo> getAllOauthClient(){
    	return oauthClientService.getAll();
    }
}
