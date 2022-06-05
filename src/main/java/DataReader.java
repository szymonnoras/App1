import com.opencsv.CSVReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class DataReader extends Exception {

    /**
     * Returns data read from file as a list of arrays of strings.
     *
     * @param path a path of CSV file to read data from
     * @return list of arrays of strings containing data from file
     */

    public static List<String[]> readData(String path) {
        List<String[]> allData = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(path);
            CSVReader csvReader = new CSVReader(fileReader);
            allData = csvReader.readAll();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return allData;
    }

    /**
     * This method checks if the data in file is valid, but only checks for
     * empty values and file must have proper number of commas between values.
     * If there is empty value it throws proper exception with position of invalid value.
     *
     * @param path a path of CSV file to read data from
     * @return list of arrays of strings containing data from file
     */
    public static List<String[]> validateData(String path){
        List<String[]> allData=readData(path);
        for (int i = 0; i < allData.size(); i++) {
            for (int j = 0; j < 3; j++) {
                if (allData.get(i)[j].isEmpty()) {
                    throw new IllegalArgumentException("Found no data in column: " + allData.get(0)[j] + ", row: " + (i + 1));
                }
            }
        }
        return allData;
    }

}