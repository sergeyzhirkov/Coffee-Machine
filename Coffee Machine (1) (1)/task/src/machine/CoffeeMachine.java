package machine;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class CoffeeMachine {
    private static int countWater = 400;
    private static int countMilk = 540;
    private static int countCoffeeBeans = 120;
    private static int disposableCups = 9;
    private static int countMoney = 550;
    private static Scanner scanner = new Scanner(System.in);
    private static boolean isExit = false;
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException{

        while (!isExit) {
            userAction();
        }

    }

    private static void userAction() throws IOException {
        System.out.println("Write action (buy, fill, take, remaining, exit): ");
        String action = reader.readLine();
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
            case "remaining":
                infoCoffeeMachine();
                break;
            case "exit":
                isExit = true;
                break;
        }
    }

    private static void buy() throws IOException{
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino: ");
        String s = reader.readLine();
        switch (s) {
            case "1":
                doEspresso();
                break;
            case "2":
                doLatte();
                break;
            case "3":
                doCappuccino();
                break;
            default:
                disposableCups++;
                break;
        }
        disposableCups--;
    }

    private static void doCappuccino() {
        if (countWater >= 200 && countCoffeeBeans >= 12 && countMilk >= 100 && disposableCups > 0) {
            countWater -= 200;
            countMilk -= 100;
            countCoffeeBeans -= 12;
            countMoney += 6;
            System.out.println("I have enough resources, making you a coffee!");
        } else {
            System.out.println("Sorry, not enough water!");
            disposableCups++;
        }

    }

    private static void doLatte() {
        if (countWater >= 350 && countCoffeeBeans >= 20 && countMilk >= 75 && disposableCups > 0) {
            countWater -= 350;
            countMilk -= 75;
            countCoffeeBeans -= 20;
            countMoney += 7;
            System.out.println("I have enough resources, making you a coffee!");
        } else {
            System.out.println("Sorry, not enough water!");
            disposableCups++;
        }
    }

    private static void doEspresso() {
        if (countWater >= 250 && countCoffeeBeans >= 16 && disposableCups > 0) {
            countWater -= 250;
            countCoffeeBeans -= 16;
            countMoney += 4;
            System.out.println("I have enough resources, making you a coffee!");
        } else {
            System.out.println("Sorry, not enough water!");
            disposableCups++;
        }
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
                        "$%d of money\n",
                countWater, countMilk, countCoffeeBeans, disposableCups, countMoney);

    }
}
