package nl.omkprojects.electricalcircuitsimulator.circuit.component.gate;

import nl.omkprojects.electricalcircuitsimulator.circuit.graphics.GraphicsWrapper;

import java.awt.*;

public class OrGateComponent extends MultiInputGateComponent {
    public OrGateComponent(float positionX, float positionY) {
        this(positionX, positionY, 2);
    }

    public OrGateComponent(float positionX, float positionY, int inputCount) {
        super(positionX, positionY, inputCount);
    }

    public OrGateComponent(float positionX, float positionY, Color color) {
        this(positionX, positionY, color, 2);
    }

    public OrGateComponent(float positionX, float positionY, Color color, int inputCount) {
        super(positionX, positionY, color, inputCount);
    }

    @Override
    public void renderGateComponent(GraphicsWrapper g) {
        float halfInputHeight = inputCount * 5;
        g.drawEllipse(-18.33333333f, 0, 22.66666667f, 11.33333333f * inputCount, 28.07248694f, 151.9275131f);
        g.drawLine(-13, -halfInputHeight, 0, -halfInputHeight);
        g.drawLine(-13, halfInputHeight, 0, halfInputHeight);
        g.drawEllipse(0, 0, 20, halfInputHeight * 2, 0, 180);
    }

    @Override
    protected float getInputLineX(int i) {
        return (float) Math.sqrt((-12844.44444444 * i * i + 913.3827160 * inputCount * inputCount - 12844.44444444 * i + 6422.22222222 * inputCount + 12844.44444444 * i * inputCount - 3211.11111111) / (32.11111111 * inputCount * inputCount)) - 18.33333333f;
    }
}
