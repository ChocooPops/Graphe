
import java.awt.Color;
import java.awt.Point;

/**
 *
 * @author ch.bonnet
 */
public class Cercle {
    private int x;
    private int y;
    private final int radius;
    private final Color color;
    private boolean dragging;
    private int offsetX;
    private int offsetY;
    private String text;

    public Cercle(int x, int y, int radius, Color color, String text) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.color = color;
        this.dragging = false;
        this.text = text;
    }

    public boolean contains(Point point) {
        int dx = x - point.x;
        int dy = y - point.y;
        return (dx * dx + dy * dy) <= (radius * radius);
    }

    public void move(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getRadius() {
        return radius;
    }

    public Color getColor() {
        return color;
    }
    public boolean isDragging() {
        return dragging;
    }

    public void setDragging(boolean dragging) {
        this.dragging = dragging;
    }

    public int getOffsetX() {
        return offsetX;
    }

    public int getOffsetY() {
        return offsetY;
    }

    public void setOffset(int offsetX, int offsetY) {
        this.offsetX = offsetX;
        this.offsetY = offsetY;
    }
    
    public String getText(){
        return text;
    }
}
