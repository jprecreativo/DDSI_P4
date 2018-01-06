package vista;

import controlador.Factory;
import controlador.conexionOracle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.URL;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author jprecreativo
 */
public class Opciones extends Screen 
{
    private final conexionOracle co;
    
    public Opciones(conexionOracle co) 
    {
        initComponents();
        
        this.co = co;
        
        Factory.co = co;
        
        this.addWindowListener(new WindowAdapter() {
        
            @Override
            public void windowClosing(WindowEvent event)
            {
                try 
                {
                    co.desconexion();
                } 
                
                catch (SQLException e) 
                {
                    System.out.println("Error: " + e.getMessage());
                }
            }
        }   
        );
        
        super.inicialize(this.getWidth(), this.getHeight(), "Opciones");
        this.loadImages();
    }
    
    private void loadImages()
    {
        this.loadInsertar();
        this.loadConsultar();
        this.loadColaborar();
        this.loadGColaboraciones();
        this.loadGCompleta();
        this.loadSalir();
    }
    
    private void loadGCompleta()
    {
        URL url = this.getClass().getResource("G_Completa.png");
        JLabel label = new JLabel(new ImageIcon(url));
        
        label.setBounds(0, 0, jp_G_Completa.getWidth(), jp_G_Completa.getHeight());
        label.setToolTipText("Gestión completa");
        
        label.addMouseListener(new MouseAdapter() {
            
            @Override
            public void mouseClicked(MouseEvent event)
            {
                Factory.factoryMethod("G_Completa");
            }
        });
        
        jp_G_Completa.add(label);
    }
    
    private void loadGColaboraciones()
    {
        URL url = this.getClass().getResource("G_Colaboraciones.png");
        JLabel label = new JLabel(new ImageIcon(url));
        
        label.setBounds(0, 0, jp_G_Colaboraciones.getWidth(), jp_G_Colaboraciones.getHeight());
        label.setToolTipText("Gestionar colaboraciones");
        
        label.addMouseListener(new MouseAdapter() {
            
            @Override
            public void mouseClicked(MouseEvent event)
            {
                Factory.factoryMethod("G_Colaboraciones");
            }
        });
        
        jp_G_Colaboraciones.add(label);
    }
    
    private void loadColaborar()
    {
        URL url = this.getClass().getResource("Colaborar.png");
        JLabel label = new JLabel(new ImageIcon(url));
        
        label.setBounds(0, 0, jp_colaboraciones.getWidth(), jp_colaboraciones.getHeight());
        label.setToolTipText("Insertar una colaboración");
        
        label.addMouseListener(new MouseAdapter() {
            
            @Override
            public void mouseClicked(MouseEvent event)
            {
                Factory.factoryMethod("Colaborar");
            }
        });
        
        jp_colaboraciones.add(label);
    }
    
    private void loadConsultar()
    {
        URL url = this.getClass().getResource("Consultar.png");
        JLabel label = new JLabel(new ImageIcon(url));
        
        label.setBounds(0, 0, jp_consultarExperto.getWidth(), jp_consultarExperto.getHeight());
        label.setToolTipText("Consulta expertos por nacionalidad");
        
        label.addMouseListener(new MouseAdapter() {
            
            @Override
            public void mouseClicked(MouseEvent event)
            {
                Factory.factoryMethod("Consultar");
            }
        });
        
        jp_consultarExperto.add(label);
    }
    
    private void loadSalir()
    {
        URL url = this.getClass().getResource("Salir.png");
        JLabel label = new JLabel(new ImageIcon(url));
        
        label.setBounds(0, 0, jp_Salir.getWidth(), jp_Salir.getHeight());
        label.setToolTipText("Desconectarme");
        
        label.addMouseListener(new MouseAdapter() {
            
            @Override
            public void mouseClicked(MouseEvent event)
            {
                try 
                {
                    co.desconexion();
                    dispose();
                } 
                
                catch (SQLException e) 
                {
                    System.out.println("Error: " + e.getMessage());
                }
            }
        });
        
        jp_Salir.add(label);
    }
    
