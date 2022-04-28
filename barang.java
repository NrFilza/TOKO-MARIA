/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package percobaan;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author User
 */
public class barang extends javax.swing.JFrame {

    /**
     * Creates new form barang
     */
    static String usernameD;
    public barang(String username) {
        initComponents();
        Tabel();
        
        this.usernameD = username;
    }
 public void autonumber(){
        try {
            String sql = "SELECT * FROM barang ORDER BY idbarang DESC";
            java.sql.Connection conn=(Connection) koneksi.koneksi();
            java.sql.Statement stm=conn.createStatement();
            java.sql.ResultSet r=stm.executeQuery(sql);
            if (r.next()) {
                String NoFaktur = r.getString("idbarang").substring(3);
                String TR = "" +(Integer.parseInt(NoFaktur)+1);
                String Nol = "";
                
                if(TR.length()==1)
                {Nol = "0";}
                else if(TR.length()==2)
                {Nol = "";}
                txt_IdBarang.setText("BR" + Nol + TR);
            } else {
           txt_IdBarang.setText("BR01");
            }
        } catch (Exception e) {
            
            System.out.println("autonumber error");
        }
    }
  

    private void Tabel(){
    DefaultTableModel model = new DefaultTableModel();
    model.addColumn("No");
    model.addColumn("Id Barang");
    model.addColumn("Nama Barang");
    model.addColumn("Jenis Barang");
    model.addColumn("Merek Barang");
    model.addColumn("Stok Barang");
    model.addColumn("Harga Jual");
    model.addColumn("Harga Beli");
    autonumber();
    try{
        int no=1;
        String query ="SELECT * FROM barang";
        java.sql.Connection conn = (Connection) koneksi.koneksi();
        java.sql.Statement stm = conn.createStatement();
        java.sql.ResultSet res = stm.executeQuery(query);
        
        while(res.next()){
            DecimalFormat kursIndonesia = (DecimalFormat) DecimalFormat.getCurrencyInstance();
        DecimalFormatSymbols formatRp = new DecimalFormatSymbols();
        
        formatRp.setCurrencySymbol("Rp. ");
        formatRp.setMonetaryDecimalSeparator(',');
        formatRp.setGroupingSeparator('.');

        kursIndonesia.setDecimalFormatSymbols(formatRp);
        String idr1 = kursIndonesia.format(Integer.parseInt(String.valueOf(res.getString(6))));
        String idr2 = kursIndonesia.format(Integer.parseInt(String.valueOf(res.getString(7))));
        
            model.addRow(new Object[] {no++, res.getString(1),res.getString(2), 
            res.getString(3), res.getString(4), res.getString(5), idr1 , idr2});
        }
                jTable1.setModel(model);
    } catch (Exception e){
    }    
}
    public void KurangStok(){
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this  method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn_edit = new javax.swing.JButton();
        txt_IdBarang = new javax.swing.JTextField();
        txt_JenisBarang = new javax.swing.JTextField();
        btn_hapus = new javax.swing.JButton();
        txt_namabarang = new javax.swing.JTextField();
        txt_merkbarang = new javax.swing.JTextField();
        txt_hargajual = new javax.swing.JTextField();
        txt_hargabeli = new javax.swing.JTextField();
        btn_simpan = new javax.swing.JButton();
        txt_stokbarang = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_edit.setBackground(new java.awt.Color(239, 26, 105));
        btn_edit.setForeground(new java.awt.Color(255, 255, 255));
        btn_edit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/percobaan/161.png"))); // NOI18N
        btn_edit.setText("EDIT");
        btn_edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editActionPerformed(evt);
            }
        });
        getContentPane().add(btn_edit, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 360, 110, 50));

        txt_IdBarang.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txt_IdBarang.setOpaque(false);
        txt_IdBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_IdBarangActionPerformed(evt);
            }
        });
        getContentPane().add(txt_IdBarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 160, 110, 40));

        txt_JenisBarang.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txt_JenisBarang.setOpaque(false);
        txt_JenisBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_JenisBarangActionPerformed(evt);
            }
        });
        getContentPane().add(txt_JenisBarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 160, 110, 40));

        btn_hapus.setBackground(new java.awt.Color(239, 26, 105));
        btn_hapus.setForeground(new java.awt.Color(255, 255, 255));
        btn_hapus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/percobaan/160.png"))); // NOI18N
        btn_hapus.setText("HAPUS");
        btn_hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_hapusActionPerformed(evt);
            }
        });
        getContentPane().add(btn_hapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 430, 110, 50));

        txt_namabarang.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txt_namabarang.setOpaque(false);
        getContentPane().add(txt_namabarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 160, 110, 40));

        txt_merkbarang.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txt_merkbarang.setOpaque(false);
        getContentPane().add(txt_merkbarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 160, 110, 40));

        txt_hargajual.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txt_hargajual.setOpaque(false);
        getContentPane().add(txt_hargajual, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 160, 100, 40));

        txt_hargabeli.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txt_hargabeli.setOpaque(false);
        txt_hargabeli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_hargabeliActionPerformed(evt);
            }
        });
        getContentPane().add(txt_hargabeli, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 160, 90, 40));

        btn_simpan.setBackground(new java.awt.Color(239, 26, 105));
        btn_simpan.setForeground(new java.awt.Color(255, 255, 255));
        btn_simpan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/percobaan/162.png"))); // NOI18N
        btn_simpan.setText("SIMPAN");
        btn_simpan.setHideActionText(true);
        btn_simpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_simpanActionPerformed(evt);
            }
        });
        getContentPane().add(btn_simpan, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 300, 110, 40));

        txt_stokbarang.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txt_stokbarang.setOpaque(false);
        getContentPane().add(txt_stokbarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 160, 100, 40));

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
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 230, 880, 380));

        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 60, 40));

        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 310, 50, 50));

        jButton5.setText("jButton2");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 40, 40));

        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 420, 50, 50));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/percobaan/100011.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_IdBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_IdBarangActionPerformed
        // TODO add your handling code here:
     autonumber();
    }//GEN-LAST:event_txt_IdBarangActionPerformed

    private void txt_JenisBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_JenisBarangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_JenisBarangActionPerformed

    private void btn_simpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_simpanActionPerformed
        // TODO add your handling code here:
        try {
            String query = "INSERT INTO barang VALUES('"+txt_IdBarang.getText()+"','"
            +txt_namabarang.getText()+"','"+txt_JenisBarang.getText()+"','"+txt_merkbarang.getText()+"','"
            +txt_stokbarang.getText()+"','"+txt_hargajual.getText()+"','"+txt_hargabeli.getText()+"')";
            java.sql.Connection conn = (Connection) koneksi.koneksi();
            java.sql.PreparedStatement pst = conn.prepareStatement(query);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Penyimpanan data berhasil");
        } catch (Exception e){
        }
        Tabel();
      autonumber();
        
    }//GEN-LAST:event_btn_simpanActionPerformed

    private void btn_editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editActionPerformed
        // TODO add your handling code here:
        try{
            String queruu= "UPDATE `barang` SET  `idbarang`='"+txt_IdBarang.getText()+"',"
            +"`namabarang` ='"+txt_namabarang.getText()+"',"
            +"`jenisbarang`='"+txt_JenisBarang.getText()+"',"
            +"`merk` = '"+txt_merkbarang.getText()+"',"
            +"`stok` ='"+txt_stokbarang.getText()+"',"
            +"`harga_jual` = '"+txt_hargajual.getText()+"',"
            +"`harga_beli` ='"+txt_hargabeli.getText()+"' WHERE `idbarang` = '" + txt_IdBarang.getText() +"'";

            java.sql.Connection conn = (Connection) koneksi.koneksi();
            java.sql.PreparedStatement pst = conn.prepareStatement(queruu);
            pst.execute();
               JOptionPane.showMessageDialog(null, "Edit anda telah berhasil dilakukan");
            Tabel(); autonumber();
        } catch(Exception e){
        } Tabel();  autonumber();
    }//GEN-LAST:event_btn_editActionPerformed

    private void btn_hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_hapusActionPerformed
        // TODO add your handling code here:
        try{
            String hapus= "delete from barang where idbarang='"+txt_IdBarang.getText() +"'";
            java.sql.Connection conn = (Connection) koneksi.koneksi();
            java.sql.PreparedStatement pst = conn.prepareStatement(hapus);
            pst.execute();
              JOptionPane.showMessageDialog(null, "Data Anda Telah Terhapus");
            Tabel();
        } catch(Exception e){
           
        } Tabel(); autonumber();
    }//GEN-LAST:event_btn_hapusActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        int baris =jTable1.rowAtPoint(evt.getPoint());
        String id_barang =jTable1.getValueAt(baris,1).toString();
        txt_IdBarang.setText(id_barang);
        txt_IdBarang.disable();
        if (jTable1.getValueAt(baris,2)==null){
            txt_namabarang.setText("");
        } else {
            txt_namabarang.setText(jTable1.getValueAt(baris,2 ).toString());
        }
        if (jTable1.getValueAt(baris,3)==null){
            txt_JenisBarang.setText("");
        } else{
            txt_JenisBarang.setText(jTable1.getValueAt(baris, 3).toString());
        } if (jTable1.getValueAt(baris,4)==null){
        }else{
            txt_merkbarang.setText(jTable1.getValueAt(baris, 4).toString());
        } if (jTable1.getValueAt(baris,5)==null){
        }else{
            txt_stokbarang.setText(jTable1.getValueAt(baris, 5).toString());

        } if (jTable1.getValueAt(baris,6)==null){
        }else{

            txt_hargajual.setText(jTable1.getValueAt(baris, 6).toString());
        } if (jTable1.getValueAt(baris,7)==null){
        }else{

            txt_hargabeli.setText(jTable1.getValueAt(baris, 7).toString());
        }

    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        new barang(usernameD).setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        new supplier(usernameD).setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        new home(usernameD).setVisible(true);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void txt_hargabeliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_hargabeliActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_hargabeliActionPerformed

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
            java.util.logging.Logger.getLogger(barang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(barang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(barang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(barang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new barang(usernameD).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_edit;
    private javax.swing.JButton btn_hapus;
    private javax.swing.JButton btn_simpan;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txt_IdBarang;
    private javax.swing.JTextField txt_JenisBarang;
    private javax.swing.JTextField txt_hargabeli;
    private javax.swing.JTextField txt_hargajual;
    private javax.swing.JTextField txt_merkbarang;
    private javax.swing.JTextField txt_namabarang;
    private javax.swing.JTextField txt_stokbarang;
    // End of variables declaration//GEN-END:variables
}