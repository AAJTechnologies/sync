package org.nibiru.sync.core.api;

import org.nibiru.model.core.api.Value;

import javax.annotation.Nullable;

public interface ModelUpdater {
    void create(String key, Value<?> element);

    void setValue(String key, @Nullable Object value);

    void setReference(String key, String targetKey);

    //TODO: esto me hace mucho ruido. No encaja con el remoto.
    <T extends Value<V>, V> T getRoot();
}
