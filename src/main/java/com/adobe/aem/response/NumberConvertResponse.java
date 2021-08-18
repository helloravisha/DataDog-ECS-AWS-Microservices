package com.adobe.aem.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * response object responsible for holding the response data after number operation.
 *
 * <ul>
 *   <li>output - holds the required output , holds the converted the number.
 *   <li>input - holds the given input number, for reference to check for conversion once output is
 *       given.
 *   <li>errorCode - holds the error code for any error in the operation. this code can be shared by
 *       the clients to the support for error tracing.
 *   <li>errorMessage - holds the error message on why the error is reported.
 * </ul>
 *
 * @author ravi shanker katta
 * @since 2021 Aug
 * @version 1.0
 */
@Getter
@Setter
@AllArgsConstructor
@Builder
public class NumberConvertResponse {

  @ApiModelProperty(
      value = "converted to given number system",
      name = "output",
      dataType = "String",
      example = "IV")
  private String output;

  @ApiModelProperty(value = "given input", name = "input", dataType = "Integer", example = "24")
  private int input;

  @ApiModelProperty(
      value = "error code for given operation",
      name = "errorCode",
      dataType = "Integer",
      example = "101")
  private int errorCode;

  @ApiModelProperty(
      value = "error message for given operation",
      name = "errorMessage",
      dataType = "String",
      example = "internal server error, please contact support.")
  private String errorMessage;

  @ApiModelProperty(
      value = " status of given operation",
      name = "success",
      dataType = "boolean",
      example = "true")
  private boolean success;
}
