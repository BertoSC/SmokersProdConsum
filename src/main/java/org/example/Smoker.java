package org.example;

import java.util.concurrent.TimeUnit;

public class Smoker implements Runnable{
    String ingredient;
    TableShop table;

    public Smoker (String ing, TableShop tab){
        this.ingredient=ing;
        this.table=tab;
    }
    @Override
    public void run() {
         while (true){
             try {
                 table.takeIngredient(ingredient);
                 System.out.println("The smoker with "+ingredient+" begins to smoke");
                 Thread.sleep(1000);
                 System.out.println("The smoker with "+ingredient+ "finished smoking");
             } catch (InterruptedException e) {
                 throw new RuntimeException(e);
             }
         }
    }
}
