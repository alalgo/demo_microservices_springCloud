package org.alalgo.usc.api.service;

import java.util.List;

import org.alalgo.usc.api.hystrix.SecurityServiceApiHystrix;
import org.alalgo.usc.dos.PermissionDO;
import org.alalgo.usc.dos.RoleDO;
import org.alalgo.usc.dos.UserDO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
@Component
@FeignClient(value = "usc",fallback = SecurityServiceApiHystrix.class)
public interface SecurityServiceApi {
	@GetMapping("/getUser")
	public UserDO getUser(String username);
	@GetMapping("/getRoleByUserId")
	public List<RoleDO> getRoleByUserId(Integer userId);
	@GetMapping("/getPermissionByUserId")
	public List<PermissionDO> getPermissionByUserId(Integer userId);
}
