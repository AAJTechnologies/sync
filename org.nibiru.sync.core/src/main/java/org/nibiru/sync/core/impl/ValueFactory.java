package org.nibiru.sync.core.impl;

import org.nibiru.model.core.api.ComplexType;
import org.nibiru.model.core.api.ComplexValue;
import org.nibiru.model.core.api.Type;
import org.nibiru.model.core.api.Value;

/**
 * Created by lbrasseur on 13/01/17.
 */
public interface ValueFactory {
    Value<?> createValue(Type<?> type, Object value);
}
