package com.github.akshayavenkatesh8;

import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import org.xml.sax.SAXException;



public class JAXBAddressParser {

    /**
     * @param args the command line arguments
     * @throws javax.xml.bind.JAXBException
     * @throws org.xml.sax.SAXException
     */
    public static void main(String[] args) throws JAXBException, SAXException {
       JAXBAddressParser parser = new JAXBAddressParser();
        File addressXmlFile = new File("address.xml");
        System.out.println("Upon Parsing using JAXB :");
        Address address = parser.parseAddressWithJAXB(addressXmlFile);//Method only parses; does not validate
        System.out.println(address);
        System.out.println("Upon Parsing and Validation using JAXB : ");
        address = parser.parseAndValidateAddressWithJAXB(addressXmlFile);//Method parses and validates
        System.out.println(address);
        parser.generateXMLFromAddress(address);//Writes xml to a new file from a java object
    }

    public Address parseAddressWithJAXB(File addressXmlFile) throws JAXBException {
        
        JAXBContext jaxbContext = JAXBContext.newInstance(Address.class);  
        
        Unmarshaller addressUnmarshal = jaxbContext.createUnmarshaller();
        Address address = (Address)addressUnmarshal.unmarshal(addressXmlFile);
        return address;
    }
    public Address parseAndValidateAddressWithJAXB(File addressXmlFile) throws JAXBException, SAXException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Address.class);  
        Unmarshaller addressUnmarshal = jaxbContext.createUnmarshaller();
        SchemaFactory sf = SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema"); 
        Schema schema = sf.newSchema(new File("address.xsd")); 
        addressUnmarshal.setSchema(schema);
        File file = new File("address.xsd");
        addressUnmarshal.setEventHandler(new AddressValidationEventHandler());
        Address address = (Address)addressUnmarshal.unmarshal(addressXmlFile);
        return address;
    }

    public void generateXMLFromAddress(Address address) throws JAXBException {
         System.out.println("Address object is Marshalled and written to newAddress.xml");
         JAXBContext jaxbContext = JAXBContext.newInstance(Address.class);
         Marshaller addressMarshal = jaxbContext.createMarshaller();
         File file = new File("newAddress.xml");
         addressMarshal.marshal(address, file);
    }
}
