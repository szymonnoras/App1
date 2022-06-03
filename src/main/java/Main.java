import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws ParserConfigurationException {
        String path="src/main/resources/data.csv";
        String pathXML="src/main/resources/dataaa.xml";
        List<String[]> data=DataReader.readData(path);
        //DataReader.printData(data);
        //DataReader.readData("asd");
        DataWriter.writeDataToXML(data,pathXML);
    }
}
