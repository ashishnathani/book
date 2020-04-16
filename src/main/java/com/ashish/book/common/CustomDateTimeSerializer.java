package com.ashish.book.common;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import ch.qos.logback.core.CoreConstants;

/**
 * The type Custom date time serializer.
 */
@Component
public class CustomDateTimeSerializer extends JsonSerializer<Date> {

	/**
	 * serializes date time.
	 */
	@Override
	public void serialize(final Date date, final JsonGenerator generator, final SerializerProvider provider)
			throws IOException {

		final SimpleDateFormat dateTimeFormat = new SimpleDateFormat("yyyy-MM-dd");
		generator.writeString(dateTimeFormat.format(date));
	}
}
