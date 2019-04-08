import xmlwise.Plist;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class ReadInfoPlist {

    public static void main(String argv[]) {

        try {
            Map<String, Object> properties = Plist.load("com.apple.wifi.plist");

            ArrayList<Object> listOfKnownNetworks = (ArrayList<Object>) properties.get("List of known networks");
            ArrayList<CSVInputForPList> csvInputForPLists = new ArrayList<CSVInputForPList>();

            for (Object obj : listOfKnownNetworks) {
                System.out.println(obj);

                HashMap<String, Object> insideObj = (HashMap<String, Object>) obj;
                String BSSID = (String) insideObj.get("BSSID");
                Date lastJoined = (Date) insideObj.get("lastJoined");
                Date lastAutoJoined = (Date) insideObj.get("lastAutoJoined");
                Double networkUsage = (Double) insideObj.get("networkUsage");

                if (insideObj.get("networkKnownBSSListKey") != null) {
                    ArrayList<Object> lastRoamedList = (ArrayList<Object>) insideObj.get("networkKnownBSSListKey");

                    for (Object objRoamed : lastRoamedList) {
                        HashMap<String, Object> insideRoamedObj = (HashMap<String, Object>) objRoamed;

                        CSVInputForPList inputForPList = new CSVInputForPList();
                        inputForPList.setBSSID(BSSID);
                        inputForPList.setLastJoined(lastJoined);
                        inputForPList.setLastAutoJoined(lastAutoJoined);
                        inputForPList.setNetworkUsage(networkUsage);
                        inputForPList.setLastRoamed((Date) insideRoamedObj.get("lastRoamed"));

                        csvInputForPLists.add(inputForPList);
                    }

                } else {

                    CSVInputForPList inputForPList = new CSVInputForPList();
                    inputForPList.setBSSID(BSSID);
                    inputForPList.setLastJoined(lastJoined);
                    inputForPList.setLastAutoJoined(lastAutoJoined);
                    inputForPList.setNetworkUsage(networkUsage);
                    inputForPList.setLastRoamed(null);

                    csvInputForPLists.add(inputForPList);
                }
            }

            CSVWriterForPList.createCSVFile("PlistParsed.csv", csvInputForPLists);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}