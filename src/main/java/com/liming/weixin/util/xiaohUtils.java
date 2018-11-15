package com.liming.weixin.util;

import java.util.ArrayList;
import java.util.List;

public class xiaohUtils {
   
   public String xiaohua() {
   String x1="1奶奶问上幼儿园的小孙女\r\n" + 
   		 
   		"奶奶：宝宝你是哪个国家的人呀？\r\n" + 
   		"孙女：中国人呀！\r\n" + 
   		"奶奶：你是哪个省的呀？\r\n" + 
   		"孙女：妈妈生的呀！\r\n" + 
   		"我直接喷饭了。。。";
   String x2="2今天早上带着四岁的女儿来幼儿园上班，我在打扫卫生，给她一块抹布让她去擦滑滑梯，\r\n" + 
   		
   		"她一屁股从滑滑梯滑下来说：妈妈，擦干净啦。。。";
   String x3="3同事儿子会吹笛子和口琴，有一次来我家里玩，对我侄子说：你会吹笛子吗？侄子摇摇头。\r\n" + 
   		
   		"又说：你会吹口琴吗？侄子又摇摇头。\r\n" + 
   		"然后问：那你会吹什么？\r\n" + 
   		"侄子不好意思的说：我会吹空调！";
   String x4="4一客户欠款很长时间，打电话催款，他家宝宝接的电话！\r\n" + 
   		
   		"宝宝：阿姨，你好！\r\n" + 
   		"我：宝宝你好，你爸爸妈妈在吗？\r\n" + 
   		"宝宝：我爸妈不在家。\r\n" + 
   		"我：那你看看你身后是不是有个喜羊羊。\r\n" + 
   		"宝宝：没有，我身后是爸爸。。。";
   String x5="5看着饭桌上的侄子，嫂子语重心长地说：看看住我们隔壁和你同班的那个小伙子，爱学习，成绩好，又不打游戏，人还挺有礼貌。\r\n" + 
   		  
   		"一旁一直不说话的侄子意味深长地来一句：怎么，想让我搞基？";
   List<String> list =new ArrayList<String>();
   list.add(x1);
   list.add(x2);
   list.add(x3);
   list.add(x4);
   list.add(x5);
   random random=new random();
   int ran= random.getrandom();
   String xiaohua=null;
  for (String string : list) {
	if(string.contains(String.valueOf(ran))) {
		
		xiaohua=string.substring(1);;
	}
}
   return xiaohua;
   
   }
  public static void main(String[] args) {
	  xiaohUtils utils=new xiaohUtils();
	  System.out.println(utils.xiaohua());
}
}
