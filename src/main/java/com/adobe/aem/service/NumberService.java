package com.adobe.aem.service;

import com.adobe.aem.request.NumberConvertRequest;
import com.adobe.aem.response.NumberConvertResponse;
import lombok.NonNull;

/**
 * number service acts as interface for any operation on the given number system, any number system
 * that need to be supported, should implement this interface. we can also add more operations to
 * this interface , like say we want to add some more mathematical operations etc , we can add such
 * operations to this interface, which can be implemented by other services as well.
 *
 * @author ravi shanker katta
 * @since 2021 Aug
 * @version 1.0
 */
public interface NumberService {
  int MAX_NUMBER_ALLOWED = 3999;
  int MIN_NUMBER_ALLOWED = 1;

  NumberConvertResponse convert(@NonNull NumberConvertRequest numberConvertRequest);
}
