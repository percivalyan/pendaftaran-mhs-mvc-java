package mahasiswa.main;

import mahasiswa.koneksi.KoneksiDatabase;
import mahasiswa.view.FramePendaftaranMahasiswa;
import java.sql.Connection;
import java.sql.SQLException;
import mahasiswa.controller.MahasiswaController;
import mahasiswa.login.FrameLogin;

/**
 *
 * @author HP
 */
public class Main {

    public static void main(String[] args) throws SQLException {
//        FramePendaftaranMahasiswa frameMahasiswa = new FramePendaftaranMahasiswa();
//        frameMahasiswa.setVisible(true);
//
//        MahasiswaController mhsController = new MahasiswaController(frameMahasiswa);
//        mhsController.tampilkanData();
        
        FrameLogin frameLogin = new FrameLogin();
        frameLogin.setVisible(true);
    }
}
