package nl.omkprojects.electricalcircuitsimulator.circuit.component.gate;

import java.awt.*;

/**
 * Created by Olle on 07-10-2015.
 */
public abstract class SinleInputGateComponent extends AbstractGateComponent {
    public SinleInputGateComponent(float positionX, float positionY) {
        super(positionX, positionY, 1);
    }

    public SinleInputGateComponent(float positionX, float positionY, Color color) {
        super(positionX, positionY, color, 1);
    }
}
