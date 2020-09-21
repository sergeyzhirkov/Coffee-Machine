package machine;

import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Write how many ml of water the coffee machine has: ");
        int water = scanner.nextInt();
        System.out.println("Write how many ml of milk the coffee machine has: ");
        int milk = scanner.nextInt();
        System.out.println("Write how many grams of coffee beans the coffee machine has: ");
        int coffeeBeans = scanner.nextInt();
        System.out.println("Write how many cups of coffee you will need: ");
        int cupsCount = scanner.nextInt();

        water /= 200;
        milk /= 50;
        coffeeBeans /= 15;
        int maxCupsCount = Math.min(Math.min(water, milk), coffeeBeans);

        if (maxCupsCount < cupsCount) {
            System.out.printf("No, I can make only %d cup(s) of coffee", maxCupsCount);
        } else {
            System.out.print("Yes, I can make that amount of coffee ");
            if (maxCupsCount > cupsCount) {
                System.out.printf("(and even %d more than that)", maxCupsCount - cupsCount);
            }
        }

    }
}
