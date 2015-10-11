package nl.omkprojects.electricalcircuitsimulator.circuit.component.gate;

import nl.omkprojects.electricalcircuitsimulator.circuit.component.AbstractCircuitComponent;
import nl.omkprojects.electricalcircuitsimulator.circuit.component.PinComponent;
import nl.omkprojects.electricalcircuitsimulator.circuit.graphics.GraphicsWrapper;

import java.awt.*;

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
    public final void render(GraphicsWrapper g) {
        // first render gate
        g.setColor(color);
        renderInputLines(g);
        renderGateComponent(g);
        renderOutputLines(g);
        g.resetColor();

        // render PinComponent objects after that
        super.render(g);
    }

    private void renderInputLines(GraphicsWrapper g) {
        for (int i = 0; i < inputPins.length; i++) {
            g.drawLine(inputPins[i].getPositionX() + 2, inputPins[i].getPositionY(), getInputLineX(i), inputPins[i].getPositionY());
        }
    }


    protected abstract void renderGateComponent(GraphicsWrapper g);

    private void renderOutputLines(GraphicsWrapper g) {
        g.drawLine(getOutputLineX(), outputPin.getPositionY(), outputPin.getPositionX() - 2, outputPin.getPositionY());
    }

    protected float getInputLineX(@SuppressWarnings("unused") int i) {
        return -10;
    }

    protected float getOutputLineX() {
        return 10;
    }
}
