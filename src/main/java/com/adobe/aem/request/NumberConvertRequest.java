package com.adobe.aem.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

/**
 * request object responsible for holding the required , request data for number conversion. number
 * is a mandatory field , conversionType is an optional field. added this property for the
 * extensibility of the system.
 *
 * @author ravi shanker katta
 * @since 2021 Aug
 * @version 1.0
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NumberConvertRequest {

  @ApiModelProperty(
      value = " number to be converted",
      name = "number",
      dataType = "Integer",
      example = "1")
  private Integer number;

  @ApiModelProperty(
      value = " conversion type ( optional ). Eg: ROMAN",
      name = "conversionType",
      dataType = "String",
      example = "ROMAN")
  @Builder.Default
  private String conversionType = "ROMAN";
}
