package controlador;

import modelo.experto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/***
 * Clase que maneja todas las operaciones relativas a la tabla EXPERTO de la BD.
 * @author jprecreativo
 */
public class manejaExperto 
{
    PreparedStatement ps = null;
    
    /***
     * Valiéndose de una función almacenada en la BD, devuelve cuantos expertos hay del sexo especificado.
     * @param s Sexo de los expertos que se quieren contar.
     * @return El número de expertos del sexo especificado.
     * @throws java.sql.SQLException Si se especifica mal el sexo o hay algún otro problema con la función.
     */
    public int sexoExperto(String s) throws SQLException
    {
        /* CallableStatement fSexoExperto = conexionOracle.co.prepareCall("{ ? = CALL FSEXOEXPERTO(?) }");
        
        fSexoExperto.setString(2, s);
        fSexoExperto.registerOutParameter(1, Types.NUMERIC);
        fSexoExperto.executeUpdate();
        
        return fSexoExperto.getInt(1); */
        
        ps = conexionOracle.co.prepareStatement("SELECT FSEXOEXPERTO(?) FROM DUAL");
        
        ps.setString(1, s);
        
        ResultSet sexo = ps.executeQuery();

        sexo.next();
        
        return sexo.getInt(1);
    }
    
     /***
      * Devuelve una lista con todos los expertos cuyo país se pase por parámetro.
      * @param pais País de los expertos.
      * @throws SQLException Si ocurre alguna anomalía.
      * @return Un ArrayList de expertos cuyo país sea el del parámetro.
      */
    public ArrayList<experto> listaExpertosPorPais(String pais) throws SQLException 
    {
        if("...".equals(pais))
            ps = conexionOracle.co.prepareStatement("SELECT * FROM EXPERTO");
        
        else
        {
            ps = conexionOracle.co.prepareStatement("SELECT * FROM EXPERTO WHERE PAIS = ?");
            
            ps.setString(1, pais);
        }
       
        ResultSet rs = ps.executeQuery();
        ArrayList<experto> expertos = new ArrayList();
        
        while(rs.next())
        {
            experto e =  new experto(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
            
            expertos.add(e);
        }
        
        ps.close();
        
        return expertos;
    }    
    /***
     * Comprueba si existe un experto.
     * @param codExperto Código del experto a comprobar.
     * @return Si existe el experto, devuelve sus datos en un objeto 'experto', si no devuelve null. 
     * @throws SQLException Si ocurre alguna anomalía.
     */
    public experto existeExperto(String codExperto) throws SQLException 
    {
        ps = conexionOracle.co.prepareStatement("SELECT * FROM EXPERTO WHERE CODEXPERTO = ?");
        
        ps.setString(1, codExperto);

        ResultSet rs = ps.executeQuery();
        
        if(rs.next())
        {
            experto e = new experto(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
            
            ps.close();
            
            return e;
        }
        
        ps.close();
        
        return null;
    }
    
    /***
     * Inserta un experto.
     * @param exp Objeto 'experto' a insertar.
     * @return TRUE si se ha conseguido insertar el experto, FALSE en caso contrario.
     */
    public boolean insertaExperto(experto exp)
    {
        try 
        {
            if("...".equals(exp.getSexo()))   // No se especifica sexo.
            {
                ps = conexionOracle.co.prepareStatement("INSERT INTO EXPERTO (CODEXPERTO, NOMBRE, PAIS, ESPECIALIDAD)"
                                                      + " VALUES (?, ?, ?, ?)");

                ps.setString(1, exp.getCodExperto());
                ps.setString(2, exp.getNombre());
                ps.setString(3, exp.getPais());
                ps.setString(4, exp.getEspecialidad());
            }
            
            else   // Se especifica sexo.
            {
                ps = conexionOracle.co.prepareStatement("INSERT INTO EXPERTO VALUES (?, ?, ?, ?, ?)");

                ps.setString(1, exp.getCodExperto());
                ps.setString(2, exp.getNombre());
                ps.setString(3, exp.getPais());
                ps.setString(4, exp.getSexo());
                ps.setString(5, exp.getEspecialidad());
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
    
    /***
     * Elimina un experto de la BD.
     * @param codExperto Código del experto a eliminar.
     * @throws java.sql.SQLException Se lenzará si algún problema con la eliminación.
     */
    public void eliminarExperto(String codExperto) throws SQLException
    {
        ps = conexionOracle.co.prepareStatement("DELETE FROM EXPERTO WHERE CODEXPERTO = ?");
      
        ps.setString(1, codExperto);
        ps.executeUpdate();
        ps.close();
    }
}