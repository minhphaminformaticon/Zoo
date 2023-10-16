
import java.util.Scanner;

public class MainApplication {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RunZoo zoo = new RunZoo();
        Game game = new Game();

        Lion lion = new Lion("minh", 20, 100, 200, 50);
        Lion lion1 = new Lion("bob",20, 100, 200, 50);

        zoo.addAnimal(lion);
        zoo.addAnimal(lion1);


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

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> addAnimalToZoo(scanner, zoo);
                case 2 -> zoo.displayAnimals();
                case 3 -> {
                    mainFunction = game.startGame((zoo.getAnimals()));
                }
                case 4-> {
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
            System.out.print("Enter the strength of the animal (max 100): ");
            strength = scanner.nextInt();
            scanner.nextLine();
        } while (strength < 0 || strength > 100);

        do {
            System.out.print("Enter the health of the animal (max 200): ");
            health = scanner.nextInt();
            scanner.nextLine();
        } while (health < 0 || health > 200);

        do {
            System.out.print("Enter the defense of the animal (max 100): ");
            defense = scanner.nextInt();
            scanner.nextLine();
        } while (defense < 0 || defense > 100);

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
                System.out.println("Invalid choice. Animal not added to the zoo.");
                return;
            }
        }

        zoo.addAnimal(animal);
        System.out.println(name + " has been added to the zoo as a " + animal.getAnimal());
    }
}
