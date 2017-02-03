package org.nibiru.sync.core.impl;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.nibiru.sync.core.impl.model.DirectoryValue;
import org.nibiru.sync.core.impl.model.Project;
import org.nibiru.sync.core.impl.model.ProjectImpl;
import org.nibiru.sync.core.impl.model.ProjectValue;

public class SyncManagerTest {
    private static String PROJECT_NAME = "Eipipimeiker";
    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void matanga() throws Exception {
        Project source = new ProjectImpl();
        Project target = new ProjectImpl();

        ProjectValue pv = new ProjectValue();

        SyncManager syncManager = new SyncManager(new TestValueFactory(), pv);

        pv.set(source);

        source.setName("PROJECT_NAME");

        assertEquals(source.getName(), target.getName());
    }
}
