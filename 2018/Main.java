package com.scholarfun;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        double price = 0;
        double time = 0;
        double accessoryPrice = 0;
        double beforeDiscount = 0;
        double tradeInAmount = 0;
        double cashback = 0;
        String model = "";

        System.out.println("Enter the model of car that you would like to purchase: ");
        model = scanner.nextLine();
        model = model.toLowerCase();

        // This is for the model and price

        if(!model.equals("hatchback") && !model.equals("saloon") && !model.equals("estate")){
            do{
                System.out.println("Sorry that car is not offered here. Please try again");
                System.out.println("Enter the model of car that you would like to purchase: ");
                model = scanner.nextLine();
            }while (!model.equals("hatchback") && !model.equals("saloon") && !model.equals("estate"));
        }

        else {
            if (model.equals("hatchback")) {
                price += 535000;
            } else if (model.equals("saloon")) {
                price += 495000;
            } else if (model.equals("estate")) {
                price += 625000;
            } else {
                System.out.println("This type of car is not offered here. Please restart the program.");
                System.exit(-1);
            }
        }

        System.out.println("Enter the features you want(separate by commas, spelling sensitive): ");
        String addOns = scanner.nextLine();
        addOns = addOns.toLowerCase();

        String[] addOn = addOns.split(",");

        String keywords_str = "luxury satellite parking bluetooth sound";
        for(int i = 0; i < addOn.length; i++){
            if (!keywords_str.contains(addOn[i])) {
                //don't proceed
            }
            else{
                //proceed

            }
        }

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

        if (!tradeIn.contains("no") && !tradeIn.contains("yes")){
            do {
                System.out.print("Sorry that command is not understood. Please answer with only yes or no.");
                System.out.print("Are you exchanging your old car? ");
                tradeIn = scanner.nextLine();
                tradeIn = tradeIn.toLowerCase();
            }while (!tradeIn.contains("no") && !tradeIn.contains("yes"));
        }
        else {
            if (tradeIn.equals("yes")) {
                System.out.println("How much is offered for the car?");
                tradeInAmount = scanner.nextInt();
                price = price - tradeInAmount;
            } else if (tradeIn.equals("no")) {
                price *= 0.95;
            } else {
                System.out.print("Sorry that command is not understood. Please answer with only yes or no.");
            }
        }

        System.out.print("Are you a returning customer?");
        String returningCustomer = scanner.nextLine();
        returningCustomer = returningCustomer.toLowerCase();

        if (!returningCustomer.contains("yes") && !returningCustomer.contains("no")) {
            do {
                System.out.println("That command is not recognised. Please answer with only yes or no.");
                System.out.print("Are you a returning customer?");
                returningCustomer = scanner.nextLine();
                returningCustomer = returningCustomer.toLowerCase();
            } while (!returningCustomer.contains("yes") && !returningCustomer.contains("no"));
        } else {

            if (returningCustomer.contains("yes")) {
                price *= 0.90;
            } else if (returningCustomer.contains("no")) {
                // do nothing
            } else {
                System.out.println("That command is not recognised. Please answer with only yes or no.");
            }
        }

        System.out.println("The final breakdown is as follows:");
        System.out.println("Price of car without discounts: " + beforeDiscount);
        System.out.println("The trade in, if any is valued at: " + tradeInAmount);
        System.out.println("Final price after all applied discounts is: " + price);

        System.out.println("Do you require the EMI option?");
        String decision = scanner.nextLine();
        decision = decision.toLowerCase();

        if (!decision.contains("yes") && !decision.contains("no")){
            do {
                System.out.println("Do you require the EMI option?");
                decision = scanner.nextLine();
                decision = decision.toLowerCase();
            }while (!decision.contains("yes") && !decision.contains("no"));
        }
        else {
            if (decision.contains("yes")) {
                System.out.println("What time period works for you?");
                time = scanner.nextInt();
                if (time != 4 && time != 7){
                    do {
                        System.out.println("Sorry that financing option is not available here");
                        System.out.println("What time period works for you?");
                        time = scanner.nextInt();
                    }while (time != 4 && time != 7);
                }
                else {
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
                }

            } else if (decision.contains("no")) {
                System.out.println("Thank you for choosing to buy with us! Please give us a moment as we calculate your final price");
                Thread.sleep(1000);
                cashback = price * 0.01;
                System.out.println("The cashback obtained is: " + cashback);
                System.out.println("Final price is: " + (price * 0.99));

                System.out.println("Would you like to take cashback or would you like your accessories to come free?");
                String decision1 = scanner.nextLine();
                decision1 = decision1.toLowerCase();

                if (!decision1.contains("cashback") && !decision1.contains("accessories")){
                    do {
                        System.out.println("That is not one of the options. Please choose between Cashback and the Accessories");
                        System.out.println("Would you like to take cashback or would you like your accessories to come free?");
                        decision1 = scanner.nextLine();
                        decision1 = decision1.toLowerCase();
                    }while (!decision1.contains("cashback") && !decision1.contains("accessories"));
                }

                if (decision1.contains("cashback")) {
                    price = price - cashback;
                } else if (decision1.contains("accessories")) {
                    price -= accessoryPrice;
                }
            } else {
                System.out.println("We're sorry :(, something went wrong. Please try again");
            }
        }
        System.out.println("Final price is: " + price);
    }
}