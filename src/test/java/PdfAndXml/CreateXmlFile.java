package PdfAndXml;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class CreateXmlFile {
    static String xmlPath="/Users/amit/IdeaProjects/JSONTutorialMaven/Data/employees.xml";
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {

        DocumentBuilderFactory factory= DocumentBuilderFactory.newInstance();
        DocumentBuilder builder=factory.newDocumentBuilder();
        Document document= (Document) builder.parse(xmlPath);

        //extract root node
        Element root=document.getDocumentElement();
        NodeList nodeList=root.getChildNodes();

        for(int i=0;i<=nodeList.getLength();i++){
            Node node=nodeList.item(i);
            if(node.getNodeType()==Node.ELEMENT_NODE)
            {
                Element element=(Element)node;
                String tagName=element.getTagName();
                String textContent=element.getTextContent();
                System.out.println("TageName: " +tagName);
                System.out.println("Text Content: " +textContent);
            }
        }



    }
}
