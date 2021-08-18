package com.adobe.aem.data;

/**
 * we currently support only roman number conversion , however going forwarf if you want to extend
 * the system and support different number system , this is the class where we can maintain the the
 * different number system supported in the system.
 *
 * <p>Added Decimal number system as a place holder to demonstrate extensibility of the system , we
 * can have different number systems going forward like BINARY etc.
 *
 * @author ravi shanker katta
 * @since 2021 Aug
 * @version 1.0
 */
public enum NumberSystem {
  DECIMAL("DECIMAL"),
  ROMAN("ROMAN");

  private final String type;

  NumberSystem(String type) {
    this.type = type;
  }

  public String getType() {
    return this.type;
  }
}
