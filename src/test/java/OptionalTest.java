import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.stream.Stream;

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
        Optional.<String>empty().ifPresentOrElse(OptionalTest::renderPage, OptionalTest::renderEmpty);
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
        Optional.of("10").ifPresentOrElse(OptionalTest::renderPage, OptionalTest::renderEmpty);
    }

    private static void renderPage(String value) {
        try (final Stream<String> lines = Files.lines(Paths.get("src/test/resources/Page.txt"))) {
            lines.forEach(x ->
                    System.out.println(x.contains("XX") ? x.replace("XX", value) : x)
            );
        } catch (IOException e) {
            System.out.println("Exception: " + e.getLocalizedMessage());
        }
    }

    private static void renderEmpty() {
        try (final Stream<String> lines = Files.lines(Paths.get("src/test/resources/EmptyPage.txt"))) {
            lines.forEach(System.out::println);
        } catch (IOException e) {
            System.out.println("Exception: " + e.getLocalizedMessage());
        }
    }
}
