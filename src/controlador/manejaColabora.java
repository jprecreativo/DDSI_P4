package controlador;

import java.sql.CallableStatement;
import modelo.colabora;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import oracle.jdbc.OracleTypes;

public class manejaColabora 
{
    // Creamos un PreparedStatement como atributo de la clase manejaExperto para
    // utilizarlo en los diferentes métodos
    PreparedStatement ps = null;
    
    /**
     * Para obetener las colaboraciones.
     * @return Todas las colaboraciones de la BD.
     * @throws java.sql.SQLException Se lanzará si hay algún problema.
     */
    public ArrayList<colabora> obtenerColaboraciones() throws SQLException
    {
        ps = conexionOracle.co.prepareStatement("SELECT * FROM COLABORA");
        
        ResultSet rs = ps.executeQuery();
        ArrayList<colabora> colaboraciones = new ArrayList();
        
        while(rs.next())
        {
            colabora c =  new colabora(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
            
            colaboraciones.add(c);
        }
        
        ps.close();
        
        return colaboraciones;
    }

    public ResultSet listaColaboradoresPorCaso(String codCaso) throws SQLException
    {
        CallableStatement pColaboradoresCaso = conexionOracle.co.prepareCall("{CALL pColaboradoresCaso(?,?)}");
        
        pColaboradoresCaso.setString(1, codCaso);
        pColaboradoresCaso.registerOutParameter(2, OracleTypes.CURSOR);
        pColaboradoresCaso.executeUpdate();
        
        return ((ResultSet) pColaboradoresCaso.getObject(2));
    }
   
     /**
    * Comprueba si existe una colaboración en la tabla de COLABORA dado su código
    * @param codExperto, codCaso caso
     * @param codCaso
     * @param fecha
     * @return 
    * @throws SQLException si ocurre alguna anomalía
    */
    public boolean existeColaboracion(String codExperto, String codCaso, String fecha) throws SQLException 
    {
        ps = conexionOracle.co.prepareStatement("SELECT * FROM COLABORA WHERE CODEXPERTO = ? AND CODCASO = ? AND FECHA = ?");
        
        ps.setString(1, codExperto);
        ps.setString(2, codCaso);
        ps.setDate(3, Date.valueOf(fecha));
        
        ResultSet colaboración = ps.executeQuery();
        
        return colaboración.next();
    }
    
     /**
    * Inserta una colaboración en la tabla COLABORA
     * @param col
     * @return 
    * @throws SQLException si ocurre alguna anomalía
    */
    public boolean insertaColaboracion(colabora col) throws SQLException 
    {
        try 
        {
            ps = conexionOracle.co.prepareStatement("INSERT INTO COLABORA VALUES (?, ?, ?, ?)");

            ps.setString(1, col.getCodExperto());
            ps.setString(2, col.getCodCaso());
            ps.setDate(3, Date.valueOf(col.getFecha()));
            ps.setString(4, col.getDescripcionColaboracion());
            
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
    
    /***
     * Borra una colaboración de la BD.
     * @param codExperto Experto de la colaboración a eliminar.
     * @param codCaso Caso de la colaboración a eliminar.
     * @param fecha
     * @throws SQLException Se lanzará si ocurre alguna anomalía con la eliminación.
     */
    public void eliminarColaboración(String codExperto, String codCaso, String fecha) throws SQLException
    {
        ps = conexionOracle.co.prepareStatement("DELETE FROM COLABORA WHERE CODEXPERTO = ? AND CODCASO = ? AND FECHA = ?");
        
        ps.setString(1, codExperto);
        ps.setString(2, codCaso);
        ps.setDate(3, Date.valueOf(fecha));
        
        ps.executeUpdate();
        ps.close();
    }
}
