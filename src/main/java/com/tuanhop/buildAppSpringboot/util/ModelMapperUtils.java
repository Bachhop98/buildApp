package com.tuanhop.buildAppSpringboot.util;


import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class ModelMapperUtils {

    private static final ModelMapper modelMapper = new ModelMapper();
    static {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        modelMapper.getConfiguration().setPropertyCondition(Conditions.isNotNull());
        modelMapper.getConfiguration().setSkipNullEnabled(true);
    }


    private ModelMapperUtils() {
        // Prevents developer from initiating instance.
    }

    /**
     * @param <S>
     *            type of result object.
     * @param <T>
     *            type of source object to map from.
     * @param entity
     *            entity that needs to be mapped.
     * @param targetClass
     *            class of result object.
     * @return new object of targetClass type.
     */
    public static <T, S> S map(final T entity, Class<S> targetClass) {
        return modelMapper.map(entity, targetClass);
    }

    /**
     * @param entities
     *            list of entity that needs to be mapped
     * @param targetClass
     *            class of result list element
     * @param <S>
     *            type of objects in result list
     * @param <T>
     *            type of entity in entityList
     * @return list of mapped object with targetClass type.
     */
    public static <T, S> List<S> mapAll(final Collection<T> entities, Class<S> targetClass) {
        return entities.stream().map(element -> map(element, targetClass)).collect(Collectors.toList());
    }

    /**
     * @param source
     *            object to map from
     * @param destination
     *            object to map to
     */
    public static <T, S> S map(final T source, S destination) {
        modelMapper.map(source, destination);
        return destination;
    }

}

