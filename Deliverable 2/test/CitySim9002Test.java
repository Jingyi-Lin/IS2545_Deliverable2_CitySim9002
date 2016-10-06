
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
    public void testInputTwoIntegers() {
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
    // VISITOR NOT LEFT IN FIRST ITERATION TESTS (CitySim9002.java)
    // --------------------------------------------------------------
    
    //  For the first visit for a vistor, he cannot leave the city.
    //  Give location as "left"
    //  firstVisit method return true to indicate it needs another random generated location.
    @Test
    public void testLeft(){
        Mockito.when(mockedRandomNumber.generateNumber()).thenReturn(4);
        assertTrue(cs.firstVisit(location.getLocation(mockedRandomNumber.generateNumber())));
    }
 
}
