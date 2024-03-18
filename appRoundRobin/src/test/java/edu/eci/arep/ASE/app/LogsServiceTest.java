package edu.eci.arep.ASE.app;
 
import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
 
import java.util.Collection;
 
import org.junit.Test;
import org.mockito.Mockito;
 
import edu.eci.arep.ASE.app.apiExternal.HttpClient;
import edu.eci.arep.ASE.app.service.LogsService;

public class LogsServiceTest {

    @Test
    public void shouldInvokerLogs(){
        String dataPort = "Port: 5000->dataPort: Prueba-1";
        String llamado = "Prueba-1";

        HttpClient httpClient = Mockito.mock(HttpClient.class);
        when(httpClient.call(anyString(), anyString())).thenReturn(llamado);

        LogsService logsService = new LogsService("http://localhost:5000/logService", 5000, httpClient);

        Collection<String> result = logsService.invokerLogs(dataPort);

        assertEquals(1, result.size());
        assertEquals(llamado, result.iterator().next());

    }

}
