package com.ashokit.binding;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

public class CustomDateSerialzer extends StdSerializer<Date>{
	
	public CustomDateSerialzer() {
		this(null, false);		
	}
	
	protected CustomDateSerialzer(Class<?> t, boolean dummy) {
		super(t, dummy);
	}

	@Override
	public void serialize(Date value, JsonGenerator gen, SerializerProvider provider) throws IOException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
        gen.writeString(sdf.format(value));
	}

}
