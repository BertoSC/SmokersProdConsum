package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TobaccoSeller implements Runnable{
    TableShop table;
    List<String> totalIngredients = new ArrayList<>();

    public TobaccoSeller(TableShop tb){
        this.table=tb;
        totalIngredients.add("tobacco");
        totalIngredients.add("paper");
        totalIngredients.add("matches");
    }
    @Override
    public void run() {
        while (true) {
            Collections.shuffle(totalIngredients);
            try {
                table.placeIngredient(totalIngredients.get(0), totalIngredients.get(1));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
