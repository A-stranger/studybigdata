package cn.studybigdata.java.threads;

import java.util.Arrays;

public class Bank {
    private final double[] accounts;

    public Bank(int n, Double initialBalance) {
        accounts = new double[n];
        Arrays.fill(accounts, initialBalance);
    }

    /**
     * 银行总存款
     * @return sum
     */
    public double getTotalBalance(){
        double sum = 0;
        for (double x: accounts){
            sum = sum + x;
        }
        return sum;
    }

    /**
     * 转账
     * @param from 转出账号
     * @param to 转入账号
     * @param amount 转账金额
     */
    public void transfer(int from, int to, double amount){
        if (accounts[from]<amount) return;//余额不足，无法转出

        System.out.println(Thread.currentThread());
        accounts[from] = accounts[from] - amount;
        System.out.printf("%10.2f from %d to %d", amount, from, to);
        accounts[to] = accounts[to] + amount;
        System.out.printf("总金额： %10.2f%n", getTotalBalance());
    }

    /**
     * 储户总数
     * @return 储户总数
     */
    public int size(){
        return accounts.length;
    }

}
