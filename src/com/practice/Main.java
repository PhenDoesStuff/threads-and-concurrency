package com.practice;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello from the main thread.");

        // Initialize a new thread using the class that I created.
        Thread anotherThread = new AnotherThread();

        // Use the start() method to run the other thread.
        anotherThread.start();

        System.out.println("Hello again from the main thread.");

        // This should throw an exception b/c threads can't be started more than once.
        anotherThread.start();
    }
}
