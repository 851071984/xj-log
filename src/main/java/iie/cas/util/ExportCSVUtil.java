package iie.cas.util;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import net.sf.json.JSONObject;

public class ExportCSVUtil {
	public static LinkedHashMap<String, Object> getMap(String logType){
		LinkedHashMap<String, Object> mapValue = new LinkedHashMap<>();
		mapValue.put("1","配置ID");
		mapValue.put("2","前端机IP");
		mapValue.put("3","详细分类");
		mapValue.put("4","源地址");
		mapValue.put("5","目的地址");
		mapValue.put("6","源端口");
		mapValue.put("7","目的端口");
		mapValue.put("8","源地域");
		mapValue.put("9","目的地域");
		mapValue.put("10","来函函号");
		mapValue.put("11","传输协议");
		mapValue.put("12","捕获时间");
		mapValue.put("13","运营商");
		mapValue.put("14","管控类别");
		mapValue.put("15","标签");
		if (logType.equals("0101")) {
			
		} else if (logType.equals("0201")) {

		} else if (logType.equals("0301")) {

		} else if (logType.equals("0103")) {

		} else if (logType.equals("0303")) {

		} else if (logType.equals("0402")) {
			mapValue.put("16","域名地址");
			mapValue.put("17","域名请求结果");
		} else if (logType.equals("0403")) {
			mapValue.put("16","语言种类");
			mapValue.put("17","访问域");
			mapValue.put("18","请求URL");
			mapValue.put("19","浏览器");
			mapValue.put("20","Cookie");
			mapValue.put("21","文件名");
			mapValue.put("22","内容");
		} else if (logType.equals("0404")) {
			mapValue.put("16","语言种类");
			mapValue.put("17","访问域");
			mapValue.put("18","请求URL");
			mapValue.put("19","浏览器");
			mapValue.put("20","Cookie");
			mapValue.put("21","文件名");
			mapValue.put("22","内容");
		} else if (logType.equals("0405")) {
			mapValue.put("16","证书名称");
			mapValue.put("17","颁发者");
			mapValue.put("18","使用者");
			mapValue.put("19","服务器名称");
		} else if (logType.equals("0406")) {
			mapValue.put("16","语言种类");
			mapValue.put("17","JC URL");
			mapValue.put("18","内容");
			mapValue.put("19","搜索引擎名称");
			mapValue.put("20","关键字");
		} else if (logType.equals("0407")) {
			mapValue.put("16","语言种类");
			mapValue.put("17","发件人");
			mapValue.put("18","收件人");
			mapValue.put("19","收件人个数");
			mapValue.put("20","抄送");
			mapValue.put("21","抄送人个数");
			mapValue.put("22","邮件主题");
			mapValue.put("23","内容");
			mapValue.put("24","是否有附件");
			mapValue.put("25","文件名");
			mapValue.put("26","文件路径");
			mapValue.put("27","登录密码");
			mapValue.put("28","发件服务商");
			mapValue.put("29","发件服务商所在地");
			mapValue.put("30","收件服务商");
			mapValue.put("31","收件服务商所在地");
			mapValue.put("32","协议类型");
			mapValue.put("33","关键字");	
		} else if (logType.equals("0408")) {
			mapValue.put("16","语言种类");
			mapValue.put("17","文件名");
			mapValue.put("18","文件路径");
			mapValue.put("19","关键字");
		} else if (logType.equals("0409")) {
			mapValue.put("16","语言种类");
			mapValue.put("17","JC URL");
			mapValue.put("18","内容");
			mapValue.put("19","搜索引擎名称");
			mapValue.put("20","关键字");
		} else if (logType.equals("0410")) {
			mapValue.put("16","语言种类");
			mapValue.put("17","发件人");
			mapValue.put("18","收件人");
			mapValue.put("19","收件人个数");
			mapValue.put("20","抄送");
			mapValue.put("21","抄送人个数");
			mapValue.put("22","邮件主题");
			mapValue.put("23","内容");
			mapValue.put("24","是否有附件");
			mapValue.put("25","文件名");
			mapValue.put("26","文件路径");
			mapValue.put("27","登录密码");
			mapValue.put("28","发件服务商");
			mapValue.put("29","发件服务商所在地");
			mapValue.put("30","收件服务商");
			mapValue.put("31","收件服务商所在地");
			mapValue.put("32","协议类型");
			mapValue.put("33","关键字");	
		} else if (logType.equals("0411")) {
			mapValue.put("16","URL");
			mapValue.put("17","用户名");
			mapValue.put("18","密码");
		} else if (logType.equals("0412")) {
			mapValue.put("16","语言种类");
			mapValue.put("17","动作类型");
			mapValue.put("18","访问域");
			mapValue.put("19","URL");
			mapValue.put("20","浏览器");
			mapValue.put("21","用户标识");
			mapValue.put("22","内容");
			mapValue.put("23","备注");
		} else if (logType.equals("0413")) {
			mapValue.put("16","语言种类");
			mapValue.put("17","动作类型");
			mapValue.put("18","访问域");
			mapValue.put("19","URL");
			mapValue.put("20","浏览器");
			mapValue.put("21","用户标识");
			mapValue.put("22","内容");
			mapValue.put("23","备注");
		} else if (logType.equals("0501")) {
			mapValue.put("16","访问域");
			mapValue.put("17","请求URL");
			mapValue.put("18","内容");
		} else if (logType.equals("0502")) {
			mapValue.put("16","域名地址");
			mapValue.put("17","域名请求结果");
		} else if (logType.equals("0503")) {
			mapValue.put("16","语言种类");
			mapValue.put("17","访问域");
			mapValue.put("18","请求URL");
			mapValue.put("19","浏览器");
			mapValue.put("20","Cookie");
			mapValue.put("21","文件名");
			mapValue.put("22","内容");
		} else if (logType.equals("0504")) {
			mapValue.put("16","语言种类");
			mapValue.put("17","访问域");
			mapValue.put("18","请求URL");
			mapValue.put("19","浏览器");
			mapValue.put("20","Cookie");
			mapValue.put("21","文件名");
			mapValue.put("22","内容");
		} else if (logType.equals("0505")) {
			mapValue.put("16","证书名称");
			mapValue.put("17","颁发者");
			mapValue.put("18","使用者");
			mapValue.put("19","服务器名称");
		} else if (logType.equals("0506")) {
			mapValue.put("16","语言种类");
			mapValue.put("17","JC URL");
			mapValue.put("18","内容");
			mapValue.put("19","搜索引擎名称");
			mapValue.put("20","关键字");
		} else if (logType.equals("0507")) {
			mapValue.put("16","语言种类");
			mapValue.put("17","发件人");
			mapValue.put("18","收件人");
			mapValue.put("19","收件人个数");
			mapValue.put("20","抄送");
			mapValue.put("21","抄送人个数");
			mapValue.put("22","邮件主题");
			mapValue.put("23","内容");
			mapValue.put("24","是否有附件");
			mapValue.put("25","文件名");
			mapValue.put("26","文件路径");
			mapValue.put("27","登录密码");
			mapValue.put("28","发件服务商");
			mapValue.put("29","发件服务商所在地");
			mapValue.put("30","收件服务商");
			mapValue.put("31","收件服务商所在地");
			mapValue.put("32","协议类型");
			mapValue.put("33","关键字");	
		} else if (logType.equals("0508")) {
			mapValue.put("16","语言种类");
			mapValue.put("17","文件名");
			mapValue.put("18","文件路径");
			mapValue.put("19","关键字");
		} else if (logType.equals("0509")) {
			mapValue.put("16","语言种类");
			mapValue.put("17","JC URL");
			mapValue.put("18","内容");
			mapValue.put("19","搜索引擎名称");
			mapValue.put("20","关键字");
		} else if (logType.equals("0510")) {
			mapValue.put("16","语言种类");
			mapValue.put("17","发件人");
			mapValue.put("18","收件人");
			mapValue.put("19","收件人个数");
			mapValue.put("20","抄送");
			mapValue.put("21","抄送人个数");
			mapValue.put("22","邮件主题");
			mapValue.put("23","内容");
			mapValue.put("24","是否有附件");
			mapValue.put("25","文件名");
			mapValue.put("26","文件路径");
			mapValue.put("27","登录密码");
			mapValue.put("28","发件服务商");
			mapValue.put("29","发件服务商所在地");
			mapValue.put("30","收件服务商");
			mapValue.put("31","收件服务商所在地");
			mapValue.put("32","协议类型");
			mapValue.put("33","关键字");	
		} else if (logType.equals("0511")) {
			mapValue.put("16","URL");
			mapValue.put("17","用户名");
			mapValue.put("18","密码");
		} else if (logType.equals("0512")) {
			mapValue.put("16","语言种类");
			mapValue.put("17","动作类型");
			mapValue.put("18","访问域");
			mapValue.put("19","URL");
			mapValue.put("20","浏览器");
			mapValue.put("21","用户标识");
			mapValue.put("22","内容");
			mapValue.put("23","备注");
		} else if (logType.equals("0513")) {
			mapValue.put("16","语言种类");
			mapValue.put("17","动作类型");
			mapValue.put("18","访问域");
			mapValue.put("19","URL");
			mapValue.put("20","浏览器");
			mapValue.put("21","用户标识");
			mapValue.put("22","内容");
			mapValue.put("23","备注");
		} else if (logType.equals("0514")) {
			mapValue.put("16","语言种类");
			mapValue.put("17","图片文件名");
			mapValue.put("18","图片URL");
			mapValue.put("19","图片所在URL");
			mapValue.put("20","图片类型");
			mapValue.put("21","图片内容");
		} else if (logType.equals("0515")) {
			mapValue.put("16","语言种类");
			mapValue.put("17","多媒体文件名");
			mapValue.put("18","多媒体URL");
			mapValue.put("19","多媒体所在URL");
			mapValue.put("20","多媒体类型");
			mapValue.put("21","多媒体内容");
		} else if (logType.equals("0601")) {

		} else if (logType.equals("0701")) {

		} else if (logType.equals("0702")) {

		} else {

		}
		return mapValue;
		
	}
	public static List getList(List<Map<String, Object>> list2,String logType){
		List<Map<String, Object>> exportData=new ArrayList<Map<String, Object>>();
		Map<String, Object> row1 = new LinkedHashMap<String, Object>();  
		for(int i=0;i<list2.size();i++){
			row1 = new LinkedHashMap<String, Object>();  
			row1.put("1", StringUtils.isNotBlank(list2.get(i).get("pzid")+"")?"\""+list2.get(i).get("pzid")+"\"":"无");
			row1.put("2", StringUtils.isNotBlank(list2.get(i).get("qdjip")+"")?"\""+list2.get(i).get("qdjip")+"\"":"无");
			row1.put("3", StringUtils.isNotBlank(list2.get(i).get("detailId")+"")?"\""+JSONObject.fromObject(list2.get(i).get("detailId")).get("name")+"\"":"无");
			row1.put("4", StringUtils.isNotBlank(list2.get(i).get("sip")+"")?"\""+list2.get(i).get("sip")+"\"":"无");
			row1.put("5", StringUtils.isNotBlank(list2.get(i).get("dip")+"")?"\""+list2.get(i).get("dip")+"\"":"无");
			row1.put("6", StringUtils.isNotBlank(list2.get(i).get("sport")+"")?"\""+list2.get(i).get("sport")+"\"":"无");
			row1.put("7", StringUtils.isNotBlank(list2.get(i).get("dport")+"")?"\""+list2.get(i).get("dport")+"\"":"无");
			row1.put("8", StringUtils.isNotBlank(list2.get(i).get("ydy")+"")?"\""+JSONObject.fromObject(list2.get(i).get("ydy")).get("name")+"\"":"无");
			row1.put("9", StringUtils.isNotBlank(list2.get(i).get("mddy")+"")?"\""+JSONObject.fromObject(list2.get(i).get("mddy")).get("name")+"\"":"无");
			row1.put("10", StringUtils.isNotBlank(list2.get(i).get("lhid")+"")?"\""+list2.get(i).get("lhid")+"\"":"无");
			row1.put("11", StringUtils.isNotBlank(list2.get(i).get("protocol")+"")?"\""+JSONObject.fromObject(list2.get(i).get("protocol")).get("name")+"\"":"无");
			row1.put("12", StringUtils.isNotBlank(list2.get(i).get("bhsj")+"")?"\""+list2.get(i).get("bhsj")+"\"":"无");
			row1.put("13", StringUtils.isNotBlank(list2.get(i).get("yys")+"")?"\""+JSONObject.fromObject(list2.get(i).get("yys")).get("name")+"\"":"无");
			row1.put("14", StringUtils.isNotBlank(list2.get(i).get("gklb")+"")?"\""+JSONObject.fromObject(list2.get(i).get("gklb")).get("name")+"\"":"无");
			row1.put("15", StringUtils.isNotBlank(list2.get(i).get("labels")+"")?"\""+list2.get(i).get("labels")+"\"":"无");
			if (logType.equals("0101")) {
				
			} else if (logType.equals("0201")) {

			} else if (logType.equals("0301")) {

			} else if (logType.equals("0103")) {

			} else if (logType.equals("0303")) {

			} else if (logType.equals("0402")) {
				row1.put("16", StringUtils.isNotBlank(list2.get(i).get("dnsName")+"")?"\""+list2.get(i).get("dnsName")+"\"":"无");
				row1.put("17", StringUtils.isNotBlank(list2.get(i).get("dnsValue")+"")?"\""+list2.get(i).get("dnsValue")+"\"":"无");
			} else if (logType.equals("0403")) {
				row1.put("16", StringUtils.isNotBlank(list2.get(i).get("yyzl")+"")?"\""+JSONObject.fromObject(list2.get(i).get("yyzl")).get("name")+"\"":"无");
				row1.put("17", StringUtils.isNotBlank(list2.get(i).get("host")+"")?"\""+list2.get(i).get("host")+"\"":"无");
				row1.put("18", StringUtils.isNotBlank(list2.get(i).get("dnsValue")+"")?"\""+list2.get(i).get("dnsValue")+"\"":"无");
				row1.put("19", StringUtils.isNotBlank(list2.get(i).get("dnsValue")+"")?"\""+list2.get(i).get("dnsValue")+"\"":"无");
				row1.put("20", StringUtils.isNotBlank(list2.get(i).get("dnsValue")+"")?"\""+list2.get(i).get("dnsValue")+"\"":"无");
				row1.put("21", StringUtils.isNotBlank(list2.get(i).get("dnsValue")+"")?"\""+list2.get(i).get("dnsValue")+"\"":"无");
				row1.put("22", StringUtils.isNotBlank(list2.get(i).get("dnsValue")+"")?"\""+list2.get(i).get("dnsValue")+"\"":"无");
			} else if (logType.equals("0404")) {
				
			} else if (logType.equals("0405")) {
				
			} else if (logType.equals("0406")) {
				
			} else if (logType.equals("0407")) {
				
			} else if (logType.equals("0408")) {
				
			} else if (logType.equals("0409")) {
				
			} else if (logType.equals("0410")) {
				
			} else if (logType.equals("0411")) {
				
			} else if (logType.equals("0412")) {
				
			} else if (logType.equals("0413")) {
				
			} else if (logType.equals("0501")) {
				
			} else if (logType.equals("0502")) {
				
			} else if (logType.equals("0503")) {
				
			} else if (logType.equals("0504")) {
				
			} else if (logType.equals("0505")) {
				
			} else if (logType.equals("0506")) {
				
			} else if (logType.equals("0507")) {
				
			} else if (logType.equals("0508")) {
				
			} else if (logType.equals("0509")) {
				
			} else if (logType.equals("0510")) {
				
			} else if (logType.equals("0511")) {
				
			} else if (logType.equals("0512")) {
				
			} else if (logType.equals("0513")) {
				
			} else if (logType.equals("0514")) {
				
			} else if (logType.equals("0515")) {
				
			} else if (logType.equals("0601")) {

			} else if (logType.equals("0701")) {

			} else if (logType.equals("0702")) {

			} else {

			}
			exportData.add(row1);
		}
		return exportData;
	}
}
