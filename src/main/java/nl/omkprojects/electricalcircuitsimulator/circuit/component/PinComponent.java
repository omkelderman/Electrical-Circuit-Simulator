package nl.omkprojects.electricalcircuitsimulator.circuit.component;

import nl.omkprojects.electricalcircuitsimulator.circuit.graphics.GraphicsWrapper;

import java.awt.*;

public class PinComponent extends AbstractCircuitComponent {
    public PinComponent(float positionX, float positionY) {
        super(positionX, positionY);
    }

    @Override
    public void renderComponent(GraphicsWrapper g) {
        g.setColor(Color.RED);
        g.drawCircle(0, 0, 4, true);
        g.resetColor();
    }
}
