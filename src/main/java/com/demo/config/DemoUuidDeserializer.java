package com.demo.config;

import java.io.IOException;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.demo.constant.PatronUUID;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class DemoUuidDeserializer extends JsonDeserializer<UUID> {

	@Override
	public UUID deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
		String dateAsString = "";
		try {

			dateAsString = p.getText();
			Pattern pat = Pattern.compile(PatronUUID.UUID_PATTERN);
			Matcher mat = pat.matcher(dateAsString);
			if (mat.find()) {
				return UUID.fromString(dateAsString);
			} else {
				throw new Error("El valor no cumple con la especificación UUID.");
			}
	

		} catch (Exception e) {
			throw new Error("No se puedo deserializar el valor :" + dateAsString);
		}
	}

}
