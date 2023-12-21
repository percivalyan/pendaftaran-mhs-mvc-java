/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mahasiswa.dao.imp;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import mahasiswa.dao.MahasiswaDAO;
import mahasiswa.koneksi.KoneksiDatabase;
import mahasiswa.model.Mahasiswa;
import mahasiswa.view.FramePendaftaranMahasiswa;
//import mahasiswa.view.MahasiswaView;
/**
 *
 * @author HP
 */
public class MahasiswaDAOImp implements MahasiswaDAO {
    //Buat Var  Koneksi
    Connection connection;
    
    public MahasiswaDAOImp() throws SQLException{
        KoneksiDatabase koneksi = new KoneksiDatabase();
        connection = koneksi.koneksi();
    }
    //final String insert = "INSERT INTO tb_mahasiswa (nim, nama, alamat, hp, dosen) VALUES (?,?,?,?);";

//    public MahasiswaDAOImp(Connection koneksi) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }

    @Override
public void insert(Mahasiswa mhs) {
    PreparedStatement ps = null;
    try {
String query = "INSERT INTO data_mahasiswa (npm, nama, tempatlahir, tanggal, gender, notelepon, email, alamat, asalsekolah, tahunlulus, program1, program2) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
ps = connection.prepareStatement(query);


        ps.setString(1, mhs.getNpm());
        ps.setString(2, mhs.getNama());
        ps.setString(3, mhs.getTempatLahir());
        ps.setString(4, mhs.getTanggal());
        ps.setString(5, mhs.getGender());
        ps.setString(6, mhs.getNoTelepon());
        ps.setString(7, mhs.getEmail());
        ps.setString(8, mhs.getAlamat());
        ps.setString(9, mhs.getAsalSekolah());
        ps.setString(10, mhs.getTahunLulus());
        ps.setString(11, mhs.getProgram1());
        ps.setString(12, mhs.getProgram2());

        // Menambahkan parameter-parameter tambahan jika ada
        // ps.setString(13, mhs.getNamaOrangTua());
        // ps.setString(14, mhs.getPekerjaanOrangTua());
        // ps.setString(15, mhs.getPenghasilanOrangTua());
        // ps.setString(16, mhs.getJumlahAnak());

        ps.executeUpdate();
    } catch (SQLException ex) {
        ex.printStackTrace(); // Sebaiknya ditangani dengan lebih baik, misalnya, dicetak ke log
    } finally {
        try {
            if (ps != null) {
                ps.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace(); // Sebaiknya ditangani dengan lebih baik, misalnya, dicetak ke log
        }
    }
}




   // Di dalam class MahasiswaDAOImp
@Override
public void update(Mahasiswa mhs) {
    PreparedStatement ps = null;
    try {
        ps = connection.prepareStatement("UPDATE data_mahasiswa SET nama=?, tempatlahir=?, tanggal=?, gender=?, notelepon=?, email=?, alamat=?, asalsekolah=?, tahunlulus=?, program1=?, program2=? WHERE npm=?");
         //ps.setString(1, mhs.getNpm());
        ps.setString(1, mhs.getNama());
        ps.setString(2, mhs.getTempatLahir());
        ps.setString(3, mhs.getTanggal());
        ps.setString(4, mhs.getGender());
        ps.setString(5, mhs.getNoTelepon());
        ps.setString(6, mhs.getEmail());
        ps.setString(7, mhs.getAlamat());
        ps.setString(8, mhs.getAsalSekolah());
        ps.setString(9, mhs.getTahunLulus());
        ps.setString(10, mhs.getProgram1());
        ps.setString(11, mhs.getProgram2());
         ps.setString(12, mhs.getNpm());


        ps.executeUpdate();
    } catch (SQLException ex) {
        ex.printStackTrace();
    } finally {
        try {
            if (ps != null) {
                ps.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}


@Override
public void delete(Mahasiswa mhs) {
    PreparedStatement ps = null;
    try {
        ps = connection.prepareStatement("DELETE FROM data_mahasiswa WHERE npm=?");
        ps.setString(1, mhs.getNpm());
        ps.executeUpdate();
    } catch (SQLException ex) {
        ex.printStackTrace();
    } finally {
        try {
            if (ps != null) {
                ps.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}

// Implementasi metode getAll dan getCariNama sesuai kebutuhan
@Override
public List<Mahasiswa> getAll() {
    List<Mahasiswa> mahasiswaList = new ArrayList<>();
    PreparedStatement ps = null;
    ResultSet rs = null;

    try {
        ps = connection.prepareStatement("SELECT * FROM data_mahasiswa");
        rs = ps.executeQuery();

        while (rs.next()) {
            Mahasiswa mhs = new Mahasiswa();
            mhs.setNpm(rs.getString("npm"));
            mhs.setNama(rs.getString("nama"));
            mhs.setTempatLahir(rs.getString("tempatlahir"));
            mhs.setTanggal(rs.getString("tanggal"));
//            mhs.setBulan(rs.getString("bulan"));
//            mhs.setTahun(rs.getString("tahun"));
            mhs.setGender(rs.getString("gender"));
            mhs.setNoTelepon(rs.getString("notelepon"));
            mhs.setEmail(rs.getString("email"));
            mhs.setAlamat(rs.getString("alamat"));
            mhs.setAsalSekolah(rs.getString("asalsekolah"));
            mhs.setTahunLulus(rs.getString("tahunlulus"));
            mhs.setProgram1(rs.getString("program1"));
            mhs.setProgram2(rs.getString("program2"));
//            mhs.setNamaOrangTua(rs.getString("namaorangtua"));
//            mhs.setPekerjaanOrangTua(rs.getString("pekerjaan"));
//            mhs.setPenghasilanOrangTua(rs.getString("penghasilan"));
//            mhs.setJumlahAnak(rs.getString("anak"));
            
            mahasiswaList.add(mhs);
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
    } finally {
        try {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    return mahasiswaList;
}


@Override
public List<Mahasiswa> getCariNama(String nama) {
    List<Mahasiswa> mahasiswaList = new ArrayList<>();
    PreparedStatement ps = null;
    ResultSet rs = null;

    try {
        ps = connection.prepareStatement("SELECT * FROM data_mahasiswa WHERE nama LIKE ?");
        ps.setString(1, "%" + nama + "%");
        rs = ps.executeQuery();

        while (rs.next()) {
            Mahasiswa mhs = new Mahasiswa();
            mhs.setNpm(rs.getString("npm"));
            mhs.setNama(rs.getString("nama"));
            mhs.setTempatLahir(rs.getString("tempatlahir"));
            mhs.setTanggal(rs.getString("tanggal"));
//            mhs.setBulan(rs.getString("bulan"));
//            mhs.setTahun(rs.getString("tahun"));
            mhs.setGender(rs.getString("gender"));
            mhs.setNoTelepon(rs.getString("notelepon"));
            mhs.setEmail(rs.getString("email"));
            mhs.setAlamat(rs.getString("alamat"));
            mhs.setAsalSekolah(rs.getString("asalsekolah"));
            mhs.setTahunLulus(rs.getString("tahunlulus"));
            mhs.setProgram1(rs.getString("program1"));
            mhs.setProgram2(rs.getString("program2"));
//            mhs.setNamaOrangTua(rs.getString("namaorangtua"));
//            mhs.setPekerjaanOrangTua(rs.getString("pekerjaan"));
//            mhs.setPenghasilanOrangTua(rs.getString("penghasilan"));
//            mhs.setJumlahAnak(rs.getString("anak"));
            
            mahasiswaList.add(mhs);
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
    } finally {
        try {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    return mahasiswaList;
}


}