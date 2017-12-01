package com.danielstone.alevels;


public class Cipher {

    public static void main(String[] args) {
        String input = "lfgq gq yl cvacjjclr agnfcp";
        String output = "";
        int key = 24;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == ' ') output += ' ';
            else output += (char) (Math.abs(((input.charAt(i) - 'a') + key) % 26) + 'a');
        }
        System.out.println(output);
    }
}


