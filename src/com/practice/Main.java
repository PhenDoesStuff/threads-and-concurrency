package com.practice;

public class Main {

    public static void main(String[] args) {
        System.out.println(ThreadColor.ANSI_PURPLE + "Hello from the main thread.");

        // Initialize a new thread using the class that I created.
        Thread anotherThread = new AnotherThread();

        // Use the start() method to run the other thread.
        anotherThread.start();

        // Can create a new thread using an anonymous class
        new Thread() {
            public void run() {
                System.out.println(ThreadColor.ANSI_GREEN + "Hello from the anonymous thread!");
            }
        }.start();

        System.out.println(ThreadColor.ANSI_PURPLE + "Hello again from the main thread.");

    }
}
