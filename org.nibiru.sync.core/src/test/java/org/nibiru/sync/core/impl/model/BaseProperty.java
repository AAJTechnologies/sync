package org.nibiru.sync.core.impl.model;

import com.google.common.base.Preconditions;

import org.nibiru.model.core.api.Property;
import org.nibiru.model.core.api.Type;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by lbrasseur on 25/01/17.
 */

public class BaseProperty<T, P> implements Property<T, P> {
    private final String name;
    private final Type<P> type;
    private final Type<T> parent;

    public BaseProperty(String name, Type<P> type, Type<T> parent) {
        this.name = checkNotNull(name);
        this.type = checkNotNull(type);
        this.parent = checkNotNull(parent);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Type<P> getType() {
        return type;
    }

    @Override
    public Type<T> getParent() {
        return parent;
    }
}
