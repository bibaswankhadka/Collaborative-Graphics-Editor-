import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

/**
 * A multi-segment Shape, with straight lines connecting "joint" points -- (x1,y1) to (x2,y2) to (x3,y3) ...
 * @author bibaswankhadka
 */
public class Polyline implements Shape {
	private Color color;
	private ArrayList<Segment> polyline = new ArrayList<Segment>();  // Make list of segments 
	
	public Polyline(int x1, int y1, Color color) {
		this.color = color;
		polyline.add(new Segment(x1,y1,color));
	}

	
	public Polyline(int x1, int y1, int x2, int y2, Color color) {
		this.color = color;
		double dist = Segment.dist2(x1, y1, x2, y2);
		if (dist > 20) {
			polyline.add(new Segment(x1,y1,x2,y2,this.color));
		}
	}
	
	@Override
	public void moveBy(int dx, int dy) {
		for (Segment s:polyline) {
			s.moveBy(dx, dy);
		}
	}

	@Override
	public Color getColor() {
		return color;
	}

	@Override
	public void setColor(Color color) {
		for (Segment s:polyline) {
			s.setColor(color);
		}
	}
	
	@Override
	public boolean contains(int x, int y) {
		for (Segment s:polyline) {
			if (s.contains(x, y)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public void draw(Graphics g) {
		for (Segment s:polyline) {
			s.draw(g);
		}
	}

	@Override
	public String toString() {
		String tostring = "";
		for (Segment s:polyline) {
			tostring += s.toString();
		}
		return tostring;
	}
}
