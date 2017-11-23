package com.fuck.mobile.spring.dubbo.kryo2;

import java.io.IOException;
import java.io.OutputStream;

import com.alibaba.dubbo.common.serialize.Cleanable;
import com.alibaba.dubbo.common.serialize.ObjectOutput;
import com.alibaba.dubbo.common.serialize.support.kryo.KryoFactory;
import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Output;

public class Kryo2ObjectOutput implements ObjectOutput, Cleanable {

	private Kryo kryo = Kryo2Factory.getDefaultFactory().getKryo();
	private Output output;

	public Kryo2ObjectOutput(OutputStream outputStream) {
		output = new Output(outputStream);
	}

	public void writeBool(boolean v) throws IOException {
		output.writeBoolean(v);
	}

	public void writeByte(byte v) throws IOException {
		output.writeByte(v);
	}

	public void writeShort(short v) throws IOException {
		output.writeShort(v);
	}

	public void writeInt(int v) throws IOException {
		output.writeInt(v);
	}

	public void writeLong(long v) throws IOException {
		output.writeLong(v);
	}

	public void writeFloat(float v) throws IOException {
		output.writeFloat(v);
	}

	public void writeDouble(double v) throws IOException {
		output.writeDouble(v);
	}

	public void writeBytes(byte[] v) throws IOException {
		if (v == null) {
			output.writeInt(-1);
		} else {
			writeBytes(v, 0, v.length);
		}
	}

	public void writeBytes(byte[] v, int off, int len) throws IOException {
		if (v == null) {
			output.writeInt(-1);
		} else {
			output.writeInt(len);
			output.write(v, off, len);
		}
	}

	public void writeUTF(String v) throws IOException {
		// TODO
		output.writeString(v);
		// kryo.writeObject(output, v);
	}

	public void writeObject(Object v) throws IOException {
		kryo.writeClassAndObject(output, v);
	}

	public void flushBuffer() throws IOException {
		output.flush();
	}

	public void cleanup() {
		Kryo2Factory.getDefaultFactory().returnKryo(kryo);
		kryo = null;
	}
}
