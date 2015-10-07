package nl.omkprojects.electricalcircuitsimulator.circuit.component;

import nl.omkprojects.electricalcircuitsimulator.circuit.graphics.GraphicsHelper;
import nl.omkprojects.electricalcircuitsimulator.circuit.graphics.IPaintable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Olle on 06-10-2015.
 */
public abstract class AbstractCircuitComponent implements IPaintable {
    protected float positionX;
    protected float positionY;
    protected float scale;

    private List<AbstractCircuitComponent> relativeComponentsList;

    public AbstractCircuitComponent(float positionX, float positionY) {
        this.positionX = positionX;
        this.positionY = positionY;
        this.scale = 1;
        this.relativeComponentsList = new ArrayList<>();
    }

    protected void addRelativeComponent(AbstractCircuitComponent component) {
        relativeComponentsList.add(component);
    }

    public float getPositionX() {
        return positionX;
    }

    public void setPositionX(float positionX) {
        this.positionX = positionX;
    }

    public float getPositionY() {
        return positionY;
    }

    public void setPositionY(float positionY) {
        this.positionY = positionY;
    }

    public float getScale() {
        return scale;
    }

    public void setScale(float scale) {
        this.scale = scale;
    }

    @Override
    public void render(GraphicsHelper g) {
        // DEBUG: draw anchor-point
        //g.drawCircle(0, 0, 2, true);

        // render relative components
        for (AbstractCircuitComponent component : relativeComponentsList) {
            g.setRelativePositioning(component.getPositionX(), component.getPositionY(), component.getScale());
            component.render(g);
            g.resetRelativePositioning();
        }
    }

}
