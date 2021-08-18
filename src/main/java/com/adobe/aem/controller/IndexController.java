package com.adobe.aem.controller;

import com.adobe.aem.constants.APIConstants;
import com.adobe.aem.data.ErrorType;
import com.adobe.aem.response.NumberConvertResponse;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * controller to handle errors.
 *
 * @author ravi shanker katta
 * @since 2021 Aug
 * @version 1.0
 */
@RestController
public class IndexController implements ErrorController {

  private final Logger log = LoggerFactory.getLogger(this.getClass());

  @RequestMapping(value = APIConstants.ERROR)
  @ApiOperation(value = " internal server error ")
  public @ResponseBody NumberConvertResponse error() {
    log.error(" internal server error processing the request");
    return NumberConvertResponse.builder()
        .success(false)
        .errorCode(ErrorType.INTERNAL_SERVER_ERROR.getCode())
        .errorMessage(ErrorType.INTERNAL_SERVER_ERROR.getMessage())
        .build();
  }

  @Override
  public String getErrorPath() {
    return APIConstants.ERROR;
  }
}
