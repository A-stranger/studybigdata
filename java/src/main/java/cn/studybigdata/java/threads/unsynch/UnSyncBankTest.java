package cn.studybigdata.java.threads.unsynch;

import cn.studybigdata.java.threads.Bank;

public class UnSyncBankTest {

    public static final int NACCOUNTS = 100;
    public static final double INITIAL_BALANCE = 1000;
    public static final double MAX_AMOUNT = 1000;
    public static final int DELAY = 10;

    public static void main(String[] args) {
        Bank bank = new Bank(100, INITIAL_BALANCE);

        for (int i = 0; i < NACCOUNTS; i++) {

            int fromAccount = i;

            Runnable task = () -> {

                while (true) {
                    int toAccount = (int) (bank.size() * Math.random());
                    double amount = MAX_AMOUNT * Math.random();
                    bank.transfer(fromAccount, toAccount, amount);
                    try {
                        Thread.sleep((int) (DELAY * Math.random()));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            };
            new Thread(task).start();
        }

    }
}
