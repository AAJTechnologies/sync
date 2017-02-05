package org.nibiru.sync.core.impl;

import com.google.common.collect.Maps;

import org.nibiru.model.core.api.ComplexType;
import org.nibiru.model.core.api.ComplexValue;
import org.nibiru.model.core.api.Property;
import org.nibiru.model.core.api.Value;

import java.util.Map;

import javax.annotation.Nullable;

import static com.google.common.base.Preconditions.checkNotNull;

public class ModelUpdater {
    private final Map<String, Value<Object>> objects;

    public ModelUpdater() {
        objects = Maps.newHashMap();
    }

    // TODO: el elemento deberia ser algo serializable
    // O en el medio poner wrappers de updater/listener que
    // reciban un serializador o algo asi
    public void create(String key, Value<?> element) {
        checkNotNull(key);
        checkNotNull(element);
        objects.put(key, (Value<Object>) element);
    }

    public void setValue(String key, @Nullable Object value) {
        checkNotNull(key);
        Value<Object> object = objects.get(key);
        object.set(value);
    }

    public void setReference(String key, String targetKey) {
        checkNotNull(key);
        checkNotNull(targetKey);

        Value<Object> object = objects.get(key);
        Value<Object> target = objects.get(targetKey);

        object.set(target.get());
    }

    public <T extends Value<V>, V> T getRoot() {
        return (T) objects.get(ModelListener.ROOT_KEY);
    }
}
