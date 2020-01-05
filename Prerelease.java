package com.scholarfun;

import java.util.*;

public class Prerelease {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        final double priceAfter16 = 2;
        final double priceSun = 2;
        final double priceSat = 3;
        final double priceOthers = 10;
        char dayOver = 'n';
        double totalDailyPayment = 0;
        System.out.println("Enter the day");
        String day = read.next();
        while (!(day.equals("Sunday")) && !(day.equals("Monday")) && !(day.equals("Tuesday")) && !(day.equals("Wednesday")) && !(day.equals("Thursday")) && !(day.equals("Friday")) && !(day.equals("Saturday"))) {
            System.out.println("Invalid entry: Enter either Sunday, Monday, Tuesday, Wednesday, Thursday, Friday or Saturday");
            day = read.next();
        }
        while (dayOver != 'y') {
            double pricePH = 0;
            double discount = 1;
            double totalPrice = 0;
            System.out.println("Enter the time");
            int time = read.nextInt();
            while (time < 8 || time > 23) {
                System.out.println("Invalid entry: Enter times from 8 to 23 only");
                time = read.nextInt();
            }
            System.out.println("Enter the number of hours which the car will be left for");
            double hours = read.nextInt();
            if (time < 16) {
                if (day.equals("Sunday")) {
                    while (hours < 1 || hours > 8) {
                        System.out.println("Invalid entry: Enter number of hours from 1 to 8 only");
                        hours = read.nextInt();
                    }
                    pricePH = priceSun;
                } else if (day.equals("Saturday")) {
                    while (hours < 1 || hours > 4) {
                        System.out.println("Invalid entry: Enter number of hours from 1 to 4 only");
                        hours = read.nextInt();
                    }
                    pricePH = priceSat;
                } else {
                    while (hours < 1 || hours > 2) {
                        System.out.println("Invalid entry: Enter number of hours as either 1 or 2 only");
                        hours = read.nextInt();
                    }
                    pricePH = priceOthers;
                }
            } else {
                while (hours < 1 || (time + hours) > 23) {
                    System.out.println("Invalid entry: Enter nuber of hours from 1 to " + (23 - time) + " only");
                    hours = read.nextInt();
                }
            }
            System.out.println("Do you have a frequent parking number? Enter 'y' for yes and 'n' for no");
            char des = read.next().charAt(0);
            while (des != 'y' && des != 'n') {
                System.out.println("Invalid entry: Enter 'y' for yes and 'n' for no");
                des = read.next().charAt(0);
            }
            while (des == 'y') {
                System.out.println("Enter your frequent parking number");
                int freq = read.nextInt();
                if (freq < 10000 || freq > 99999) {
                    System.out.println("Invalid entry: Enter 'y' to try again. Enter 'n' to skip");
                    des = read.next().charAt(0);
                    while (des != 'y' && des != 'n') {
                        System.out.println("Invalid entry: Enter 'y' to try again. Enter 'n' to skip");
                        des = read.next().charAt(0);
                    }
                } else {
                    String freq2 = String.valueOf(freq);
                    int[] num = new int[freq2.length()];
                    for (int i = 0; i < freq2.length(); i++) {
                        num[i] = freq2.charAt(i) - '0';
                    }
                    boolean correct = (num[0] + num[2] + num[4] + (3 * (num[1] + num[3]))) % 11 == 0;
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
            if (time < 16 && (time + hours) >= 16) {
                totalPrice = ((pricePH * (16 - time)) + priceAfter16) * discount;
            } else if (time < 16) {
                totalPrice = (pricePH * hours) * discount;
            } else {
                totalPrice = priceAfter16 * discount;
            }
            System.out.println("the total price to park is " + totalPrice);
            System.out.println("\nEnter payment amount");
            double payment = read.nextDouble();
            while (payment < totalPrice) {
                System.out.println("Payment unsuccessful: Enter an amount greater than or equal to the price displayed");
                payment = read.nextDouble();
            }
            totalDailyPayment += payment;
            System.out.println("is it the end of the day? Enter 'y' for yes and 'n' for no");
            dayOver = read.next().charAt(0);
            while (dayOver != 'y' && dayOver != 'n') {
                System.out.println("Invalid entry: Enter 'y' for yes and 'n' for no");
                dayOver = read.next().charAt(0);
            }
        }
        System.out.println("The Total Daily Payment is " + totalDailyPayment + "\n\n");
    }
}
