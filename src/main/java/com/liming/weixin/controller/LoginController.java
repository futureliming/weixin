package com.liming.weixin.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.liming.weixin.util.CheckUtil;
import com.liming.weixin.util.MessageUtil;
import com.liming.weixin.util.TextMessageUtil;
/*****
 * 
 * @author test
 * 类名称:LoginController
 * 类描述:与微信对接登陆验证
 *
 */

@Controller
public class LoginController {
	int count=1;
	@RequestMapping(value = "wx",method=RequestMethod.GET)
	public void login(HttpServletRequest request,HttpServletResponse response){
		System.out.println("success");
		String signature = request.getParameter("signature");
		String timestamp = request.getParameter("timestamp");
		String nonce = request.getParameter("nonce");
		String echostr = request.getParameter("echostr");
		PrintWriter out = null;
		try {
			  out = response.getWriter();
			if(CheckUtil.checkSignature(signature, timestamp, nonce)){
				out.write(echostr);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			out.close();
		}
		
	}
	
	@RequestMapping(value = "wx",method=RequestMethod.POST)
	public void dopost(HttpServletRequest request,HttpServletResponse response){
		System.out.println("进入了方法");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = null;
		//将微信请求xml转为map格式，获取所需的参数
		Map<String,String> map = MessageUtil.xmlToMap(request);
		String ToUserName = map.get("ToUserName");
		String FromUserName = map.get("FromUserName");
		String MsgType = map.get("MsgType");
		String Content = map.get("Content");
		
		String message = null;
		//处理文本类型，实现输入1，回复相应的封装的内容
		if("text".equals(MsgType)){
			/*TextMessageUtil textMessages = new TextMessageUtil();
			message = textMessages.initMessages(FromUserName, ToUserName);*/
			if("1".equals(Content)){
				
				TextMessageUtil textMessage = new TextMessageUtil();
				message = textMessage.initMessage(FromUserName, ToUserName);
				System.out.println(message);
			}else if(Content.contains("天气")) {
				TextMessageUtil textMessage = new TextMessageUtil();
				message = textMessage.initMessages(FromUserName, ToUserName);
				count=2;
			}else if(count ==2) {
				TextMessageUtil textMessage = new TextMessageUtil();
				message = textMessage.getWeather(FromUserName, ToUserName, Content);
				count=1;
			}else if(Content.contains("笑话")) {
				TextMessageUtil textMessage = new TextMessageUtil();
				message = textMessage.getxiaohua(FromUserName, ToUserName);
			}else {
				TextMessageUtil textMessage = new TextMessageUtil();
				message = textMessage.replyundefind(FromUserName, ToUserName);
			}
		}
		try {
			out = response.getWriter();
			out.write(message);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		out.close();

	}


}
