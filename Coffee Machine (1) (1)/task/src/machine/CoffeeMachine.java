package machine;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class CoffeeMachine {
    private int countWater = 400;
    private int countMilk = 540;
    private int countCoffeeBeans = 120;
    private int disposableCups = 9;
    private int countMoney = 550;

    public boolean isExit = false;
    public Condition status = Condition.INFO;

    protected void inputStringData(String inputString) {
        switch (status) {
            case CHOOSE_ACTION:
                userAction(inputString);
                break;
            case WANT_BUY:
                buy(inputString);
                break;
            default:
                fill(inputString);
                break;

        }
    }
    public static void main(String[] args) throws IOException{

        UserInput newUserInput = new UserInput();
        newUserInput.userRun();

    }

    private void userAction(String action) {

        switch (action) {
            case "buy":
                System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino: ");
                status = Condition.WANT_BUY;
                break;
            case "fill":
                System.out.println("Write how many ml of water do you want to add: ");
                status = Condition.HOW_MUCH_WATER;
                break;
            case "take":
                take();
                status = Condition.INFO;
                break;
            case "remaining":
                infoCoffeeMachine();
                status = Condition.INFO;
                break;
            case "exit":
                isExit = true;
                break;
        }
    }

    private void buy(String s) {
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
        status = Condition.INFO;
    }

    private void doCappuccino() {
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

    private void doLatte() {
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

    private void doEspresso() {
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

    private void take() {
        System.out.println("I gave you $" + countMoney);
        countMoney = 0;
    }

    private void fill(String s) {
        if (status == Condition.HOW_MUCH_WATER) {

            countWater += Integer.parseInt(s);
            status = Condition.HOW_MUCH_MILK;
            System.out.println("Write how many ml of milk do you want to add: ");
            return;
        }
        if (status == Condition.HOW_MUCH_MILK) {

            countMilk += Integer.parseInt(s);
            status = Condition.HOW_MUCH_COFFEE;
            System.out.println("Write how many grams of coffee beans do you want to add: ");
            return;
        }
        if (status == Condition.HOW_MUCH_COFFEE) {

            countCoffeeBeans += Integer.parseInt(s);
            status = Condition.HOW_MANY_CUPS;
            System.out.println("Write how many disposable cups of coffee do you want to add: ");
            return;
        }
        if (status == Condition.HOW_MANY_CUPS) {

            disposableCups += Integer.parseInt(s);
            status = Condition.INFO;
        }

    }

    private void infoCoffeeMachine() {
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
