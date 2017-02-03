package org.nibiru.sync.core.impl.model;

import org.nibiru.model.gen.Generate;
import org.nibiru.model.gen.ImplGenerator;
import org.nibiru.model.gen.TypeGenerator;
import org.nibiru.model.gen.ValueGenerator;

/**
 * Created by lbrasseur on 25/01/17.
 */

@Generate(generators = {TypeGenerator.class, ValueGenerator.class, ImplGenerator.class})
public interface Project {
    String getName();

    void setName(String name);

    Directory getRoot();

    void setRoot(Directory root);
}
