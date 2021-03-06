import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class CSVWriterForStepCount {
    public static void createCSVFile(String fileName, ArrayList<CSVInputForStepCount> csvInputForStepCounts) {

        try (PrintWriter writer = new PrintWriter(new File(fileName))) {
            StringBuilder sb = new StringBuilder();
            sb.append("Source Name,Source Version,Creation Date,Value");
            sb.append('\n');

            for (CSVInputForStepCount input : csvInputForStepCounts) {
                sb.append(input.getSourceName());
                sb.append(',');
                sb.append(input.getSourceVersion());
                sb.append(',');
                sb.append(input.getCreationDate());
                sb.append(',');
                sb.append(input.getValue());
                sb.append('\n');
            }

            writer.write(sb.toString());

            System.out.println("CSV File created!");
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}