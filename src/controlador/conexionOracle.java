package controlador;

import java.sql.*;

/***
 * Clase cuyo cometido es el manejo de la conexión con la BD Orcale y el control de las transacciones.
 * @author jprecreativo
 */
public class conexionOracle 
{
    protected static Connection co = null;
    
    /***
     * Establece la conexión con el servidor.
     * @param username Nombre de usuario.
     * @param pass Contraseña.
     * @throws java.lang.ClassNotFoundException Se lanzará si hay algún problema con el driver de JDBC.
     * @throws java.sql.SQLException Se lanzará si no se puede hacer el login por algún motivo en concreto.
     */
    public conexionOracle(String username, String pass) throws ClassNotFoundException, SQLException 
    {
        Class.forName("oracle.jdbc.OracleDriver");
        
        co = DriverManager.getConnection("jdbc:oracle:thin:@172.17.20.75:1521:rabida", username, pass); 
    }  
    
    /***
     * Implementa la desconexión con el servidor.
     * @throws SQLException Si ocurre cualquier anormalidad.
     */
    public void desconexion() throws SQLException 
    {    
        co.close();
    }
    
    /***  
     * Inicia una transacción
     * @throws SQLException Si ocurre cualquier anormalidad.
     */
    public void inicioTransaccion() throws SQLException 
    {
        try 
        {
            co.setAutoCommit(false);
        } 
        
        catch (SQLException e) 
        {
            System.out.println("Error: " + e.getMessage());
        }
        
        finally
        {
            co.setAutoCommit(true);
        }
    }
    
    /*** 
     *  Finaliza una transacción con commit.
     * @throws SQLException si ocurre cualquier anormalidad
     */			
    public void finTransaccionCommit() throws SQLException 
    {
       conexionOracle.co.commit();
    }
    
    /***  
     * Finaliza una transacción con rollback
     * @throws SQLException si ocurre cualquier anormalidad
     */			
    public void finTransaccionRollback() throws SQLException 
    {
        conexionOracle.co.rollback();
    }

}
