package edu.eci.arep.ASE.app;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.beans.Transient;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;

import edu.eci.arep.ASE.app.persistence.GestionLogs;
import edu.eci.arep.ASE.app.service.LogsService;

public class LogsServiceTest {

    private LogsService logsService;
    private GestionLogs gestionLogs;
    

    @Before
    public void setUp() {
        gestionLogs= mock(GestionLogs.class);
        logsService = new LogsService(gestionLogs);
    }


    @Test
    public void shouldsaveTest() {
        String id = "testId";

        logsService.save(id);

        verify(gestionLogs, times(1)).save(anyString(), anyString());

    }

    @Test
    public void shouldgetTenTest(){
        Collection<String> mockLogs = Arrays.asList("log1", "log2", "log3", 
                                    "log4", "log5", "log6", "log7", "log8", 
                                    "log9", "log10", "log11");

        when(gestionLogs.searchAll()).thenReturn(mockLogs);

        Collection<String> latestLogs = logsService.getLatest();

        verify(gestionLogs, times(1)).searchAll();
        assertEquals(10, latestLogs.size());

    }


    @Test
    public void shouldgetLatestTenTest() {
        Collection<String> mockLogs = Arrays.asList("log1", "log2", "log3", 
                                    "log4", "log5", "log6", "log7", "log8", 
                                    "log9", "log10", "log11");

        Collection<String> auxMockLogs = Arrays.asList("log2", "log3", 
                                "log4", "log5", "log6", "log7", "log8", 
                                "log9", "log10", "log11");

        when(gestionLogs.searchAll()).thenReturn(mockLogs);

        Collection<String> latestLogs = logsService.getLatest();

        verify(gestionLogs, times(1)).searchAll();
        assertEquals(10, latestLogs.size());
        assertEquals(auxMockLogs, latestLogs);

    }
    
}
