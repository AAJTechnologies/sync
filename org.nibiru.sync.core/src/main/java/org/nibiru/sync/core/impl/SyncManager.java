package org.nibiru.sync.core.impl;

import com.google.common.collect.Maps;

import org.nibiru.model.core.api.ComplexType;
import org.nibiru.model.core.api.ComplexValue;
import org.nibiru.model.core.api.Property;

import java.util.Map;

import javax.annotation.Nullable;

import static com.google.common.base.Preconditions.checkNotNull;

public class SyncManager {
    private final ValueFactory valueFactory;
    private final Map<String, ComplexValue<Object>> objects;
    private final ComplexValue<Object> root;

    public SyncManager(ValueFactory valueFactory, ComplexValue<?> root) {
        this.valueFactory = checkNotNull(valueFactory);
        this.root = (ComplexValue<Object>) checkNotNull(root);
        objects = Maps.newHashMap();
        objects.put("", this.root);
    }

    public void setValue(String key, String property, @Nullable Object value) {
        checkNotNull(key);
        checkNotNull(property);
        ComplexValue<Object> object = objects.get(key);
        ComplexType<Object> type = (ComplexType<Object>) object.getType();
        Property<Object, Object> prop = type.getProperty(property);

        object.set(prop, valueFactory.createValue(prop.getType(), value));
    }

    public void setReference(String key, String property, String targetKey) {
        checkNotNull(key);
        checkNotNull(property);
        checkNotNull(targetKey);

        ComplexValue<Object> object = objects.get(key);
        ComplexValue<Object> target = objects.get(targetKey);
        ComplexType<Object> type = (ComplexType<Object>) object.getType();
        Property<Object, Object> prop = type.getProperty(property);

        object.set(prop, target);
    }
}
