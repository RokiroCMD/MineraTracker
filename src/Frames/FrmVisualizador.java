/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Frames;

import Conexionsql.Conexion;
import java.util.HashSet;
import java.util.Set;
import javax.swing.event.MouseInputListener;
import models.Semaforo;
import models.Vehiculo;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;
import org.jxmapviewer.OSMTileFactoryInfo;
import org.jxmapviewer.VirtualEarthTileFactoryInfo;
import org.jxmapviewer.input.PanMouseInputListener;
import org.jxmapviewer.input.ZoomMouseWheelListenerCenter;
import org.jxmapviewer.viewer.DefaultTileFactory;
import org.jxmapviewer.viewer.GeoPosition;
import org.jxmapviewer.viewer.TileFactoryInfo;
import org.jxmapviewer.viewer.WaypointPainter;
import utils.waypoint.DompeWaypoint;
import utils.waypoint.ExcavadoraWaypoint;
import utils.waypoint.MineraWaypoint;
import utils.waypoint.MineraWaypoint.MINERA_WAYPOINT_TYPE;
import utils.waypoint.SemaforoWaypoint;
import utils.waypoint.WaypointRenderer;

public class FrmVisualizador extends javax.swing.JFrame {

    private Set<MineraWaypoint> waypoints = new HashSet<>();
    
    public FrmVisualizador() {
        initComponents();
        Conexion.initConexion();
        initMap();
    }

    private void initMap(){
        TileFactoryInfo info = new OSMTileFactoryInfo();
        DefaultTileFactory tileFactory  = new DefaultTileFactory(info);
        mapView.setTileFactory(tileFactory);
        GeoPosition pos = new GeoPosition(27.058286, -109.452277);
        mapView.setAddressLocation(pos);
        mapView.setZoom(2);
        
        MouseInputListener mm = new PanMouseInputListener(mapView);
        ZoomMouseWheelListenerCenter zoomWheelC = new ZoomMouseWheelListenerCenter(mapView);
        mapView.addMouseListener(mm);
        mapView.addMouseMotionListener(mm);
        mapView.addMouseWheelListener(zoomWheelC);
    
    }
    
    private void initWaypoints(){
        WaypointPainter<MineraWaypoint> wp = new WaypointRenderer();
        wp.setWaypoints(waypoints);
        mapView.setOverlayPainter(wp);
        for (MineraWaypoint mw : waypoints) {
            mapView.add(mw.getBtn());
        }
    }
    
    private void clearWaypoints(){
        for (MineraWaypoint mw : waypoints) {
            mapView.remove(mw.getBtn());
        }
        waypoints.clear();
        initWaypoints();
    }
    
    public void addWaypoint(String name, GeoPosition coord, MINERA_WAYPOINT_TYPE tipo){
        switch(tipo){
            case SEMAFORO:
                waypoints.add(new MineraWaypoint(name, new SemaforoWaypoint(name), coord));
                initWaypoints();
                break;
            case DOMPE:
                waypoints.add(new MineraWaypoint(name, new DompeWaypoint(), coord));
                initWaypoints();
                break;
            case EXCAVADORA:
                waypoints.add(new MineraWaypoint(name, new ExcavadoraWaypoint(), coord));
                initWaypoints();
                break;
        }
    }
    
