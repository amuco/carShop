package com.carseller.cars;

import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

@Component
public class XmlConverter {

    private final String filename="C:/Users/amuco/Downloads/cars/cars/src/main/resources/ford-example.xml";


    public NodeList getNodeList(String element){
        DocumentBuilderFactory builderFactory= DocumentBuilderFactory.newInstance();

        try{

            builderFactory.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);

            DocumentBuilder db= builderFactory.newDocumentBuilder();
            Document document=db.parse(new File(filename));

            document.getDocumentElement().normalize();

            NodeList list=document.getElementsByTagName(element);

            return list;
        }catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }

       return null;
    }

}
