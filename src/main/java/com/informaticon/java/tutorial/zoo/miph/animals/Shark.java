package com.informaticon.java.tutorial.zoo.miph.animals;

import com.informaticon.java.tutorial.zoo.miph.animals.template.Predator;
import com.informaticon.java.tutorial.zoo.miph.animals.template.SeaAnimal;

public class Shark extends Animal implements Predator, SeaAnimal {

    public Shark(String name, int age, int strength, int health, int defense, int speed) {
        super(name, age, strength, health, defense, speed);
        setIcon("✩\uD83E\uDD88✮");
        setFin("the big scary " + getName() + " uses its fins to swim in the deep.");
        setKingOfTheSea("The shark is the king of the deep.");
    }

    private String fin;
    private String kingOfTheSea;

    @Override
    public void makeSound() {
        System.out.println(getName() + " makes underwater noises.");
    }


    @Override
    public void action() {
        hunt();
        eatFish();
        eatMeat();
        swim();
    }

    @Override
    public void attributes() {
        System.out.println(getFin());
        System.out.println(getKingOfTheSea());
    }

    @Override
    public void hunt() {
        System.out.println(getName() + " hunts other fish.");
    }

    @Override
    public void eatMeat() {
        System.out.println(getName() + " eats meat");
    }

    @Override
    public void swim() {
        System.out.println(getName() + " swims gracefully.");
    }

    @Override
    public void eatFish() {
        System.out.println(getName() + " eats fish.");
    }

    public String getFin() {
        return fin;
    }

    public void setFin(String fin) {
        this.fin = fin;
    }

    public String getKingOfTheSea() {
        return kingOfTheSea;
    }

    public void setKingOfTheSea(String kingOfTheSea) {
        this.kingOfTheSea = kingOfTheSea;
    }
}