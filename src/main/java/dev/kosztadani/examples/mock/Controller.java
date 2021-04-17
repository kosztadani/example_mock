package dev.kosztadani.examples.mock;

import dev.kosztadani.examples.mock.api.Cooler;
import dev.kosztadani.examples.mock.api.Heater;
import dev.kosztadani.examples.mock.api.Sensor;

public class Controller {

    private static final int MIN_TEMPERATURE = 22;
    private static final int MAX_TEMPERATURE = 26;

    private final Sensor sensor;
    private final Heater heater;
    private final Cooler cooler;

    public Controller(Sensor sensor, Heater heater, Cooler cooler) {
        this.sensor = sensor;
        this.heater = heater;
        this.cooler = cooler;
    }

    /**
     * Operate the mechanism that detects temperature and makes adjustments as needed.
     *
     * Intended to be called from an infinite loop, with some delay between calls.
     */
    public void operate() {
        int temperature = sensor.sense();
        if (temperature < MIN_TEMPERATURE) {
            heater.heat();
        } else if (temperature > MAX_TEMPERATURE) {
            cooler.cool();
        }
    }
}
