package nl.omkprojects.electricalcircuitsimulator.gui;

import nl.omkprojects.electricalcircuitsimulator.circuit.VirtualCircuit;
import nl.omkprojects.electricalcircuitsimulator.circuit.graphics.GraphicsHelper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;

/**
 * Created by Olle on 06-10-2015.
 */
public class CircuitPanel extends JPanel {
    private VirtualCircuit virtualCircuit;

    public CircuitPanel(VirtualCircuit virtualCircuit) {
        this.virtualCircuit = virtualCircuit;
        MouseAdapter mouseAdapter = new MouseAdapter() {
        };
        addMouseMotionListener(mouseAdapter);
        addMouseListener(mouseAdapter);
    }

    @Override
    public void paint(java.awt.Graphics g) {
        super.paint(g);

        if (g instanceof Graphics2D) {
            Graphics2D g2 = (Graphics2D) g;
            virtualCircuit.render(new GraphicsHelper(g2));
        } else {
            System.err.println("No Graphics2D available...");
        }
    }
}
