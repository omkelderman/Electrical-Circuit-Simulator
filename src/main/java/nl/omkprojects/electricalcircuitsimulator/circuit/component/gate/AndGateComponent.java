package nl.omkprojects.electricalcircuitsimulator.circuit.component.gate;

import nl.omkprojects.electricalcircuitsimulator.circuit.graphics.GraphicsWrapper;

import java.awt.*;

public class AndGateComponent extends MultiInputGateComponent {
    public AndGateComponent(float positionX, float positionY) {
        this(positionX, positionY, 2);
    }

    public AndGateComponent(float positionX, float positionY, int inputCount) {
        super(positionX, positionY, inputCount);
    }

    public AndGateComponent(float positionX, float positionY, Color color) {
        this(positionX, positionY, color, 2);
    }

    public AndGateComponent(float positionX, float positionY, Color color, int inputCount) {
        super(positionX, positionY, color, inputCount);
    }

    @Override
    public void renderGateComponent(GraphicsWrapper g) {
        float halfInputHeight = inputCount * 5;
        g.drawLine(-10, -halfInputHeight, -10, halfInputHeight);
        g.drawLine(-10, -halfInputHeight, 0, -halfInputHeight);
        g.drawLine(-10, halfInputHeight, 0, halfInputHeight);
        g.drawEllipse(0, 0, 20, halfInputHeight * 2, 0, 180);
    }
}
