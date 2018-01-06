package vista;

import javax.swing.JFrame;

/***
 * Clase abstracta de la cual heredan todas las pantallas de la aplicación.
 * @author jprecreativo
 */
public abstract class Screen extends JFrame 
{
    /***
     * Será llamado por la pantalla que se quiera instanciar.
     * @param width Ancho de la ventana.
     * @param height Alto de la ventana.
     * @param title Título de la ventana.
     */
    public void inicialize(int width, int height, String title)
    {
        this.setSize(width, height);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setTitle(title);
        this.setVisible(true);
        this.toFront();
    }
}
