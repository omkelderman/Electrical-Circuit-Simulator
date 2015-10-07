package nl.omkprojects.electricalcircuitsimulator.circuit.component.gate;

import nl.omkprojects.electricalcircuitsimulator.circuit.graphics.GraphicsHelper;

import java.awt.*;

/**
 * Created by Olle on 06-10-2015.
 */
public class NotGateComponent extends SingleInputGateComponent {
    public NotGateComponent(float positionX, float positionY) {
        super(positionX, positionY);
    }

    public NotGateComponent(float positionX, float positionY, Color color) {
        super(positionX, positionY, color);
    }

    @Override
    public void renderGateComponent(GraphicsHelper g) {
        g.drawLine(-10, -10, -10, 10);
        g.drawLine(-10, -10, 10, 0);
        g.drawLine(-10, 10, 10, 0);
        g.drawCircle(12, 0, 2);
    }

    @Override
    protected float getOutputLineX() {
        return 14;
    }
}