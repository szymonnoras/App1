import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.util.List;

public class Main {

    //extracts data from CSV file and writes it to XML file.
    static void writeData(String pathCSV, String pathXML){
        List<String[]> data = DataReader.readData(pathCSV);
        DataWriter.writeDataToXML(data, pathXML);
    }

    public static void main(String[] args) throws ParserConfigurationException {
        String pathCSV = "src/main/resources/data.csv";
        String pathXML ="src/main/resources/data.xml";
        writeData(pathCSV,pathXML);
    }
}
