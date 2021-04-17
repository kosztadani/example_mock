package dev.kosztadani.examples.mock.handwritten;

import dev.kosztadani.examples.mock.api.Cooler;

public class MockCooler implements Cooler {

    private int callCounter = 0;

    @Override
    public void cool() {
        callCounter++;
    }

    public int getCallCounter() {
        return callCounter;
    }
}
