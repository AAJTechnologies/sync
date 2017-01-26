package org.nibiru.sync.core.impl.model;

import org.nibiru.model.core.api.Value;
import org.nibiru.model.core.impl.java.JavaValue;

/**
 * Created by lbrasseur on 25/01/17.
 */

public class DirectoryImpl implements Directory {
    final Value<String> name = JavaValue.of(null);

    public String getName() {
        return name.get();
    }

    public void setName(String name) {
        this.name.set(name);
    }
}