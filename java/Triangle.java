import java.awt.*;

/**
 * A triangle that can be manipulated and that draws itself on a canvas.
 * 
 * @author  Michael Kölling and David J. Barnes
 * @version 2016.02.29
 */

public class Triangle
{
    private int height;
    private int width;
    private int xPosition;
    private int yPosition;
    private String color;
    private boolean isVisible;
    private int orientacion;

    /**
     * Create a new triangle at default position with default color.
     */
    public Triangle()
    {
        orientacion = 0;
        height = 60;
        width = 70;
        xPosition = 250;
        yPosition = 250;
        color = "green";
        isVisible = false;
    }




    /**
     * Rotate the triangle 90 degrees clockwise.
     */
    public void rotate()
    {
        erase();
        orientacion = (orientacion + 1) % 4;
        draw();
    }




    /**
     * Make this triangle visible. If it was already visible, do nothing.
     */
    public void makeVisible()
    {
        isVisible = true;
        draw();
    }
    
    /**
     * Make this triangle invisible. If it was already invisible, do nothing.
     */
    public void makeInvisible()
    {
        erase();
        isVisible = false;
    }
    
    /**
     * Move the triangle a few pixels to the right.
     */
    public void moveRight()
    {
        moveHorizontal(20);
    }

    /**
     * Move the triangle a few pixels to the left.
     */
    public void moveLeft()
    {
        moveHorizontal(-20);
    }

    /**
     * Move the triangle a few pixels up.
     */
    public void moveUp()
    {
        moveVertical(-20);
    }

    /**
     * Move the triangle a few pixels down.
     */
    public void moveDown()
    {
        moveVertical(20);
    }

    /**
     * Move the triangle horizontally by 'distance' pixels.
     */
    public void moveHorizontal(int distance)
    {
        erase();
        xPosition += distance;
        draw();
    }

    /**
     * Move the triangle vertically by 'distance' pixels.
     */
    public void moveVertical(int distance)
    {
        erase();
        yPosition += distance;
        draw();
    }

    public void setPosition(int newX, int newY)
    {
        erase();
        xPosition = newX;
        yPosition = newY;
        draw();
    }

    /**
     * Slowly move the triangle horizontally by 'distance' pixels.
     */
    public void slowMoveHorizontal(int distance)
    {
        int delta;

        if(distance < 0) 
        {
            delta = -1;
            distance = -distance;
        }
        else 
        {
            delta = 1;
        }

        for(int i = 0; i < distance; i++)
        {
            xPosition += delta;
            draw();
        }
    }

    /**
     * Slowly move the triangle vertically by 'distance' pixels.
     */
    public void slowMoveVertical(int distance)
    {
        int delta;

        if(distance < 0) 
        {
            delta = -1;
            distance = -distance;
        }
        else 
        {
            delta = 1;
        }

        for(int i = 0; i < distance; i++)
        {
            yPosition += delta;
            draw();
        }
    }

    /**
     * Change the size to the new size (in pixels). Size must be >= 0.
     */
    public void changeSize(int newHeight, int newWidth)
    {
        erase();
        height = newHeight;
        width = newWidth;
        draw();
    }

    /**
     * Change the color. Valid colors are "red", "yellow", "blue", "green",
     * "magenta" and "black".
     */
    public void changeColor(String newColor)
    {
        color = newColor;
        draw();
    }

    /**
     * Draw the triangle with current specifications on screen.
     */
  private void draw()
    {
        if(isVisible) {
            Canvas canvas = Canvas.getCanvas();
            int[] xpoints = new int[3];
            int[] ypoints = new int[3];
            
            switch(orientacion) {
                case 0: // Apunta hacia Arriba
                    xpoints = new int[] { xPosition, xPosition + (width/2), xPosition - (width/2) };
                    ypoints = new int[] { yPosition, yPosition + height, yPosition + height };
                    break;
                case 1: // Apunta hacia la Derecha
                    xpoints = new int[] { xPosition + height, xPosition, xPosition };
                    ypoints = new int[] { yPosition + (width/2), yPosition + width, yPosition };
                    break;
                case 2: // Apunta hacia Abajo
                    xpoints = new int[] { xPosition, xPosition - (width/2), xPosition + (width/2) };
                    ypoints = new int[] { yPosition + height, yPosition, yPosition };
                    break;
                case 3: // Apunta hacia la Izquierda
                    xpoints = new int[] { xPosition - height, xPosition, xPosition };
                    ypoints = new int[] { yPosition + (width/2), yPosition, yPosition + width };
                    break;
            }
            
            canvas.draw(this, color, new Polygon(xpoints, ypoints, 3));
            canvas.wait(10);
        }
    }

    /**
     * Erase the triangle on screen.
     */
    private void erase()
    {
        if(isVisible) {
            Canvas canvas = Canvas.getCanvas();
            canvas.erase(this);
        }
    }
}
