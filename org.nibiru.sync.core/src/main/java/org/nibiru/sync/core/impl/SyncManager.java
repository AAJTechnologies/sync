package org.nibiru.sync.core.impl;

import com.google.common.base.Preconditions;
import com.google.common.collect.Iterables;

import org.nibiru.model.core.api.ComplexType;
import org.nibiru.model.core.api.ComplexValue;
import org.nibiru.model.core.api.Property;
import org.nibiru.model.core.api.Type;
import org.nibiru.model.core.api.Value;

import javax.annotation.Nullable;

import static com.google.common.base.Preconditions.checkNotNull;
import static com.google.common.base.Preconditions.checkState;

public class SyncManager {
    private final ValueFactory valueFactory;
    private final ComplexType<Object> rootType;
    private ComplexValue<Object> root;

    public SyncManager(ValueFactory valueFactory, ComplexType<Object> rootType) {
        this.valueFactory = checkNotNull(valueFactory);
        this.rootType = checkNotNull(rootType);
    }

    public void setValue(@Nullable Object sourceValue, Iterable<String> targetPath) {
        checkNotNull(targetPath);
        if (Iterables.isEmpty(targetPath)) {
            root = (ComplexValue<Object>) valueFactory.createValue(rootType, sourceValue);
        } else {
            SearhcResult result = findValue(targetPath);
            Value<Object> targetValue = result.value;
            if (targetValue == null) {
                targetValue = (Value<Object>) valueFactory.createValue(result.property.getType(), sourceValue);
                result.parent.set(result.property, targetValue);
            }
            targetValue.set(sourceValue);
        }
    }

    public void setReference(Iterable<String> sourcePath, Iterable<String> targetPath) {
        checkNotNull(sourcePath);
        checkNotNull(targetPath);

        SearhcResult sourceResult = findValue(sourcePath);
        SearhcResult targetResult = findValue(targetPath);

        targetResult.parent.set(targetResult.property, sourceResult.value);
    }

    private SearhcResult findValue(Iterable<String> path) {
        ComplexValue<Object> parent = null;
        Property<Object, Object> prop = null;
        Value<Object> value = root;
        for (String propName : path) {
            checkState(value instanceof ComplexValue, "A non complex value found inside the path");
            parent = (ComplexValue<Object>) value;

            ComplexType<Object> parentType = (ComplexType<Object>) parent.getType();
            prop = parentType.getProperty(propName);
            value = parent.get(prop);
        }
        return new SearhcResult(parent, prop, value);
    }

    private static class SearhcResult {
        private final ComplexValue<Object> parent;
        private final Property<Object, Object> property;
        private final Value<Object> value;

        private SearhcResult(ComplexValue<Object> parent,
                             Property<Object, Object> property,
                             Value<Object> value) {
            this.parent = parent;
            this.property = property;
            this.value = value;
        }
    }
}
