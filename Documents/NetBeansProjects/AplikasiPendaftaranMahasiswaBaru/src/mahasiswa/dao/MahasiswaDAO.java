/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package mahasiswa.dao;

import java.util.List;
import mahasiswa.model.Mahasiswa;
//import mahasiswa.view.MahasiswaView;

/**
 *
 * @author HP
 */
public interface MahasiswaDAO {
    //Fungsi untuk melakukan proses CRUD pada database
    public void insert(Mahasiswa mhs);
    
    public void update(Mahasiswa mhs);
    
    public void delete(Mahasiswa mhs);
    
    public List<Mahasiswa> getAll();
    
    public List<Mahasiswa> getCariNama(String nama);
}
