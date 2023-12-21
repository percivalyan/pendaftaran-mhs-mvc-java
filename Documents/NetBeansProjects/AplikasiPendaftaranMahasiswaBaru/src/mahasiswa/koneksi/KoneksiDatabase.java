/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mahasiswa.koneksi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author HP
 */
public class KoneksiDatabase {
    private Connection conn;
    
    public Connection koneksi() throws SQLException {
        try {
            String db = "jdbc:mysql://localhost/mahasiswa_baru"; // Ganti URL sesuai dengan konfigurasi MySQL Anda
            String user = "root";
            String pass = "";

            conn = DriverManager.getConnection(db, user, pass);

            JOptionPane.showMessageDialog(null, "Berhasil", "Berhasil",
                    JOptionPane.INFORMATION_MESSAGE);
            System.out.println("Database Information:");
            System.out.println("Database Name: "+conn.getMetaData().getDatabaseProductName());
            System.out.println("Databae Versiion "+conn.getMetaData().getDatabaseProductVersion());

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Gagal", "Gagal",
                    JOptionPane.ERROR_MESSAGE); // Perbaiki JOptionPane.INFORMATION_MESSAGE ke JOptionPane.ERROR_MESSAGE
            System.err.println(e.getMessage());
            System.exit(0);
        }
        return conn; // Anda harus mengembalikan objek Connection setelah membuat koneksi
    }
}
