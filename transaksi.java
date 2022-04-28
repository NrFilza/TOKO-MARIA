/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package percobaan;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author User
 */

public class transaksi extends javax.swing.JFrame {

    /**
     * Creates new form transaksi
     */
    private DefaultTableModel model;
    String tanggal;
    public transaksi() {
        initComponents();
        model = new DefaultTableModel();
        
        jTable1.setModel(model);
        
        model.addColumn("Kode Penjualan");
        model.addColumn("Kode Produk");
        model.addColumn("Nama Produk");
        model.addColumn("Jumlah");
        model.addColumn("Harga");
        model.addColumn("Total Harga"); 
        
        utama();
        Date date = new Date();
        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
        txTanggal.setText(s.format(date));
        
     
        
        
        autonumber();
        
    }
    public void totalJumlah(){
        int jumlahBaris = jTable1.getRowCount();
        int hargaBarang;
        int totalJumlah = 0;
        for (int i = 0; i < jumlahBaris; i++) {
            hargaBarang = Integer.parseInt(jTable1.getValueAt(i, 3).toString()); 
            totalJumlah = totalJumlah + hargaBarang ;
        }
        qty.setText(""+totalJumlah);
        qty.setVisible(false);
    }
    
    public void totalBiaya(){
        int jumlahBaris = jTable1.getRowCount();
        int totalBiaya = 0;
        int jumlahBarang, hargaBarang;
        DecimalFormat kursIndonesia = (DecimalFormat) DecimalFormat.getCurrencyInstance();
        DecimalFormatSymbols formatRp = new DecimalFormatSymbols();
        
        formatRp.setCurrencySymbol("Rp. ");
        formatRp.setMonetaryDecimalSeparator(',');
        formatRp.setGroupingSeparator('.');

        kursIndonesia.setDecimalFormatSymbols(formatRp);
        
        
        for (int i = 0; i < jumlahBaris; i++) {
            jumlahBarang = Integer.parseInt(jTable1.getValueAt(i, 3).toString());
            hargaBarang = Integer.parseInt(jTable1.getValueAt(i, 4).toString());
            totalBiaya = totalBiaya + (jumlahBarang * hargaBarang);
        }
        
        String idr = kursIndonesia.format(Integer.parseInt(String.valueOf(totalBiaya)));
        txtampil.setText( idr );
        grandtotal.setText(""+totalBiaya);
        grandtotal.setVisible(false);
    }
    
    private void autonumber(){
        try {
            String sql = "SELECT * FROM transaksi ORDER BY idtransaksi DESC";
            java.sql.Connection conn=(Connection) koneksi.koneksi();
            java.sql.Statement stm=conn.createStatement();
            java.sql.ResultSet r=stm.executeQuery(sql);
            if (r.next()) {
                String NoFaktur = r.getString("idtransaksi").substring(2);
                String TR = "" +(Integer.parseInt(NoFaktur)+1);
                String Nol = "";
                
                if(TR.length()==1)
                {Nol = "0";}
                else if(TR.length()==2)
                {Nol = "";}
                txt_idtransaksi.setText("TR" + Nol + TR);
            } else {
            txt_idtransaksi.setText("TR01");
            }
        } catch (Exception e) {
            System.out.println("autonumber error");
        }
    }
    
    public void loadData(){
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.addRow(new Object[]{
            txt_idtransaksi.getText(),
            txt_idbarang.getText(),
            txt_namabarang.getText(),
            txt_jumlah.getText(),
            txt_harga.getText(),
            txtampil.getText()
        });
    }
    public void kosong(){
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        
        while (model.getRowCount()>0) {
            model.removeRow(0);
        }
    }
    
    public void utama(){
        txt_idtransaksi.setText("");
        txt_idbarang.setText("");
        txt_namabarang.setText("");
        txt_jumlah.setText("");
        txt_harga.setText("");
        
        autonumber();
    }
    
    public void clear(){
     //   txtampil.setText("0");
    }
    
    public void clear2(){
//        txt_idbarang.setText("");
//        txt_namabarang.setText("");
//        txt_harga.setText("");
//        txt_harga.setText("");
    }
    
