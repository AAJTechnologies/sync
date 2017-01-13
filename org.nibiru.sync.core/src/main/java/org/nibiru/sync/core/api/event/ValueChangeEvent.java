package org.nibiru.sync.core.api.event;

public interface ValueChangeEvent<T> extends Event {
    String getProperty();

    T getValue();
}
