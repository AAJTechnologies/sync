package org.nibiru.sync.core.api;

import org.nibiru.model.core.api.Value;

public interface ModelListener {
    void listen(Value<?> root);
}
