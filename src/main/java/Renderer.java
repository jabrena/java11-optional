import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.function.Consumer;
import java.util.stream.Stream;

/**
 * Created by mtumilowicz on 2018-11-08.
 */
public class Renderer {
    public static void page(String value) {
        render("src/test/resources/Page.txt", line ->
                System.out.println(line.contains("XX") ? line.replace("XX", value) : line));
    }

    public static void empty() {
        render("src/test/resources/EmptyPage.txt", System.out::println);
    }

    private static void render(String path, Consumer<String> draw) {
        try (final Stream<String> lines = Files.lines(Paths.get(path))) {
            lines.forEach(draw);
        } catch (IOException e) {
            System.out.println("Exception: " + e.getLocalizedMessage());
        }
    }
}
