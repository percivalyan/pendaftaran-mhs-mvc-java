/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package demo_eksepsi_lanjutan_2;

import java.io.File;
import java.io.IOException;

/**
 *
 * @author HP
 */
class DemoEksepsi3 {
    public static void main(String[] args) {
        try {
            File myFile = new File("test.txt");
            myFile.createNewFile();
            System.out.println("File berhasil dibuat");
        } catch (IOException e) {
            System.out.println("File gagal dibuat");
        }
    }
}