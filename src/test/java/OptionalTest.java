import org.junit.Test;

import java.util.Optional;

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
}
