package com.liming.weixin.util;

import java.util.Random;



public class random {
   public static int getrandom() {
	  Random random=new Random();
	   return (random.nextInt(5)+1);
   }
 
}
