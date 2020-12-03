package org.alalgo.usc.web;

import org.alalgo.usc.service.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RefreshScope
public class HelloController {
	@Autowired
	private SecurityService securityService;
	
	//@Value("${alalgo.hello}")
	private String conf_hello;
	
	@GetMapping
	public String getConf() {
		return conf_hello;
	}
	@GetMapping("/mybatis")
	public String mybatis()  {
		/*
		Reader reader = Resources.getResourceAsReader("resources/application.yml");
		SqlSessionFactory sql = new SqlSessionFactoryBuilder().build(reader);
		SqlSession session = sql.openSession();
		session.insert("add", null);
		session.commit();
		session.close();
		return "";
		*/
		return "";
	}
	@GetMapping("/transaction")
	public String testTransaction()  {
		securityService.updateAll();
		return "sucess.";
	}	
}
