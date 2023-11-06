/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package demo_eksepsi_lanjutan_4;

import java.io.File;
import java.io.IOException;

/**
 *
 * @author HP
 */
class DemoEksepsi5 {
    public static void main(String[] args) {
        double BILANGAN = 100.0;
        System.out.println("Sebelum pembagian");
        for (int i = 5; i >= 0; i--) {
            try {
                System.out.println(BILANGAN + "/" + i + " = ");
                System.out.println(BILANGAN / i);
            } finally {
                System.out.println("Bagian finally dijalankan");
            }
        }
        System.out.println("Program selesai");
    }
}