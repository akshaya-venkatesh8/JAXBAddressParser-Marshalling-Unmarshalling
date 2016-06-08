package com.github.akshayavenkatesh8;
import javax.xml.bind.ValidationEvent;
import javax.xml.bind.ValidationEventHandler;
/**
 *
 * @author Akshaya
 */
class AddressValidationEventHandler implements ValidationEventHandler {
 public AddressValidationEventHandler() {
  }
    @Override
    public boolean handleEvent(ValidationEvent event) {
        System.out.println("ERROR : "+event.getMessage());
        return true;
    }
    
}
