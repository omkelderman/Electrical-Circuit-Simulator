package nl.omkprojects.electricalcircuitsimulator.circuit.component.gate;

import nl.omkprojects.electricalcircuitsimulator.circuit.graphics.GraphicsHelper;

import java.awt.*;

/**
 * Created by Olle on 06-10-2015.
 */
public class NorGateComponent extends MultiInputGateComponent {
    public NorGateComponent(float positionX, float positionY) {
        super(positionX, positionY, 2);
    }

    public NorGateComponent(float positionX, float positionY, Color color) {
        super(positionX, positionY, color, 2);
    }

    @Override
    public void renderGateComponent(GraphicsHelper g) {
        g.drawCircle(-24, 0, 14.87f, -42.27f, 42.27f);
        g.drawLine(-13, -10, 0, -10);
        g.drawLine(-13, 10, 0, 10);
        g.drawCircle(0, 0, 10, -90, 90);
        g.drawCircle(12, 0, 2);
    }

    @Override
    protected float getOutputLineX() {
        return 14;
    }
}
