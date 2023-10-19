package com.informaticon.java.tutorial.zoo.miph;

import java.util.Random;
import java.util.List;
import java.util.Scanner;

public class Game {

    public boolean mainFunction;

    Random countR = new Random();

    public Game() {
        mainFunction = true;
    }

    public void newIncreaseCounterForSmokesScreen(Animal animal1Or2) {
        animal1Or2.counter++;
    }

    public void executeSmokesBasedOnPercentage(Animal attacker, Animal defender) {
        int percentage = calculatePercentage(defender);

        if (countR.nextInt(100) < percentage) {
            defender.counter = 0;
            dodge();
        } else {
            attack(attacker, defender);
        }
    }

    public void dodge() {
        System.out.println("attack dodged!");
    }

    public int calculatePercentage(Animal animal1Or2) {
        return Math.min(animal1Or2.counter * 25, 100);
    }

    /**
     * This method initializes and starts the game with 4 animals.
     *
     * @param zooAnimals list of all animals in the zoo
     * @return false
     */
    public boolean startGame(List<Animal> zooAnimals) {
        if (zooAnimals.isEmpty() || zooAnimals.size() < 4) {
            System.out.println();
            System.out.println("The following condition needs to be fulfilled.");
            System.out.println("You can try again.");
            return true;
        }
        Random random = new Random();

        int index1 = random.nextInt(zooAnimals.size());
        int index2;
        do {
            index2 = random.nextInt(zooAnimals.size());
        } while (index2 == index1);
        int index3;
        do {
            index3 = random.nextInt(zooAnimals.size());
        } while (index3 == index2 || index3 == index1);
        int index4;
        do {
            index4 = random.nextInt(zooAnimals.size());
        } while (index4 == index1 || index4 == index2 || index4 == index3);

        Animal animal1Or2 = zooAnimals.get(index1);
        Animal animal1or2 = zooAnimals.get(index2);
        Animal benchedAnimals = zooAnimals.get(index3);
        Animal benchedAnimals2 = zooAnimals.get(index4);

        Animal[] selectedAnimals = new Animal[]{animal1Or2, animal1or2, benchedAnimals, benchedAnimals2};
        System.out.println("Battle: " + selectedAnimals[0].getName() + " vs " + selectedAnimals[1].getName());

        fight(selectedAnimals[0], selectedAnimals[1], selectedAnimals[2], selectedAnimals[3]);
        return false;
    }

    public void attack(Animal attacker, Animal defender) {

        int pDamage = attacker.strength;
        int opDefense = defender.defense;

        int dmgTaken = opDefense - pDamage;
        int dmgOutput = 0;

        if (dmgTaken < 0) {
            defender.health += dmgTaken;
            dmgOutput = Math.abs(dmgTaken);
        }
        System.out.println(attacker.name + " inflicts " + dmgOutput + " dmg to " + defender.name);
        System.out.println("health: " + defender.health);
    }

    public void newheal(Animal animal1Or2) {
        System.out.println(animal1Or2.maxHealth);
        System.out.println(animal1Or2.health);
        int heal = 20;
        if (animal1Or2.maxHealth <= animal1Or2.health) {
            System.out.println("You can't heal because your health has already reached its max!");
            return;
        } else {
            int newHealth = Math.min(animal1Or2.maxHealth, animal1Or2.health + heal);
            int actualHeal = newHealth - animal1Or2.health;
            animal1Or2.health = newHealth;
            System.out.println(animal1Or2.name + " healed for " + actualHeal + " health.");
            System.out.println(animal1Or2.health);
        }
    }

    public void newPowerUp(Animal animal1Or2) {
        System.out.println("the previous strength: " + animal1Or2.strength);
        System.out.println();

        int currentStrength = animal1Or2.strength;
        double strengthMultiplier = currentStrength * 0.2;
        double strengthMutiplied = currentStrength + strengthMultiplier;

        currentStrength = (int) strengthMutiplied;
        animal1Or2.strength = currentStrength;

        System.out.println(animal1Or2.name + " has its strength increased to " + currentStrength);
    }

