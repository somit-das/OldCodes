package com.example;

public class Car {
	private Engine engine;

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public void start() {
        System.out.println("Car is starting with " + engine);
    }
}
