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
import javax.swing.JOptionPane;
import modelo.caso;
import modelo.colabora;
import modelo.experto;

/**
 *
 * @author jprecreativo
 */
public class Colaborar extends Screen
{
    private final conexionOracle co;
    private boolean existeExperto;
    private boolean existeCaso;

    /**
     * Creates new form Colaborar
     * @param co
     */
    public Colaborar(conexionOracle co) 
    {
        initComponents();
        
        this.co = co;
        
        super.inicialize(this.getWidth(), this.getHeight(), "Insertar colaboración");
        
        ta_des.setLineWrap(true);   // Se logra que haya salto de línea en el TextArea.
        ta_des.setWrapStyleWord(true);   // Se impide la división de palabras en el TestArea.
    }
    
    private void obtenerNacionalidades()
    {
        try 
        {
            ResultSet nacionalidades = Nacionalidad.obtenerNacionalidades();
            
            while(nacionalidades.next())
                cb_nacionalidad.addItem(nacionalidades.getString(1));
        } 
        
        catch (SQLException e) 
        {
            System.out.println("Error: " + e.getMessage());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        tf_codExperto = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        tf_codCaso = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ta_des = new javax.swing.JTextArea();
        bt_insertar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        tf_nombreExperto = new javax.swing.JTextField();
        cb_sexo = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        cb_nacionalidad = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        tf_especialidad = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        tf_nombreCaso = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        dc_fechaIni = new com.toedter.calendar.JDateChooser();
        dc_fechaFin = new com.toedter.calendar.JDateChooser();
        dc_fecha = new com.toedter.calendar.JDateChooser();
        bt_comprobarExperto = new javax.swing.JButton();
        bt_comprobarCaso = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setText("Código del experto:");

        jLabel2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel2.setText("Código del caso:");

        jLabel3.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel3.setText("Fecha colaboración:");

        jLabel4.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel4.setText("Descripción de la colaboración:");

        ta_des.setColumns(20);
        ta_des.setRows(5);
        jScrollPane1.setViewportView(ta_des);

        bt_insertar.setText("Insertar");
        bt_insertar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_insertarActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel5.setText("Nombre:");

        tf_nombreExperto.setEnabled(false);

        cb_sexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "...", "F", "M" }));
        cb_sexo.setEnabled(false);

        jLabel6.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel6.setText("Sexo:");

        jLabel7.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel7.setText("País:");

        cb_nacionalidad.setEditable(true);
        cb_nacionalidad.setEnabled(false);

        jLabel8.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel8.setText("Especialidad:");

        tf_especialidad.setEnabled(false);

        jLabel9.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel9.setText("Nombre:");

        tf_nombreCaso.setEnabled(false);

        jLabel10.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel10.setText("Fecha de inicio:");

        jLabel11.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel11.setText("Fecha de fin:");

        dc_fechaIni.setDateFormatString("dd/MM/yyyy");
        dc_fechaIni.setEnabled(false);

        dc_fechaFin.setDateFormatString("dd/MM/yyyy");
        dc_fechaFin.setEnabled(false);

        dc_fecha.setDateFormatString("dd/MM/yyyy");

        bt_comprobarExperto.setText("Comprobar experto");
        bt_comprobarExperto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_comprobarExpertoActionPerformed(evt);
            }
        });

        bt_comprobarCaso.setText("Comprobar caso");
        bt_comprobarCaso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_comprobarCasoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(288, 288, 288)
                        .addComponent(bt_insertar))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tf_nombreCaso, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tf_codCaso, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(dc_fecha, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(52, 52, 52))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabel5)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(tf_nombreExperto))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(tf_codExperto, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cb_sexo, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(49, 49, 49)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cb_nacionalidad, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(51, 51, 51)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(tf_especialidad))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel11)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(dc_fechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel10)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(dc_fechaIni, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(0, 0, Short.MAX_VALUE)))))
                        .addGap(16, 16, 16))))
            .addGroup(layout.createSequentialGroup()
                .addGap(255, 255, 255)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bt_comprobarExperto)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(bt_comprobarCaso)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(tf_codExperto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(tf_nombreExperto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)
                            .addComponent(tf_especialidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cb_nacionalidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel7)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cb_sexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addComponent(bt_comprobarExperto)
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(tf_codCaso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel10))
                    .addComponent(dc_fechaIni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel9)
                        .addComponent(tf_nombreCaso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel11))
                    .addComponent(dc_fechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addComponent(bt_comprobarCaso)
                .addGap(27, 27, 27)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(bt_insertar))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(dc_fecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void expertoInsertado()
    {
        if(!existeExperto)
            {
                experto ex = new experto(tf_codExperto.getText(),
                                 tf_nombreExperto.getText(),
                                 cb_nacionalidad.getSelectedItem().toString(),
                                 cb_sexo.getSelectedItem().toString(),
                                 tf_especialidad.getText());
        
        
                if(new manejaExperto().insertaExperto(ex))
                    JOptionPane.showMessageDialog(this, "Experto insertado con éxito.", "Inserción realizada", JOptionPane.INFORMATION_MESSAGE);
            }
    }
    
    private void casoInsertado() throws SQLException
    {
        if(!existeCaso)
            {
                SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
                String fechaIni = formato.format(dc_fechaIni.getDate());
                String fechaFin = "";
        
                if(dc_fechaFin.getDate() != null)
                    fechaFin = formato.format(dc_fechaFin.getDate());
                
                caso c = new caso(tf_codCaso.getText(),
                                 tf_nombreCaso.getText(),
                                 fechaIni,
                                 fechaFin);
        
        
                if(new manejaCaso().insertaCaso(c))
                    JOptionPane.showMessageDialog(this, "Caso insertado con éxito.", "Inserción realizada", JOptionPane.INFORMATION_MESSAGE);
            }
    }
    
    private void colaboraciónInsertada() throws SQLException
    {
        manejaColabora mc = new manejaColabora();
            
        if(!mc.existeColaboracion(tf_codExperto.getText(), tf_codCaso.getText()))
        {
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
            String fecha = formato.format(dc_fecha.getDate());
            
            mc.insertaColaboracion(new colabora(tf_codExperto.getText(), tf_codCaso.getText(), fecha, ta_des.getText()));
            
            co.finTransaccionCommit();
            
            JOptionPane.showMessageDialog(this, "Se ha insertado la colaboración.");
        }

        else
        {
            JOptionPane.showMessageDialog(this, "Ya existe la colaboración.", "Colaboración no insertada", JOptionPane.ERROR_MESSAGE);

            co.finTransaccionRollback();
        }
    }
    
    private void comprobarExperto() throws SQLException
    {
        manejaExperto me = new manejaExperto();
        experto e = me.existeExperto(tf_codExperto.getText());
        
        if(null == e)
        {
            JOptionPane.showMessageDialog(this, "El experto no existe, rellena sus datos.");
                    
                    tf_nombreExperto.setEnabled(true);
                    tf_especialidad.setEnabled(true);
                    cb_nacionalidad.setEnabled(true);
                    cb_sexo.setEnabled(true);
                    
                    this.obtenerNacionalidades();
                    
                    existeExperto = false;
        }
        
        else
        {
            JOptionPane.showMessageDialog(this, "El experto ya existe.");
            
            tf_nombreExperto.setEnabled(false);
            tf_nombreExperto.setText(e.getCodExperto());
            
            tf_especialidad.setEnabled(false);
            tf_especialidad.setText(e.getEspecialidad());
            
            cb_nacionalidad.setEnabled(false);
            cb_nacionalidad.setSelectedItem(e.getPais());
            
            cb_sexo.setEnabled(false);
            cb_sexo.setSelectedItem(e.getSexo());
            
            existeExperto = true;
        }
    }
    
    private void comprobarCaso() throws SQLException, ParseException
    {
        manejaCaso mc = new manejaCaso();
        caso c = mc.existeCaso(tf_codCaso.getText());
        
        if(null == c)
        {
            JOptionPane.showMessageDialog(this, "El caso no existe, rellena sus datos.");
                    
            tf_nombreCaso.setEnabled(true);
            dc_fechaIni.setEnabled(true);
            dc_fechaFin.setEnabled(true);

            existeCaso = false;
        }
        
        else
        {
            JOptionPane.showMessageDialog(this, "El caso ya existe.");
            
            tf_nombreCaso.setEnabled(false);
            tf_nombreCaso.setText(c.getNombre());
            
            dc_fechaIni.setEnabled(false);
            dc_fechaIni.setDate(new SimpleDateFormat("yyyy-MM-dd").parse(c.getFechaInicio()));
            
            dc_fechaFin.setEnabled(false);
            
            if(null != c.getFechaFin())
                dc_fechaFin.setDate(new SimpleDateFormat("yyyy-MM-dd").parse(c.getFechaFin()));
            
            existeCaso = true;
        }
    }
    
    private void comprobarFechas() throws Exception
    {
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        String fechaIni = formato.format(dc_fechaIni.getDate());
        String fecha = formato.format(dc_fecha.getDate());
        String fechaFin = "";
        
        if(dc_fechaFin.getDate() != null)
            fechaFin = formato.format(dc_fechaFin.getDate());
        
        if(!"".equals(fechaFin) && fechaIni.compareTo(fechaFin) == 1)
            throw new Exception("La fecha de fin ha de ser mayor o igual a la fecha de inicio del caso.");
        
        if(fecha.compareTo(fechaIni) == -1)
            throw new Exception("La fecha de la colaboración ha de ser mayor o igual a la fecha de inicio del caso.");
        
        if(!"".equals(fechaFin) && fechaFin.compareTo(fecha) == -1)
            throw new Exception("La fecha de la colaboración ha de ser menor o igual a la fecha de fin del caso.");
    }
    
    private void bt_insertarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_insertarActionPerformed

        try 
        {
            this.comprobarFechas();   // Antes de nada, se comprueban las fechas.
            
            co.inicioTransaccion();

            this.expertoInsertado();
            this.casoInsertado();
            this.colaboraciónInsertada();
        }

        catch (SQLException e1)
        {
            JOptionPane.showMessageDialog(this, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);

            try
            {
                co.finTransaccionRollback();
            }

            catch (SQLException e2)
            {
                JOptionPane.showMessageDialog(this, e2.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        } 

        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_bt_insertarActionPerformed

    private void bt_comprobarExpertoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_comprobarExpertoActionPerformed
       
        try 
        {
            this.comprobarExperto();
        } 
        
        catch (SQLException e) 
        {
            System.out.println("Error: " + e.getMessage());
        }
    }//GEN-LAST:event_bt_comprobarExpertoActionPerformed

    private void bt_comprobarCasoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_comprobarCasoActionPerformed
        
        try 
        {
            this.comprobarCaso();
        } 
        
        catch (SQLException | ParseException e) 
        {
            System.out.println("Error: " + e.getMessage());
        }
    }//GEN-LAST:event_bt_comprobarCasoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_comprobarCaso;
    private javax.swing.JButton bt_comprobarExperto;
    private javax.swing.JButton bt_insertar;
    private javax.swing.JComboBox<String> cb_nacionalidad;
    private javax.swing.JComboBox<String> cb_sexo;
    private com.toedter.calendar.JDateChooser dc_fecha;
    private com.toedter.calendar.JDateChooser dc_fechaFin;
    private com.toedter.calendar.JDateChooser dc_fechaIni;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea ta_des;
    private javax.swing.JTextField tf_codCaso;
    private javax.swing.JTextField tf_codExperto;
    private javax.swing.JTextField tf_especialidad;
    private javax.swing.JTextField tf_nombreCaso;
    private javax.swing.JTextField tf_nombreExperto;
    // End of variables declaration//GEN-END:variables
}
