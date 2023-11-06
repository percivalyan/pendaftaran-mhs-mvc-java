/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package demo_assertion;

import java.util.Scanner;
/**
 *
 * @author HP
 */
class ContohAssertion {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        System.out.print("Masukkan Usia :");
        int usia = input.nextInt();
        assert usia <= 18 : "Not valid";
        System.out.println("Usia kamu adalah " + usia);
        //Variabel value diganti dengan usia agar dapat mencetak nilai usia yang dimasukkan,
        //Jika tidak diganti kode ini akan error.
    }
}