package nl.omkprojects.electricalcircuitsimulator.circuit.component;

import nl.omkprojects.electricalcircuitsimulator.circuit.graphics.DrawPositionInfo;
import nl.omkprojects.electricalcircuitsimulator.circuit.graphics.GraphicsWrapper;
import nl.omkprojects.electricalcircuitsimulator.circuit.graphics.IPaintable;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractCircuitComponent implements IPaintable {
    private DrawPositionInfo drawPositionInfo;

    private List<AbstractCircuitComponent> relativeComponentsList;

    public AbstractCircuitComponent(float positionX, float positionY) {
        this.relativeComponentsList = new ArrayList<>();
        this.drawPositionInfo = new DrawPositionInfo(positionX, positionY);
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
    public final void render(GraphicsWrapper g) {
        // set relative position
        g.setRelativePositioning(drawPositionInfo);

        // render the component itself
        renderComponent(g);

        // render relative components
        for (AbstractCircuitComponent component : relativeComponentsList) {
            component.render(g);
        }

        // DEBUG: draw anchor-point
//        g.setColor(Color.BLUE);
//        g.drawCircle(0, 0, 2, true);
//        g.resetColor();

        // reset relative position
        g.resetRelativePositioning();
    }

    protected abstract void renderComponent(GraphicsWrapper g);
}
