package com.adobe.aem.service;

import com.adobe.aem.data.ErrorType;
import com.adobe.aem.request.NumberConvertRequest;
import com.adobe.aem.response.NumberConvertResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * number validator service responsible for validating the given number , these validation are
 * requored for any number system , therefore moved this class to a validator and not having it in
 * the service. this class can be extended for more validations.
 *
 * @author ravi shanker katta
 * @since 2021 Aug
 * @version 1.0
 */
@Service
public class NumberValidatorService {
  private final Logger log = LoggerFactory.getLogger(this.getClass());

  public boolean isValid(
      NumberConvertRequest numberConvertRequest, NumberConvertResponse numberConvertResponse) {
    if (numberConvertRequest == null) {
      numberConvertResponse.setSuccess(false);
      numberConvertResponse.setErrorCode(ErrorType.INVALID_INPUT.getCode());
      numberConvertResponse.setErrorMessage(ErrorType.INVALID_INPUT.getMessage());
      log.error(" invalid input, please check for a valid input");
      return false;
    }
    Integer input = numberConvertRequest.getNumber();
    if (input == null) {
      numberConvertResponse.setSuccess(false);
      numberConvertResponse.setErrorCode(ErrorType.EMPTY_INPUT.getCode());
      numberConvertResponse.setErrorMessage(ErrorType.EMPTY_INPUT.getMessage());
      log.error(" invalid input, number not present, input={}", input);
      return false;
    } else if (input > NumberService.MAX_NUMBER_ALLOWED) {
      numberConvertResponse.setSuccess(false);
      numberConvertResponse.setErrorCode(ErrorType.INVALID_NUMBER_MAX.getCode());
      numberConvertResponse.setErrorMessage(ErrorType.INVALID_NUMBER_MAX.getMessage());
      log.error(
          " invalid number , number not allowed, maximum number allowed is 3999, input={}", input);
      return false;
    } else if (input < NumberService.MIN_NUMBER_ALLOWED) {
      numberConvertResponse.setSuccess(false);
      numberConvertResponse.setErrorCode(ErrorType.INVALID_NUMBER.getCode());
      numberConvertResponse.setErrorMessage(ErrorType.INVALID_NUMBER.getMessage());
      log.error(" invalid number, valid range is between 1 and  3999 , input={}", input);
      return false;
    }
    return true;
  }
}
