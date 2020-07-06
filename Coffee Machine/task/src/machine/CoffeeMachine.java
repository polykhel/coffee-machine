package machine;

import java.util.Scanner;

public class CoffeeMachine {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CoffeeMaker coffeeMaker = new CoffeeMaker();
        CoffeeMachineState state = CoffeeMachineState.CHOOSE_ACTION;

        while (true) {
            if (state == CoffeeMachineState.CHOOSE_ACTION) {
                System.out.println("Write action (buy, fill, take, remaining, exit):");
                String action = scanner.nextLine();

                if ("buy".equals(action)) {
                    state = CoffeeMachineState.CHOOSE_COFFEE;
                } else if ("fill".equals(action)) {
                    state = CoffeeMachineState.FILL;
                } else if ("take".equals(action)) {
                    coffeeMaker.takeMoney();
                } else if ("remaining".equals(action)) {
                    coffeeMaker.printRemaining();
                } else if ("exit".equals(action)) {
                    break;
                }
            } else if (state == CoffeeMachineState.CHOOSE_COFFEE) {
                System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino");
                String type = scanner.nextLine();
                coffeeMaker.buy(Integer.parseInt(type));
                state = CoffeeMachineState.CHOOSE_ACTION;
            } else if (state == CoffeeMachineState.FILL) {
                System.out.println("Write how many ml of water do you want to add:");
                int waterToFill = scanner.nextInt();
                System.out.println("Write how many ml of milk do you want to add:");
                int milkToFill = scanner.nextInt();
                System.out.println("Write how many grams of coffee beans do you want to add:");
                int coffeeToFill = scanner.nextInt();
                System.out.println("Write how many disposable cups of coffee do you want to add:");
                int cupsToFill = scanner.nextInt();
                coffeeMaker.fill(waterToFill, milkToFill, coffeeToFill, cupsToFill);
                state = CoffeeMachineState.CHOOSE_ACTION;
            }
        }
    }
}

class CoffeeMaker {
    private int water;
    private int milk;
    private int coffee;
    private int cups;
    private int money;

    CoffeeMaker() {
        this.water = 400;
        this.milk = 540;
        this.coffee = 120;
        this.cups = 0;
        this.money = 550;
    }

    public void buy(int type) {
        switch (type) {
            case 1:
                makeCoffee(250, 0, 16, 4);
                break;
            case 2:
                makeCoffee(350, 75, 20, 7);
                break;
            case 3:
                makeCoffee(200, 100, 12, 6);
                break;
        }
    }

    public void makeCoffee(int waterNeeded, int milkNeeded, int coffeeNeeded, int cost) {
        if (water - waterNeeded < 0) {
            System.out.println("Sorry, not enough water!");
        } else if (milk - milkNeeded < 0) {
            System.out.println("Sorry, not enough milk!");
        } else if (coffee - coffeeNeeded < 0) {
            System.out.println("Sorry, not enough coffee!");
        } else if (cups <= 0) {
            System.out.println("Sorry, not enough cups!");
        } else {
            water -= waterNeeded;
            milk -= milkNeeded;
            coffee -= coffeeNeeded;
            cups--;
            money += cost;
            System.out.println("I have enough resources, making you a coffee!");
        }
    }

    public void fill(int water, int milk, int coffee, int cups) {
        this.water += water;
        this.milk += milk;
        this.coffee += coffee;
        this.cups += cups;
    }

    public void takeMoney() {
        System.out.println("I gave you $" + money);
        money = 0;
    }

    public void printRemaining() {
        System.out.println("The coffee machine has:");
        System.out.println(water + " of water");
        System.out.println(milk + " of milk");
        System.out.println(coffee + " of coffee beans");
        System.out.println(cups + " of disposable cups");
        System.out.println(money + " of money");
    }
}

enum CoffeeMachineState {
    CHOOSE_ACTION, CHOOSE_COFFEE, FILL
}
