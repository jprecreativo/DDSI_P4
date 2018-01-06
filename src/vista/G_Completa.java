package vista;

import controlador.Nacionalidad;
import controlador.conexionOracle;
import controlador.manejaCaso;
import controlador.manejaColabora;
import controlador.manejaExperto;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.caso;
import modelo.colabora;
import modelo.experto;

/**
 * Pantalla que permite una gestión completa de la BD.
 * @author jprecreativo
 */
public class G_Completa extends Screen 
{
    private final conexionOracle co;
    
    public G_Completa(conexionOracle co) 
    {
        initComponents();
        
        this.co = co;
        jScrollPane1.getVerticalScrollBar().setUnitIncrement(16);
        
        super.inicialize(this.getWidth(), this.getHeight(), "Gestión completa");
        this.obtenerNacionalidades();
        this.mostrarDatos();
    }
    
    /***
     * Obtiene las diferentes nacionalidades de los expertos para ponerlas en 'cb_nacionalidad'.
     */
    private void obtenerNacionalidades()
    {
        try 
        {
            cb_nacionalidad.addItem("...");
            
            ResultSet nacionalidades = Nacionalidad.obtenerNacionalidades();
            
            while(nacionalidades.next())
                cb_nacionalidad.addItem(nacionalidades.getString(1));
        } 
        
        catch (SQLException e) 
        {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    /***
     * Muestra todos los expertos, casos y colaboraciones de la BD, en sus correspondientes tablas.
     */
    private void mostrarDatos()
    {
        try 
        {
            this.mostrarExpertos();
            this.mostrarCasos();
            this.mostrarColaboraciones();
        } 
        
        catch (SQLException e) 
        {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    /***
     * Limpia los datos de una tabla.
     * @param datos Modelo de la tabla a limpiar.
     */
    private void borrarDatos(DefaultTableModel datos)
    {
        if(datos.getRowCount() > 0)
            for(int i = datos.getRowCount() - 1; i >= 0; i--)
                datos.removeRow(i);
    }
    
    /***
     * Para obtener el modelo de alguna de las tablas de la ventana.
     * @param tabla Indica de qué tabla queremos el modelo.
     * @return El modelo de la tabla seleccionada.
     */
    private DefaultTableModel obtenerModelo(String tabla)
    {
        DefaultTableModel model;
        
        if("Expertos".equals(tabla))
            model = (DefaultTableModel) jt_Expertos.getModel();
        
        else if("Casos".equals(tabla))
            model = (DefaultTableModel) jt_Casos.getModel();
        
        else
            model = (DefaultTableModel) jt_Colaboraciones.getModel();
        
        this.borrarDatos(model);
        
        return model;
    }
    
    /***
     * Obtiene y muestra los expertos.
     * @throws SQLException Si hay algún problema al obtener los expertos de la BD.
     */
    private void mostrarExpertos() throws SQLException
    {
        DefaultTableModel tablaExpertos = this.obtenerModelo("Expertos");
        ArrayList<experto> expertos = new manejaExperto().listaExpertosPorPais("...");
        
        expertos.stream().forEach((e) -> tablaExpertos.addRow(new Object[] {e.getCodExperto(),
                                                                    e.getNombre(),
                                                                    e.getPais(),
                                                                    e.getSexo(),
                                                                    e.getEspecialidad()}));
    }
    
    /***
     * Obtiene y muestra los casos.
     * @throws SQLException Si hay algún problema al obtener los casos de la BD.
     */
    private void mostrarCasos() throws SQLException
    {
        DefaultTableModel tablaCasos = this.obtenerModelo("Casos");
        ArrayList<caso> casos = new manejaCaso().obtenerCasos();
        
        casos.forEach((c) -> {
            if(null == c.getFechaFin())
                tablaCasos.addRow(new Object[] {c.getCodCaso(), c.getNombre(), c.getFechaInicio().split(" ")[0], ""});
        
            else
                tablaCasos.addRow(new Object[] {c.getCodCaso(), c.getNombre(), c.getFechaInicio().split(" ")[0], c.getFechaFin().split(" ")[0]});
        });
    }
    
    /***
     * Obtiene y muestra las colaboraciones.
     * @throws SQLException Si hay algún problema al obtener las colaboraciones de la BD.
     */
    private void mostrarColaboraciones() throws SQLException
    {
        DefaultTableModel tablaColaboraciones = this.obtenerModelo("Colaboraciones");
        ArrayList<colabora> colaboraciones = new manejaColabora().obtenerColaboraciones();
        
        colaboraciones.stream().forEach((c) -> tablaColaboraciones.addRow(new Object[] {c.getCodExperto(),
                                                                                        c.getCodCaso(),
                                                                                        c.getFecha().split(" ")[0],
                                                                                        c.getDescripcionColaboracion()}));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bt_Refrescar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tf_codExperto = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tf_nombreExperto = new javax.swing.JTextField();
        cb_nacionalidad = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cb_sexo = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        tf_especialidad = new javax.swing.JTextField();
        bt_insertarExperto = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jt_Expertos = new javax.swing.JTable();
        bt_eliminarExperto = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        tf_nombreCaso = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        dc_fechaIni = new com.toedter.calendar.JDateChooser();
        dc_fechaFin = new com.toedter.calendar.JDateChooser();
        jLabel7 = new javax.swing.JLabel();
        tf_codCaso = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jt_Casos = new javax.swing.JTable();
        bt_eliminarCaso = new javax.swing.JButton();
        bt_insertarCaso = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        tf_codExpertoCol = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jt_Colaboraciones = new javax.swing.JTable();
        jLabel14 = new javax.swing.JLabel();
        tf_codCasoCol = new javax.swing.JTextField();
        dc_fecha = new com.toedter.calendar.JDateChooser();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        tf_des = new javax.swing.JTextField();
        bt_insertarColaborar = new javax.swing.JButton();
        bt_eliminarColaborar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        bt_Refrescar.setText("Refrescar");
        bt_Refrescar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_RefrescarActionPerformed(evt);
            }
        });

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setText("Código:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Experto");

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setText("Nombre:");

        cb_nacionalidad.setEditable(true);

        jLabel4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel4.setText("País:");

        jLabel5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel5.setText("Sexo:");

        cb_sexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "...", "F", "M" }));

        jLabel6.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel6.setText("Especialidad:");

        bt_insertarExperto.setText("Insertar experto");
        bt_insertarExperto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_insertarExpertoActionPerformed(evt);
            }
        });

        jt_Expertos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CÓDIGO", "NOMBRE", "PAÍS", "SEXO", "ESPECIALIDAD"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jt_Expertos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jt_ExpertosMouseReleased(evt);
            }
        });
        jScrollPane2.setViewportView(jt_Expertos);

        bt_eliminarExperto.setText("Eliminar experto");
        bt_eliminarExperto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_eliminarExpertoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(326, 326, 326)
                        .addComponent(jLabel2))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(tf_nombreExperto, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(tf_codExperto, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cb_nacionalidad, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(cb_sexo, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(tf_especialidad, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(84, 84, 84)
                                .addComponent(bt_insertarExperto)
                                .addGap(229, 229, 229)
                                .addComponent(bt_eliminarExperto)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(tf_codExperto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(tf_nombreExperto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(cb_nacionalidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(cb_sexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(tf_especialidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt_insertarExperto)
                    .addComponent(bt_eliminarExperto))
                .addGap(262, 262, 262))
        );

        jLabel9.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel9.setText("Nombre:");

        jLabel10.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel10.setText("Fecha de inicio:");

        jLabel11.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel11.setText("Fecha de fin:");

        dc_fechaIni.setDateFormatString("dd/MM/yyyy");

        dc_fechaFin.setDateFormatString("dd/MM/yyyy");

        jLabel7.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel7.setText("Código del caso:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Caso");

        jt_Casos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CÓDIGO", "NOMBRE", "FECHA_INICIO", "FECHA_FIN"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jt_Casos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jt_CasosMouseReleased(evt);
            }
        });
        jScrollPane3.setViewportView(jt_Casos);

        bt_eliminarCaso.setText("Eliminar caso");
        bt_eliminarCaso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_eliminarCasoActionPerformed(evt);
            }
        });

        bt_insertarCaso.setText("Insertar caso");
        bt_insertarCaso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_insertarCasoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tf_codCaso, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tf_nombreCaso, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dc_fechaIni, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dc_fechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addComponent(jLabel8)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(91, 91, 91)
                .addComponent(bt_insertarCaso)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bt_eliminarCaso)
                .addGap(169, 169, 169))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(tf_codCaso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(tf_nombreCaso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(dc_fechaIni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(dc_fechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt_eliminarCaso)
                    .addComponent(bt_insertarCaso))
                .addContainerGap())
        );

        jLabel12.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel12.setText("Código del experto:");

        tf_codExpertoCol.setEditable(false);
        tf_codExpertoCol.setFocusable(false);

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel13.setText("Colaboraciones");

        jt_Colaboraciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "COD_EXP", "COD_CASO", "FECHA", "DESCRIPCIÓN"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(jt_Colaboraciones);

        jLabel14.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel14.setText("Código del caso:");

        tf_codCasoCol.setEditable(false);
        tf_codCasoCol.setFocusable(false);

        dc_fecha.setDateFormatString("dd/MM/yyyy");

        jLabel15.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel15.setText("Fecha:");

        jLabel16.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel16.setText("Descripción:");

        bt_insertarColaborar.setText("Insertar colaboración");
        bt_insertarColaborar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_insertarColaborarActionPerformed(evt);
            }
        });

        bt_eliminarColaborar.setText("Eliminar colaboración");
        bt_eliminarColaborar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_eliminarColaborarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(307, 307, 307)
                        .addComponent(jLabel13)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tf_codExpertoCol, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tf_codCasoCol, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dc_fecha, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel16)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tf_des, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(86, 86, 86)
                .addComponent(bt_insertarColaborar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bt_eliminarColaborar)
                .addGap(155, 155, 155))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(tf_codExpertoCol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(tf_codCasoCol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15)
                            .addComponent(dc_fecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(tf_des, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt_insertarColaborar)
                    .addComponent(bt_eliminarColaborar))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(338, 338, 338)
                .addComponent(bt_Refrescar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 730, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bt_Refrescar)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bt_insertarExpertoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_insertarExpertoActionPerformed
        
        experto ex = new experto(tf_codExperto.getText(),
                                 tf_nombreExperto.getText(),
                                 cb_nacionalidad.getSelectedItem().toString(),
                                 cb_sexo.getSelectedItem().toString(),
                                 tf_especialidad.getText());
        
        
        if(new manejaExperto().insertaExperto(ex))
            JOptionPane.showMessageDialog(this, "Experto insertado con éxito.", "Inserción realizada", JOptionPane.INFORMATION_MESSAGE);
        
        else
            JOptionPane.showMessageDialog(this, "Ocurrió un error, no se insertó el experto.", "Error", JOptionPane.ERROR_MESSAGE);
    }//GEN-LAST:event_bt_insertarExpertoActionPerformed

    /***
     * Inserta un caso.
     * @param fechaFin Será la fecha de fin del caso o un String vacío si no hay fecha de fin.
     */
    private void insertarCaso(String fechaFin)
    {
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        
        caso c = new caso(tf_codCaso.getText(), 
                          tf_nombreCaso.getText(), 
                          formato.format(dc_fechaIni.getDate()), 
                          fechaFin);
        
        try 
        {
            if(new manejaCaso().insertaCaso(c))
                JOptionPane.showMessageDialog(this, "Caso insertado correctamente.", "Inserción realizada", JOptionPane.INFORMATION_MESSAGE);
                
            else
                JOptionPane.showMessageDialog(this, "El caso ya existe.", "Error", JOptionPane.ERROR_MESSAGE);
        } 
        
        catch (SQLException e) 
        {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    /***
     * Se llamará al presionar el botón de insertar un caso. Comprueba si el caso tiene fecha de fin o no y llama al
     * método insertarCaso para realizar la inserción.
     * @param evt NOT_USED.
     */
    private void bt_insertarCasoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_insertarCasoActionPerformed
        
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        
        if(dc_fechaFin.getDate() != null)
        {
            if(this.comprobarFechaCaso())
                this.insertarCaso(formato.format(dc_fechaFin.getDate()));
            
            else
                JOptionPane.showMessageDialog(this, "La fecha de fin ha de mayor o igual a la de comienzo.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        else
            this.insertarCaso("");
    }//GEN-LAST:event_bt_insertarCasoActionPerformed

    /***
     * Comprueba que la fecha de inicio de un caso no se mayor a la de fin. 
     * @return TRUE si la fecha de inicio es menor o igual a la de fin, FALSE en caso contrario.
     */
    private boolean comprobarFechaCaso()
    {
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        String fechaIni = formato.format(dc_fechaIni.getDate());
        String fechaFin = formato.format(dc_fechaFin.getDate());
        
        return !(fechaIni.compareTo(fechaFin) > 0);
    }
    
    /***
     * Intenta insertar una nueva colaboración.
     * @param codExperto Código del experto de la colaboración.
     * @param codCaso Código del caso de la colaboración.
     * @return TRUE si se ha insertado la colaboración, FALSE en cualquier otro caso.
     * @throws ParseException Se lanzará si no se puede "parsear" alguna fecha.
     */
    private boolean insertarColaboración(String codExperto, String codCaso) throws ParseException
    {
        if(this.comprobarFechaColabora())
        {
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
            String fecha = formato.format(dc_fecha.getDate());
            colabora c = new colabora(codExperto, codCaso, fecha, tf_des.getText());

            try 
            {
                new manejaColabora().insertaColaboracion(c);
                
                return true;
            } 

            catch (SQLException e) 
            {
                JOptionPane.showMessageDialog(this, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                
                return false;
            }
        }       

        else
        {
            JOptionPane.showMessageDialog(this, "Hay algún error con las fechas.", "Error", JOptionPane.ERROR_MESSAGE);
            
            return false;
        }
    }
    
    /***
     * Comprueba si la colaboración que se pretende insertar ya existe en la BD.
     * @param codExperto Código del experto de la colaboración.
     * @param codCaso Código del caso de la colaboración.
     * @param fecha Fecha de la colaboración.
     * @return TRUE si no existe la colaboración y se ha logrado insertar, FALSE en cualquier otro caso.
     * @throws SQLException Si hay algún problema al comprobar si existe la colaboración.
     * @throws ParseException Se lanzará si no se puede "parsear" alguna fecha.
     */
    private boolean colaboraciónInsertada(String codExperto, String codCaso, String fecha) throws SQLException, ParseException
    {
        manejaColabora mc = new manejaColabora();
        
        if(!mc.existeColaboracion(codExperto, codCaso, fecha))
            return (this.insertarColaboración(codExperto, codCaso));
        
        else
        {
            JOptionPane.showMessageDialog(this, "Ya existe la colaboración.", "Colaboración no insertada", JOptionPane.ERROR_MESSAGE);
            
            return false;
        }
    }
    
    /***
     * Ejecuta las sentencias necesarias para insertar una colaboración. Será llamado al pulsar el botón correspondiente.
     * @param evt NOT_USED.
     */
    private void bt_insertarColaborarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_insertarColaborarActionPerformed
        
        String codExperto = tf_codExpertoCol.getText();
        String codCaso = tf_codCasoCol.getText();
        
        if("".equals(codExperto) || "".equals(codCaso))
            JOptionPane.showMessageDialog(this, "Selecciona un experto y un caso.", "Información faltante", JOptionPane.QUESTION_MESSAGE);
        
        else
        {
            try 
            {
                SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
                String fecha = formato.format(dc_fecha.getDate());
                
                co.inicioTransaccion();
                
                boolean inserciónRealizada = this.colaboraciónInsertada(codExperto, codCaso, fecha);
                
                co.finTransaccionCommit();
                
                if(inserciónRealizada)
                    JOptionPane.showMessageDialog(this, "Colaboración insertada.", "Inserción realizada", JOptionPane.INFORMATION_MESSAGE);
            } 
            
            catch (SQLException | ParseException e1) 
            {
                try 
                {
                    co.finTransaccionRollback();
                } 
                
                catch (SQLException e2) 
                {
                    System.out.println("Error: " + e2.getMessage());
                }
                
                JOptionPane.showMessageDialog(this, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_bt_insertarColaborarActionPerformed

    /***
     * Comprueba que la fecha de una colaboración esté comprendida entre las fechas de inicio y fin del caso seleccionado.
     * @return FALSE si no se cumple lo anteriormente descrito, TRUE en caso contrario.
     * @throws ParseException Se lanzará si no se puede "parsear" alguna de las fechas.
     */
    private boolean comprobarFechaColabora() throws ParseException
    {
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        String fecha = formato.format(dc_fecha.getDate());
        DefaultTableModel tablaCasos = (DefaultTableModel) jt_Casos.getModel();
        int casoSeleccionado = jt_Casos.getSelectedRow();
        String fechaIniCasoSeleccionado = tablaCasos.getValueAt(casoSeleccionado, 2).toString();
        String fechaFinCasoSeleccionado = tablaCasos.getValueAt(casoSeleccionado, 3).toString();
        
        if(fechaIniCasoSeleccionado.compareTo(fecha) > 0)
            return false;
        
        if(!"".equals(fechaFinCasoSeleccionado))
            return fechaFinCasoSeleccionado.compareTo(fecha) >= 0;
        
        return false;
    }
    
    /***
     * Escribe el código del experto seleccionado con el ratón en 'tf_codExpertoCol'.
     * @param evt NOT_USED.
     */
    private void jt_ExpertosMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jt_ExpertosMouseReleased
        
        tf_codExpertoCol.setText(jt_Expertos.getModel().getValueAt(jt_Expertos.getSelectedRow(), 0).toString());
    }//GEN-LAST:event_jt_ExpertosMouseReleased
    
    /***
     * Escribe el código del caso seleccionado con el ratón en 'tf_codCasoCol'.
     * @param evt NOT_USED.
     */
    private void jt_CasosMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jt_CasosMouseReleased
        
        tf_codCasoCol.setText(jt_Casos.getModel().getValueAt(jt_Casos.getSelectedRow(), 0).toString());
    }//GEN-LAST:event_jt_CasosMouseReleased

    /***
     * Llama al método 'mostraDatos' para que se refresque la información mostrada en la interfaz. Se invoca cuando se
     * presione el botón de refrescar.
     * @param evt NOT_USED.
     */
    private void bt_RefrescarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_RefrescarActionPerformed
        
        this.mostrarDatos();
    }//GEN-LAST:event_bt_RefrescarActionPerformed

    /***
     * Se llama al pulsar el botón de eliminar experto y ejecuta las acciones pertinentes para borrar el experto que el
     * usuario ha seleccionado. Si no se ha seleccionado ningún experto, se abre un diálogo de error, si se ha seleccionado
     * más de un experto, se borrará el primeramente seleccionado. El método le pide confirmación al usuario, si el usuario
     * no confirma el experto no se borra.
     * @param evt NOT_USED.
     */
    private void bt_eliminarExpertoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_eliminarExpertoActionPerformed
        
        int expertoSeleccionado = jt_Expertos.getSelectedRow();
        
        if(expertoSeleccionado == -1)
            JOptionPane.showMessageDialog(this, "Selecciona un experto.", "Error", JOptionPane.ERROR_MESSAGE);
        
        else
        {
            String codExperto = jt_Expertos.getModel().getValueAt(expertoSeleccionado, 0).toString();
            String mensaje = "¿Estás seguro de borrar al experto " + codExperto + "?";
            int respuesta = JOptionPane.showConfirmDialog(this, mensaje, "¡Cuidado!", JOptionPane.YES_NO_OPTION);
            
            if(respuesta == JOptionPane.YES_OPTION)   
            {
                try 
                {
                    new manejaExperto().eliminarExperto(codExperto);
                    
                    mensaje = "Experto " + codExperto + " eliminado permanentemente.";
                    
                    JOptionPane.showMessageDialog(this, mensaje, "Eliminación satisfactoria", JOptionPane.INFORMATION_MESSAGE);
                } 
                
                catch (SQLException e) 
                {
                    JOptionPane.showMessageDialog(this, e.getMessage(), "Eliminación errónea", JOptionPane.ERROR_MESSAGE);
                }
            }
            
            else
                JOptionPane.showMessageDialog(this, "El experto " + codExperto + " no se ha borrado.", "Eliminación cancelada", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_bt_eliminarExpertoActionPerformed

    /***
     * Se llama al pulsar el botón de eliminar caso y ejecuta las acciones pertinentes para borrar el caso que el
     * usuario ha seleccionado. Si no se ha seleccionado ningún caso, se abre un diálogo de error, si se ha seleccionado
     * más de un caso, se borrará el primeramente seleccionado. El método le pide confirmación al usuario, si el usuario
     * no confirma el caso no se borra.
     * @param evt NOT_USED.
     */
    private void bt_eliminarCasoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_eliminarCasoActionPerformed
        
        int casoSeleccionado = jt_Casos.getSelectedRow();
        
        if(casoSeleccionado == -1)
            JOptionPane.showMessageDialog(this, "Selecciona un caso.", "Error", JOptionPane.ERROR_MESSAGE);
        
        else
        {
            String codCaso = jt_Casos.getModel().getValueAt(casoSeleccionado, 0).toString();
            String mensaje = "¿Estás seguro de borrar el caso " + codCaso + "?";
            int respuesta = JOptionPane.showConfirmDialog(this, mensaje, "¡Cuidado!", JOptionPane.YES_NO_OPTION);
            
            if(respuesta == JOptionPane.YES_OPTION)   
            {
                try 
                {
                    new manejaCaso().eliminarCaso(codCaso);
                    
                    mensaje = "Caso " + codCaso + " eliminado permanentemente.";
                    
                    JOptionPane.showMessageDialog(this, mensaje, "Eliminación satisfactoria", JOptionPane.INFORMATION_MESSAGE);
                } 
                
                catch (SQLException e) 
                {
                    JOptionPane.showMessageDialog(this, e.getMessage(), "Eliminación errónea", JOptionPane.ERROR_MESSAGE);
                }
            }
            
            else
                JOptionPane.showMessageDialog(this, "El caso " + codCaso + " no se ha borrado.", "Eliminación cancelada", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_bt_eliminarCasoActionPerformed

    /***
     * Se llama al pulsar el botón de eliminar colaboración y ejecuta las acciones pertinentes para borrar la 
     * colaboración que el usuario ha seleccionado. Si no se ha seleccionado ningúna colaboración, se abre un diálogo de 
     * error, si se ha seleccionado más de una colaboración, se borrará la primeramente seleccionada. El método le pide 
     * confirmación al usuario, si el usuario no confirma la colaboración no se borra.
     * @param evt NOT_USED.
     */
    private void bt_eliminarColaborarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_eliminarColaborarActionPerformed
        
        int colaboraciónSeleccionada = jt_Colaboraciones.getSelectedRow();
        
        if(colaboraciónSeleccionada == -1)
            JOptionPane.showMessageDialog(this, "Selecciona una colaboración.", "Error", JOptionPane.ERROR_MESSAGE);
        
        else
        {
            String mensaje = "¿Estás seguro de borrar la colaboración seleccionada?";
            int respuesta = JOptionPane.showConfirmDialog(this, mensaje, "¡Cuidado!", JOptionPane.YES_NO_OPTION);
            
            if(respuesta == JOptionPane.YES_OPTION)   
            {
                try 
                {
                    String codExperto = jt_Colaboraciones.getModel().getValueAt(colaboraciónSeleccionada, 0).toString();
                    String codCaso = jt_Colaboraciones.getModel().getValueAt(colaboraciónSeleccionada, 1).toString();
                    String fecha = jt_Colaboraciones.getModel().getValueAt(colaboraciónSeleccionada, 2).toString();
                    
                    new manejaColabora().eliminarColaboración(codExperto, codCaso, fecha);
                    
                    mensaje = "Colaboración eliminada permanentemente.";
                    
                    JOptionPane.showMessageDialog(this, mensaje, "Eliminación satisfactoria", JOptionPane.INFORMATION_MESSAGE);
                } 
                
                catch (SQLException e) 
                {
                    JOptionPane.showMessageDialog(this, e.getMessage(), "Eliminación errónea", JOptionPane.ERROR_MESSAGE);
                }
            }
            
            else
                JOptionPane.showMessageDialog(this, "La colaboración no se ha borrado.", "Eliminación cancelada", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_bt_eliminarColaborarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_Refrescar;
    private javax.swing.JButton bt_eliminarCaso;
    private javax.swing.JButton bt_eliminarColaborar;
    private javax.swing.JButton bt_eliminarExperto;
    private javax.swing.JButton bt_insertarCaso;
    private javax.swing.JButton bt_insertarColaborar;
    private javax.swing.JButton bt_insertarExperto;
    private javax.swing.JComboBox<String> cb_nacionalidad;
    private javax.swing.JComboBox<String> cb_sexo;
    private com.toedter.calendar.JDateChooser dc_fecha;
    private com.toedter.calendar.JDateChooser dc_fechaFin;
    private com.toedter.calendar.JDateChooser dc_fechaIni;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jt_Casos;
    private javax.swing.JTable jt_Colaboraciones;
    private static javax.swing.JTable jt_Expertos;
    private javax.swing.JTextField tf_codCaso;
    private javax.swing.JTextField tf_codCasoCol;
    private javax.swing.JTextField tf_codExperto;
    private javax.swing.JTextField tf_codExpertoCol;
    private javax.swing.JTextField tf_des;
    private javax.swing.JTextField tf_especialidad;
    private javax.swing.JTextField tf_nombreCaso;
    private javax.swing.JTextField tf_nombreExperto;
    // End of variables declaration//GEN-END:variables
}
