import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.List;

public class DataWriter {
    /**
     * Converts List of arrays of String which contains data of business cards to Document object in XML
     *
     * @param data contains data extracted from csv file.
     * @return returns Document object which is ready to be used as XML
     * @throws ParserConfigurationException
     */
    private static Document convertListToDocumentXML(List<String[]> data) {

        DocumentBuilderFactory factory;
        DocumentBuilder builder = null;
        try {
            factory = DocumentBuilderFactory.newInstance();
            builder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }

        Document document = null;

        if (builder != null) {
            document = builder.newDocument();

            Element rootElement = document.createElement("cards");
            document.appendChild(rootElement);

            for (int i = 1; i < data.size(); i++) {
                Element card = document.createElement("card");
                rootElement.appendChild(card);

                Element name = document.createElement("name");
                name.appendChild(document.createTextNode(data.get(i)[0]));
                card.appendChild(name);

                Element surname = document.createElement("surname");
                surname.appendChild(document.createTextNode(data.get(i)[1]));
                card.appendChild(surname);

                Element phone = document.createElement("phone");
                phone.appendChild(document.createTextNode(data.get(i)[2]));
                card.appendChild(phone);
            }
        }

        return document;
    }

    public static void writeDataToXML(List<String[]> data, String path) {
        Document document = convertListToDocumentXML(data);
        try (FileOutputStream outputStream = new FileOutputStream(path)) {
            writeXml(document, outputStream);
            System.out.println("XML file written to path: "+path);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void writeXml(Document document, OutputStream output) throws TransformerException {
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();

        transformer.setOutputProperty(OutputKeys.INDENT, "yes");

        DOMSource source = new DOMSource(document);
        StreamResult result = new StreamResult(output);

        transformer.transform(source, result);
    }

}
