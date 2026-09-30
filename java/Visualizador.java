public class Visualizador {
    
    public static void carta(Carta c, Posicion p) {
        int posX = p.getX();
        int posY = p.getY();
        

        
        Square fondoCarta = new Square();
        


        fondoCarta.changeColor("blue"); 
        fondoCarta.makeVisible();
        



        System.out.println("Graficando " + c.toString() + " en X:" + posX + " Y:" + posY);
    }
}