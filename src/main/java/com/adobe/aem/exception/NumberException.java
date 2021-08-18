package com.adobe.aem.exception;

/**
 * Represents the number conversion exception thrown by the APIs.
 *
 * @author ravi shanker katta
 * @since 2021 Aug
 * @version 1.0
 */
public class NumberException extends RuntimeException {

  private static final long serialVersionUID = 5776681206288518465L;

  public NumberException(String message) {
    super(message);
  }
}
