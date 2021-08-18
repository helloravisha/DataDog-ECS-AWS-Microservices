package com.adobe.aem.service;

import com.adobe.aem.data.ErrorType;
import com.adobe.aem.request.NumberConvertRequest;
import com.adobe.aem.response.NumberConvertResponse;
import lombok.NonNull;
import org.springframework.stereotype.Service;

/**
 * decimal number service responsible to convert the given number to decimal number, currently this
 * operation is not supported , added this as place holder to demonstrate the extensibility of the
 * system, if tomorrow we want to convert the given number to decimal for any given number we can
 * use this service.
 *
 * @author ravi shanker katta
 * @since 2021 Aug
 * @version 1.0
 */
@Service("decimalNumberService")
public class DecimalNumberService implements NumberService {
  @Override
  public NumberConvertResponse convert(@NonNull NumberConvertRequest numberConvertRequest) {
    NumberConvertResponse numberConvertResponse = NumberConvertResponse.builder().build();
    numberConvertResponse.setSuccess(false);
    numberConvertResponse.setErrorCode(ErrorType.NEXT_RELEASE.getCode());
    numberConvertResponse.setErrorMessage(ErrorType.NEXT_RELEASE.getMessage());
    return numberConvertResponse;
  }
}
