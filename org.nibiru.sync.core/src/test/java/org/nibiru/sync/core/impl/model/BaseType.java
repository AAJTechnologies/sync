package org.nibiru.sync.core.impl.model;


import com.google.common.collect.Maps;

import org.nibiru.model.core.api.ComplexType;
import org.nibiru.model.core.api.Property;
import org.nibiru.model.core.api.Type;

import java.util.Map;

import javax.annotation.Nullable;

import static com.google.common.base.Preconditions.checkNotNull;

// TODO: Should this be moved to "model"?
public class BaseType<T> implements ComplexType<T> {
    private final Class<T> clazz;
    private final Map<String, Property<T, ?>> properties;

    public BaseType(Class<T> clazz, Map<String, Type<?>> propertyTypes) {
        this.clazz = checkNotNull(clazz);
        checkNotNull(propertyTypes);

        this.properties = Maps.newHashMap(Maps.transformEntries(propertyTypes,
                (String key, Type<?> value) -> new BaseProperty<>(key, value, this)));
    }

    @Override
    public Iterable<Property<T, ?>> getProperties() {
        return properties.values();
    }

    @Override
    public <X> Property<T, X> getProperty(String name) {
        return (Property<T, X>) properties.get(name);
    }

    @Override
    public Class<T> cast() {
        return clazz;
    }

    @Override
    public String getName() {
        return clazz.getName();
    }

    @Override
    public String getNamespace() {
        return clazz.getPackage().getName();
    }
}
