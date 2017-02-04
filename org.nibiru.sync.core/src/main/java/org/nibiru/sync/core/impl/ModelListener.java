package org.nibiru.sync.core.impl;

import org.nibiru.model.core.api.ComplexType;
import org.nibiru.model.core.api.ComplexValue;
import org.nibiru.model.core.api.Property;
import org.nibiru.model.core.api.Value;

import java.util.UUID;

import static com.google.common.base.Preconditions.checkNotNull;

public class ModelListener {
    public static final String ROOT_KEY = "";
    //private final ComplexValue<Object> root;
    private final ModelUpdater modelUpdater;

    // Para remoto, wrapear el ModelUpdater?
    public ModelListener(Value<?> root,
                         ModelUpdater modelUpdater) {
        checkNotNull(root);
        this.modelUpdater = checkNotNull(modelUpdater);
        addObject(ROOT_KEY, (Value<Object>) root);
    }

    private void addObject(String key, Value<Object> object) {
        modelUpdater.create(key, object);
        object.addObserver(() -> {
            addChildren(object);
            modelUpdater.setValue(key, object.get());
        });
        addChildren(object);
    }

    private void addChildren(Value<Object> object) {
        if (object.get() != null && object instanceof ComplexValue) {
            ComplexValue<Object> complexObject = (ComplexValue<Object>) object;
            ComplexType<Object> complexType = (ComplexType<Object>) complexObject.getType();

            for (Property<Object, ?> property : complexType.getProperties()) {
                String key = UUID.randomUUID().toString(); // TODO: poner algo que sea compatible con GWT
                addObject(key, complexObject.get((Property<Object, Object>) property));
            }
        }
    }
}