    public void tambahTransaksi(){
        int jumlah, harga, total;
        
        jumlah = Integer.valueOf(txt_jumlah.getText());
        harga = Integer.valueOf(txt_harga.getText());
        total = jumlah * harga;
        
        txtampil.setText(String.valueOf(total));
        
        loadData();
        totalJumlah();
        totalBiaya();
        clear2();
        txt_idbarang.requestFocus();
    }
public void totalKembalian(){
         DecimalFormat kursIndonesia = (DecimalFormat) DecimalFormat.getCurrencyInstance();
        DecimalFormatSymbols formatRp = new DecimalFormatSymbols();
        
        formatRp.setCurrencySymbol("Rp. ");
        formatRp.setMonetaryDecimalSeparator(',');
        formatRp.setGroupingSeparator('.');

        kursIndonesia.setDecimalFormatSymbols(formatRp);
        
        int kembalian, totalkembalian, totalKembalian;
        kembalian = Integer.parseInt(txt_uanguser.getText());
        totalkembalian = Integer.parseInt(grandtotal.getText());
        totalKembalian = kembalian-totalkembalian;
         String idr = kursIndonesia.format(Integer.parseInt(String.valueOf(totalKembalian)));
         txtkembalian.setText(idr);
        txtkembalian.setText(idr);
        }
public void konversiRupiah(){
        DecimalFormat kursIndonesia = (DecimalFormat) DecimalFormat.getCurrencyInstance();
        DecimalFormatSymbols formatRp = new DecimalFormatSymbols();
        
        formatRp.setCurrencySymbol("Rp. ");
        formatRp.setMonetaryDecimalSeparator(',');
        formatRp.setGroupingSeparator('.');

        kursIndonesia.setDecimalFormatSymbols(formatRp);

        String harga = "100000";
        String idr = kursIndonesia.format(Integer.parseInt(harga));
        //System.out.println(idr);
        //set text jLabel.setText(idr)
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txt_idtransaksi = new javax.swing.JTextField();
        txt_idbarang = new javax.swing.JTextField();
        txt_namabarang = new javax.swing.JTextField();
        txt_harga = new javax.swing.JTextField();
        txt_jumlah = new javax.swing.JTextField();
        btn_tambah = new javax.swing.JButton();
        btn_hapus = new javax.swing.JButton();
        btn_simpan = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btn_cari = new javax.swing.JButton();
        txtampil = new javax.swing.JTextField();
        txTanggal = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txt_uanguser = new javax.swing.JTextField();
        txtkembalian = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        qty = new javax.swing.JTextField();
        grandtotal = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_idtransaksi.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txt_idtransaksi.setEnabled(false);
        getContentPane().add(txt_idtransaksi, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 150, 110, 40));

