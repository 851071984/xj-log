package iie.cas.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import iie.cas.dao.primary.AreaCodeTMapper;
import iie.cas.dao.primary.BaseJklhMapper;
import iie.cas.po.primary.AreaCodeT;
import iie.cas.po.primary.BaseJklh;

public class TranslatingUtil {
	public static Map<String,Object> GKLB(int gklb){
		Map<String,Object> map=new HashMap<String,Object>();
		if(gklb==1){
			map.put("id", 1);
			map.put("name", "音频");
			return map;
		}else if(gklb==2){
			map.put("id", 2);
			map.put("name", "视频");
			return map;
		}else if(gklb==3){
			map.put("id", 3);
			map.put("name", "图片");
			return map;
		}else if(gklb==4){
			map.put("id", 4);
			map.put("name", "文本");
			return map;
		}else if(gklb==5){
			map.put("id", 5);
			map.put("name", "VPN");
			return map;
		}else if(gklb==6){
			map.put("id", 6);
			map.put("name", "即时通信");
			return map;
		}else if(gklb==7){
			map.put("id", 7);
			map.put("name", "加密网址");
			return map;
		}
		map.put("id", 1);
		map.put("name", "音频");
		return map;
	}
	public static Map<String,Object> YYS(int yys){
		Map<String,Object> map=new HashMap<String,Object>();
		if(yys==1){
			map.put("id", 1);
			map.put("name", "移动");
			return map;
		}else if(yys==2){
			map.put("id", 2);
			map.put("name", "联通");
			return map;
		}else if(yys==3){
			map.put("id", 3);
			map.put("name", "电信");
			return map;
		}else if(yys==4){
			map.put("id", 4);
			map.put("name", "铁通");
			return map;
		}else if(yys==5){
			map.put("id", 2);
			map.put("name", "教育网");
			return map;
		}
		return map;
	}
	public static Integer PROTOCOL(String xy){
		if(xy.equals("UDP")){
			return 17;
		}else if(xy.equals("TCP")){
			return 6;
		}else{
			return 6;
		}
	}
	public static Map<String,Object> CSCXY(int xy){
		Map<String,Object> map=new HashMap<String,Object>();
		if(xy==17){
			map.put("id", 17);
			map.put("name", "UDP");
			return map;
		}else if(xy==6){
			map.put("id", 6);
			map.put("name", "TCP");
			return map;
		}
		map.put("id", 6);
		map.put("name", "TCP");
		return map;
	}
	public static Map<String,Object> PZLX(int pzlx){
		Map<String,Object> map=new HashMap<String,Object>();
		if(pzlx==201){
			map.put("id", 201);
			map.put("name", "IP黑名单");
			return map;
		}else if(pzlx==402){
			map.put("id", 402);
			map.put("name", "DNS欺骗");
			return map;
		}else if(pzlx==403){
			map.put("id", 403);
			map.put("name", "URLFD");
			return map;
		}else if(pzlx==404){
			map.put("id", 404);
			map.put("name", "网站FD");
			return map;
		}else if(pzlx==405){
			map.put("id", 405);
			map.put("name", "特定证书FD");
			return map;
		}else if(pzlx==406){
			map.put("id", 406);
			map.put("name", "网站关键字FD");
			return map;
		}else if(pzlx==407){
			map.put("id", 407);
			map.put("name", "邮件关键字FD");
			return map;
		}else if(pzlx==408){
			map.put("id", 408);
			map.put("name", "FTP关键字FD");
			return map;
		}else if(pzlx==409){
			map.put("id", 409);
			map.put("name", "搜索词FD");
			return map;
		}else if(pzlx==410){
			map.put("id", 410);
			map.put("name", "邮件FD");
			return map;
		}else if(pzlx==411){
			map.put("id", 411);
			map.put("name", "VPNFD");
			return map;
		}else if(pzlx==412){
			map.put("id", 412);
			map.put("name", "即时通讯FD");
			return map;
		}else if(pzlx==413){
			map.put("id", 413);
			map.put("name", "社交应用FD");
			return map;
		}else if(pzlx==501){
			map.put("id", 501);
			map.put("name", "IPJC");
			return map;
		}else if(pzlx==502){
			map.put("id", 502);
			map.put("name", "DNSJC");
			return map;
		}else if(pzlx==503){
			map.put("id", 503);
			map.put("name", "URLJC");
			return map;
		}else if(pzlx==504){
			map.put("id", 504);
			map.put("name", "网站JC");
			return map;
		}else if(pzlx==505){
			map.put("id", 505);
			map.put("name", "特定证书JC");
			return map;
		}else if(pzlx==506){
			map.put("id", 506);
			map.put("name", "网站关键词JC");
			return map;
		}else if(pzlx==507){
			map.put("id", 507);
			map.put("name", "邮件关键词JC");
			return map;
		}else if(pzlx==508){
			map.put("id", 508);
			map.put("name", "FTP关键词JC");
			return map;
		}else if(pzlx==509){
			map.put("id", 509);
			map.put("name", "搜索词JC");
			return map;
		}else if(pzlx==510){
			map.put("id", 510);
			map.put("name", "邮件JC");
			return map;
		}else if(pzlx==511){
			map.put("id", 511);
			map.put("name", "VPNJC");
			return map;
		}else if(pzlx==512){
			map.put("id", 512);
			map.put("name", "即时通讯JC");
			return map;
		}else if(pzlx==513){
			map.put("id", 513);
			map.put("name", "社交应用JC");
			return map;
		}else if(pzlx==514){
			map.put("id", 514);
			map.put("name", "图片监测");
			return map;
		}else if(pzlx==515){
			map.put("id", 515);
			map.put("name", "多媒体监测");
			return map;
		}else{
			map.put("id", 203);
			map.put("name", "IP白名单");
			return map;
		}
	}
	public static String LHID(Integer lhid,BaseJklhMapper baseJklhMapper){
			BaseJklh area=baseJklhMapper.Select(Integer.valueOf(lhid));
			if(area!=null){
				return area.getLhhh();
			}else{
				return "未知";
			}
		
	}
	public static Map<Integer,Object> LHIDList(List<BaseJklh> baseJklh){
		Map<Integer,Object> map=new HashMap<Integer,Object>();
		for(int i=0;i<baseJklh.size();i++){
			map.put(baseJklh.get(i).getLhid(), baseJklh.get(i).getLhhh());
		}
		return map;
	}
	public static Map<String,Object> YDY(String ydy,AreaCodeTMapper areaCodeTMapper){
		Map<String,Object> map=new HashMap<String,Object>();
		if(StringUtils.isNotBlank(ydy)){
			AreaCodeT area=areaCodeTMapper.Select(Integer.valueOf(ydy));
			if(area!=null){
				map.put("id", area.getId());
				map.put("name", area.getMc().trim());
				return map;
			}else{
				map.put("id", 0);
				map.put("name", "未知");
				return map;
			}
		}
		
		map.put("id", 0);
		map.put("name", "未知");
		return map;
		
	}
	public static Map<Integer,Object> YDYList(List<AreaCodeT> areaCodeT){
		Map<Integer,Object> map=new HashMap<Integer,Object>();
		for(int i=0;i<areaCodeT.size();i++){
			map.put(areaCodeT.get(i).getId(), areaCodeT.get(i).getMc().trim());
		}
		return map;
	}
	public static Map<String,Object> MDDY(String mddy,AreaCodeTMapper areaCodeTMapper){
		Map<String,Object> map=new HashMap<String,Object>();
		if(StringUtils.isNotBlank(mddy)){
			AreaCodeT area=areaCodeTMapper.Select(Integer.valueOf(mddy));
			if(area!=null){
				map.put("id", area.getId());
				map.put("name", area.getMc().trim());
				return map;
			}else{
				map.put("id", 0);
				map.put("name", "未知");
				return map;
			}
		}
		
		map.put("id", 0);
		map.put("name", "未知");
		return map;
	}
	public static Map<String,Object> YYZL(int yyzl){
		Map<String,Object> map=new HashMap<String,Object>();
		if(yyzl==0){
			map.put("id", 0);
			map.put("name", "中文");
		}else if(yyzl==1){
			map.put("id", 1);
			map.put("name", "英文");
			return map;
		}else if(yyzl==2){
			map.put("id", 2);
			map.put("name", "维文");
			return map;
		}else if(yyzl==3){
			map.put("id", 3);
			map.put("name", "阿拉伯文");
			return map;
		}else if(yyzl==4){
			map.put("id", 4);
			map.put("name", "俄文");
			return map;
		}else if(yyzl==5){
			map.put("id", 5);
			map.put("name", "哈萨克文");
			return map;
		}else if(yyzl==6){
			map.put("id", 6);
			map.put("name", "柯尔克孜文");
			return map;
		}else{
			map.put("id", 0);
			map.put("name", "中文");
			return map;
		}
		return map;
	}

