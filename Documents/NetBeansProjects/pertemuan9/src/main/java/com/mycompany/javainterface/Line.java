package com.mycompany.javainterface;

/**
 * Class ini mendefinisikan segmen garis
 */
public class Line implements Relation {
    private double x1;
    private double x2;
    private double y1;
    private double y2;

    public Line(double x1, double x2, double y1, double y2) {
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
    }

    public double getLength() {
        double length = Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
        return length;
    }

    public boolean isGreater(Object a, Object b) {
        double aLen = ((Line) a).getLength();
        double bLen = ((Line) b).getLength();
        return aLen > bLen;
    }

    public boolean isLess(Object a, Object b) {
        double aLen = ((Line) a).getLength();
        double bLen = ((Line) b).getLength();
        return aLen < bLen;
    }

    public boolean isEqual(Object a, Object b) {
        double aLen = ((Line) a).getLength();
        double bLen = ((Line) b).getLength();
        return aLen == bLen;
    }

    public static void main(String[] args) {
        //Buat objek garis pertama dan garis kedua
        Line garis1 = new Line(4.0, 8.0, 8.0, 9.0);
        Line garis2 = new Line(5.0, 8.0, 9.0, 9.0);

        //Hitung panjang kedua garis
        double panjangGaris1 = garis1.getLength();
        double panjangGaris2 = garis2.getLength();

        //Cetak panjang kedua garis
        System.out.println("Panjang Garis 1: " + panjangGaris1);
        System.out.println("Panjang Garis 2: " + panjangGaris2);

        //Bandingkan panjang garis
        if (garis1.isGreater(garis1, garis2)) {
            System.out.println("Garis 1 lebih panjang dari Garis 2.");
        } else if (garis1.isLess(garis1, garis2)) {
            System.out.println("Garis 1 lebih pendek dari Garis 2.");
        } else {
            System.out.println("Garis 1 sama panjang dengan Garis 2.");
        }
    }
}