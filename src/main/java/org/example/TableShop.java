package org.example;

import java.util.ArrayList;
import java.util.List;

public class TableShop {
    List<String> ingredientsOnTable = new ArrayList<>();
    List <String> totalIngredients = List.of("tobacco", "paper", "matches");


    public synchronized void placeIngredient(String element1, String element2) throws InterruptedException {
        while (!ingredientsOnTable.isEmpty()) {
            wait();
        }
        ingredientsOnTable.add(element1);
        ingredientsOnTable.add(element2);
        System.out.println("The TobaccoSeller adds " + element1 + " and " + element2 + " to the shop table");
        notifyAll();
    }

    public synchronized void takeIngredient(String smokerElement) throws InterruptedException {
        while (ingredientsOnTable.isEmpty() || ingredientsOnTable.contains(smokerElement)) {
            StringBuilder sb = new StringBuilder();
            String remaining="";
            for (String s: totalIngredients){
                if (!s.equals(smokerElement)){
                    sb.append(s).append(" ");
                }
                remaining = sb.toString().trim();
            }
            System.out.println("The smoker with "+smokerElement+ " is waiting for : "+remaining);
            wait();
        }

        System.out.println("The smoker with " + smokerElement + " takes the ingredients: " + ingredientsOnTable);
        ingredientsOnTable.clear();
        notifyAll();
    }
}
