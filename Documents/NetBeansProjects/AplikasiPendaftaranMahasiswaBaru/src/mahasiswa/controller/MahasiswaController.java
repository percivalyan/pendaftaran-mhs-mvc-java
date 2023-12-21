/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mahasiswa.controller;

import java.sql.SQLException;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import mahasiswa.dao.imp.MahasiswaDAOImp;
import mahasiswa.view.FramePendaftaranMahasiswa;
import mahasiswa.model.Mahasiswa;

/**
 *
 * @author HP
 */
public class MahasiswaController {
    FramePendaftaranMahasiswa frame = new FramePendaftaranMahasiswa();
    MahasiswaDAOImp daoMahasiswaImpl;
    private final MahasiswaController mhsController;
    
    //Buat Controller
    public MahasiswaController(FramePendaftaranMahasiswa frame) throws SQLException {
        //Inisialisasi
        this.frame = frame;
        this.mhsController = this; // Tambahkan inisialisasi ini
        daoMahasiswaImpl = new MahasiswaDAOImp();
    }
    
    //Insert Data User
    public void insert() {
    Mahasiswa mhs = new Mahasiswa();
    mhs.setNpm(frame.getNpmTextField().getText());
    mhs.setNama(frame.getNamaTextField().getText());
    mhs.setTempatLahir(frame.getTempatlahirTextField().getText());
    mhs.setTanggal((String) frame.getTanggalTextField().getText());
//    mhs.setBulan((String) frame.getBulanComboBox().getSelectedItem());
//    mhs.setTahun((String) frame.getTahunComboBox().getSelectedItem());
    mhs.setGender((String) frame.getGenderComboBox().getSelectedItem());
    mhs.setNoTelepon(frame.getNoteleponTextField().getText());
    mhs.setEmail(frame.getEmailTextField().getText());
    mhs.setAlamat(frame.getAlamatTextField().getText());
    mhs.setAsalSekolah(frame.getAsalsekolahTextField().getText());
    mhs.setTahunLulus(frame.getTahunlulusTextField().getText());
    mhs.setProgram1((String) frame.getStudi1ComboBox().getSelectedItem());
    mhs.setProgram2((String) frame.getStudi2ComboBox().getSelectedItem());
    daoMahasiswaImpl.insert(mhs);
}

    
    //MEMPERBARUHI
public void update() {
    Mahasiswa mhs = new Mahasiswa();
    mhs.setNpm(frame.getNpmTextField().getText());
    mhs.setNama(frame.getNamaTextField().getText());
    mhs.setTempatLahir(frame.getTempatlahirTextField().getText());
    mhs.setTanggal((String) frame.getTanggalTextField().getText());
    mhs.setGender((String) frame.getGenderComboBox().getSelectedItem());
    mhs.setNoTelepon(frame.getNoteleponTextField().getText());
    mhs.setEmail(frame.getEmailTextField().getText());
    mhs.setAlamat(frame.getAlamatTextField().getText());
    mhs.setAsalSekolah(frame.getAsalsekolahTextField().getText());
    mhs.setTahunLulus(frame.getTahunlulusTextField().getText());
    mhs.setProgram1((String) frame.getStudi1ComboBox().getSelectedItem());
    mhs.setProgram2((String) frame.getStudi2ComboBox().getSelectedItem());
    daoMahasiswaImpl.update(mhs);

    // Setelah update, refresh tampilan tabel
    refreshTable();
}


//MENGHAPUS
public void delete() {
    Mahasiswa mhs = new Mahasiswa();
    mhs.setNpm(frame.getNpmTextField().getText());

    daoMahasiswaImpl.delete(mhs);

    // Setelah delete, refresh tampilan tabel
    refreshTable();
}

//RESET
public void reset() {
    frame.getNpmTextField().setText("");
    frame.getNamaTextField().setText("");
    frame.getTempatlahirTextField().setText("");
    frame.getTanggalTextField().setText("");
//    frame.getBulanComboBox().setSelectedItem("");
//    frame.getTahunComboBox().setSelectedItem("");
    frame.getGenderComboBox().setSelectedItem("");
    frame.getNoteleponTextField().setText("");
    frame.getEmailTextField().setText("");
    frame.getAlamatTextField().setText("");
    frame.getAsalsekolahTextField().setText("");
    frame.getTahunlulusTextField().setText("");
    frame.getStudi1ComboBox().setSelectedItem("");
    frame.getStudi2ComboBox().setSelectedItem("");
}


public void tampilkanData() {
    // Mengambil data dari database
    List<Mahasiswa> mahasiswaList = daoMahasiswaImpl.getAll();

    // Mendapatkan model tabel dari frame
    DefaultTableModel model = (DefaultTableModel) frame.getTabel_Data().getModel();

    // Membersihkan data yang ada di tabel
    model.setRowCount(0);

    // Memasukkan data baru ke dalam tabel
    for (Mahasiswa mhs : mahasiswaList) {
    Object[] rowData = {
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
    };
    model.addRow(rowData);
}

}

private void refreshTable() {
        // Ambil data terbaru dari database
        List<Mahasiswa> mahasiswaList = daoMahasiswaImpl.getAll();

        // Update model tabel di frame
        DefaultTableModel model = (DefaultTableModel) frame.getTabel_Data().getModel();
        model.setRowCount(0); // Kosongkan tabel

        // Isi tabel dengan data terbaru
        for (Mahasiswa mhs : mahasiswaList) {
        Object[] rowData = {
            mhs.getNpm(),
            mhs.getNama(),
            mhs.getTempatLahir(),
            mhs.getTanggal(),
//            mhs.getBulan(),
//            mhs.getTahun(),
            mhs.getGender(),
            mhs.getNoTelepon(),
            mhs.getEmail(),
            mhs.getAlamat(),
            mhs.getAsalSekolah(),
            mhs.getTahunLulus(),
            mhs.getProgram1(),
            mhs.getProgram2(),
        };
        model.addRow(rowData);
}

    }

public List<Mahasiswa> getMahasiswaList() {
        // Mengambil data dari database
        return daoMahasiswaImpl.getAll();
    }

// Tambahkan metode cariNama
    public void cariNama(String nama) {
        // Panggil metode di DAO untuk mendapatkan hasil pencarian
        List<Mahasiswa> hasilPencarian = daoMahasiswaImpl.getCariNama(nama);

        // Update tabel dengan hasil pencarian
        frame.updateTabel(hasilPencarian);
    }
}
