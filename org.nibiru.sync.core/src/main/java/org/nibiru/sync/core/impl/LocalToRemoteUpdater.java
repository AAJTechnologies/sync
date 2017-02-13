package org.nibiru.sync.core.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.nibiru.model.core.api.Value;
import org.nibiru.sync.core.api.ModelUpdater;
import org.nibiru.sync.core.api.RemoteModelUpdater;

import javax.annotation.Nullable;

import static com.google.common.base.Preconditions.checkNotNull;

public class LocalToRemoteUpdater implements ModelUpdater {
    private final RemoteModelUpdater remoteUpdater;
    private final ObjectMapper mapper = new ObjectMapper();

    public LocalToRemoteUpdater(RemoteModelUpdater remoteUpdater) {
        this.remoteUpdater = checkNotNull(remoteUpdater);
    }


    @Override
    public void create(String key, Value<?> element) {
        checkNotNull(key);
        checkNotNull(element);
        try {
            remoteUpdater.create(key, mapper.writeValueAsString(element), element.getClass().getName());
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void setValue(String key, @Nullable Object value) {
        checkNotNull(key);
        try {
            if (value != null) {
                remoteUpdater.create(key, mapper.writeValueAsString(value), value.getClass().getName());
            } else {
                remoteUpdater.create(key, null, null);
            }
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void setReference(String key, String targetKey) {
        checkNotNull(key);
        checkNotNull(targetKey);
        remoteUpdater.setReference(key, targetKey);
    }

    @Override
    public <T extends Value<V>, V> T getRoot() {
        return null;
    }
}
