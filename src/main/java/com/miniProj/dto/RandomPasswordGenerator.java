package com.miniProj.dto;

//package com.example.usermanagement.util;

import java.security.SecureRandom;

public class RandomPasswordGenerator {
  private static final String CHARSET = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789@#$%&*";
  private static final SecureRandom RAND = new SecureRandom();

  public static String generate(int length) {
    StringBuilder sb = new StringBuilder(length);
    for (int i = 0; i < length; i++) {
      sb.append(CHARSET.charAt(RAND.nextInt(CHARSET.length())));
    }
    return sb.toString();
  }
}
