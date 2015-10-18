package nl.omkprojects.electricalcircuitsimulator;

import nl.omkprojects.electricalcircuitsimulator.circuit.VirtualCircuit;
import nl.omkprojects.electricalcircuitsimulator.circuit.component.gate.*;
import nl.omkprojects.electricalcircuitsimulator.gui.ElecCircuitSim;

public class App {
    public static void main(String[] args) {
        VirtualCircuit virtualCircuit = new VirtualCircuit();

        final float scale = 1f;

        AndGateComponent andGateComponent = new AndGateComponent(30 * scale, 30 * scale, 4);
        andGateComponent.setScale(scale);
        virtualCircuit.addComponent(andGateComponent);

        NandGateComponent nandGateComponent = new NandGateComponent(100 * scale, 30 * scale, 4);
        nandGateComponent.setScale(scale);
        virtualCircuit.addComponent(nandGateComponent);

        OrGateComponent orGateComponent = new OrGateComponent(30 * scale, 100 * scale, 4);
        orGateComponent.setScale(scale);
        virtualCircuit.addComponent(orGateComponent);

        NorGateComponent norGateComponent = new NorGateComponent(100 * scale, 100 * scale, 4);
        norGateComponent.setScale(scale);
        virtualCircuit.addComponent(norGateComponent);

        XorGateComponent xorGateComponent = new XorGateComponent(30 * scale, 170 * scale, 4);
        xorGateComponent.setScale(scale);
        virtualCircuit.addComponent(xorGateComponent);

        XnorGateComponent xnorGateComponent = new XnorGateComponent(100 * scale, 170 * scale, 4);
        xnorGateComponent.setScale(scale);
        virtualCircuit.addComponent(xnorGateComponent);

        NotGateComponent notGateComponent = new NotGateComponent(100 * scale, 240 * scale);
        notGateComponent.setScale(scale);
        virtualCircuit.addComponent(notGateComponent);

        ElecCircuitSim sim = new ElecCircuitSim("Awesome Title", virtualCircuit);
        sim.setVisible(true);
    }
}
