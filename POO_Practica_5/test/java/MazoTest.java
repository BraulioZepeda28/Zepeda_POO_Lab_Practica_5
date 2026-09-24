import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;

import org.junit.jupiter.api.Test;

class MazoTest {
    @Test
    void debeCrear52Cartas() {
        Mazo mazo = new Mazo();

        assertEquals(52, mazo.getCantidadCartas());
    }

    @Test
    void debeRepartirCartas() {
        Mazo mazo = new Mazo();

        List<Carta> cartas = mazo.repartirCartas(5);

        assertEquals(5, cartas.size());
        assertEquals(47, mazo.getCantidadCartas());
    }

    @Test
    void debeAgregarCartaAlFinal() {
        Mazo mazo = new Mazo();
        Carta carta = mazo.quitarCarta();

        mazo.agregarCartaAlFinal(carta);

        assertEquals(52, mazo.getCantidadCartas());
        assertEquals(carta.toString(), mazo.getCartasNoRepartidas().get(51).toString());
    }

    @Test
    void debeRechazarRepartoExcesivo() {
        Mazo mazo = new Mazo();

        assertThrows(IllegalArgumentException.class, () -> mazo.repartirCartas(53));
    }
}
