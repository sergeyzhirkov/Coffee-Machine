package machine;

import java.util.Scanner;

public class CoffeeMachine {
    private static int countWater = 400;
    private static int countMilk = 540;
    private static int countCoffeeBeans = 120;
    private static int disposableCups = 9;
    private static int countMoney = 550;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {


//        System.out.println("Write how many ml of water the coffee machine has: ");
//        int water = scanner.nextInt();
//        System.out.println("Write how many ml of milk the coffee machine has: ");
//        int milk = scanner.nextInt();
//        System.out.println("Write how many grams of coffee beans the coffee machine has: ");
//        int coffeeBeans = scanner.nextInt();
//        System.out.println("Write how many cups of coffee you will need: ");
//        int cupsCount = scanner.nextInt();
//
//        water /= 200;
//        milk /= 50;
//        coffeeBeans /= 15;
//        int maxCupsCount = Math.min(Math.min(water, milk), coffeeBeans);
//
//        if (maxCupsCount < cupsCount) {
//            System.out.printf("No, I can make only %d cup(s) of coffee", maxCupsCount);
//        } else {
//            System.out.print("Yes, I can make that amount of coffee ");
//            if (maxCupsCount > cupsCount) {
//                System.out.printf("(and even %d more than that)", maxCupsCount - cupsCount);
//            }
//        }
        infoCoffeeMachine();
        userAction();
        infoCoffeeMachine();

    }

    private static void userAction() {
        System.out.println("Write action (buy, fill, take): ");
        String action = scanner.nextLine();
        switch (action) {
            case "buy":
                buy();
                break;
            case "fill":
                fill();
                break;
            case "take":
                take();
                break;
        }
    }

    private static void buy() {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino: ");
        switch (scanner.nextInt()) {
            case 1:
                countWater -= 250;
                countCoffeeBeans -= 16;
                countMoney += 4;
                break;
            case 2:
                countWater-=350;
                countMilk-=75;
                countCoffeeBeans-=20;
                countMoney+=7;
                break;
            case 3:
                countWater -=200;
                countMilk -= 100;
                countCoffeeBeans -=12;
                countMoney +=6;
                break;
        }
        disposableCups--;
    }

    private static void take() {
        System.out.println("I gave you $" + countMoney);
        countMoney = 0;
    }

    private static void fill() {
        System.out.println("Write how many ml of water do you want to add: ");
        countWater += scanner.nextInt();
        System.out.println("Write how many ml of milk do you want to add: ");
        countMilk += scanner.nextInt();
        System.out.println("Write how many grams of coffee beans do you want to add: ");
        countCoffeeBeans += scanner.nextInt();
        System.out.println("Write how many disposable cups of coffee do you want to add: ");
        disposableCups += scanner.nextInt();
    }

    private static void infoCoffeeMachine() {
        System.out.printf(
                "The coffee machine has:\n" +
                        "%d of water\n" +
                        "%d of milk\n" +
                        "%d of coffee beans\n" +
                        "%d of disposable cups\n" +
                        "%d of money",
                countWater, countMilk, countCoffeeBeans, disposableCups, countMoney);

    }
}
