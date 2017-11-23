package com.fuck.mobile.spring.dubbo.kryo2;

import static com.esotericsoftware.kryo.Kryo.NULL;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.LogFactory;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.Serializer;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import com.esotericsoftware.minlog.Log;

public class EnumSerializerEx extends Serializer<Enum> {	
	{
		setImmutable(true);
		setAcceptsNull(true);
	}

	static org.apache.commons.logging.Log log = LogFactory.getLog(EnumSerializerEx.class);
	
	private Enum[] enumConstants;

	public EnumSerializerEx (Class<? extends Enum> type) {
		enumConstants = type.getEnumConstants();
		if (enumConstants == null) throw new IllegalArgumentException("The type must be an enum: " + type);
	}

	public void write (Kryo kryo, Output output, Enum object) {
		if (object == null) {
			output.writeVarInt(NULL, true);
			return;
		}
		output.writeVarInt(1, true);
		output.writeString(object.name());
	}

	public Enum read (Kryo kryo, Input input, Class<Enum> type) {
		int ordinal = input.readVarInt(true);
		if (ordinal == NULL) return null;
		if(ordinal != 1)
		{
			 throw new IllegalArgumentException("Object data error -> " + ordinal);
		}
		
		String name = input.readString();
		for(Enum e : enumConstants)
		{
			if(StringUtils.equals(e.name(), name))
			{
				return e;
			}
		}
		log.error("can not found Enum named " + name);
		return null;
	}
	
	


}
