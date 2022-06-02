import com.opencsv.CSVReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class DataReader extends Exception {

    /**
     * Returns tidy data read from file as a list of arrays of strings.
     * This method checks if the data in file is valid, but only checks for
     * empty values and file must have proper number of commas between values.
     * If there is empty value it throws proper exception with position of invalid value.
     * @param path a path of CSV file to read data from
     * @return list of arrays of strings containing data from file
     */
    public static List<String[]> readData(String path) {
        List<String[]> allData = new ArrayList<>();
        boolean notValidData=false;
        try {
            FileReader fileReader = new FileReader(path);
            CSVReader csvReader = new CSVReader(fileReader);
            allData = csvReader.readAll();
            for (int i = 0; i < allData.size(); i++) {
                for (int j = 0; j < 3; j++) {
                    if (allData.get(i)[j].isEmpty()) {
                        notValidData=true;
                        throw new IllegalArgumentException("Found no data in column: " + allData.get(0)[j] + ", row: " + (i + 1));
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(notValidData){
                allData.clear();
            }
        }
        return allData;
    }

    public static void printData(List<String[]> data){
        for (String[] row : data) {
            for (String cell : row) {
                System.out.print(cell+" ");
            }
            System.out.println();
        }
    }
}