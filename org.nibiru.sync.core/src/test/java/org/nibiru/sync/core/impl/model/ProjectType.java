package org.nibiru.sync.core.impl.model;

import com.google.common.collect.ImmutableMap;

import org.nibiru.model.core.api.Type;
import org.nibiru.model.core.impl.java.JavaType;

/**
 * Created by lbrasseur on 25/01/17.
 */

public class ProjectType extends BaseType<Project> {
    static final ProjectType INSTANCE = new ProjectType();

    static final String NAME_PROPERTY = "name";
    static final String ROOT_PROPERTY = "root";

    private ProjectType() {
        super(Project.class,
                ImmutableMap.of(
                        NAME_PROPERTY, JavaType.STRING,
                        ROOT_PROPERTY, DirectoryType.INSTANCE
                ));
    }
}