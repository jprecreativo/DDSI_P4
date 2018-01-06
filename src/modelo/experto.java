package modelo;

/***
 * Representa a la entidad 'EXPERTO'.
 * @author jprecreativo
 */
public class experto 
{
    private String codExperto;
    private String nombre;
    private String pais;
    private String sexo;
    private String especialidad;

    public experto(String c, String n, String p, String s, String e) 
    {
        codExperto = c;
        nombre = n;
        pais = p;
        sexo = s;
        especialidad = e;
    }		

    public String getCodExperto() 
    {
        return codExperto;
    }

    public String getNombre() 
    {
        return nombre;
    }

    public String getPais() 
    {
        return pais;
    }

    public String getSexo() 
    {
        return sexo;
    }

    public String getEspecialidad() 
    {
        return especialidad;
    }

    public void setCodExperto(String c) 
    {
        codExperto = c;
    }

    public void setNombre(String n) 
    {
        nombre = n;
    }

    public void setPais(String p) 
    {
        pais = p;
    }

    public void setSexo(String s) 
    {
        sexo = s;
    }

    public void setEspecialidad(String e) 
    {
        especialidad = e;
    }
}