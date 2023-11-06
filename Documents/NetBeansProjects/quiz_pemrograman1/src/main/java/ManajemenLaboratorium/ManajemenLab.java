/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package ManajemenLaboratorium;

/**
 *
 * @author HP
 */
import java.util.ArrayList;
import java.util.Scanner;

public class ManajemenLab extends Peralatan{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Peralatan> DaftarPeralatan = new ArrayList<>();

        boolean MenuUtama = true;
        while (MenuUtama) {
            System.out.println("===============================================================");
            System.out.println("APLIKASI MANAJEMEN PERLENGKAPAN LABORATORIUM TEKNIK INFORMATIKA");
            System.out.println("===============================================================");
            System.out.println("\nMENU:");
            System.out.println("A. INPUT DATA");
            System.out.println("B. TRANSAKSI DATA");
            System.out.println("C. OUTPUT DATA");
            System.out.println("D. KELUAR MENU");
            System.out.print("Pilih opsi: ");
            String pilihan = scanner.nextLine();
            System.out.println("");

            switch (pilihan) {
                case "a":
                case "A":
                    System.out.println("INPUT DATA:");
                    while (true) {
                        System.out.println("===============================================================");
                        System.out.print("Nama peralatan    : ");
                        String nama = scanner.nextLine();
                        if (nama.equalsIgnoreCase("selesai") || nama.equalsIgnoreCase("tidak")) {
                            break;
                        }
                        int kuantitas;
                        while (true) {
                            System.out.print("Jumlah peralatan  : ");
                            if (scanner.hasNextInt()) {
                                kuantitas = scanner.nextInt();
                                scanner.nextLine();
                                break;
                            } else {
                                System.out.println("Input harus berupa angka. Silakan masukkan angka yang valid.");
                                scanner.nextLine();
                            }
                        }

                        Peralatan peralatan = new Peralatan(nama, kuantitas);
                        DaftarPeralatan.add(peralatan);
                        System.out.println("===============================================================");
                        System.out.println("Keterangan          : ");
                        System.out.println("ya                  : Melanjutkan penambahan peralatan");
                        System.out.println("tidak atau selesai  : Kembali ke Menu Utama");
                        System.out.println("===============================================================");
                        System.out.print("Apakah ingin menambahkan peralatan lain? (ya/tidak/selesai): ");
                        String tambahLagi = scanner.nextLine();
                        
                        if (!tambahLagi.equalsIgnoreCase("ya")) {
                            if (!tambahLagi.equalsIgnoreCase("tidak") && !tambahLagi.equalsIgnoreCase("selesai")) {
                                System.out.println("Opsi tidak valid. Silakan masukkan 'ya', 'tidak', atau 'selesai'.");
                            }
                            break;
                        }
                    }
                    System.out.println("===============================================================");
                    System.out.println("");
                    System.out.println("#########################MENU_INPUT_SELESAI#########################");
                    System.out.println("");
                    break;

                case "b":
                case "B":
                    System.out.println("TRANSAKSI DATA:");
                    System.out.println("===============================================================");
                    System.out.println("Pilih opsi:");
                    System.out.println("1. Tambah peralatan");
                    System.out.println("2. Hapus peralatan");
                    System.out.println("3. Edit peralatan");
                    System.out.print("Pilih opsi: ");

                    try {
                        int pilihanTransaksiData = scanner.nextInt();
                        scanner.nextLine();
                        System.out.println("===============================================================");

                        switch (pilihanTransaksiData) {
                            case 1:
                                System.out.print("Nama peralatan yang ditambahkan   : ");
                                String namaDitambahkan = scanner.nextLine();
                                System.out.print("Jumlah peralatan yang ditambahkan : ");
                                int kuantitasDitambahkan = scanner.nextInt();
                                scanner.nextLine();

                                boolean ditemukan = false;
                                for (Peralatan peralatan : DaftarPeralatan) {
                                    if (peralatan.getNama().equalsIgnoreCase(namaDitambahkan)) {
                                        int kuantitasBaru = peralatan.getKuantitas() + kuantitasDitambahkan;
                                        peralatan.setKuantitas(kuantitasBaru);
                                        ditemukan = true;
                                    }
                                }
                                if (!ditemukan) {
                                    Peralatan peralatanBaru = new Peralatan(namaDitambahkan, kuantitasDitambahkan);
                                    DaftarPeralatan.add(peralatanBaru);
                                    System.out.println("Peralatan baru telah ditambahkan");
                                }
                                break;

                            case 2:
                                System.out.println("Daftar Peralatan:");
                                for (Peralatan peralatan : DaftarPeralatan) {
                                    System.out.println(peralatan.getNama() + " - " + peralatan.getKuantitas());
                                }
                                System.out.println("===============================================================");
                                System.out.print("Nama peralatan yang dihapus: ");
                                String namaDihapus = scanner.nextLine();
                                Peralatan peralatanDihapus = null;

                                for (Peralatan peralatan : DaftarPeralatan) {
                                    if (peralatan.getNama().equalsIgnoreCase(namaDihapus)) {
                                        peralatanDihapus = peralatan;
                                        break;
                                    }
                                }

                                if (peralatanDihapus != null) {
                                    DaftarPeralatan.remove(peralatanDihapus);
                                    System.out.println(namaDihapus + " telah dihapus dari daftar.");
                                } else {
                                    System.out.println("Peralatan tidak ditemukan. Tidak ada perubahan pada daftar.");
                                }
                                break;

                            case 3:
                                System.out.println("Daftar Peralatan:");
                                for (Peralatan peralatan : DaftarPeralatan) {
                                    System.out.println(peralatan.getNama() + " - " + peralatan.getKuantitas());
                                }
                                System.out.println("===============================================================");
                                System.out.print("Nama peralatan yang diedit: ");
                                String namaDiedit = scanner.nextLine();
                                boolean ada = false;
                                for (Peralatan peralatan : DaftarPeralatan) {
                                    if (peralatan.getNama().equalsIgnoreCase(namaDiedit)) {
                                        System.out.print("Nama baru peralatan       : ");
                                        String namaBaru = scanner.nextLine();
                                        System.out.print("Perbarui jumlah peralatan : ");
                                        int kuantitasBaru = scanner.nextInt();
                                        scanner.nextLine();
                                        peralatan.setNama(namaBaru);
                                        peralatan.setKuantitas(kuantitasBaru);
                                        System.out.println(namaDiedit + " telah diubah menjadi " + namaBaru + " dengan kuantitas " + kuantitasBaru + ".");
                                        ada = true;
                                        break;
                                    }
                                }
                                if (!ada) {
                                    System.out.println("Input tidak valid.");
                                }

                                break;

                            default:
                                System.out.println("Input tidak valid.");
                                break;
                        }
                    } catch (java.util.InputMismatchException e) {
                        System.out.println("Opsi tidak valid. Silakan pilih opsi yang benar.");
                        scanner.nextLine();
                    }
                    System.out.println("===============================================================");
                    System.out.println("");
                    System.out.println("#########################MENU_TRANSAKSI_SELESAI#########################");
                    System.out.println("");
                    break;

                case "c":
                case "C":
                    System.out.println("OUTPUT DATA:");
                    System.out.println("===============================================================");
                    if (DaftarPeralatan.isEmpty()) {
                        System.out.println("Belum ada peralatan yang diinput.");
                        System.out.println("");
                    } else {
                        for (Peralatan peralatan : DaftarPeralatan) {
                            System.out.println(peralatan);
                        }
                    }
                    System.out.println("===============================================================");
                    System.out.println("");
                    System.out.println("#########################MENU_OUTPUT_SELESAI#########################");
                    System.out.println("");
                    break;

                case "d":
                case "D":
                    MenuUtama = false;
                    break;

                default:
                    System.out.println("===============================================================");
                    System.out.println("Opsi tidak valid. Silakan pilih opsi yang benar.");
                    System.out.println("===============================================================");
                    System.out.println("");
                    System.out.println("#########################OPSI_TIDAK_VALID#########################");
                    System.out.println("");
                    break;
            }
        }
        System.out.println("===============================================================================================");
        System.out.println("Terima kasih telah menggunakan Aplikasi Manajemen Perlengkapan Laboratorium Teknik Informatika.");
        System.out.println("===============================================================================================");
        System.out.println("");
        System.out.println("########################################PROGRAM_SELESAI########################################");
        System.out.println("");
    }

    public ManajemenLab(String nama, int kuantitas) {
        super(nama, kuantitas);
    }
}