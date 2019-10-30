package com.scholarfun;

import java.text.DecimalFormat;
import java.util.Scanner;

public class OctNov2019 {
    private static DecimalFormat df = new DecimalFormat("0.00");

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double priceMultiplier = 0;
        double depth = 0;
        double size = 0;
        double price = 0;
        double radius = 0;
        double finalVolume = 0;
        double priceVolume = 0;
        String color = "";

        // The main part of the program, used by all three tasks
        System.out.println("Serial| Slab Color   | Slab Depth  | Size and Shape  |");
        System.out.println("1     | Grey         | 38mm        | 600x600[Square] |");
        System.out.println("2     | Red          | 45mm        | 450x450[Square] |");
        System.out.println("3     | Green        | N/A         | 600x700[Rect]   |");
        System.out.println("4     | Custom       | N/A         | 600x450[Rect]   |");
        System.out.println("5     | N/A          | N/A         | Diameter 300    |");
        System.out.println("6     | N/A          | N/A         | Diameter 450    |");

        System.out.println("Which combination would you like(Separate characteristics by commas): ");
        String param = scanner.nextLine();
        param = param.toLowerCase();

        String[] params = param.split(",");
        // Task 1 Starts here
        //use params[0] and determining the color
        String param1 = params[0];

        if (param1.contains("1")) {
            priceMultiplier = 0.05;
            color = "Grey";
        } else if (param1.contains("2")) {
            priceMultiplier = 0.05 * 0.1;
            color = "Red";
        } else if (param1.contains("3")) {
            priceMultiplier = 0.05 * 0.1;
            color = "Green";
        } else if (param1.contains("4")) {
            priceMultiplier = 0.05 * 0.15;
            price = 5;
            color = "Custom Color option";
        } else {
            System.out.println("Sorry that is not an option. Please consult the chart again");
            System.exit(-1);
        }

        //use params[1] and determining the depth
        String param2 = params[1];
        if (param2.contains("1")) {
            depth = 38;
        } else if (param2.contains("2")) {
            depth = 45;
        } else {
            System.out.println("Sorry that is not an option. Please consult the chart again");
            System.exit(-1);
        }

        //use params[2] and determining the dimentions
        String param3 = params[2];

        if (param3.contains("1")) {
            size = 600 * 600;
        } else if (param3.contains("2")) {
            size = 450 * 450;
        } else if (param3.contains("3")) {
            size = 600 * 700;
        } else if (param3.contains("4")) {
            size = 600 * 450;
        } else if (param3.contains("5")) {
            size = 0.25 * ((22 / 7) * (300 * 300));
            radius = 150;
        } else if (param3.contains("6")) {
            size = 0.25 * ((22 / 7) * (450 * 450));
            radius = 225;
        } else {
            System.out.println("Sorry that is not an option. Please consult the chart again");
            System.exit(-1);
        }

        finalVolume = depth * size;
        priceVolume = finalVolume / 100000;
        price = priceMultiplier * priceVolume;
        double testPrice = price * 20;


        System.out.println("The options selected are as follows: ");
        System.out.println("The color is: " + color);
        System.out.println("The depth of the block is: " + depth);
        System.out.println("The volume of a unit block is: " + finalVolume);
        System.out.println("The final price for 20 units is: " + df.format(testPrice) + " $");

        // Task 2 begins here
        System.out.println("How many slabs would you like to purchase? ");
        int numberOfSlabs = scanner.nextInt();
        do {
            System.out.println("Sorry that order quantity does not work. Please retry");
            System.out.println("How many slabs would you like to purchase? ");
            numberOfSlabs = scanner.nextInt();
        } while (numberOfSlabs > 100 || numberOfSlabs < 20);

        double finalPrice = price * numberOfSlabs;
        System.out.println("The final price for " + numberOfSlabs + " units is: " + df.format(finalPrice) + " $");

        //Task 3 begins here
        System.out.println("Would you like to purchase basic or best quality blocks? ");
        String quality = scanner.next();
        quality = quality.toLowerCase();

        do {
            System.out.println("Would you like to purchase basic or best quality blocks? ");
            quality = scanner.next();
            quality = quality.toLowerCase();
        }while (!quality.contains("basic") || !quality.contains("best"));

        if (quality.contains("basic")) {
            System.out.println("The final price for 20 units is: " + df.format(testPrice) + " $");
        } else if (quality.contains("best")) {
            System.out.println("The final price for 20 units is: " + df.format(testPrice * 0.07) + " $");
        } else {
            System.out.println("This option does not exist. Try checking your spelling");
        }

    }
}
