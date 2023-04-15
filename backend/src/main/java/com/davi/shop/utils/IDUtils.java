package com.davi.shop.utils;

import java.util.UUID;

public class IDUtils {    
   public static String GetIDValue() {
      return UUID.randomUUID().toString().replace("-", "");
   }
    
}
