import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class CartaTest {
    @Test
    void debeMostrarAsConSuNombre() {
        Carta carta = new Carta(1, Tipo.CORAZONES);

        assertEquals("AS de CORAZONES", carta.toString());
    }

    @Test
    void debeRechazarValoresFueraDeRango() {
        assertThrows(IllegalArgumentException.class, () -> new Carta(14, Tipo.ESPADAS));
    }
}
