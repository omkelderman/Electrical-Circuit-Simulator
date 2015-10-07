package nl.omkprojects.electricalcircuitsimulator.circuit;


import nl.omkprojects.electricalcircuitsimulator.circuit.component.AbstractCircuitComponent;
import nl.omkprojects.electricalcircuitsimulator.circuit.graphics.GraphicsHelper;
import nl.omkprojects.electricalcircuitsimulator.circuit.graphics.IPaintable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Olle on 06-10-2015.
 */
public class VirtualCircuit implements IPaintable {
    private List<AbstractCircuitComponent> componentList;

    public VirtualCircuit() {
        this.componentList = new ArrayList<>();
    }

    public void addComponent(AbstractCircuitComponent component) {
        componentList.add(component);
    }

    @Override
    public void render(GraphicsHelper g) {
        for (AbstractCircuitComponent component : componentList) {
            g.setRelativePositioning(component.getPositionX(), component.getPositionY(), component.getScale());
            component.render(g);
            g.resetRelativePositioning();
        }
    }
}
