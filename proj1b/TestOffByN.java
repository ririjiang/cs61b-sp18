import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByN {
    CharacterComparator test = new OffByN(5);
    @Test
    public void testequalChars(){
        assertTrue(test.equalChars('a','f'));
    }


}
