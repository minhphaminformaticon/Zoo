package com.informaticon.java.tutorial.zoo.miph.animals;

import com.informaticon.java.tutorial.zoo.miph.animals.template.PreyAnimal;

public class Panda extends Animal implements PreyAnimal {

    public Panda(String name, int age, int strength, int health, int defense, int speed) {
        super(name, age, strength, health, defense, speed);
        setIcon("✩\uD83D\uDC3C✮");
        setCuteEyes(getName() + " has super cute eyes.");
    }

    String cuteEyes;


    @Override
    public void makeSound() {
        System.out.println(getName() + " growls!");
    }

    @Override
    public void action() {
        eatPlants();
    }

    @Override
    public void attributes() {
        System.out.println(getCuteEyes());
    }

    @Override
    public void eatPlants() {
        System.out.println(getName() + " eats bamboos everyday.");
    }

    public String getCuteEyes() {
        return cuteEyes;
    }

    public void setCuteEyes(String cuteEyes) {
        this.cuteEyes = cuteEyes;
    }
}