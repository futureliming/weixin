package com.liming.weixin.util;
/**
 * @author test
 * 消息封装工具的基类，这里采取泛型，方便后期进行扩展
 * */
public interface BaseMessageUtil<T> {
  /**
   * @author test
   * 将回复的信息对象转xml格式给微信
   * */
	public abstract String messageToxml(T t);
  /**
   * 回复的信息封装
   * */
	public abstract  String initMessage(String FromUserName,String ToUserName);
}
