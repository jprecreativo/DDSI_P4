package modelo;

/***
 * Clase que se corresponde con la tabla 'COLABORA' de la BD.
 * @author jprecreativo
 */
public class colabora 
{
    private String codExperto;
    private String codCaso;
    private String fecha;
    private String descripcionColaboracion;
	
    public colabora(String ce, String cc, String f, String dc) 
    {
	codExperto = ce;
        codCaso = cc;
        fecha = f;
        descripcionColaboracion = dc;
    }

    public String getCodExperto() 
    {
        return codExperto;
    }

    public void setCodExperto(String codExperto) 
    {
        this.codExperto = codExperto;
    }

    public String getCodCaso() 
    {
        return codCaso;
    }

    public void setCodCaso(String codCaso) 
    {
        this.codCaso = codCaso;
    }

    public String getFecha() 
    {
        return fecha;
    }

    public void setFecha(String fecha) 
    {
        this.fecha = fecha;
    }

    public String getDescripcionColaboracion() 
    {
        return descripcionColaboracion;
    }

    public void setDescripcionColaboracion(String descripcionColaboracion) 
    {
        this.descripcionColaboracion = descripcionColaboracion;
    }
}
