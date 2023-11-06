/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package demo_eksepsi_lanjutan;

/**
 *
 * @author HP
 */
import java.io.File;
import java.io.IOException; //Diberi kode ini agar semua program dapat berjalan

class DemoEksepsi2{
    public static void main(String[] args) throws IOException{
	File myFile = new File("test.txt");
	myFile.createNewFile();
	}
}