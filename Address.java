
package com.github.akshayavenkatesh8;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Akshaya
 */
@XmlRootElement
class Address {
        @XmlElement(name = "name")
        public String name;
       @XmlElement(name = "streetnumber")
        public String streetNumber;
        @XmlElement(name = "streetname")
        public String streetName;
       @XmlElement(name = "secondaryaddress")
        public String secondaryAddress;
       @XmlElement(name = "city")
        public String city;
       @XmlElement(name = "statecode")
        public String stateCode;
       @XmlElement(name = "zipcode")
        public String zipCode;
    
    
        @Override
        public String toString()
        {
           return "Address :\n"+name+",\n"+streetNumber+" "+streetName+",\n"+secondaryAddress+",\n"+city+",\n"+stateCode+" "+zipCode;
        }


}
