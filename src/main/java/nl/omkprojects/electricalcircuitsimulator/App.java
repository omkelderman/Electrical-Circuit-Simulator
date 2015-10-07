package nl.omkprojects.electricalcircuitsimulator;

import nl.omkprojects.electricalcircuitsimulator.circuit.VirtualCircuit;
import nl.omkprojects.electricalcircuitsimulator.circuit.component.gate.*;
import nl.omkprojects.electricalcircuitsimulator.gui.ElecCircuitSim;

/**
 * Created by Olle on 06-10-2015.
 */
public class App {
    public static void main(String[] args) {
        VirtualCircuit virtualCircuit = new VirtualCircuit();

        float scale = 1f;

        AndGateComponent andGateComponent = new AndGateComponent(30 * scale, 30 * scale);
        andGateComponent.setScale(scale);
        virtualCircuit.addComponent(andGateComponent);

        NandGateComponent nandGateComponent = new NandGateComponent(80 * scale, 30 * scale);
        nandGateComponent.setScale(scale);
        virtualCircuit.addComponent(nandGateComponent);

        OrGateComponent orGateComponent = new OrGateComponent(30 * scale, 70 * scale);
        orGateComponent.setScale(scale);
        virtualCircuit.addComponent(orGateComponent);

        NorGateComponent norGateComponent = new NorGateComponent(80 * scale, 70 * scale);
        norGateComponent.setScale(scale);
        virtualCircuit.addComponent(norGateComponent);

        XorGateComponent xorGateComponent = new XorGateComponent(30 * scale, 110 * scale);
        xorGateComponent.setScale(scale);
        xorGateComponent.setAngle(45);
        virtualCircuit.addComponent(xorGateComponent);

        XnorGateComponent xnorGateComponent = new XnorGateComponent(80 * scale, 110 * scale);
        xnorGateComponent.setScale(scale);
        virtualCircuit.addComponent(xnorGateComponent);

        NotGateComponent notGateComponent = new NotGateComponent(80 * scale, 150 * scale);
        notGateComponent.setScale(scale);
        virtualCircuit.addComponent(notGateComponent);

        ElecCircuitSim sim = new ElecCircuitSim("Awesome Title", virtualCircuit);
        sim.setVisible(true);
    }
}
