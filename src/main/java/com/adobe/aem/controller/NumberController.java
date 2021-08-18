package com.adobe.aem.controller;

import com.adobe.aem.constants.APIConstants;
import com.adobe.aem.factory.NumberServiceFactory;
import com.adobe.aem.request.NumberConvertRequest;
import com.adobe.aem.response.NumberConvertResponse;
import com.adobe.aem.service.NumberService;
import io.swagger.annotations.ApiOperation;
import lombok.NonNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Number controller responsible for executing the operation on the given number and number system.
 *
 * <p>As per the given requirement , we currently support only conversion operation from a given
 * number to roman numeral.
 *
 * <p>However we can extend the system to convert to any number system and support any operation. if
 * we want to extend the system , we can simply add the required operation and update the factory
 * class to support the required number system.
 *
 * @author ravi shanker katta
 * @since 2021 Aug
 * @version 1.0
 */
@RestController
@RequestMapping(value = APIConstants.NUMBER_CONTROLLER_SERVICE_BASE_URI)
public class NumberController {

  private final Logger log = LoggerFactory.getLogger(this.getClass());

  @Autowired private NumberServiceFactory numberServiceFactory;

  @RequestMapping(value = APIConstants.CONVERT, method = RequestMethod.GET)
  @ApiOperation(
      value = " converts given numeric value to roman numeral, number allowed between 1 and 3999.")
  public @ResponseBody NumberConvertResponse convert(
      @NonNull NumberConvertRequest numberConvertRequest) {
    NumberService numberService =
        numberServiceFactory.getNumberService(numberConvertRequest.getConversionType());
    NumberConvertResponse numberConvertResponse = numberService.convert(numberConvertRequest);
    log.info(
        " number converted successfully , input={} output={}",
        numberConvertRequest.getNumber(),
        numberConvertResponse.getOutput());
    return numberConvertResponse;
  }
}
