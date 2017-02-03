package org.nibiru.sync.core.impl.model;

import org.nibiru.model.gen.Generate;
import org.nibiru.model.gen.ImplGenerator;
import org.nibiru.model.gen.TypeGenerator;
import org.nibiru.model.gen.ValueGenerator;

@Generate(generators = {TypeGenerator.class, ValueGenerator.class, ImplGenerator.class})
public interface Directory {
    String getName();

    void setName(String name);
}
