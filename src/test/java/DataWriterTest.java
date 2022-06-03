import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.util.List;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.*;

class DataWriterTest {
    static final Logger logger = Logger.getLogger(DataWriterTest.class.getName());
    private String filePath;
    private List<String[]> list;
    private File file;

    @BeforeEach
    void init() {
        logger.info("startup");
        filePath = "src/test/resourcesTest/data.xml";
        list = DataReader.readData("src/test/resourcesTest/validData.csv");
        file = new File(filePath);
        DataWriter.writeDataToXML(list, filePath);
    }

    @AfterEach
    void teardown() {
        logger.info("teardown\n");
        filePath = null;
        list.clear();
        file.delete();
    }

    @Test
    void checkIfFileIsCreatedAfterCallingMethodWriteDataToXML() {
        logger.info("executing test");
        assertTrue(file.exists());
    }

    @Test
    void checkIfWrittenFileHasData() {
        logger.info("executing test");
        assertTrue(file.length()!=0);
    }

}