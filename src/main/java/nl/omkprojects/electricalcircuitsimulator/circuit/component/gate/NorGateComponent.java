package nl.omkprojects.electricalcircuitsimulator.circuit.component.gate;

import nl.omkprojects.electricalcircuitsimulator.circuit.graphics.GraphicsWrapper;

import java.awt.*;

public class NorGateComponent extends MultiInputGateComponent {
    public NorGateComponent(float positionX, float positionY) {
        this(positionX, positionY, 2);
    }

    public NorGateComponent(float positionX, float positionY, int inputCount) {
        super(positionX, positionY, inputCount);
    }

    public NorGateComponent(float positionX, float positionY, Color color) {
        this(positionX, positionY, color, 2);
    }

    public NorGateComponent(float positionX, float positionY, Color color, int inputCount) {
        super(positionX, positionY, color, inputCount);
    }

    @Override
    public void renderGateComponent(GraphicsWrapper g) {
        g.drawCircle(-24, 0, 29.74f, 47.73f, 132.27f);
        g.drawLine(-13, -10, 0, -10);
        g.drawLine(-13, 10, 0, 10);
        g.drawCircle(0, 0, 20, 0, 180);
        g.drawCircle(12, 0, 4);
    }

    @Override
    protected float getOutputLineX() {
        return 14;
    }
}
