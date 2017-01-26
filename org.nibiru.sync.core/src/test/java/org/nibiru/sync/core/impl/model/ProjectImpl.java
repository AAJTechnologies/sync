package org.nibiru.sync.core.impl.model;

import org.nibiru.model.core.api.Value;
import org.nibiru.model.core.impl.java.JavaValue;

public class ProjectImpl implements Project {
    final Value<String> name = JavaValue.of(null);
    final Value<Directory> root = new DirectoryValue();

    @Override
    public String getName() {
        return name.get();
    }

    @Override
    public void setName(String name) {
        this.name.set(name);
    }

    @Override
    public Directory getRoot() {
        return root.get();
    }

    @Override
    public void setRoot(Directory root) {
        this.root.set(root);
    }
}
