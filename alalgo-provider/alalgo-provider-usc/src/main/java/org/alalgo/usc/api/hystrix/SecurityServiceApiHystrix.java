package org.alalgo.usc.api.hystrix;

import java.util.List;

import org.alalgo.usc.api.service.SecurityServiceApi;
import org.alalgo.usc.dos.PermissionDO;
import org.alalgo.usc.dos.RoleDO;
import org.alalgo.usc.dos.UserDO;
import org.springframework.stereotype.Component;
@Component
public class SecurityServiceApiHystrix implements SecurityServiceApi {

	public SecurityServiceApiHystrix() {
	}

	@Override
	public UserDO getUser(String username) {
		UserDO userDO = new UserDO();
		userDO.setUsername(username);
		return userDO;
	}

	@Override
	public List<RoleDO> getRoleByUserId(Integer userId) {
		return null;
	}

	@Override
	public List<PermissionDO> getPermissionByUserId(Integer userId) {
		return null;
	}

}
