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
      System.out.println("Message : "+event.getMessage());
      System.out.println("Severity : "+event.getSeverity());
      System.out.println("Warning/ErrorLocation :-\n@LineNumber - "+event.getLocator().getLineNumber()+"\n@ColumnNumber "+event.getLocator().getColumnNumber());
      return false;
    }
    
}
