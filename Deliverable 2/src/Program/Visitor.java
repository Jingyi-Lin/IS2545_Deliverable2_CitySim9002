package Program;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Jingyi Lin (jil173)
 */

public class Visitor {
	
	static final int visitorNumber = 5;
	List<String> visitors = new ArrayList<>();
	HashMap<String, List<String>> people = new HashMap<>();
	
	public Visitor(){
            //  Add four visitor types into a list.
            visitors.add("Student");
            visitors.add("Professor");
            visitors.add("Business Person");
            visitors.add("Blogger");
            
            //  Add each visitor's preferences.
            List<String> studentLikeLoc = new ArrayList<String>();
            studentLikeLoc.add("Squirrel Hill");
            studentLikeLoc.add("Downtown");
            studentLikeLoc.add("The Point");

            List<String> professorLikeLoc = new ArrayList<String>();
            professorLikeLoc.add("Squirrel Hill");
            professorLikeLoc.add("Downtown");
            professorLikeLoc.add("The Point");
            professorLikeLoc.add("The Cathedral of Learning");

            List<String> businessLikeLoc = new ArrayList<String>();
            businessLikeLoc.add("Squirrel Hill");
            businessLikeLoc.add("Downtown");

            List<String> bloggerLikeLoc = new ArrayList<String>();
            
            //  Put visitor type and corresponding preference into a hashmap.
            //  Use visitor type as key, preference as value.
            people.put("Student", studentLikeLoc);
            people.put("Professor", professorLikeLoc);
            people.put("Business Person", businessLikeLoc);
            people.put("Blogger", bloggerLikeLoc);
	}
	
        //  Use RandomNumber generator to get an array of randomly got visitors. 
	public String[] generateVisitorList(RandomNumber generator){
            String[] visitorGenerator = new String[visitorNumber]; 
          
            for(int i = 0; i < visitorNumber; i++){
                int visitorIndex = generator.generateNumber();
                visitorGenerator[i] = visitors.get(visitorIndex);
            }
            return visitorGenerator;
	}
        
        //  Check visitors' preferences.
	public boolean likeLoc(String visitor, String location){
            return people.get(visitor).contains(location);
	}
	
}
