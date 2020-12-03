package org.alalgo.gateway.conf.oauth2client;

//@Configuration
//@EnableOAuth2Client
public class Oauth2ClientConf {
/*
	  @Autowired
	  OAuth2ClientContext oauth2ClientContext;	
	  @Bean
		public FilterRegistrationBean<OAuth2ClientContextFilter> oauth2ClientFilterRegistration(OAuth2ClientContextFilter filter) {
			FilterRegistrationBean<OAuth2ClientContextFilter> registration = new FilterRegistrationBean<OAuth2ClientContextFilter>();
			registration.setFilter(filter);
			registration.setOrder(-100);
			return registration;
		}		  
	  
	  private Filter ssoFilter(Oauth2ClientResources client, String url) {
		  OAuth2ClientAuthenticationProcessingFilter filter = new OAuth2ClientAuthenticationProcessingFilter(url);
		  
		  OAuth2RestTemplate template = new OAuth2RestTemplate(client.getClient(), oauth2ClientContext);
		  filter.setRestTemplate(template);
		  
		  UserInfoTokenServices tokenServices = new UserInfoTokenServices(client.getResource().getUserInfoUri(), client.getClient().getClientId());
		  tokenServices.setRestTemplate(template);
		  filter.setTokenServices(tokenServices);
		  
		  return filter;
	  }
	  @Bean
		public  Filter ssoFilter() {
		  CompositeFilter filter = new CompositeFilter();
		  List<Filter> filters = new ArrayList<>();
		  filters.add(ssoFilter(local(),"/login/local"));
		  filters.add(ssoFilter(github(),"/login/github"));
		  filter.setFilters(filters);
		  return filter;
		}	  
	  @Bean
	  @ConfigurationProperties("local")
	  public Oauth2ClientResources local() {
	    return new Oauth2ClientResources();
	  }	

	  @Bean
	  @ConfigurationProperties("github")
	  public Oauth2ClientResources github() {
	    return new Oauth2ClientResources();
	  }	
	  */
}
