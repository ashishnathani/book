package com.ashish.book.common;


import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;


/**
 * The Class IsoTimeDeserilizer.
 */
@Component
public class CustomDateTimeDeserilizer extends JsonDeserializer<Date> {

	
	@Override
	public Date deserialize(final JsonParser jsonParser, final DeserializationContext deserializationContext)
			throws IOException {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String date = jsonParser.getText();
		try {
			return format.parse(date);
		} catch (ParseException e) {
			throw new RuntimeException(e);
		}
	}
}
