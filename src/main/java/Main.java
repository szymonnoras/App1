import java.util.List;

public class Main {

    public static void main(String[] args) {
        String path="src/main/resources/data.csv";
        List<String[]> data=DataReader.readData(path);
        DataReader.printData(data);
        DataReader.readData("asd");
    }
}
