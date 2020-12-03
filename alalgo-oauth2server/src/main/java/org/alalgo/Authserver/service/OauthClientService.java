package org.alalgo.Authserver.service;

import java.util.List;

import org.alalgo.Authserver.dos.OauthClientDetailsDo;

public interface OauthClientService {
	public List<OauthClientDetailsDo> getAll();
	public void update(OauthClientDetailsDo oauthClientDetailsDo);
}
