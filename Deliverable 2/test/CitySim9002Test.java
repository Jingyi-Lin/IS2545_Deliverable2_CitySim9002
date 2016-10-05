
import Program.CitySim9002;
import Program.Location;
import Program.RandomNumber;
import Program.Visitor;
import org.junit.After;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.mockito.*;

/**
 *
 * @author Jingyi Lin (jil173)
 */

public class CitySim9002Test {

    @Mock
    Visitor mockedVisitor = Mockito.mock(Visitor.class);
    Location mockedLocation = Mockito.mock(Location.class); 
    RandomNumber mockedRandomNumber = Mockito.mock(RandomNumber.class);
    
    Visitor visitor = new Visitor();
    Location location = new Location();
    RandomNumber randomNumber = new RandomNumber(7, 5);
    
    @Before
    public void setUp() throws Exception {
        // If you use @Mock, you need to do this
        MockitoAnnotations.initMocks(mockedVisitor);
        MockitoAnnotations.initMocks(mockedLocation);
    }

    @After
    public void tearDown() throws Exception {
        
    }	

    // --------------------------------------------------------------
    // VALID INTEGER TESTS (CitySim9002.java)
    // --------------------------------------------------------------
    
    //  The program can only accept an integer as argument,
    //  use a string array to test validator class.
    //  The validator cannot pass this argument.
    @Test
    public void testInputString() {
        CitySim9002 cs = new CitySim9002();
        String[] a = {"a"};
        assertFalse(cs.validArgument(a));
    } 
    
    //  The program can only accept an integer as argument,
    //  use a null value to test validator class.
    //  The validator cannot pass this argument.
    @Test
    public void testInputNull() {
        CitySim9002 cs = new CitySim9002();
        String[] a = {""};
        assertFalse(cs.validArgument(a));
    } 
    
    //  The program can only accept an integer as argument,
    //  use several integers to test validator class.
    //  The validator cannot pass this argument.
    @Test
    public void testInputTwoInteger() {
        CitySim9002 cs = new CitySim9002();
        String[] a = {"1", "2"};
        assertFalse(cs.validArgument(a));
    }
    
    //  The program can only accept an integer as argument,
    //  use one integer to test validator class.
    //  The validator pass this argument.
    @Test
    public void testInputOneInteger() {
        CitySim9002 cs = new CitySim9002();
        String[] a = {"0"};
        assertTrue(cs.validArgument(a));
    }
    
    // --------------------------------------------------------------
    // VISITOR PREFERENCE TESTS (Visitor.java)
    // --------------------------------------------------------------
    
    //  Student has preference -- dislike "The Cathedral of Learning".
    @Test
    public void testStudentPreference_CL(){
        String visitor = "Student";
        String location = "The Cathedral of Learning";
        assertFalse(this.visitor.likeLoc(visitor, location));
    }
    
    //  Professor has preference -- like "The Cathedral of Learning".
    @Test
    public void testProfessorPreference_CL(){
        String visitor = "Professor";
        String location = "The Cathedral of Learning";
        assertTrue(this.visitor.likeLoc(visitor, location));
    }
    
    //  Blogger has preference -- dislike "The Cathedral of Learning".
    @Test
    public void testBloggerPreference_CL(){
        String visitor = "Blogger";
        String location = "The Cathedral of Learning";
        assertFalse(this.visitor.likeLoc(visitor, location));
    }
    
    //  Business Person has preference -- dislike "The Cathedral of Learning".
    @Test
    public void testBusinessPreference_CL(){
        String visitor = "Business Person";
        String location = "The Cathedral of Learning";
        assertFalse(this.visitor.likeLoc(visitor, location));
    }
    
    // ----------------------------------------------------------------------
    // GENERATE RANDOM VISITOR LIST TESTS (Visitor.java & RandomNumber.java)
    // ----------------------------------------------------------------------
    
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
        int[] index = {1, 3, 2, 0, 2};
        Mockito.when(mockedRandomNumber.generateNumber()).thenReturn(1);
        Mockito.when(mockedRandomNumber.generateNumber()).thenReturn(3);
        Mockito.when(mockedRandomNumber.generateNumber()).thenReturn(2);
        Mockito.when(mockedRandomNumber.generateNumber()).thenReturn(0);
        Mockito.when(mockedRandomNumber.generateNumber()).thenReturn(2);
        String[] visitorList = this.visitor.generateVisitorList(mockedRandomNumber);
        String[] visitor = {"Professor", "Blogger", "Business Person", "Student", "Business Person"};
        assertArrayEquals(visitor, visitorList);
    }
    
    // --------------------------------------------------------------
    // GENERATE RANDOM LOCATION TESTS (Location.java)
    // --------------------------------------------------------------
    
    //  Each location has index in array.
    //  Assign a value of 2 to getLocation function,
    //  Equals "The Point", which has index of 2.  
    @Test
    public void testEqualLocation(){
        int locationIndex = 2;
        assertEquals("The Point", location.getLocation(locationIndex));
    }
    
    //  Each location has index in array.
    //  Assign a value of 1 to getLocation function,
    //  Equals "Squirrel Hill", which has index of 1, so not eqaul to "Downtown".
    @Test
    public void testNotEqualLocation(){
        int locationIndex = 1;
        assertNotEquals("Downtown", location.getLocation(locationIndex));
    }
    
    // --------------------------------------------------------------
    // VISITOR NOT LEFT IN FIRST ITERATION TESTS (CitySim9002.java)
    // --------------------------------------------------------------
    
    @Test
    public void testLeft(){
        Mockito.when(mockedRandomNumber.generateNumber()).thenReturn(4);
        assertEquals("left", location.getLocation(4));
    }
    
    
}
