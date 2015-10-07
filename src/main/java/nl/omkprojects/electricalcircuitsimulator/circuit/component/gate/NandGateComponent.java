package nl.omkprojects.electricalcircuitsimulator.circuit.component.gate;

import nl.omkprojects.electricalcircuitsimulator.circuit.graphics.GraphicsHelper;

import java.awt.*;

/**
 * Created by Olle on 06-10-2015.
 */
public class NandGateComponent extends MultiInputGateComponent {
    public NandGateComponent(float positionX, float positionY) {
        super(positionX, positionY, 2);
    }

    public NandGateComponent(float positionX, float positionY, Color color) {
        super(positionX, positionY, color, 2);
    }

    @Override
    public void renderGateComponent(GraphicsHelper g) {
        // input-lines
        g.drawLine(-20, -5, -10, -5);
        g.drawLine(-20, 5, -10, 5);

        // component
        g.drawLine(-10, -10, -10, 10);
        g.drawLine(-10, -10, 0, -10);
        g.drawLine(-10, 10, 0, 10);
        g.drawCircle(0, 0, 10, -90, 90);
        g.drawCircle(12, 0, 2);

        // output-line
        g.drawLine(14, 0, 20, 0);
    }
}
