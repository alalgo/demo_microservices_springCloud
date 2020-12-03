package org.alalgo.Authserver.service.impl;

import java.util.List;

import org.alalgo.Authserver.dos.OauthClientDetailsDo;
import org.alalgo.Authserver.mapper.OauthClientMapper;
import org.alalgo.Authserver.service.OauthClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class OauthClientServiceImpl implements OauthClientService {
	@Autowired
	private OauthClientMapper oauthClientMapper;
	@Override
	public List<OauthClientDetailsDo> getAll() {
		return oauthClientMapper.getAll();
	}

	@Override
	public void update(OauthClientDetailsDo oauthClientDetailsDo) {
		oauthClientMapper.update(oauthClientDetailsDo);
	}

}
