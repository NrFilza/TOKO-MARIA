/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package percobaan;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author User
 */
public class histori extends javax.swing.JFrame {

    /**
     * Creates new form histori
     */
    public histori() {
        initComponents();
        histori();
        
    }

   
        
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 130, 790, 410));

        jButton2.setContentAreaFilled(false);
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 560, 110, 50));

        jPanel1.setBackground(new java.awt.Color(247, 247, 247));
        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 780, 50));

        jButton1.setContentAreaFilled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 560, 110, 50));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/percobaan/A42.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
           openSelection();
    }//GEN-LAST:event_jButton1ActionPerformed
 private void histori() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Nama Barang");
        model.addColumn("Jumlah");
        model.addColumn("Harga Total");
        model.addColumn("Tangal");
        
        try {
            String sql = "SELECT barang.namabarang, detailtransaksi.jumlah, SUM(detailtransaksi.jumlah * detailtransaksi.harga_jual) as Penghasilan, transaksi.tanggal from barang JOIN detailtransaksi ON barang.idbarang = detailtransaksi.idbarang JOIN transaksi ON detailtransaksi.idtransaksi = transaksi.idtransaksi  GROUP BY barang.namabarang, detailtransaksi.jumlah";
            java.sql.Connection conn=(Connection) koneksi.koneksi();
            java.sql.Statement stm=conn.createStatement();
            java.sql.ResultSet r=stm.executeQuery(sql);
            while(r.next()) {
                DecimalFormat kursIndonesia = (DecimalFormat) DecimalFormat.getCurrencyInstance();
        DecimalFormatSymbols formatRp = new DecimalFormatSymbols();
        
        formatRp.setCurrencySymbol("Rp. ");
        formatRp.setMonetaryDecimalSeparator(',');
        formatRp.setGroupingSeparator('.');

        kursIndonesia.setDecimalFormatSymbols(formatRp);
          String idr = kursIndonesia.format(Integer.parseInt(String.valueOf(r.getString(3))));
                model.addRow(new Object[]
                {r.getString(1),r.getString(2),idr,r.getString(4)});
                
            }  jTable1.setModel(model);
        }catch (Exception e) {
    }
 }
 
 public void exportkeExcel(javax.swing.JTable table, File file) {
     //export ke excel
         try{
             DefaultTableModel Model_Data = (DefaultTableModel)table.getModel();
             FileWriter ObjWriter = new FileWriter(file);
             System.out.println(file.toString());
             for(int i =0; i < Model_Data.getColumnCount(); i++){
                 System.out.println(Model_Data.getColumnName(i));
                 ObjWriter.write(Model_Data.getColumnName(i) + "\t");      
             } ObjWriter.write("\n");
             for(int i =0; i < Model_Data.getRowCount(); i++){
                 for(int j=0; j<Model_Data.getColumnCount(); j++){
                     ObjWriter.write(Model_Data.getValueAt(i, j).toString()+ "\t");
                 } ObjWriter.write("\n");
             }
             ObjWriter.close();
         } catch(IOException e){
             System.out.println(e);
         }
 }
 
 public void openSelection(){
         JFileChooser path = new JFileChooser();
         path.showOpenDialog(this);
         String date = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
         try{
             File f = path.getSelectedFile();
             String location = f.getAbsolutePath();
             String filename = location + "_"+".xls";
             JOptionPane.showMessageDialog(null, filename);
             File fp = new File(filename);
             
             exportkeExcel(jTable1, fp);
             JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan");
         } catch (Exception e){
           e.printStackTrace();
         }
     }
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
            java.util.logging.Logger.getLogger(histori.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(histori.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(histori.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(histori.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new histori().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
