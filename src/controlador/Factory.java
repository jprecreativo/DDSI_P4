package controlador;

import vista.Colaborar;
import vista.Consultar;
import vista.G_Colaboraciones;
import vista.InsertarExperto;

/**
 *
 * @author jprecreativo
 */
public abstract class Factory 
{
    public static conexionOracle co;
    private static Colaborar colaborar = null;
    private static Consultar consultar = null;
    private static InsertarExperto insertar = null;
    private static G_Colaboraciones g_colaboraciones = null;
    
    public static void factoryMethod(String screen, String codExperto)
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

                                    insertar = new InsertarExperto(Factory.co, codExperto);

                                    break;
                                
            case "G_Colaboraciones":
                                    if(g_colaboraciones != null)
                                        g_colaboraciones.dispose();
                                    
                                    g_colaboraciones = new G_Colaboraciones(Factory.co);
                                    
                                    break;
        }    
    }
}
