/**
 * @author bibaswankhadka
 *
 */
import java.awt.Color;
import java.util.Set;

public class Messages {
	
	public static synchronized void getmessage(String str, Sketch sketch) {
		String[] tokens = str.split(" ");
		if (tokens[0].equals("Add")) {
			String shapetype = tokens[1];
			Integer x1= Integer.parseInt(tokens[2]);
			Integer y1= Integer.parseInt(tokens[3]);
			Integer x2= Integer.parseInt(tokens[4]);
			Integer y2= Integer.parseInt(tokens[5]);
			Integer color = Integer.parseInt(tokens[6]);
			Color c = new Color(color);
			Integer movingId = Integer.parseInt(tokens[7]);
			if (shapetype.equals("ellipse")) {
				sketch.addshape(SketchServer.getid(), new Ellipse(x1,y1,x2,y2,c));
			}
			if (shapetype.equals("rectangle")) {
				sketch.addshape(SketchServer.getid(), new Rectangle(x1,y1,x2,y2,c));
			}
			if (shapetype.equals("segment")) {
				sketch.addshape(SketchServer.getid(), new Segment(x1,y1,x2,y2,c));
			}
			if (shapetype.equals("freehand")) {
				sketch.addshape(SketchServer.getid(), new Polyline(x1,y1,x2,y2,c));
			}
		}
		if (tokens[0].equals("moveBy")) {
			String shapetype = tokens[1];
			Integer x1= Integer.parseInt(tokens[2]);
			Integer y1= Integer.parseInt(tokens[3]);
			Integer x2= Integer.parseInt(tokens[4]);
			Integer y2= Integer.parseInt(tokens[5]);
			Integer color = Integer.parseInt(tokens[6]);
			Color c = new Color(color);
			Integer dx = Integer.parseInt(tokens[7]);
			Integer dy = Integer.parseInt(tokens[8]);
			Integer movingId = Integer.parseInt(tokens[9]);
			if (shapetype.equals("ellipse")) {
				sketch.getshape(movingId).moveBy(dx,dy);
			}
			if (shapetype.equals("rectangle")) {
				sketch.getshape(movingId).moveBy(dx,dy);
			}
			if (shapetype.equals("segment")) {
				sketch.getshape(movingId).moveBy(dx,dy);
			}
			if (shapetype.equals("polyline")) {
				sketch.getshape(movingId).moveBy(dx,dy);
			}
		}
		if (tokens[0].equals("remove")) {
			Integer movingId = Integer.parseInt(tokens[1]);
			sketch.removeshape(movingId);
		}
		if (tokens[0].equals("reColor")) {
			Integer color = Integer.parseInt(tokens[1]);
			Color c = new Color(color);
			Integer movingId = Integer.parseInt(tokens[2]);
			sketch.getshape(movingId).setColor(c);
		}
		
	}

	public static void main(String[] args) {

		// TODO Auto-generated method stub

	}

}
