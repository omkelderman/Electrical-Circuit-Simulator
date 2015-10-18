package nl.omkprojects.electricalcircuitsimulator.circuit.component.gate;

import java.awt.*;

public abstract class MultiInputGateComponent extends AbstractGateComponent {
    protected final float inputCount;

    public MultiInputGateComponent(float positionX, float positionY, int inputCount) {
        super(positionX, positionY, validateInputCount(inputCount));
        this.inputCount = inputCount;
    }

    public MultiInputGateComponent(float positionX, float positionY, Color color, int inputCount) {
        super(positionX, positionY, color, validateInputCount(inputCount));
        this.inputCount = inputCount;
    }

    private static int validateInputCount(int inputCount) {
        if (inputCount < 2) throw new IllegalArgumentException("A minimum of 2 input-pins is required");
        return inputCount;
    }

}
