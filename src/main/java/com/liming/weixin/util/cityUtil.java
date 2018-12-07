package com.liming.weixin.util;

public class cityUtil {
  public static final String[] citys= {"北京","易县","潍坊"};
  
  public String  getContainCity(String context) {
	 for (String cit : citys) {
		if(context.contains(cit)) {
			return cit;
		}
	}
	  
	  return context;
  }
  public boolean  ContainCity(String context) {
		 for (String cit : citys) {
			if(context.contains(cit)) {
				return true;
			}
		}
		  
		  return false;
	  }
}
