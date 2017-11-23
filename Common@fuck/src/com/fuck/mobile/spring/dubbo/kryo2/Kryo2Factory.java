package com.fuck.mobile.spring.dubbo.kryo2;

import java.lang.reflect.InvocationHandler;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.TreeSet;
import java.util.UUID;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Pattern;

import com.alibaba.dubbo.common.serialize.support.SerializableClassRegistry;
import com.alibaba.dubbo.common.serialize.support.kryo.KryoFactory;
import com.alibaba.dubbo.common.serialize.support.kryo.PooledKryoFactory;
import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.serializers.CompatibleFieldSerializer;
import com.esotericsoftware.kryo.serializers.DefaultSerializers;
import com.esotericsoftware.kryo.serializers.DefaultSerializers.DateSerializer;

import de.javakaffee.kryoserializers.ArraysAsListSerializer;
import de.javakaffee.kryoserializers.BitSetSerializer;
import de.javakaffee.kryoserializers.GregorianCalendarSerializer;
import de.javakaffee.kryoserializers.JdkProxySerializer;
import de.javakaffee.kryoserializers.RegexSerializer;
import de.javakaffee.kryoserializers.SynchronizedCollectionsSerializer;
import de.javakaffee.kryoserializers.URISerializer;
import de.javakaffee.kryoserializers.UUIDSerializer;
import de.javakaffee.kryoserializers.UnmodifiableCollectionsSerializer;

public class Kryo2Factory {

	private static ClassLoader cl = Kryo2Factory.class.getClassLoader();
	private static final KryoFactory factory = new PooledKryoFactory() {
		@Override
		protected Kryo createKryo() {
			Kryo kryo = new CompatibleKryoEx();
			// TODO
			// kryo.setReferences(false);
			kryo.setRegistrationRequired(false);

			kryo.register(Arrays.asList("").getClass(), new ArraysAsListSerializer());
			kryo.register(GregorianCalendar.class, new GregorianCalendarSerializer());
			kryo.register(InvocationHandler.class, new JdkProxySerializer());
			kryo.register(BigDecimal.class, new DefaultSerializers.BigDecimalSerializer());
			kryo.register(BigInteger.class, new DefaultSerializers.BigIntegerSerializer());
			kryo.register(Pattern.class, new RegexSerializer());
			kryo.register(BitSet.class, new BitSetSerializer());
			kryo.register(URI.class, new URISerializer());
			kryo.register(UUID.class, new UUIDSerializer());
			UnmodifiableCollectionsSerializer.registerSerializers(kryo);
			SynchronizedCollectionsSerializer.registerSerializers(kryo);

			// now just added some very common classes
			// TODO optimization
			kryo.register(HashMap.class);
			kryo.register(ArrayList.class);
			kryo.register(LinkedList.class);
			kryo.register(HashSet.class);
			kryo.register(TreeSet.class);
			kryo.register(Hashtable.class);
//			kryo.register(Date.class);
			kryo.register(Calendar.class);
			kryo.register(ConcurrentHashMap.class);
			kryo.register(SimpleDateFormat.class);
			kryo.register(GregorianCalendar.class);
			kryo.register(Vector.class);
			kryo.register(BitSet.class);
			kryo.register(StringBuffer.class);
			kryo.register(StringBuilder.class);
			kryo.register(Object.class);
			kryo.register(Object[].class);
			kryo.register(String[].class);
			kryo.register(byte[].class);
			kryo.register(char[].class);
			kryo.register(int[].class);
			kryo.register(float[].class);
			kryo.register(double[].class);

			for (Class clazz : SerializableClassRegistry.getRegisteredClasses()) {
				kryo.register(clazz);
			}

			DateSerializer ds = new DateSerializer();
			kryo.register(java.sql.Timestamp.class, ds);
			kryo.register(java.sql.Date.class, ds);
			kryo.register(java.sql.Time.class, ds);
			kryo.register(Date.class, ds);

			kryo.addDefaultSerializer(Enum.class, EnumSerializerEx.class);
			kryo.setDefaultSerializer(CompatibleFieldSerializer.class);
			
			kryo.setClassLoader(cl);
			
			return kryo;
		}
	};

	public static KryoFactory getDefaultFactory() {
		return factory;
	}

	public static void setClassLoader(ClassLoader c) {
		cl = c;
	}



}
