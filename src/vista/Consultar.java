package vista;

import controlador.Nacionalidad;
import controlador.manejaExperto;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import modelo.experto;

/**
 *
 * @author jprecreativo
 */
public class Consultar extends Screen 
{
    /**
     * Creates new form Consultar
     */
    public Consultar()
    {
        initComponents();
        
        super.inicialize(this.getWidth(), this.getHeight(), "Consultar expertos por nacionalidad");
        this.obtenerNacionalidades();
        
        cb_nacionalidades.addItemListener(new Nacionalidad());
    }
    
    public static void rellenarTabla(ArrayList<experto> expertos)
    {
        DefaultTableModel model = (DefaultTableModel) jt_Datos.getModel();
        
        if(model.getRowCount() > 0)
            for(int i = model.getRowCount() - 1; i >= 0; i--)
                model.removeRow(i);
        
        expertos.stream().forEach((e) -> model.addRow(new Object[] {e.getCodExperto(),
                                                                    e.getNombre(),
                                                                    e.getPais(),
                                                                    e.getSexo(),
                                                                    e.getEspecialidad()}));
    }

    private void obtenerNacionalidades()
    {
        try 
        {
            cb_nacionalidades.addItem("...");
            
            ResultSet nacionalidades = Nacionalidad.obtenerNacionalidades();
            
            while(nacionalidades.next())
                cb_nacionalidades.addItem(nacionalidades.getString(1));
            
            Consultar.rellenarTabla(new manejaExperto().listaExpertosPorPais("..."));
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
        cb_nacionalidades = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jt_Datos = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        tf_sexo = new javax.swing.JTextField();
        bt_contar = new javax.swing.JButton();
        jl_textoSexo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setText("Elige una nacionalidad:");

        jt_Datos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CODEXPERTO", "NOMBRE", "PAÍS", "SEXO", "ESPECIALIDAD"
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
        jt_Datos.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jt_Datos);
        if (jt_Datos.getColumnModel().getColumnCount() > 0) {
            jt_Datos.getColumnModel().getColumn(0).setResizable(false);
            jt_Datos.getColumnModel().getColumn(1).setResizable(false);
            jt_Datos.getColumnModel().getColumn(2).setResizable(false);
            jt_Datos.getColumnModel().getColumn(3).setResizable(false);
            jt_Datos.getColumnModel().getColumn(4).setResizable(false);
        }

        jLabel2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel2.setText("Sexo:");

        bt_contar.setText("Contar");
        bt_contar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_contarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(142, 142, 142)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(cb_nacionalidades, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 147, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(tf_sexo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(bt_contar)
                        .addGap(36, 36, 36)
                        .addComponent(jl_textoSexo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cb_nacionalidades, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jl_textoSexo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(tf_sexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(bt_contar)))
                .addGap(27, 27, 27))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bt_contarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_contarActionPerformed
       
        try 
        {
            int n = new manejaExperto().sexoExperto(tf_sexo.getText());
            
            jl_textoSexo.setText("Hay " + n + " persona<s> del sexo especificado.");
        } 
        
        catch (SQLException e) 
        {
            jl_textoSexo.setText("");
            
            System.out.println("Error: " + e.getMessage());
        }
    }//GEN-LAST:event_bt_contarActionPerformed
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_contar;
    private javax.swing.JComboBox<String> cb_nacionalidades;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jl_textoSexo;
    private static javax.swing.JTable jt_Datos;
    private javax.swing.JTextField tf_sexo;
    // End of variables declaration//GEN-END:variables
}
