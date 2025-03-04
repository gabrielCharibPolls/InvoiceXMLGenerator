package objects;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class XMLGenerator {
    public static void main(String[] args) {
        try {
            // Création du document XML
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.newDocument();

            // Déclaration XML
            document.setXmlVersion("1.0");

            // Création de l'élément racine
            Element rootElement = document.createElement("Root");
            document.appendChild(rootElement);

            // Création d'un élément enfant XMLObject
            Element xmlObject = document.createElement("XMLObject");
            rootElement.appendChild(xmlObject);

            // Création d'un sous-élément Name
            Element name = document.createElement("Name");
            name.appendChild(document.createTextNode("Exemple"));
            xmlObject.appendChild(name);

            // Création d'un sous-élément Value
            Element value = document.createElement("Value");
            value.appendChild(document.createTextNode("12345"));
            xmlObject.appendChild(value);

            // Transformer le document en fichier XML
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(document);
            StreamResult result = new StreamResult(new File("output.xml"));

            transformer.transform(source, result);

            System.out.println("Fichier XML généré avec succès : output.xml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
