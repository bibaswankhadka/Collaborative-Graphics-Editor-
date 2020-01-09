import java.util.Set;
import java.util.TreeMap;

public class Sketch {
	TreeMap<Integer, Shape> sketch;
	
	public Sketch() {
		 sketch = new TreeMap<Integer, Shape>();
	}
	
	public synchronized void addshape(Integer id, Shape shape) {
		sketch.put(id, shape);
	}
	
	public synchronized Shape getshape(Integer id) {
		return sketch.get(id);
	}
	
	public void removeshape(Integer id) {
		sketch.remove(id);
	}
	
	public synchronized Set<Integer> descendingkeyset(){
		return sketch.descendingKeySet();
	}
	
	public synchronized Set<Integer> lowtohigh(){
		return sketch.navigableKeySet();
	}
	
	public synchronized boolean isnew() {
		return sketch.isEmpty();
	}

	

}
