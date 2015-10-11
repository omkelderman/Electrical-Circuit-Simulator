package nl.omkprojects.electricalcircuitsimulator.circuit.component.gate;

import nl.omkprojects.electricalcircuitsimulator.circuit.graphics.GraphicsWrapper;

import java.awt.*;

public class XorGateComponent extends MultiInputGateComponent {
    public XorGateComponent(float positionX, float positionY) {
        super(positionX, positionY, 2);
    }

    public XorGateComponent(float positionX, float positionY, Color color) {
        super(positionX, positionY, color, 2);
    }

    @Override
    public void renderGateComponent(GraphicsWrapper g) {
        g.drawCircle(-24, 0, 14.87f, 47.73f, 132.27f);
        g.drawCircle(-27, 0, 14.87f, 47.73f, 132.27f);
        g.drawLine(-13, -10, 0, -10);
        g.drawLine(-13, 10, 0, 10);
        g.drawCircle(0, 0, 10, 0, 180);
    }
}
