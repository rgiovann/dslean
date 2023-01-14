package com.devsuperior.dslearnbds.entities.config.exceptions;

import java.io.IOException;
import java.time.Instant;
import java.util.Arrays;
import java.util.Map;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

/**
 * Created by hardik on 03/11/17.
 * Since we added the annotation @JsonSerialize(using = CustomOauthExceptionSerializer.class) 
 * it means that for Serializing the Exception we will use Custom or our own class 
 * CustomOauthExceptionSerializer below the file containing our custom Serializing class.
 * 
 *                               === I*M*P*O*R*T*A*N*T  ===
 * Providing friendly error messages in production applications when it comes to authentication/authorization 
 * is in general bad practice from a security standpoint. These types of messages can benefit malicious actors, 
 * when trying out things so that they realize what they have done wrong and guide them in their hacking attempts.
 */

public class CustomOauthExceptionSerializer extends StdSerializer<CustomOauthException> {

	private static final long serialVersionUID = 1L;

	public CustomOauthExceptionSerializer() {
		super(CustomOauthException.class);
	}

	@Override
	public void serialize(CustomOauthException value, JsonGenerator jsonGenerator,
			SerializerProvider serializerProvider) throws IOException {
		Instant instant = Instant.now();
		String formattedInstant = instant.toString();
		jsonGenerator.writeStartObject();
		jsonGenerator.writeNumberField("HTTP status code", value.getHttpErrorCode());
        jsonGenerator.writeBooleanField("status", false);
		jsonGenerator.writeStringField("date", formattedInstant);
		jsonGenerator.writeObjectField("errors", Arrays.asList(value.getOAuth2ErrorCode(), value.getMessage()));
		if (value.getAdditionalInformation() != null) {
			for (Map.Entry<String, String> entry : value.getAdditionalInformation().entrySet()) {
				String key = entry.getKey();
				String add = entry.getValue();
				jsonGenerator.writeStringField(key, add);
			}
		}
		jsonGenerator.writeEndObject();
	}
}