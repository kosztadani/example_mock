package dev.kosztadani.examples.mock.withmockito;

import dev.kosztadani.examples.mock.Controller;
import dev.kosztadani.examples.mock.api.Cooler;
import dev.kosztadani.examples.mock.api.Heater;
import dev.kosztadani.examples.mock.api.Sensor;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ControllerTest {

    @Mock
    private Sensor sensor;

    @Mock
    private Heater heater;

    @Mock
    private Cooler cooler;

    @InjectMocks
    private Controller controller;

    @Test
    public void testNoOperation() {
        when(sensor.sense()).thenReturn(25);

        controller.operate();

        verifyNoMoreInteractions(sensor);
        verifyNoMoreInteractions(heater);
        verifyNoMoreInteractions(cooler);
    }

    @Test
    public void testHeater() {
        when(sensor.sense()).thenReturn(18);

        controller.operate();

        verifyNoMoreInteractions(sensor);
        verify(heater).heat();
        verifyNoMoreInteractions(heater);
        verifyNoMoreInteractions(cooler);
    }

    @Test
    public void testCooler() {
        when(sensor.sense()).thenReturn(30);

        controller.operate();

        verifyNoMoreInteractions(sensor);
        verifyNoMoreInteractions(heater);
        verify(cooler).cool();
        verifyNoMoreInteractions(cooler);
    }

    @Test
    public void testComplex() {
        when(sensor.sense())
            .thenReturn(22)
            .thenReturn(20)
            .thenReturn(24)
            .thenReturn(28)
            .thenReturn(25);

        controller.operate();
        verifyNoMoreInteractions(sensor);
        verifyNoMoreInteractions(heater);
        verifyNoMoreInteractions(cooler);

        controller.operate();
        verifyNoMoreInteractions(sensor);
        verify(heater).heat();
        verifyNoMoreInteractions(heater);
        verifyNoMoreInteractions(cooler);

        controller.operate();
        verifyNoMoreInteractions(sensor);
        verifyNoMoreInteractions(heater);
        verifyNoMoreInteractions(cooler);

        controller.operate();
        verifyNoMoreInteractions(sensor);
        verifyNoMoreInteractions(heater);
        verify(cooler).cool();
        verifyNoMoreInteractions(cooler);

        controller.operate();
        verifyNoMoreInteractions(sensor);
        verifyNoMoreInteractions(heater);
        verifyNoMoreInteractions(cooler);
    }
}
