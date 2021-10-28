package com.company;

import java.util.*;

public class AutumnCocktails {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        ArrayDeque<Integer> ingredients = new ArrayDeque<>();
        ArrayDeque<Integer> freshness = new ArrayDeque<>();

        String[] ing = scan.nextLine().split(" ");
        String[] fre = scan.nextLine().split(" ");

        for (int i = 0; i < ing.length; i++) {
            ingredients.offer(Integer.parseInt(ing[i]));
        }

        for (int i = 0; i < fre.length; i++) {
            freshness.push(Integer.parseInt(fre[i]));
        }

        int pearSour = 0;
        int theHarvest = 0;
        int appleHinny = 0;
        int highFashion = 0;

        Map<String, Integer> cocktails = new TreeMap<>();

        while (!ingredients.isEmpty() && !freshness.isEmpty()) {

            int ingredient = ingredients.peek();
            int fresh = freshness.peek();

            if (ingredient == 0) {
                ingredients.poll();
                continue;
            }

            if (ingredient * fresh == 150) {
                pearSour++;
                ingredients.poll();
                freshness.pop();
                cocktails.put("Pear Sour", pearSour);
            } else if (ingredient * fresh == 250) {
                theHarvest++;
                ingredients.poll();
                freshness.pop();
                cocktails.put("The Harvest", theHarvest);
            } else if (ingredient * fresh == 300) {
                appleHinny++;
                ingredients.poll();
                freshness.pop();
                cocktails.put("Apple Hinny", appleHinny);
            } else if (ingredient * fresh == 400) {
                highFashion++;
                ingredients.poll();
                freshness.pop();
                cocktails.put("High Fashion", highFashion);
            } else {
                freshness.pop();
                int toIncrease = ingredients.poll();
                ingredients.offer(toIncrease + 5);
            }

        }

        int sum = 0;

        if (!ingredients.isEmpty()) {
            for (Integer ingredient : ingredients) {
                sum = sum + ingredient;
            }
        }


        if (pearSour != 0 && theHarvest != 0 && appleHinny != 0 && highFashion !=0) {
            System.out.println("It's party time! The cocktails are ready!");
            if (sum != 0) {
                System.out.println("Ingredients left: " + sum);
            }

           for (Map.Entry<String, Integer> cocktail : cocktails.entrySet()) {
               System.out.printf(" # %s --> %d%n", cocktail.getKey(), cocktail.getValue());
           }
        }

        else {
            System.out.println("What a pity! You didn't manage to prepare all cocktails.");
            if (sum != 0) {
                System.out.println("Ingredients left: " + sum);
            }

            for (Map.Entry<String, Integer> cocktail : cocktails.entrySet()) {
                System.out.printf(" # %s --> %d%n", cocktail.getKey(), cocktail.getValue());
            }
        }

    }
}
