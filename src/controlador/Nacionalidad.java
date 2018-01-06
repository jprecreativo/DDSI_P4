package controlador;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import vista.Consultar;

/**
 * Clase encargada de actualizar los expertos que se muestran dependiendo de la nacionalidad.
 * @author jprecreativo
 */
public class Nacionalidad implements ItemListener
{
    /***
     * Cuando en alguna interfaz se cambie la nacionalidad de un JComboBox, refrescará la información de su tabla.
     * @param event Para saber que nacionalidad se ha establecido.
     */
    @Override
    public void itemStateChanged(ItemEvent event) 
    {
        if(event.getStateChange() == ItemEvent.SELECTED)
        {
            try 
            {
                Consultar.rellenarTabla(new manejaExperto().listaExpertosPorPais(event.getItem().toString()));
            } 
            
            catch (SQLException e) 
            {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
    
    /***
     * Obtiene las diferentes nacionalidades que hay en la BD.
     * @return Un ResultSet con las nacionalidades.
     * @throws SQLException Se lanzará si hay algún problema con la consulta SQL.
     */
    public static ResultSet obtenerNacionalidades() throws SQLException
    {
        return conexionOracle.co.createStatement().executeQuery("SELECT DISTINCT PAIS FROM EXPERTO");
    }
}