    public void switchAnimal(Animal oldAnimal, Animal newAnimal) {
        int switchedStrength = oldAnimal.strength;
        int switchedHealth = oldAnimal.health;
        int switchedDefense = oldAnimal.defense;
        String switchedName = oldAnimal.name;
        String switchedIcon = oldAnimal.getIcon();

        oldAnimal.strength = newAnimal.strength;
        oldAnimal.health = newAnimal.health;
        oldAnimal.defense = newAnimal.defense;
        oldAnimal.setIcon(newAnimal.getIcon());

        newAnimal.strength = switchedStrength;
        newAnimal.health = switchedHealth;
        newAnimal.defense = switchedDefense;
        newAnimal.setIcon(switchedIcon);

        System.out.println(oldAnimal.name + " has been switched with " + newAnimal.name);
        oldAnimal.name = newAnimal.name;
        newAnimal.name = switchedName;

        int switchedMaxHealth = oldAnimal.maxHealth;
        oldAnimal.maxHealth = newAnimal.maxHealth;
        newAnimal.maxHealth = switchedMaxHealth;
    }


    public void endGame(Animal animal1, Animal animal2, Animal animal3, Animal animal4) {
        System.out.println();
        System.out.println("zoo.Game Over!");
        if (animal1.health <= 0 && animal3.health <= 0) {
            System.out.println(animal2.name + " and " + animal4.name + " wins!");
        } else {
            System.out.println(animal1.name + " and " + animal3.name + " wins!");
        }
    }

    public void drawHealthBar(Animal animal) {
        int barLength = 20;
        double healthBarFill = ((double) animal.health / animal.maxHealth) * barLength;

        System.out.print("Health: [");

        for (int i = 0; i < barLength; i++) {
            if (i < healthBarFill) {
                System.out.print("\uD83D\uDFE9");
            } else {
                System.out.print("\uD83D\uDFE5");
            }
        }

        System.out.print("] " + animal.health + "/" + animal.maxHealth);
    }

    public void animalFainted(Animal animalFainted, Animal benchedAnimal) {
        System.out.println();
        System.out.println(animalFainted.name + " has been fainted!");
        System.out.println();
        switchAnimal(animalFainted, benchedAnimal);
    }

    public void displayAnimalStats(Animal animal) {
        System.out.println(animal.getIcon() + " " + animal.name + " stats: " + " ⚔\uFE0F: " + animal.strength + " \uD83D\uDEE1\uFE0F: " + animal.defense + " \uD83D\uDE36\u200D\uD83C\uDF2B\uFE0F: " + animal.counter);
    }

    public void battleAction(Animal attacker, Animal defender) {
        System.out.println("--------------------------------------");
        displayAnimalStats(attacker);
        drawHealthBar(attacker);
        System.out.println();
        System.out.println();
        displayAnimalStats(defender);
        drawHealthBar(defender);
        System.out.println();
        System.out.println();
    }

    public void fightInput(Animal attacker, Animal defender, Animal benchedAnimal) {
        System.out.println("choose 1 option for " + attacker.name);
        System.out.println("1. attack");
        System.out.println("2. heal");
        System.out.println("3. power up");
        System.out.println("4. set smokes");
        System.out.println("5. switch zoo.animals");
        System.out.println();
        Scanner inputGame = new Scanner(System.in);
        int actionGame;
        actionGame = Integer.parseInt(inputGame.nextLine());
        switch (actionGame) {
            case 1 -> executeSmokesBasedOnPercentage(attacker, defender);
            case 2 -> newheal(attacker);
            case 3 -> newPowerUp(attacker);
            case 4 -> newIncreaseCounterForSmokesScreen(attacker);
            case 5 -> switchAnimal(attacker, benchedAnimal);
            default -> System.out.println("Invalid choice. Please try again.");
        }

    }

    public void fight(Animal animal1, Animal animal2, Animal animal3, Animal animal4) {
        boolean isTurnAnimal1 = true;
        if (animal1 == null || animal2 == null) {
            return;
        } else {
            animal1.maxHealth = animal1.getHealth();
            animal2.maxHealth = animal2.getHealth();
            animal3.maxHealth = animal3.getHealth();
            animal4.maxHealth = animal4.getHealth();


            while (animal1.health > 0 || animal2.health > 0) {
                if (isTurnAnimal1) {
                    battleAction(animal1, animal2);
                    fightInput(animal1, animal2, animal3);
                    isTurnAnimal1 = false;
                } else {
                    battleAction(animal2, animal1);
                    fightInput(animal2, animal1, animal4);
                    isTurnAnimal1 = true;
                }
                if ((animal1.health <= 0 && animal3.health <= 0) || (animal2.health <= 0 && animal4.health <= 0)) {
                    endGame(animal1, animal2, animal3, animal4);
                    return;
                } else if (animal1.health <= 0) {
                    animalFainted(animal1, animal3);
                    isTurnAnimal1 = false;
                } else if (animal2.health <= 0) {
                    animalFainted(animal2, animal4);
                    isTurnAnimal1 = true;
                }
            }
        }
    }
}