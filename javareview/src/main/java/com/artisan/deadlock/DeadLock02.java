package com.artisan.deadlock;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 小工匠
 * @version 1.0
 * @description: TODO
 * @date 2021/8/15 21:41
 * @mark: show me the code , change the world
 */
public class DeadLock02 {
    public static void main(String[] args) {
        Account a = new Account();
        Account b = new Account();
        a.transfer(b,100);
        b.transfer(a,200);
    }

    static class Allocator {
        private List<Object> als = new ArrayList<Object>();
        // 一次性申请所有资源
        synchronized boolean apply(Object from, Object to){
            if(als.contains(from) || als.contains(to)){
                return false;
            } else {
                als.add(from);
                als.add(to);
            }
            return true;
        }
        synchronized void clean(Object from, Object to){
            als.remove(from);
            als.remove(to);
        }
    }

    static class Account {
        private Allocator actr = DeadLock02.getInstance();
        private int balance;
        void transfer(Account target, int amt){
            while(!actr.apply(this, target));
            try{
                synchronized(this){
                    System.out.println(this.toString()+" lock obj1");
                    synchronized(target){
                        System.out.println(this.toString()+" lock obj2");
                        if (this.balance > amt){
                            this.balance -= amt;
                            target.balance += amt;
                        }
                    }
                }
            } finally {
                //执行完后，再释放持有的资源
                actr.clean(this, target);
            }
        }
    }

    private void Allocator(){};

    private static class SingleTonHoler{
        private static Allocator INSTANCE = new Allocator();
    }

    public static Allocator getInstance(){
        return SingleTonHoler.INSTANCE;
    }

}