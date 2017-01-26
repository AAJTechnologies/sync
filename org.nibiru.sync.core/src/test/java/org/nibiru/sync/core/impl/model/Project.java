package org.nibiru.sync.core.impl.model;

/**
 * Created by lbrasseur on 25/01/17.
 */

public interface Project {
    String getName();

    void setName(String name);

    Directory getRoot();

    void setRoot(Directory root);
}
