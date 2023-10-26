package com.informaticon.java.tutorial.zoo.miph.game;

import com.informaticon.java.tutorial.zoo.miph.animals.Animal;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Game {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";


    private final Random countR = new Random();

    // class variables with active or benched states for team 1 & 2
    private Animal team1Active;
    private Animal team1Benched;
    private Animal team2Active;
    private Animal team2Benched;
    private boolean mainFunction;

    public Game() {
        setMainFunction(true);
    }

    public boolean startGame(List<Animal> zooAnimals) {
        if (zooAnimals.isEmpty() || zooAnimals.size() < 4) {
            System.out.println();
            System.out.println("The following condition needs to be fulfilled.");
            System.out.println("You can try again.");
            return true;
        }
        Random random = new Random();

//        int index1 = random.nextInt(zooAnimals.size());
//        int index2;
//        do {
//            index2 = random.nextInt(zooAnimals.size());
//        } while (index2 == index1);
//        int index3;
//        do {
//            index3 = random.nextInt(zooAnimals.size());
//        } while (index3 == index2 || index3 == index1);
//        int index4;
//        do {
//            index4 = random.nextInt(zooAnimals.size());
//        } while (index4 == index1 || index4 == index2 || index4 == index3);


        team1Active = zooAnimals.get(6);
        team2Active = zooAnimals.get(2);
        team1Benched = zooAnimals.get(1);
        team2Benched = zooAnimals.get(5);

        System.out.println("Battle: " + ANSI_BLUE + team1Active.getName() + " & " + team1Benched.getName()
                + ANSI_RESET + " vs " + ANSI_RED + team2Active.getName() + " & " + team2Benched.getName()
                + ANSI_RESET);
        fight();

        return false;
    }

    public void fight() {

        // work with class variables from here
        //team1Active


        boolean isTurnAnimal1 = true;
        if (team1Active != null || team2Active != null) {
            assert team1Active != null;
            displayAnimalStats(team1Active);
            drawHealthBar(team1Active);
            System.out.println();
            System.out.println();
            displayAnimalStats(team2Active);
            drawHealthBar(team2Active);
            System.out.println();
            while (team1Active.getHealth() > 0 || team2Active.getHealth() > 0) {
                if (isTurnAnimal1) {
                    fightInput(team1Active);
                    isTurnAnimal1 = false;
                } else {
                    fightInput(team2Active);
                    battlePhase();
                    battleAction(team1Active, team2Active);
                    isTurnAnimal1 = true;
                }
                if ((team1Active.getHealth() <= 0 && team1Benched.getHealth() <= 0) || (team2Active.getHealth() <= 0 &&
                        team2Benched.getHealth() <= 0)) {
                    endGame();
                    return;
                } else if (team1Active.getHealth() <= 0) {
                    animalFainted(team1Active, team1Benched, 1);
                    isTurnAnimal1 = false;
                } else if (team2Active.getHealth() <= 0) {
                    animalFainted(team2Active, team2Benched, 2);
                    isTurnAnimal1 = true;
                }
            }
        }
    }

    public void endGame() {
        System.out.println();
        System.out.println("Game Over!");
        if (team1Active.getHealth() <= 0 && team1Benched.getHealth() <= 0) {
            System.out.println(team2Active.getName() + " and " + team2Benched.getName() + " wins!");
        } else {
            System.out.println(team1Active.getName() + " and " + team1Benched.getName() + " wins!");
        }
    }

    public void battlePhase() {

        if (team1Active.getSpeed() != team2Active.getSpeed()) {
            if (team1Active.getSpeed() > team2Active.getSpeed()) {
                // team 1 goes first
                performingAction(team1Active, team2Active, team1Benched, 1);
                performingAction(team2Active, team1Active, team2Benched, 2);
            } else if (team1Active.getSpeed() < team2Active.getSpeed()) {
                performingAction(team2Active, team1Active, team2Benched, 2);
                performingAction(team1Active, team2Active, team1Benched, 1);
            }
        } else {
            Random random = new Random();
            int bound = 2;
            int randomChoice = random.nextInt(bound);
            if (randomChoice == 0) {
                performingAction(team1Active, team2Active, team1Benched, 1);
                performingAction(team2Active, team1Active, team2Benched, 2);
            } else {
                performingAction(team2Active, team1Active, team2Benched, 2);
                performingAction(team1Active, team2Active, team1Benched, 1);
            }
        }

    }

    public void fightInput(Animal attacker) {
        System.out.println();
        System.out.println("choose 1 option for " + attacker.getName());
        System.out.println("1. attack");
        System.out.println("2. heal");
        System.out.println("3. power up");
        System.out.println("4. defense up");
        System.out.println("5. set smokes");
        System.out.println("6. switch animals");
        System.out.println();
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int actionGame = 0;
        try {
            actionGame = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println("You must input a number!");
        }
        switch (actionGame) {
            case 1 -> attacker.setActionChoice(actionGame);
            case 2 -> attacker.setActionChoice(actionGame);
            case 3 -> attacker.setActionChoice(actionGame);
            case 4 -> attacker.setActionChoice(actionGame);
            case 5 -> attacker.setActionChoice(actionGame);
            case 6 -> attacker.setActionChoice(actionGame);
            default -> System.out.println("Invalid choice!");
        }
    }

    public void battleAction(Animal attacker, Animal defender) {
        System.out.println();
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

    public void drawHealthBar(Animal animal) {
        int barLength = 20;
        double healthBarFill = ((double) animal.getHealth() / animal.getMaxHealth()) * barLength;

        System.out.print("Health: [");

        for (int i = 0; i < barLength; i++) {
            if (i < healthBarFill) {
                System.out.print("\uD83D\uDFE9");
            } else {
                System.out.print("\uD83D\uDFE5");
            }
        }

        System.out.print("] " + animal.getHealth() + "/" + animal.getMaxHealth());
    }

    public void displayAnimalStats(Animal animal) {
        System.out.println(animal.getIcon() + " " + animal.getName() + " stats: " + " ⚔\uFE0F: " + animal.getStrength()
                + " \uD83D\uDEE1\uFE0F: " + animal.getDefense() + " \uD83C\uDFC3: " + animal.getSpeed() +
                " \uD83D\uDE36\u200D\uD83C\uDF2B\uFE0F: " + animal.getCounter());
    }

    public void performingAction(Animal activeAnimal, Animal activeAnimalOpponent, Animal benchedAnimal, int team) {
        if (activeAnimal.getHealth() > 0) {
            switch (activeAnimal.getActionChoice()) {
                case 1 -> executeSmokesBasedOnPercentage(activeAnimal, activeAnimalOpponent);
                case 2 -> newHeal(activeAnimal);
                case 3 -> newPowerUp(activeAnimal);
                case 4 -> newDefenseUp(activeAnimal);
                case 5 -> newIncreaseCounterForSmokesScreen(activeAnimal);
                case 6 -> {
                    if (benchedAnimal.getHealth() <= 0) {
                        System.out.println(ANSI_RED + activeAnimal.getName() + " can't be switched with " + benchedAnimal.getName() + ANSI_RESET);
                    } else {
                        switchAnimal(team);
                    }
                }
            }
        } else {
            System.out.println(activeAnimal.getName() + " has fainted, it can't perform any actions!");
        }
    }

    public void attack(Animal attacker, Animal defender) {

        int pDamage = attacker.getStrength();
        int opDefense = defender.getDefense();

        int dmgTaken = opDefense - pDamage;
        int dmgOutput;

        if (dmgTaken < 0) {
            defender.setHealth(defender.getHealth() + dmgTaken);
            dmgOutput = Math.abs(dmgTaken);
            System.out.println(ANSI_RED + attacker.getName() + " inflicts " + dmgOutput + " dmg to " + defender.getName() +
                    ANSI_RESET);
            System.out.println("health: " + defender.getHealth());
        } else if (dmgTaken == 0) {
            System.out.println(ANSI_RED + attacker.getName() + "'s attack has no effect on " + defender.getName() + ANSI_RESET);
        } else {
            attacker.setHealth(attacker.getHealth() - dmgTaken);
            dmgOutput = Math.abs(dmgTaken);
            System.out.println(ANSI_RED + attacker.getName() + " inflicts " + dmgOutput + " dmg to itself." +
                    ANSI_RESET);
            System.out.println("health: " + attacker.getHealth());
        }

        // reset strenth and defense
        attacker.setStrength(attacker.getOriginalStrength());
        defender.setDefense(defender.getOriginalDefense());
    }

    public void newHeal(Animal animal1Or2) {
        Random random = new Random();
        System.out.println();
        System.out.println(animal1Or2.getMaxHealth());
        System.out.println(animal1Or2.getHealth());
        int heal = random.nextInt(10, 100);
        if (heal == 0) {
            return;
        }

        if (animal1Or2.getMaxHealth() <= animal1Or2.getHealth()) {
            System.out.println("You can't heal because your health has already reached its max!");
        } else {
            int newHealth = Math.min(animal1Or2.getMaxHealth(), animal1Or2.getHealth() + heal);
            int actualHeal = newHealth - animal1Or2.getHealth();
            animal1Or2.setHealth(newHealth);
            System.out.println(ANSI_GREEN + animal1Or2.getName() + " healed for " + actualHeal + " health." + ANSI_RESET);
            System.out.println(animal1Or2.getHealth());
        }
    }

    public void newPowerUp(Animal animal1Or2) {
        System.out.println();
        System.out.println("the previous strength: " + animal1Or2.getStrength());
        Random random = new Random();
        double randomMultiplier = random.nextDouble();
        int currentStrength = animal1Or2.getStrength();
        double strengthMultiplier = currentStrength * (randomMultiplier);
        double strengthMultiplied = currentStrength + strengthMultiplier;

        currentStrength = (int) strengthMultiplied;
        animal1Or2.setStrength(currentStrength);

        System.out.println(ANSI_PURPLE + animal1Or2.getName() + " has its strength increased to " + currentStrength + ANSI_RESET);
    }

    public void newDefenseUp(Animal animal1Or2) {
        System.out.println();
        System.out.println("the previous defense: " + animal1Or2.getDefense());
        Random random = new Random();
        double randomMultiplier = random.nextDouble();
        int currentDefense = animal1Or2.getDefense();
        double defenseMultiplier = currentDefense * (randomMultiplier);
        double defenseMultiplied = currentDefense + defenseMultiplier;

        currentDefense = (int) defenseMultiplied;
        animal1Or2.setDefense(currentDefense);
        System.out.println(ANSI_CYAN + animal1Or2.getName() + " has its defense increased to " + currentDefense + ANSI_RESET);
    }

    public void newIncreaseCounterForSmokesScreen(Animal animal1Or2) {
        if (animal1Or2.getMaxSmokesUsage() < 3) {
            animal1Or2.setCounter(animal1Or2.getCounter() + 1);
            System.out.println(animal1Or2.getName() + " has increased its smokescounter to: " + animal1Or2.getCounter());
        } else {
            System.out.println("You can't set smokes anymore!");
        }
    }

    public void executeSmokesBasedOnPercentage(Animal attacker, Animal defender) {
        int percentage = calculatePercentage(defender);

        if (countR.nextInt(100) < percentage) {
            defender.setCounter(0);
            defender.setMaxSmokesUsage(defender.getMaxSmokesUsage() + 1);
            dodge(defender);
        } else {
            attack(attacker, defender);
        }
    }

    public void dodge(Animal animalDodged) {
        System.out.println(ANSI_CYAN + animalDodged.getName() + " dodged the attack!" + ANSI_RESET);
        int smokesAvailable = 4 - animalDodged.getMaxSmokesUsage();
        System.out.println("dodges available for " + animalDodged.getName() + ": " + smokesAvailable);
    }

    public int calculatePercentage(Animal animal1Or2) {
        return Math.min(animal1Or2.getCounter() * 50, 100);
    }

    public void switchAnimal(int team) {
        Animal switchedAnimal;
        switch (team) {
            case 1 -> {
                switchedAnimal = team1Active;
                team1Active = team1Benched;
                team1Benched = switchedAnimal;
                System.out.println(ANSI_YELLOW + team1Benched.getName() + " has been switched with " + team1Active.getName() + ANSI_RESET);
            }
            case 2 -> {
                switchedAnimal = team2Active;
                team2Active = team2Benched;
                team2Benched = switchedAnimal;
                System.out.println(ANSI_YELLOW + team2Benched.getName() + " has been switched with " + team2Active.getName() + ANSI_RESET);
            }
        }
    }

    public void animalFainted(Animal animalFainted, Animal switchedAnimal, int team) {
        System.out.println();
        System.out.println(animalFainted.getName() + " has been fainted!");
        switchAnimal(team);
        if (team == 1) {
            fightInput(switchedAnimal);
        }
    }

    public void setMainFunction(boolean mainFunction) {
        this.mainFunction = mainFunction;
    }
}