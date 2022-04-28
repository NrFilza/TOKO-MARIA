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
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author User
 */
public class laporanperhari extends javax.swing.JFrame {

    /**
     * Creates new form laporanperhari
     */
    public laporanperhari() {
        initComponents();
        tabell();
        totalhasil();
    }
 public void totalhasil(){
     Calendar c = Calendar.getInstance();
     Date harisekarang = new Date();
     String dataParser = String.valueOf(c.get(Calendar.YEAR))+"-"+String.valueOf(harisekarang.getMonth()+1)+
             "-"+String.valueOf(c.get(Calendar.DAY_OF_MONTH));
        try{
            String totalduit = "SELECT SUM(`harga_jual`) as totaluang FROM detailtransaksi WHERE YEAR(tanggal) = YEAR('"+dataParser+"')"
                    +"AND MONTH(tanggal) = MONTH('"+dataParser+"')"
                    +"AND DAY(tanggal)= DAY('"+dataParser+"')";
            java.sql.Connection Conn =(Connection) koneksi.koneksi();
            java.sql.PreparedStatement stm = Conn.prepareStatement(totalduit);
            java.sql.ResultSet rs = stm.executeQuery(totalduit);
            while(rs.next()){
                
                jLabel2.setText((rs.getString("totaluang")));
                jLabel2.setText(String.valueOf(rs.getString(3)));
            }
            
        } catch (Exception e){
            
        }}
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();

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

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 160, 910, 400));

        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 600, 100, 40));

        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 600, 120, 40));
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 560, 70, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/percobaan/1000013.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jButton5.setContentAreaFilled(false);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 100, 80, 30));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:

            openSelection();
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
       print();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        tabel();
    }//GEN-LAST:event_jButton5ActionPerformed
private void tabel(){
        //laporan perhari
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("No");
        model.addColumn("Nama Barang");
        model.addColumn("Jumlah");
        model.addColumn("Harga Jual");
        model.addColumn("Id Transaksi");
        model.addColumn("Id Barang");
        model.addColumn("Tanggal");

    String tampilan = "dd-MM-yyyy";
    SimpleDateFormat fm = new SimpleDateFormat(tampilan);
    System.out.println(fm);
   
    try {
            int no =1;
            int NamaBarang =0;
            int Jumlah=0;
            int HargaJual =0;
            int IdTransaksi =0;
            int IdBarang =0;
            int Tanggal =0;
            String sql ="SELECT*From detailtransaksi";
            System.out.println(sql);
            java.sql.Connection conn = (Connection) koneksi.koneksi();
            java.sql.Statement stm =conn.createStatement();
            java.sql.ResultSet res =stm.executeQuery(sql);
            while(res.next()){
                 model.addRow(new Object[] {no++,res.getString(1),res.getString(2), 
            res.getString(3), res.getString(4),res.getString(5)});
                
            }
           jTable1.setModel(model);
        } catch(Exception e){
        }}

private void tabell(){
    //memasukkan ketabel
    DefaultTableModel model = new DefaultTableModel();
        model.addColumn("No");
        model.addColumn("Nama Barang");
        model.addColumn("Jumlah");
        model.addColumn("Harga Jual");
        model.addColumn("Id Transaksi");
        model.addColumn("Id Barang");
        model.addColumn("Tanggal");
    try {
         Calendar c = Calendar.getInstance();
     Date harisekarang = new Date();
     String dataParser = String.valueOf(c.get(Calendar.YEAR))+"-"+String.valueOf(harisekarang.getMonth()+1)+
             "-"+String.valueOf(c.get(Calendar.DAY_OF_MONTH));
            int no =1;
            int NamaBarang =0;
            int Jumlah=0;
            int HargaJual =0;
            int IdTransaksi =0;
            int IdBarang =0;
            int Tanggal =0;
            String sql ="SELECT*From detailtransaksi WHERE YEAR(tanggal) = YEAR('"+dataParser+"')"
                    +"AND MONTH(tanggal) = MONTH('"+dataParser+"')"
                    +"AND DAY(tanggal)= DAY('"+dataParser+"')";
            java.sql.Connection conn = (Connection) koneksi.koneksi();
            java.sql.Statement stm =conn.createStatement();
            java.sql.ResultSet res =stm.executeQuery(sql);
            while(res.next()){
                 model.addRow(new Object[] {no++,res.getString("nama_barang"),res.getString("jumlah"), 
                    res.getString("harga_jual"), res.getString("idtransaksi"),res.getString("idbarang")
                 ,res.getString("tanggal")});
                
            }
           jTable1.setModel(model);
        } catch(Exception e){
            e.printStackTrace();
        }}
            
       public void RubahkeExcel(javax.swing.JTable table, File file){
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
             
             RubahkeExcel(jTable1, fp);
             JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan");
         } catch (Exception e){
           e.printStackTrace();
         }
     }
       private void print(){
         try{
             jTable1.print();
         } catch (Exception e){
             JOptionPane.showMessageDialog(null, "Data Kosong!");
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
            java.util.logging.Logger.getLogger(laporanperhari.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(laporanperhari.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(laporanperhari.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(laporanperhari.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new laporanperhari().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

}