import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.logging.Logger;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class DataReaderTest {

    static final Logger logger = Logger.getLogger(DataReaderTest.class.getName());
    private String validData;
    private String invalidData;

    @BeforeEach
    void init() {
        logger.info("startup");
        validData = "src/test/resourcesTest/validData.csv";
        invalidData = "src/test/resourcesTest/invalidData.csv";
    }

    @AfterEach
    void teardown() {
        logger.info("teardown\n");
        validData = null;
        invalidData = null;
    }

    @Test
    void readDataReturnsNotNullValueFromValidData() {
        logger.info("executing test");
        assertFalse(DataReader.readData(validData).isEmpty());
    }

    @Test
    void validateDataThrowsExceptionForInvalidData() {
        logger.info("executing test");
        assertThrows(IllegalArgumentException.class, () -> DataReader.validateData(invalidData));
    }

    @Test
    void validateDataReturnsValueForValidData(){
        logger.info("executing test");
        assertFalse(DataReader.readData(validData).isEmpty());
    }
}