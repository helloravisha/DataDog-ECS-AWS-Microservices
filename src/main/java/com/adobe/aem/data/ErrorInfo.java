package com.adobe.aem.data;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * holds the error code and error message.
 *
 * @author ravi shanker katta
 * @since 2021 Aug
 * @version 1.0
 */
@Getter
@Setter
@Builder
public class ErrorInfo {
  private int code;
  private String Message;
}
