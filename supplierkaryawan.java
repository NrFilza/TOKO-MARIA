/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package percobaan;

/**
 *
 * @author User
 */
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class supplierkaryawan extends javax.swing.JFrame {

    /**
     * Creates new form supplier
     */
   static String usernams;
    public supplierkaryawan(String usrna) {
        initComponents();
        tabel();
        this.usernams = usrna;
    }
    private void autonumber(){
        try {
            String sql = "SELECT * FROM supplier ORDER BY idsupplier DESC";
            java.sql.Connection conn=(Connection) koneksi.koneksi();
            java.sql.Statement stm=conn.createStatement();
            java.sql.ResultSet r=stm.executeQuery(sql);
            if (r.next()) {
                String NoFaktur = r.getString("idsupplier").substring(2);
                String TR = "" +(Integer.parseInt(NoFaktur)+1);
                String Nol = "";
                
                if(TR.length()==1)
                {Nol = "0";}
                else if(TR.length()==2)
                {Nol = "";}
                txt_IdSupplier.setText("SP" + Nol + TR);
            } else {
           txt_IdSupplier.setText("SP01");
            }
        } catch (Exception e) {
            System.out.println("autonumber error");
        }
    }
     private void tabel (){
         //Untuk menampilkan tabel
         DefaultTableModel model = new DefaultTableModel();
         model.addColumn("No");
         model.addColumn("Id Supplier");
         model.addColumn("Nama Supplier");
         model.addColumn("No Telephone");
         model.addColumn("Alamat");
         autonumber();
         try{
        int no=1;
        String query ="SELECT * FROM supplier";
        java.sql.Connection conn = (Connection) koneksi.koneksi();
        java.sql.Statement stm = conn.createStatement();
        java.sql.ResultSet res = stm.executeQuery(query);
        while(res.next()){
            model.addRow(new Object[] {no++,res.getString(1),res.getString(2), 
            res.getString(3), res.getString(4)});
        }
                jTable1.setModel(model);
    } catch (Exception e){
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

        txt_IdSupplier = new javax.swing.JTextField();
        txt_NamaSupplier = new javax.swing.JTextField();
        txt_nomertelpon = new javax.swing.JTextField();
        txt_Alamat = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        txt_edit = new javax.swing.JButton();
        btn_simpan = new javax.swing.JButton();
        btn_hapus = new javax.swing.JButton();
        btn_chat = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_IdSupplier.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txt_IdSupplier.setOpaque(false);
        txt_IdSupplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_IdSupplierActionPerformed(evt);
            }
        });
        getContentPane().add(txt_IdSupplier, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 160, 130, 50));

        txt_NamaSupplier.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txt_NamaSupplier.setOpaque(false);
        txt_NamaSupplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_NamaSupplierActionPerformed(evt);
            }
        });
        getContentPane().add(txt_NamaSupplier, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 160, 120, 50));

        txt_nomertelpon.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txt_nomertelpon.setOpaque(false);
        getContentPane().add(txt_nomertelpon, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 160, 120, 50));

        txt_Alamat.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txt_Alamat.setOpaque(false);
        txt_Alamat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_AlamatActionPerformed(evt);
            }
        });
        getContentPane().add(txt_Alamat, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 160, 120, 50));

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

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 240, 1000, 350));

        txt_edit.setBackground(new java.awt.Color(239, 26, 105));
        txt_edit.setForeground(new java.awt.Color(255, 255, 255));
        txt_edit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/percobaan/161.png"))); // NOI18N
        txt_edit.setText("EDIT");
        txt_edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_editActionPerformed(evt);
            }
        });
        getContentPane().add(txt_edit, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 170, 100, 30));

        btn_simpan.setBackground(new java.awt.Color(239, 26, 105));
        btn_simpan.setForeground(new java.awt.Color(255, 255, 255));
        btn_simpan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/percobaan/162.png"))); // NOI18N
        btn_simpan.setText("SIMPAN");
        btn_simpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_simpanActionPerformed(evt);
            }
        });
        getContentPane().add(btn_simpan, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 170, 100, 30));

        btn_hapus.setBackground(new java.awt.Color(239, 26, 105));
        btn_hapus.setForeground(new java.awt.Color(255, 255, 255));
        btn_hapus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/percobaan/160.png"))); // NOI18N
        btn_hapus.setText("HAPUS");
        btn_hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_hapusActionPerformed(evt);
            }
        });
        getContentPane().add(btn_hapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 170, 90, 30));

        btn_chat.setBackground(new java.awt.Color(239, 26, 105));
        btn_chat.setForeground(new java.awt.Color(255, 255, 255));
        btn_chat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/percobaan/163.png"))); // NOI18N
        btn_chat.setText("HUBUNGI SUPPLIER");
        btn_chat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_chatActionPerformed(evt);
            }
        });
        getContentPane().add(btn_chat, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 620, 170, 40));

        jButton1.setToolTipText("");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 300, 50, 50));

        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 410, 50, 50));

        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 250, 50, 50));

        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 190, 50, 50));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/percobaan/1000012.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_NamaSupplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_NamaSupplierActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_NamaSupplierActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // 
        int baris =jTable1.rowAtPoint(evt.getPoint());
        String id_supplier =jTable1.getValueAt(baris,1).toString();
        txt_IdSupplier.setText(id_supplier);
        txt_IdSupplier.disable();
        if (jTable1.getValueAt(baris,2)==null){
            txt_NamaSupplier.setText("");
        } else {
            txt_NamaSupplier.setText(jTable1.getValueAt(baris,2 ).toString());
        }
        if (jTable1.getValueAt(baris,3)==null){
            txt_nomertelpon.setText("");
        } else{
            txt_nomertelpon.setText(jTable1.getValueAt(baris, 3).toString());
        } if (jTable1.getValueAt(baris,4)==null){
        }else{
            txt_Alamat.setText(jTable1.getValueAt(baris, 4).toString());
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void btn_simpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_simpanActionPerformed
        // TODO add your handling code here:
        try {
            String query = "INSERT INTO supplier VALUES('"+txt_IdSupplier.getText()+"','"
            +txt_NamaSupplier.getText()+"','"+txt_nomertelpon.getText()+"','"+txt_Alamat.getText() + "')";
            java.sql.Connection conn = (Connection) koneksi.koneksi();
            java.sql.PreparedStatement pst = conn.prepareStatement(query);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Penyimpanan data berhasil");
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        tabel();
autonumber();
    }//GEN-LAST:event_btn_simpanActionPerformed

    private void btn_hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_hapusActionPerformed
        // TODO add your handling code here:
        try{
            String hapus= "delete from supplier where idsupplier='"+txt_IdSupplier.getText() +"'";
            java.sql.Connection conn = (Connection) koneksi.koneksi();
            java.sql.PreparedStatement pst = conn.prepareStatement(hapus);
            pst.execute();
            tabel();
        } catch(SQLException e){
            e.printStackTrace();
        } tabel();autonumber();
    }//GEN-LAST:event_btn_hapusActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
                    new supplierkaryawan(usernams).setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btn_chatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_chatActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
                    new hubungisupplier(usernams).setVisible(true);
    }//GEN-LAST:event_btn_chatActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        new barang(usernams).setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        new home(usernams).setVisible(true);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void txt_IdSupplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_IdSupplierActionPerformed
        // TODO add your handling code here:
        autonumber();
    }//GEN-LAST:event_txt_IdSupplierActionPerformed

    private void txt_editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_editActionPerformed
       // TODO add your handling code here:
        try {
            String sql = "UPDATE `supplier` SET `idsupplier` ='"+txt_IdSupplier.getText()+"',"
                    + "`nama_supplier`='"+txt_NamaSupplier.getText()+"',"
                    +"`notelp` ='"+txt_nomertelpon.getText()+"',"
                    +"`alamat` ='"+txt_Alamat.getText()+"' WHERE idsupplier = '"+txt_IdSupplier.getText()+"'";
            java.sql.Connection conn = (Connection) koneksi.koneksi();
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);
            pst.execute();
            tabel(); autonumber();
        }   
      catch(SQLException e){
          JOptionPane.showMessageDialog(null, e);
      }
    }//GEN-LAST:event_txt_editActionPerformed

    private void txt_AlamatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_AlamatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_AlamatActionPerformed

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
            java.util.logging.Logger.getLogger(supplierkaryawan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(supplierkaryawan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(supplierkaryawan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(supplierkaryawan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new supplierkaryawan(usernams).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_chat;
    private javax.swing.JButton btn_hapus;
    private javax.swing.JButton btn_simpan;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txt_Alamat;
    private javax.swing.JTextField txt_IdSupplier;
    private javax.swing.JTextField txt_NamaSupplier;
    private javax.swing.JButton txt_edit;
    private javax.swing.JTextField txt_nomertelpon;
    // End of variables declaration//GEN-END:variables
}
