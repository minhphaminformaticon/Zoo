package com.informaticon.java.tutorial.zoo.miph.animals;

import com.informaticon.java.tutorial.zoo.miph.animals.template.Omnivores;

public class Bear extends Animal implements Omnivores {
    public Bear(String name, int age, int strength, int health, int defense, int speed) {
        super(name, age, strength, health, defense, speed);
        setIcon("✩\uD83D\uDC3B✮");
        setBigBody(getName() + "'s big belly is so fluffy and squishy!");
    }

    private String bigBody;

    @Override
    public void makeSound() {
        System.out.println(getName() + " roars!");
    }

    @Override
    public void action() {
        hunt();
        eatPlantsAndMeat();
    }

    @Override
    public void attributes() {
        System.out.println(getBigBody());
    }

    @Override
    public void hunt() {
        System.out.println(getName() + " hunts other zoo.animals.");
    }

    @Override
    public void eatPlantsAndMeat() {
        System.out.println(getName() + " eats other animals and honey.");
    }

    public String getBigBody() {
        return bigBody;
    }

    public void setBigBody(String bigBody) {
        this.bigBody = bigBody;
    }
}
