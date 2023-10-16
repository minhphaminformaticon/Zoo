import java.util.Random;
import java.util.List;
import java.util.Scanner;

public class Game {
    private Animal animal1;
    private Animal animal2;

    int maxHealth;


    int maxHealth2;


    public boolean mainFunction;

    public Game(){
        mainFunction = true;
    }


    public boolean startGame(List<Animal> zooAnimals) {
        if (zooAnimals.isEmpty() || zooAnimals.size() < 2) {
            System.out.println();
            System.out.println("The following condition needs to be fulfilled.");
            System.out.println("You can try again.");
            return true;
        }
        Game game = new Game();
        Random random = new Random();

        int index1 = random.nextInt(zooAnimals.size());
        int index2;
        do {
            index2 = random.nextInt(zooAnimals.size());
        } while (index2 == index1);

        Animal animal1 = zooAnimals.get(index1);
        Animal animal2 = zooAnimals.get(index2);

        Animal[] selectedAnimals = new Animal[]{animal1, animal2};
        System.out.println("Battle: " + selectedAnimals[0].getName() + " vs " + selectedAnimals[1].getName());

        game.fight(selectedAnimals[0], selectedAnimals[1]);
        return false;


    }
    public void attack(Animal animal1, Animal animal2){
        this.animal1 = animal1;
        this.animal2 = animal2;

        int pDamage = animal1.strength;
        int opDefense = animal2.defense;

        int dmgTaken= opDefense - pDamage;

        if (dmgTaken < 0) {
            System.out.println(dmgTaken);
            System.out.println();
            animal2.health += dmgTaken;
        }
        System.out.println(animal1.name + " inflicts " + pDamage + " dmg to " + animal2.name);
        System.out.println("health: " + animal2.health);
    }
    public void heal(Animal animal1){
        this.animal1 = animal1;

        System.out.println(maxHealth);
        System.out.println(animal1.health);
        int heal = 20;
        if(maxHealth <= animal1.health){
            System.out.println("You can't heal because your health has already reached its max!");
            return;
        }else {
            int newHealth = Math.min(maxHealth, animal1.health + heal);
            int actualHeal = newHealth - animal1.health;
            animal1.health = newHealth;
            System.out.println(animal1.name + " healed for " + actualHeal + " health.");
        }
    }
    public void attack2(Animal animal1, Animal animal2){
        this.animal1 = animal1;
        this.animal2 = animal2;

        int pDamage = animal2.strength;
        int opDefense = animal1.defense;

        int dmgTaken= opDefense - pDamage;
        if (dmgTaken < 0) {
            System.out.println(dmgTaken);
            System.out.println();
            animal1.health += dmgTaken;
        }
        System.out.println(animal2.name + " inflicts " + pDamage + " dmg to " + animal1.name);
        System.out.println("health: " + animal1.health);
    }
    public void heal2(Animal animal2){
        this.animal2 = animal2;

        System.out.println(maxHealth2);
        System.out.println(animal2.health);
        int heal = 20;
        if(maxHealth2 <= animal2.health){
            System.out.println("You can't heal because your health has already reached its max!");
            return;
        }else {
            int newHealth = Math.min(maxHealth2, animal2.health + heal);
            int actualHeal = newHealth - animal2.health;
            animal2.health = newHealth;
            System.out.println(animal2.name + " healed for " + actualHeal + " health.");
        }
    }
    public void endGame(Animal animal1, Animal animal2) {
        System.out.println("Game Over!");
        if (animal1.health <= 0 && animal2.health <= 0) {
            System.out.println("It's a draw! Both animals have fainted.");
        } else if (animal1.health <= 0) {
            System.out.println(animal2.getName() + " wins!");
        } else {
            System.out.println(animal1.getName() + " wins!");
        }
    }

    public void fight(Animal animal1, Animal animal2){
        boolean isTurn = true;
        if (animal1 == null || animal2 == null){
            return;
        }else {
            maxHealth = animal1.getHealth();
            maxHealth2 = animal2.getHealth();
            while(animal1.health > 0 || animal2.health > 0){
                Scanner inputGame = new Scanner(System.in);
                int actionGame;
                if (isTurn){
                    System.out.println();
                    System.out.println("choose 1 option player 1");
                    System.out.println("1. attack");
                    System.out.println("2. heal");
                    System.out.println();
                    System.out.println("Max HP: " + maxHealth);
                    System.out.println("Current HP: " + animal1.health);
                    System.out.println("Strength: " + animal1.strength);
                    System.out.println("Defense: " + animal1.defense);
                    System.out.println();

                    actionGame = Integer.parseInt(inputGame.nextLine());
                    switch (actionGame){
                        case 1 ->   attack(animal1, animal2);
                        case 2->    heal(animal1);
                        default -> System.out.println("Invalid choice. Please try again.");
                    }
                    isTurn = false;
                }else {
                    Scanner inputGame2 = new Scanner(System.in);
                    int actionGame2;
                    System.out.println();
                    System.out.println("choose 1 option player 2");
                    System.out.println("1. attack");
                    System.out.println("2. heal");
                    System.out.println();
                    System.out.println("Max HP: " + maxHealth2);
                    System.out.println("Current HP: " + animal2.health);
                    System.out.println("Strength: " + animal2.strength);
                    System.out.println("Defense: " + animal2.defense);
                    System.out.println();
                    actionGame2 = Integer.parseInt(inputGame2.nextLine());
                    switch (actionGame2) {
                        case 1 -> attack2(animal1, animal2);
                        case 2 -> heal2(animal2);
                        default -> System.out.println("Invalid choice. Please try again.");
                    }
                    isTurn = true;
                }
                if (animal1.health <= 0 || animal2.health <= 0) {
                    endGame(animal1, animal2);
                    return;
                }
            }

        }
    }

}