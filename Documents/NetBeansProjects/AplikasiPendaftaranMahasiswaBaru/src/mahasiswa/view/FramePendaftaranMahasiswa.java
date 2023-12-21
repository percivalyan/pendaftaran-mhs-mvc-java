/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package mahasiswa.view;
import javax.swing.JComboBox;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JTable;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import static groovy.inspect.Inspector.print;
import java.awt.Desktop;
import java.awt.print.PrinterJob;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import javax.swing.JFrame;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
import javax.swing.JTextField;
//import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;
import mahasiswa.controller.MahasiswaController;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import mahasiswa.dao.imp.MahasiswaDAOImp;
import mahasiswa.koneksi.KoneksiDatabase;
import mahasiswa.model.Mahasiswa;

import java.sql.Connection;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import mahasiswa.login.FrameLogin;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author HP
 */
public class FramePendaftaranMahasiswa extends javax.swing.JFrame {

    private String jasperPrint;
//    public Statement st;
//    public ResultSet rs;
//    Connection cn = mahasiswa.koneksi.KoneksiDatabase.koneksi();
    /**
     * Creates new form MainGUI
     */
    public void updateTabel(List<Mahasiswa> data) {
        DefaultTableModel model = (DefaultTableModel) Tabel_Data.getModel();
        model.setRowCount(0); // Mengosongkan tabel

//        for (Mahasiswa mhs : data) {
//            Object[] row = {mhs.getNpm(), mhs.getNama(), mhs.getProgram1(), mhs.getProgram2()};
//            model.addRow(row);
//        }
        
        for (Mahasiswa mhs : data) {
    Object[] row = {
        mhs.getNpm(),
        mhs.getNama(),
        mhs.getTempatLahir(),
        mhs.getTanggal(),
//        mhs.getBulan(),
//        mhs.getTahun(),
        mhs.getGender(),
        mhs.getNoTelepon(),
        mhs.getEmail(),
        mhs.getAlamat(),
        mhs.getAsalSekolah(),
        mhs.getTahunLulus(),
        mhs.getProgram1(),
        mhs.getProgram2(),
//        mhs.getNamaOrangTua(),
//        mhs.getPekerjaanOrangTua(),
//        mhs.getPenghasilanOrangTua(),
//        mhs.getJumlahAnak()
    };
    model.addRow(row);
}


    }

    //DefaultTableModel model; //Default Tabel (1A)
    //Buat Objek Kelas Controller
    MahasiswaController mhsController;
    