    private void loadInsertar()
    {
        URL url = this.getClass().getResource("InsertarExperto.png");
        JLabel label = new JLabel(new ImageIcon(url));
        
        label.setBounds(0, 0, jp_insertarExperto.getWidth(), jp_insertarExperto.getHeight());
        label.setToolTipText("Insertar un experto");
        
        label.addMouseListener(new MouseAdapter() {
            
            @Override
            public void mouseClicked(MouseEvent event)
            {
                Factory.factoryMethod("Insertar");
            }
        });
        
        jp_insertarExperto.add(label);
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
        jp_Salir = new javax.swing.JPanel();
        jp_colaboraciones = new javax.swing.JPanel();
        jp_insertarExperto = new javax.swing.JPanel();
        jp_consultarExperto = new javax.swing.JPanel();
        jp_G_Colaboraciones = new javax.swing.JPanel();
        jp_G_Completa = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("¿Qué quieres hacer?");

        javax.swing.GroupLayout jp_SalirLayout = new javax.swing.GroupLayout(jp_Salir);
        jp_Salir.setLayout(jp_SalirLayout);
        jp_SalirLayout.setHorizontalGroup(
            jp_SalirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 88, Short.MAX_VALUE)
        );
        jp_SalirLayout.setVerticalGroup(
            jp_SalirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jp_colaboracionesLayout = new javax.swing.GroupLayout(jp_colaboraciones);
        jp_colaboraciones.setLayout(jp_colaboracionesLayout);
        jp_colaboracionesLayout.setHorizontalGroup(
            jp_colaboracionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 88, Short.MAX_VALUE)
        );
        jp_colaboracionesLayout.setVerticalGroup(
            jp_colaboracionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jp_insertarExpertoLayout = new javax.swing.GroupLayout(jp_insertarExperto);
        jp_insertarExperto.setLayout(jp_insertarExpertoLayout);
        jp_insertarExpertoLayout.setHorizontalGroup(
            jp_insertarExpertoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 88, Short.MAX_VALUE)
        );
        jp_insertarExpertoLayout.setVerticalGroup(
            jp_insertarExpertoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 88, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jp_consultarExpertoLayout = new javax.swing.GroupLayout(jp_consultarExperto);
        jp_consultarExperto.setLayout(jp_consultarExpertoLayout);
        jp_consultarExpertoLayout.setHorizontalGroup(
            jp_consultarExpertoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 88, Short.MAX_VALUE)
        );
        jp_consultarExpertoLayout.setVerticalGroup(
            jp_consultarExpertoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 88, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jp_G_ColaboracionesLayout = new javax.swing.GroupLayout(jp_G_Colaboraciones);
        jp_G_Colaboraciones.setLayout(jp_G_ColaboracionesLayout);
        jp_G_ColaboracionesLayout.setHorizontalGroup(
            jp_G_ColaboracionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 88, Short.MAX_VALUE)
        );
        jp_G_ColaboracionesLayout.setVerticalGroup(
            jp_G_ColaboracionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 88, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jp_G_CompletaLayout = new javax.swing.GroupLayout(jp_G_Completa);
        jp_G_Completa.setLayout(jp_G_CompletaLayout);
        jp_G_CompletaLayout.setHorizontalGroup(
            jp_G_CompletaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 88, Short.MAX_VALUE)
        );
        jp_G_CompletaLayout.setVerticalGroup(
            jp_G_CompletaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jp_consultarExperto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jp_insertarExperto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jp_colaboraciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jp_G_Colaboraciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jp_G_Completa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jp_Salir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(172, 172, 172)
                        .addComponent(jLabel1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jp_Salir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jp_insertarExperto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jp_consultarExperto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jp_G_Colaboraciones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jp_colaboraciones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jp_G_Completa, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jp_G_Colaboraciones;
    private javax.swing.JPanel jp_G_Completa;
    private javax.swing.JPanel jp_Salir;
    private javax.swing.JPanel jp_colaboraciones;
    private javax.swing.JPanel jp_consultarExperto;
    private javax.swing.JPanel jp_insertarExperto;
    // End of variables declaration//GEN-END:variables
}
