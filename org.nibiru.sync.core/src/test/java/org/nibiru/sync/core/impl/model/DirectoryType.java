package org.nibiru.sync.core.impl.model;

import com.google.common.collect.ImmutableMap;

import org.nibiru.model.core.api.Type;
import org.nibiru.model.core.impl.java.JavaType;

public class DirectoryType extends BaseType<Directory> {
    static final DirectoryType INSTANCE = new DirectoryType();

    static final String NAME_PROPERTY = "name";

    private DirectoryType() {
        super(Directory.class,
                ImmutableMap.of(
                        NAME_PROPERTY, JavaType.STRING
                ));
    }
}
