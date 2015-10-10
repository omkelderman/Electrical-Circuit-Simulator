package nl.omkprojects.electricalcircuitsimulator.circuit;


import nl.omkprojects.electricalcircuitsimulator.circuit.component.AbstractCircuitComponent;
import nl.omkprojects.electricalcircuitsimulator.circuit.graphics.DrawPositionInfo;
import nl.omkprojects.electricalcircuitsimulator.circuit.graphics.GraphicsHelper;
import nl.omkprojects.electricalcircuitsimulator.circuit.graphics.IPaintable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Olle on 06-10-2015.
 */
public class VirtualCircuit implements IPaintable {
    private List<AbstractCircuitComponent> componentList;
    private DrawPositionInfo drawPositionInfo;

    public VirtualCircuit() {
        this.componentList = new ArrayList<>();
        this.drawPositionInfo = new DrawPositionInfo();
    }

    public DrawPositionInfo getDrawPositionInfo() {
        return drawPositionInfo;
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
