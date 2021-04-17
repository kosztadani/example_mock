package dev.kosztadani.examples.mock.handwritten;

import dev.kosztadani.examples.mock.api.Sensor;

import java.util.Arrays;
import java.util.Iterator;

public class MockSensor implements Sensor {

    private int callCounter = 0;
    private Iterator<Integer> values;

    @Override
    public int sense() {
        if (values.hasNext()) {
            callCounter++;
            return values.next();
        } else {
            throw new RuntimeException("MockSensor called too many times.");
        }
    }

    public void setValues(int... values) {
        this.values = Arrays.stream(values).iterator();
    }

    public int getCallCounter() {
        return callCounter;
    }
}