    public void addWaypoint(String name, GeoPosition coord, MINERA_WAYPOINT_TYPE tipo, String extra){
        switch(tipo){
            case SEMAFORO:
                waypoints.add(new MineraWaypoint(name, new SemaforoWaypoint(name), coord, extra));
                initWaypoints();
                break;
            case DOMPE:
                waypoints.add(new MineraWaypoint(name, new DompeWaypoint(), coord));
                initWaypoints();
                break;
            case EXCAVADORA:
                waypoints.add(new MineraWaypoint(name, new ExcavadoraWaypoint(), coord));
                initWaypoints();
                break;
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cmbTipo = new combobox.Combobox();
        button1 = new button.Button();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        mapView = new org.jxmapviewer.JXMapViewer();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Visualizador MINERA");
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.LINE_AXIS));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(63, 67, 70));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Reportes/mineria.jpg"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("SISTEMA DE CONTROL DE TRAFICO");

        cmbTipo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Open Stree", "Virtual Earth", "Hybrid", "Satellite" }));
        cmbTipo.setLabeText("Tipo de mapa");
        cmbTipo.setLightWeightPopupEnabled(false);
        cmbTipo.setLineColor(new java.awt.Color(117, 42, 27));
        cmbTipo.setRequestFocusEnabled(false);
        cmbTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbTipoActionPerformed(evt);
            }
        });

        button1.setForeground(new java.awt.Color(102, 102, 102));
        button1.setText("Semaforos");
        button1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        button1.setRippleColor(new java.awt.Color(153, 153, 153));
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(246, 246, 246));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Generar reportes");

        jButton1.setText("Refrescar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Cambiar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cmbTipo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(button1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jButton1)
                .addGap(27, 27, 27)
                .addComponent(jButton2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(cmbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addGap(10, 10, 10)
                .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(114, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout mapViewLayout = new javax.swing.GroupLayout(mapView);
        mapView.setLayout(mapViewLayout);
        mapViewLayout.setHorizontalGroup(
            mapViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 962, Short.MAX_VALUE)
        );
        mapViewLayout.setVerticalGroup(
            mapViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(mapView, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(mapView, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        getContentPane().add(jPanel1);

        setSize(new java.awt.Dimension(1220, 606));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public void generarReporteSemaforos(){
        
          try {
            JasperDesign jd = JRXmlLoader.load("src/Reportes/Semaforos.jrxml");
            JasperReport jreport = JasperCompileManager.compileReport(jd);
            JasperPrint jprint = JasperFillManager.fillReport(jreport, null, 
                    Conexion.getConnection);
            JasperViewer.viewReport(jprint,false);
            
        } catch(JRException ex)  {
            System.out.println("Error: " + ex.getMessage());
        }
    }
    public void generarReporteVehiculos(){
        try {
            JasperDesign jd = JRXmlLoader.load("src/Reportes/Vehiculos.jrxml");
            JasperReport jreport = JasperCompileManager.compileReport(jd);
            JasperPrint jprint = JasperFillManager.fillReport(jreport, null, 
                    Conexion.getConnection);
            JasperViewer.viewReport(jprint,false);
            
        } catch(JRException ex)  {
            System.out.println("Error: " + ex.getMessage());
        }
    }
    public void generarReporteRutas(){
        try {
            JasperDesign jd = JRXmlLoader.load("src/Reportes/Rutas.jrxml");
            JasperReport jreport = JasperCompileManager.compileReport(jd);
            JasperPrint jprint = JasperFillManager.fillReport(jreport, null, 
                    Conexion.getConnection);
            JasperViewer.viewReport(jprint,false);
            
        } catch(JRException ex)  {
            System.out.println("Error: " + ex.getMessage());
        }
    }
    
    private void cmbTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbTipoActionPerformed
        TileFactoryInfo info = null;
        int index = cmbTipo.getSelectedIndex();
        switch (index) {
            case 0:
            info = new OSMTileFactoryInfo();
            break;
            case 1:
            info = new VirtualEarthTileFactoryInfo(VirtualEarthTileFactoryInfo.MAP);
            break;
            case 2:
            info = new VirtualEarthTileFactoryInfo(VirtualEarthTileFactoryInfo.HYBRID);
            break;
            case 3:
            info = new VirtualEarthTileFactoryInfo(VirtualEarthTileFactoryInfo.SATELLITE);
            break;
            default:
            info = new OSMTileFactoryInfo();
            break;
        }
        DefaultTileFactory tileFactory  = new DefaultTileFactory(info);
        mapView.setTileFactory(tileFactory);
    }//GEN-LAST:event_cmbTipoActionPerformed

    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button1ActionPerformed
        generarReporteSemaforos();
    }//GEN-LAST:event_button1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        clearWaypoints();
        for (Semaforo s : Conexion.getSemaforos()) {
            addWaypoint(s.getId()+"", new GeoPosition(s.getLat(), s.getLon()), MINERA_WAYPOINT_TYPE.SEMAFORO, s.getEstado());
        }
        
        for (Vehiculo v : Conexion.getVehiculos()) {
            addWaypoint(v.getId()+"", new GeoPosition(v.getLat(), v.getLon()), MINERA_WAYPOINT_TYPE.valueOf(v.getTipo()));
        }
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        for (MineraWaypoint mw : waypoints) {
            if (mw.getBtn() instanceof SemaforoWaypoint) {
                ((SemaforoWaypoint) mw.getBtn()).cambiarColor();
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmVisualizador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmVisualizador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmVisualizador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmVisualizador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmVisualizador().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private button.Button button1;
    private combobox.Combobox cmbTipo;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private org.jxmapviewer.JXMapViewer mapView;
    // End of variables declaration//GEN-END:variables
}
