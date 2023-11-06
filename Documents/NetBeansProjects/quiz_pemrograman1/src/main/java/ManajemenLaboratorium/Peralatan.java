/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ManajemenLaboratorium;

/**
 *
 * @author HP
 */
public class Peralatan {
    private String nama;
    private int kuantitas;

    public Peralatan(String nama, int kuantitas) {
        this.nama = nama;
        this.kuantitas = kuantitas;
    }
    
    public String getNama() {
        return nama;
    }
    
    public int getKuantitas() {
        return kuantitas;
    }
    
    public void setKuantitas(int kuantitas) {
        this.kuantitas = kuantitas;
    }
    
    public void setNama(String nama) {
        this.nama = nama;
    }
    
    @Override
    public String toString() {
        return nama + " - " + kuantitas;
    }
}