package com.informaticon.java.tutorial.zoo.miph;

import java.util.Scanner;

public class MainApplication {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RunZoo zoo = new RunZoo();
        Game game = new Game();

        Lion lion = new Lion("lion minh", 20, 100, 200, 50);
        Tiger tiger = new Tiger("tiger minh", 20, 100, 200, 50);
        Shark shark = new Shark("shark minh", 20, 100, 200, 50);
        Elephant elephant = new Elephant("elephant minh", 20, 100, 200, 50);
        Snake snake = new Snake("snake minh", 20, 100, 200, 50);
        Gorilla gorilla = new Gorilla("gorilla minh", 20, 100, 200, 50);
        Giraffe giraffe = new Giraffe("giraffe minh", 20, 100, 200, 50);
        Zebra zebra = new Zebra("zebra minh", 20, 100, 200, 50);
        Panda panda = new Panda("panda minh", 20, 100, 200, 50);
        Penguin penguin = new Penguin("penguin minh", 20, 100, 200, 50);

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
            System.out.println("2. Display zoo.animals in the zoo");
            System.out.println("3. zoo.Animal Battle");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> addAnimalToZoo(scanner, zoo);
                case 2 -> zoo.displayAnimals();
                case 3 -> {
                    mainFunction = game.startGame((zoo.getAnimals()));
                }
                case 4 -> {
                    System.out.println("Exiting program.");
                    scanner.close();
                    System.exit(0);
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addAnimalToZoo(Scanner scanner, RunZoo zoo) {
        int strength, health, defense;

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

        System.out.println("Select the animal type:");
        System.out.println("1. zoo.Lion");
        System.out.println("2. zoo.Elephant");
        System.out.println("3. zoo.Shark");
        System.out.println("4. zoo.Gorilla");
        System.out.println("5. zoo.Snake");
        System.out.println("6. zoo.Penguin");
        System.out.println("7. zoo.Tiger");
        System.out.println("8. zoo.Crocodile");
        System.out.println("9. zoo.Giraffe");
        System.out.println("10. zoo.Zebra");
        System.out.println("11. zoo.Panda");
        System.out.println();
        int animalChoice = scanner.nextInt();
        scanner.nextLine();
        Animal animal;

        switch (animalChoice) {
            case 1 -> animal = new Lion(name, age, strength, health, defense);
            case 2 -> animal = new Elephant(name, age, strength, health, defense);
            case 3 -> animal = new Shark(name, age, strength, health, defense);
            case 4 -> animal = new Gorilla(name, age, strength, health, defense);
            case 5 -> animal = new Snake(name, age, strength, health, defense);
            case 6 -> animal = new Penguin(name, age, strength, health, defense);
            case 7 -> animal = new Tiger(name, age, strength, health, defense);
            case 8 -> animal = new Crocodile(name, age, strength, health, defense);
            case 9 -> animal = new Giraffe(name, age, strength, health, defense);
            case 10 -> animal = new Zebra(name, age, strength, health, defense);
            case 11 -> animal = new Panda(name, age, strength, health, defense);
            default -> {
                System.out.println("Invalid choice. zoo.Animal not added to the zoo.");
                return;
            }
        }
        zoo.addAnimal(animal);
        System.out.println(name + " has been added to the zoo as a " + animal.getClass());
    }
}
