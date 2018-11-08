import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by mtumilowicz on 2018-11-08.
 */
public class OptionalTest {
    
    /*
    ====================
    |                  |
    |      EMPTY       |
    |                  | 
    ====================
     */
    @Test
    public void ifPresentOrElse_optionalEmpty() {
        Optional.<String>empty().ifPresentOrElse(Renderer::page, Renderer::empty);
    }

    /*
    ====================
    |                  |
    |        10        |
    |                  | 
    ====================
     */
    @Test
    public void ifPresentOrElse_optionalNotEmpty() {
        Optional.of("10").ifPresentOrElse(Renderer::page, Renderer::empty);
    }
    
    @Test
    public void isEmpty_empty() {
        assertTrue(Optional.empty().isEmpty());
    }

    @Test
    public void isEmpty_notEmpty() {
        assertFalse(Optional.of("not empty").isEmpty());
    }
}
