package modelo;

/***
 * Objeto que representa la entidad 'CASO_POLICIAL' almacenada en la BD.
 * @author jprecreativo
 */
public class caso 
{
    private String codCaso;
    private String nombre;
    private String fechaInicio;
    private String fechaFin;
    
    public caso(String cc, String n, String fi, String ff) 
    {
	codCaso = cc;
        nombre = n;
        fechaInicio = fi;
        fechaFin = ff;
    }

    public String getCodCaso() 
    {
        return codCaso;
    }

    public void setCodCaso(String codCaso) 
    {
        this.codCaso = codCaso;
    }

    public String getNombre() 
    {
        return nombre;
    }

    public void setNombre(String nombre) 
    {
        this.nombre = nombre;
    }

    public String getFechaInicio() 
    {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) 
    {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFin()
    {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) 
    {
        this.fechaFin = fechaFin;
    }    
}
