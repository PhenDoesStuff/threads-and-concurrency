package com.practice;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello from the main thread.");

        // Initialize a new thread using the class that I created.
        Thread anotherThread = new AnotherThread();

        // Use the start() method to run the other thread.
        anotherThread.start();

        // Can create a new thread using an anonymous class
        new Thread() {
            public void run() {
                System.out.println("Hello from the anonymous thread!");
            }
        }.start();

        System.out.println("Hello again from the main thread.");

    }
}
