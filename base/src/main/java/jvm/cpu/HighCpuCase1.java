package jvm.cpu;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class HighCpuCase1 {

    private static Executor executor = Executors.newFixedThreadPool(60);

    public final static Object lock = new Object();



    public static void main(String[] args) {



        for (int i = 0 ; i < 30 ; i++){
            Task a = new Task();
            executor.execute(a);
        }
    }


    static class Task implements Runnable{

        @Override
        public void run() {
            synchronized (lock){
                calculate();
            }
        }

        public void calculate(){
            int i = 0;
            while(true){
                i++;
            }
        }
    }









}
