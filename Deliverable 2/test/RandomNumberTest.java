
import Program.CitySim9002;
import Program.Location;
import Program.RandomNumber;
import Program.Visitor;
import org.junit.After;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import org.mockito.*;


/**
 *
 * @author JYee
 */
public class RandomNumberTest {
    
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
    // RANDOM GENERATOR TESTS (RandomNumber.java)
    // --------------------------------------------------------------
    
    //  Set seed is 9, count is 5.
    //  The generateNumber method gives the numbers in a range of [0, 5).
    @Test
    public void testRandomGenerator(){
        RandomNumber r = new RandomNumber(9, 5);
        assertTrue(r.generateNumber() >= 0 && r.generateNumber() < 5);
    }   
    
}
