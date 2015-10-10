package nl.omkprojects.electricalcircuitsimulator.circuit.graphics;

/**
 * Created by Olle on 07-10-2015.
 */
public class DrawPositionInfo {
    public float x;
    public float y;
    public float scale;
    public float angle;

    public DrawPositionInfo() {
        this.x = 0;
        this.y = 0;
        this.scale = 1;
        this.angle = 0;
    }


    public DrawPositionInfo(float x, float y) {
        this(x, y, 1, 0);
    }

    public DrawPositionInfo(float x, float y, float scale, float angle) {
        this.x = x;
        this.y = y;
        this.scale = scale;
        this.angle = angle;
    }

    public float getAbsoluteScale(float f) {
        return f * this.scale;
    }

    public float getAbsoluteAngle(float a) {
        return a + this.angle;
    }

    public XY getAbsoluteXY(float x, float y) {
        double angle = Math.atan2(y, x) + Math.toRadians(this.angle);
        double radius = Math.sqrt(x * x + y * y);
        x = getAbsoluteScale((float) (Math.cos(angle) * radius)) + this.x;
        y = getAbsoluteScale((float) (Math.sin(angle) * radius)) + this.y;
        return new XY(x, y);
    }

    public static DrawPositionInfo add(DrawPositionInfo base, DrawPositionInfo add) {
        XY xy = base.getAbsoluteXY(add.x, add.y);
        return new DrawPositionInfo(xy.x, xy.y, base.getAbsoluteScale(add.scale), base.getAbsoluteAngle(add.angle));
    }

    public static class XY {
        float x;
        float y;

        public XY(float x, float y) {
            this.x = x;
            this.y = y;
        }
    }
}
