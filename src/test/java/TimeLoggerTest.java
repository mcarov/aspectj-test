import org.junit.jupiter.api.Test;
import ru.cbr.service.User;

public class TimeLoggerTest {
    @Test
    public void logExecutionTimeTest() throws InterruptedException {
        User user = new User(30, "Dmitry");
        user.getData();
    }
}