        txt_idbarang.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txt_idbarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_idbarangActionPerformed(evt);
            }
        });
        getContentPane().add(txt_idbarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 150, 100, 40));

        txt_namabarang.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_namabarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 150, 100, 40));

        txt_harga.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_harga, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 150, 160, 40));

        txt_jumlah.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txt_jumlah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_jumlahActionPerformed(evt);
            }
        });
        getContentPane().add(txt_jumlah, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 160, 120, 30));

        btn_tambah.setText("HITUNG");
        btn_tambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_tambahActionPerformed(evt);
            }
        });
        getContentPane().add(btn_tambah, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 230, 80, 30));

        btn_hapus.setText("HAPUS");
        btn_hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_hapusActionPerformed(evt);
            }
        });
        getContentPane().add(btn_hapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 230, 70, 30));

        btn_simpan.setText("SIMPAN");
        btn_simpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_simpanActionPerformed(evt);
            }
        });
        getContentPane().add(btn_simpan, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 230, 80, 30));

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

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 290, 720, 330));

        btn_cari.setText("CARI");
        btn_cari.setToolTipText("");
        btn_cari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cariActionPerformed(evt);
            }
        });
        getContentPane().add(btn_cari, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 150, 60, 30));

        txtampil.setBorder(null);
        txtampil.setEnabled(false);
        getContentPane().add(txtampil, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 330, 190, 50));

        txTanggal.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txTanggal.setBorder(null);
        txTanggal.setEnabled(false);
        getContentPane().add(txTanggal, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 240, 200, 30));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Total Bayar :");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 300, -1, -1));

        txt_uanguser.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                txt_uanguserComponentAdded(evt);
            }
        });
        txt_uanguser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txt_uanguserMouseClicked(evt);
            }
        });
        txt_uanguser.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_uanguserKeyReleased(evt);
            }
        });
        getContentPane().add(txt_uanguser, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 420, 200, 30));

        txtkembalian.setEnabled(false);
        getContentPane().add(txtkembalian, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 490, 190, 40));

        jLabel3.setText("Uang ");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 400, 100, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/percobaan/1000014.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        qty.setText("jTextField1");
        getContentPane().add(qty, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 140, -1, -1));

        grandtotal.setText("jTextField1");
        getContentPane().add(grandtotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 150, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_tambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tambahActionPerformed
        // TODO add your handling code here:
        tambahTransaksi();
    }//GEN-LAST:event_btn_tambahActionPerformed

    private void btn_hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_hapusActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        int row = jTable1.getSelectedRow();
        model.removeRow(row);
        totalBiaya();
    }//GEN-LAST:event_btn_hapusActionPerformed

    private void btn_simpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_simpanActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        String noTransaksi = txt_idtransaksi.getText();
        String tanggal = txTanggal.getText();
        String totalhrg = txt_harga.getText();
        String qty1 = qty.getText();
        String ttlk = grandtotal.getText();
        try {
            String sql = "INSERT INTO `transaksi`(`idtransaksi`, `tanggal`, `qty`, `totalkeseluruhan`) "
                    + "VALUES ('"+noTransaksi+"','"
            +tanggal+"',"+"'"+qty1+"','"+ttlk+"')";
            System.out.println(sql);
            java.sql.Connection conn=(Connection)koneksi.koneksi();
            java.sql.PreparedStatement pst=conn.prepareStatement(sql);
            
            pst.executeUpdate();
            pst.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
       try {
            Connection c = (Connection)koneksi.koneksi();
            int baris = jTable1.getRowCount();
            
            for (int i = 0; i < baris; i++) {
                String sql = "INSERT INTO `detailtransaksi` (`idtransaksi`,`nama_barang`,"
                        + "`jumlah`,`harga_jual`,`idbarang`,`tanggal`) VALUES ('"+jTable1.getValueAt(i, 0)+
                        "','" + jTable1.getValueAt(i, 2) + "','"
                        + jTable1.getValueAt(i, 3) +"','"+ jTable1.getValueAt(i, 5)
                        +"','"+jTable1.getValueAt(i,1) +"','"+tanggal+"')";
                       
            System.out.println(sql);
                PreparedStatement p = c.prepareStatement(sql);
                p.executeUpdate();
                p.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        clear();
        utama();
        autonumber();
        kosong();
        txtampil.setText("Rp. 0");
        this.setVisible(false);
    }//GEN-LAST:event_btn_simpanActionPerformed

    private void btn_cariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cariActionPerformed
        // TODO add your handling code here:
        new caribarang().setVisible(true);
    }//GEN-LAST:event_btn_cariActionPerformed

    private void txt_idbarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_idbarangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_idbarangActionPerformed

    private void txt_uanguserComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_txt_uanguserComponentAdded
        // TODO add your handling code here:
        
    }//GEN-LAST:event_txt_uanguserComponentAdded

    private void txt_uanguserKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_uanguserKeyReleased
        // TODO add your handling code here:
       
        
        int kembalian = Integer.parseInt(txt_uanguser.getText());
        int totalkembalian = Integer.parseInt(grandtotal.getText());
        if(kembalian>totalkembalian){
             totalKembalian();
             
        }
    }//GEN-LAST:event_txt_uanguserKeyReleased

    private void txt_uanguserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_uanguserMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_txt_uanguserMouseClicked

    private void txt_jumlahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_jumlahActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_jumlahActionPerformed

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
            java.util.logging.Logger.getLogger(transaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(transaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(transaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(transaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new transaksi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cari;
    private javax.swing.JButton btn_hapus;
    private javax.swing.JButton btn_simpan;
    private javax.swing.JButton btn_tambah;
    private javax.swing.JTextField grandtotal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField qty;
    private javax.swing.JTextField txTanggal;
    public static javax.swing.JTextField txt_harga;
    public static javax.swing.JTextField txt_idbarang;
    private javax.swing.JTextField txt_idtransaksi;
    public static javax.swing.JTextField txt_jumlah;
    public static javax.swing.JTextField txt_namabarang;
    private javax.swing.JTextField txt_uanguser;
    private javax.swing.JTextField txtampil;
    private javax.swing.JTextField txtkembalian;
    // End of variables declaration//GEN-END:variables
}
