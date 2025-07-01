import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;


public class SecondTest {

    Logger logger = LogManager.getLogger(SecondTest.class);

    @Test
    public void firstTest() {
        logger.info("Info");
        logger.debug("Debug");
    }
}
