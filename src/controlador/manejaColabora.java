package controlador;

import java.sql.CallableStatement;
import modelo.colabora;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import oracle.jdbc.OracleTypes;

public class manejaColabora 
{
    // Creamos un PreparedStatement como atributo de la clase manejaExperto para
    // utilizarlo en los diferentes métodos
    PreparedStatement ps = null;

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
     * @return 
    * @throws SQLException si ocurre alguna anomalía
    */
    public boolean existeColaboracion(String codExperto, String codCaso) throws SQLException 
    {
        ps = conexionOracle.co.prepareStatement("SELECT * FROM COLABORA WHERE CODEXPERTO = ? AND CODCASO = ?");
        
        ps.setString(1, codExperto);
        ps.setString(2, codCaso);
        
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
}
