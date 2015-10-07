package nl.omkprojects.electricalcircuitsimulator.circuit.component.gate;

import nl.omkprojects.electricalcircuitsimulator.circuit.component.AbstractCircuitComponent;
import nl.omkprojects.electricalcircuitsimulator.circuit.component.PinComponent;
import nl.omkprojects.electricalcircuitsimulator.circuit.graphics.GraphicsHelper;

import java.awt.*;

/**
 * Created by Olle on 06-10-2015.
 */
public abstract class AbstractGateComponent extends AbstractCircuitComponent {
    private Color color;
    protected PinComponent outputPin;
    protected PinComponent[] inputPins;

    public AbstractGateComponent(float positionX, float positionY, int inputCount) {
        this(positionX, positionY, Color.BLACK, inputCount);
    }

    public AbstractGateComponent(float positionX, float positionY, Color color, int inputCount) {
        super(positionX, positionY);
        this.color = color;

        // input pins
        if (inputCount < 1) {
            throw new IllegalArgumentException("A minimum of 1 input-pin is required");
        }
        inputPins = new PinComponent[inputCount];
        float inputPinY = -5 * inputCount + 5;
        for (int i = 0; i < inputCount; ++i) {
            PinComponent inputPin = new PinComponent(-20, inputPinY);
            addRelativeComponent(inputPin);
            inputPinY += 10;
            inputPins[i] = inputPin;
        }

        // outputPin
        this.outputPin = new PinComponent(20, 0);
        addRelativeComponent(outputPin);
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public final void render(GraphicsHelper g) {
        // first render gate
        g.setColor(color);
        renderGateComponent(g);
        g.resetColor();

        // render PinComponent objects after that
        super.render(g);
    }

    protected abstract void renderGateComponent(GraphicsHelper g);
}
