package com.mycompany.abstractclass;

abstract class LivingThing {
    public void breath() {
        System.out.println("Bernafas melalui hidung.");
    }

    public void eat() {
        System.out.println("Makan melalui mulut.");
    }

    /**
     * Metode abstrak 'walk'
     * Kita ingin metode ini di-overriding oleh subclass.
     */
    public abstract void walk();
}