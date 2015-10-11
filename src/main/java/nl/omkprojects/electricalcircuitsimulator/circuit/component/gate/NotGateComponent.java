package nl.omkprojects.electricalcircuitsimulator.circuit.component.gate;

import nl.omkprojects.electricalcircuitsimulator.circuit.graphics.GraphicsWrapper;

import java.awt.*;

public class NotGateComponent extends SingleInputGateComponent {
    public NotGateComponent(float positionX, float positionY) {
        super(positionX, positionY);
    }

    public NotGateComponent(float positionX, float positionY, Color color) {
        super(positionX, positionY, color);
    }

    @Override
    public void renderGateComponent(GraphicsWrapper g) {
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
