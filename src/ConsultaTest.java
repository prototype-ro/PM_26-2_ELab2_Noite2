import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

public class ConsultaTest {
    
    @Test
    public void TesteConsulta(){
        Consulta consulta_A;
        Consulta consulta_B;
        
        consulta_A = new ConsultaAgendada("Rodrigo",LocalDateTime.of(2026,10,21,18,00),"ORTOPEDIA");
        consulta_B = new ConsultaRetorno("Rodrigo",LocalDateTime.of(2026,11,6,18,00),"ORTOPEDIA");
        
        assertEquals(0, ConsultaRetorno(consulta_B.horario,consulta_A););
    }
}
