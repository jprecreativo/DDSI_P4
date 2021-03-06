package controlador;

import vista.Colaborar;
import vista.Consultar;
import vista.G_Colaboraciones;
import vista.G_Completa;
import vista.InsertarExperto;

/**
 * Clase encargada de crear las distintas pantallas de la aplicación siguiendo el patrón 'Factory'.
 * @author jprecreativo
 */
public abstract class Factory 
{
    public static conexionOracle co;
    private static Colaborar colaborar = null;
    private static Consultar consultar = null;
    private static InsertarExperto insertar = null;
    private static G_Colaboraciones g_colaboraciones = null;
    private static G_Completa g_completa = null;
    
    /***
     * Instanciará una ventana que se hará visible. Si ya existe esa ventana, previamente se cierra para volverla a abrir.
     * @param screen Dependiendo de su valor, se creará una pantalla u otra.
     */
    public static void factoryMethod(String screen)
    {
        switch(screen)
        {
            case "Colaborar":
                                    if(colaborar != null)
                                        colaborar.dispose();

                                    colaborar = new Colaborar(Factory.co);

                                    break;
                                
            case "Consultar":
                                    if(consultar != null)
                                        consultar.dispose();

                                    consultar = new Consultar();

                                    break;
                                
            case "Insertar":
                                    if(insertar != null)
                                        insertar.dispose();

                                    insertar = new InsertarExperto();

                                    break;
                                
            case "G_Colaboraciones":
                                    if(g_colaboraciones != null)
                                        g_colaboraciones.dispose();
                                    
                                    g_colaboraciones = new G_Colaboraciones();
                                    
                                    break;
                                    
            case "G_Completa":
                                    if(g_completa != null)
                                        g_completa.dispose();
                                    
                                    g_completa = new G_Completa(Factory.co);
        }    
    }
}