    public FramePendaftaranMahasiswa() {
        initComponents();
        
        initTableListener();
        
        // Set the frame size to the screen size
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        // Set the default close operation
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Menonaktifkan resize
//        setResizable(false);
//
//        // Menetapkan ukuran frame
//        setSize(560, 700);
//
//        // Menetapkan operasi default ketika tombol close diklik
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("NPM");
        model.addColumn("Mahasiswa");
        model.addColumn("Tempat Lahir");
        model.addColumn("Tanggal Lahir");
        model.addColumn("Gender");
        model.addColumn("No Telepon");
        model.addColumn("E-mail");
        model.addColumn("Alamat");
        model.addColumn("Asal Sekolah");
        model.addColumn("Tahun Lulus");
        model.addColumn("Program 1");
        model.addColumn("Program 2");
        Tabel_Data.setModel(model);
    }
  
    
private void initTableListener() {
    Tabel_Data.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
        @Override
        public void valueChanged(ListSelectionEvent e) {
            if (!e.getValueIsAdjusting()) {
                int selectedRow = Tabel_Data.getSelectedRow();
                if (selectedRow != -1) {
                    // Baris dipilih, isi kolom input dengan data dari baris tersebut
                    String npm = Objects.toString(Tabel_Data.getValueAt(selectedRow, 0), "");
                    String nama = Objects.toString(Tabel_Data.getValueAt(selectedRow, 1), "");
                    String tempatLahir = Objects.toString(Tabel_Data.getValueAt(selectedRow, 2), "");
                     String tanggal = Objects.toString(Tabel_Data.getValueAt(selectedRow, 3), "");
                    String gender = Objects.toString(Tabel_Data.getValueAt(selectedRow, 4), "");
                    String noTelepon = Objects.toString(Tabel_Data.getValueAt(selectedRow, 5), "");
                    String email = Objects.toString(Tabel_Data.getValueAt(selectedRow, 6), "");
                    String alamat = Objects.toString(Tabel_Data.getValueAt(selectedRow, 7), "");
                    String asalSekolah = Objects.toString(Tabel_Data.getValueAt(selectedRow, 8), "");
                    String tahunLulus = Objects.toString(Tabel_Data.getValueAt(selectedRow, 9), "");
                     String studi1 = Objects.toString(Tabel_Data.getValueAt(selectedRow, 10), "");
                    String studi2 = Objects.toString(Tabel_Data.getValueAt(selectedRow, 11), "");
                    
                    npmTextField.setText(npm);
                    namaTextField.setText(nama);
                    tempatlahirTextField.setText(tempatLahir);
                    tanggalTextField.setText(tanggal);
//                    bulanComboBox.setSelectedItem(bulan);
//                    tahunComboBox.setSelectedItem(tahun);
                    genderComboBox.setSelectedItem(gender);
                    noteleponTextField.setText(noTelepon);
                    emailTextField.setText(email);
                    alamatTextField.setText(alamat);
                    asalsekolahTextField.setText(asalSekolah);
                    tahunlulusTextField.setText(tahunLulus);
                    studi1ComboBox.setSelectedItem(studi1);
                    studi2ComboBox.setSelectedItem(studi2);
                }
            }
        }
    });
}

    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        npmTextField = new javax.swing.JTextField();
        tempatlahirTextField = new javax.swing.JTextField();
        namaTextField = new javax.swing.JTextField();
        noteleponTextField = new javax.swing.JTextField();
        genderComboBox = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        btn_update = new javax.swing.JButton();
        btn_hapus = new javax.swing.JButton();
        btn_reset = new javax.swing.JButton();
        btn_cetak = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        CariTextField = new javax.swing.JTextField();
        btn_cari = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tabel_Data = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        emailTextField = new javax.swing.JTextField();
        alamatTextField = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        asalsekolahTextField = new javax.swing.JTextField();
        jLabel40 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        tahunlulusTextField = new javax.swing.JTextField();
        studi1ComboBox = new javax.swing.JComboBox<>();
        studi2ComboBox = new javax.swing.JComboBox<>();
        btn_tambah = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        tanggalTextField = new javax.swing.JTextField();
        btn_customprint = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(102, 102, 255));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("NO. TELP");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText("NAMA");

        npmTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                npmTextFieldActionPerformed(evt);
            }
        });

        genderComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "Laki-Laki", "Perempuan" }));

        jLabel1.setFont(new java.awt.Font("Roboto Black", 1, 24)); // NOI18N
        jLabel1.setText("FORMULIR PENDAFTARAN MAHASISWA BARU");
        jLabel1.setVerifyInputWhenFocusTarget(false);

        btn_update.setText("UPDATE");
        btn_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_updateActionPerformed(evt);
            }
        });

        btn_hapus.setText("DELETE");
        btn_hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_hapusActionPerformed(evt);
            }
        });

        btn_reset.setText("RESET");
        btn_reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_resetActionPerformed(evt);
            }
        });

        btn_cetak.setText("PRINT");
        btn_cetak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cetakActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setText("NO. PENDAFTARAN");

        jLabel6.setText("Pencarian Berdasarkan Nama:");

        btn_cari.setText("CARI");
        btn_cari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cariActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahasiswa/assets/main.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(442, 442, 442)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 403, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel10.setText("GENDER");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel12.setText("TEMPAT LAHIR");

        Tabel_Data.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(Tabel_Data);

        jLabel9.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        jLabel9.setText("DATA PRIBADI");
        jLabel9.setVerifyInputWhenFocusTarget(false);

        emailTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailTextFieldActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel14.setText("ALAMAT");

        jLabel11.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        jLabel11.setText("PILIHAN PROGRAM");
        jLabel11.setVerifyInputWhenFocusTarget(false);

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel16.setText("PROGRAM STUDI 2");

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel17.setText("PROGRAM STUDI 1");

        jLabel40.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel40.setText("ASAL SEKOLAH");

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel18.setText("TANGGAL LAHIR");

        jLabel41.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel41.setText("TAHUN KELULUSAN");

        studi1ComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "Teknik Informatika (S1)", "Teknik Mesin (S1)", "Teknik Industri (S1)", "Sistem Informasi (S1)" }));

        studi2ComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "Teknik Informatika (S1)", "Teknik Mesin (S1)", "Teknik Industri (S1)", "Sistem Informasi (S1)" }));

        btn_tambah.setText("INSERT");
        btn_tambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_tambahActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setText("EMAIL");

        tanggalTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tanggalTextFieldActionPerformed(evt);
            }
        });

        btn_customprint.setText("CUSTOM PRINT");
        btn_customprint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_customprintActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(359, 359, 359)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(CariTextField)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_cari, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(113, 113, 113))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(164, 164, 164))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel11)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel17)
                                                .addComponent(jLabel16)
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                    .addComponent(btn_tambah)
                                                    .addGap(18, 18, 18)
                                                    .addComponent(btn_reset)))
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                    .addGap(18, 18, 18)
                                                    .addComponent(btn_update)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                    .addComponent(btn_hapus, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(studi1ComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(studi2ComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel41, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addGap(2, 2, 2)
                                            .addComponent(tahunlulusTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(2, 2, 2))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(emailTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(alamatTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(asalsekolahTextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                            .addGap(1, 1, 1)))
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(noteleponTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(namaTextField)
                                                    .addComponent(tempatlahirTextField)
                                                    .addComponent(tanggalTextField, javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(npmTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(genderComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addGap(17, 17, 17)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btn_cetak, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btn_customprint, javax.swing.GroupLayout.PREFERRED_SIZE, 616, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 955, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(346, 346, 346))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(CariTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_cari))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(npmTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addGap(23, 23, 23)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(namaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tempatlahirTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18)
                            .addComponent(tanggalTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(genderComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addGap(21, 21, 21)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(noteleponTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(emailTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(alamatTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(asalsekolahTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel40))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tahunlulusTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel41))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17)
                            .addComponent(studi1ComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(studi2ComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 499, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_tambah)
                            .addComponent(btn_update)
                            .addComponent(btn_reset, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_hapus)
                            .addComponent(btn_cetak, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_customprint))))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(1342, 735));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_cariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cariActionPerformed
        if (mhsController == null) {
            try {
                // Jika mhsController belum diinisialisasi, inisialisasi di sini
                mhsController = new MahasiswaController(this);
            } catch (SQLException ex) {
                Logger.getLogger(FramePendaftaranMahasiswa.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        // Ambil teks dari kolom pencarian
        String namaCari = CariTextField.getText();

        // Lakukan pencarian berdasarkan nama
        mhsController.cariNama(namaCari);
    }//GEN-LAST:event_btn_cariActionPerformed

    private void btn_cetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cetakActionPerformed
        Document document = new Document();
        try {
            // Mendapatkan waktu saat ini untuk digunakan sebagai nama file PDF
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss");
            String timestamp = sdf.format(new Date());

            // Nama file PDF
            String pdfFileName = "Data_Mahasiswa_" + timestamp + ".pdf";

            // Lokasi penyimpanan file PDF
            String pdfFilePath = System.getProperty("user.home") + File.separator + pdfFileName;

            PdfWriter.getInstance(document, new FileOutputStream(pdfFilePath));

            document.open();

            // Judul PDF
            Font fontTitle = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 16, BaseColor.BLACK);
            Paragraph title = new Paragraph("DATA MAHASISWA", fontTitle);
            title.setAlignment(Element.ALIGN_CENTER);
            document.add(title);
            document.add(new Paragraph("\n")); // Baris kosong

            // Tabel PDF
            PdfPTable pdfTable = new PdfPTable(Tabel_Data.getColumnCount());
            pdfTable.setWidthPercentage(100);

            // Header
            Font fontHeader = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 9, BaseColor.BLACK);
            for (int i = 0; i < Tabel_Data.getColumnCount(); i++) {
                PdfPCell cell = new PdfPCell(new Phrase(Tabel_Data.getColumnName(i), fontHeader));
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                pdfTable.addCell(cell);
            }

            // Data
            Font fontData = FontFactory.getFont(FontFactory.HELVETICA, 8, BaseColor.BLACK);
            for (int i = 0; i < Tabel_Data.getRowCount(); i++) {
                for (int j = 0; j < Tabel_Data.getColumnCount(); j++) {
                    PdfPCell cell = new PdfPCell(new Phrase(String.valueOf(Tabel_Data.getValueAt(i, j)), fontData));
                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    pdfTable.addCell(cell);
                }
            }

            document.add(pdfTable);

            // Menutup dokumen dan menampilkan file PDF
            document.close();
            Desktop.getDesktop().open(new File(pdfFilePath));

        } catch (DocumentException | IOException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btn_cetakActionPerformed

    private void btn_resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_resetActionPerformed
        if (mhsController == null) {
            try {
                // jika mhsController belum diinisialisasi, inisialisasi di sini
                mhsController = new MahasiswaController(this);
            } catch (SQLException ex) {
                Logger.getLogger(FramePendaftaranMahasiswa.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        mhsController.reset();
    }//GEN-LAST:event_btn_resetActionPerformed

    private void btn_hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_hapusActionPerformed
        if (mhsController == null) {
            try {
                // jika mhsController belum diinisialisasi, inisialisasi di sini
                mhsController = new MahasiswaController(this);
            } catch (SQLException ex) {
                Logger.getLogger(FramePendaftaranMahasiswa.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        mhsController.delete();
    }//GEN-LAST:event_btn_hapusActionPerformed

    //MEMPERBARUHI
    private void btn_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_updateActionPerformed
        if (mhsController == null) {
            try {
                // jika mhsController belum diinisialisasi, inisialisasi di sini
                mhsController = new MahasiswaController(this);
            } catch (SQLException ex) {
                Logger.getLogger(FramePendaftaranMahasiswa.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        mhsController.update();
    }//GEN-LAST:event_btn_updateActionPerformed

    private void npmTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_npmTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_npmTextFieldActionPerformed

    private void btn_tambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tambahActionPerformed
        if (mhsController == null) {
          try {
              // jika mhsController belum diinisialisasi, inisialisasi di sini
              mhsController = new MahasiswaController(this);
          } catch (SQLException ex) {
              Logger.getLogger(FramePendaftaranMahasiswa.class.getName()).log(Level.SEVERE, null, ex);
          }
    }

    mhsController.insert();
    //mhsController.update();
    mhsController.tampilkanData();
    }//GEN-LAST:event_btn_tambahActionPerformed

    private void emailTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailTextFieldActionPerformed

    private void tanggalTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tanggalTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tanggalTextFieldActionPerformed

    private void btn_customprintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_customprintActionPerformed
        FrameCetak frameCetak = new FrameCetak();
        frameCetak.setVisible(true);
    }//GEN-LAST:event_btn_customprintActionPerformed

       
   
    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(FramePendaftaranMahasiswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(FramePendaftaranMahasiswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(FramePendaftaranMahasiswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(FramePendaftaranMahasiswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new FramePendaftaranMahasiswa().setVisible(true);
//            }
//        });
//    }

    public JTextField getCariTextField() {
        return CariTextField;
    }

    public void setCariTextField(JTextField CariTextField) {
        this.CariTextField = CariTextField;
    }

    public JTable getTabel_Data() {
        return Tabel_Data;
    }

    public void setTabel_Data(JTable Tabel_Data) {
        this.Tabel_Data = Tabel_Data;
    }

    public JButton getCETAK() {
        return btn_cetak;
    }

    public void setCETAK(JButton CETAK) {
        this.btn_cetak = CETAK;
    }
    
    //Getter and Setter for TextField and ComboBox
    
    public JTextField getAlamatTextField() {
        return alamatTextField;
    }

    public void setAlamatTextField(JTextField alamatTextField) {
        this.alamatTextField = alamatTextField;
    }

    public JTextField getAsalsekolahTextField() {
        return asalsekolahTextField;
    }

    public void setAsalsekolahTextField(JTextField asalsekolahTextField) {
        this.asalsekolahTextField = asalsekolahTextField;
    }

//    public JComboBox<String> getBulanComboBox() {
//        return bulanComboBox;
//    }
//
//    public void setBulanComboBox(JComboBox<String> bulanComboBox) {
//        this.bulanComboBox = bulanComboBox;
//    }

    public JTextField getEmailTextField() {
        return emailTextField;
    }

    public void setEmailTextField(JTextField emailTextField) {
        this.emailTextField = emailTextField;
    }

    public JComboBox<String> getGenderComboBox() {
        return genderComboBox;
    }

    public void setGenderComboBox(JComboBox<String> genderComboBox) {
        this.genderComboBox = genderComboBox;
    }

    public JTextField getNamaTextField() {
        return namaTextField;
    }

    public void setNamaTextField(JTextField namaTextField) {
        this.namaTextField = namaTextField;
    }

    public JTextField getNoteleponTextField() {
        return noteleponTextField;
    }

    public void setNoteleponTextField(JTextField noteleponTextField) {
        this.noteleponTextField = noteleponTextField;
    }

    public JTextField getNpmTextField() {
        return npmTextField;
    }

    public void setNpmTextField(JTextField npmTextField) {
        this.npmTextField = npmTextField;
    }

    public JComboBox<String> getStudi1ComboBox() {
        return studi1ComboBox;
    }

    public void setStudi1ComboBox(JComboBox<String> studi1ComboBox) {
        this.studi1ComboBox = studi1ComboBox;
    }

    public JComboBox<String> getStudi2ComboBox() {
        return studi2ComboBox;
    }

    public void setStudi2ComboBox(JComboBox<String> studi2ComboBox) {
        this.studi2ComboBox = studi2ComboBox;
    }

//    public JComboBox<String> getTahunComboBox() {
//        return tahunComboBox;
//    }
//
//    public void setTahunComboBox(JComboBox<String> tahunComboBox) {
//        this.tahunComboBox = tahunComboBox;
//    }

    public JTextField getTahunlulusTextField() {
        return tahunlulusTextField;
    }

    public void setTahunlulusTextField(JTextField tahunlulusTextField) {
        this.tahunlulusTextField = tahunlulusTextField;
    }

//    public JComboBox<String> getTanggalComboBox() {
//        return tanggalComboBox;
//    }
//
//    public void setTanggalComboBox(JComboBox<String> tanggalComboBox) {
//        this.tanggalComboBox = tanggalComboBox;
//    }

    public JTextField getTempatlahirTextField() {
        return tempatlahirTextField;
    }

    public void setTempatlahirTextField(JTextField tempatlahirTextField) {
        this.tempatlahirTextField = tempatlahirTextField;
    }

    public JTextField getTanggalTextField() {
        return tanggalTextField;
    }

    public void setTanggalTextField(JTextField tanggalTextField) {
        this.tanggalTextField = tanggalTextField;
    }
    
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField CariTextField;
    private javax.swing.JTable Tabel_Data;
    private javax.swing.JTextField alamatTextField;
    private javax.swing.JTextField asalsekolahTextField;
    private javax.swing.JButton btn_cari;
    private javax.swing.JButton btn_cetak;
    private javax.swing.JButton btn_customprint;
    private javax.swing.JButton btn_hapus;
    private javax.swing.JButton btn_reset;
    private javax.swing.JButton btn_tambah;
    private javax.swing.JButton btn_update;
    private javax.swing.JTextField emailTextField;
    private javax.swing.JComboBox<String> genderComboBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField namaTextField;
    private javax.swing.JTextField noteleponTextField;
    private javax.swing.JTextField npmTextField;
    private javax.swing.JComboBox<String> studi1ComboBox;
    private javax.swing.JComboBox<String> studi2ComboBox;
    private javax.swing.JTextField tahunlulusTextField;
    private javax.swing.JTextField tanggalTextField;
    private javax.swing.JTextField tempatlahirTextField;
    // End of variables declaration//GEN-END:variables

   
  


}
