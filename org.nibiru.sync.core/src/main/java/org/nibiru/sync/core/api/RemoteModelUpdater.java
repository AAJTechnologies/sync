package org.nibiru.sync.core.api;

import org.nibiru.model.core.api.Value;

import javax.annotation.Nullable;

public interface RemoteModelUpdater {
    void create(String key, String element, String className);

    void setValue(String key, @Nullable String value, @Nullable String className);

    void setReference(String key, String targetKey);
}
