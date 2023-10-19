package com.informaticon.java.tutorial.zoo.miph;

public abstract class Animal {

    public Animal() {

    }

    public Animal(String name, int age, int strength, int health, int defense) {
        this.name = name;
        this.age = age;
        this.strength = strength;
        this.health = health;
        this.defense = defense;
    }

    String name;
    int age;
    private String icon;
    String animal;
    int health;
    int strength;

    int counter;
    int maxHealth = health;
    int defense;

    public String getAnimal() {
        return animal;
    }

    public int getCounter() {
        return counter;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public abstract void makeSound();

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public abstract void action();

    public abstract void attributes();

    public int getHealth() {
        return health;
    }

    public int getStrength() {
        return strength;
    }

    public int getDefense() {
        return defense;
    }
}


