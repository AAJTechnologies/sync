package org.nibiru.sync.core.impl.model;

import org.nibiru.model.core.api.ComplexValue;
import org.nibiru.model.core.api.Property;
import org.nibiru.model.core.api.Type;
import org.nibiru.model.core.api.Value;
import org.nibiru.model.core.impl.BaseValue;

import javax.annotation.Nullable;

import static com.google.common.base.Preconditions.checkNotNull;

public class DirectoryValue extends BaseValue<Directory> implements ComplexValue<Directory> {
    private DirectoryImpl directory;

    @Override
    public <X> ComplexValue<Directory> set(Property<Directory, X> property, Value<? extends X> value) {
        get(property).set(value.get());
        return this;
    }

    @Override
    public <X> Value<X> get(Property<Directory, X> property) {
        checkNotNull(property);
        switch (property.getName()){
            case DirectoryType.NAME_PROPERTY:
                return (Value<X>) directory.name;
            default:
                throw new IllegalArgumentException("Invalid property: " + property);
        }
    }

    @Override
    public <X> ComplexValue<X> getComplex(Property<Directory, X> property) {
        return (ComplexValue<X>)get(property);
    }

    @Override
    protected void setValue(@Nullable Directory directory) {
        this.directory = (DirectoryImpl) directory;
    }

    @Nullable
    @Override
    public Directory get() {
        return directory;
    }

    @Override
    public Type<Directory> getType() {
        return DirectoryType.INSTANCE;
    }
}
