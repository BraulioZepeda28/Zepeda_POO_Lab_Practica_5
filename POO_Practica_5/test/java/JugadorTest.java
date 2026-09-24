import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class JugadorTest {
    @Test
    void debeGestionarSuMano() {
        Jugador jugador = new Jugador("Ana");
        Carta carta = new Carta(10, Tipo.ESPADAS);

        jugador.recibirCarta(carta);

        assertEquals(1, jugador.getMano().size());
        assertEquals(carta, jugador.deshacerseDeCarta(0));
        assertEquals(0, jugador.getMano().size());
    }
}
