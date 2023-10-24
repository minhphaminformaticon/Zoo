package com.informaticon.java.tutorial.zoo.miph;

public abstract class Animal {

    public Animal() {

    }

    public Animal(String name, int age, int strength, int health, int defense, int speed) {
        this.name = name;
        this.age = age;
        this.strength = strength;
        this.health = health;
        this.defense = defense;
        this.speed = speed;
    }

    private String name;
    private int age;
    private String icon;
    private String animal;
    private int health;
    private int strength;

    private int counter;
    private int maxHealth = health;
    private int defense;
    private int speed;
    private int actionChoice = 0;


    public abstract void makeSound();

    public abstract void action();

    public abstract void attributes();


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

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getHealth() {
        return health;
    }

    public int getStrength() {
        return strength;
    }

    public int getDefense() {
        return defense;
    }

    public int getSpeed() {
        return speed;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setAnimal(String animal) {
        this.animal = animal;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getActionChoice() {
        return actionChoice;
    }

    public void setActionChoice(int actionChoice) {
        this.actionChoice = actionChoice;
    }
}