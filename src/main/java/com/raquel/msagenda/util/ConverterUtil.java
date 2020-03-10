package com.raquel.msagenda.util;

import org.modelmapper.ModelMapper;
import org.springframework.core.convert.converter.Converter;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public interface ConverterUtil<A, B> extends Converter<A, B> {

    @Override
    default B convert(A a) {
        ModelMapper modelMapper = new ModelMapper();
        Class clazz = getClass();
        ParameterizedType parameterizedType = (ParameterizedType) clazz.getGenericInterfaces()[0];
        Type[] typeArguments = parameterizedType.getActualTypeArguments();
        Class<B> typeArgument = (Class<B>) typeArguments[1];
        return modelMapper.map(a, typeArgument);

    }
}
