import java.util.List;

public class Juego {
    public static void main(String[] args) {
        Mazo mazo = new Mazo();
        System.out.println("=== Creacion del mazo ===");
        System.out.println("Se creo un mazo de " + mazo.getCantidadCartas() + " cartas.");
        mostrarPrimerasCartas("Primeras 5 cartas sin barajar", mazo.getCartasNoRepartidas());

        System.out.println("\n=== Barajar ===");
        System.out.println("Se esta barajando el mazo...");
        mazo.barajar();
        mostrarPrimerasCartas("Primeras 5 cartas despues de barajar", mazo.getCartasNoRepartidas());

        Jugador ana = new Jugador("Ana");
        Jugador carlos = new Jugador("Carlos");
        Jugador maria = new Jugador("Maria");
        Jugador[] jugadores = new Jugador[3];
        jugadores[0] = ana;
        jugadores[1] = carlos;
        jugadores[2] = maria;
        System.out.println("\n=== Jugadores ===");
        for (int indice = 0; indice < jugadores.length; indice++) {
            System.out.println("Jugador: " + jugadores[indice].nombre);
        }

        System.out.println("\n=== Reparto ===");
        for (int indiceJugador = 0; indiceJugador < jugadores.length; indiceJugador++) {
            List<Carta> cartas = mazo.repartirCartas(5);
            for (int indiceCarta = 0; indiceCarta < cartas.size(); indiceCarta++) {
                jugadores[indiceJugador].recibirCarta(cartas.get(indiceCarta));
            }
            System.out.println(jugadores[indiceJugador]);
        }

        System.out.println("\n=== Cartas sobrantes ===");
        System.out.println("Quedan " + mazo.getCantidadCartas() + " cartas en el mazo.");
        mostrarPrimerasCartas("Primeras 5 cartas sobrantes", mazo.getCartasNoRepartidas());

        System.out.println("\n=== Ana devuelve 2 cartas ===");
        Carta cartaDevuelta1 = ana.deshacerseDeCarta(ana.getMano().size() - 1);
        Carta cartaDevuelta2 = ana.deshacerseDeCarta(ana.getMano().size() - 1);
        mazo.agregarCartaAlFinal(cartaDevuelta1);
        mazo.agregarCartaAlFinal(cartaDevuelta2);
        System.out.println("Mano de Ana: " + ana);
        System.out.println("Las cartas devueltas se agregaron al final del mazo.");
        System.out.println("Ahora quedan " + mazo.getCantidadCartas() + " cartas sobrantes.");

        System.out.println("\n=== Busqueda de carta ===");
        Carta cartaBuscada = carlos.getMano().get(0);
        Jugador jugadorEncontrado = buscarJugador(jugadores, cartaBuscada);
        System.out.println(cartaBuscada + " la tiene " + jugadorEncontrado.nombre + ".");
    }

    private static void mostrarPrimerasCartas(String titulo, List<Carta> cartas) {
        System.out.println(titulo + ":");
        int limite = Math.min(5, cartas.size());
        for (int indice = 0; indice < limite; indice++) {
            System.out.println("- " + cartas.get(indice));
        }
    }

    private static Jugador buscarJugador(Jugador[] jugadores, Carta cartaBuscada) {
        for (int indiceJugador = 0; indiceJugador < jugadores.length; indiceJugador++) {
            List<Carta> mano = jugadores[indiceJugador].getMano();
            for (int indiceCarta = 0; indiceCarta < mano.size(); indiceCarta++) {
                Carta carta = mano.get(indiceCarta);
                if (carta.getValor() == cartaBuscada.getValor()
                        && carta.getTipo() == cartaBuscada.getTipo()) {
                    return jugadores[indiceJugador];
                }
            }
        }
        return null;
    }
}
