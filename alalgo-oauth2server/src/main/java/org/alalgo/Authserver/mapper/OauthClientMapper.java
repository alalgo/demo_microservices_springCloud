package org.alalgo.Authserver.mapper;

import java.util.List;

import org.alalgo.Authserver.dos.OauthClientDetailsDo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
@Mapper
public interface OauthClientMapper {
	@Select("select * from oauth_client_details")
	public List<OauthClientDetailsDo> getAll();
	
	@Update("update oauth_client_details set access_token_validity=#{access_token_validity},"
			+ "additional_information=#{additional_information},authorities=#{authorities},"
			+ "authorized_grant_types=#{authorized_grant_types},autoapprove=#{autoapprove},"
			+ "client_secret=#{client_secret},refresh_token_validity=#{refresh_token_validity},"
			+ "resource_ids=#{resource_ids},scope=#{scope},web_server_redirect_uri=#{web_server_redirect_uri} "
			+ "where client_id = #{client_id}")
	public void update(OauthClientDetailsDo oauthClientDetailsDo);
}
