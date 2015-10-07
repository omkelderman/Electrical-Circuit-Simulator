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

    public static DrawPositionInfo add(DrawPositionInfo base, DrawPositionInfo add) {
        return new DrawPositionInfo(base.x + add.x * base.scale, base.y + add.y * base.scale, base.scale * add.scale, base.angle + add.angle);
    }
}
