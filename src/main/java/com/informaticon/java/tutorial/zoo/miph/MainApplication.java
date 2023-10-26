package com.informaticon.java.tutorial.zoo.miph;

import com.informaticon.java.tutorial.zoo.miph.animals.*;
import com.informaticon.java.tutorial.zoo.miph.game.Game;
import com.informaticon.java.tutorial.zoo.miph.zoo.RunZoo;

import java.util.Scanner;

public class MainApplication {

    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        RunZoo zoo = new RunZoo();
        Game game = new Game();

        Lion lion = new Lion("lion minh", 20, 100, 180, 50, 90);
        Tiger tiger = new Tiger("tiger minh", 20, 100, 200, 80, 60);
        Shark shark = new Shark("shark minh", 20, 100, 190, 60, 80);
        Elephant elephant = new Elephant("elephant minh", 20, 100, 200, 100, 40);
        Snake snake = new Snake("snake minh", 20, 80, 100, 40, 100);
        Gorilla gorilla = new Gorilla("gorilla minh", 20, 80, 200, 90, 70);
        Giraffe giraffe = new Giraffe("giraffe minh", 20, 70, 150, 100, 70);
        Zebra zebra = new Zebra("zebra minh", 20, 70, 150, 70, 100);
        Panda panda = new Panda("panda minh", 20, 100, 170, 100, 40);
        Penguin penguin = new Penguin("penguin minh", 20, 70, 100, 70, 100);
        Bear bear = new Bear("bear minh", 20, 80, 190, 80, 80);

        zoo.addAnimal(lion);
        zoo.addAnimal(tiger);
        zoo.addAnimal(shark);
        zoo.addAnimal(elephant);
        zoo.addAnimal(snake);
        zoo.addAnimal(gorilla);
        zoo.addAnimal(giraffe);
        zoo.addAnimal(zebra);
        zoo.addAnimal(panda);
        zoo.addAnimal(penguin);
        zoo.addAnimal(bear);
        System.out.println("W E L C O M E  T O  Z O O");
        System.out.println("      /\";;:;;\"\\");
        System.out.println("    (:;/\\,-,/\\;;");
        System.out.println("   (:;{  d b  }:;)");
        System.out.println("    (:;\\__Y__/;;)-----------,,_");
        System.out.println("     ,..\\  ,..\\      ___/___)__`\\");
        System.out.println("    (,,,)~(,,,)`-._##____________)");

        boolean mainFunction = true;

        while (mainFunction) {
            System.out.println();
            System.out.println("1. Add an animal to the zoo");
            System.out.println("2. Display animals in the zoo");
            System.out.println("3. Animal Battle");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            String input = scanner.nextLine();

            int choice = 0;
            try {
                choice = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("You must input a number!");

            }

            switch (choice) {
                case 1 -> addAnimalToZoo(scanner, zoo);
                case 2 -> zoo.displayAnimals();
                case 3 -> {
                    mainFunction = game.startGame((zoo.getAnimals()));
                }
                case 4 -> {
                    System.out.println("Exiting program.");
                    mainFunction = false;
                }
                case 9 -> throw new RuntimeException("kdsalfdsjalf");

                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addAnimalToZoo(Scanner scanner, RunZoo zoo) {
        int strength, health, defense, speed;

        System.out.print("Enter the name of the animal: ");
        String name = scanner.nextLine();
        System.out.print("Enter the age of the animal: ");
        int age = scanner.nextInt();
        scanner.nextLine();
        do {
            System.out.print("Enter the strength of the animal (max 100 min 10): ");
            strength = scanner.nextInt();
            scanner.nextLine();
        } while (strength < 10 || strength > 100);

        do {
            System.out.print("Enter the health of the animal (max 200 min 100): ");
            health = scanner.nextInt();
            scanner.nextLine();
        } while (health < 100 || health > 200);

        do {
            System.out.print("Enter the defense of the animal (max 100 min 10): ");
            defense = scanner.nextInt();
            scanner.nextLine();
        } while (defense < 10 || defense > 100);

        do {
            System.out.print("Enter the speed of the animal (max 100 min 10): ");
            speed = scanner.nextInt();
            scanner.nextLine();
        } while (speed < 10 || speed > 100);


        System.out.println("Select the animal type:");
        System.out.println("1. Lion");
        System.out.println("2. Elephant");
        System.out.println("3. Shark");
        System.out.println("4. Gorilla");
        System.out.println("5. Snake");
        System.out.println("6. Penguin");
        System.out.println("7. Tiger");
        System.out.println("8. Crocodile");
        System.out.println("9. Giraffe");
        System.out.println("10. Zebra");
        System.out.println("11. Panda");
        System.out.println("12. Bear");
        System.out.println();
        int animalChoice = scanner.nextInt();
        scanner.nextLine();
        Animal animal;

        switch (animalChoice) {
            case 1 -> animal = new Lion(name, age, strength, health, defense, speed);
            case 2 -> animal = new Elephant(name, age, strength, health, defense, speed);
            case 3 -> animal = new Shark(name, age, strength, health, defense, speed);
            case 4 -> animal = new Gorilla(name, age, strength, health, defense, speed);
            case 5 -> animal = new Snake(name, age, strength, health, defense, speed);
            case 6 -> animal = new Penguin(name, age, strength, health, defense, speed);
            case 7 -> animal = new Tiger(name, age, strength, health, defense, speed);
            case 8 -> animal = new Crocodile(name, age, strength, health, defense, speed);
            case 9 -> animal = new Giraffe(name, age, strength, health, defense, speed);
            case 10 -> animal = new Zebra(name, age, strength, health, defense, speed);
            case 11 -> animal = new Panda(name, age, strength, health, defense, speed);
            case 12 -> animal = new Bear(name, age, strength, health, defense, speed);
            default -> {
                System.out.println("Invalid choice. Animal not added to the zoo.");
                return;
            }
        }
        zoo.addAnimal(animal);
        System.out.println(name + " has been added to the zoo as a " + animal.getClass().getSimpleName());
    }
}