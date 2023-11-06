/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package demo_throw_2;

import java.io.IOException; 
/**
 *
 * @author HP
 */
class DemoThrows{
    public static void main(String[] args) throws IOException {
        SuatuKelas obj = new SuatuKelas();
        obj.metodeA();
        obj.metodeB();
    }
}
class SuatuKelas {
    // Method tanpa throws
    public void metodeA() {
        System.out.println("MetodeA");
    }
    // Method dengan throws
    public void metodeB() throws IOException {
        System.out.println("MetodeB");
    }
}