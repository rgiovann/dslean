package com.devsuperior.dslearnbds.entities.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenEnhancerChain;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

import com.devsuperior.dslearnbds.components.JwtTokenEnhancer;


@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

	@Value("${security.oauth2.client.client-id}")
	private String clientId;
	
	@Value("${security.oauth2.client.client-secret}")
	private String clientSecret;
	
	@Value("${jwt.duration}")
	private Integer jwtDuration;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	private UserDetailsService userDetailsService;

// ****	
// not needed anymore, used to debug internal InternalAuthorizationServiceException (missing @Autowired)
// ****		
//	@Autowired
//	private WebResponseExceptionTranslator<OAuth2Exception> webResponseExceptionTranslator;
	
	@Autowired
	private JwtAccessTokenConverter accessTokenConverter;
	
	@Autowired
	private JwtTokenStore tokenStore;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private JwtTokenEnhancer tokenEnhancer;
	
	@Override
	public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
		security.tokenKeyAccess("permitAll()").checkTokenAccess("isAuthenticated()");
	}

	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		clients.inMemory()
		.withClient(clientId)
		.secret(passwordEncoder.encode(clientSecret))
		.scopes("read", "write")
		.authorizedGrantTypes("password","refresh_token")
		.accessTokenValiditySeconds(jwtDuration)
		.refreshTokenValiditySeconds(jwtDuration);
	}

	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {

/*                                === I*M*P*O*R*T*A*N*T  ===
 * Providing friendly error messages in production applications when it comes to authentication/authorization 
 * is in general bad practice from a security standpoint. These types of messages can benefit malicious actors, 
 * when trying out things so that they realize what they have done wrong and guide them in their hacking attempts.
 */
		
// Integrate our CustomOauthException in the OAuth2config
//		endpoints.exceptionTranslator(exception -> {
//            if (exception instanceof OAuth2Exception) {
//                OAuth2Exception oAuth2Exception = (OAuth2Exception) exception;
//                return ResponseEntity
//                        .status(oAuth2Exception.getHttpErrorCode())
//                        .body(new CustomOauthException(oAuth2Exception.getMessage()));
//            } else {
//                throw exception;
//            }
//        });
		
		TokenEnhancerChain chain = new TokenEnhancerChain();
		chain.setTokenEnhancers(Arrays.asList(accessTokenConverter, tokenEnhancer));
		
		// .pathMapping("/oauth/token", "<your custom endpoint>") change authentication route to a customized route
		
		endpoints.authenticationManager(authenticationManager)
		.tokenStore(tokenStore)
		.accessTokenConverter(accessTokenConverter)
		.tokenEnhancer(chain)
		.userDetailsService(userDetailsService);
		


		// ****	
		// not needed anymore, used to debug internal InternalAuthorizationServiceException (missing @Autowired)
		// ****	
        //.exceptionTranslator(webResponseExceptionTranslator);
	}
}
