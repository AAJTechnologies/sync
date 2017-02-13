package org.nibiru.sync.core.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Preconditions;

import org.nibiru.model.core.api.Value;
import org.nibiru.sync.core.api.ModelUpdater;
import org.nibiru.sync.core.api.RemoteModelUpdater;

import java.io.IOException;

import javax.annotation.Nullable;

import static com.google.common.base.Preconditions.checkNotNull;


public class RemoteToLocalUpdater implements RemoteModelUpdater {
    private final ModelUpdater updater;
    private final ObjectMapper mapper = new ObjectMapper();

    public RemoteToLocalUpdater(ModelUpdater updater) {
        this.updater = checkNotNull(updater);
    }


    @Override
    public void create(String key, String element, String className) {
        checkNotNull(key);
        checkNotNull(element);
        checkNotNull(className);
        try {
            updater.create(key, (Value<?>) mapper.readValue(element, Class.forName(className)));
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void setValue(String key, @Nullable String value, @Nullable String className) {
        checkNotNull(key);
        try {
            if (value != null && className != null) {
                updater.setValue(key, mapper.readValue(value, Class.forName(className)));
            } else {
                updater.setValue(key, null);
            }
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void setReference(String key, String targetKey) {
        checkNotNull(key);
        checkNotNull(targetKey);
        updater.setReference(key, targetKey);
    }
}
