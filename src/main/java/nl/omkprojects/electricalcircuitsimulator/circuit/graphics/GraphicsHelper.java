package nl.omkprojects.electricalcircuitsimulator.circuit.graphics;

import java.awt.*;
import java.awt.geom.Arc2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.util.Stack;

/**
 * Created by Olle on 06-10-2015.
 */
public class GraphicsHelper {
    private final Graphics2D g2;
    private final RelativeInfo relativeInfo = new RelativeInfo();
    private final Stack<RelativeInfo> relativeHistory = new Stack<>();
    private final Stack<Color> colorHistory = new Stack<>();

    public GraphicsHelper(Graphics2D g2) {
        this.g2 = g2;
    }

    public void setColor(Color c) {
        // push current color to stack
        colorHistory.push(g2.getColor());

        // update current color
        g2.setColor(c);
    }

    public void resetColor() {
        if (colorHistory.isEmpty()) throw new IllegalStateException("History is empty, cannot reset!");

        // pop from stack and update current color
        g2.setColor(colorHistory.pop());
    }

    public void setRelativePositioning(float x, float y, float scale) {
        // create copy and push in stack
        relativeHistory.push(new RelativeInfo(relativeInfo));

        // update current info
        relativeInfo.relativeX += x * relativeInfo.relativeScale;
        relativeInfo.relativeY += y * relativeInfo.relativeScale;
        relativeInfo.relativeScale *= scale;
    }

    public void resetRelativePositioning() {
        if (relativeHistory.isEmpty()) throw new IllegalStateException("History is empty, cannot reset!");

        // pop from stack and update current info
        relativeInfo.set(relativeHistory.pop());
    }

    private void drawAndMaybeFill(Shape s, boolean fill) {
        g2.draw(s);
        if (fill) g2.fill(s);
    }

    public void drawCircle(float x, float y, float radius) {
        drawCircle(x, y, radius, false);
    }

    public void drawCircle(float x, float y, float radius, boolean fill) {
        x = x * relativeInfo.relativeScale + relativeInfo.relativeX;
        y = y * relativeInfo.relativeScale + relativeInfo.relativeY;
        radius = radius * relativeInfo.relativeScale;
        drawAndMaybeFill(new Ellipse2D.Float(x - radius, y - radius, radius * 2, radius * 2), fill);
    }

    public void drawCircle(float x, float y, float radius, float start, float end) {
        drawCircle(x, y, radius, start, end, false);
    }

    public void drawCircle(float x, float y, float radius, float start, float end, boolean fill) {
        float extent = end - start;
        x = x * relativeInfo.relativeScale + relativeInfo.relativeX;
        y = y * relativeInfo.relativeScale + relativeInfo.relativeY;
        radius = radius * relativeInfo.relativeScale;
        drawAndMaybeFill(new Arc2D.Float(x - radius, y - radius, radius * 2, radius * 2, start, extent, Arc2D.OPEN), fill);
    }

    public void drawLine(float x1, float y1, float x2, float y2) {
        x1 = x1 * relativeInfo.relativeScale + relativeInfo.relativeX;
        y1 = y1 * relativeInfo.relativeScale + relativeInfo.relativeY;
        x2 = x2 * relativeInfo.relativeScale + relativeInfo.relativeX;
        y2 = y2 * relativeInfo.relativeScale + relativeInfo.relativeY;
        g2.draw(new Line2D.Float(x1, y1, x2, y2));
    }

//    public void drawLine(float x1, float y1, float x2, float y2, float thickness) {
//        drawCircle(x1, y1, thickness, true);
//        drawCircle(x2, y2, thickness, true);
//    }

    private class RelativeInfo {
        private float relativeX;
        private float relativeY;
        private float relativeScale;

        public RelativeInfo() {
            this.relativeX = 0;
            this.relativeY = 0;
            this.relativeScale = 1;
        }

        public RelativeInfo(RelativeInfo info) {
            set(info);
        }

        public void set(RelativeInfo info) {
            this.relativeX = info.relativeX;
            this.relativeY = info.relativeY;
            this.relativeScale = info.relativeScale;
        }
    }
}
