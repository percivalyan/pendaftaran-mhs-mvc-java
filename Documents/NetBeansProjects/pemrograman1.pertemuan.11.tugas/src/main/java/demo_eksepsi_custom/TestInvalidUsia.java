/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package demo_eksepsi_custom;

/**
 *
 * @author HP
 */
class TestInvalidUsia {
    static void validate(int age) throws InvalidUsia {
        if (age < 25)
            throw new InvalidUsia("Usia Belum Valid");
        else
            System.out.println("Sudah Layak Menikah");
    }
    public static void main(String args[]) {
        try {
            validate(22);
        } catch (Exception m) { 
            System.out.println("Eksespi Dieksekusi: " + m.getMessage()); //m dapat diperbarui m.getMessage()
        }
        System.out.println("Kode Setelah Try & Catch.");
    }
}