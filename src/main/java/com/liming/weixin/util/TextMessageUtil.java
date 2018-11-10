package com.liming.weixin.util;

import java.util.Date;

import com.liming.weixin.pojo.MessageText;
import com.thoughtworks.xstream.XStream;

public class TextMessageUtil {
	/**
	 * 将发送消息封装成对应的xml格式
	 */
	public  String messageToxml(MessageText  message) {
		XStream xstream  = new XStream();
		xstream.alias("xml", message.getClass());
		return xstream.toXML(message);
	}
	/**
	 * @author test
	 * 天气查询
	 * 
	 * */
	public  String initMessages(String FromUserName, String ToUserName) {
		MessageText text = new MessageText();
		text.setToUserName(FromUserName);
		text.setFromUserName(ToUserName);
		text.setContent("请问你想查询哪个城市");
		text.setCreateTime(new Date().getTime());
		text.setMsgType("text");
		System.out.println(text.getMsgType());
	     return  messageToxml(text);
	}
	/**
	 * @author test
	 * 回复笑话
	 * */
	public  String getxiaohua(String FromUserName, String ToUserName) {
		MessageText text = new MessageText();
		text.setToUserName(FromUserName);
		text.setFromUserName(ToUserName);
		text.setContent("送鹅从前有个秀才送给学官一只鹅。学官说：“我要是要了你的鹅，又没东西喂它，那鹅不就饿死了？若是不要你的鹅吧，又失礼节，你说怎么办？”秀才说：“请老师权且收下，鹅（饿）死的事小，失节的事大。”");
		text.setCreateTime(new Date().getTime());
		text.setMsgType("text");
		System.out.println(text.getMsgType());
	     return  messageToxml(text);
	}
	
	/**
	 * 封装发送消息对象,封装时，需要将调换发送者和接收者的关系
	 * @param FromUserName
	 * @param ToUserName
	 */
	public  String initMessage(String FromUserName, String ToUserName) {
		MessageText text = new MessageText();
		text.setToUserName(FromUserName);
		text.setFromUserName(ToUserName);
		text.setContent("欢迎关注卢笛的公众号");
		text.setCreateTime(new Date().getTime());
		text.setMsgType("text");
		System.out.println(text.getMsgType());
	     return  messageToxml(text);
	}
    /**
     * 返回天气
     * @author test
     * */
	public  String getWeather(String FromUserName, String ToUserName,String city) {
		MessageText text = new MessageText();
		text.setToUserName(FromUserName);
		text.setFromUserName(ToUserName);
		WeatherReportByCity weatherReportByCity=new WeatherReportByCity();
		String weather=weatherReportByCity.GetTodayTemperatureByCity(city);
		text.setContent(weather);
		text.setCreateTime(new Date().getTime());
		text.setMsgType("text");
		System.out.println(text.getMsgType());
	     return  messageToxml(text);
	}
	/**
	 * @author test
	 * 回复未开发的功能
	 * */
	public  String replyundefind(String FromUserName, String ToUserName) {
		MessageText text = new MessageText();
		text.setToUserName(FromUserName);
		text.setFromUserName(ToUserName);
		text.setContent("该功能还未开发哦");
		text.setCreateTime(new Date().getTime());
		text.setMsgType("text");
		System.out.println(text.getMsgType());
	     return  messageToxml(text);
	}

}
