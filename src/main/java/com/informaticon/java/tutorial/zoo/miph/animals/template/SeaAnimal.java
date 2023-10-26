package com.informaticon.java.tutorial.zoo.miph.animals.template;

public interface SeaAnimal {

    /**
     * Default behaviour for all SeaAnimals
     */
    default void swim() {
        System.out.println("SeaAnimal swims");
    }

    /**
     * hallo
     */
    void eatFish();

}
