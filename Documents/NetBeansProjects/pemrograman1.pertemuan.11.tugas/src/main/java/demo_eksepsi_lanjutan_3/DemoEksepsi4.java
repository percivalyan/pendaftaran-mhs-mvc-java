/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package demo_eksepsi_lanjutan_3;
import java.io.File;
import java.io.IOException;

//@author HP
class DemoEksepsi4 {
    public static void main(String[] args) {
        try {
            int x = args.length;
            int y = 100 / x;
            int[] arr = {0, 1, 2, 3};
            y = arr[x];
            System.out.println("Jumlah argument: " + y);
            System.out.println("Tidak terjadi eksepsi");
        } catch (ArithmeticException e) {
            System.out.println("Terjadi eksepsi karena pembagian dengan nol: " + e.getMessage());
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Terjadi eksepsi karena indeks di luar kapasitas");
        } catch (Throwable e) {
            System.out.println("Terjadi eksepsi yang tidak diketahui");
        }
        System.out.println("Setelah blok try catch");
    }
}