public class Carta {
    private final int valor;
    private final Tipo tipo;































    public Carta(int valor, Tipo tipo) {
        if (valor < 1 || valor > 13) {
            throw new IllegalArgumentException("El valor debe estar entre 1 y 13.");
        }
        if (tipo == null) {
            throw new IllegalArgumentException("La figura no puede ser nula.");
        }
        this.valor = valor;
        this.tipo = tipo;
    }





















    public int getValor() {
        return valor;
    }
    public Tipo getTipo() {
        return tipo;
    }























    private String obtenerNombreValor() {
        if (valor == 1) {
            return "AS";
        }
        if (valor == 11) {
            return "J";
        }
        if (valor == 12) {
            return "Q";
        }
        if (valor == 13) {
            return "K";
        }
        return String.valueOf(valor);
    }

















    @Override
    public String toString() {
        return obtenerNombreValor() + " de " + tipo;
    }

    



    
}
