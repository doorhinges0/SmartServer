package com.fuck.mobile.spring.dubbo.kryo2;

import com.alibaba.dubbo.common.serialize.support.kryo.ReflectionUtils;
import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.Serializer;
import com.esotericsoftware.kryo.serializers.JavaSerializer;

public class CompatibleKryoEx extends Kryo {

    @Override
    public Serializer getDefaultSerializer(Class type) {
        if (type == null) {
            throw new IllegalArgumentException("type cannot be null.");
        }

        if (!type.isArray() && !type.isEnum() && !ReflectionUtils.checkZeroArgConstructor(type)) {
            return new JavaSerializer();
        }
        return super.getDefaultSerializer(type);
    }
}