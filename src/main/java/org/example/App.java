package org.example;

/*
 *  UCF COP3330 Fall 2021 Assignment 1 Solution
 *  Copyright 2021 John Slauter
 */

import java.util.Scanner;

public class App 
{

    public static void main( String[] args )
    {

        Scanner s = new Scanner(System.in);

        double principal, interest_rate, result;

        int num_years;

        String temp;

        System.out.print("Enter the principal: ");

        temp = s.nextLine();

        principal = String_to_double(temp);

        System.out.print("Enter the rate of interest: ");

        temp = s.nextLine();

        interest_rate = String_to_double(temp)/100;

        System.out.print("Enter the number of years: ");

        temp = s.nextLine();

        num_years = String_to_int(temp);

        result = principal*(1+interest_rate*num_years);

        System.out.print(String.format("After %d years at %f%%, the investment will be worth $%.2f.", num_years, interest_rate*100, result));

        s.close();

    }

    private static double ceiling(double num){

        int temp = (int)(num*100);

        if((num*1000)%(temp*10) > 0){

            return ((double)(temp+1))/100;

        }

        return ((double)temp)/100;

    }

    private static int String_to_int(String s){

        int res = 0;

        for(int i = 0; i < s.length(); i++){

            res += (s.charAt(i)-'0')*pow(10, s.length()-1-i);

        }

        return res;

    }

    private static double String_to_double(String s){

        int flag = 0, decimal_index = -1;

        double res = 0.0;

        for(int i = 0; i < s.length(); i++){

            if(s.charAt(i) == '.'){

                decimal_index = i;

            }

        }

        if(decimal_index == -1){

            return(String_to_int(s));

        }

        for(int i = 0; i < s.length(); i++){

            if(i == decimal_index){

                continue;

            }

            else if(i < decimal_index || decimal_index == -1) {

                res += (s.charAt(i) - '0') * pow(10, decimal_index-1-i);

            }

            else{

                res += (s.charAt(i) - '0') * pow(10, -1*(i-decimal_index));

            }


        }

        return res;

    }

    private static double pow(int base, int exponent){

        if(exponent < 0){

            return pow_negative_exponent(base, -1*exponent);

        }

        int res = 1;

        for(int i = 0; i < exponent; i++){

            res *= base;

        }

        return res;

    }

    private static double pow_negative_exponent(int base, int exponent){

        double res = 1;

        for(int i = 0; i < exponent; i++){

            res /= base;

        }

        return res;

    }

}
