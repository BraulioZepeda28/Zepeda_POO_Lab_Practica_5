public class Visualizador {
    
   public static void carta(Carta c, Posicion p) {
    int posX = p.getX();
    int posY = p.getY();
    Square fondo = new Square();
    fondo.changeColor("black"); 
    fondo.moveHorizontal(posX);
    fondo.moveVertical(posY);
    fondo.makeVisible();
    Tipo tipoCarta = c.getTipo();
    
    switch (tipoCarta) {
        case CORAZONES:
            
           fondo.makeInvisible();
            Circle mediaLunaIzquierda = new Circle();
            mediaLunaIzquierda.changeColor("red");
            mediaLunaIzquierda.moveHorizontal(posX + 10); 
            mediaLunaIzquierda.moveVertical(posY + 10);
            mediaLunaIzquierda.makeVisible();
            
            Circle mediaLunaDerecha = new Circle();
            mediaLunaDerecha.changeColor("red");
            mediaLunaDerecha.moveHorizontal(posX + 30);
            mediaLunaDerecha.moveVertical(posY + 10);
            mediaLunaDerecha.makeVisible();
            
            Triangle punta = new Triangle();
            punta.changeColor("red");
            punta.moveHorizontal(posX + 30);
            punta.moveVertical(posY + 30);
            punta.makeVisible();
            break;
            
        case ESPADAS:
            fondo.makeInvisible();
            Circle mediaLunaIzquierdaespada = new Circle();
            mediaLunaIzquierdaespada.changeColor("yellow");
            mediaLunaIzquierdaespada.moveHorizontal(posX + 10); 
            mediaLunaIzquierdaespada.moveVertical(posY + 10);
            mediaLunaIzquierdaespada.makeVisible();
            break;
            
        case DIAMANTES:
            fondo.makeInvisible();
            int cantidad = c.getValor();
            for (int i = 0; i < cantidad; i++) {
            int nuevaY = posY + (i * 30); 
            Square diamante = new Square();
            diamante.changeColor("red");
            diamante.moveHorizontal(posX + 10);
            diamante.moveVertical(nuevaY);
            diamante.makeVisible();
}
            break;
            
        case TREBOLES:
            fondo.makeInvisible();
            Circle mediaLunaIzquierdatrebol = new Circle();
            mediaLunaIzquierdatrebol.changeColor("green");
            mediaLunaIzquierdatrebol.moveHorizontal(posX + 10); 
            mediaLunaIzquierdatrebol.moveVertical(posY + 10);
            mediaLunaIzquierdatrebol.makeVisible();
            break;
    }
}
}