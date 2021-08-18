package com.adobe.aem.service;

import com.adobe.aem.data.ErrorType;
import com.adobe.aem.request.NumberConvertRequest;
import com.adobe.aem.response.NumberConvertResponse;
import org.junit.Assert;
import org.junit.Test;


/**
 * Tests added to validate possible use cases.
 *
 * @author ravi shanker katta
 * @since 2021 Aug
 * @version 1.0
 */
public class NumberValidatorServiceTest {

  private NumberValidatorService numberValidatorService = new NumberValidatorService();

  /** validates maximum number crossed use case. */
  @Test
  public void invalidMaximumNumberTest() {
    NumberConvertRequest numberConvertRequest = NumberConvertRequest.builder().number(5000).build();
    NumberConvertResponse numberConvertResponse = NumberConvertResponse.builder().build();
    Boolean isValid = numberValidatorService.isValid(numberConvertRequest, numberConvertResponse);
    Assert.assertEquals(
        ErrorType.INVALID_NUMBER_MAX.getMessage(), numberConvertResponse.getErrorMessage());
    Assert.assertFalse(isValid);
  }

  /** validates minimum number crossed use case. */
  @Test
  public void invalidMimimumNumberTest() {
    NumberConvertRequest numberConvertRequest = NumberConvertRequest.builder().number(-1).build();
    NumberConvertResponse numberConvertResponse = NumberConvertResponse.builder().build();
    Boolean isValid = numberValidatorService.isValid(numberConvertRequest, numberConvertResponse);
    Assert.assertEquals(
        ErrorType.INVALID_NUMBER.getMessage(), numberConvertResponse.getErrorMessage());
    Assert.assertFalse(numberConvertResponse.isSuccess());
    Assert.assertFalse(isValid);
  }

  /** validates empty number crossed use case. */
  @Test
  public void invalidNumberTest() {
    NumberConvertRequest numberConvertRequest = NumberConvertRequest.builder().build();
    NumberConvertResponse numberConvertResponse = NumberConvertResponse.builder().build();
    Boolean isValid = numberValidatorService.isValid(numberConvertRequest, numberConvertResponse);
    Assert.assertEquals(
        ErrorType.EMPTY_INPUT.getMessage(), numberConvertResponse.getErrorMessage());
    Assert.assertFalse(numberConvertResponse.isSuccess());
    Assert.assertFalse(isValid);
  }

  /** validates positive use case. */
  @Test
  public void romanNumberConversionTest() {
    NumberConvertRequest numberConvertRequest = NumberConvertRequest.builder().number(13).build();
    NumberConvertResponse numberConvertResponse = NumberConvertResponse.builder().build();
    Boolean isValid = numberValidatorService.isValid(numberConvertRequest, numberConvertResponse);
    Assert.assertTrue(isValid);
  }
}
