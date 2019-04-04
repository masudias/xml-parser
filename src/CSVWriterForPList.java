import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class CSVWriterForPList {
    public static void createCSVFile(String fileName, ArrayList<CSVInputForPList> csvInputForPLists) {

        try (PrintWriter writer = new PrintWriter(new File(fileName))) {
            StringBuilder sb = new StringBuilder();
            sb.append("BSSID,Last Roamed,Last Joined,Last Auto Joined, Network Usage");
            sb.append('\n');

            for (CSVInputForPList input : csvInputForPLists) {
                sb.append(input.getBSSID());
                sb.append(',');
                sb.append(input.getLastRoamed());
                sb.append(',');
                sb.append(input.getLastJoined());
                sb.append(',');
                sb.append(input.getLastAutoJoined());
                sb.append(',');
                sb.append(input.getNetworkUsage());
                sb.append('\n');
            }

            writer.write(sb.toString());

            System.out.println("CSV File for PList created!");
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}