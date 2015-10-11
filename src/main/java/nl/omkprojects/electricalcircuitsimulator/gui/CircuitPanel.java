package nl.omkprojects.electricalcircuitsimulator.gui;

import nl.omkprojects.electricalcircuitsimulator.circuit.VirtualCircuit;
import nl.omkprojects.electricalcircuitsimulator.circuit.graphics.DrawPositionInfo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;

public class CircuitPanel extends JPanel {
    private VirtualCircuit virtualCircuit;

    private Point mouseStartPosition = null;
    private float virtualCircuitStartX = 0;
    private float virtualCircuitStartY = 0;
    private boolean dragging = false;


    public CircuitPanel(VirtualCircuit virtualCircuit) {
        this.virtualCircuit = virtualCircuit;
        MouseAdapter mouseAdapter = new MouseAdapter() {
            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {
                CircuitPanel.this.mouseWheelMoved(e);
            }

            @Override
            public void mousePressed(MouseEvent e) {
                CircuitPanel.this.mousePressed(e);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                CircuitPanel.this.mouseReleased(e);
            }

            @Override
            public void mouseDragged(MouseEvent e) {
                CircuitPanel.this.mouseDragged(e);
            }
        };
        addMouseMotionListener(mouseAdapter);
        addMouseListener(mouseAdapter);
        addMouseWheelListener(mouseAdapter);
    }

    private void mouseWheelMoved(MouseWheelEvent e) {
        virtualCircuit.zoom(e.getWheelRotation(), e.getPoint());
        repaint();
    }

    private void mousePressed(MouseEvent e) {
        if (SwingUtilities.isMiddleMouseButton(e)) {
            // start dragging
            mouseStartPosition = e.getPoint();
            DrawPositionInfo drawPositionInfo = virtualCircuit.getDrawPositionInfo();
            virtualCircuitStartX = drawPositionInfo.x;
            virtualCircuitStartY = drawPositionInfo.y;
            dragging = true;
        }
    }

    private void mouseReleased(MouseEvent e) {
        if (SwingUtilities.isMiddleMouseButton(e)) {
            // stop dragging
            dragging = false;
        }
    }

    private void mouseDragged(MouseEvent e) {
        if (SwingUtilities.isMiddleMouseButton(e)) {
            if (dragging) {
                Point mouseCurrentPosition = e.getPoint();
                float x = virtualCircuitStartX + (mouseCurrentPosition.x - mouseStartPosition.x);
                float y = virtualCircuitStartY + (mouseCurrentPosition.y - mouseStartPosition.y);
                virtualCircuit.setPosition(x, y);
                repaint();
            }
        }
    }

    @Override
    public void paint(Graphics graphics) {
        super.paint(graphics);

        if (graphics instanceof Graphics2D) {
            virtualCircuit.render((Graphics2D) graphics);
        } else {
            System.err.println("No Graphics2D available...");
        }
    }
}
