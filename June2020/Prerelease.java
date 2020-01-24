package com.scholarfun;

import java.util.*;

public class Prerelease {
    public static void main(String[] args) {
        //Declare scanner
        Scanner read = new Scanner(System.in);

        //Declare and initialize variables
        final double priceAfter16 = 2;
        final double priceSun = 2;
        final double priceSat = 3;
        final double priceOthers = 10;
        char dayOver = 'n';
        double dailyTotal = 0;

        //Get the day and validate
        System.out.println("Enter the day");
        String day = read.next().toLowerCase();
        while (!(day.equals("sunday")) && !(day.equals("monday")) && !(day.equals("tuesday")) && !(day.equals("wednesday")) && !(day.equals("thursday")) && !(day.equals("friday")) && !(day.equals("saturday"))) {
            System.out.println("Invalid entry: Enter either Sunday, Monday, Tuesday, Wednesday, Thursday, Friday or Saturday");
            day = read.next();
        }

        //As long as the day is not over
        while (dayOver != 'y') {
            //Variables to be reset each time a new user is interacting
            double pricePH = 0;
            double discount = 1;
            double totalPrice;

            //Get the current time and validate
            System.out.println("Enter the time");
            int time = Integer.parseInt(read.next().substring(0, 2));
            while (time < 8 || time > 23) {
                System.out.println("Invalid entry: Enter times from 8 to 23 only");
                time = Integer.parseInt(read.next().substring(0, 2));
            }

            //Get the length of the stay and validate for Saturday, Sunday and the other days combined
            System.out.println("Enter the number of hours which the car will be left for");
            double hours = read.nextInt();
            if (time < 16) {
                if (day.equals("sunday")) {
                    while (hours < 1 || hours > 8) {
                        System.out.println("Invalid entry: Enter number of hours from 1 to 8 only");
                        hours = Integer.parseInt(read.next().substring(0, 1));
                    }
                    pricePH = priceSun;
                } else if (day.equals("saturday")) {
                    while (hours < 1 || hours > 4) {
                        System.out.println("Invalid entry: Enter number of hours from 1 to 4 only");
                        hours = Integer.parseInt(read.next().substring(0, 1));
                    }
                    pricePH = priceSat;
                } else {
                    while (hours < 1 || hours > 2) {
                        System.out.println("Invalid entry: Enter number of hours as either 1 or 2 only");
                        hours = Integer.parseInt(read.next().substring(0, 1));
                    }
                    pricePH = priceOthers;
                }
            } else {
                while (hours < 1 || (time + hours) > 24) {
                    System.out.println("Invalid entry: Enter number of hours from 1 to " + (24 - time) + " only");
                    hours = Integer.parseInt(read.next().substring(0, 1));
                }
            }

            //Get the frequent parking number and validate
            System.out.println("Do you have a frequent parking number? Enter 'y' for yes and 'n' for no");
            char des = read.next().charAt(0);
            while (des != 'y' && des != 'n') {
                System.out.println("Invalid entry: Enter 'y' for yes and 'n' for no");
                des = read.next().charAt(0);
            }
            while (des == 'y') {
                System.out.println("Enter your frequent parking number");
                int freq = read.nextInt();
                if (freq < 10000 || freq > 99999) {         //length check
                    System.out.println("Invalid entry: Enter 'y' to try again. Enter 'n' to skip");
                    des = read.next().charAt(0);
                    while (des != 'y' && des != 'n') {
                        System.out.println("Invalid entry: Enter 'y' to try again. Enter 'n' to skip");
                        des = read.next().charAt(0);
                    }
                } else {        //Modulo 11 checksum
                    String freq2 = String.valueOf(freq);
                    int[] num = new int[freq2.length()];
                    for (int i = 0; i < freq2.length(); i++) {
                        num[i] = freq2.charAt(i) - '0';
                    }
                    boolean correct = (num[0] + num[2] + num[4] + (3 * (num[1] + num[3]))) % 11 == 0;  //Checksum boolean
                    if (correct) {
                        des = 'n';
                        if (time < 16) {
                            discount = 0.9;
                        } else {
                            discount = 0.5;
                        }
                    } else {
                        System.out.println("Invalid entry: Enter 'y' to try again. Enter 'n' to skip");
                        des = read.next().charAt(0);
                        while (des != 'y' && des != 'n') {
                            System.out.println("Invalid entry: Enter 'y' to try again. Enter 'n' to skip");
                            des = read.next().charAt(0);
                        }
                    }
                }
            }

            //Calculate final prices
            if (time < 16 && (time + hours) >= 16) {
                totalPrice = ((pricePH * (16 - time)) + priceAfter16) * discount;
            } else if (time < 16) {
                totalPrice = (pricePH * hours) * discount;
            } else {
                totalPrice = priceAfter16 * discount;
            }

            //Output final price
            System.out.println("the total price to park is " + totalPrice);

            //Take payment from user. No change given back
            System.out.println("\nEnter payment amount");
            double payment = read.nextDouble();
            while (payment < totalPrice) {
                System.out.println("Payment unsuccessful: Enter an amount greater than or equal to the price displayed");
                payment = read.nextDouble();
            }
            dailyTotal += payment;

            //Check if the day is over or if there are more values to be input
            System.out.println("is it the end of the day? Enter 'y' for yes and 'n' for no");
            dayOver = read.next().charAt(0);
            while (dayOver != 'y' && dayOver != 'n') {
                System.out.println("Invalid entry: Enter 'y' for yes and 'n' for no");
                dayOver = read.next().charAt(0);
            }
        }

        //Print out the final total once the day has finished
        System.out.println("The daily total is " + dailyTotal + "\n\n");
    }
}
