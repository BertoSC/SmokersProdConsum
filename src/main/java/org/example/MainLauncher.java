package org.example;

public class MainLauncher {
    public static void main(String[] args) {
        TableShop ts = new TableShop();
        TobaccoSeller seller = new TobaccoSeller(ts);
        Smoker smoke1 = new Smoker("tobacco", ts);
        Smoker smoke2 = new Smoker("paper", ts);
        Smoker smoke3 = new Smoker("matches", ts);

        Thread sel = new Thread(seller);
        Thread sm1 = new Thread(smoke1);
        Thread sm2 = new Thread(smoke2);
        Thread sm3 = new Thread(smoke3);

        sel.start();
        sm1.start();
        sm2.start();
        sm3.start();

        try {
            sel.join();
            sm1.join();
            sm2.join();
            sm3.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}