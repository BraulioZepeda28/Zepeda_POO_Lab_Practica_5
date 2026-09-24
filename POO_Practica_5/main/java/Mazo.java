import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Mazo {
    private static final int NUMERO_DE_VALORES = 13;
    private List<Carta> pilaNoRepartidas;






    


    public Mazo() {
        pilaNoRepartidas = new ArrayList<Carta>();
        restablecer();
    }















    public final void restablecer() {
        pilaNoRepartidas.clear();
        Tipo[] tipos = Tipo.values();
        for (int indiceTipo = 0; indiceTipo < tipos.length; indiceTipo++) {
            Tipo tipo = tipos[indiceTipo];
            for (int valor = 1; valor <= NUMERO_DE_VALORES; valor++) {
                pilaNoRepartidas.add(new Carta(valor, tipo));
            }
        }
    }














    public void barajar() {
        Collections.shuffle(pilaNoRepartidas);
    }













    public List<Carta> repartirCartas(int cantidad) {
        if (cantidad < 0 || cantidad > pilaNoRepartidas.size()) {
            throw new IllegalArgumentException("La cantidad a repartir no es valida.");
        }

        List<Carta> cartasRepartidas = new ArrayList<Carta>();
        for (int indice = 0; indice < cantidad; indice++) {
            Carta carta = quitarCarta();
            cartasRepartidas.add(carta);
        }
        return cartasRepartidas;
    }











    public Carta quitarCarta() {
        if (pilaNoRepartidas.isEmpty()) {
            throw new IllegalStateException("No quedan cartas en el mazo.");
        }
        return pilaNoRepartidas.remove(0);
    }














    public void agregarCartaAlFinal(Carta carta) {
        if (carta == null) {
            throw new IllegalArgumentException("La carta no puede ser nula.");
        }
        pilaNoRepartidas.add(carta);
    }













    public List<Carta> getCartasNoRepartidas() {
        List<Carta> copia = new ArrayList<Carta>();
        for (int indice = 0; indice < pilaNoRepartidas.size(); indice++) {
            copia.add(pilaNoRepartidas.get(indice));
        }
        return copia;
    }












    public int getCantidadCartas() {
        return pilaNoRepartidas.size();
    }




}


