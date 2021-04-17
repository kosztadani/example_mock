package dev.kosztadani.examples.mock.handwritten;

import dev.kosztadani.examples.mock.api.Heater;

public class MockHeater implements Heater {

    private int callCounter = 0;

    @Override
    public void heat() {
        callCounter++;
    }

    public int getCallCounter() {
        return callCounter;
    }
}
