package org.alalgo.Authserver.dos;

import lombok.Data;

@Data
public class OauthClientDetailsDo {
	private int access_token_validity  ;
	private String additional_information ;
	private String authorities            ;
	private String authorized_grant_types ;
	private String autoapprove            ;
	private String client_id              ;
	private String client_secret          ;
	private int refresh_token_validity ;
	private String resource_ids           ;
	private String scope                  ;
	private String web_server_redirect_uri;
}
