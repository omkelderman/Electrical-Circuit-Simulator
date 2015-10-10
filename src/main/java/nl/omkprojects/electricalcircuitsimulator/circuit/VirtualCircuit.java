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
    public static final int ZOOM_SPEED = 50;
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

    public void zoom(float zoom, Point point) {
        float actualZoom = zoom / ZOOM_SPEED;
        if (this.drawPositionInfo.scale <= actualZoom) {
            // ignore requests that tries to set scale to 0 or less
            return;
        }

        float x = point.x - drawPositionInfo.x;
        float y = point.y - drawPositionInfo.y;

        float deltaScale = actualZoom / drawPositionInfo.scale;
        this.drawPositionInfo.scale -= actualZoom;

        float deltaX = x * deltaScale;
        float deltaY = y * deltaScale;

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
