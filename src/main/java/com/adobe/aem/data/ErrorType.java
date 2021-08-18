package com.adobe.aem.data;

/**
 * holds different coded in the system, the error codes helps the client to communicate with the
 * support team for the error use cases. The same enum can be externalized, to support Localization
 * for any given client. in the best interest of time we currently configured the error coded in an
 * enum.
 *
 * @author ravi shanker katta
 * @since 2021 Aug
 * @version 1.0
 */
public enum ErrorType {
  INVALID_NUMBER_MAX(101, " invalid number , number not allowed. maximum number allowed is 3999"),
  INVALID_NUMBER(102, " invalid number, valid range is between 1 and  3999 "),
  INVALID_INPUT(103, " invalid input, please check for a valid input "),
  EMPTY_INPUT(104, " invalid input, number not present"),
  OPERATION_NOT_SUPPORTED(105, " invalid type, operation  not supported."),
  NEXT_RELEASE(106, " invalid type, opeartion to be supported with next release"),
  INTERNAL_SERVER_ERROR(107, " internal server error, please contact support.");

  private Integer code;
  private String message;

  private ErrorType(Integer code, String message) {
    this.code = code;
    this.message = message;
  }

  public Integer getCode() {
    return this.code;
  }

  public String getMessage() {
    return this.message;
  }
}
