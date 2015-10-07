package nl.omkprojects.electricalcircuitsimulator.circuit.component;

import nl.omkprojects.electricalcircuitsimulator.circuit.graphics.GraphicsHelper;

import java.awt.*;

/**
 * Created by Olle on 07-10-2015.
 */
public class PinComponent extends AbstractCircuitComponent {
    public PinComponent(float positionX, float positionY) {
        super(positionX, positionY);
    }

    @Override
    public void render(GraphicsHelper g) {
        g.setColor(Color.RED);
        g.drawCircle(0, 0, 2, true);
        g.resetColor();
    }
}
