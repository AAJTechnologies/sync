package org.nibiru.sync.core.impl;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import org.nibiru.sync.core.impl.model.Project;
import org.nibiru.sync.core.impl.model.ProjectImpl;
import org.nibiru.sync.core.impl.model.ProjectValue;

public class SyncTest {
    private static String PROJECT_NAME = "Eipipimeiker";
    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void matanga() throws Exception {
//        Project source = new ProjectImpl();
//        Project target = new ProjectImpl();

        ProjectValue source = new ProjectValue();

        ModelUpdater updater = new ModelUpdater();
        ModelListener listener = new ModelListener(source, updater);

        source.set(new ProjectImpl());

        source.get().setName("PROJECT_NAME");

        ProjectValue target = updater.getRoot();

        assertEquals(source.get().getName(), target.get().getName());
    }
}
