package org.alalgo.usc.web;

import org.alalgo.usc.service.SecurityService;
import org.alalgo.usc.vo.IndexVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@Api(tags = "首页需要的接口")
public class IndexController {
	@Autowired
	private SecurityService securityService;
	
	@ApiOperation(value = "获取完整菜单列表")
	@GetMapping("/index")
	public @ApiParam("菜单列表") IndexVO indexInfo() {
		IndexVO indexVO = new IndexVO();
		indexVO.setMenus(securityService.getAllMenu());
		return indexVO;
	}
}
