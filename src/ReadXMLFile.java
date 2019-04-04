import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;

public class ReadXMLFile {

    public static ArrayList<CSVInputForStepCount> csvInputForStepCounts = new ArrayList<>();

    public static void main(String argv[]) {

        try {
            File fXmlFile = new File("export.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);
            doc.getDocumentElement().normalize();

            NodeList nList = doc.getElementsByTagName("Record");
            int count = 0;

            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    String type = eElement.getAttribute("type");

                    if (type.equals("HKQuantityTypeIdentifierStepCount")) {
                        count++;

                        CSVInputForStepCount input = new CSVInputForStepCount();
                        input.setSourceName(eElement.getAttribute("sourceName"));
                        input.setSourceVersion(eElement.getAttribute("sourceVersion"));
                        input.setCreationDate(eElement.getAttribute("creationDate"));
                        input.setValue(eElement.getAttribute("value"));

                        csvInputForStepCounts.add(input);
                    }
                }
            }

            CSVWriterForStepCount.createCSVFile("StepCount.csv", csvInputForStepCounts);
            System.out.println(count + "");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
