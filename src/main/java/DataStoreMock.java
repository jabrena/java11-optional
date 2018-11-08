import java.util.Objects;
import java.util.Optional;

/**
 * Created by mtumilowicz on 2018-11-08.
 */
public class DataStoreMock {
    public static Optional<String> findByName(String name) {
        return Objects.equals(name, "name") ? Optional.of("foundByName") : Optional.empty();
    }

    public static Optional<String> findById(int id) {
        return id == 5 ? Optional.of("foundById") : Optional.empty();
    }
}
