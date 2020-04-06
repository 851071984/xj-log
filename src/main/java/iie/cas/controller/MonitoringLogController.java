package iie.cas.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;

import iie.cas.dao.primary.AreaCodeTMapper;
import iie.cas.dao.primary.BaseJklhMapper;
import iie.cas.dao.primary.BaseLabelMapper;
import iie.cas.dao.primary.ExportCsvMapper;
import iie.cas.po.primary.AreaCodeT;
import iie.cas.po.primary.BaseJklh;
import iie.cas.po.primary.BaseLabel;
import iie.cas.po.primary.ExportCsv;
import iie.cas.po.primary.UserCheckMorePo;
import iie.cas.service.JCSJService;
import iie.cas.service.MonitoringLogService;
import iie.cas.util.CSVUtils;
import iie.cas.util.ExportCSVUtil;
import iie.cas.util.HttpsUtils;
import iie.cas.util.IPNo;
import net.sf.json.JSONObject;

@CrossOrigin
@RestController
@RequestMapping("Monitoringlog")
public class MonitoringLogController {
	@Autowired
	private MonitoringLogService monitoringLogService;
	@Autowired
	private JCSJService jCSJService;
	@Autowired
	private BaseLabelMapper baseLabelMapper;
	@Autowired
	private BaseJklhMapper baseJklhMapper;
	@Autowired
	private ExportCsvMapper exportCsvMapper;
	@Autowired
	private AreaCodeTMapper areaCodeTMapper;
	/**
	 * 
	 * @param startTime
	 *            起始时间
	 * @param endTime
	 *            截止时间
	 * @param pzid
	 *            配置ID
	 * @param labels
	 *            标签
	 * @param lhid
	 *            来函ID
	 * @param ydy
	 *            源地域
	 * @param mddy
	 *            目的地域
	 * @param pzlx
	 *            配置类型
	 * @param gklb
	 *            管控类别
	 * @param protocol
	 *            传输协议
	 * @param sip
	 *            源地址
	 * @param dip
	 *            目的地址
	 * @param sport
	 *            源端口
	 * @param dport
	 *            目的端口
	 * @param pageNo
	 *            当前页数
	 * @param pageSize
	 *            每页日志数
	 * @param logType
	 *            日志类型
	 * @param dnsValue
	 *            域名请求结果
	 * @param dnsName
	 *            域名地址
	 * @param fileName
	 *            文件名
	 * @param content
	 *            内容
	 * @param host
	 *            访问域
	 * @param cookie
	 *            Cookie
	 * @param yyzl
	 *            语言种类
	 * @param userAgent
	 *            浏览器
	 * @param url
	 *            请求URL
	 * @param fwqmc
	 *            服务器名称
	 * @param syz
	 *            使用者
	 * @param zsmc
	 *            证书名称
	 * @param bfz
	 *            颁发者
	 * @param ssyq
	 *            搜索引擎名称
	 * @param jcUrl
	 *            JC URL
	 * @param gjz
	 *            关键字
	 * @param receverNum
	 *            收件人个数
	 * @param mailRecever
	 *            收件人
	 * @param sjfws
	 *            收件服务商
	 * @param mailSubject
	 *            邮件主题
	 * @param mailSender
	 *            发件人
	 * @param sjfwsSzd
	 *            收件服务商所在地
	 * @param fjfwsSzd
	 *            发件服务商所在地
	 * @param ccNum
	 *            抄送人个数
	 * @param fjfws
	 *            发件服务商
	 * @param xylx
	 *            协议类型
	 * @param pwd
	 *            登录密码
	 * @param accessory
	 *            是否有附件
	 * @param fileContent
	 *            文件路径
	 * @param mailCc
	 *            抄送
	 * @param username
	 *            用户名
	 * @param userId
	 *            用户标识
	 * @param reserved
	 *            备注
	 * @param dzId
	 *            动作类型
	 * @param scBytes
	 *            s->c字节数
	 * @param csPkts
	 *            c->s包个数
	 * @param csBytes
	 *            c->s字节数
	 * @param scPkts
	 *            s->c包个数
	 * @param picName
	 *            文件名
	 * @param picUrl
	 *            图片URl
	 * @param picType
	 *            图片类型
	 * @param picContent
	 *            图片内容
	 * @param mediaContent
	 *            多媒体内容
	 * @param mediaName
	 *            文件名
	 * @param mediaUrl
	 *            多媒体URl
	 * @param mediaType
	 *            多媒体类型
	 * @param qdjip
	 *            前端机ip
	 * @return
	 */
	@RequestMapping(value = "/queryLogInfo")
	public Map<String, Object> queryLogInfo(String startTime, String pzid, String labels, String lhhh, String ydy,
			String mddy, String[] gklbs, String protocol, String sip, String dip,
			@RequestParam(value = "sport", required = false) String sports,
			@RequestParam(value = "dport", required = false) String dports,
			@RequestParam(value = "pageNo", required = true, defaultValue = "1") int pageNo,
			@RequestParam(value = "pageSize", required = true, defaultValue = "10") int pageSize,
			@RequestParam(value = "logType", required = true) String logType, String endTime, String yys, Integer num,
			String dnsValue, String dnsName, String fileName, String content, String host, String cookie, String[] yyzl,
			String userAgent, String url, String fwqmc, String syz, String zsmc, String bfz, String ssyq, String jcUrl,
			String gjz, String receverNum, String mailRecever, String sjfws, String mailSubject, String mailSender,
			String sjfwsSzd, String fjfwsSzd, String ccNum, String fjfws, String xylx, String pwd, String accessory,
			String fileContent, String mailCc, String username, String userId, String reserved, String dzId,
			Integer scBytes, Integer csPkts, Integer csBytes, Integer scPkts, String picName, String picUrl, String picType,
			String picContent, String mediaContent, String mediaName, String mediaUrl, String mediaType, String qdjip,HttpServletRequest request) {
		String token=request.getHeader("Access-Token");
		Map<String, Object> map = new HashMap<>();
		if(token==null||token.equals("NULL")||token.equals("null")){
			map.put("code", 600);
			map.put("message", "token不可为空");
			return map;
		}
		String gblb="";
		String lhid="";
		String yyzls="";
		
		Integer sport=null;
		Integer dport=null;
		try {
			if(StringUtils.isNotBlank(sports)){
				sport=Integer.valueOf(sports);
			}
			if(StringUtils.isNotBlank(dports)){
				dport=Integer.valueOf(dports);
			}
		} catch (Exception e) {
			map.put("code", 400);
			map.put("message", "请输入正确的端口号");
			return map;
		}
		if(StringUtils.isNotBlank(labels)){
			if(labels.split(",").length>5){
				String[] label=Arrays.copyOfRange(labels.split(","), 0, 5);
				labels="";
				for(String labe:label){
					labels+=labe+",";
				}
				labels=labels.substring(0,labels.length()-1);
			}
//			String labe="";
//			for(String label:labels.split(",")){
//				BaseLabel baselabel=baseLabelMapper.SelectName(label);
//				if(baselabel!=null){
//					labe+=baselabel.getBqid()+",";
//				}
//			}
//			if(labe.length()>0){
//				labels=labe.substring(0,labe.length()-1);
//			}
//			
		}
		if(yyzl!=null&&yyzl.length>0){
			for(String gk:yyzl){
				yyzls+=gk+",";
			}
			yyzls=yyzls.substring(0,yyzls.length()-1);
		}
		if(StringUtils.isNotBlank(lhhh)){
			BaseJklh base=baseJklhMapper.SelectName(lhhh);
			if(base!=null){
				lhid=base.getLhid()+"";
			}else{
				map.put("code", 400);
				map.put("message", "此来函函号不存在");
				return map;
			}
			
		}
		if(gklbs!=null&&gklbs.length>0){
//			gblb+="( ";
			for(String gk:gklbs){
				gblb+=gk+",";
			}
			gblb=gblb.substring(0,gblb.length()-1);
//			gblb+=")";
		}
		if (logType == null || logType.equals("")) {
			map.put("code", 400);
			map.put("message", "日志类型不可为空");
			return map;
		}
		if(dport!=null){
			if(dport>65535||dport<0){
				map.put("code", 400);
				map.put("message", "请输入正确的端口号");
				return map;
			}
		}
		if(sport!=null){
			if(sport>65535||sport<0){
				map.put("code", 400);
				map.put("message", "请输入正确的端口号");
				return map;
			}
		}
		
		if(StringUtils.isNotBlank(sip)){
			if(!IPNo.isIp(sip)){
				map.put("code", 400);
				map.put("message", "请输入正确的ip");
				return map;
			}
		}
		if(StringUtils.isNotBlank(dip)){
			if(!IPNo.isIp(dip)){
				map.put("code", 400);
				map.put("message", "请输入正确的ip");
				return map;
			}
		}
		if(StringUtils.isNotBlank(qdjip)){
			if(!IPNo.isIp(qdjip)){
				map.put("code", 400);
				map.put("message", "请输入正确的ip");
				return map;
			}
		}
		//权限
		Map<String,String> maq=new HashMap<>();
		maq.put("10", "tycx");
		UserCheckMorePo user=new UserCheckMorePo();
		user.setAccessToken(token);
		user.setAreaCheck(true);
		user.setModeluAction(maq);
		String value=HttpsUtils.doPost("http://172.16.18.11:8444/auth/system/check/userCheckMoreAction",JSON.toJSONString(user));
		System.out.println(value);
		System.out.println(token);
		net.sf.json.JSONObject data=JSONObject.fromObject(value);
		String result=data.getString("result");
		String  accessToken=data.getString("Access-Token");
		List<String> list=new ArrayList<String>();
		if(result.equals("false")){
			map.put("code", 600);
			map.put("message", "无权限 ");
		}
		String area=data.getString("area");
		if(area.equals("650000")||area.contains("650000")){
			
		}else {
			List<Integer> listdy=new ArrayList<Integer>();
			for(String dy:area.split(",")) {
				listdy.add(Integer.valueOf(dy));
			}
			List<AreaCodeT> areaCodeList=areaCodeTMapper.SelectList(listdy);
			for(AreaCodeT areaCodet:areaCodeList) {
				list.add(areaCodet.getId()+"");
			}
		}
		
		map = new HashMap<>();
		if (logType.equals("0101")) {
			map.put("code", 400);
			map.put("message", "当前日志类型不存在 ");
			return map;
		} else if (logType.equals("0201")) {
			 map=monitoringLogService.IPHMDqueryLogInfo(startTime, pzid, labels, lhid, ydy, mddy, 201, gblb, protocol,
					sip, dip, sport, dport, pageNo, pageSize, logType, endTime, qdjip,yys,0,list);
		} else if (logType.equals("0301")) {
			map.put("code", 400);
			map.put("message", "当前日志类型不存在 ");
			return map;
		} else if (logType.equals("0103")) {
			map.put("code", 400);
			map.put("message", "当前日志类型不存在 ");
			return map;
		} else if (logType.equals("0303")) {
			map.put("code", 400);
			map.put("message", "当前日志类型不存在 ");
			return map;
		} else if (logType.equals("0402")) {
			map=monitoringLogService.DNSGKqueryLogInfo(startTime, pzid, labels, lhid, ydy, mddy, 402, gblb, protocol,
					sip, dip, sport, dport, pageNo, pageSize, logType, endTime, qdjip, dnsValue, dnsName,yys,0,list);
		} else if (logType.equals("0403")) {
			map= monitoringLogService.HTTPGKqueryLogInfo(startTime, pzid, labels, lhid, ydy, mddy, 403, gblb, protocol,
					sip, dip, sport, dport, pageNo, pageSize, logType, endTime, qdjip, fileName, content, host, cookie,
					yyzls, userAgent, url,yys,0,list);
		} else if (logType.equals("0404")) {
			map= monitoringLogService.HTTPGKqueryLogInfo(startTime, pzid, labels, lhid, ydy, mddy, 404, gblb, protocol,
					sip, dip, sport, dport, pageNo, pageSize, logType, endTime, qdjip, fileName, content, host, cookie,
					yyzls, userAgent, url,yys,0,list);
		} else if (logType.equals("0405")) {
			map= monitoringLogService.SSLGKqueryLogInfo(startTime, pzid, labels, lhid, ydy, mddy, 405, gblb, protocol,
					sip, dip, sport, dport, pageNo, pageSize, logType, endTime, qdjip, fwqmc, syz, zsmc, bfz,yys,0,list);
		} else if (logType.equals("0406")) {
			map= monitoringLogService.WYGJCGKqueryLogInfo(startTime, pzid, labels, lhid, ydy, mddy, 406, gblb,
					protocol, sip, dip, sport, dport, pageNo, pageSize, logType, endTime, qdjip, ssyq, content, yyzls,
					jcUrl, gjz,yys,0,list);
		} else if (logType.equals("0407")) {
			map= monitoringLogService.MAILGKqueryLogInfo(startTime, pzid, labels, lhid, ydy, mddy, 407, gblb, protocol,
					sip, dip, sport, dport, pageNo, pageSize, logType, endTime, qdjip, fileName, receverNum,
					mailRecever, sjfws, content, mailSubject, mailSender, sjfwsSzd, fjfwsSzd, ccNum, yyzls, fjfws, xylx,
					gjz, pwd, accessory, fileContent, mailCc,yys,0,list);
		} else if (logType.equals("0408")) {
			map= monitoringLogService.FTPGJCGKqueryLogInfo(startTime, pzid, labels, lhid, ydy, mddy, 408, gblb,
					protocol, sip, dip, sport, dport, pageNo, pageSize, logType, endTime, qdjip, fileName, yyzls, gjz,
					fileContent,yys,0,list);
		} else if (logType.equals("0409")) {
			map= monitoringLogService.WYGJCGKqueryLogInfo(startTime, pzid, labels, lhid, ydy, mddy, 409, gblb,
					protocol, sip, dip, sport, dport, pageNo, pageSize, logType, endTime, qdjip, ssyq, content, yyzls,
					jcUrl, gjz,yys,0,list);
		} else if (logType.equals("0410")) {
			map= monitoringLogService.MAILGKqueryLogInfo(startTime, pzid, labels, lhid, ydy, mddy, 410, gblb, protocol,
					sip, dip, sport, dport, pageNo, pageSize, logType, endTime, qdjip, fileName, receverNum,
					mailRecever, sjfws, content, mailSubject, mailSender, sjfwsSzd, fjfwsSzd, ccNum, yyzls, fjfws, xylx,
					gjz, pwd, accessory, fileContent, mailCc,yys,0,list);
		} else if (logType.equals("0411")) {
			map= monitoringLogService.VPNGKqueryLogInfo(startTime, pzid, labels, lhid, ydy, mddy, 411, gblb, protocol,
					sip, dip, sport, dport, pageNo, pageSize, logType, endTime, qdjip, url, pwd, username,yys,0,list);
		} else if (logType.equals("0412")) {
			map= monitoringLogService.JSTXGKqueryLogInfo(startTime, pzid, labels, lhid, ydy, mddy, 412, gblb, protocol,
					sip, dip, sport, dport, pageNo, pageSize, logType, endTime, qdjip, content, host, yyzls, userAgent,
					userId, url, reserved, dzId,yys,0,list);
		} else if (logType.equals("0413")) {
			map= monitoringLogService.JSTXGKqueryLogInfo(startTime, pzid, labels, lhid, ydy, mddy, 413, gblb, protocol,
					sip, dip, sport, dport, pageNo, pageSize, logType, endTime, qdjip, content, host, yyzls, userAgent,
					userId, url, reserved, dzId,yys,0,list);
		} else if (logType.equals("0501")) {
			map= monitoringLogService.IPJCqueryLogInfo(startTime, pzid, labels, lhid, ydy, mddy, 501, gblb, protocol,
					sip, dip, sport, dport, pageNo, pageSize, logType, endTime, qdjip, scBytes, content, host, csPkts,
					url, csBytes, scPkts,yys,0,list);
		} else if (logType.equals("0502")) {
			map= monitoringLogService.DNSJCqueryLogInfo(startTime, pzid, labels, lhid, ydy, mddy, 502, gblb, protocol,
					sip, dip, sport, dport, pageNo, pageSize, logType, endTime, qdjip, dnsValue, dnsName, scBytes,
					csPkts, csBytes, scPkts,yys,0,list);
		} else if (logType.equals("0503")) {
			map= monitoringLogService.HTTPJCqueryLogInfo(startTime, pzid, labels, lhid, ydy, mddy, 503, gblb, protocol,
					sip, dip, sport, dport, pageNo, pageSize, logType, endTime, qdjip, fileName, scBytes, content, host,
					csPkts, cookie, yyzls, userAgent, url, csBytes, scPkts,yys,0,list);
		} else if (logType.equals("0504")) {
			map= monitoringLogService.HTTPJCqueryLogInfo(startTime, pzid, labels, lhid, ydy, mddy, 504, gblb, protocol,
					sip, dip, sport, dport, pageNo, pageSize, logType, endTime, qdjip, fileName, scBytes, content, host,
					csPkts, cookie, yyzls, userAgent, url, csBytes, scPkts,yys,0,list);
		} else if (logType.equals("0505")) {
			map= monitoringLogService.SSLJCqueryLogInfo(startTime, pzid, labels, lhid, ydy, mddy, 505, gblb, protocol,
					sip, dip, sport, dport, pageNo, pageSize, logType, endTime, qdjip, fwqmc, scBytes, syz, csPkts,
					zsmc, bfz, csBytes, scPkts,yys,0,list);
		} else if (logType.equals("0506")) {
			map= monitoringLogService.WYGJCJCqueryLogInfo(startTime, pzid, labels, lhid, ydy, mddy, 506, gblb,
					protocol, sip, dip, sport, dport, pageNo, pageSize, logType, endTime, qdjip, scBytes, ssyq, content,
					csPkts, yyzls, jcUrl, gjz, csBytes, scPkts,yys,0,list);
		} else if (logType.equals("0507")) {
			map= monitoringLogService.MAILJCqueryLogInfo(startTime, pzid, labels, lhid, ydy, mddy, 507, gblb, protocol,
					sip, dip, sport, dport, pageNo, pageSize, logType, endTime, qdjip, fileName, receverNum,
					mailRecever, scBytes, sjfws, content, mailSubject, mailSender, sjfwsSzd, csPkts, fjfwsSzd, ccNum,
					yyzls, fjfws, xylx, gjz, csBytes, scPkts, pwd, accessory, fileContent, mailCc,yys,0,list);
		} else if (logType.equals("0508")) {
			map= monitoringLogService.FTPGJCJCqueryLogInfo(startTime, pzid, labels, lhid, ydy, mddy, 508, gblb,
					protocol, sip, dip, sport, dport, pageNo, pageSize, logType, endTime, qdjip, fileName, scBytes,
					csPkts, yyzls, gjz, csBytes, scPkts, fileContent,yys,0,list);
		} else if (logType.equals("0509")) {
			map= monitoringLogService.WYGJCJCqueryLogInfo(startTime, pzid, labels, lhid, ydy, mddy, 509, gblb,
					protocol, sip, dip, sport, dport, pageNo, pageSize, logType, endTime, qdjip, scBytes, ssyq, content,
					csPkts, yyzls, jcUrl, gjz, csBytes, scPkts,yys,0,list);
		} else if (logType.equals("0510")) {
			map= monitoringLogService.MAILJCqueryLogInfo(startTime, pzid, labels, lhid, ydy, mddy, 510, gblb, protocol,
					sip, dip, sport, dport, pageNo, pageSize, logType, endTime, qdjip, fileName, receverNum,
					mailRecever, scBytes, sjfws, content, mailSubject, mailSender, sjfwsSzd, csPkts, fjfwsSzd, ccNum,
					yyzls, fjfws, xylx, gjz, csBytes, scPkts, pwd, accessory, fileContent, mailCc,yys,0,list);
		} else if (logType.equals("0511")) {
			map= monitoringLogService.VPNJCqueryLogInfo(startTime, pzid, labels, lhid, ydy, mddy, 511, gblb, protocol,
					sip, dip, sport, dport, pageNo, pageSize, logType, endTime, qdjip, scBytes, csPkts, url, csBytes,
					scPkts, pwd, username,yys,0,list);
		} else if (logType.equals("0512")) {
			map= monitoringLogService.JSTXJCqueryLogInfo(startTime, pzid, labels, lhid, ydy, mddy, 512, gblb, protocol,
					sip, dip, sport, dport, pageNo, pageSize, logType, endTime, qdjip, scBytes, content, host, csPkts,
					yyzls, userAgent, userId, url, reserved, csBytes, scPkts, dzId,yys,0,list);
		} else if (logType.equals("0513")) {
			map= monitoringLogService.JSTXJCqueryLogInfo(startTime, pzid, labels, lhid, ydy, mddy, 513, gblb, protocol,
					sip, dip, sport, dport, pageNo, pageSize, logType, endTime, qdjip, scBytes, content, host, csPkts,
					yyzls, userAgent, userId, url, reserved, csBytes, scPkts, dzId,yys,0,list);
		} else if (logType.equals("0514")) {
			map= monitoringLogService.TPJCqueryLogInfo(startTime, pzid, labels, lhid, ydy, mddy, 514, gblb, protocol,
					sip, dip, sport, dport, pageNo, pageSize, logType, endTime, qdjip, picName, scBytes, picUrl, csPkts,
					picType, yyzls, url, picContent, csBytes, scPkts,yys,0,list);
		} else if (logType.equals("0515")) {
			map= monitoringLogService.DMTJCqueryLogInfo(startTime, pzid, labels, lhid, ydy, mddy, 515, gblb, protocol,
					sip, dip, sport, dport, pageNo, pageSize, logType, endTime, qdjip, scBytes, mediaContent, mediaName,
					csPkts, mediaUrl, yyzls, mediaType, url, csBytes, scPkts,yys,0,list);
		} else if (logType.equals("0601")) {
			map.put("code", 400);
			map.put("message", "当前日志类型不存在 ");
			return map;
		} else if (logType.equals("0701")) {
			map.put("code", 400);
			map.put("message", "当前日志类型不存在 ");
			return map;
		} else if (logType.equals("0702")) {
			map.put("code", 400);
			map.put("message", "当前日志类型不存在 ");
			return map;
		} else {
			System.out.println(logType);
			map.put("code", 400);
			map.put("message", "当前日志类型不存在 ");
			return map;
		}
		map.put("accessToken", accessToken);
		return map;

	}
	@RequestMapping(value = "/downloadLogInfoWhole")
	public Map<String, Object> downloadLogInfoWhole(HttpServletResponse response,String startTime, String pzid, String labels, String lhhh, String ydy,
			String mddy, String[] gklbs, String protocol, String sip, String dip,
			@RequestParam(value = "sport", required = false) String sports,
			@RequestParam(value = "dport", required = false) String dports,
			@RequestParam(value = "logType", required = true) String logType, String endTime, String yys, Integer num,
			String dnsValue, String dnsName, String fileName, String content, String host, String cookie, String[] yyzl,
			String userAgent, String url, String fwqmc, String syz, String zsmc, String bfz, String ssyq, String jcUrl,
			String gjz, String receverNum, String mailRecever, String sjfws, String mailSubject, String mailSender,
			String sjfwsSzd, String fjfwsSzd, String ccNum, String fjfws, String xylx, String pwd, String accessory,
			String fileContent, String mailCc, String username, String userId, String reserved, String dzId,
			Integer scBytes, Integer csPkts, Integer csBytes, Integer scPkts, String picName, String picUrl, String picType,
			String picContent, String mediaContent, String mediaName, String mediaUrl, String mediaType, String qdjip,HttpServletRequest request){
		String token=request.getHeader("Access-Token");
		Map<String, Object> map = new HashMap<>();
		if(token==null||token.equals("NULL")||token.equals("null")){
			map.put("code", 600);
			map.put("message", "token不可为空");
			return map;
		}
		int pageNo=1;
		int pageSize=10;
		String gblb="";
		String lhid="";
		String yyzls="";
		Integer sport=null;
		Integer dport=null;
		try {
			if(StringUtils.isNotBlank(sports)){
				sport=Integer.valueOf(sports);
			}
			if(StringUtils.isNotBlank(dports)){
				dport=Integer.valueOf(dports);
			}
		} catch (Exception e) {
			map.put("code", 400);
			map.put("message", "请输入正确的端口号");
			return map;
		}
		if(StringUtils.isNotBlank(labels)){
			if(labels.split(",").length>5){
				String[] label=Arrays.copyOfRange(labels.split(","), 0, 5);
				labels="";
				for(String labe:label){
					labels+=labe+",";
				}
				labels=labels.substring(0,labels.length()-1);
			}
		}
		if(yyzl!=null&&yyzl.length>0){
			for(String gk:yyzl){
				yyzls+=gk+",";
			}
			yyzls=yyzls.substring(0,yyzls.length()-1);
		}
		if(StringUtils.isNotBlank(lhhh)){
			BaseJklh base=baseJklhMapper.SelectName(lhhh);
			if(base!=null){
				lhid=base.getLhid()+"";
			}else{
				map.put("code", 400);
				map.put("message", "此来函函号不存在");
				return map;
			}
			
		}
		if(gklbs!=null&&gklbs.length>0){
			for(String gk:gklbs){
				gblb+=gk+",";
			}
			gblb=gblb.substring(0,gblb.length()-1);
		}
		if (logType == null || logType.equals("")) {
			map.put("code", 400);
			map.put("message", "日志类型不可为空");
			return map;
		}
		if(dport!=null){
			if(dport>65535||dport<0){
				map.put("code", 400);
				map.put("message", "请输入正确的端口号");
				return map;
			}
		}
		if(sport!=null){
			if(sport>65535||sport<0){
				map.put("code", 400);
				map.put("message", "请输入正确的端口号");
				return map;
			}
		}
		
		if(StringUtils.isNotBlank(sip)){
			if(!IPNo.isIp(sip)){
				map.put("code", 400);
				map.put("message", "请输入正确的ip");
				return map;
			}
		}
		if(StringUtils.isNotBlank(dip)){
			if(!IPNo.isIp(dip)){
				map.put("code", 400);
				map.put("message", "请输入正确的ip");
				return map;
			}
		}
		if(StringUtils.isNotBlank(qdjip)){
			if(!IPNo.isIp(qdjip)){
				map.put("code", 400);
				map.put("message", "请输入正确的ip");
				return map;
			}
		}
		//权限
				Map<String,String> maq=new HashMap<>();
				map.put("10", "tycx");
				UserCheckMorePo user=new UserCheckMorePo();
				user.setAccessToken(token);
				user.setAreaCheck(true);
				user.setModeluAction(maq);
				String value=HttpsUtils.doPost("http://172.16.18.11:8444/auth/system/check/userCheckMoreAction",JSON.toJSONString(user));
				net.sf.json.JSONObject data=JSONObject.fromObject(value);
				String result=data.getString("result");
				String  accessToken=data.getString("Access-Token");
				List<String> list=new ArrayList<String>();
				if(result.equals("false")){
					map.put("code", 600);
					map.put("message", "无权限 ");
				}
				String area=data.getString("area");
				if(area.equals("650000")||area.contains("650000")){
					
				}else {
					List<Integer> listdy=new ArrayList<Integer>();
					for(String dy:area.split(",")) {
						listdy.add(Integer.valueOf(dy));
					}
					List<AreaCodeT> areaCodeList=areaCodeTMapper.SelectList(listdy);
					for(AreaCodeT areaCodet:areaCodeList) {
						list.add(areaCodet.getId()+"");
					}
				}
		if (logType.equals("0101")) {
			map.put("code", 400);
			map.put("message", "当前日志类型不存在 ");
			return map;
		} else if (logType.equals("0201")) {
			map= monitoringLogService.IPHMDqueryLogInfo(startTime, pzid, labels, lhid, ydy, mddy, 201, gblb, protocol,
					sip, dip, sport, dport, pageNo, pageSize, logType, endTime, qdjip,yys,1,list);
		} else if (logType.equals("0301")) {
			map.put("code", 400);
			map.put("message", "当前日志类型不存在 ");
			return map;
		} else if (logType.equals("0103")) {
			map.put("code", 400);
			map.put("message", "当前日志类型不存在 ");
			return map;
		} else if (logType.equals("0303")) {
			map.put("code", 400);
			map.put("message", "当前日志类型不存在 ");
			return map;
		} else if (logType.equals("0402")) {
			map= monitoringLogService.DNSGKqueryLogInfo(startTime, pzid, labels, lhid, ydy, mddy, 402, gblb, protocol,
					sip, dip, sport, dport, pageNo, pageSize, logType, endTime, qdjip, dnsValue, dnsName,yys,1,list);
		} else if (logType.equals("0403")) {
			map= monitoringLogService.HTTPGKqueryLogInfo(startTime, pzid, labels, lhid, ydy, mddy, 403, gblb, protocol,
					sip, dip, sport, dport, pageNo, pageSize, logType, endTime, qdjip, fileName, content, host, cookie,
					yyzls, userAgent, url,yys,1,list);
		} else if (logType.equals("0404")) {
			map= monitoringLogService.HTTPGKqueryLogInfo(startTime, pzid, labels, lhid, ydy, mddy, 404, gblb, protocol,
					sip, dip, sport, dport, pageNo, pageSize, logType, endTime, qdjip, fileName, content, host, cookie,
					yyzls, userAgent, url,yys,1,list);
		} else if (logType.equals("0405")) {
			map= monitoringLogService.SSLGKqueryLogInfo(startTime, pzid, labels, lhid, ydy, mddy, 405, gblb, protocol,
					sip, dip, sport, dport, pageNo, pageSize, logType, endTime, qdjip, fwqmc, syz, zsmc, bfz,yys,1,list);
		} else if (logType.equals("0406")) {
			map= monitoringLogService.WYGJCGKqueryLogInfo(startTime, pzid, labels, lhid, ydy, mddy, 406, gblb,
					protocol, sip, dip, sport, dport, pageNo, pageSize, logType, endTime, qdjip, ssyq, content, yyzls,
					jcUrl, gjz,yys,1,list);
		} else if (logType.equals("0407")) {
			map= monitoringLogService.MAILGKqueryLogInfo(startTime, pzid, labels, lhid, ydy, mddy, 407, gblb, protocol,
					sip, dip, sport, dport, pageNo, pageSize, logType, endTime, qdjip, fileName, receverNum,
					mailRecever, sjfws, content, mailSubject, mailSender, sjfwsSzd, fjfwsSzd, ccNum, yyzls, fjfws, xylx,
					gjz, pwd, accessory, fileContent, mailCc,yys,1,list);
		} else if (logType.equals("0408")) {
			map= monitoringLogService.FTPGJCGKqueryLogInfo(startTime, pzid, labels, lhid, ydy, mddy, 408, gblb,
					protocol, sip, dip, sport, dport, pageNo, pageSize, logType, endTime, qdjip, fileName, yyzls, gjz,
					fileContent,yys,1,list);
		} else if (logType.equals("0409")) {
			map= monitoringLogService.WYGJCGKqueryLogInfo(startTime, pzid, labels, lhid, ydy, mddy, 409, gblb,
					protocol, sip, dip, sport, dport, pageNo, pageSize, logType, endTime, qdjip, ssyq, content, yyzls,
					jcUrl, gjz,yys,1,list);
		} else if (logType.equals("0410")) {
			map= monitoringLogService.MAILGKqueryLogInfo(startTime, pzid, labels, lhid, ydy, mddy, 410, gblb, protocol,
					sip, dip, sport, dport, pageNo, pageSize, logType, endTime, qdjip, fileName, receverNum,
					mailRecever, sjfws, content, mailSubject, mailSender, sjfwsSzd, fjfwsSzd, ccNum, yyzls, fjfws, xylx,
					gjz, pwd, accessory, fileContent, mailCc,yys,1,list);
		} else if (logType.equals("0411")) {
			map= monitoringLogService.VPNGKqueryLogInfo(startTime, pzid, labels, lhid, ydy, mddy, 411, gblb, protocol,
					sip, dip, sport, dport, pageNo, pageSize, logType, endTime, qdjip, url, pwd, username,yys,1,list);
		} else if (logType.equals("0412")) {
			map= monitoringLogService.JSTXGKqueryLogInfo(startTime, pzid, labels, lhid, ydy, mddy, 412, gblb, protocol,
					sip, dip, sport, dport, pageNo, pageSize, logType, endTime, qdjip, content, host, yyzls, userAgent,
					userId, url, reserved, dzId,yys,1,list);
		} else if (logType.equals("0413")) {
			map= monitoringLogService.JSTXGKqueryLogInfo(startTime, pzid, labels, lhid, ydy, mddy, 413, gblb, protocol,
					sip, dip, sport, dport, pageNo, pageSize, logType, endTime, qdjip, content, host, yyzls, userAgent,
					userId, url, reserved, dzId,yys,1,list);
		} else if (logType.equals("0501")) {
			map= monitoringLogService.IPJCqueryLogInfo(startTime, pzid, labels, lhid, ydy, mddy, 501, gblb, protocol,
					sip, dip, sport, dport, pageNo, pageSize, logType, endTime, qdjip, scBytes, content, host, csPkts,
					url, csBytes, scPkts,yys,1,list);
		} else if (logType.equals("0502")) {
			map= monitoringLogService.DNSJCqueryLogInfo(startTime, pzid, labels, lhid, ydy, mddy, 502, gblb, protocol,
					sip, dip, sport, dport, pageNo, pageSize, logType, endTime, qdjip, dnsValue, dnsName, scBytes,
					csPkts, csBytes, scPkts,yys,1,list);
		} else if (logType.equals("0503")) {
			map= monitoringLogService.HTTPJCqueryLogInfo(startTime, pzid, labels, lhid, ydy, mddy, 503, gblb, protocol,
					sip, dip, sport, dport, pageNo, pageSize, logType, endTime, qdjip, fileName, scBytes, content, host,
					csPkts, cookie, yyzls, userAgent, url, csBytes, scPkts,yys,1,list);
		} else if (logType.equals("0504")) {
			map= monitoringLogService.HTTPJCqueryLogInfo(startTime, pzid, labels, lhid, ydy, mddy, 504, gblb, protocol,
					sip, dip, sport, dport, pageNo, pageSize, logType, endTime, qdjip, fileName, scBytes, content, host,
					csPkts, cookie, yyzls, userAgent, url, csBytes, scPkts,yys,1,list);
		} else if (logType.equals("0505")) {
			map= monitoringLogService.SSLJCqueryLogInfo(startTime, pzid, labels, lhid, ydy, mddy, 505, gblb, protocol,
					sip, dip, sport, dport, pageNo, pageSize, logType, endTime, qdjip, fwqmc, scBytes, syz, csPkts,
					zsmc, bfz, csBytes, scPkts,yys,1,list);
		} else if (logType.equals("0506")) {
			map= monitoringLogService.WYGJCJCqueryLogInfo(startTime, pzid, labels, lhid, ydy, mddy, 506, gblb,
					protocol, sip, dip, sport, dport, pageNo, pageSize, logType, endTime, qdjip, scBytes, ssyq, content,
					csPkts, yyzls, jcUrl, gjz, csBytes, scPkts,yys,1,list);
		} else if (logType.equals("0507")) {
			map= monitoringLogService.MAILJCqueryLogInfo(startTime, pzid, labels, lhid, ydy, mddy, 507, gblb, protocol,
					sip, dip, sport, dport, pageNo, pageSize, logType, endTime, qdjip, fileName, receverNum,
					mailRecever, scBytes, sjfws, content, mailSubject, mailSender, sjfwsSzd, csPkts, fjfwsSzd, ccNum,
					yyzls, fjfws, xylx, gjz, csBytes, scPkts, pwd, accessory, fileContent, mailCc,yys,1,list);
		} else if (logType.equals("0508")) {
			map= monitoringLogService.FTPGJCJCqueryLogInfo(startTime, pzid, labels, lhid, ydy, mddy, 508, gblb,
					protocol, sip, dip, sport, dport, pageNo, pageSize, logType, endTime, qdjip, fileName, scBytes,
					csPkts, yyzls, gjz, csBytes, scPkts, fileContent,yys,1,list);
		} else if (logType.equals("0509")) {
			map= monitoringLogService.WYGJCJCqueryLogInfo(startTime, pzid, labels, lhid, ydy, mddy, 509, gblb,
					protocol, sip, dip, sport, dport, pageNo, pageSize, logType, endTime, qdjip, scBytes, ssyq, content,
					csPkts, yyzls, jcUrl, gjz, csBytes, scPkts,yys,1,list);
		} else if (logType.equals("0510")) {
			map= monitoringLogService.MAILJCqueryLogInfo(startTime, pzid, labels, lhid, ydy, mddy, 510, gblb, protocol,
					sip, dip, sport, dport, pageNo, pageSize, logType, endTime, qdjip, fileName, receverNum,
					mailRecever, scBytes, sjfws, content, mailSubject, mailSender, sjfwsSzd, csPkts, fjfwsSzd, ccNum,
					yyzls, fjfws, xylx, gjz, csBytes, scPkts, pwd, accessory, fileContent, mailCc,yys,1,list);
		} else if (logType.equals("0511")) {
			map= monitoringLogService.VPNJCqueryLogInfo(startTime, pzid, labels, lhid, ydy, mddy, 511, gblb, protocol,
					sip, dip, sport, dport, pageNo, pageSize, logType, endTime, qdjip, scBytes, csPkts, url, csBytes,
					scPkts, pwd, username,yys,1,list);
		} else if (logType.equals("0512")) {
			map= monitoringLogService.JSTXJCqueryLogInfo(startTime, pzid, labels, lhid, ydy, mddy, 512, gblb, protocol,
					sip, dip, sport, dport, pageNo, pageSize, logType, endTime, qdjip, scBytes, content, host, csPkts,
					yyzls, userAgent, userId, url, reserved, csBytes, scPkts, dzId,yys,1,list);
		} else if (logType.equals("0513")) {
			map= monitoringLogService.JSTXJCqueryLogInfo(startTime, pzid, labels, lhid, ydy, mddy, 513, gblb, protocol,
					sip, dip, sport, dport, pageNo, pageSize, logType, endTime, qdjip, scBytes, content, host, csPkts,
					yyzls, userAgent, userId, url, reserved, csBytes, scPkts, dzId,yys,1,list);
		} else if (logType.equals("0514")) {
			map= monitoringLogService.TPJCqueryLogInfo(startTime, pzid, labels, lhid, ydy, mddy, 514, gblb, protocol,
					sip, dip, sport, dport, pageNo, pageSize, logType, endTime, qdjip, picName, scBytes, picUrl, csPkts,
					picType, yyzls, url, picContent, csBytes, scPkts,yys,1,list);
		} else if (logType.equals("0515")) {
			map= monitoringLogService.DMTJCqueryLogInfo(startTime, pzid, labels, lhid, ydy, mddy, 515, gblb, protocol,
					sip, dip, sport, dport, pageNo, pageSize, logType, endTime, qdjip, scBytes, mediaContent, mediaName,
					csPkts, mediaUrl, yyzls, mediaType, url, csBytes, scPkts,yys,1,list);
		} else if (logType.equals("0601")) {
			map.put("code", 400);
			map.put("message", "当前日志类型不存在 ");
			return map;
		} else if (logType.equals("0701")) {
			map.put("code", 400);
			map.put("message", "当前日志类型不存在 ");
			return map;
		} else if (logType.equals("0702")) {
			map.put("code", 400);
			map.put("message", "当前日志类型不存在 ");
			return map;
		} else {
			System.out.println(logType);
			map.put("code", 400);
			map.put("message", "当前日志类型不存在 ");
			return map;
		}
		map.put("accessToken", accessToken);
		return map;

	}
	@RequestMapping(value = "/downZip")
	public Map<String, Object> downloadLogInfo(HttpServletResponse response,@RequestParam(value = "id", required = true)int id){
		    ExportCsv export=exportCsvMapper.SelectId(id);
			File file=new File("/home/huangyuchen/"+id+".zip");
			try {
			InputStream in = new FileInputStream(file);
			PrintWriter os = new PrintWriter(response.getWriter());
			response.reset();
			// 先去掉文件名称中的空格,然后转换编码格式为utf-8,保证不出现乱码,这个文件名称用于浏览器的下载框中自动显示的文件名
			response.setHeader("Content-Disposition",
					"attachment;filename=" + new String((export.getName() + ".zip").getBytes("utf-8"), "iso8859-1"));
			response.setContentType("application/octet-stream");
			int temp;
			while ((temp = in.read()) != -1) {
				os.write(temp);// 输出文件
			}
			os.flush();
			os.close();
			in.close();
			} catch (Exception e) {
				System.out.println(e);
			}
			return null;
		
	}
//	@RequestMapping(value = "/downloadLogInfo")
//	public Map<String, Object> downloadLogInfo(HttpServletResponse response,String startTime, String pzid, String labels, String lhhh, String ydy,
//			String mddy, String[] gklbs, String protocol, String sip, String dip,
//			@RequestParam(value = "sport", required = false) String sports,
//			@RequestParam(value = "dport", required = false) String dports,
//			@RequestParam(value = "logType", required = true) String logType, String endTime, String yys, Integer num,
//			String dnsValue, String dnsName, String fileName, String content, String host, String cookie, String[] yyzl,
//			String userAgent, String url, String fwqmc, String syz, String zsmc, String bfz, String ssyq, String jcUrl,
//			String gjz, String receverNum, String mailRecever, String sjfws, String mailSubject, String mailSender,
//			String sjfwsSzd, String fjfwsSzd, String ccNum, String fjfws, String xylx, String pwd, String accessory,
//			String fileContent, String mailCc, String username, String userId, String reserved, String dzId,
//			Integer scBytes, Integer csPkts, Integer csBytes, Integer scPkts, String picName, String picUrl, String picType,
//			String picContent, String mediaContent, String mediaName, String mediaUrl, String mediaType, String qdjip,HttpServletRequest request){
//		int pageNo=1;
//		int pageSize=10000;
//		String gblb="";
//		String lhid="";
//		String yyzls="";
//		Map<String, Object> map = new HashMap<>();
//		Integer sport=null;
//		Integer dport=null;
//		try {
//			if(StringUtils.isNotBlank(sports)){
//				sport=Integer.valueOf(sports);
//			}
//			if(StringUtils.isNotBlank(dports)){
//				dport=Integer.valueOf(dports);
//			}
//		} catch (Exception e) {
//			map.put("code", 400);
//			map.put("message", "请输入正确的端口号");
//			return map;
//		}
//		if(StringUtils.isNotBlank(labels)){
//			if(labels.split(",").length>5){
//				String[] label=Arrays.copyOfRange(labels.split(","), 0, 5);
//				labels="";
//				for(String labe:label){
//					labels+=labe+",";
//				}
//				labels=labels.substring(0,labels.length()-1);
//			}
////			String labe="";
////			for(String label:labels.split(",")){
////				BaseLabel baselabel=baseLabelMapper.SelectName(label);
////				if(baselabel!=null){
////					labe+=baselabel.getBqid()+",";
////				}
////			}
////			if(labe.length()>0){
////				labels=labe.substring(0,labe.length()-1);
////			}
////			
//		}
//		if(yyzl!=null&&yyzl.length>0){
//			for(String gk:yyzl){
//				yyzls+=gk+",";
//			}
//			yyzls=yyzls.substring(0,yyzls.length()-1);
//		}
//		if(StringUtils.isNotBlank(lhhh)){
//			BaseJklh base=baseJklhMapper.SelectName(lhhh);
//			if(base!=null){
//				lhid=base.getLhid()+"";
//			}else{
//				map.put("code", 400);
//				map.put("message", "此来函函号不存在");
//				return map;
//			}
//			
//		}
//		if(gklbs!=null&&gklbs.length>0){
////			gblb+="( ";
//			for(String gk:gklbs){
//				gblb+=gk+",";
//			}
//			gblb=gblb.substring(0,gblb.length()-1);
////			gblb+=")";
//		}
//		if (logType == null || logType.equals("")) {
//			map.put("code", 400);
//			map.put("message", "日志类型不可为空");
//			return map;
//		}
//		if(dport!=null){
//			if(dport>65535||dport<0){
//				map.put("code", 400);
//				map.put("message", "请输入正确的端口号");
//				return map;
//			}
//		}
//		if(sport!=null){
//			if(sport>65535||sport<0){
//				map.put("code", 400);
//				map.put("message", "请输入正确的端口号");
//				return map;
//			}
//		}
//		
//		if(StringUtils.isNotBlank(sip)){
//			if(!IPNo.isIp(sip)){
//				map.put("code", 400);
//				map.put("message", "请输入正确的ip");
//				return map;
//			}
//		}
//		if(StringUtils.isNotBlank(dip)){
//			if(!IPNo.isIp(dip)){
//				map.put("code", 400);
//				map.put("message", "请输入正确的ip");
//				return map;
//			}
//		}
//		if(StringUtils.isNotBlank(qdjip)){
//			if(!IPNo.isIp(qdjip)){
//				map.put("code", 400);
//				map.put("message", "请输入正确的ip");
//				return map;
//			}
//		}
//		//权限
//		Map<String,String> maq=new HashMap<>();
//		map.put("10", "tycx");
//		UserCheckMorePo user=new UserCheckMorePo();
//		user.setAccessToken(token);
//		user.setAreaCheck(true);
//		user.setModeluAction(maq);
//		String value=HttpsUtils.doPost("https://test:8444/auth/system/check/userCheckMoreAction",JSON.toJSONString(user));
//		net.sf.json.JSONObject data=new net.sf.json.JSONObject().fromObject(value);
//		String result=data.getString("result");
//		List<String> list=new ArrayList<String>();
//		if(result.equals("false")){
//			map.put("code", 600);
//			map.put("message", "无权限 ");
//		}
//		String area=data.getString("area");
//		if(area.equals("650000")||area.contains("650000")){
//			
//		}else {
//			List<Integer> listdy=new ArrayList<Integer>();
//			for(String dy:area.split(",")) {
//				listdy.add(Integer.valueOf(dy));
//			}
//			List<AreaCodeT> areaCodeList=areaCodeTMapper.SelectList(listdy);
//			for(AreaCodeT areaCodet:areaCodeList) {
//				list.add(areaCodet.getId()+"");
//			}
//		}
////		if (logType.equals("0201")) {
//			map=monitoringLogService.IPHMDqueryLogInfo(startTime, pzid, labels, lhid, ydy, mddy, 201, gblb, protocol,
//					sip, dip, sport, dport, pageNo, pageSize, logType, endTime, qdjip,yys,0,list);
////		}
//		LinkedHashMap<String, Object> mapValue = new LinkedHashMap<>();
//		mapValue=ExportCSVUtil.getMap(logType);
//		List exportData=new ArrayList<Map>();
//		exportData=ExportCSVUtil.getList((List<Map<String, Object>>) map.get("data"),logType);
//		File file = CSVUtils.createCSVFile(exportData, mapValue, "/home/", "黑名单日志");
//		try {
//		response.setContentType("application/csv;charset=UTF-8");
//		response.setHeader("Content-Disposition",
//				"attachment;filename=" + new String("日志.csv".getBytes(), "iso-8859-1"));
//		InputStream in = null;
//		try {
//			in = new FileInputStream(file);
//			int len = 0;
//			byte[] buffer = new byte[1024];
//			response.setCharacterEncoding("GBK");
//			OutputStream out = response.getOutputStream();
//			while ((len = in.read(buffer)) > 0) {
//				out.write(buffer, 0, len);
//			}
//		} catch (FileNotFoundException e) {
//			System.out.println(e);
//		} finally {
//			if (in != null) {
//				try {
//					in.close();
//				} catch (Exception e) {
//					throw new RuntimeException(e);
//				}
//			}
//		}
//		} catch (Exception e) {
//			System.out.println(e);
//		}
//		file.delete();
//		return null;
//	}
	
	
	@RequestMapping(value = "/DYUtil")
	public Map<String, Object> DYUtil(
			@RequestParam(value = "name", required = false) String name){
		return jCSJService.DYJCSJ(name);
	}
	/**
	 * 动作类型编码
	 * @return
	 */
	@RequestMapping(value = "/actionUtil")
	public Map<String, Object> actionUtil(@RequestParam(value = "name", required = false) String name){	
		return jCSJService.ActionJCSJ(name);
	}
	
	@RequestMapping(value = "/selectDownCsv")
	public Map<String, Object> selectDownCsv(@RequestParam(value = "pageNo", required = true, defaultValue = "1") int pageNo,
			@RequestParam(value = "pageSize", required = true, defaultValue = "10") int pageSize,
			@RequestParam(value = "logType", required = true) String logType){
		return jCSJService.DownCSV(pageNo, pageSize, logType, "");
	}
	
}
