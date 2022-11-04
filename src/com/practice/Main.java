package com.practice;

import com.threadcolor.ThreadColor;

public class Main {

    public static void main(String[] args) {
        System.out.println(ThreadColor.ANSI_PURPLE + "Hello from the main thread.");

        // Initialize a new thread using the class that I created.
        Thread anotherThread = new AnotherThread();
        anotherThread.setName("== Another Thread ==");
        // Use the start() method to run the other thread.
        anotherThread.start(); // This prints out "Hello from == Another Thread =="

        // Example of how .run() doesn't use the other thread.
//        anotherThread.run(); // This prints out "Hello from main"
        // Calls method in other class, but doesn't use a new thread

        // Can create a new thread using an anonymous class
        new Thread() {
            public void run() {
                System.out.println(ThreadColor.ANSI_GREEN + "Hello from the anonymous thread!");
            }
        }.start();

        Thread myRunnableThread = new Thread(new MyRunnable() {
            @Override
            public void run() {
                System.out.println(ThreadColor.ANSI_RED + "Hello from the anonymous class' implementation of run().");
                try {
                    anotherThread.join();
                    System.out.println(ThreadColor.ANSI_RED + "anotherThread terminated, or timed out, so I am running again.");
                } catch (InterruptedException e) {
                    System.out.println(ThreadColor.ANSI_RED + "I couldn't wait after all. I was interrupted.");
                }
            }
        });

        myRunnableThread.start();

        System.out.println(ThreadColor.ANSI_PURPLE + "Hello again from the main thread.");

    }
}
