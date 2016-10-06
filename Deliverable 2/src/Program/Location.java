package Program;

import java.util.HashMap;

/**
 *
 * @author Jingyi Lin (jil173)
 */

public class Location {
	HashMap<Integer, String> loc = new HashMap<>();
        
        //  Put all location options into a hashmap.
        //  Assign keys from 0 to 3 to four locations
        //  and assign 4 to left.
	public Location(){
            loc.put(0, "The Cathedral of Learning");
            loc.put(1, "Squirrel Hill");
            loc.put(2, "The Point");
            loc.put(3, "Downtown");	
            loc.put(4, "left");
	}
	
	public String getLocation(int i){
            return loc.get(i);
	}
}
