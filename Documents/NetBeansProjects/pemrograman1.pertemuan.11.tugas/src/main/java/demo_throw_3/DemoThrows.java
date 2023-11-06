/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package demo_throw_3;
import java.io.IOException;
//@author HP
public class DemoThrows {
    public static void main(String[] args) {
        SuatuKelas obj = new SuatuKelas();
        obj.metodeA();
        try {
            obj.metodeB();
        } catch (IOException e) {
            System.out.println("Terjadi Kesalahan Pada Methode B");
        } finally {
            System.out.println("Selalu dieksekusi");
        }
    }
}
class SuatuKelas {
    public void metodeA() {
        System.out.println("MetodeA");
    }
    public void metodeB() throws IOException {
        System.out.println("MetodeB");
    }
}