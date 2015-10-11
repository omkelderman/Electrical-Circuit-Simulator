package nl.omkprojects.electricalcircuitsimulator.circuit.component;

import nl.omkprojects.electricalcircuitsimulator.circuit.graphics.DrawPositionInfo;
import nl.omkprojects.electricalcircuitsimulator.circuit.graphics.GraphicsWrapper;
import nl.omkprojects.electricalcircuitsimulator.circuit.graphics.IPaintable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Olle on 06-10-2015.
 */
public abstract class AbstractCircuitComponent implements IPaintable {
    private DrawPositionInfo drawPositionInfo;

    private List<AbstractCircuitComponent> relativeComponentsList;

    public AbstractCircuitComponent(float positionX, float positionY) {
        this.relativeComponentsList = new ArrayList<>();
        this.drawPositionInfo = new DrawPositionInfo(positionX, positionY);
    }

    public DrawPositionInfo getDrawPositionInfo() {
        return drawPositionInfo;
    }

    protected void addRelativeComponent(AbstractCircuitComponent component) {
        relativeComponentsList.add(component);
    }

    public float getPositionX() {
        return drawPositionInfo.x;
    }

    public void setPositionX(float positionX) {
        this.drawPositionInfo.x = positionX;
    }

    public float getPositionY() {
        return drawPositionInfo.y;
    }

    public void setPositionY(float positionY) {
        this.drawPositionInfo.y = positionY;
    }

    public float getScale() {
        return drawPositionInfo.scale;
    }

    public void setScale(float scale) {
        this.drawPositionInfo.scale = scale;
    }

    public float getAngle() {
        return drawPositionInfo.angle;
    }

    public void setAngle(float angle) {
        this.drawPositionInfo.angle = angle;
    }

    @Override
    public void render(GraphicsWrapper g) {
        // DEBUG: draw anchor-point
        //g.drawCircle(0, 0, 2, true);

        // render relative components
        for (AbstractCircuitComponent component : relativeComponentsList) {
            g.setRelativePositioning(component.drawPositionInfo);
            component.render(g);
            g.resetRelativePositioning();
        }
    }

}
