package com.adobe.aem.service;

import com.adobe.aem.request.NumberConvertRequest;
import com.adobe.aem.response.NumberConvertResponse;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

/**
 * Demonstrates mocking capabilities and roman number conversion validation.
 *
 * <p>This test is added to validate roman number conversion and also demonstrate mocking
 * capability. today as per the given requirement , the layer is next to service is not having much
 * functionality , however in a traditional application , we may have a DAO class or a work flow
 * associated classes, in those cases mocking comes handy and helps in validating only the layer
 * under test and mocking all the other classes.
 *
 *  @author ravi shanker katta
 *  @since 2021 Aug *
 *  @version 1.0
 */
@RunWith(MockitoJUnitRunner.class)
public class RomanNumberServiceTest {

  @InjectMocks RomanNumberService romanNumberService;

  @Mock NumberValidatorService validatorService;

  @Test
  public void convertTest() {
    NumberConvertRequest numberConvertRequest = NumberConvertRequest.builder().number(12).build();
    NumberConvertResponse numberConvertResponse = NumberConvertResponse.builder().build();
    Mockito.when(
            validatorService.isValid(
                Mockito.any(NumberConvertRequest.class), Mockito.any(NumberConvertResponse.class)))
        .thenReturn(true);
    NumberConvertResponse numberConvResponse = romanNumberService.convert(numberConvertRequest);
    Assert.assertEquals("XII", numberConvResponse.getOutput());
    Assert.assertEquals(12, numberConvResponse.getInput());
  }
}
