package com.informaticon.java.tutorial.zoo.miph.animals;

import com.informaticon.java.tutorial.zoo.miph.Lion;
import com.informaticon.java.tutorial.zoo.miph.Shark;

public class ClassInPackage {

    public static void main(String[] args) {
        Lion lion = new Lion("test", 22, 100, 100, 100);
        String name = lion.getName();

        Shark shark = new Shark("test", 22, 100, 100, 100);
        shark.swim();

    }
}
