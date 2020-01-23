package com.scholarfun;

import java.util.Scanner;

public class PreRelease2020 {

    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        String model = scanner.nextLine();
        int price = 0;
        int time = 0;
        int accessoryPrice = 0;
        int beforeDiscount = 0;
        int tradeInAmount = 0;
        model = model.toLowerCase();

        // This is for the model and price

        if (model.equals("hatchback")){
            price += 535000;
        }
        else if(model.equals("saloon")){
            price += 495000;
        }
        else if(model.equals("estate")){
            price += 625000;
        }
        else{
            System.out.println("This type of car is not offered here. Please restart the program.");
            System.exit(-1);
        }

        System.out.println("Enter the features you want(separate by commas, spelling sensitive): ");
        String addOns = scanner.nextLine();
        addOns = addOns.toLowerCase();

        String[] addOn = addOns.split(",");

        for (int i = 0; i < addOn.length; i++){
            if (addOn[i].contains("luxury")){
                price = price + 45000;
            }
            else if (addOn[i].contains("satellite")){
                price = price + 5500;
            }
            else if (addOn[i].contains("parking")){
                price = price + 10000;
            }
            else if (addOn[i].contains("bluetooth")){
                price = price + 350;
            }
            else if (addOn[i].contains("sound")){
                price = price + 1000;
            }
            else{
                System.out.print("Sorry your entry was incorrectly spelled or is not one that is offered here. Please try again.");
            }
        }
        beforeDiscount = price;

        System.out.print("Are you exchanging your old car? ");
        String tradeIn = scanner.nextLine();
        tradeIn = tradeIn.toLowerCase();

        if (tradeIn.equals("yes")){
            System.out.println("How much is offered for the car?");
            tradeInAmount = scanner.nextInt();
            price = price - tradeInAmount;
        }
        else if (tradeIn.equals("no")){
            price *= 0.95;
        }
        else{
            System.out.print("Sorry that command is not understood. Please answer with only yes or no.");
        }

        System.out.print("Are you a returning customer?");
        String returningCustomer = scanner.nextLine();
        returningCustomer = returningCustomer.toLowerCase();

        if (returningCustomer.contains("yes")){
            price *= 0.90;
        }
        else if (returningCustomer.contains("no")){
            // do nothing
        }
        else{
            System.out.println("That command is not recognised. Please answer with only yes or no.");
        }

        System.out.println("The final breakdown is as follows:");
        System.out.println("Price of car without discounts: " + beforeDiscount);
        System.out.println("The trade in, if any is valued at: " + tradeInAmount);
        System.out.println("Final price after all applied discounts is: " + price);

        System.out.println("Do you require the EMI option?");
        String decision = scanner.nextLine();
        decision = decision.toLowerCase();



        if (decision.contains("yes")) {
            System.out.println("What time period works for you?");
            time = scanner.nextInt();

            if (time == 4) {
                System.out.println("Thank you for choosing to buy with us! Please give us a moment as we calculate your final price");
                Thread.sleep(1000);
                System.out.println("Your final price is: " + price);
                System.out.println("The amount to be paid is: " + (price / 48));
            } else if (time == 7) {
                System.out.println("Thank you for choosing to buy with us! Please give us a moment as we calculate your final price");
                Thread.sleep(1000);
                price *= 1.05;
                System.out.println("Your final price is: " + price);
                System.out.println("The amount to be paid per month is: " + (price / 84));
            } else {
                System.out.println("We're sorry but that financing option is unavailable. Please choose 7 years or 4 years.");
            }

        } else if (decision.contains("no")) {
            System.out.println("Thank you for choosing to buy with us! Please give us a moment as we calculate your final price");
            Thread.sleep(1000);
            System.out.println("The cashback obtained is: " + (price * 0.01));
            System.out.println("Final price is: " + (price * 0.99));

            System.out.println("Would you like to take cashback or would you like your accessories to come free?");
            String decision1 = scanner.nextLine();

            if (decision1.contains("cashback")) {
                price *= 0.99;
            } else if (decision1.contains("accessories")) {
                price -= accessoryPrice;
            }
        } else {
            System.out.println("We're sorry :(, something went wrong. Please try again");
        }
        System.out.println("Final price is: " + price);
    }
}
