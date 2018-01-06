package controlador;

import modelo.caso;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/***
 * Clase encargada de controlar las operaciones de la BD relativas a los casos.
 * @author jprecreativo
 */
public class manejaCaso 
{
    PreparedStatement ps = null;
	 
     /***
      * Comprueba si existe un caso en la tabla de CASO_POLICIAL dado un código de caso.
      * @param codCaso Código del caso a buscar.
      * @return El caso, si existe, o null si el caso no existe.
      * @throws SQLException Si ocurre alguna anomalía.
      */
    public caso existeCaso(String codCaso) throws SQLException 
    {
        ps = conexionOracle.co.prepareStatement("SELECT * FROM CASO_POLICIAL WHERE CODCASO = ?");
        
        ps.setString(1, codCaso);
        
        ResultSet rs = ps.executeQuery();
        
        if(rs.next())
            return (new caso(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)));
        
        return null;
    }
    
     /***
      * Inserta un caso en la tabla de CASO_POLICIAL.
      * @param cs Caso a insertar.
      * @return TRUE si se ha insertado el caso, FALSE en cualquier otro caso.
      * @throws SQLException Si ocurre alguna anomalía.
      */
    public boolean insertaCaso(caso cs) throws SQLException  
    {
        try 
        {
            if("".equals(cs.getFechaFin()))   // No hay fecha de fin.
            {
                ps = conexionOracle.co.prepareStatement("INSERT INTO CASO_POLICIAL (CODCASO, NOMBRE, FECHA_INICIO) "
                                                        + "VALUES (?, ?, ?)");

                ps.setString(1, cs.getCodCaso());
                ps.setString(2, cs.getNombre());
                ps.setDate(3, Date.valueOf(cs.getFechaInicio()));
            }
            
            else   // Hay fecha de fin.
            {
                ps = conexionOracle.co.prepareStatement("INSERT INTO CASO_POLICIAL VALUES (?, ?, ?, ?)");

                ps.setString(1, cs.getCodCaso());
                ps.setString(2, cs.getNombre());
                ps.setDate(3, Date.valueOf(cs.getFechaInicio()));
                ps.setDate(4, Date.valueOf(cs.getFechaFin()));
            }
            
            ps.executeUpdate();
            ps.close();

            return true;
        } 

        catch (SQLException e) 
        {
            System.out.println("Error: " + e.getMessage());

            return false;
        }
    }
    
    /**
     * Para obtener los casos.
     * @return Todos los casos de la BD.
     * @throws java.sql.SQLException Si hay algún problema.
     */
    public ArrayList<caso> obtenerCasos() throws SQLException
    {
        ps = conexionOracle.co.prepareStatement("SELECT * FROM CASO_POLICIAL");
        
        ResultSet rs = ps.executeQuery();
        ArrayList<caso> casos = new ArrayList();
        
        while(rs.next())
        {
            caso c =  new caso(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
            
            casos.add(c);
        }
        
        ps.close();
        
        return casos;
    }
    
    /***
     * Elimina un caso de la BD.
     * @param codCaso Código del caso a eliminar.
     * @throws SQLException Se lanzará si algún problema con la eliminación.
     */
    public void eliminarCaso(String codCaso) throws SQLException
    {
        ps = conexionOracle.co.prepareStatement("DELETE FROM CASO_POLICIAL WHERE CODCASO = ?");
        
        ps.setString(1, codCaso);
        ps.executeUpdate();
        ps.close();
    }
}

	 


