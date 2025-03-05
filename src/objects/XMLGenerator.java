package objects;


import org.w3c.dom.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class XMLGenerator {
    private String outputFilePath;
    private String fromAddress = "3025760000104";
    private String toAddress = "5488888006645";
    
    public XMLGenerator(String outputFilePath, String name) {
        this.outputFilePath = outputFilePath;
    }
    
    public void generateXML() {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.newDocument();
            
            // Déclaration XML
            document.setXmlVersion("1.0");

            // Création de l'élément racine Envelope avec les namespaces
            Element envelopeElement = document.createElement("Envelope");
            envelopeElement.setAttribute("xmlns:env", "http://www.intentia.com/MBM_Envelope_1");
            envelopeElement.setAttribute("xmlns:xsi", "http://www.w3.org/2001/XMLSchema-instance");
            document.appendChild(envelopeElement);
            
            // Création de l'élément Header
            Element headerElement = document.createElement("Header");
            envelopeElement.appendChild(headerElement);
            
            // Création de l'élément delivery
            Element deliveryElement = document.createElement("delivery");
            headerElement.appendChild(deliveryElement);
            
            // Élément to
            Element toElement = document.createElement("to");
            Element toAddressElement = document.createElement("address");
            toAddressElement.appendChild(document.createTextNode(toAddress));
            toElement.appendChild(toAddressElement);
            deliveryElement.appendChild(toElement);
            
            // Élément from
            Element fromElement = document.createElement("from");
            Element fromAddressElement = document.createElement("address");
            fromAddressElement.appendChild(document.createTextNode(fromAddress));
            fromElement.appendChild(fromAddressElement);
            deliveryElement.appendChild(fromElement);
            
            // Élément properties
            Element propertiesElement = document.createElement("properties");
            headerElement.appendChild(propertiesElement);
            
            Element identityElement = document.createElement("identity");
            identityElement.appendChild(document.createTextNode("69"));
            propertiesElement.appendChild(identityElement);
            
            Element sentAtElement = document.createElement("sentAt");
            sentAtElement.appendChild(document.createTextNode(getCurrentTimestamp()));
            propertiesElement.appendChild(sentAtElement);
            
            Element expiresAtElement = document.createElement("expiresAt");
            propertiesElement.appendChild(expiresAtElement); // Vide
            
            Element topicElement = document.createElement("topic");
            topicElement.appendChild(document.createTextNode("http://www.intentia.com/MBM"));
            propertiesElement.appendChild(topicElement);
            
            // Élément manifest
            Element manifestElement = document.createElement("manifest");
            headerElement.appendChild(manifestElement);
            
            Element referenceElement = document.createElement("reference");
            referenceElement.setAttribute("uri", "#ORDERS@D96A");
            manifestElement.appendChild(referenceElement);
            
            Element descriptionElement = document.createElement("description");
            descriptionElement.appendChild(document.createTextNode("DOC NAME DESCR"));
            referenceElement.appendChild(descriptionElement);

            // Body 
                //ORDERS
                    //UNB
                        //cmp01
            
            // Transformation du document en fichier XML
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.ENCODING, "ISO-8859-15");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            
            DOMSource source = new DOMSource(document);
            StreamResult result = new StreamResult(new File(outputFilePath));
            transformer.transform(source, result);

            System.out.println("Fichier XML généré avec succès : " + outputFilePath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private String getCurrentTimestamp() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
        return sdf.format(new Date());
    }

    public static void main(String[] args) {
        XMLGenerator generator = new XMLGenerator("output.xml", "MyName");
        generator.generateXML();
    }
}
