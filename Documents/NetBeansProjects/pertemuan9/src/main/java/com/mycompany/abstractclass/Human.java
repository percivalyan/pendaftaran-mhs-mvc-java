package com.mycompany.abstractclass;

class Human extends LivingThing {
    public Human() {
        // Konstruktor untuk Human
    }

    @Override
    public void walk() {
        System.out.println("Berjalan dengan 2 kaki.");
    }

    public static void main(String[] args) {
        Human output = new Human();
        output.breath();
        output.eat();
        output.walk();
    }
}