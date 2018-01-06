package controlador;

import java.sql.CallableStatement;
import modelo.colabora;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import oracle.jdbc.OracleTypes;

/***
 * Clase encargada de controlar las operaciones SQL relativas a las colaboraciones.
 * @author jprecreativo
 */
public class manejaColabora 
{
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

    /***
     * Utilizando un procedimiento almacenado en la BD, devuelve todas las colaboraciones de un caso en concreto.
     * @param codCaso Código del caso del que se quieren saber las colaboraciones.
     * @return Un ResultSet con la colaboraciones del caso especificado.
     * @throws SQLException Se lanzará si hay algún problema al llamar al procedimiento almacenado.
     */
    public ResultSet listaColaboradoresPorCaso(String codCaso) throws SQLException
    {
        CallableStatement pColaboradoresCaso = conexionOracle.co.prepareCall("{CALL pColaboradoresCaso(?,?)}");
        
        pColaboradoresCaso.setString(1, codCaso);
        pColaboradoresCaso.registerOutParameter(2, OracleTypes.CURSOR);
        pColaboradoresCaso.executeUpdate();
        
        return ((ResultSet) pColaboradoresCaso.getObject(2));
    }
   
     /***
      * Comprueba si existe una colaboración en la tabla COLABORA.
      * @param codExperto Código del experto de la colaboración.
      * @param codCaso Código del caso de la colaboración.
      * @param fecha Fecha de la colaboración
      * @return TRUE si existe la colaboración, FALSE en caso contrario.
      * @throws SQLException Si ocurre alguna anomalía,
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
    
     /***
      * Inserta una colaboración en la tabla COLABORA.
      * @param col Objeto 'colabora' con los datos de la colaboración a insertar.
      * @return TRUE si se ha conseguido insertar la colaboración, FALSE si no.
      * @throws SQLException Si ocurre alguna anomalía.
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
     * @param fecha Fecha de la colaboración a eliminar.
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
