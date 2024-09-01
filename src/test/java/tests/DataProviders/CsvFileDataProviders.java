package tests.DataProviders;

import com.opencsv.CSVReader;
import org.testng.annotations.DataProvider;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class CsvFileDataProviders {
    @DataProvider(name = "csvData")
    public Object[][] provideCSVData() throws IOException {
        CSVReader reader = new CSVReader(new FileReader("src/test/resources/testdata.csv"));
        List<String[]> csvData = reader.readAll();
        Object[][] data = new Object[csvData.size()][2];
        for (int i = 0; i < csvData.size(); i++) {
            data[i] = csvData.get(i);
        }
        return data;
    }

    public void main() {
    }
}
