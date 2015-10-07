package nl.omkprojects.electricalcircuitsimulator.circuit.component.gate;

import java.awt.*;

/**
 * Created by Olle on 07-10-2015.
 */
public abstract class MultiInputGateComponent extends AbstractGateComponent {
    public MultiInputGateComponent(float positionX, float positionY, int inputCount) {
        super(positionX, positionY, validateInputCount(inputCount));
    }

    public MultiInputGateComponent(float positionX, float positionY, Color color, int inputCount) {
        super(positionX, positionY, color, validateInputCount(inputCount));
    }

    private static int validateInputCount(int inputCount) {
        if (inputCount < 2) throw new IllegalArgumentException("A minimum of 2 input-pins is required");
        return inputCount;
    }

}
