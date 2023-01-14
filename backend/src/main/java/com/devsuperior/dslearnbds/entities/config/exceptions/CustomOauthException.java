package com.devsuperior.dslearnbds.entities.config.exceptions;

import org.springframework.security.oauth2.common.exceptions.OAuth2Exception;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * Created by Hardik on 03/11/17.
 * Create Class which extend OAuth2Exception
 * 
 *                               === I*M*P*O*R*T*A*N*T  ===
 * Providing friendly error messages in production applications when it comes to authentication/authorization 
 * is in general bad practice from a security standpoint. These types of messages can benefit malicious actors, 
 * when trying out things so that they realize what they have done wrong and guide them in their hacking attempts.
 */
 
@JsonSerialize(using = CustomOauthExceptionSerializer.class)
public class CustomOauthException extends OAuth2Exception {
  
	private static final long serialVersionUID = 1L;

	public CustomOauthException(String msg) {
        super(msg);
    }
}