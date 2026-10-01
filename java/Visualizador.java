public class Visualizador {
    
   public static void carta(Carta c, Posicion p) {
    Square fondo = new Square();
    fondo.changeColor("white"); 
    fondo.changeSize(350, 200);
    fondo.setPosition((500 - 200) / 2, (500 - 350) / 2);
    fondo.makeVisible();

         Tipo tipoCarta = c.getTipo();
         String colorCarta = colorDe(tipoCarta);
       Canvas.getCanvas().drawText(c, c.obtenerNombreValor(), 170, 125, colorCarta);
         dibujarPalo(c, colorCarta);
}

   private static String colorDe(Tipo tipo) {
      return tipo == Tipo.CORAZONES || tipo == Tipo.DIAMANTES
            ? "vino" : "black";
   }

private static void dibujarEspada(int centroX, int centroY, String color) {
   Square hoja = new Square();
   hoja.changeColor(color);
   hoja.changeSize(70, 9);
   hoja.setPosition(centroX - 4, centroY - 50);
   hoja.makeVisible();

   Square guarda = new Square();
   guarda.changeColor(color);
   guarda.changeSize(6, 36);
   guarda.setPosition(centroX - 18, centroY + 15);
   guarda.makeVisible();

   Square empunadura = new Square();
   empunadura.changeColor(color);
   empunadura.changeSize(30, 8);
   empunadura.setPosition(centroX - 4, centroY + 21);
   empunadura.makeVisible();
}

private static void dibujarEspadaPequena(int centroX, int centroY, String color) {
   Square hoja = new Square();
   hoja.changeColor(color);
   hoja.changeSize(22, 4);
   hoja.setPosition(centroX - 2, centroY - 14);
   hoja.makeVisible();

   Square guarda = new Square();
   guarda.changeColor(color);
   guarda.changeSize(2, 12);
   guarda.setPosition(centroX - 6, centroY + 8);
   guarda.makeVisible();

   Square empunadura = new Square();
   empunadura.changeColor(color);
   empunadura.changeSize(8, 3);
   empunadura.setPosition(centroX - 1, centroY + 10);
   empunadura.makeVisible();
}

private static void dibujarDiamante(int centroX, int centroY, String color) {
   Triangle parteSuperior = new Triangle();
   parteSuperior.changeColor(color);
   parteSuperior.changeSize(25, 60);
   parteSuperior.setPosition(centroX, centroY - 25);
   parteSuperior.makeVisible();

   Triangle parteInferior = new Triangle();
   parteInferior.changeColor(color);
   parteInferior.rotate();
   parteInferior.rotate();
   parteInferior.changeSize(25, 60);
   parteInferior.setPosition(centroX, centroY);
   parteInferior.makeVisible();
}

private static void dibujarDiamantePequeno(int centroX, int centroY, String color) {
   Triangle parteSuperior = new Triangle();
   parteSuperior.changeColor(color);
   parteSuperior.changeSize(12, 28);
   parteSuperior.setPosition(centroX, centroY - 12);
   parteSuperior.makeVisible();

   Triangle parteInferior = new Triangle();
   parteInferior.changeColor(color);
   parteInferior.rotate();
   parteInferior.rotate();
   parteInferior.changeSize(12, 28);
   parteInferior.setPosition(centroX, centroY);
   parteInferior.makeVisible();
}

private static void dibujarPalo(Carta carta, String color) {
   Tipo tipo = carta.getTipo();
   if (carta.getValor() >= 11 && carta.getValor() <= 13) {
      Person persona = new Person();
      persona.changeColor(color);
      persona.changeSize(100, 60);
      persona.setPosition(250, 240);
      persona.makeVisible();
      if (carta.getValor() == 11) {
         dibujarGuitarraJ(color, carta.getTipo());
      }
      else if (carta.getValor() == 12) {
         dibujarFaldaQ(color);
         dibujarCorona(color, carta.getTipo());
      }
      else {
         dibujarCorona(color, null);
         dibujarBaculoK(color, tipo);
      }
   }
   else if (carta.getValor() == 1) {
      dibujarSimbolo(tipo, 250, 250, color, TamanoSimbolo.GRANDE);
      dibujarLineaTrebol(color);
   }
   else {
      int[][] posiciones = posicionesPatron(carta.getValor());
      for (int[] posicion : posiciones) {
         dibujarSimbolo(tipo, posicion[0], posicion[1], color, TamanoSimbolo.PEQUENO);
      }
   }
}

private enum TamanoSimbolo {
   GRANDE,
   PEQUENO,
   COMPACTO
}

private static void dibujarSimbolo(Tipo tipo, int centroX, int centroY, String color,
                                   TamanoSimbolo tamano) {
   switch (tipo) {
      case CORAZONES:
         if (tamano == TamanoSimbolo.GRANDE) {
            dibujarCorazon(centroX, centroY, color);
         }
         else if (tamano == TamanoSimbolo.PEQUENO) {
            dibujarCorazonPequeno(centroX, centroY, color);
         }
         else {
            dibujarCorazonMedallon(centroX, centroY, color);
         }
         break;
      case DIAMANTES:
         if (tamano == TamanoSimbolo.GRANDE) {
            dibujarDiamante(centroX, centroY, color);
         }
         else if (tamano == TamanoSimbolo.PEQUENO) {
            dibujarDiamantePequeno(centroX, centroY, color);
         }
         else {
            dibujarDiamanteMedallon(centroX, centroY, color);
         }
         break;
      case ESPADAS:
         if (tamano == TamanoSimbolo.GRANDE) {
            dibujarEspada(centroX, centroY, color);
         }
         else if (tamano == TamanoSimbolo.PEQUENO) {
            dibujarEspadaPequena(centroX, centroY, color);
         }
         else {
            dibujarEspadaMedallon(centroX, centroY, color);
         }
         break;
      case TREBOLES:
         if (tamano == TamanoSimbolo.GRANDE) {
            dibujarTrebolGrande(centroX, centroY - 10, color);
         }
         else if (tamano == TamanoSimbolo.PEQUENO) {
            dibujarTrebol(centroX, centroY, color);
         }
         else {
            dibujarTrebolMedallon(centroX, centroY, color);
         }
         break;
   }
}

private static void dibujarCorazon(int centroX, int centroY, String color) {
   Circle ladoIzquierdo = new Circle();
   ladoIzquierdo.changeColor(color);
   ladoIzquierdo.changeSize(50);
   ladoIzquierdo.setPosition(centroX - 38, centroY - 50);
   ladoIzquierdo.makeVisible();

   Circle ladoDerecho = new Circle();
   ladoDerecho.changeColor(color);
   ladoDerecho.changeSize(50);
   ladoDerecho.setPosition(centroX - 13, centroY - 50);
   ladoDerecho.makeVisible();

   Triangle punta = new Triangle();
   punta.changeColor(color);
   punta.rotate();
   punta.rotate();
   punta.changeSize(50, 75);
   punta.setPosition(centroX, centroY - 15);
   punta.makeVisible();
}

private static void dibujarCorazonPequeno(int centroX, int centroY, String color) {
   Circle ladoIzquierdo = new Circle();
   ladoIzquierdo.changeColor(color);
   ladoIzquierdo.changeSize(15);
   ladoIzquierdo.setPosition(centroX - 11, centroY - 7);
   ladoIzquierdo.makeVisible();

   Circle ladoDerecho = new Circle();
   ladoDerecho.changeColor(color);
   ladoDerecho.changeSize(15);
   ladoDerecho.setPosition(centroX - 4, centroY - 7);
   ladoDerecho.makeVisible();

   Triangle punta = new Triangle();
   punta.changeColor(color);
   punta.rotate();
   punta.rotate();
   punta.changeSize(16, 24);
   punta.setPosition(centroX, centroY + 1);
   punta.makeVisible();
}

private static int[][] posicionesPatron(int cantidad) {
   int izquierda = 207;
   int centro = 250;
   int derecha = 293;
   int arriba = 155;
   int medio = 250;
   int abajo = 345;

   switch (cantidad) {
      case 2:
         return new int[][] {{centro, arriba}, {centro, abajo}};
      case 3:
         return new int[][] {{izquierda, arriba}, {centro, medio}, {derecha, abajo}};
      case 4:
         return new int[][] {{izquierda, arriba}, {derecha, arriba},
                        {izquierda, abajo}, {derecha, abajo}};
      case 5:
         return new int[][] {{izquierda, arriba}, {derecha, arriba}, {centro, medio},
                        {izquierda, abajo}, {derecha, abajo}};
      case 6:
         return new int[][] {{izquierda, arriba}, {derecha, arriba},
                        {izquierda, medio}, {derecha, medio},
                        {izquierda, abajo}, {derecha, abajo}};
      case 7:
         return new int[][] {{izquierda, arriba}, {derecha, arriba},
                        {izquierda, medio}, {centro, medio}, {derecha, medio},
                        {izquierda, abajo}, {derecha, abajo}};
      case 8:
         return new int[][] {{izquierda, arriba}, {centro, arriba}, {derecha, arriba},
                        {izquierda, medio}, {derecha, medio},
                        {izquierda, abajo}, {centro, abajo}, {derecha, abajo}};
      case 9:
         return new int[][] {{izquierda, arriba}, {centro, arriba}, {derecha, arriba},
                        {izquierda, medio}, {centro, medio}, {derecha, medio},
                        {izquierda, abajo}, {centro, abajo}, {derecha, abajo}};
      case 10:
         return posicionesAlternadas();
      default:
         return new int[0][0];
   }
}

private static int[][] posicionesAlternadas() {
   int[] columnas = {207, 250, 293};
   int[] filas = {155, 193, 231, 269, 307, 345};
   int[][] posiciones = new int[10][2];
   int indice = 0;

   for (int fila = 0; fila < filas.length; fila++) {
      for (int columna = 0; columna < columnas.length; columna++) {
         if (((fila % 3) + columna) % 2 == 0) {
            posiciones[indice][0] = columnas[columna];
            posiciones[indice][1] = filas[fila];
            indice++;
         }
      }
   }
   return posiciones;
}

private static void dibujarTrebol(int centroX, int centroY, String color) {
   Circle trebolSuperiorIzquierdo = new Circle();
   trebolSuperiorIzquierdo.changeColor(color);
   trebolSuperiorIzquierdo.changeSize(15);
   trebolSuperiorIzquierdo.setPosition(centroX - 14, centroY - 7);
   trebolSuperiorIzquierdo.makeVisible();

   Circle trebolSuperiorDerecho = new Circle();
   trebolSuperiorDerecho.changeColor(color);
   trebolSuperiorDerecho.changeSize(15);
   trebolSuperiorDerecho.setPosition(centroX - 1, centroY - 7);
   trebolSuperiorDerecho.makeVisible();

   Circle trebolInferior = new Circle();
   trebolInferior.changeColor(color);
   trebolInferior.changeSize(15);
   trebolInferior.setPosition(centroX - 7, centroY - 16);
   trebolInferior.makeVisible();

   Triangle talloTrebol = new Triangle();
   talloTrebol.changeColor(color);
   talloTrebol.changeSize(12, 6);
   talloTrebol.setPosition(centroX, centroY + 4);
   talloTrebol.makeVisible();
}

private static void dibujarTrebolGrande(int centroX, int centroY, String color) {
   Circle trebolSuperiorIzquierdo = new Circle();
   trebolSuperiorIzquierdo.changeColor(color);
   trebolSuperiorIzquierdo.changeSize(45);
   trebolSuperiorIzquierdo.setPosition(centroX - 42, centroY - 21);
   trebolSuperiorIzquierdo.makeVisible();

   Circle trebolSuperiorDerecho = new Circle();
   trebolSuperiorDerecho.changeColor(color);
   trebolSuperiorDerecho.changeSize(45);
   trebolSuperiorDerecho.setPosition(centroX - 3, centroY - 21);
   trebolSuperiorDerecho.makeVisible();

   Circle trebolInferior = new Circle();
   trebolInferior.changeColor(color);
   trebolInferior.changeSize(45);
   trebolInferior.setPosition(centroX - 21, centroY - 48);
   trebolInferior.makeVisible();

   Triangle talloTrebol = new Triangle();
   talloTrebol.changeColor(color);
   talloTrebol.changeSize(36, 18);
   talloTrebol.setPosition(centroX, centroY + 12);
   talloTrebol.makeVisible();
}

private static void dibujarLineaTrebol(String color) {
   Canvas.getCanvas().draw(new Object(), color,
   new java.awt.geom.Rectangle2D.Double(210, 307, 80, 6));
}

private static void dibujarGuitarraJ(String color, Tipo tipo) {
   Square mastil = new Square();
   mastil.changeColor(color);
   mastil.changeSize(70, 14);
   mastil.setPosition(204, 195);
   mastil.makeVisible();

   Circle cuerpo = new Circle();
   cuerpo.changeColor(color);
   cuerpo.changeSize(52);
   cuerpo.setPosition(185, 258);
   cuerpo.makeVisible();

   Square contornoMastil = new Square();
   contornoMastil.changeColor("white");
   contornoMastil.changeSize(60, 6);
   contornoMastil.setPosition(208, 200);
   contornoMastil.makeVisible();

   Circle contornoCuerpo = new Circle();
   contornoCuerpo.changeColor("white");
   contornoCuerpo.changeSize(36);
   contornoCuerpo.setPosition(193, 266);
   contornoCuerpo.makeVisible();

   dibujarMedallon(tipo, 211, 194, color);
}

private static void dibujarMedallon(Tipo tipo, int centroX, int centroY, String color) {
   Circle medallon = new Circle();
   medallon.changeColor(color);
   medallon.changeSize(34);
   medallon.setPosition(centroX - 17, centroY - 17);
   medallon.makeVisible();

   Circle interiorMedallon = new Circle();
   interiorMedallon.changeColor("white");
   interiorMedallon.changeSize(26);
   interiorMedallon.setPosition(centroX - 13, centroY - 13);
   interiorMedallon.makeVisible();

   dibujarSimbolo(tipo, centroX, centroY, color, TamanoSimbolo.COMPACTO);
}

private static void dibujarCorazonMedallon(int centroX, int centroY, String color) {
   Circle ladoIzquierdo = new Circle();
   ladoIzquierdo.changeColor(color);
   ladoIzquierdo.changeSize(8);
   ladoIzquierdo.setPosition(centroX - 7, centroY - 4);
   ladoIzquierdo.makeVisible();

   Circle ladoDerecho = new Circle();
   ladoDerecho.changeColor(color);
   ladoDerecho.changeSize(8);
   ladoDerecho.setPosition(centroX - 1, centroY - 4);
   ladoDerecho.makeVisible();

   Triangle punta = new Triangle();
   punta.changeColor(color);
   punta.rotate();
   punta.rotate();
   punta.changeSize(7, 12);
   punta.setPosition(centroX, centroY + 1);
   punta.makeVisible();
}

private static void dibujarDiamanteMedallon(int centroX, int centroY, String color) {
   Triangle parteSuperior = new Triangle();
   parteSuperior.changeColor(color);
   parteSuperior.changeSize(6, 14);
   parteSuperior.setPosition(centroX, centroY - 6);
   parteSuperior.makeVisible();

   Triangle parteInferior = new Triangle();
   parteInferior.changeColor(color);
   parteInferior.rotate();
   parteInferior.rotate();
   parteInferior.changeSize(6, 14);
   parteInferior.setPosition(centroX, centroY);
   parteInferior.makeVisible();
}

private static void dibujarEspadaMedallon(int centroX, int centroY, String color) {
   Square hoja = new Square();
   hoja.changeColor(color);
   hoja.changeSize(14, 3);
   hoja.setPosition(centroX - 1, centroY - 9);
   hoja.makeVisible();

   Square guarda = new Square();
   guarda.changeColor(color);
   guarda.changeSize(2, 10);
   guarda.setPosition(centroX - 5, centroY + 5);
   guarda.makeVisible();

   Square empunadura = new Square();
   empunadura.changeColor(color);
   empunadura.changeSize(5, 2);
   empunadura.setPosition(centroX - 1, centroY + 7);
   empunadura.makeVisible();
}

private static void dibujarTrebolMedallon(int centroX, int centroY, String color) {
   Circle ladoIzquierdo = new Circle();
   ladoIzquierdo.changeColor(color);
   ladoIzquierdo.changeSize(8);
   ladoIzquierdo.setPosition(centroX - 7, centroY - 4);
   ladoIzquierdo.makeVisible();

   Circle ladoDerecho = new Circle();
   ladoDerecho.changeColor(color);
   ladoDerecho.changeSize(8);
   ladoDerecho.setPosition(centroX - 1, centroY - 4);
   ladoDerecho.makeVisible();

   Circle parteInferior = new Circle();
   parteInferior.changeColor(color);
   parteInferior.changeSize(8);
   parteInferior.setPosition(centroX - 4, centroY - 10);
   parteInferior.makeVisible();

   Triangle tallo = new Triangle();
   tallo.changeColor(color);
   tallo.changeSize(7, 5);
   tallo.setPosition(centroX, centroY + 1);
   tallo.makeVisible();
}

private static void dibujarFaldaQ(String color) {
   Triangle falda = new Triangle();
   falda.changeColor(color);
   falda.changeSize(25, 38);
   falda.setPosition(250, 285);
   falda.makeVisible();
}

private static void dibujarCorona(String color, Tipo tipo) {
   Square banda = new Square();
   banda.changeColor(color);
   banda.changeSize(8, 45);
   banda.setPosition(228, 210);
   banda.makeVisible();

   int[] posiciones = {238, 250, 262};
   for (int posicion : posiciones) {
      Triangle punta = new Triangle();
      punta.changeColor(color);
      punta.changeSize(18, 11);
      punta.setPosition(posicion, 192);
      punta.makeVisible();
   }

   if (tipo != null) {
      dibujarMedallon(tipo, 250, 196, color);
   }
}

private static void dibujarBaculoK(String color, Tipo tipo) {
   Square baston = new Square();
   baston.changeColor(color);
   baston.changeSize(115, 7);
   baston.setPosition(215, 185);
   baston.makeVisible();

   Circle remate = new Circle();
   remate.changeColor(color);
   remate.changeSize(45);
   remate.setPosition(196, 147);
   remate.makeVisible();

   Circle centroRemate = new Circle();
   centroRemate.changeColor("white");
   centroRemate.changeSize(35);
   centroRemate.setPosition(201, 152);
   centroRemate.makeVisible();

   dibujarSimbolo(tipo, 219, 169, color, TamanoSimbolo.COMPACTO);
}

}