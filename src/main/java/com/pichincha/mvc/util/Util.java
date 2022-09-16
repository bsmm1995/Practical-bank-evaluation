package com.pichincha.mvc.util;

import java.text.SimpleDateFormat;
import java.util.Locale;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class Util {
  public static final Locale LOCALE = Locale.forLanguageTag("es-EC");

  private Util() {
  }

  public static String spellNumber(Double number) {
    return "";
  }

  public static SimpleDateFormat getDateLongFormat() {
    return new SimpleDateFormat("dd 'días del mes de' MMMM 'del año' yyyy", Util.LOCALE);
  }

}
