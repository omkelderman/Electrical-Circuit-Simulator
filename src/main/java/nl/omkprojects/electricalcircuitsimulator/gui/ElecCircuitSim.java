package nl.omkprojects.electricalcircuitsimulator.gui;

import nl.omkprojects.electricalcircuitsimulator.circuit.VirtualCircuit;

import javax.swing.*;

public class ElecCircuitSim extends JFrame {
    private JPanel rootPanel;
    private JSplitPane mainSplitPanel;
    private JPanel leftPanel;
    private JPanel circuitPanel;
    private JButton button1;
    private VirtualCircuit virtualCircuit;

    public ElecCircuitSim(String title, VirtualCircuit virtualCircuit) {
        super(title);
        this.virtualCircuit = virtualCircuit;

        setContentPane(rootPanel);
        pack();
        setSize(500, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    private void createUIComponents() {
        circuitPanel = new CircuitPanel(virtualCircuit);
    }
}
