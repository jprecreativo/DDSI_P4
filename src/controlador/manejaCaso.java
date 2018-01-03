package controlador;

import modelo.caso;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class manejaCaso {
    
    // Crea un PreparedStatement como atributo de la clase manejaExperto para
    // utilizarlo en los diferentes métodos
    PreparedStatement ps = null;
	 
     /**
    *  Comprueba si existe un caso en la tabla de CASO_POLICIAL dado un código de caso
    * @param codCaso código del caso a buscar
     * @return 
    * @throws SQLException si ocurre alguna anomalía
    */
    public boolean existeCaso(String codCaso) throws SQLException 
    {
        ps = conexionOracle.co.prepareStatement("SELECT * FROM CASO_POLICIAL WHERE CODCASO = ?");
        
        ps.setString(1, codCaso);
        
        ResultSet caso = ps.executeQuery();
        
        return caso.next();
    }
    
     /**
    *  Inserta caso en la tabla de CASO_POLICIAL
    * @param cs caso a insertar
     * @return 
    * @throws SQLException si ocurre alguna anomalía
    */
    public boolean insertaCaso (caso cs) throws SQLException  
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
}

	 


