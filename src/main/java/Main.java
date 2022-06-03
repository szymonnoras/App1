import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.util.List;

public class Main {

    //extracts data from CSV file and writes it to XML file.
    static void writeData(String path){
        List<String[]> data = DataReader.readData(path);
        DataWriter.writeDataToXML(data, "src/main/resources/data.xml");
    }

    public static void main(String[] args) throws ParserConfigurationException {
        String pathCSV = "src/main/resources/data.csv";

        writeData(pathCSV);
    }
}
