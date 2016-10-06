
import Program.CitySim9002;
import Program.Location;
import Program.RandomNumber;
import Program.Visitor;
import org.junit.After;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import org.mockito.*;


/**
 *
 * @author JYee
 */
public class VisitorTest {
    
    @Mock
    Visitor mockedVisitor = Mockito.mock(Visitor.class);
    Location mockedLocation = Mockito.mock(Location.class); 
    RandomNumber mockedRandomNumber = Mockito.mock(RandomNumber.class);
    
    CitySim9002 cs = new CitySim9002();
    Visitor visitor = new Visitor();
    Location location = new Location();
    RandomNumber randomNumber = new RandomNumber(7, 5);
    
    @Before
    public void setUp() throws Exception {
        // If you use @Mock, you need to do this
        MockitoAnnotations.initMocks(mockedVisitor);
        MockitoAnnotations.initMocks(mockedLocation);
        MockitoAnnotations.initMocks(mockedRandomNumber);
    }

    @After
    public void tearDown() throws Exception {
        
    }	
    
    // --------------------------------------------------------------
    // VISITOR PREFERENCE TESTS (Visitor.java)
    // --------------------------------------------------------------
    
    //  Student has preference -- dislike "The Cathedral of Learning".
    @Test
    public void testStudentPreference_CL(){
        Mockito.when(mockedLocation.getLocation(0)).thenReturn("The Cathedral of Learning");
        String visitor = "Student";
        assertFalse(this.visitor.likeLoc(visitor, mockedLocation.getLocation(0)));
    }
    
    //  Professor has preference -- like "The Cathedral of Learning".
    @Test
    public void testProfessorPreference_CL(){
        Mockito.when(mockedLocation.getLocation(0)).thenReturn("The Cathedral of Learning");
        String visitor = "Professor";
        assertTrue(this.visitor.likeLoc(visitor, mockedLocation.getLocation(0)));
    }
    
    //  Blogger has preference -- dislike "The Cathedral of Learning".
    @Test
    public void testBloggerPreference_CL(){
        Mockito.when(mockedLocation.getLocation(0)).thenReturn("The Cathedral of Learning");
        String visitor = "Blogger";
        assertFalse(this.visitor.likeLoc(visitor, mockedLocation.getLocation(0)));
    }
    
    //  Business Person has preference -- dislike "The Cathedral of Learning".
    @Test
    public void testBusinessPreference_CL(){
        Mockito.when(mockedLocation.getLocation(0)).thenReturn("The Cathedral of Learning");
        String visitor = "Business Person";
        assertFalse(this.visitor.likeLoc(visitor, mockedLocation.getLocation(0)));
    }
    
    // -------------------------------------------------------------
    // GENERATE RANDOM VISITOR LIST TESTS (Visitor.java)
    // -------------------------------------------------------------
    
    //  Each visitor has index in array.
    //  Generate 0 as the random number, call generateVisitorList function
    //  "Student" has an index of 0, so return an array full of "Student".
    @Test
    public void testRandomList_Single(){
        Mockito.when(mockedRandomNumber.generateNumber()).thenReturn(0);
        String[] visitorList = this.visitor.generateVisitorList(mockedRandomNumber);
        String[] visitor = {"Student", "Student", "Student", "Student", "Student"};
        assertArrayEquals(visitor, visitorList);
    }
    
    //  Each visitor has index in array.
    //  "Student" has index of 0, "Professor" has index of 1, 
    //  "Business Person" has index of 2, "Blogger" has index of 3.
    //  Set randomly generate number as {1,3,2,0,2}.
    //  According visitor type will return - "Professor", "Business Person", "Blogger", "Student", "Blogger".
     @Test
    public void testRandomList_Multiple(){
        int[] visitorIndex = new int[5];
        String[] visitorList = new String[5];
        
        Mockito.when(mockedRandomNumber.generateNumber()).thenReturn(1);
        visitorIndex[0] = mockedRandomNumber.generateNumber();
        visitorList[0] = visitor.visitors.get(visitorIndex[0]);
        
        Mockito.when(mockedRandomNumber.generateNumber()).thenReturn(3);
        visitorIndex[1] = mockedRandomNumber.generateNumber();
        visitorList[1] = visitor.visitors.get(visitorIndex[1]);
        
        Mockito.when(mockedRandomNumber.generateNumber()).thenReturn(2);
        visitorIndex[2] = mockedRandomNumber.generateNumber();
        visitorList[2] = visitor.visitors.get(visitorIndex[2]);        
        
        Mockito.when(mockedRandomNumber.generateNumber()).thenReturn(0);
        visitorIndex[3] = mockedRandomNumber.generateNumber();
        visitorList[3] = visitor.visitors.get(visitorIndex[3]);
        
        Mockito.when(mockedRandomNumber.generateNumber()).thenReturn(2);
        visitorIndex[4] = mockedRandomNumber.generateNumber();
        visitorList[4] = visitor.visitors.get(visitorIndex[4]);
        
        String[] visitor = {"Professor", "Blogger", "Business Person", "Student", "Business Person"};
        assertArrayEquals(visitor, visitorList);
    }    
        
}
