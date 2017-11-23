package com.fuck.mobile.spring.dubbo.kryo2;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.common.serialize.ObjectInput;
import com.alibaba.dubbo.common.serialize.ObjectOutput;
import com.alibaba.dubbo.common.serialize.OptimizedSerialization;

public class Kryo2Serialization implements OptimizedSerialization {

	public byte getContentTypeId() {
		return 10;
	}

	public String getContentType() {
		return "x-application/kryo2";
	}

	@Override
	public ObjectOutput serialize(URL url, OutputStream output) throws IOException {
		return new Kryo2ObjectOutput(output);
	}

	@Override
	public ObjectInput deserialize(URL url, InputStream input) throws IOException {
		return new Kryo2ObjectInput(input);
	}

}
