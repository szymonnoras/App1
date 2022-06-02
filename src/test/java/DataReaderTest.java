import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class DataReaderTest {

    final String validData = "src/test/resourcesTest/validData.csv";
    final String invalidData = "src/test/resourcesTest/invalidData.csv";

    @Test
    void readDataReturnsNotNullValueFromValidData() {
        assertFalse(DataReader.readData(validData).isEmpty());
    }

    @Test
    void readDataThrowsExceptionForInvalidData() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> DataReader.readData(invalidData));
    }

}