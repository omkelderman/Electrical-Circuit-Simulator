package nl.omkprojects.electricalcircuitsimulator.circuit.graphics;

import java.awt.*;
import java.awt.geom.Arc2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.util.Stack;

public class GraphicsWrapper {
    private final Graphics2D graphics2D;
    private final Stack<DrawPositionInfo> relativeHistory = new Stack<>();
    private final Stack<Color> colorHistory = new Stack<>();
    private DrawPositionInfo relativeDrawPosition;

    public GraphicsWrapper(Graphics2D graphics2D) {
        this(graphics2D, new DrawPositionInfo());
    }

    public GraphicsWrapper(Graphics2D graphics2D, DrawPositionInfo initialDrawPositionInfo) {
        this.graphics2D = graphics2D;
        this.relativeDrawPosition = initialDrawPositionInfo;
    }

    public void setColor(Color c) {
        // push current color to stack
        colorHistory.push(graphics2D.getColor());

        // update current color
        graphics2D.setColor(c);
    }

    public void resetColor() {
        if (colorHistory.isEmpty()) throw new IllegalStateException("History is empty, cannot reset!");

        // pop from stack and update current color
        graphics2D.setColor(colorHistory.pop());
    }

    public void setRelativePositioning(DrawPositionInfo info) {
        // create copy and push in stack
        relativeHistory.push(relativeDrawPosition);

        // update current info
        relativeDrawPosition = DrawPositionInfo.add(relativeDrawPosition, info);
    }

    public void resetRelativePositioning() {
        if (relativeHistory.isEmpty()) throw new IllegalStateException("History is empty, cannot reset!");

        // pop from stack and update current info
        relativeDrawPosition = relativeHistory.pop();
    }

    private void drawAndMaybeFill(Shape s, boolean fill) {
        graphics2D.draw(s);
        if (fill) graphics2D.fill(s);
    }

    public void drawCircle(float x, float y, float diameter) {
        drawEllipse(x, y, diameter, diameter);
    }

    public void drawCircle(float x, float y, float diameter, boolean fill) {
        drawEllipse(x, y, diameter, diameter, fill);
    }

    public void drawEllipse(float x, float y, float width, float height) {
        drawEllipse(x, y, width, height, false);
    }

    public void drawEllipse(float x, float y, float width, float height, boolean fill) {
        XY xy = relativeDrawPosition.getAbsoluteXY(x, y);
        width = relativeDrawPosition.getAbsoluteScale(width);
        height = relativeDrawPosition.getAbsoluteScale(height);

        Ellipse2D.Float ellipse = new Ellipse2D.Float(xy.x - (width / 2), xy.y - (height / 2), width, height);
        drawAndMaybeFill(ellipse, fill);
    }

    public void drawCircle(float x, float y, float diameter, float startAngle, float endAngle) {
        drawEllipse(x, y, diameter, diameter, startAngle, endAngle, false);
    }

    public void drawCircle(float x, float y, float diameter, float startAngle, float endAngle, boolean fill) {
        drawEllipse(x, y, diameter, diameter, startAngle, endAngle, fill);
    }

    public void drawEllipse(float x, float y, float width, float height, float startAngle, float endAngle) {
        drawEllipse(x, y, width, height, startAngle, endAngle, false);
    }

    public void drawEllipse(float x, float y, float width, float height, float startAngle, float endAngle, boolean fill) {
        startAngle = -relativeDrawPosition.getAbsoluteAngle(startAngle) + 90;
        endAngle = -relativeDrawPosition.getAbsoluteAngle(endAngle) + 90;
        float extentAngle = endAngle - startAngle;

        XY xy = relativeDrawPosition.getAbsoluteXY(x, y);
        width = relativeDrawPosition.getAbsoluteScale(width);
        height = relativeDrawPosition.getAbsoluteScale(height);

        Arc2D.Float arc = new Arc2D.Float(xy.x - (width / 2), xy.y - (height / 2), width, height, startAngle, extentAngle, Arc2D.OPEN);
        drawAndMaybeFill(arc, fill);
    }

    public void drawLine(float x1, float y1, float x2, float y2) {
        XY xy1 = relativeDrawPosition.getAbsoluteXY(x1, y1);
        XY xy2 = relativeDrawPosition.getAbsoluteXY(x2, y2);
        graphics2D.draw(new Line2D.Float(xy1.x, xy1.y, xy2.x, xy2.y));
    }

//    public void drawLine(float x1, float y1, float x2, float y2, float thickness) {
//        drawCircle(x1, y1, thickness, true);
//        drawCircle(x2, y2, thickness, true);
//    }

}