	public static Map<String,Object> DLYX(String dlyx){
		Map<String,Object> map=new HashMap<String,Object>();
		if(dlyx.equals("00")){
			map.put("id","00");
			map.put("name", "全部");
			return map;
		}else if(dlyx.equals("01")){
			map.put("id","01");
			map.put("name", "HTTP");
			return map;
		}else if(dlyx.equals("02")){
			map.put("id","02");
			map.put("name", "DNS");
			return map;
		}else if(dlyx.equals("03")){
			map.put("id","03");
			map.put("name", "MAIL");
			return map;
		}else if(dlyx.equals("04")){
			map.put("id","04");
			map.put("name", "VPN");
			return map;
		}else if(dlyx.equals("05")){
			map.put("id","05");
			map.put("name", "即时通信");
			return map;
		}else if(dlyx.equals("06")){
			map.put("id","06");
			map.put("name", "FTP");
			return map;
		}else if(dlyx.equals("07")){
			map.put("id","07");
			map.put("name", "ssl");
			return map;
		}else if(dlyx.equals("08")){
			map.put("id","08");
			map.put("name", "IP类");
			return map;
		}
		return map;
		
	}
	public static Map<String,Object> XXID(String xxid){
		Map<String,Object> map=new HashMap<String,Object>();
		//协议 1-4 6-7
		map.put("01999","HTTP");
		map.put("02999","DNS");
		map.put("03001","WEBMAIL");
		map.put("03002","SMTP");
		map.put("03003","POP3");
		map.put("03004","IMAP");
		map.put("04001","PPTP");
		map.put("04002","L2TP");
		map.put("04003","OpenVPN");
		map.put("04004","IPSec");
		map.put("05001","QQ");
		map.put("05002","BlackLight");
		map.put("05003","钉钉");
		map.put("05004","翼聊");
		map.put("05005","Hangouts");
		map.put("05006","个信");
		map.put("05007","微信电话本");
		map.put("05008","飞聊");
		map.put("05009","环聊");
		map.put("05010","有信电话");
		map.put("05011","友约");
		map.put("05012","遇见");
		map.put("05013","Kik");
		map.put("05014","微爱");
		map.put("05015","Tango");
		map.put("05016","敢聊");
		map.put("05017","微信");
		map.put("05018","易信");
		map.put("05019","旺信");
		map.put("05020","Tumblr");
		map.put("05021","Blued");
		map.put("05022","网聊");
		map.put("05023","快传");
		map.put("05024","唱吧");
		map.put("05025","比邻");
		map.put("05026","千牛");
		map.put("05027","派派");
		map.put("05028","找对象");
		map.put("05029","IM+");
		map.put("05030","微聚");
		map.put("05031","BBM");
		map.put("05032","LOFTER");
		map.put("05033","Weico");
		map.put("05034","米聊");
		map.put("05035","YY语音");
		map.put("05036","Skype");
		map.put("05037","Path");
		map.put("05038","网易泡泡");
		map.put("05039","有你");
		map.put("05040","微乐");
		map.put("05041","GO短信");
		map.put("05042","和通讯录");
		map.put("05043","约爱");
		map.put("05044","无秘");
		map.put("05045","Wicker");
		map.put("05046","约会吧");
		map.put("05047","hike messager");
		map.put("05048","摩擦");
		map.put("05049","探探");
		map.put("05050","陌陌");
		map.put("05051","点点虫");
		map.put("05052","百度Hi");
		map.put("05053","ZANK");
		map.put("05054","小恩爱");
		map.put("05055","飞信");
		map.put("05056","ChatON");
		map.put("05057","QT语音");
		map.put("05058","爱聊");
		map.put("05059","nice好赞");
		map.put("05060","朋友印象");
		map.put("05061","Googletalk");
		map.put("05062","友加");
		map.put("05063","Keechat");
		map.put("05064","啪啪音乐圈");
		map.put("05065","微会");
		map.put("05066","Radicall");
		map.put("05067","槽厂");
		map.put("05068","想恋爱");
		map.put("05069","颜值点评");
		map.put("05070","LinkedIn");
		map.put("05071","Telegram");
		map.put("05072","DiDi");
		map.put("05073","ICQ");
		map.put("05074","Zello");
		map.put("05075","NextDoor");
		map.put("05076","Pinterest");
		map.put("05077","叮咚");
		map.put("05078","床上");
		map.put("05079","Nimbuzz");
		map.put("05080","微人脉");
		map.put("05081","陪陪");
		map.put("05082","微密");
		map.put("05083","Vine");
		map.put("05084","Line");
		map.put("05085","between");
		map.put("05086","facebook");
		map.put("05087","Viber");
		map.put("05088","MeetUP");
		map.put("05089","MeetMe");
		map.put("05090","OkCupidDating");
		map.put("05091","碰碰");
		map.put("05092","Diaspora");
		map.put("05093","咚呱");
		map.put("05094","陪聊");
		map.put("05095","Twitter");
		map.put("05096","Kakao");
		map.put("05097","MSN");
		map.put("05098","Voxer");
		map.put("05099","Airetalk");
		map.put("05100","ooVoo");
		map.put("05101","Mico");
		map.put("05102","Banjo");
		map.put("05103","TextNow");
		map.put("05104","抱抱");
		map.put("05105","多多的鱼");
		map.put("05106","个性");
		map.put("05107","闺蜜圈");
		map.put("05108","Instagram");
		map.put("05109","Whatsapp");
		map.put("05110","Talkbox");
		map.put("05111","ChatOn");
		map.put("05112","Coco");
		map.put("05113","Badoo");
		map.put("05114","Match.com");
		map.put("05115","TextFree");
		map.put("05116","Tapatalk");
		map.put("05117","KC网络电话");
		map.put("05118","爱唱");
		map.put("05119","酷我");
		map.put("05120","荔枝FM");
		map.put("06999","FTP");
		map.put("07999","SSL");
		map.put("08001","IP黑名单");
		map.put("08002","IP监测");
		map.put("08003","IP一般日志");
		Map<String,Object> mapp=new HashMap<String,Object>();
		mapp.put("id", xxid);
		mapp.put("name", map.containsKey(xxid)?map.get(xxid):"");
		return mapp;
	}
//	public static Map<String,Object> XXIDS(String dlyx){
//		Map<String,Object> map=new HashMap<String,Object>();
//		map.put("HTTP","01999");
//		map.put("DNS","02999");
//		map.put("WEBMAIL","03001");
//		map.put("SMTP","03002");
//		map.put("POP3","03003");
//		map.put("IMAP","03004");
//		map.put("PPTP","04001");
//		map.put("L2TP","04002");
//		map.put("OpenVPN","04003");
//		map.put("IPSec","04004");
//		map.put("QQ","05001");
//		map.put("BlackLight","05002");
//		map.put("钉钉","05003");
//		map.put("翼聊","05004");
//		map.put("Hangouts","05005");
//		map.put("个信","05006");
//		map.put("微信电话本","05007");
//		map.put("飞聊","05008");
//		map.put("环聊","05009");
//		map.put("有信电话","05010");
//		map.put("友约","05011");
//		map.put("遇见","05012");
//		map.put("Kik","05013");
//		map.put("微爱","05014");
//		map.put("Tango","05015");
//		map.put("敢聊","05016");
//		map.put("微信","05017");
//		map.put("易信","05018");
//		map.put("旺信","05019");
//		map.put("Tumblr","05020");
//		map.put("Blued","05021");
//		map.put("网聊","05022");
//		map.put("快传","05023");
//		map.put("唱吧","05024");
//		map.put("比邻","05025");
//		map.put("千牛","05026");
//		map.put("派派","05027");
//		map.put("找对象","05028");
//		map.put("IM+","05029");
//		map.put("微聚","05030");
//		map.put("BBM","05031");
//		map.put("LOFTER","05032");
//		map.put("Weico","05033");
//		map.put("米聊","05034");
//		map.put("YY语音","05035");
//		map.put("Skype","05036");
//		map.put("Path","05037");
//		map.put("网易泡泡","05038");
//		map.put("有你","05039");
//		map.put("微乐","05040");
//		map.put("GO短信","05041");
//		map.put("和通讯录","05042");
//		map.put("约爱","05043");
//		map.put("无秘","05044");
//		map.put("Wicker","05045");
//		map.put("约会吧","05046");
//		map.put("hikemessager","05047");
//		map.put("摩擦","05048");
//		map.put("探探","05049");
//		map.put("陌陌","05050");
//		map.put("点点虫","05051");
//		map.put("百度Hi","05052");
//		map.put("ZANK","05053");
//		map.put("小恩爱","05054");
//		map.put("飞信","05055");
//		map.put("ChatON","05056");
//		map.put("QT语音","05057");
//		map.put("爱聊","05058");
//		map.put("nice好赞","05059");
//		map.put("朋友印象","05060");
//		map.put("Googletalk","05061");
//		map.put("友加","05062");
//		map.put("Keechat","05063");
//		map.put("啪啪音乐圈","05064");
//		map.put("微会","05065");
//		map.put("Radicall","05066");
//		map.put("槽厂","05067");
//		map.put("想恋爱","05068");
//		map.put("颜值点评","05069");
//		map.put("LinkedIn","05070");
//		map.put("Telegram","05071");
//		map.put("DiDi","05072");
//		map.put("ICQ","05073");
//		map.put("Zello","05074");
//		map.put("NextDoor","05075");
//		map.put("Pinterest","05076");
//		map.put("叮咚","05077");
//		map.put("床上","05078");
//		map.put("Nimbuzz","05079");
//		map.put("微人脉","05080");
//		map.put("陪陪","05081");
//		map.put("微密","05082");
//		map.put("Vine","05083");
//		map.put("Line","05084");
//		map.put("between","05085");
//		map.put("facebook","05086");
//		map.put("Viber","05087");
//		map.put("MeetUP","05088");
//		map.put("MeetMe","05089");
//		map.put("OkCupidDating","05090");
//		map.put("碰碰","05091");
//		map.put("Diaspora","05092");
//		map.put("咚呱","05093");
//		map.put("陪聊","05094");
//		map.put("Twitter","05095");
//		map.put("Kakao","05096");
//		map.put("MSN","05097");
//		map.put("Voxer","05098");
//		map.put("Airetalk","05099");
//		map.put("ooVoo","05100");
//		map.put("Mico","05101");
//		map.put("Banjo","05102");
//		map.put("TextNow","05103");
//		map.put("抱抱","05104");
//		map.put("多多的鱼","05105");
//		map.put("个性","05106");
//		map.put("闺蜜圈","05107");
//		map.put("Instagram","05108");
//		map.put("Whatsapp","05109");
//		map.put("Talkbox","05110");
//		map.put("ChatOn","05111");
//		map.put("Coco","05112");
//		map.put("Badoo","05113");
//		map.put("Match.com","05114");
//		map.put("TextFree","05115");
//		map.put("Tapatalk","05116");
//		map.put("KC网络电话","05117");
//		map.put("爱唱","05118");
//		map.put("酷我","05119");
//		map.put("荔枝FM","05120");
//		map.put("FTP","06999");
//		map.put("SSL","07999");
//		map.put("IP黑名单","08001");
//		map.put("IP监测","08002");
//		map.put("IP一般日志","08003");
//		return map;
//	}
}
