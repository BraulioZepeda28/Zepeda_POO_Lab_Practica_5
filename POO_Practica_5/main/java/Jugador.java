import java.util.ArrayList;
import java.util.List;

public class Jugador {
    public String nombre;

    private List<Carta> mano;









    public Jugador(String nombre) {
        this.nombre = nombre;
        this.mano = new ArrayList<Carta>();
    }










    public void recibirCarta(Carta carta) {
        if (carta == null) {
            throw new IllegalArgumentException("La carta no puede ser nula.");
        }
        mano.add(carta);
    }













    public Carta deshacerseDeCarta(int indice) {
        return mano.remove(indice);
    }












    public List<Carta> getMano() {
        List<Carta> copia = new ArrayList<Carta>();
        for (int indice = 0; indice < mano.size(); indice++) {
            copia.add(mano.get(indice));
        }
        return copia;
    }











    
    @Override
    public String toString() {
        return nombre + ": " + mano;
    }
}
