package org.nibiru.sync.core.impl.model;

import com.google.common.collect.ImmutableMap;

import org.nibiru.model.core.api.ComplexType;
import org.nibiru.model.core.api.ComplexValue;
import org.nibiru.model.core.api.Property;
import org.nibiru.model.core.api.Type;
import org.nibiru.model.core.api.Value;
import org.nibiru.model.core.impl.BaseValue;
import org.nibiru.model.core.impl.java.JavaType;
import org.nibiru.model.core.impl.java.JavaValue;

import javax.annotation.Nullable;

import static com.google.common.base.Preconditions.checkNotNull;

public class ProjectValue extends BaseValue<Project> implements ComplexValue<Project> {
    private ProjectImpl project;

    @Override
    public <X> ComplexValue<Project> set(Property<Project, X> property, Value<? extends X> value) {
        get(property).set(value.get());
        return this;
    }

    @Override
    public <X> Value<X> get(Property<Project, X> property) {
        checkNotNull(property);
        switch (property.getName()){
            case ProjectType.NAME_PROPERTY:
                return (Value<X>) project.name;
            case ProjectType.ROOT_PROPERTY:
                return (Value<X>) project.root;
            default:
                throw new IllegalArgumentException("Invalid property: " + property);
        }
    }

    @Override
    public <X> ComplexValue<X> getComplex(Property<Project, X> property) {
        return (ComplexValue<X>)get(property);
    }

    @Override
    protected void setValue(@Nullable Project project) {
        this.project = (ProjectImpl) project;
    }

    @Nullable
    @Override
    public Project get() {
        return project;
    }

    @Override
    public Type<Project> getType() {
        return ProjectType.INSTANCE;
    }
}
