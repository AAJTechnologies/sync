package org.nibiru.sync.core.api.manager;

import org.nibiru.sync.core.api.event.Event;

import java.util.function.Consumer;

public interface SyncManager {
    void fireEvent(Event event);

    void listenEvent(Consumer<? extends  Event> callback);
}
