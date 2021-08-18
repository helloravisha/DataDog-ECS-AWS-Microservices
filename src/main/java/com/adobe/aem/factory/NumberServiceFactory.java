package com.adobe.aem.factory;

import com.adobe.aem.data.NumberSystem;
import com.adobe.aem.service.NumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * <br>
 * Added this class to demonstrate extensibility of the system. this is not part of requirement.
 * </BR>
 *
 * <p>factory class takes care of getting the required service based on the required * opeartion
 * type. this class acts as an extension for the requirement if we want * to extend the service to
 * convert based on the required conversion type , * for example , in future, if we want to convert
 * the given number to Decimal * , just pass the type to which we need the conversion.
 *
 * @author ravi shanker katta
 */
@Service
public class NumberServiceFactory {

  @Autowired
  @Qualifier("romanNumberService")
  private NumberService romanNumberService;

  @Autowired
  @Qualifier("decimalNumberService")
  private NumberService decimalNumberService;

  public NumberService getNumberService(String type) {
    if (NumberSystem.DECIMAL.getType().equalsIgnoreCase(type)) {
      return decimalNumberService;

    } else if (NumberSystem.ROMAN.getType().equalsIgnoreCase(type)) {
      return romanNumberService;
    }
    return romanNumberService;
  }
}
