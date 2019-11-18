package utilities;
/*
import jdk.internal.org.xml.sax.InputSource;
import javax.xml.xpath.*;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
*/

public class XML {
    /*
    // Dependencies: javax.xml | org.w3c.com | org.xml.sax
    public static String[][] get(String file) {
        String[][] data = null;

        // 1. Prepare Xpath
        XPathFactory xpf = XPathFactory.newInstance();
        XPath xPath = xpf.newXPath();

        try {
            // 2. Create XML File
            InputSource xmlFile = new InputSource(file);

            // 3. Node Settings
            // Parent Node
            NodeList cars = (NodeList) xPath.evaluate("/cars/car", xmlFile, XPathConstants.NODESET);
            // Child Nodes
            XPathExpression xBodyStyle = xPath.compile("bodyStyle");

            // 4. Define the array : columns (fields) must be known and set manually
            int rows = cars.getLength();
            int columns = 4;
            data = new String[rows][columns];

            // 4. Iterate Through XML Based on Parent Node
            for(int i=0; i<cars.getLength(); i++) {
                // Create a Node for each record
                Node carRecord = cars.item(i);

                // Capture Data for Each Record and Store in Variables
                String carType = carRecord.getAttributes().item(0).getTextContent();
                String bodyStyle = xBodyStyle.evaluate(carRecord, XPathConstants.STRING).toString();

                // Place into Array
                data[i][0] = carType;
                data[i][1] = bodyStyle;
            }
        } catch (XPathExpressionException e) {
            System.out.println("ERROR READING XML FILE");
            e.toString();
        }
        return data;
    }*/
}
