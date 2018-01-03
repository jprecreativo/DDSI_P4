package controlador;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import vista.Consultar;

/**
 *
 * @author jprecreativo
 */
public class Nacionalidad implements ItemListener
{
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
    
    public static ResultSet obtenerNacionalidades() throws SQLException
    {
        return conexionOracle.co.createStatement().executeQuery("SELECT DISTINCT PAIS FROM EXPERTO");
    }
}
