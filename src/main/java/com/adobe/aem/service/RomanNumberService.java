package com.adobe.aem.service;

import com.adobe.aem.data.ErrorType;
import com.adobe.aem.exception.NumberException;
import com.adobe.aem.request.NumberConvertRequest;
import com.adobe.aem.response.NumberConvertResponse;
import com.adobe.aem.util.NumberTransformUtil;
import lombok.NonNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * roman number service responsible to convert the given number to roman number.
 *
 * @author ravi shanker katta
 * @since 2021 Aug
 * @version 1.0
 */
@Service("romanNumberService")
public class RomanNumberService implements NumberService {

  private final Logger log = LoggerFactory.getLogger(this.getClass());

  @Autowired
  private NumberValidatorService numberValidatorService;

  @Override
  public NumberConvertResponse convert(@NonNull NumberConvertRequest numberConvertRequest) {
    NumberConvertResponse numberConvertResponse = NumberConvertResponse.builder().build();
    try {
      if (numberValidatorService.isValid(numberConvertRequest, numberConvertResponse)) {
        Integer input = numberConvertRequest.getNumber();
        String romanNumberOutput = NumberTransformUtil.convertToToRomanNumber(input);
        return NumberConvertResponse.builder()
            .success(true)
            .output(romanNumberOutput)
            .input(numberConvertRequest.getNumber())
            .build();
      }
    } catch (NumberException exception) {
      numberConvertResponse.setSuccess(false);
      numberConvertResponse.setErrorCode(ErrorType.INTERNAL_SERVER_ERROR.getCode());
      numberConvertResponse.setErrorMessage(ErrorType.INTERNAL_SERVER_ERROR.getMessage());
      log.error(
          " error converting given number to roman number  , input={} exception={}",
          numberConvertRequest.getNumber(),
          exception.getMessage());
    }
    return numberConvertResponse;
  }
}
