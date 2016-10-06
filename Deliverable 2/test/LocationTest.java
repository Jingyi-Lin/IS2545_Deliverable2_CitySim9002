
import Program.CitySim9002;
import Program.Location;
import Program.RandomNumber;
import Program.Visitor;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import org.junit.Before;
import org.junit.Test;
import org.mockito.*;


/**
 *
 * @author JYee
 */
public class LocationTest {
    
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
    // GENERATE RANDOM LOCATION TESTS (Location.java)
    // --------------------------------------------------------------
    
    //  Each location has index in array.
    //  Assign a value of 2 to getLocation function,
    //  Equals "The Point", which has index of 2.  
    @Test
    public void testEqualLocation(){
        Mockito.when(mockedRandomNumber.generateNumber()).thenReturn(2);
        assertEquals("The Point", location.getLocation(mockedRandomNumber.generateNumber()));
    }
    
    //  Each location has index in array.
    //  Assign a value of 1 to getLocation function,
    //  Equals "Squirrel Hill", which has index of 1, so not eqaul to "Downtown".
    @Test
    public void testNotEqualLocation(){
        Mockito.when(mockedRandomNumber.generateNumber()).thenReturn(1);
        assertNotEquals("Downtown", location.getLocation(mockedRandomNumber.generateNumber()));
    }
    
}
