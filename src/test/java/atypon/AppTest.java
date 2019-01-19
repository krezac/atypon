package atypon;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Unit test for simple App.
 */
public class AppTest {
    /**
     * Rigorous Test.
     */
    @Test
    public void testAppValidInput() {
        assertEquals("4:2,2:1,5:2,1:1,,,6:1", new Tree("4,2,5,5,6,1,4").printTree());
        assertEquals("4:2,2:1,5:2,1:1,,,6:1", new Tree("4 , 2,5, 5 ,6, 1,4").printTree());
    }

    @Test
    public void testAppEmptyInput() {
        try {
            new Tree("").printTree();
            assertTrue(false);
        } catch(NumberFormatException e) {

        }
    }

    @Test
    public void testAppInvalidInput() {
        try {
            new Tree("ab,cd").printTree();
            assertTrue(false);
        } catch(NumberFormatException e) {

        }
    }
}
