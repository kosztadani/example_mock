package dev.kosztadani.examples.mock.handwritten;

import dev.kosztadani.examples.mock.Controller;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ControllerTest {

    private final MockSensor sensor = new MockSensor();
    private final MockHeater heater = new MockHeater();
    private final MockCooler cooler = new MockCooler();
    private final Controller controller = new Controller(sensor, heater, cooler);

    @Test
    public void testNoOperation() {
        // given
        sensor.setValues(25);

        // when
        controller.operate();

        // then
        assertEquals(1, sensor.getCallCounter());
        assertEquals(0, heater.getCallCounter());
        assertEquals(0, cooler.getCallCounter());
    }

    @Test
    public void testHeater() {
        // given
        sensor.setValues(18);

        // when
        controller.operate();

        // then
        assertEquals(1, sensor.getCallCounter());
        assertEquals(1, heater.getCallCounter());
        assertEquals(0, cooler.getCallCounter());
    }

    @Test
    public void testCooler() {
        // given
        sensor.setValues(30);

        // when
        controller.operate();

        // then
        assertEquals(1, sensor.getCallCounter());
        assertEquals(0, heater.getCallCounter());
        assertEquals(1, cooler.getCallCounter());
    }

    @Test
    public void testComplex() {
        // given
        sensor.setValues(22, 20, 24, 28, 25);

        // when
        controller.operate();
        // then
        assertEquals(1, sensor.getCallCounter());
        assertEquals(0, heater.getCallCounter());
        assertEquals(0, cooler.getCallCounter());

        // when
        controller.operate();
        // then
        assertEquals(2, sensor.getCallCounter());
        assertEquals(1, heater.getCallCounter());
        assertEquals(0, cooler.getCallCounter());

        // when
        controller.operate();
        // then
        assertEquals(3, sensor.getCallCounter());
        assertEquals(1, heater.getCallCounter());
        assertEquals(0, cooler.getCallCounter());

        // when
        controller.operate();
        // then
        assertEquals(4, sensor.getCallCounter());
        assertEquals(1, heater.getCallCounter());
        assertEquals(1, cooler.getCallCounter());

        // when
        controller.operate();
        // then
        assertEquals(5, sensor.getCallCounter());
        assertEquals(1, heater.getCallCounter());
        assertEquals(1, cooler.getCallCounter());
    }
}
