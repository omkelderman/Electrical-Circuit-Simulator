package nl.omkprojects.electricalcircuitsimulator.circuit;


import nl.omkprojects.electricalcircuitsimulator.circuit.component.AbstractCircuitComponent;
import nl.omkprojects.electricalcircuitsimulator.circuit.graphics.DrawPositionInfo;
import nl.omkprojects.electricalcircuitsimulator.circuit.graphics.GraphicsHelper;
import nl.omkprojects.electricalcircuitsimulator.circuit.graphics.IPaintable;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Olle on 06-10-2015.
 */
public class VirtualCircuit implements IPaintable {
    private static final float ZOOM_CONSTANT = 1.05f;

    private List<AbstractCircuitComponent> componentList;
    private DrawPositionInfo drawPositionInfo;

    public VirtualCircuit() {
        this.componentList = new ArrayList<>();
        this.drawPositionInfo = new DrawPositionInfo();
    }

    public DrawPositionInfo getDrawPositionInfo() {
        return drawPositionInfo;
    }

    public void setPosition(float x, float y) {
        drawPositionInfo.x = x;
        drawPositionInfo.y = y;
    }

    public void zoom(int zoom, Point point) {
        // set new scale
        float zoomModifier = (float) Math.pow(ZOOM_CONSTANT, zoom);
        this.drawPositionInfo.scale /= zoomModifier;

        // correct position to place the point that was below the mouse-pointer again below the mouse-pointer

        // so yeah, turns out, after doing the math this is correct:
        float deltaScale = 1 - (1 / zoomModifier);

        float realX = point.x - drawPositionInfo.x;
        float realY = point.y - drawPositionInfo.y;
        float deltaX = realX * deltaScale;
        float deltaY = realY * deltaScale;
        this.drawPositionInfo.x += deltaX;
        this.drawPositionInfo.y += deltaY;
    }

    public void addComponent(AbstractCircuitComponent component) {
        componentList.add(component);
    }

    @Override
    public void render(GraphicsHelper g) {
        g.setRelativePositioning(drawPositionInfo);
        for (AbstractCircuitComponent component : componentList) {
            g.setRelativePositioning(component.getDrawPositionInfo());
            component.render(g);
            g.resetRelativePositioning();
        }
        g.resetRelativePositioning();
    }
}
