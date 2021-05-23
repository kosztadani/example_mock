package dev.kosztadani.examples.mock.api;

public interface Heater {

    /**
     * Heat the system.
     *
     * One-time operation, e.g. adding an amount of hot water.
     */
    void heat();
}
