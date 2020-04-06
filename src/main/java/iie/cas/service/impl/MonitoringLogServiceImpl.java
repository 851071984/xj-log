package iie.cas.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import iie.cas.dao.gbase.DNSGKZBMapper;
import iie.cas.dao.gbase.DNSJCZBMapper;
import iie.cas.dao.gbase.FTPGKZBMapper;
import iie.cas.dao.gbase.FTPJCZBMapper;
import iie.cas.dao.gbase.HTTPGKZBMapper;
import iie.cas.dao.gbase.HTTPJCZBMapper;
import iie.cas.dao.gbase.IPGKZBMapper;
import iie.cas.dao.gbase.IPJCZBMapper;
import iie.cas.dao.gbase.JSTXGKZBMapper;
import iie.cas.dao.gbase.JSTXJCZBMapper;
import iie.cas.dao.gbase.MAILGKZBMapper;
import iie.cas.dao.gbase.MAILJCZBMapper;
import iie.cas.dao.gbase.MEDIAJCZBMapper;
import iie.cas.dao.gbase.PICJCZBMapper;
import iie.cas.dao.gbase.SSLGKZBMapper;
import iie.cas.dao.gbase.SSLJCZBMapper;
import iie.cas.dao.gbase.VPNGKZBMapper;
import iie.cas.dao.gbase.VPNJCZBMapper;
import iie.cas.dao.gbase.WYGJCGKRZMapper;
import iie.cas.dao.gbase.WYGJCJCRZMapper;
import iie.cas.dao.primary.AreaCodeTMapper;
import iie.cas.dao.primary.BaseJklhMapper;
import iie.cas.dao.primary.ExportCsvMapper;
import iie.cas.po.DNSGKZBLogPo;
import iie.cas.po.DNSJCZBLogPo;
import iie.cas.po.FTPGKZBLogPo;
import iie.cas.po.FTPJCZBLogPo;
import iie.cas.po.HTTPGKZBLogPo;
import iie.cas.po.HTTPJCZBLogPo;
import iie.cas.po.IPGKZBLogPo;
import iie.cas.po.IPJCZBLogPo;
import iie.cas.po.JSTXGKZBLogPo;
import iie.cas.po.JSTXJCZBLogPo;
import iie.cas.po.MAILGKZBLogPo;
import iie.cas.po.MAILJCZBLogPo;
import iie.cas.po.MEDIAJCZBLogPo;
import iie.cas.po.PICJCZBLogPo;
import iie.cas.po.SSLGKZBLogPo;
import iie.cas.po.SSLJCZBLogPo;
import iie.cas.po.VPNGKZBLogPo;
import iie.cas.po.VPNJCZBLogPo;
import iie.cas.po.WYGJCGKRZLogPo;
import iie.cas.po.WYGJCJCRZLogPo;
import iie.cas.po.primary.ExportCsv;
import iie.cas.service.MonitoringLogService;
import iie.cas.util.IPv4Util;
import iie.cas.util.TranslatingUtil;
import net.sf.json.JSONObject;

@Service
public class MonitoringLogServiceImpl implements MonitoringLogService {
	@Autowired
	private IPGKZBMapper iPGKZBMapper;
	@Autowired
	private HTTPJCZBMapper httpJCZBMapper;
	@Autowired
	private DNSJCZBMapper dnsJCZBMapper;
	@Autowired
	private SSLJCZBMapper sslJCZBMapper;
	@Autowired
	private MAILJCZBMapper mailJCZBMapper;
	@Autowired
	private JSTXJCZBMapper jstxJCZBMapper;
	@Autowired
	private VPNJCZBMapper vpnJCZBMapper;
	@Autowired
	private FTPJCZBMapper ftpJCZBMapper;
	@Autowired
	private WYGJCJCRZMapper wtgjcJCRZMapper;
	@Autowired
	private IPJCZBMapper ipJCZBMapper;
	@Autowired
	private PICJCZBMapper picJCZBMapper;
	@Autowired
	private MEDIAJCZBMapper mediaJCZBMapper;
	@Autowired
	private HTTPGKZBMapper httpGKZBMapper;
	@Autowired
	private DNSGKZBMapper dnsGKZBMapper;
	@Autowired
	private SSLGKZBMapper sslGKZBMapper;
	@Autowired
	private MAILGKZBMapper mailGKZBMapper;
	@Autowired
	private JSTXGKZBMapper jstxGKZBMapper;
	@Autowired
	private VPNGKZBMapper vpnGKZBMapper;
	@Autowired
	private WYGJCGKRZMapper wygjGKZBMapper;
	@Autowired
	private FTPGKZBMapper ftpGKZBMapper;
	@Autowired
	private AreaCodeTMapper areaCodeTMapper;
	@Autowired
	private BaseJklhMapper baseJklhMapper;
	@Autowired
	private ExportCsvMapper exportCsvMapper;
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	SimpleDateFormat sd = new SimpleDateFormat("yyyyMMddHHmmss");

	@Override
	public Map<String, Object> IPHMDqueryLogInfo(String startTime, String PZID, String label, String LHID, String YDY,
			String MDDY, Integer PZLX, String GKLB, String PROTOCOL, String SIP, String DIP, Integer SPORT, Integer DPORT,
			Integer pageNo, Integer pageSize, String logType, String endTime, String qdjip,String yys,int type,List<String> list) {
		Map<String, Object> map = new HashMap<>();
		ArrayList<Map<String, Object>> resultList = new ArrayList<>();
		if (StringUtils.isNotBlank(startTime)) {
			map.put("startTime", startTime);
		}
		if (StringUtils.isNotBlank(endTime)) {
			map.put("endTime", endTime);
		}
		if (StringUtils.isNotBlank(PZID)) {
			map.put("PZID", PZID);
		}
		if (StringUtils.isNotBlank(label)) {
			map.put("LABEL",label.split(","));
		}
		if (StringUtils.isNotBlank(LHID)) {
			map.put("LHID", LHID);
		}
		if (StringUtils.isNotBlank(YDY)) {
			map.put("YDY", YDY.split(","));
		}
		if (StringUtils.isNotBlank(MDDY)) {
			map.put("MDDY", MDDY.split(","));
		}
		map.put("PZLX", PZLX);
		if (StringUtils.isNotBlank(GKLB)) {
			map.put("GKLB", GKLB);
		}
		if (StringUtils.isNotBlank(SIP)&&!SIP.equals("null")) {
			map.put("SIP", IPv4Util.ipToLong(SIP));
		}
		if (StringUtils.isNotBlank(DIP)) {
			map.put("DIP", IPv4Util.ipToLong(DIP));
		}
		if (StringUtils.isNotBlank(qdjip)) {
			map.put("QDJIP", IPv4Util.ipToLong(qdjip));
		}
		if (StringUtils.isNotBlank(yys)) {
			map.put("YYS", yys);
		}
		if (StringUtils.isNotBlank(PROTOCOL)) {
			map.put("PROTOCOL", TranslatingUtil.PROTOCOL(PROTOCOL));
		}
		if (SPORT!=null&&SPORT >= 0) {
			map.put("SPORT", SPORT);
		}
		if (DPORT!=null&&DPORT >= 0) {
			map.put("DPORT", DPORT);
		}
		map.put("start", (pageNo-1)*10);
		map.put("length", pageSize);
		if(list!=null&&list.size()>0) {
			map.put("QXDY", list);
		}
		if(type==1){
            JSONObject jsonObject=JSONObject.fromObject(map);
	        String string = jsonObject.toString();
	        ExportCsv record=new ExportCsv();
	        record.setName(sd.format(new Date()));
	        record.setStatus(0);
	        record.setSqls(string);
	        record.setLogType(PZLX);
	        exportCsvMapper.insert(record);
	        map = new HashMap<>();
			map.put("code", 200);
			map.put("message", "成功");
		}else{
		List<IPGKZBLogPo> ipgkzbList = iPGKZBMapper.SelectAll(map);
		Integer num = iPGKZBMapper.SelectCount(map);
		for (int i = 0; i < ipgkzbList.size(); i++) {
			Map<String, Object> resultMap = new HashMap<>();
			try {
				resultMap.put("bhsj", sdf.format(sdf.parse(ipgkzbList.get(i).getBhsj())));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			resultMap.put("labels", ipgkzbList.get(i).getLabel());
			resultMap.put("pzid", ipgkzbList.get(i).getPzid());
			resultMap.put("flid", ipgkzbList.get(i).getFlid());
			resultMap.put("xzid", ipgkzbList.get(i).getXzid());
			resultMap.put("lhid", TranslatingUtil.LHID(ipgkzbList.get(i).getLhid(), baseJklhMapper));
			resultMap.put("ydy", TranslatingUtil.YDY(ipgkzbList.get(i).getYdy(),areaCodeTMapper));
			resultMap.put("mddy", TranslatingUtil.MDDY(ipgkzbList.get(i).getMddy(),areaCodeTMapper));
			resultMap.put("pzlx", TranslatingUtil.PZLX(ipgkzbList.get(i).getPzlx()));
			resultMap.put("gklb", TranslatingUtil.GKLB(ipgkzbList.get(i).getGklb()));
			resultMap.put("qdjip", IPv4Util.longToIp(Long.parseLong(ipgkzbList.get(i).getQdjip() + "")));
			if(ipgkzbList.get(i).getYl1()==4) {
				resultMap.put("sip", IPv4Util.longToIp(Long.parseLong(ipgkzbList.get(i).getSip())));
				resultMap.put("dip", IPv4Util.longToIp(Long.parseLong(ipgkzbList.get(i).getDip())));
			}else if(ipgkzbList.get(i).getYl1()==6) {
				resultMap.put("sip", IPv4Util.longToIp(Long.parseLong(ipgkzbList.get(i).getSip())));
				resultMap.put("dip", IPv4Util.longToIp(Long.parseLong(ipgkzbList.get(i).getDip())));
			}else {
				resultMap.put("sip", IPv4Util.longToIp(Long.parseLong(ipgkzbList.get(i).getSip())));
				resultMap.put("dip", IPv4Util.longToIp(Long.parseLong(ipgkzbList.get(i).getDip())));
			}
			resultMap.put("sport", ipgkzbList.get(i).getSport());
			resultMap.put("dport", ipgkzbList.get(i).getDport());
			resultMap.put("protocol", TranslatingUtil.CSCXY(ipgkzbList.get(i).getProtocol()));
			resultMap.put("protoId", ipgkzbList.get(i).getProtoId());
			resultMap.put("detailId", TranslatingUtil.XXID(ipgkzbList.get(i).getDetailId()));
			resultMap.put("yys", TranslatingUtil.YYS(ipgkzbList.get(i).getYys()));
			resultMap.put("yl1", ipgkzbList.get(i).getYl1());
			resultMap.put("yl2", ipgkzbList.get(i).getYl2());
			resultMap.put("yl3", ipgkzbList.get(i).getYl3());
			resultMap.put("yl4", ipgkzbList.get(i).getYl4());
			resultMap.put("yl5", ipgkzbList.get(i).getYl5());
			resultList.add(resultMap);
		}
		map = new HashMap<>();
		map.put("data", resultList);
		map.put("pageSize", pageSize);
		map.put("pageNo", pageNo);
		map.put("totalPage", num / pageSize);
		map.put("totalCount", num);
		map.put("code", 200);
		}
		return map;
	}

	@Override
	public Map<String, Object> HTTPJCqueryLogInfo(String startTime, String PZID, String label, String LHID, String YDY,
			String MDDY, Integer PZLX, String GKLB, String PROTOCOL, String SIP, String DIP, Integer SPORT, Integer DPORT,
			Integer pageNo, Integer pageSize, String logType, String endTime, String qdjip, String fileName, Integer scBytes,
			String content, String host, Integer csPkts, String cookie, String yyzl, String userAgent, String url,
			Integer csBytes, Integer scPkts,String yys,int type,List<String> list) {
		Map<String, Object> map = new HashMap<>();
		ArrayList<Map<String, Object>> resultList = new ArrayList<>();
		if (StringUtils.isNotBlank(yys)) {
			map.put("YYS", yys);
		}
		if (StringUtils.isNotBlank(startTime)) {
			map.put("startTime", startTime);
		}
		if (StringUtils.isNotBlank(endTime)) {
			map.put("endTime", endTime);
		}
		if (StringUtils.isNotBlank(PZID)) {
			map.put("PZID", PZID);
		}
		if (StringUtils.isNotBlank(LHID)) {
			map.put("LHID", LHID);
		}
		if (StringUtils.isNotBlank(YDY)) {
			map.put("YDY", YDY.split(","));
		}
		if (StringUtils.isNotBlank(MDDY)) {
			map.put("MDDY", MDDY.split(","));
		}
		map.put("PZLX", PZLX);
		if (StringUtils.isNotBlank(GKLB)) {
			map.put("GKLB", GKLB);
		}
		if (StringUtils.isNotBlank(SIP)) {
			map.put("SIP", IPv4Util.ipToLong(SIP));
		}
		if (StringUtils.isNotBlank(DIP)) {
			map.put("DIP", IPv4Util.ipToLong(DIP));
		}
		if (StringUtils.isNotBlank(PROTOCOL)) {
			map.put("PROTOCOL", TranslatingUtil.PROTOCOL(PROTOCOL));
		}
		if (SPORT!=null&&SPORT >= 0) {
			map.put("SPORT", SPORT);
		}
		if (DPORT!=null&&DPORT >= 0) {
			map.put("DPORT", DPORT);
		}
		
		if (StringUtils.isNotBlank(label)) {
			map.put("LABEL", label.split(","));
		}
		if (StringUtils.isNotBlank(qdjip)) {
			map.put("QDJIP", IPv4Util.ipToLong(qdjip));
		}
		if (StringUtils.isNotBlank(fileName)) {
			map.put("FILE_NAME", fileName);
		}
		if (scBytes!=null) {
			map.put("SC_BYTES", scBytes);
		}
		if (csBytes!=null) {
			map.put("CS_BYTES", csBytes);
		}
		if (scPkts!=null) {
			map.put("SC_PKTS", scPkts);
		}
		if (csPkts!=null) {
			map.put("CS_PKTS", csPkts);
		}
		if (StringUtils.isNotBlank(content)) {
			map.put("CONTENT", content);
		}
		if (StringUtils.isNotBlank(host)) {
			map.put("HOST", host);
		}
		if (StringUtils.isNotBlank(cookie)) {
			map.put("COOKIE", cookie);
		}
		if (StringUtils.isNotBlank(yyzl)) {
			map.put("YYZL", yyzl);
		}
		if (StringUtils.isNotBlank(userAgent)) {
			map.put("USER_AGENT", userAgent);
		}
		if (StringUtils.isNotBlank(url)) {
			map.put("URL", url);
		}
		
		map.put("start", (pageNo-1)*10);
		map.put("length", pageSize);
		if(list!=null&&list.size()>0) {
			map.put("QXDY", list);
		}
		if(type==1){
            JSONObject jsonObject=JSONObject.fromObject(map);
	        String string = jsonObject.toString();
	        ExportCsv record=new ExportCsv();
	       record.setName(sd.format(new Date()));
	        record.setStatus(0);
	        record.setSqls(string);
	        record.setLogType(PZLX);
	        exportCsvMapper.insert(record);
	        map = new HashMap<>();
			map.put("code", 200);
			map.put("message", "成功");
		}else{
		List<HTTPJCZBLogPo> ipgkzbList = httpJCZBMapper.SelectAll(map);
		Integer num = httpJCZBMapper.SelectCount(map);
		for (int i = 0; i < ipgkzbList.size(); i++) {
			Map<String, Object> resultMap = new HashMap<>();
			try {
				resultMap.put("bhsj", sdf.format(sdf.parse(ipgkzbList.get(i).getBhsj())));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			resultMap.put("labels", ipgkzbList.get(i).getLabel());
			resultMap.put("pzid", ipgkzbList.get(i).getPzid());
			resultMap.put("flid", ipgkzbList.get(i).getFlid());
			resultMap.put("xzid", ipgkzbList.get(i).getXzid());
			resultMap.put("lhid", TranslatingUtil.LHID(ipgkzbList.get(i).getLhid(), baseJklhMapper));
			resultMap.put("ydy", TranslatingUtil.YDY(ipgkzbList.get(i).getYdy(),areaCodeTMapper));
			resultMap.put("mddy", TranslatingUtil.MDDY(ipgkzbList.get(i).getMddy(),areaCodeTMapper));
			resultMap.put("pzlx", TranslatingUtil.PZLX(ipgkzbList.get(i).getPzlx()));
			resultMap.put("gklb", TranslatingUtil.GKLB(ipgkzbList.get(i).getGklb()));
			if (ipgkzbList.get(i).getYyzl() != null) {
				resultMap.put("yyzl", TranslatingUtil.YYZL(ipgkzbList.get(i).getYyzl()));
			} else {
				resultMap.put("yyzl", "");
			}

			resultMap.put("qdjip", IPv4Util.longToIp(Long.parseLong(ipgkzbList.get(i).getQdjip() + "")));
			if(ipgkzbList.get(i).getYl1()==4) {
				resultMap.put("sip", IPv4Util.longToIp(Long.parseLong(ipgkzbList.get(i).getSip())));
				resultMap.put("dip", IPv4Util.longToIp(Long.parseLong(ipgkzbList.get(i).getDip())));
			}else if(ipgkzbList.get(i).getYl1()==6) {
				resultMap.put("sip", IPv4Util.longToIp(Long.parseLong(ipgkzbList.get(i).getSip())));
				resultMap.put("dip", IPv4Util.longToIp(Long.parseLong(ipgkzbList.get(i).getDip())));
			}else {
				resultMap.put("sip", IPv4Util.longToIp(Long.parseLong(ipgkzbList.get(i).getSip())));
				resultMap.put("dip", IPv4Util.longToIp(Long.parseLong(ipgkzbList.get(i).getDip())));
			}
			resultMap.put("sport", ipgkzbList.get(i).getSport());
			resultMap.put("dport", ipgkzbList.get(i).getDport());
			resultMap.put("protocol", TranslatingUtil.CSCXY(ipgkzbList.get(i).getProtocol()));
			resultMap.put("protoId", ipgkzbList.get(i).getProtoId());
			resultMap.put("detailId", TranslatingUtil.XXID(ipgkzbList.get(i).getDetailId()));
			resultMap.put("csPkts", ipgkzbList.get(i).getCsPkts());
			resultMap.put("csBytes", ipgkzbList.get(i).getCsBytes());
			resultMap.put("scPkts", ipgkzbList.get(i).getScPkts());
			resultMap.put("scBytes", ipgkzbList.get(i).getScBytes());
			resultMap.put("host", ipgkzbList.get(i).getHost());
			resultMap.put("userAgent", ipgkzbList.get(i).getUserAgent());
			resultMap.put("fileName", ipgkzbList.get(i).getFileName());
			resultMap.put("yys", TranslatingUtil.YYS(ipgkzbList.get(i).getYys()));
			resultMap.put("url", ipgkzbList.get(i).getUrl());
			resultMap.put("cookie", ipgkzbList.get(i).getCookie());
			resultMap.put("content", ipgkzbList.get(i).getContent());
			resultMap.put("yl1", ipgkzbList.get(i).getYl1());
			resultMap.put("yl2", ipgkzbList.get(i).getYl2());
			resultMap.put("yl3", ipgkzbList.get(i).getYl3());
			resultMap.put("yl4", ipgkzbList.get(i).getYl4());
			resultMap.put("yl5", ipgkzbList.get(i).getYl5());
			resultList.add(resultMap);
		}
		map = new HashMap<>();
		map.put("data", resultList);
		map.put("pageSize", pageSize);
		map.put("pageNo", pageNo);
		map.put("totalPage", num / pageSize);
		map.put("totalCount", num);
		map.put("code", 200);
		}
		return map;
	}

	@Override
	public Map<String, Object> DNSJCqueryLogInfo(String startTime, String PZID, String label, String LHID, String YDY,
			String MDDY, Integer PZLX, String GKLB, String PROTOCOL, String SIP, String DIP, Integer SPORT, Integer DPORT,
			Integer pageNo, Integer pageSize, String logType, String endTime, String qdjip, String dnsValue, String dnsName,
			Integer scBytes, Integer csPkts, Integer csBytes, Integer scPkts,String yys,int type,List<String> list) {
		Map<String, Object> map = new HashMap<>();
		ArrayList<Map<String, Object>> resultList = new ArrayList<>();
		if (StringUtils.isNotBlank(yys)) {
			map.put("YYS", yys);
		}
		if (StringUtils.isNotBlank(startTime)) {
			map.put("startTime", startTime);
		}
		if (StringUtils.isNotBlank(endTime)) {
			map.put("endTime", endTime);
		}
		if (StringUtils.isNotBlank(PZID)) {
			map.put("PZID", PZID);
		}
		if (StringUtils.isNotBlank(LHID)) {
			map.put("LHID", LHID);
		}
		if (StringUtils.isNotBlank(YDY)) {
			map.put("YDY", YDY.split(","));
		}
		if (StringUtils.isNotBlank(MDDY)) {
			map.put("MDDY", MDDY.split(","));
		}
		map.put("PZLX", PZLX);
		if (StringUtils.isNotBlank(GKLB)) {
			map.put("GKLB", GKLB);
		}
		if (StringUtils.isNotBlank(SIP)) {
			map.put("SIP", IPv4Util.ipToLong(SIP));
		}
		if (StringUtils.isNotBlank(DIP)) {
			map.put("DIP", IPv4Util.ipToLong(DIP));
		}
		if (StringUtils.isNotBlank(PROTOCOL)) {
			map.put("PROTOCOL", TranslatingUtil.PROTOCOL(PROTOCOL));
		}
		if (SPORT!=null&&SPORT >= 0) {
			map.put("SPORT", SPORT);
		}
		if (DPORT!=null&&DPORT >= 0) {
			map.put("DPORT", DPORT);
		}
		
		if (StringUtils.isNotBlank(label)) {
			map.put("LABEL", label.split(","));
		}
		if (StringUtils.isNotBlank(qdjip)) {
			map.put("QDJIP", IPv4Util.ipToLong(qdjip));
		}
		if (StringUtils.isNotBlank(dnsName)) {
			map.put("DNS_NAME", dnsName);
		}
		if (StringUtils.isNotBlank(dnsValue)) {
			map.put("DNS_VALUE", dnsValue);
		}
		if (scBytes!=null) {
			map.put("SC_BYTES", scBytes);
		}
		if (csBytes!=null) {
			map.put("CS_BYTES", csBytes);
		}
		if (scPkts!=null) {
			map.put("SC_PKTS", scPkts);
		}
		if (csPkts!=null) {
			map.put("CS_PKTS", csPkts);
		}
		
		map.put("start", (pageNo-1)*10);
		map.put("length", pageSize);
		if(list!=null&&list.size()>0) {
			map.put("QXDY", list);
		}
		if(type==1){
            JSONObject jsonObject=JSONObject.fromObject(map);
	        String string = jsonObject.toString();
	        ExportCsv record=new ExportCsv();
	       record.setName(sd.format(new Date()));
	        record.setStatus(0);
	        record.setSqls(string);
	        record.setLogType(PZLX);
	        exportCsvMapper.insert(record);
	        map = new HashMap<>();
			map.put("code", 200);
			map.put("message", "成功");
		}else{
		List<DNSJCZBLogPo> ipgkzbList = dnsJCZBMapper.SelectAll(map);
		Integer num = dnsJCZBMapper.SelectCount(map);
		for (int i = 0; i < ipgkzbList.size(); i++) {
			Map<String, Object> resultMap = new HashMap<>();
			try {
				resultMap.put("bhsj", sdf.format(sdf.parse(ipgkzbList.get(i).getBhsj())));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			resultMap.put("labels", ipgkzbList.get(i).getLabel());
			resultMap.put("pzid", ipgkzbList.get(i).getPzid());
			resultMap.put("flid", ipgkzbList.get(i).getFlid());
			resultMap.put("xzid", ipgkzbList.get(i).getXzid());
			resultMap.put("lhid", TranslatingUtil.LHID(ipgkzbList.get(i).getLhid(), baseJklhMapper));
			resultMap.put("ydy", TranslatingUtil.YDY(ipgkzbList.get(i).getYdy(),areaCodeTMapper));
			resultMap.put("mddy", TranslatingUtil.MDDY(ipgkzbList.get(i).getMddy(),areaCodeTMapper));
			resultMap.put("pzlx", TranslatingUtil.PZLX(ipgkzbList.get(i).getPzlx()));
			resultMap.put("gklb", TranslatingUtil.GKLB(ipgkzbList.get(i).getGklb()));
			resultMap.put("qdjip", IPv4Util.longToIp(Long.parseLong(ipgkzbList.get(i).getQdjip() + "")));
			if(ipgkzbList.get(i).getYl1()==4) {
				resultMap.put("sip", IPv4Util.longToIp(Long.parseLong(ipgkzbList.get(i).getSip())));
				resultMap.put("dip", IPv4Util.longToIp(Long.parseLong(ipgkzbList.get(i).getDip())));
			}else if(ipgkzbList.get(i).getYl1()==6) {
				resultMap.put("sip", IPv4Util.longToIp(Long.parseLong(ipgkzbList.get(i).getSip())));
				resultMap.put("dip", IPv4Util.longToIp(Long.parseLong(ipgkzbList.get(i).getDip())));
			}else {
				resultMap.put("sip", IPv4Util.longToIp(Long.parseLong(ipgkzbList.get(i).getSip())));
				resultMap.put("dip", IPv4Util.longToIp(Long.parseLong(ipgkzbList.get(i).getDip())));
			}
			resultMap.put("sport", ipgkzbList.get(i).getSport());
			resultMap.put("dport", ipgkzbList.get(i).getDport());
			resultMap.put("protocol", TranslatingUtil.CSCXY(ipgkzbList.get(i).getProtocol()));
			resultMap.put("protoId", ipgkzbList.get(i).getProtoId());
			resultMap.put("detailId", TranslatingUtil.XXID(ipgkzbList.get(i).getDetailId()));
			resultMap.put("csPkts", ipgkzbList.get(i).getCsPkts());
			resultMap.put("csBytes", ipgkzbList.get(i).getCsBytes());
			resultMap.put("scPkts", ipgkzbList.get(i).getScPkts());
			resultMap.put("scBytes", ipgkzbList.get(i).getScBytes());
			resultMap.put("dnsName", ipgkzbList.get(i).getDnsName());
			resultMap.put("dnsValue", ipgkzbList.get(i).getDnsValue());
			resultMap.put("yys", TranslatingUtil.YYS(ipgkzbList.get(i).getYys()));
			resultMap.put("yl1", ipgkzbList.get(i).getYl1());
			resultMap.put("yl2", ipgkzbList.get(i).getYl2());
			resultMap.put("yl3", ipgkzbList.get(i).getYl3());
			resultMap.put("yl4", ipgkzbList.get(i).getYl4());
			resultMap.put("yl5", ipgkzbList.get(i).getYl5());
			resultList.add(resultMap);
		}
		map = new HashMap<>();
		map.put("data", resultList);
		map.put("pageSize", pageSize);
		map.put("pageNo", pageNo);
		map.put("totalPage", num / pageSize);
		map.put("totalCount", num);
		map.put("code", 200);
		}
		return map;
	}

	@Override
	public Map<String, Object> SSLJCqueryLogInfo(String startTime, String PZID, String label, String LHID, String YDY,
			String MDDY, Integer PZLX, String GKLB, String PROTOCOL, String SIP, String DIP, Integer SPORT, Integer DPORT,
			Integer pageNo, Integer pageSize, String logType, String endTime, String qdjip, String fwqmc, Integer scBytes,
			String syz, Integer csPkts, String zsmc, String bfz, Integer csBytes, Integer scPkts,String yys,int type,List<String> list) {
		Map<String, Object> map = new HashMap<>();
		ArrayList<Map<String, Object>> resultList = new ArrayList<>();
		if (StringUtils.isNotBlank(yys)) {
			map.put("YYS", yys);
		}
		if (StringUtils.isNotBlank(startTime)) {
			map.put("startTime", startTime);
		}
		if (StringUtils.isNotBlank(endTime)) {
			map.put("endTime", endTime);
		}
		if (StringUtils.isNotBlank(PZID)) {
			map.put("PZID", PZID);
		}
		if (StringUtils.isNotBlank(LHID)) {
			map.put("LHID", LHID);
		}
		if (StringUtils.isNotBlank(YDY)) {
			map.put("YDY", YDY.split(","));
		}
		if (StringUtils.isNotBlank(MDDY)) {
			map.put("MDDY", MDDY.split(","));
		}
		map.put("PZLX", PZLX);
		if (StringUtils.isNotBlank(GKLB)) {
			map.put("GKLB", GKLB);
		}
		if (StringUtils.isNotBlank(SIP)) {
			map.put("SIP", IPv4Util.ipToLong(SIP));
		}
		if (StringUtils.isNotBlank(DIP)) {
			map.put("DIP", IPv4Util.ipToLong(DIP));
		}
		if (StringUtils.isNotBlank(PROTOCOL)) {
			map.put("PROTOCOL", TranslatingUtil.PROTOCOL(PROTOCOL));
		}
		if (SPORT!=null&&SPORT >= 0) {
			map.put("SPORT", SPORT);
		}
		if (DPORT!=null&&DPORT >= 0) {
			map.put("DPORT", DPORT);
		}
		
		if (StringUtils.isNotBlank(label)) {
			map.put("LABEL", label.split(","));
		}
		if (StringUtils.isNotBlank(qdjip)) {
			map.put("QDJIP", qdjip);
		}
		if (StringUtils.isNotBlank(fwqmc)) {
			map.put("FWQMC", fwqmc);
		}
		if (StringUtils.isNotBlank(syz)) {
			map.put("SYZ", syz);
		}
		if (StringUtils.isNotBlank(zsmc)) {
			map.put("ZSMC", zsmc);
		}
		if (StringUtils.isNotBlank(bfz)) {
			map.put("BFZ", bfz);
		}
		if (scBytes!=null) {
			map.put("SC_BYTES", scBytes);
		}
		if (csBytes!=null) {
			map.put("CS_BYTES", csBytes);
		}
		if (scPkts!=null) {
			map.put("SC_PKTS", scPkts);
		}
		if (csPkts!=null) {
			map.put("CS_PKTS", csPkts);
		}
		
		map.put("start", (pageNo-1)*10);
		map.put("length", pageSize);
		if(list!=null&&list.size()>0) {
			map.put("QXDY", list);
		}
		if(type==1){
            JSONObject jsonObject=JSONObject.fromObject(map);
	        String string = jsonObject.toString();
	        ExportCsv record=new ExportCsv();
	       record.setName(sd.format(new Date()));
	        record.setStatus(0);
	        record.setSqls(string);
	        record.setLogType(PZLX);
	        exportCsvMapper.insert(record);
	        map = new HashMap<>();
			map.put("code", 200);
			map.put("message", "成功");
		}else{
		List<SSLJCZBLogPo> ipgkzbList = sslJCZBMapper.SelectAll(map);
		Integer num = sslJCZBMapper.SelectCount(map);
		for (int i = 0; i < ipgkzbList.size(); i++) {
			Map<String, Object> resultMap = new HashMap<>();
			try {
				resultMap.put("bhsj", sdf.format(sdf.parse(ipgkzbList.get(i).getBhsj())));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			resultMap.put("labels", ipgkzbList.get(i).getLabel());
			resultMap.put("pzid", ipgkzbList.get(i).getPzid());
			resultMap.put("flid", ipgkzbList.get(i).getFlid());
			resultMap.put("xzid", ipgkzbList.get(i).getXzid());
			resultMap.put("lhid", TranslatingUtil.LHID(ipgkzbList.get(i).getLhid(), baseJklhMapper));
			resultMap.put("ydy", TranslatingUtil.YDY(ipgkzbList.get(i).getYdy(),areaCodeTMapper));
			resultMap.put("mddy", TranslatingUtil.MDDY(ipgkzbList.get(i).getMddy(),areaCodeTMapper));
			resultMap.put("pzlx", TranslatingUtil.PZLX(ipgkzbList.get(i).getPzlx()));
			resultMap.put("gklb", TranslatingUtil.GKLB(ipgkzbList.get(i).getGklb()));
			resultMap.put("qdjip", IPv4Util.longToIp(Long.parseLong(ipgkzbList.get(i).getQdjip() + "")));
			if(ipgkzbList.get(i).getYl1()==4) {
				resultMap.put("sip", IPv4Util.longToIp(Long.parseLong(ipgkzbList.get(i).getSip())));
				resultMap.put("dip", IPv4Util.longToIp(Long.parseLong(ipgkzbList.get(i).getDip())));
			}else if(ipgkzbList.get(i).getYl1()==6) {
				resultMap.put("sip", IPv4Util.longToIp(Long.parseLong(ipgkzbList.get(i).getSip())));
				resultMap.put("dip", IPv4Util.longToIp(Long.parseLong(ipgkzbList.get(i).getDip())));
			}else {
				resultMap.put("sip", IPv4Util.longToIp(Long.parseLong(ipgkzbList.get(i).getSip())));
				resultMap.put("dip", IPv4Util.longToIp(Long.parseLong(ipgkzbList.get(i).getDip())));
			}
			resultMap.put("sport", ipgkzbList.get(i).getSport());
			resultMap.put("dport", ipgkzbList.get(i).getDport());
			resultMap.put("protocol", TranslatingUtil.CSCXY(ipgkzbList.get(i).getProtocol()));
			resultMap.put("protoId", ipgkzbList.get(i).getProtoId());
			resultMap.put("detailId", TranslatingUtil.XXID(ipgkzbList.get(i).getDetailId()));
			resultMap.put("csPkts", ipgkzbList.get(i).getCsPkts());
			resultMap.put("csBytes", ipgkzbList.get(i).getCsBytes());
			resultMap.put("scPkts", ipgkzbList.get(i).getScPkts());
			resultMap.put("scBytes", ipgkzbList.get(i).getScBytes());
			resultMap.put("zsmc", ipgkzbList.get(i).getZsmc());
			resultMap.put("bfz", ipgkzbList.get(i).getBfz());
			resultMap.put("syz", ipgkzbList.get(i).getSyz());
			resultMap.put("fwqmc", ipgkzbList.get(i).getFwqmc());
			resultMap.put("yys", TranslatingUtil.YYS(ipgkzbList.get(i).getYys()));
			resultMap.put("yl1", ipgkzbList.get(i).getYl1());
			resultMap.put("yl2", ipgkzbList.get(i).getYl2());
			resultMap.put("yl3", ipgkzbList.get(i).getYl3());
			resultMap.put("yl4", ipgkzbList.get(i).getYl4());
			resultMap.put("yl5", ipgkzbList.get(i).getYl5());
			resultList.add(resultMap);
		}
		map = new HashMap<>();
		map.put("data", resultList);
		map.put("pageSize", pageSize);
		map.put("pageNo", pageNo);
		map.put("totalPage", num / pageSize);
		map.put("totalCount", num);
		map.put("code", 200);
		}
		return map;
	}

	@Override
	public Map<String, Object> MAILJCqueryLogInfo(String startTime, String PZID, String label, String LHID, String YDY,
			String MDDY, Integer PZLX, String GKLB, String PROTOCOL, String SIP, String DIP, Integer SPORT, Integer DPORT,
			Integer pageNo, Integer pageSize, String logType, String endTime, String qdjip, String fileName, String receverNum,
			String mailRecever, Integer scBytes, String sjfws, String content, String mailSubject, String mailSender,
			String sjfwsSzd, Integer csPkts, String fjfwsSzd, String ccNum, String yyzl, String fjfws, String xylx, String gjz,
			Integer csBytes, Integer scPkts, String pwd, String accessory, String fileContent, String mailCc,String yys,int type,List<String> list) {
		Map<String, Object> map = new HashMap<>();
		ArrayList<Map<String, Object>> resultList = new ArrayList<>();
		if (StringUtils.isNotBlank(yys)) {
			map.put("YYS", yys);
		}
		if (StringUtils.isNotBlank(startTime)) {
			map.put("startTime", startTime);
		}
		if (StringUtils.isNotBlank(endTime)) {
			map.put("endTime", endTime);
		}
		if (StringUtils.isNotBlank(PZID)) {
			map.put("PZID", PZID);
		}
		if (StringUtils.isNotBlank(LHID)) {
			map.put("LHID", LHID);
		}
		if (StringUtils.isNotBlank(YDY)) {
			map.put("YDY", YDY.split(","));
		}
		if (StringUtils.isNotBlank(MDDY)) {
			map.put("MDDY", MDDY.split(","));
		}
		map.put("PZLX", PZLX);
		if (StringUtils.isNotBlank(GKLB)) {
			map.put("GKLB", GKLB);
		}
		if (StringUtils.isNotBlank(SIP)) {
			map.put("SIP", IPv4Util.ipToLong(SIP));
		}
		if (StringUtils.isNotBlank(DIP)) {
			map.put("DIP", IPv4Util.ipToLong(DIP));
		}
		if (StringUtils.isNotBlank(PROTOCOL)) {
			map.put("PROTOCOL", TranslatingUtil.PROTOCOL(PROTOCOL));
		}
		if (SPORT!=null&&SPORT >= 0) {
			map.put("SPORT", SPORT);
		}
		if (DPORT!=null&&DPORT >= 0) {
			map.put("DPORT", DPORT);
		}
		
		if (StringUtils.isNotBlank(label)) {
			map.put("LABEL", label.split(","));
		}
		if (StringUtils.isNotBlank(qdjip)) {
			map.put("QDJIP", qdjip);
		}
		if (StringUtils.isNotBlank(fileName)) {
			map.put("FILE_NAME", fileName);
		}
		if (StringUtils.isNotBlank(receverNum)) {
			map.put("RECEVER_NUM", receverNum);
		}
		if (StringUtils.isNotBlank(mailRecever)) {
			map.put("MAIL_RECEVER", mailRecever);
		}
		if (StringUtils.isNotBlank(sjfws)) {
			map.put("SJFWS", sjfws);
		}
		if (StringUtils.isNotBlank(content)) {
			map.put("CONTENT", content);
		}
		if (StringUtils.isNotBlank(mailSubject)) {
			map.put("MAIL_SUBJECT", mailSubject);
		}
		if (StringUtils.isNotBlank(mailSender)) {
			map.put("MAIL_SENDER", mailSender);
		}
		if (StringUtils.isNotBlank(sjfwsSzd)) {
			map.put("SJFWS_SZD", sjfwsSzd);
		}
		if (StringUtils.isNotBlank(fjfwsSzd)) {
			map.put("FJFWS_SZD", fjfwsSzd);
		}
		if (StringUtils.isNotBlank(ccNum)) {
			map.put("CC_NUM", ccNum);
		}
		if (StringUtils.isNotBlank(yyzl)) {
			map.put("YYZL", yyzl);
		}
		if (StringUtils.isNotBlank(fjfws)) {
			map.put("FJFWS", fjfws);
		}
		if (StringUtils.isNotBlank(xylx)) {
			map.put("XYLX", xylx);
		}
		if (StringUtils.isNotBlank(gjz)) {
			map.put("GJZ", gjz);
		}
		if (StringUtils.isNotBlank(pwd)) {
			map.put("PWD", pwd);
		}
		if (StringUtils.isNotBlank(accessory)) {
			map.put("ACCESSORY", accessory);
		}
		if (StringUtils.isNotBlank(fileContent)) {
			map.put("FILE_CONTENT", fileContent);
		}
		if (StringUtils.isNotBlank(mailCc)) {
			map.put("MAIL_CC", mailCc);
		}
		if (scBytes!=null) {
			map.put("SC_BYTES", scBytes);
		}
		if (csBytes!=null) {
			map.put("CS_BYTES", csBytes);
		}
		if (scPkts!=null) {
			map.put("SC_PKTS", scPkts);
		}
		if (csPkts!=null) {
			map.put("CS_PKTS", csPkts);
		}
		
		map.put("start", (pageNo-1)*10);
		map.put("length", pageSize);
		if(list!=null&&list.size()>0) {
			map.put("QXDY", list);
		}
		if(type==1){
            JSONObject jsonObject=JSONObject.fromObject(map);
	        String string = jsonObject.toString();
	        ExportCsv record=new ExportCsv();
	       record.setName(sd.format(new Date()));
	        record.setStatus(0);
	        record.setSqls(string);
	        record.setLogType(PZLX);
	        exportCsvMapper.insert(record);
	        map = new HashMap<>();
			map.put("code", 200);
			map.put("message", "成功");
		}else{
		List<MAILJCZBLogPo> ipgkzbList = mailJCZBMapper.SelectAll(map);
		Integer num = mailJCZBMapper.SelectCount(map);
		for (int i = 0; i < ipgkzbList.size(); i++) {
			Map<String, Object> resultMap = new HashMap<>();
			try {
				resultMap.put("bhsj", sdf.format(sdf.parse(ipgkzbList.get(i).getBhsj())));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			resultMap.put("labels", ipgkzbList.get(i).getLabel());
			resultMap.put("pzid", ipgkzbList.get(i).getPzid());
			resultMap.put("flid", ipgkzbList.get(i).getFlid());
			resultMap.put("xzid", ipgkzbList.get(i).getXzid());
			resultMap.put("lhid", TranslatingUtil.LHID(ipgkzbList.get(i).getLhid(), baseJklhMapper));
			resultMap.put("ydy", TranslatingUtil.YDY(ipgkzbList.get(i).getYdy(),areaCodeTMapper));
			resultMap.put("mddy", TranslatingUtil.MDDY(ipgkzbList.get(i).getMddy(),areaCodeTMapper));
			resultMap.put("pzlx", TranslatingUtil.PZLX(ipgkzbList.get(i).getPzlx()));
			resultMap.put("gklb", TranslatingUtil.GKLB(ipgkzbList.get(i).getGklb()));
			if (ipgkzbList.get(i).getYyzl() != null) {
				resultMap.put("yyzl", TranslatingUtil.YYZL(ipgkzbList.get(i).getYyzl()));
			} else {
				resultMap.put("yyzl", "");
			}

			resultMap.put("qdjip", IPv4Util.longToIp(Long.parseLong(ipgkzbList.get(i).getQdjip() + "")));
			if(ipgkzbList.get(i).getYl1()==4) {
				resultMap.put("sip", IPv4Util.longToIp(Long.parseLong(ipgkzbList.get(i).getSip())));
				resultMap.put("dip", IPv4Util.longToIp(Long.parseLong(ipgkzbList.get(i).getDip())));
			}else if(ipgkzbList.get(i).getYl1()==6) {
				resultMap.put("sip", IPv4Util.longToIp(Long.parseLong(ipgkzbList.get(i).getSip())));
				resultMap.put("dip", IPv4Util.longToIp(Long.parseLong(ipgkzbList.get(i).getDip())));
			}else {
				resultMap.put("sip", IPv4Util.longToIp(Long.parseLong(ipgkzbList.get(i).getSip())));
				resultMap.put("dip", IPv4Util.longToIp(Long.parseLong(ipgkzbList.get(i).getDip())));
			}
			resultMap.put("sport", ipgkzbList.get(i).getSport());
			resultMap.put("dport", ipgkzbList.get(i).getDport());
			resultMap.put("protocol", TranslatingUtil.CSCXY(ipgkzbList.get(i).getProtocol()));
			resultMap.put("protoId", ipgkzbList.get(i).getProtoId());
			resultMap.put("detailId", TranslatingUtil.XXID(ipgkzbList.get(i).getDetailId()));
			resultMap.put("csPkts", ipgkzbList.get(i).getCsPkts());
			resultMap.put("csBytes", ipgkzbList.get(i).getCsBytes());
			resultMap.put("scPkts", ipgkzbList.get(i).getScPkts());
			resultMap.put("scBytes", ipgkzbList.get(i).getScBytes());
			resultMap.put("mailSender", ipgkzbList.get(i).getMailSender());
			resultMap.put("receverNum", ipgkzbList.get(i).getReceverNum());
			resultMap.put("ccNum", ipgkzbList.get(i).getCcNum());
			resultMap.put("mailSubject", ipgkzbList.get(i).getMailSubject());
			resultMap.put("accessory", ipgkzbList.get(i).getAccessory());
			resultMap.put("fileName", ipgkzbList.get(i).getFileName());
			resultMap.put("fileContent", ipgkzbList.get(i).getFileContent());
			resultMap.put("pwd", ipgkzbList.get(i).getPwd());
			resultMap.put("fjfws", ipgkzbList.get(i).getFjfws());
			resultMap.put("fjfwsSzd", ipgkzbList.get(i).getFjfwsSzd());
			resultMap.put("sjfws", ipgkzbList.get(i).getSjfws());
			resultMap.put("sjfwsSzd", ipgkzbList.get(i).getSjfwsSzd());
			resultMap.put("xylx", ipgkzbList.get(i).getXylx());
			resultMap.put("gjz", ipgkzbList.get(i).getGjz());
			resultMap.put("yys", TranslatingUtil.YYS(ipgkzbList.get(i).getYys()));
			resultMap.put("mailRecever", ipgkzbList.get(i).getMailRecever());
			resultMap.put("mailCc", ipgkzbList.get(i).getMailCc());
			resultMap.put("content", ipgkzbList.get(i).getContent());
			resultMap.put("yl1", ipgkzbList.get(i).getYl1());
			resultMap.put("yl2", ipgkzbList.get(i).getYl2());
			resultMap.put("yl3", ipgkzbList.get(i).getYl3());
			resultMap.put("yl4", ipgkzbList.get(i).getYl4());
			resultMap.put("yl5", ipgkzbList.get(i).getYl5());
			resultList.add(resultMap);
		}
		map = new HashMap<>();
		map.put("data", resultList);
		map.put("pageSize", pageSize);
		map.put("pageNo", pageNo);
		map.put("totalPage", num / pageSize);
		map.put("totalCount", num);
		map.put("code", 200);
		}
		return map;
	}

	@Override
	public Map<String, Object> JSTXJCqueryLogInfo(String startTime, String PZID, String label, String LHID, String YDY,
			String MDDY, Integer PZLX, String GKLB, String PROTOCOL, String SIP, String DIP, Integer SPORT, Integer DPORT,
			Integer pageNo, Integer pageSize, String logType, String endTime, String qdjip, Integer scBytes, String content,
			String host, Integer csPkts, String yyzl, String userAgent, String userId, String url, String reserved,
			Integer csBytes, Integer scPkts, String dzId,String yys,int type,List<String> list) {
		Map<String, Object> map = new HashMap<>();
		ArrayList<Map<String, Object>> resultList = new ArrayList<>();
		if (StringUtils.isNotBlank(yys)) {
			map.put("YYS", yys);
		}
		if (StringUtils.isNotBlank(startTime)) {
			map.put("startTime", startTime);
		}
		if (StringUtils.isNotBlank(endTime)) {
			map.put("endTime", endTime);
		}
		if (StringUtils.isNotBlank(PZID)) {
			map.put("PZID", PZID);
		}
		if (StringUtils.isNotBlank(LHID)) {
			map.put("LHID", LHID);
		}
		if (StringUtils.isNotBlank(YDY)) {
			map.put("YDY", YDY.split(","));
		}
		if (StringUtils.isNotBlank(MDDY)) {
			map.put("MDDY", MDDY.split(","));
		}
		map.put("PZLX", PZLX);
		if (StringUtils.isNotBlank(GKLB)) {
			map.put("GKLB", GKLB);
		}
		if (StringUtils.isNotBlank(SIP)) {
			map.put("SIP", IPv4Util.ipToLong(SIP));
		}
		if (StringUtils.isNotBlank(DIP)) {
			map.put("DIP", IPv4Util.ipToLong(DIP));
		}
		if (StringUtils.isNotBlank(PROTOCOL)) {
			map.put("PROTOCOL", TranslatingUtil.PROTOCOL(PROTOCOL));
		}
		if (SPORT!=null&&SPORT >= 0) {
			map.put("SPORT", SPORT);
		}
		if (DPORT!=null&&DPORT >= 0) {
			map.put("DPORT", DPORT);
		}
		
		if (StringUtils.isNotBlank(label)) {
			map.put("LABEL", label.split(","));
		}
		if (StringUtils.isNotBlank(qdjip)) {
			map.put("QDJIP", IPv4Util.ipToLong(qdjip));
		}
		if (StringUtils.isNotBlank(content)) {
			map.put("CONTENT", content);
		}
		if (StringUtils.isNotBlank(host)) {
			map.put("HOST", host);
		}
		if (StringUtils.isNotBlank(yyzl)) {
			map.put("YYZL", yyzl);
		}
		if (StringUtils.isNotBlank(userAgent)) {
			map.put("USER_AGENT", userAgent);
		}
		if (StringUtils.isNotBlank(userId)) {
			map.put("USER_ID", userId);
		}
		if (StringUtils.isNotBlank(url)) {
			map.put("URL", url);
		}
		if (StringUtils.isNotBlank(reserved)) {
			map.put("RESERVED", reserved);
		}
		if (StringUtils.isNotBlank(dzId)) {
			map.put("DZ_ID", dzId);
		}
		
		if (scBytes!=null) {
			map.put("SC_BYTES", scBytes);
		}
		if (csBytes!=null) {
			map.put("CS_BYTES", csBytes);
		}
		if (scPkts!=null) {
			map.put("SC_PKTS", scPkts);
		}
		if (csPkts!=null) {
			map.put("CS_PKTS", csPkts);
		}
		
		map.put("start", (pageNo-1)*10);
		map.put("length", pageSize);
		if(list!=null&&list.size()>0) {
			map.put("QXDY", list);
		}
		if(type==1){
            JSONObject jsonObject=JSONObject.fromObject(map);
	        String string = jsonObject.toString();
	        ExportCsv record=new ExportCsv();
	       record.setName(sd.format(new Date()));
	        record.setStatus(0);
	        record.setSqls(string);
	        record.setLogType(PZLX);
	        exportCsvMapper.insert(record);
	        map = new HashMap<>();
			map.put("code", 200);
			map.put("message", "成功");
		}else{
		List<JSTXJCZBLogPo> ipgkzbList = jstxJCZBMapper.SelectAll(map);
		Integer num = jstxJCZBMapper.SelectCount(map);
		for (int i = 0; i < ipgkzbList.size(); i++) {
			Map<String, Object> resultMap = new HashMap<>();
			try {
				resultMap.put("bhsj", sdf.format(sdf.parse(ipgkzbList.get(i).getBhsj())));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			resultMap.put("labels", ipgkzbList.get(i).getLabel());
			resultMap.put("pzid", ipgkzbList.get(i).getPzid());
			resultMap.put("flid", ipgkzbList.get(i).getFlid());
			resultMap.put("xzid", ipgkzbList.get(i).getXzid());
			resultMap.put("lhid", TranslatingUtil.LHID(ipgkzbList.get(i).getLhid(), baseJklhMapper));
			resultMap.put("ydy", TranslatingUtil.YDY(ipgkzbList.get(i).getYdy(),areaCodeTMapper));
			resultMap.put("mddy", TranslatingUtil.MDDY(ipgkzbList.get(i).getMddy(),areaCodeTMapper));
			resultMap.put("pzlx", TranslatingUtil.PZLX(ipgkzbList.get(i).getPzlx()));
			resultMap.put("gklb", TranslatingUtil.GKLB(ipgkzbList.get(i).getGklb()));
			if (ipgkzbList.get(i).getYyzl() != null) {
				resultMap.put("yyzl", TranslatingUtil.YYZL(ipgkzbList.get(i).getYyzl()));
			} else {
				resultMap.put("yyzl", "");
			}

			resultMap.put("qdjip", IPv4Util.longToIp(Long.parseLong(ipgkzbList.get(i).getQdjip() + "")));
			if(ipgkzbList.get(i).getYl1()==4) {
				resultMap.put("sip", IPv4Util.longToIp(Long.parseLong(ipgkzbList.get(i).getSip())));
				resultMap.put("dip", IPv4Util.longToIp(Long.parseLong(ipgkzbList.get(i).getDip())));
			}else if(ipgkzbList.get(i).getYl1()==6) {
				resultMap.put("sip", IPv4Util.longToIp(Long.parseLong(ipgkzbList.get(i).getSip())));
				resultMap.put("dip", IPv4Util.longToIp(Long.parseLong(ipgkzbList.get(i).getDip())));
			}else {
				resultMap.put("sip", IPv4Util.longToIp(Long.parseLong(ipgkzbList.get(i).getSip())));
				resultMap.put("dip", IPv4Util.longToIp(Long.parseLong(ipgkzbList.get(i).getDip())));
			}
			resultMap.put("sport", ipgkzbList.get(i).getSport());
			resultMap.put("dport", ipgkzbList.get(i).getDport());
			resultMap.put("protocol", TranslatingUtil.CSCXY(ipgkzbList.get(i).getProtocol()));
			resultMap.put("protoId", ipgkzbList.get(i).getProtoId());
			resultMap.put("detailId", TranslatingUtil.XXID(ipgkzbList.get(i).getDetailId()));
			resultMap.put("csPkts", ipgkzbList.get(i).getCsPkts());
			resultMap.put("csBytes", ipgkzbList.get(i).getCsBytes());
			resultMap.put("scPkts", ipgkzbList.get(i).getScPkts());
			resultMap.put("scBytes", ipgkzbList.get(i).getScBytes());
			resultMap.put("dzId", ipgkzbList.get(i).getDzId());
			resultMap.put("host", ipgkzbList.get(i).getHost());
			resultMap.put("userAgent", ipgkzbList.get(i).getUserAgent());
			resultMap.put("userId", ipgkzbList.get(i).getUserId());
			resultMap.put("reserved", ipgkzbList.get(i).getReserved());
			resultMap.put("yys", TranslatingUtil.YYS(ipgkzbList.get(i).getYys()));
			resultMap.put("content", ipgkzbList.get(i).getContent());
			resultMap.put("url", ipgkzbList.get(i).getUrl());
			resultMap.put("yl1", ipgkzbList.get(i).getYl1());
			resultMap.put("yl2", ipgkzbList.get(i).getYl2());
			resultMap.put("yl3", ipgkzbList.get(i).getYl3());
			resultMap.put("yl4", ipgkzbList.get(i).getYl4());
			resultMap.put("yl5", ipgkzbList.get(i).getYl5());
			resultList.add(resultMap);
		}
		map = new HashMap<>();
		map.put("data", resultList);
		map.put("pageSize", pageSize);
		map.put("pageNo", pageNo);
		map.put("totalPage", num / pageSize);
		map.put("totalCount", num);
		map.put("code", 200);
		}
		return map;
	}

	@Override
	public Map<String, Object> VPNJCqueryLogInfo(String startTime, String PZID, String label, String LHID, String YDY,
			String MDDY, Integer PZLX, String GKLB, String PROTOCOL, String SIP, String DIP, Integer SPORT, Integer DPORT,
			Integer pageNo, Integer pageSize, String logType, String endTime, String qdjip, Integer scBytes, Integer csPkts, String url,
			Integer csBytes, Integer scPkts, String pwd, String username,String yys,int type,List<String> list) {
		Map<String, Object> map = new HashMap<>();
		ArrayList<Map<String, Object>> resultList = new ArrayList<>();
		if (StringUtils.isNotBlank(yys)) {
			map.put("YYS", yys);
		}
		if (StringUtils.isNotBlank(startTime)) {
			map.put("startTime", startTime);
		}
		if (StringUtils.isNotBlank(endTime)) {
			map.put("endTime", endTime);
		}
		if (StringUtils.isNotBlank(PZID)) {
			map.put("PZID", PZID);
		}
		if (StringUtils.isNotBlank(LHID)) {
			map.put("LHID", LHID);
		}
		if (StringUtils.isNotBlank(YDY)) {
			map.put("YDY", YDY.split(","));
		}
		if (StringUtils.isNotBlank(MDDY)) {
			map.put("MDDY", MDDY.split(","));
		}
		map.put("PZLX", PZLX);
		if (StringUtils.isNotBlank(GKLB)) {
			map.put("GKLB", GKLB);
		}
		if (StringUtils.isNotBlank(SIP)) {
			map.put("SIP", IPv4Util.ipToLong(SIP));
		}
		if (StringUtils.isNotBlank(DIP)) {
			map.put("DIP", IPv4Util.ipToLong(DIP));
		}
		if (StringUtils.isNotBlank(PROTOCOL)) {
			map.put("PROTOCOL", TranslatingUtil.PROTOCOL(PROTOCOL));
		}
		if (SPORT!=null&&SPORT >= 0) {
			map.put("SPORT", SPORT);
		}
		if (DPORT!=null&&DPORT >= 0) {
			map.put("DPORT", DPORT);
		}
		
		if (StringUtils.isNotBlank(label)) {
			map.put("LABEL", label.split(","));
		}
		if (StringUtils.isNotBlank(qdjip)) {
			map.put("QDJIP", IPv4Util.ipToLong(qdjip));
		}
		if (StringUtils.isNotBlank(url)) {
			map.put("URL", url);
		}
		if (StringUtils.isNotBlank(username)) {
			map.put("USERNAME", username);
		}
		if (StringUtils.isNotBlank(pwd)) {
			map.put("PWD", pwd);
		}
		if (scBytes!=null) {
			map.put("SC_BYTES", scBytes);
		}
		if (csBytes!=null) {
			map.put("CS_BYTES", csBytes);
		}
		if (scPkts!=null) {
			map.put("SC_PKTS", scPkts);
		}
		if (csPkts!=null) {
			map.put("CS_PKTS", csPkts);
		}
		
		map.put("start", (pageNo-1)*10);
		map.put("length", pageSize);
		if(list!=null&&list.size()>0) {
			map.put("QXDY", list);
		}
		if(type==1){
            JSONObject jsonObject=JSONObject.fromObject(map);
	        String string = jsonObject.toString();
	        ExportCsv record=new ExportCsv();
	       record.setName(sd.format(new Date()));
	        record.setStatus(0);
	        record.setSqls(string);
	        record.setLogType(PZLX);
	        exportCsvMapper.insert(record);
	        map = new HashMap<>();
			map.put("code", 200);
			map.put("message", "成功");
		}else{
		List<VPNJCZBLogPo> ipgkzbList = vpnJCZBMapper.SelectAll(map);
		Integer num = vpnJCZBMapper.SelectCount(map);
		for (int i = 0; i < ipgkzbList.size(); i++) {
			Map<String, Object> resultMap = new HashMap<>();
			try {
				resultMap.put("bhsj", sdf.format(sdf.parse(ipgkzbList.get(i).getBhsj())));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			resultMap.put("labels", ipgkzbList.get(i).getLabel());
			resultMap.put("pzid", ipgkzbList.get(i).getPzid());
			resultMap.put("flid", ipgkzbList.get(i).getFlid());
			resultMap.put("xzid", ipgkzbList.get(i).getXzid());
			resultMap.put("lhid", TranslatingUtil.LHID(ipgkzbList.get(i).getLhid(), baseJklhMapper));
			resultMap.put("ydy", TranslatingUtil.YDY(ipgkzbList.get(i).getYdy(),areaCodeTMapper));
			resultMap.put("mddy", TranslatingUtil.MDDY(ipgkzbList.get(i).getMddy(),areaCodeTMapper));
			resultMap.put("pzlx", TranslatingUtil.PZLX(ipgkzbList.get(i).getPzlx()));
			resultMap.put("gklb", TranslatingUtil.GKLB(ipgkzbList.get(i).getGklb()));
			resultMap.put("qdjip", IPv4Util.longToIp(Long.parseLong(ipgkzbList.get(i).getQdjip() + "")));
			if(ipgkzbList.get(i).getYl1()==4) {
				resultMap.put("sip", IPv4Util.longToIp(Long.parseLong(ipgkzbList.get(i).getSip())));
				resultMap.put("dip", IPv4Util.longToIp(Long.parseLong(ipgkzbList.get(i).getDip())));
			}else if(ipgkzbList.get(i).getYl1()==6) {
				resultMap.put("sip", IPv4Util.longToIp(Long.parseLong(ipgkzbList.get(i).getSip())));
				resultMap.put("dip", IPv4Util.longToIp(Long.parseLong(ipgkzbList.get(i).getDip())));
			}else {
				resultMap.put("sip", IPv4Util.longToIp(Long.parseLong(ipgkzbList.get(i).getSip())));
				resultMap.put("dip", IPv4Util.longToIp(Long.parseLong(ipgkzbList.get(i).getDip())));
			}
			resultMap.put("sport", ipgkzbList.get(i).getSport());
			resultMap.put("dport", ipgkzbList.get(i).getDport());
			resultMap.put("protocol", TranslatingUtil.CSCXY(ipgkzbList.get(i).getProtocol()));
			resultMap.put("protoId", ipgkzbList.get(i).getProtoId());
			resultMap.put("detailId", TranslatingUtil.XXID(ipgkzbList.get(i).getDetailId()));
			resultMap.put("csPkts", ipgkzbList.get(i).getCsPkts());
			resultMap.put("csBytes", ipgkzbList.get(i).getCsBytes());
			resultMap.put("scPkts", ipgkzbList.get(i).getScPkts());
			resultMap.put("scBytes", ipgkzbList.get(i).getScBytes());
			resultMap.put("username", ipgkzbList.get(i).getUsername());
			resultMap.put("pwd", ipgkzbList.get(i).getPwd());
			resultMap.put("yys", TranslatingUtil.YYS(ipgkzbList.get(i).getYys()));
			resultMap.put("url", ipgkzbList.get(i).getUrl());
			resultMap.put("yl1", ipgkzbList.get(i).getYl1());
			resultMap.put("yl2", ipgkzbList.get(i).getYl2());
			resultMap.put("yl3", ipgkzbList.get(i).getYl3());
			resultMap.put("yl4", ipgkzbList.get(i).getYl4());
			resultMap.put("yl5", ipgkzbList.get(i).getYl5());
			resultList.add(resultMap);
		}
		map = new HashMap<>();
		map.put("data", resultList);
		map.put("pageSize", pageSize);
		map.put("pageNo", pageNo);
		map.put("totalPage", num / pageSize);
		map.put("totalCount", num);
		map.put("code", 200);
		}
		return map;
	}

	@Override
	public Map<String, Object> FTPGJCJCqueryLogInfo(String startTime, String PZID, String label, String LHID,
			String YDY, String MDDY, Integer PZLX, String GKLB, String PROTOCOL, String SIP, String DIP, Integer SPORT,
			Integer DPORT, Integer pageNo, Integer pageSize, String logType, String endTime, String qdjip, String fileName,
			Integer scBytes, Integer csPkts, String yyzl, String gjz, Integer csBytes, Integer scPkts, String fileContent,String yys,int type,List<String> list) {
		Map<String, Object> map = new HashMap<>();
		ArrayList<Map<String, Object>> resultList = new ArrayList<>();
		if (StringUtils.isNotBlank(yys)) {
			map.put("YYS", yys);
		}
		if (StringUtils.isNotBlank(startTime)) {
			map.put("startTime", startTime);
		}
		if (StringUtils.isNotBlank(endTime)) {
			map.put("endTime", endTime);
		}
		if (StringUtils.isNotBlank(PZID)) {
			map.put("PZID", PZID);
		}
		if (StringUtils.isNotBlank(LHID)) {
			map.put("LHID", LHID);
		}
		if (StringUtils.isNotBlank(YDY)) {
			map.put("YDY", YDY.split(","));
		}
		if (StringUtils.isNotBlank(MDDY)) {
			map.put("MDDY", MDDY.split(","));
		}
		map.put("PZLX", PZLX);
		if (StringUtils.isNotBlank(GKLB)) {
			map.put("GKLB", GKLB);
		}
		if (StringUtils.isNotBlank(SIP)) {
			map.put("SIP", IPv4Util.ipToLong(SIP));
		}
		if (StringUtils.isNotBlank(DIP)) {
			map.put("DIP", IPv4Util.ipToLong(DIP));
		}
		if (StringUtils.isNotBlank(PROTOCOL)) {
			map.put("PROTOCOL", TranslatingUtil.PROTOCOL(PROTOCOL));
		}
		if (SPORT!=null&&SPORT >= 0) {
			map.put("SPORT", SPORT);
		}
		if (DPORT!=null&&DPORT >= 0) {
			map.put("DPORT", DPORT);
		}
		
		if (StringUtils.isNotBlank(label)) {
			map.put("LABEL", label.split(","));
		}
		if (StringUtils.isNotBlank(qdjip)) {
			map.put("QDJIP", IPv4Util.ipToLong(qdjip));
		}
		if (StringUtils.isNotBlank(fileName)) {
			map.put("FILE_NAME", fileName);
		}
		if (StringUtils.isNotBlank(yyzl)) {
			map.put("YYZL", IPv4Util.ipToLong(yyzl));
		}
		if (StringUtils.isNotBlank(gjz)) {
			map.put("GJZ", gjz);
		}
		if (StringUtils.isNotBlank(fileContent)) {
			map.put("FILE_CONTENT", fileContent);
		}
		if (scBytes!=null) {
			map.put("SC_BYTES", scBytes);
		}
		if (csBytes!=null) {
			map.put("CS_BYTES", csBytes);
		}
		if (scPkts!=null) {
			map.put("SC_PKTS", scPkts);
		}
		if (csPkts!=null) {
			map.put("CS_PKTS", csPkts);
		}
		
		map.put("start", (pageNo-1)*10);
		map.put("length", pageSize);
		if(list!=null&&list.size()>0) {
			map.put("QXDY", list);
		}
		if(type==1){
            JSONObject jsonObject=JSONObject.fromObject(map);
	        String string = jsonObject.toString();
	        ExportCsv record=new ExportCsv();
	       record.setName(sd.format(new Date()));
	        record.setStatus(0);
	        record.setSqls(string);
	        record.setLogType(PZLX);
	        exportCsvMapper.insert(record);
	        map = new HashMap<>();
			map.put("code", 200);
			map.put("message", "成功");
		}else{
		List<FTPJCZBLogPo> ipgkzbList = ftpJCZBMapper.SelectAll(map);
		Integer num = ftpJCZBMapper.SelectCount(map);
		for (int i = 0; i < ipgkzbList.size(); i++) {
			Map<String, Object> resultMap = new HashMap<>();
			try {
				resultMap.put("bhsj", sdf.format(sdf.parse(ipgkzbList.get(i).getBhsj())));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			resultMap.put("labels", ipgkzbList.get(i).getLabel());
			resultMap.put("pzid", ipgkzbList.get(i).getPzid());
			resultMap.put("flid", ipgkzbList.get(i).getFlid());
			resultMap.put("xzid", ipgkzbList.get(i).getXzid());
			resultMap.put("lhid", TranslatingUtil.LHID(ipgkzbList.get(i).getLhid(), baseJklhMapper));
			resultMap.put("ydy", TranslatingUtil.YDY(ipgkzbList.get(i).getYdy(),areaCodeTMapper));
			resultMap.put("mddy", TranslatingUtil.MDDY(ipgkzbList.get(i).getMddy(),areaCodeTMapper));
			resultMap.put("pzlx", TranslatingUtil.PZLX(ipgkzbList.get(i).getPzlx()));
			resultMap.put("gklb", TranslatingUtil.GKLB(ipgkzbList.get(i).getGklb()));

			if (ipgkzbList.get(i).getYyzl() != null) {
				resultMap.put("yyzl", TranslatingUtil.YYZL(ipgkzbList.get(i).getYyzl()));
			} else {
				resultMap.put("yyzl", "");
			}
			resultMap.put("qdjip", IPv4Util.longToIp(Long.parseLong(ipgkzbList.get(i).getQdjip() + "")));
			if(ipgkzbList.get(i).getYl1()==4) {
				resultMap.put("sip", IPv4Util.longToIp(Long.parseLong(ipgkzbList.get(i).getSip())));
				resultMap.put("dip", IPv4Util.longToIp(Long.parseLong(ipgkzbList.get(i).getDip())));
			}else if(ipgkzbList.get(i).getYl1()==6) {
				resultMap.put("sip", IPv4Util.longToIp(Long.parseLong(ipgkzbList.get(i).getSip())));
				resultMap.put("dip", IPv4Util.longToIp(Long.parseLong(ipgkzbList.get(i).getDip())));
			}else {
				resultMap.put("sip", IPv4Util.longToIp(Long.parseLong(ipgkzbList.get(i).getSip())));
				resultMap.put("dip", IPv4Util.longToIp(Long.parseLong(ipgkzbList.get(i).getDip())));
			}
			resultMap.put("sport", ipgkzbList.get(i).getSport());
			resultMap.put("dport", ipgkzbList.get(i).getDport());
			resultMap.put("protocol", TranslatingUtil.CSCXY(ipgkzbList.get(i).getProtocol()));
			resultMap.put("protoId", ipgkzbList.get(i).getProtoId());
			resultMap.put("detailId", TranslatingUtil.XXID(ipgkzbList.get(i).getDetailId()));
			resultMap.put("csPkts", ipgkzbList.get(i).getCsPkts());
			resultMap.put("csBytes", ipgkzbList.get(i).getCsBytes());
			resultMap.put("scPkts", ipgkzbList.get(i).getScPkts());
			resultMap.put("scBytes", ipgkzbList.get(i).getScBytes());
			resultMap.put("fileName", ipgkzbList.get(i).getFileName());
			resultMap.put("fileContent", ipgkzbList.get(i).getFileContent());
			resultMap.put("yys", TranslatingUtil.YYS(ipgkzbList.get(i).getYys()));
			resultMap.put("gjz", ipgkzbList.get(i).getGjz());
			resultMap.put("yl1", ipgkzbList.get(i).getYl1());
			resultMap.put("yl2", ipgkzbList.get(i).getYl2());
			resultMap.put("yl3", ipgkzbList.get(i).getYl3());
			resultMap.put("yl4", ipgkzbList.get(i).getYl4());
			resultMap.put("yl5", ipgkzbList.get(i).getYl5());
			resultList.add(resultMap);
		}
		map = new HashMap<>();
		map.put("data", resultList);
		map.put("pageSize", pageSize);
		map.put("pageNo", pageNo);
		map.put("totalPage", num / pageSize);
		map.put("totalCount", num);
		map.put("code", 200);
		}
		return map;
	}

	@Override
	public Map<String, Object> WYGJCJCqueryLogInfo(String startTime, String PZID, String label, String LHID, String YDY,
			String MDDY, Integer PZLX, String GKLB, String PROTOCOL, String SIP, String DIP, Integer SPORT, Integer DPORT,
			Integer pageNo, Integer pageSize, String logType, String endTime, String qdjip, Integer scBytes, String ssyq,
			String content, Integer csPkts, String yyzl, String jcUrl, String gjz, Integer csBytes, Integer scPkts,String yys,int type,List<String> list) {
		Map<String, Object> map = new HashMap<>();
		ArrayList<Map<String, Object>> resultList = new ArrayList<>();
		if (StringUtils.isNotBlank(startTime)) {
			map.put("startTime", startTime);
		}
		if (StringUtils.isNotBlank(yys)) {
			map.put("YYS", yys);
		}
		if (StringUtils.isNotBlank(endTime)) {
			map.put("endTime", endTime);
		}
		if (StringUtils.isNotBlank(PZID)) {
			map.put("PZID", PZID);
		}
		if (StringUtils.isNotBlank(LHID)) {
			map.put("LHID", LHID);
		}
		if (StringUtils.isNotBlank(YDY)) {
			map.put("YDY", YDY.split(","));
		}
		if (StringUtils.isNotBlank(MDDY)) {
			map.put("MDDY", MDDY.split(","));
		}
		map.put("PZLX", PZLX);
		if (StringUtils.isNotBlank(GKLB)) {
			map.put("GKLB", GKLB);
		}
		if (StringUtils.isNotBlank(SIP)) {
			map.put("SIP", IPv4Util.ipToLong(SIP));
		}
		if (StringUtils.isNotBlank(DIP)) {
			map.put("DIP", IPv4Util.ipToLong(DIP));
		}
		if (StringUtils.isNotBlank(PROTOCOL)) {
			map.put("PROTOCOL", TranslatingUtil.PROTOCOL(PROTOCOL));
		}
		if (SPORT!=null&&SPORT >= 0) {
			map.put("SPORT", SPORT);
		}
		if (DPORT!=null&&DPORT >= 0) {
			map.put("DPORT", DPORT);
		}
		
		if (scBytes!=null) {
			map.put("SC_BYTES", scBytes);
		}
		if (csBytes!=null) {
			map.put("CS_BYTES", csBytes);
		}
		if (scPkts!=null) {
			map.put("SC_PKTS", scPkts);
		}
		if (csPkts!=null) {
			map.put("CS_PKTS", csPkts);
		}
		if (StringUtils.isNotBlank(label)) {
			map.put("LABEL", label.split(","));
		}
		if (StringUtils.isNotBlank(qdjip)) {
			map.put("QDJIP", IPv4Util.ipToLong(qdjip));
		}
		if (StringUtils.isNotBlank(ssyq)) {
			map.put("SSYQ", ssyq);
		}
		if (StringUtils.isNotBlank(content)) {
			map.put("CONTENT", content);
		}
		if (StringUtils.isNotBlank(yyzl)) {
			map.put("YYZL", yyzl);
		}
		if (StringUtils.isNotBlank(jcUrl)) {
			map.put("JC_URL", jcUrl);
		}
		if (StringUtils.isNotBlank(gjz)) {
			map.put("GJZ", gjz);
		}
		
		map.put("start", (pageNo-1)*10);
		map.put("length", pageSize);
		if(list!=null&&list.size()>0) {
			map.put("QXDY", list);
		}
		if(type==1){
            JSONObject jsonObject=JSONObject.fromObject(map);
	        String string = jsonObject.toString();
	        ExportCsv record=new ExportCsv();
	       record.setName(sd.format(new Date()));
	        record.setStatus(0);
	        record.setSqls(string);
	        record.setLogType(PZLX);
	        exportCsvMapper.insert(record);
	        map = new HashMap<>();
			map.put("code", 200);
			map.put("message", "成功");
		}else{
		List<WYGJCJCRZLogPo> ipgkzbList = wtgjcJCRZMapper.SelectAll(map);
		Integer num = wtgjcJCRZMapper.SelectCount(map);
		for (int i = 0; i < ipgkzbList.size(); i++) {
			Map<String, Object> resultMap = new HashMap<>();
			try {
				resultMap.put("bhsj", sdf.format(sdf.parse(ipgkzbList.get(i).getBhsj())));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			resultMap.put("labels", ipgkzbList.get(i).getLabel());
			resultMap.put("pzid", ipgkzbList.get(i).getPzid());
			resultMap.put("flid", ipgkzbList.get(i).getFlid());
			resultMap.put("xzid", ipgkzbList.get(i).getXzid());
			resultMap.put("lhid", TranslatingUtil.LHID(ipgkzbList.get(i).getLhid(), baseJklhMapper));
			resultMap.put("ydy", TranslatingUtil.YDY(ipgkzbList.get(i).getYdy(),areaCodeTMapper));
			resultMap.put("mddy", TranslatingUtil.MDDY(ipgkzbList.get(i).getMddy(),areaCodeTMapper));
			resultMap.put("pzlx", TranslatingUtil.PZLX(ipgkzbList.get(i).getPzlx()));
			resultMap.put("gklb", TranslatingUtil.GKLB(ipgkzbList.get(i).getGklb()));
			if (ipgkzbList.get(i).getYyzl() != null) {
				resultMap.put("yyzl", TranslatingUtil.YYZL(ipgkzbList.get(i).getYyzl()));
			} else {
				resultMap.put("yyzl", "");
			}

			resultMap.put("qdjip", IPv4Util.longToIp(Long.parseLong(ipgkzbList.get(i).getQdjip() + "")));
			if(ipgkzbList.get(i).getYl1()==4) {
				resultMap.put("sip", IPv4Util.longToIp(Long.parseLong(ipgkzbList.get(i).getSip())));
				resultMap.put("dip", IPv4Util.longToIp(Long.parseLong(ipgkzbList.get(i).getDip())));
			}else if(ipgkzbList.get(i).getYl1()==6) {
				resultMap.put("sip", IPv4Util.longToIp(Long.parseLong(ipgkzbList.get(i).getSip())));
				resultMap.put("dip", IPv4Util.longToIp(Long.parseLong(ipgkzbList.get(i).getDip())));
			}else {
				resultMap.put("sip", IPv4Util.longToIp(Long.parseLong(ipgkzbList.get(i).getSip())));
				resultMap.put("dip", IPv4Util.longToIp(Long.parseLong(ipgkzbList.get(i).getDip())));
			}
			resultMap.put("sport", ipgkzbList.get(i).getSport());
			resultMap.put("dport", ipgkzbList.get(i).getDport());
			resultMap.put("protocol", TranslatingUtil.CSCXY(ipgkzbList.get(i).getProtocol()));
			resultMap.put("protoId", ipgkzbList.get(i).getProtoId());
			resultMap.put("detailId", TranslatingUtil.XXID(ipgkzbList.get(i).getDetailId()));
			resultMap.put("csPkts", ipgkzbList.get(i).getCsPkts());
			resultMap.put("csBytes", ipgkzbList.get(i).getCsBytes());
			resultMap.put("scPkts", ipgkzbList.get(i).getScPkts());
			resultMap.put("scBytes", ipgkzbList.get(i).getScBytes());
			resultMap.put("ssyq", ipgkzbList.get(i).getSsyq());
			resultMap.put("yys", TranslatingUtil.YYS(ipgkzbList.get(i).getYys()));
			resultMap.put("gjz", ipgkzbList.get(i).getGjz());
			resultMap.put("yl1", ipgkzbList.get(i).getYl1());
			resultMap.put("yl2", ipgkzbList.get(i).getYl2());
			resultMap.put("yl3", ipgkzbList.get(i).getYl3());
			resultMap.put("yl4", ipgkzbList.get(i).getYl4());
			resultMap.put("yl5", ipgkzbList.get(i).getYl5());
			resultMap.put("jcUrl", ipgkzbList.get(i).getJcUrl());
			resultMap.put("content", ipgkzbList.get(i).getContent());
			resultList.add(resultMap);
		}
		map = new HashMap<>();
		map.put("data", resultList);
		map.put("pageSize", pageSize);
		map.put("pageNo", pageNo);
		map.put("totalPage", num / pageSize);
		map.put("totalCount", num);
		map.put("code", 200);
		}
		return map;
	}

	@Override
	public Map<String, Object> IPJCqueryLogInfo(String startTime, String PZID, String label, String LHID, String YDY,
			String MDDY, Integer PZLX, String GKLB, String PROTOCOL, String SIP, String DIP, Integer SPORT, Integer DPORT,
			Integer pageNo, Integer pageSize, String logType, String endTime, String qdjip, Integer scBytes, String content,
			String host, Integer csPkts, String url, Integer csBytes, Integer scPkts,String yys,int type,List<String> list) {
		Map<String, Object> map = new HashMap<>();
		ArrayList<Map<String, Object>> resultList = new ArrayList<>();
		if (StringUtils.isNotBlank(startTime)) {
			map.put("startTime", startTime);
		}
		if (StringUtils.isNotBlank(yys)) {
			map.put("YYS", yys);
		}
		if (StringUtils.isNotBlank(endTime)) {
			map.put("endTime", endTime);
		}
		if (StringUtils.isNotBlank(PZID)) {
			map.put("PZID", PZID);
		}
		if (StringUtils.isNotBlank(LHID)) {
			map.put("LHID", LHID);
		}
		if (StringUtils.isNotBlank(YDY)) {
			map.put("YDY", YDY.split(","));
		}
		if (StringUtils.isNotBlank(MDDY)) {
			map.put("MDDY", MDDY.split(","));
		}
		map.put("PZLX", PZLX);
		if (StringUtils.isNotBlank(GKLB)) {
			map.put("GKLB", GKLB);
		}
		if (StringUtils.isNotBlank(SIP)) {
			map.put("SIP", IPv4Util.ipToLong(SIP));
		}
		if (StringUtils.isNotBlank(DIP)) {
			map.put("DIP", IPv4Util.ipToLong(DIP));
		}
		if (StringUtils.isNotBlank(PROTOCOL)) {
			map.put("PROTOCOL", TranslatingUtil.PROTOCOL(PROTOCOL));
		}
		if (SPORT!=null&&SPORT >= 0) {
			map.put("SPORT", SPORT);
		}
		if (DPORT!=null&&DPORT >= 0) {
			map.put("DPORT", DPORT);
		}
		
		if (scBytes!=null) {
			map.put("SC_BYTES", scBytes);
		}
		if (csBytes!=null) {
			map.put("CS_BYTES", csBytes);
		}
		if (scPkts!=null) {
			map.put("SC_PKTS", scPkts);
		}
		if (csPkts!=null) {
			map.put("CS_PKTS", csPkts);
		}
		if (StringUtils.isNotBlank(label)) {
			map.put("LABEL", label.split(","));
		}
		if (StringUtils.isNotBlank(qdjip)) {
			map.put("QDJIP", IPv4Util.ipToLong(qdjip));
		}
		if (StringUtils.isNotBlank(content)) {
			map.put("CONTENT", content);
		}
		if (StringUtils.isNotBlank(host)) {
			map.put("HOST", host);
		}
		if (StringUtils.isNotBlank(url)) {
			map.put("URL", url);
		}
		
		map.put("start", (pageNo-1)*10);
		map.put("length", pageSize);
		if(list!=null&&list.size()>0) {
			map.put("QXDY", list);
		}
		if(type==1){
            JSONObject jsonObject=JSONObject.fromObject(map);
	        String string = jsonObject.toString();
	        ExportCsv record=new ExportCsv();
	       record.setName(sd.format(new Date()));
	        record.setStatus(0);
	        record.setSqls(string);
	        record.setLogType(PZLX);
	        exportCsvMapper.insert(record);
	        map = new HashMap<>();
			map.put("code", 200);
			map.put("message", "成功");
		}else{
		List<IPJCZBLogPo> ipgkzbList = ipJCZBMapper.SelectAll(map);
		Integer num = ipJCZBMapper.SelectCount(map);
		for (int i = 0; i < ipgkzbList.size(); i++) {
			Map<String, Object> resultMap = new HashMap<>();
			try {
				resultMap.put("bhsj", sdf.format(sdf.parse(ipgkzbList.get(i).getBhsj())));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			resultMap.put("labels", ipgkzbList.get(i).getLabel());
			resultMap.put("pzid", ipgkzbList.get(i).getPzid());
			resultMap.put("flid", ipgkzbList.get(i).getFlid());
			resultMap.put("xzid", ipgkzbList.get(i).getXzid());
			resultMap.put("lhid", TranslatingUtil.LHID(ipgkzbList.get(i).getLhid(), baseJklhMapper));
			resultMap.put("ydy", TranslatingUtil.YDY(ipgkzbList.get(i).getYdy(),areaCodeTMapper));
			resultMap.put("mddy", TranslatingUtil.MDDY(ipgkzbList.get(i).getMddy(),areaCodeTMapper));
			resultMap.put("pzlx", TranslatingUtil.PZLX(ipgkzbList.get(i).getPzlx()));
			resultMap.put("gklb", TranslatingUtil.GKLB(ipgkzbList.get(i).getGklb()));
			resultMap.put("qdjip", IPv4Util.longToIp(Long.parseLong(ipgkzbList.get(i).getQdjip() + "")));
			if(ipgkzbList.get(i).getYl1()==4) {
				resultMap.put("sip", IPv4Util.longToIp(Long.parseLong(ipgkzbList.get(i).getSip())));
				resultMap.put("dip", IPv4Util.longToIp(Long.parseLong(ipgkzbList.get(i).getDip())));
			}else if(ipgkzbList.get(i).getYl1()==6) {
				resultMap.put("sip", IPv4Util.longToIp(Long.parseLong(ipgkzbList.get(i).getSip())));
				resultMap.put("dip", IPv4Util.longToIp(Long.parseLong(ipgkzbList.get(i).getDip())));
			}else {
				resultMap.put("sip", IPv4Util.longToIp(Long.parseLong(ipgkzbList.get(i).getSip())));
				resultMap.put("dip", IPv4Util.longToIp(Long.parseLong(ipgkzbList.get(i).getDip())));
			}
			resultMap.put("sport", ipgkzbList.get(i).getSport());
			resultMap.put("dport", ipgkzbList.get(i).getDport());
			resultMap.put("protocol", TranslatingUtil.CSCXY(ipgkzbList.get(i).getProtocol()));
			resultMap.put("protoId", ipgkzbList.get(i).getProtoId());
			resultMap.put("detailId", TranslatingUtil.XXID(ipgkzbList.get(i).getDetailId()));
			resultMap.put("csPkts", ipgkzbList.get(i).getCsPkts());
			resultMap.put("csBytes", ipgkzbList.get(i).getCsBytes());
			resultMap.put("scPkts", ipgkzbList.get(i).getScPkts());
			resultMap.put("scBytes", ipgkzbList.get(i).getScBytes());
			resultMap.put("host", ipgkzbList.get(i).getHost());
			resultMap.put("yys", TranslatingUtil.YYS(ipgkzbList.get(i).getYys()));
			resultMap.put("url", ipgkzbList.get(i).getUrl());
			resultMap.put("yl1", ipgkzbList.get(i).getYl1());
			resultMap.put("yl2", ipgkzbList.get(i).getYl2());
			resultMap.put("yl3", ipgkzbList.get(i).getYl3());
			resultMap.put("yl4", ipgkzbList.get(i).getYl4());
			resultMap.put("yl5", ipgkzbList.get(i).getYl5());
			resultMap.put("content", ipgkzbList.get(i).getContent());
			resultList.add(resultMap);
		}
		map = new HashMap<>();
		map.put("data", resultList);
		map.put("pageSize", pageSize);
		map.put("pageNo", pageNo);
		map.put("totalPage", num / pageSize);
		map.put("totalCount", num);
		map.put("code", 200);
		}
		return map;
	}

	@Override
	public Map<String, Object> TPJCqueryLogInfo(String startTime, String PZID, String label, String LHID, String YDY,
			String MDDY, Integer PZLX, String GKLB, String PROTOCOL, String SIP, String DIP, Integer SPORT, Integer DPORT,
			Integer pageNo, Integer pageSize, String logType, String endTime, String qdjip, String picName, Integer scBytes,
			String picUrl, Integer csPkts, String picType, String yyzl, String url, String picContent, Integer csBytes,
			Integer scPkts,String yys,int type,List<String> list) {
		Map<String, Object> map = new HashMap<>();
		ArrayList<Map<String, Object>> resultList = new ArrayList<>();
		if (StringUtils.isNotBlank(startTime)) {
			map.put("startTime", startTime);
		}
		if (StringUtils.isNotBlank(yys)) {
			map.put("YYS", yys);
		}
		if (StringUtils.isNotBlank(endTime)) {
			map.put("endTime", endTime);
		}
		if (StringUtils.isNotBlank(PZID)) {
			map.put("PZID", PZID);
		}
		if (StringUtils.isNotBlank(LHID)) {
			map.put("LHID", LHID);
		}
		if (StringUtils.isNotBlank(YDY)) {
			map.put("YDY", YDY.split(","));
		}
		if (StringUtils.isNotBlank(MDDY)) {
			map.put("MDDY", MDDY.split(","));
		}
		map.put("PZLX", PZLX);
		if (StringUtils.isNotBlank(GKLB)) {
			map.put("GKLB", GKLB);
		}
		if (StringUtils.isNotBlank(SIP)) {
			map.put("SIP", IPv4Util.ipToLong(SIP));
		}
		if (StringUtils.isNotBlank(DIP)) {
			map.put("DIP", IPv4Util.ipToLong(DIP));
		}
		if (StringUtils.isNotBlank(PROTOCOL)) {
			map.put("PROTOCOL", TranslatingUtil.PROTOCOL(PROTOCOL));
		}
		if (SPORT!=null&&SPORT >= 0) {
			map.put("SPORT", SPORT);
		}
		if (DPORT!=null&&DPORT >= 0) {
			map.put("DPORT", DPORT);
		}
		
		if (scBytes!=null) {
			map.put("SC_BYTES", scBytes);
		}
		if (csBytes!=null) {
			map.put("CS_BYTES", csBytes);
		}
		if (scPkts!=null) {
			map.put("SC_PKTS", scPkts);
		}
		if (csPkts!=null) {
			map.put("CS_PKTS", csPkts);
		}
		if (StringUtils.isNotBlank(label)) {
			if (StringUtils.isNotBlank(label)) {
				String[] string=new String[label.split(",").length];
				String[] lab=label.split(",");
				for(int i=0;i<lab.length;i++){
					string[i]=lab[i];
				}
				map.put("LABEL", lab);
			}
		}
		if (StringUtils.isNotBlank(qdjip)) {
			map.put("QDJIP", IPv4Util.ipToLong(qdjip));
		}
		if (StringUtils.isNotBlank(picName)) {
			map.put("PIC_NAME", picName);
		}
		if (StringUtils.isNotBlank(picUrl)) {
			map.put("PIC_URL", picUrl);
		}
		if (StringUtils.isNotBlank(picType)) {
			map.put("PIC_TYPE", picType);
		}
		if (StringUtils.isNotBlank(yyzl)) {
			map.put("YYZL", yyzl);
		}
		if (StringUtils.isNotBlank(url)) {
			map.put("URL", url);
		}
		if (StringUtils.isNotBlank(picContent)) {
			map.put("PIC_CONTENT", picContent);
		}
		
		map.put("start", (pageNo-1)*10);
		map.put("length", pageSize);
		if(list!=null&&list.size()>0) {
			map.put("QXDY", list);
		}
		if(type==1){
            JSONObject jsonObject=JSONObject.fromObject(map);
	        String string = jsonObject.toString();
	        ExportCsv record=new ExportCsv();
	       record.setName(sd.format(new Date()));
	        record.setStatus(0);
	        record.setSqls(string);
	        record.setLogType(PZLX);
	        exportCsvMapper.insert(record);
	        map = new HashMap<>();
			map.put("code", 200);
			map.put("message", "成功");
		}else{
		List<PICJCZBLogPo> ipgkzbList = picJCZBMapper.SelectAll(map);
		Integer num = picJCZBMapper.SelectCount(map);
		for (int i = 0; i < ipgkzbList.size(); i++) {
			Map<String, Object> resultMap = new HashMap<>();
			try {
				resultMap.put("bhsj", sdf.format(sdf.parse(ipgkzbList.get(i).getBhsj())));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			resultMap.put("labels", ipgkzbList.get(i).getLabel());
			resultMap.put("pzid", ipgkzbList.get(i).getPzid());
			resultMap.put("flid", ipgkzbList.get(i).getFlid());
			resultMap.put("xzid", ipgkzbList.get(i).getXzid());
			resultMap.put("lhid", TranslatingUtil.LHID(ipgkzbList.get(i).getLhid(), baseJklhMapper));
			resultMap.put("ydy", TranslatingUtil.YDY(ipgkzbList.get(i).getYdy(),areaCodeTMapper));
			resultMap.put("mddy", TranslatingUtil.MDDY(ipgkzbList.get(i).getMddy(),areaCodeTMapper));
			resultMap.put("pzlx", TranslatingUtil.PZLX(ipgkzbList.get(i).getPzlx()));
			resultMap.put("gklb", TranslatingUtil.GKLB(ipgkzbList.get(i).getGklb()));
			if (ipgkzbList.get(i).getYyzl() != null) {
				resultMap.put("yyzl", TranslatingUtil.YYZL(ipgkzbList.get(i).getYyzl()));
			} else {
				resultMap.put("yyzl", "");
			}
			resultMap.put("qdjip", IPv4Util.longToIp(Long.parseLong(ipgkzbList.get(i).getQdjip() + "")));
			if(ipgkzbList.get(i).getYl1()==4) {
				resultMap.put("sip", IPv4Util.longToIp(Long.parseLong(ipgkzbList.get(i).getSip())));
				resultMap.put("dip", IPv4Util.longToIp(Long.parseLong(ipgkzbList.get(i).getDip())));
			}else if(ipgkzbList.get(i).getYl1()==6) {
				resultMap.put("sip", IPv4Util.longToIp(Long.parseLong(ipgkzbList.get(i).getSip())));
				resultMap.put("dip", IPv4Util.longToIp(Long.parseLong(ipgkzbList.get(i).getDip())));
			}else {
				resultMap.put("sip", IPv4Util.longToIp(Long.parseLong(ipgkzbList.get(i).getSip())));
				resultMap.put("dip", IPv4Util.longToIp(Long.parseLong(ipgkzbList.get(i).getDip())));
			}
			resultMap.put("sport", ipgkzbList.get(i).getSport());
			resultMap.put("dport", ipgkzbList.get(i).getDport());
			resultMap.put("protocol", TranslatingUtil.CSCXY(ipgkzbList.get(i).getProtocol()));
			resultMap.put("protoId", ipgkzbList.get(i).getProtoId());
			resultMap.put("detailId", TranslatingUtil.XXID(ipgkzbList.get(i).getDetailId()));
			resultMap.put("csPkts", ipgkzbList.get(i).getCsPkts());
			resultMap.put("csBytes", ipgkzbList.get(i).getCsBytes());
			resultMap.put("scPkts", ipgkzbList.get(i).getScPkts());
			resultMap.put("scBytes", ipgkzbList.get(i).getScBytes());
			resultMap.put("picName", ipgkzbList.get(i).getPicName());
			resultMap.put("picType", ipgkzbList.get(i).getPicType());
			resultMap.put("picContent", ipgkzbList.get(i).getPicContent());
			resultMap.put("yys", TranslatingUtil.YYS(ipgkzbList.get(i).getYys()));
			resultMap.put("yl1", ipgkzbList.get(i).getYl1());
			resultMap.put("yl2", ipgkzbList.get(i).getYl2());
			resultMap.put("yl3", ipgkzbList.get(i).getYl3());
			resultMap.put("yl4", ipgkzbList.get(i).getYl4());
			resultMap.put("yl5", ipgkzbList.get(i).getYl5());
			resultMap.put("picUrl", ipgkzbList.get(i).getPicUrl());
			resultMap.put("url", ipgkzbList.get(i).getUrl());
			resultList.add(resultMap);
		}
		map = new HashMap<>();
		map.put("data", resultList);
		map.put("pageSize", pageSize);
		map.put("pageNo", pageNo);
		map.put("totalPage", num / pageSize);
		map.put("totalCount", num);
		map.put("code", 200);
		}
		return map;
	}

	@Override
	public Map<String, Object> DMTJCqueryLogInfo(String startTime, String PZID, String label, String LHID, String YDY,
			String MDDY, Integer PZLX, String GKLB, String PROTOCOL, String SIP, String DIP, Integer SPORT, Integer DPORT,
			Integer pageNo, Integer pageSize, String logType, String endTime, String qdjip, Integer scBytes, String mediaContent,
			String mediaName, Integer csPkts, String mediaUrl, String yyzl, String mediaType, String url, Integer csBytes,
			Integer scPkts,String yys,int type,List<String> list) {
		Map<String, Object> map = new HashMap<>();
		ArrayList<Map<String, Object>> resultList = new ArrayList<>();
		if (StringUtils.isNotBlank(startTime)) {
			map.put("startTime", startTime);
		}
		if (StringUtils.isNotBlank(yys)) {
			map.put("YYS", yys);
		}
		if (StringUtils.isNotBlank(endTime)) {
			map.put("endTime", endTime);
		}
		if (StringUtils.isNotBlank(PZID)) {
			map.put("PZID", PZID);
		}
		if (StringUtils.isNotBlank(LHID)) {
			map.put("LHID", LHID);
		}
		if (StringUtils.isNotBlank(YDY)) {
			map.put("YDY", YDY.split(","));
		}
		if (StringUtils.isNotBlank(MDDY)) {
			map.put("MDDY", MDDY.split(","));
		}
		map.put("PZLX", PZLX);
		if (StringUtils.isNotBlank(GKLB)) {
			map.put("GKLB", GKLB);
		}
		if (StringUtils.isNotBlank(SIP)) {
			map.put("SIP", IPv4Util.ipToLong(SIP));
		}
		if (StringUtils.isNotBlank(DIP)) {
			map.put("DIP", IPv4Util.ipToLong(DIP));
		}
		if (StringUtils.isNotBlank(PROTOCOL)) {
			map.put("PROTOCOL", TranslatingUtil.PROTOCOL(PROTOCOL));
		}
		if (SPORT!=null&&SPORT >= 0) {
			map.put("SPORT", SPORT);
		}
		if (DPORT!=null&&DPORT >= 0) {
			map.put("DPORT", DPORT);
		}
		
		if (StringUtils.isNotBlank(label)) {
			if (StringUtils.isNotBlank(label)) {
				String[] string=new String[label.split(",").length];
				String[] lab=label.split(",");
				for(int i=0;i<lab.length;i++){
					string[i]=lab[i];
				}
				map.put("LABEL", lab);
			}
		}
		if (StringUtils.isNotBlank(qdjip)) {
			map.put("QDJIP", IPv4Util.ipToLong(qdjip));
		}
		if (scBytes!=null) {
			map.put("SC_BYTES", scBytes);
		}
		if (csBytes!=null) {
			map.put("CS_BYTES", csBytes);
		}
		if (scPkts!=null) {
			map.put("SC_PKTS", scPkts);
		}
		if (csPkts!=null) {
			map.put("CS_PKTS", csPkts);
		}
		if (StringUtils.isNotBlank(mediaContent)) {
			map.put("MEDIA_CONTENT", mediaContent);
		}
		if (StringUtils.isNotBlank(mediaName)) {
			map.put("MEDIA_NAME", mediaName);
		}
		if (StringUtils.isNotBlank(mediaUrl)) {
			map.put("MEDIA_URL", mediaUrl);
		}
		if (StringUtils.isNotBlank(mediaType)) {
			map.put("MEDIA_TYPE", mediaType);
		}
		if (StringUtils.isNotBlank(yyzl)) {
			map.put("YYZL", yyzl);
		}
		if (StringUtils.isNotBlank(url)) {
			map.put("URL", url);
		}
		
		map.put("start", (pageNo-1)*10);
		map.put("length", pageSize);
		if(list!=null&&list.size()>0) {
			map.put("QXDY", list);
		}
		if(type==1){
            JSONObject jsonObject=JSONObject.fromObject(map);
	        String string = jsonObject.toString();
	        ExportCsv record=new ExportCsv();
	       record.setName(sd.format(new Date()));
	        record.setStatus(0);
	        record.setSqls(string);
	        record.setLogType(PZLX);
	        exportCsvMapper.insert(record);
	        map = new HashMap<>();
			map.put("code", 200);
			map.put("message", "成功");
		}else{
		List<MEDIAJCZBLogPo> ipgkzbList = mediaJCZBMapper.SelectAll(map);
		Integer num = mediaJCZBMapper.SelectCount(map);
		for (int i = 0; i < ipgkzbList.size(); i++) {
			Map<String, Object> resultMap = new HashMap<>();
			try {
				resultMap.put("bhsj", sdf.format(sdf.parse(ipgkzbList.get(i).getBhsj())));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			resultMap.put("labels", ipgkzbList.get(i).getLabel());
			resultMap.put("pzid", ipgkzbList.get(i).getPzid());
			resultMap.put("flid", ipgkzbList.get(i).getFlid());
			resultMap.put("xzid", ipgkzbList.get(i).getXzid());
			resultMap.put("lhid", TranslatingUtil.LHID(ipgkzbList.get(i).getLhid(), baseJklhMapper));
			resultMap.put("ydy", TranslatingUtil.YDY(ipgkzbList.get(i).getYdy(),areaCodeTMapper));
			resultMap.put("mddy", TranslatingUtil.MDDY(ipgkzbList.get(i).getMddy(),areaCodeTMapper));
			resultMap.put("pzlx", TranslatingUtil.PZLX(ipgkzbList.get(i).getPzlx()));
			resultMap.put("gklb", TranslatingUtil.GKLB(ipgkzbList.get(i).getGklb()));
			if (ipgkzbList.get(i).getYyzl() != null) {
				resultMap.put("yyzl", TranslatingUtil.YYZL(ipgkzbList.get(i).getYyzl()));
			} else {
				resultMap.put("yyzl", "");
			}
			resultMap.put("qdjip", IPv4Util.longToIp(Long.parseLong(ipgkzbList.get(i).getQdjip() + "")));
			if(ipgkzbList.get(i).getYl1()==4) {
				resultMap.put("sip", IPv4Util.longToIp(Long.parseLong(ipgkzbList.get(i).getSip())));
				resultMap.put("dip", IPv4Util.longToIp(Long.parseLong(ipgkzbList.get(i).getDip())));
			}else if(ipgkzbList.get(i).getYl1()==6) {
				resultMap.put("sip", IPv4Util.longToIp(Long.parseLong(ipgkzbList.get(i).getSip())));
				resultMap.put("dip", IPv4Util.longToIp(Long.parseLong(ipgkzbList.get(i).getDip())));
			}else {
				resultMap.put("sip", IPv4Util.longToIp(Long.parseLong(ipgkzbList.get(i).getSip())));
				resultMap.put("dip", IPv4Util.longToIp(Long.parseLong(ipgkzbList.get(i).getDip())));
			}
			resultMap.put("sport", ipgkzbList.get(i).getSport());
			resultMap.put("dport", ipgkzbList.get(i).getDport());
			resultMap.put("protocol", TranslatingUtil.CSCXY(ipgkzbList.get(i).getProtocol()));
			resultMap.put("protoId", ipgkzbList.get(i).getProtoId());
			resultMap.put("detailId", TranslatingUtil.XXID(ipgkzbList.get(i).getDetailId()));
			resultMap.put("csPkts", ipgkzbList.get(i).getCsPkts());
			resultMap.put("csBytes", ipgkzbList.get(i).getCsBytes());
			resultMap.put("scPkts", ipgkzbList.get(i).getScPkts());
			resultMap.put("scBytes", ipgkzbList.get(i).getScBytes());
			resultMap.put("mediaName", ipgkzbList.get(i).getMediaName());
			resultMap.put("mediaType", ipgkzbList.get(i).getMediaType());
			resultMap.put("mediaContent", ipgkzbList.get(i).getMediaContent());
			resultMap.put("yys", TranslatingUtil.YYS(ipgkzbList.get(i).getYys()));
			resultMap.put("yl1", ipgkzbList.get(i).getYl1());
			resultMap.put("yl2", ipgkzbList.get(i).getYl2());
			resultMap.put("yl3", ipgkzbList.get(i).getYl3());
			resultMap.put("yl4", ipgkzbList.get(i).getYl4());
			resultMap.put("yl5", ipgkzbList.get(i).getYl5());
			resultMap.put("mediaUrl", ipgkzbList.get(i).getMediaUrl());
			resultMap.put("url", ipgkzbList.get(i).getUrl());
			resultList.add(resultMap);
		}
		map = new HashMap<>();
		map.put("data", resultList);
		map.put("pageSize", pageSize);
		map.put("pageNo", pageNo);
		map.put("totalPage", num / pageSize);
		map.put("totalCount", num);
		map.put("code", 200);
		}
		return map;
	}

	@Override
	public Map<String, Object> HTTPGKqueryLogInfo(String startTime, String PZID, String label, String LHID, String YDY,
			String MDDY, Integer PZLX, String GKLB, String PROTOCOL, String SIP, String DIP, Integer SPORT, Integer DPORT,
			Integer pageNo, Integer pageSize, String logType, String endTime, String qdjip, String fileName, String content,
			String host, String cookie, String yyzl, String userAgent, String url,String yys,int type,List<String> list) {
		Map<String, Object> map = new HashMap<>();
		ArrayList<Map<String, Object>> resultList = new ArrayList<>();
		if (StringUtils.isNotBlank(startTime)) {
			map.put("startTime", startTime);
		}
		if (StringUtils.isNotBlank(yys)) {
			map.put("YYS", yys);
		}
		if (StringUtils.isNotBlank(endTime)) {
			map.put("endTime", endTime);
		}
		if (StringUtils.isNotBlank(PZID)) {
			map.put("PZID", PZID);
		}
		if (StringUtils.isNotBlank(LHID)) {
			map.put("LHID", LHID);
		}
		if (StringUtils.isNotBlank(YDY)) {
			map.put("YDY", YDY.split(","));
		}
		if (StringUtils.isNotBlank(MDDY)) {
			map.put("MDDY", MDDY.split(","));
		}
		map.put("PZLX", PZLX);
		if (StringUtils.isNotBlank(GKLB)) {
			map.put("GKLB", GKLB);
		}
		if (StringUtils.isNotBlank(SIP)) {
			map.put("SIP", IPv4Util.ipToLong(SIP));
		}
		if (StringUtils.isNotBlank(DIP)) {
			map.put("DIP", IPv4Util.ipToLong(DIP));
		}
		if (StringUtils.isNotBlank(PROTOCOL)) {
			map.put("PROTOCOL", TranslatingUtil.PROTOCOL(PROTOCOL));
		}
		if (SPORT!=null&&SPORT >= 0) {
			map.put("SPORT", SPORT);
		}
		if (DPORT!=null&&DPORT >= 0) {
			map.put("DPORT", DPORT);
		}
		if (StringUtils.isNotBlank(label)) {
			if (StringUtils.isNotBlank(label)) {
				String[] string=new String[label.split(",").length];
				String[] lab=label.split(",");
				for(int i=0;i<lab.length;i++){
					string[i]=lab[i];
				}
				map.put("LABEL", lab);
			}
		}
		if (StringUtils.isNotBlank(qdjip)) {
			map.put("QDJIP", IPv4Util.ipToLong(qdjip));
		}
		if (StringUtils.isNotBlank(fileName)) {
			map.put("FILE_NAME", fileName);
		}
		if (StringUtils.isNotBlank(content)) {
			map.put("CONTENT", content);
		}
		if (StringUtils.isNotBlank(host)) {
			map.put("HOST", host);
		}
		if (StringUtils.isNotBlank(cookie)) {
			map.put("COOKIE", cookie);
		}
		if (StringUtils.isNotBlank(yyzl)) {
			map.put("YYZL", yyzl);
		}
		if (StringUtils.isNotBlank(userAgent)) {
			map.put("USER_AGENT", userAgent);
		}
		if (StringUtils.isNotBlank(url)) {
			map.put("URL", url);
		}
		
		map.put("start", (pageNo-1)*10);
		map.put("length", pageSize);
		if(list!=null&&list.size()>0) {
			map.put("QXDY", list);
		}
		if(type==1){
            JSONObject jsonObject=JSONObject.fromObject(map);
	        String string = jsonObject.toString();
	        ExportCsv record=new ExportCsv();
	       record.setName(sd.format(new Date()));
	        record.setStatus(0);
	        record.setSqls(string);
	        record.setLogType(PZLX);
	        exportCsvMapper.insert(record);
	        map = new HashMap<>();
			map.put("code", 200);
			map.put("message", "成功");
		}else{
		List<HTTPGKZBLogPo> ipgkzbList = httpGKZBMapper.SelectAll(map);
		Integer num = httpGKZBMapper.SelectCount(map);
		for (int i = 0; i < ipgkzbList.size(); i++) {
			Map<String, Object> resultMap = new HashMap<>();
			try {
				resultMap.put("bhsj", sdf.format(sdf.parse(ipgkzbList.get(i).getBhsj())));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			resultMap.put("labels", ipgkzbList.get(i).getLabel());
			resultMap.put("pzid", ipgkzbList.get(i).getPzid());
			resultMap.put("flid", ipgkzbList.get(i).getFlid());
			resultMap.put("xzid", ipgkzbList.get(i).getXzid());
			resultMap.put("lhid", TranslatingUtil.LHID(ipgkzbList.get(i).getLhid(), baseJklhMapper));
			resultMap.put("ydy", TranslatingUtil.YDY(ipgkzbList.get(i).getYdy(),areaCodeTMapper));
			resultMap.put("mddy", TranslatingUtil.MDDY(ipgkzbList.get(i).getMddy(),areaCodeTMapper));
			resultMap.put("pzlx", TranslatingUtil.PZLX(ipgkzbList.get(i).getPzlx()));
			resultMap.put("gklb", TranslatingUtil.GKLB(ipgkzbList.get(i).getGklb()));
			if (ipgkzbList.get(i).getYyzl() != null) {
				resultMap.put("yyzl", TranslatingUtil.YYZL(ipgkzbList.get(i).getYyzl()));
			} else {
				resultMap.put("yyzl", "");
			}
			resultMap.put("qdjip", IPv4Util.longToIp(Long.parseLong(ipgkzbList.get(i).getQdjip() + "")));
			if(ipgkzbList.get(i).getYl1()==4) {
				resultMap.put("sip", IPv4Util.longToIp(Long.parseLong(ipgkzbList.get(i).getSip())));
				resultMap.put("dip", IPv4Util.longToIp(Long.parseLong(ipgkzbList.get(i).getDip())));
			}else if(ipgkzbList.get(i).getYl1()==6) {
				resultMap.put("sip", IPv4Util.longToIp(Long.parseLong(ipgkzbList.get(i).getSip())));
				resultMap.put("dip", IPv4Util.longToIp(Long.parseLong(ipgkzbList.get(i).getDip())));
			}else {
				resultMap.put("sip", IPv4Util.longToIp(Long.parseLong(ipgkzbList.get(i).getSip())));
				resultMap.put("dip", IPv4Util.longToIp(Long.parseLong(ipgkzbList.get(i).getDip())));
			}
			resultMap.put("sport", ipgkzbList.get(i).getSport());
			resultMap.put("dport", ipgkzbList.get(i).getDport());
			resultMap.put("protocol", TranslatingUtil.CSCXY(ipgkzbList.get(i).getProtocol()));
			resultMap.put("protoId", ipgkzbList.get(i).getProtoId());
			resultMap.put("detailId", TranslatingUtil.XXID(ipgkzbList.get(i).getDetailId()));
			resultMap.put("host", ipgkzbList.get(i).getHost());
			resultMap.put("userAgent", ipgkzbList.get(i).getUserAgent());
			resultMap.put("fileName", ipgkzbList.get(i).getFileName());
			resultMap.put("yys", TranslatingUtil.YYS(ipgkzbList.get(i).getYys()));
			resultMap.put("yl1", ipgkzbList.get(i).getYl1());
			resultMap.put("yl2", ipgkzbList.get(i).getYl2());
			resultMap.put("yl3", ipgkzbList.get(i).getYl3());
			resultMap.put("yl4", ipgkzbList.get(i).getYl4());
			resultMap.put("yl5", ipgkzbList.get(i).getYl5());
			resultMap.put("cookie", ipgkzbList.get(i).getCookie());
			resultMap.put("content", ipgkzbList.get(i).getContent());
			resultMap.put("url", ipgkzbList.get(i).getUrl());
			resultList.add(resultMap);
		}
		map = new HashMap<>();
		map.put("data", resultList);
		map.put("pageSize", pageSize);
		map.put("pageNo", pageNo);
		map.put("totalPage", num / pageSize);
		map.put("totalCount", num);
		map.put("code", 200);
		}
		return map;
	}

	@Override
	public Map<String, Object> DNSGKqueryLogInfo(String startTime, String PZID, String label, String LHID, String YDY,
			String MDDY, Integer PZLX, String GKLB, String PROTOCOL, String SIP, String DIP, Integer SPORT, Integer DPORT,
			Integer pageNo, Integer pageSize, String logType, String endTime, String qdjip, String dnsValue, String dnsName,String yys,int type,List<String> list) {
		Map<String, Object> map = new HashMap<>();
		ArrayList<Map<String, Object>> resultList = new ArrayList<>();
		if (StringUtils.isNotBlank(startTime)) {
			map.put("startTime", startTime);
		}
		if (StringUtils.isNotBlank(yys)) {
			map.put("YYS", yys);
		}
		if (StringUtils.isNotBlank(endTime)) {
			map.put("endTime", endTime);
		}
		if (StringUtils.isNotBlank(PZID)) {
			map.put("PZID", PZID);
		}
		if (StringUtils.isNotBlank(label)) {
				String[] lab=label.split(",");
				map.put("LABEL", lab);
		}
		if (StringUtils.isNotBlank(LHID)) {
			map.put("LHID", LHID);
		}
		if (StringUtils.isNotBlank(YDY)) {
			map.put("YDY", YDY.split(","));
		}
		if (StringUtils.isNotBlank(MDDY)) {
			map.put("MDDY", MDDY.split(","));
		}
		map.put("PZLX", PZLX);
		if (StringUtils.isNotBlank(GKLB)) {
			map.put("GKLB", GKLB);
		}
		if (StringUtils.isNotBlank(SIP)) {
			map.put("SIP", IPv4Util.ipToLong(SIP));
		}
		if (StringUtils.isNotBlank(DIP)) {
			map.put("DIP", IPv4Util.ipToLong(DIP));
		}
		if (StringUtils.isNotBlank(PROTOCOL)) {
			map.put("PROTOCOL", TranslatingUtil.PROTOCOL(PROTOCOL));
		}
		if (SPORT!=null&&SPORT >= 0) {
			map.put("SPORT", SPORT);
		}
		if (DPORT!=null&&DPORT >= 0) {
			map.put("DPORT", DPORT);
		}
		if (StringUtils.isNotBlank(qdjip)) {
			map.put("QDJIP", IPv4Util.ipToLong(qdjip));
		}
		if (StringUtils.isNotBlank(dnsValue)) {
			map.put("dnsValue", dnsValue);
		}
		if (StringUtils.isNotBlank(dnsName)) {
			map.put("dnsName", dnsName);
		}
		map.put("start", (pageNo-1)*10);
		map.put("length", pageSize);
		if(list!=null&&list.size()>0) {
			map.put("QXDY", list);
		}
		if(type==1){
            JSONObject jsonObject=JSONObject.fromObject(map);
	        String string = jsonObject.toString();
	        ExportCsv record=new ExportCsv();
	       record.setName(sd.format(new Date()));
	        record.setStatus(0);
	        record.setSqls(string);
	        record.setLogType(PZLX);
	        exportCsvMapper.insert(record);
	        map = new HashMap<>();
			map.put("code", 200);
			map.put("message", "成功");
		}else{
		List<DNSGKZBLogPo> ipgkzbList = dnsGKZBMapper.SelectAll(map);
		Integer num = dnsGKZBMapper.SelectCount(map);
		for (int i = 0; i < ipgkzbList.size(); i++) {
			Map<String, Object> resultMap = new HashMap<>();
			try {
				resultMap.put("bhsj", sdf.format(sdf.parse(ipgkzbList.get(i).getBhsj())));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			resultMap.put("labels", ipgkzbList.get(i).getLabel());
			resultMap.put("pzid", ipgkzbList.get(i).getPzid());
			resultMap.put("flid", ipgkzbList.get(i).getFlid());
			resultMap.put("xzid", ipgkzbList.get(i).getXzid());
			resultMap.put("lhid", TranslatingUtil.LHID(ipgkzbList.get(i).getLhid(), baseJklhMapper));
			resultMap.put("ydy", TranslatingUtil.YDY(ipgkzbList.get(i).getYdy(),areaCodeTMapper));
			resultMap.put("mddy", TranslatingUtil.MDDY(ipgkzbList.get(i).getMddy(),areaCodeTMapper));
			resultMap.put("pzlx", TranslatingUtil.PZLX(ipgkzbList.get(i).getPzlx()));
			resultMap.put("gklb", TranslatingUtil.GKLB(ipgkzbList.get(i).getGklb()));
			resultMap.put("qdjip", IPv4Util.longToIp(Long.parseLong(ipgkzbList.get(i).getQdjip() + "")));
			if(ipgkzbList.get(i).getYl1()==4) {
				resultMap.put("sip", IPv4Util.longToIp(Long.parseLong(ipgkzbList.get(i).getSip())));
				resultMap.put("dip", IPv4Util.longToIp(Long.parseLong(ipgkzbList.get(i).getDip())));
			}else if(ipgkzbList.get(i).getYl1()==6) {
				resultMap.put("sip", IPv4Util.longToIp(Long.parseLong(ipgkzbList.get(i).getSip())));
				resultMap.put("dip", IPv4Util.longToIp(Long.parseLong(ipgkzbList.get(i).getDip())));
			}else {
				resultMap.put("sip", IPv4Util.longToIp(Long.parseLong(ipgkzbList.get(i).getSip())));
				resultMap.put("dip", IPv4Util.longToIp(Long.parseLong(ipgkzbList.get(i).getDip())));
			}
			resultMap.put("sport", ipgkzbList.get(i).getSport());
			resultMap.put("dport", ipgkzbList.get(i).getDport());
			resultMap.put("protocol", TranslatingUtil.CSCXY(ipgkzbList.get(i).getProtocol()));
			resultMap.put("protoId", ipgkzbList.get(i).getProtoId());
			resultMap.put("detailId", TranslatingUtil.XXID(ipgkzbList.get(i).getDetailId()));
			resultMap.put("dnsName", ipgkzbList.get(i).getDnsName());
			resultMap.put("dnsValue", ipgkzbList.get(i).getDnsValue());
			resultMap.put("yys", TranslatingUtil.YYS(ipgkzbList.get(i).getYys()));
			resultMap.put("yl1", ipgkzbList.get(i).getYl1());
			resultMap.put("yl2", ipgkzbList.get(i).getYl2());
			resultMap.put("yl3", ipgkzbList.get(i).getYl3());
			resultMap.put("yl4", ipgkzbList.get(i).getYl4());
			resultMap.put("yl5", ipgkzbList.get(i).getYl5());
			resultList.add(resultMap);
		}
		map = new HashMap<>();
		map.put("data", resultList);
		map.put("pageSize", pageSize);
		map.put("pageNo", pageNo);
		map.put("totalPage", num / pageSize);
		map.put("totalCount", num);
		map.put("code", 200);
		}
		return map;
	}

	@Override
	public Map<String, Object> SSLGKqueryLogInfo(String startTime, String PZID, String label, String LHID, String YDY,
			String MDDY, Integer PZLX, String GKLB, String PROTOCOL, String SIP, String DIP, Integer SPORT, Integer DPORT,
			Integer pageNo, Integer pageSize, String logType, String endTime, String qdjip, String fwqmc, String syz,
			String zsmc, String bfz,String yys,int type,List<String> list) {
		Map<String, Object> map = new HashMap<>();
		ArrayList<Map<String, Object>> resultList = new ArrayList<>();
		if (StringUtils.isNotBlank(startTime)) {
			map.put("startTime", startTime);
		}
		if (StringUtils.isNotBlank(yys)) {
			map.put("YYS", yys);
		}
		if (StringUtils.isNotBlank(endTime)) {
			map.put("endTime", endTime);
		}
		if (StringUtils.isNotBlank(PZID)) {
			map.put("PZID", PZID);
		}
		if (StringUtils.isNotBlank(LHID)) {
			map.put("LHID", LHID);
		}
		if (StringUtils.isNotBlank(YDY)) {
			map.put("YDY", YDY.split(","));
		}
		if (StringUtils.isNotBlank(MDDY)) {
			map.put("MDDY", MDDY.split(","));
		}
		map.put("PZLX", PZLX);
		if (StringUtils.isNotBlank(GKLB)) {
			map.put("GKLB", GKLB);
		}
		if (StringUtils.isNotBlank(SIP)) {
			map.put("SIP", IPv4Util.ipToLong(SIP));
		}
		if (StringUtils.isNotBlank(DIP)) {
			map.put("DIP", IPv4Util.ipToLong(DIP));
		}
		if (StringUtils.isNotBlank(PROTOCOL)) {
			map.put("PROTOCOL", TranslatingUtil.PROTOCOL(PROTOCOL));
		}
		if (SPORT!=null&&SPORT >= 0) {
			map.put("SPORT", SPORT);
		}
		if (DPORT!=null&&DPORT >= 0) {
			map.put("DPORT", DPORT);
		}
		
		if (StringUtils.isNotBlank(label)) {
			if (StringUtils.isNotBlank(label)) {
				String[] string=new String[label.split(",").length];
				String[] lab=label.split(",");
				for(int i=0;i<lab.length;i++){
					string[i]=lab[i];
				}
				map.put("LABEL", lab);
			}
		}
		if (StringUtils.isNotBlank(qdjip)) {
			map.put("QDJIP", IPv4Util.ipToLong(qdjip));
		}
		if (StringUtils.isNotBlank(fwqmc)) {
			map.put("FWQMC", fwqmc);
		}
		if (StringUtils.isNotBlank(syz)) {
			map.put("SYZ", syz);
		}
		if (StringUtils.isNotBlank(zsmc)) {
			map.put("ZSMC", zsmc);
		}
		if (StringUtils.isNotBlank(bfz)) {
			map.put("BFZ", bfz);
		}
		
		map.put("start", (pageNo-1)*10);
		map.put("length", pageSize);
		if(list!=null&&list.size()>0) {
			map.put("QXDY", list);
		}
		if(type==1){
            JSONObject jsonObject=JSONObject.fromObject(map);
	        String string = jsonObject.toString();
	        ExportCsv record=new ExportCsv();
	       record.setName(sd.format(new Date()));
	        record.setStatus(0);
	        record.setSqls(string);
	        record.setLogType(PZLX);
	        exportCsvMapper.insert(record);
	        map = new HashMap<>();
			map.put("code", 200);
			map.put("message", "成功");
		}else{
		List<SSLGKZBLogPo> ipgkzbList = sslGKZBMapper.SelectAll(map);
		Integer num = sslGKZBMapper.SelectCount(map);
		for (int i = 0; i < ipgkzbList.size(); i++) {
			Map<String, Object> resultMap = new HashMap<>();
			try {
				resultMap.put("bhsj", sdf.format(sdf.parse(ipgkzbList.get(i).getBhsj())));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			resultMap.put("labels", ipgkzbList.get(i).getLabel());
			resultMap.put("pzid", ipgkzbList.get(i).getPzid());
			resultMap.put("flid", ipgkzbList.get(i).getFlid());
			resultMap.put("xzid", ipgkzbList.get(i).getXzid());
			resultMap.put("lhid", TranslatingUtil.LHID(ipgkzbList.get(i).getLhid(), baseJklhMapper));
			resultMap.put("ydy", TranslatingUtil.YDY(ipgkzbList.get(i).getYdy(),areaCodeTMapper));
			resultMap.put("mddy", TranslatingUtil.MDDY(ipgkzbList.get(i).getMddy(),areaCodeTMapper));
			resultMap.put("pzlx", TranslatingUtil.PZLX(ipgkzbList.get(i).getPzlx()));
			resultMap.put("gklb", TranslatingUtil.GKLB(ipgkzbList.get(i).getGklb()));
			resultMap.put("qdjip", IPv4Util.longToIp(Long.parseLong(ipgkzbList.get(i).getQdjip() + "")));
			if(ipgkzbList.get(i).getYl1()==4) {
				resultMap.put("sip", IPv4Util.longToIp(Long.parseLong(ipgkzbList.get(i).getSip())));
				resultMap.put("dip", IPv4Util.longToIp(Long.parseLong(ipgkzbList.get(i).getDip())));
			}else if(ipgkzbList.get(i).getYl1()==6) {
				resultMap.put("sip", IPv4Util.longToIp(Long.parseLong(ipgkzbList.get(i).getSip())));
				resultMap.put("dip", IPv4Util.longToIp(Long.parseLong(ipgkzbList.get(i).getDip())));
			}else {
				resultMap.put("sip", IPv4Util.longToIp(Long.parseLong(ipgkzbList.get(i).getSip())));
				resultMap.put("dip", IPv4Util.longToIp(Long.parseLong(ipgkzbList.get(i).getDip())));
			}
			resultMap.put("sport", ipgkzbList.get(i).getSport());
			resultMap.put("dport", ipgkzbList.get(i).getDport());
			resultMap.put("protocol", TranslatingUtil.CSCXY(ipgkzbList.get(i).getProtocol()));
			resultMap.put("protoId", ipgkzbList.get(i).getProtoId());
			resultMap.put("detailId", TranslatingUtil.XXID(ipgkzbList.get(i).getDetailId()));
			resultMap.put("zsmc", ipgkzbList.get(i).getZsmc());
			resultMap.put("bfz", ipgkzbList.get(i).getBfz());
			resultMap.put("syz", ipgkzbList.get(i).getSyz());
			resultMap.put("fwqmc", ipgkzbList.get(i).getFwqmc());
			resultMap.put("yys", TranslatingUtil.YYS(ipgkzbList.get(i).getYys()));
			resultMap.put("yl1", ipgkzbList.get(i).getYl1());
			resultMap.put("yl2", ipgkzbList.get(i).getYl2());
			resultMap.put("yl3", ipgkzbList.get(i).getYl3());
			resultMap.put("yl4", ipgkzbList.get(i).getYl4());
			resultMap.put("yl5", ipgkzbList.get(i).getYl5());
			resultList.add(resultMap);
		}
		map = new HashMap<>();
		map.put("data", resultList);
		map.put("pageSize", pageSize);
		map.put("pageNo", pageNo);
		map.put("totalPage", num / pageSize);
		map.put("totalCount", num);
		map.put("code", 200);
		}
		return map;
	}

	@Override
	public Map<String, Object> MAILGKqueryLogInfo(String startTime, String PZID, String label, String LHID, String YDY,
			String MDDY, Integer PZLX, String GKLB, String PROTOCOL, String SIP, String DIP, Integer SPORT, Integer DPORT,
			Integer pageNo, Integer pageSize, String logType, String endTime, String qdjip, String fileName, String receverNum,
			String mailRecever, String sjfws, String content, String mailSubject, String mailSender, String sjfwsSzd,
			String fjfwsSzd, String ccNum, String yyzl, String fjfws, String xylx, String gjz, String pwd,
			String accessory, String fileContent, String mailCc,String yys,int type,List<String> list) {
		Map<String, Object> map = new HashMap<>();
		ArrayList<Map<String, Object>> resultList = new ArrayList<>();
		if (StringUtils.isNotBlank(startTime)) {
			map.put("startTime", startTime);
		}
		if (StringUtils.isNotBlank(yys)) {
			map.put("YYS", yys);
		}
		if (StringUtils.isNotBlank(endTime)) {
			map.put("endTime", endTime);
		}
		if (StringUtils.isNotBlank(PZID)) {
			map.put("PZID", PZID);
		}
		if (StringUtils.isNotBlank(LHID)) {
			map.put("LHID", LHID);
		}
		if (StringUtils.isNotBlank(YDY)) {
			map.put("YDY", YDY.split(","));
		}
		if (StringUtils.isNotBlank(MDDY)) {
			map.put("MDDY", MDDY.split(","));
		}
		map.put("PZLX", PZLX);
		if (StringUtils.isNotBlank(GKLB)) {
			map.put("GKLB", GKLB);
		}
		if (StringUtils.isNotBlank(SIP)) {
			map.put("SIP", IPv4Util.ipToLong(SIP));
		}
		if (StringUtils.isNotBlank(DIP)) {
			map.put("DIP", IPv4Util.ipToLong(DIP));
		}
		if (StringUtils.isNotBlank(PROTOCOL)) {
			map.put("PROTOCOL", TranslatingUtil.PROTOCOL(PROTOCOL));
		}
		if (SPORT!=null&&SPORT >= 0) {
			map.put("SPORT", SPORT);
		}
		if (DPORT!=null&&DPORT >= 0) {
			map.put("DPORT", DPORT);
		}
		
		if (StringUtils.isNotBlank(label)) {
			if (StringUtils.isNotBlank(label)) {
				String[] string=new String[label.split(",").length];
				String[] lab=label.split(",");
				for(int i=0;i<lab.length;i++){
					string[i]=lab[i];
				}
				map.put("LABEL", lab);
			}
		}
		if (StringUtils.isNotBlank(qdjip)) {
			map.put("QDJIP", IPv4Util.ipToLong(qdjip));
		}
		if (StringUtils.isNotBlank(fileName)) {
			map.put("FILE_NAME", fileName);
		}
		if (StringUtils.isNotBlank(receverNum)) {
			map.put("RECEVER_NUM", receverNum);
		}
		if (StringUtils.isNotBlank(mailRecever)) {
			map.put("MAIL_RECEVER", mailRecever);
		}
		if (StringUtils.isNotBlank(sjfws)) {
			map.put("SJFWS", sjfws);
		}
		if (StringUtils.isNotBlank(content)) {
			map.put("CONTENT", content);
		}
		if (StringUtils.isNotBlank(mailSubject)) {
			map.put("MAIL_SUBJECT", mailSubject);
		}
		if (StringUtils.isNotBlank(mailSender)) {
			map.put("MAIL_SENDER", mailSender);
		}
		if (StringUtils.isNotBlank(sjfwsSzd)) {
			map.put("SJFWS_SZD", sjfwsSzd);
		}
		if (StringUtils.isNotBlank(fjfwsSzd)) {
			map.put("FJFWS_SZD", fjfwsSzd);
		}
		if (StringUtils.isNotBlank(ccNum)) {
			map.put("CC_NUM", ccNum);
		}
		if (StringUtils.isNotBlank(yyzl)) {
			map.put("YYZL", yyzl);
		}
		if (StringUtils.isNotBlank(fjfws)) {
			map.put("FJFWS", fjfws);
		}
		if (StringUtils.isNotBlank(xylx)) {
			map.put("XYLX", xylx);
		}
		if (StringUtils.isNotBlank(gjz)) {
			map.put("GJZ", gjz);
		}
		if (StringUtils.isNotBlank(pwd)) {
			map.put("PWD", pwd);
		}
		if (StringUtils.isNotBlank(accessory)) {
			map.put("ACCESSORY", accessory);
		}
		if (StringUtils.isNotBlank(fileContent)) {
			map.put("FILE_CONTENT", fileContent);
		}
		if (StringUtils.isNotBlank(mailCc)) {
			map.put("MAIL_CC", mailCc);
		}
		
		map.put("start", (pageNo-1)*10);
		map.put("length", pageSize);
		if(list!=null&&list.size()>0) {
			map.put("QXDY", list);
		}
		if(type==1){
            JSONObject jsonObject=JSONObject.fromObject(map);
	        String string = jsonObject.toString();
	        ExportCsv record=new ExportCsv();
	       record.setName(sd.format(new Date()));
	        record.setStatus(0);
	        record.setSqls(string);
	        record.setLogType(PZLX);
	        exportCsvMapper.insert(record);
	        map = new HashMap<>();
			map.put("code", 200);
			map.put("message", "成功");
		}else{
		List<MAILGKZBLogPo> ipgkzbList = mailGKZBMapper.SelectAll(map);
		Integer num = mailGKZBMapper.SelectCount(map);
		for (int i = 0; i < ipgkzbList.size(); i++) {
			Map<String, Object> resultMap = new HashMap<>();
			try {
				resultMap.put("bhsj", sdf.format(sdf.parse(ipgkzbList.get(i).getBhsj())));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			resultMap.put("labels", ipgkzbList.get(i).getLabel());
			resultMap.put("pzid", ipgkzbList.get(i).getPzid());
			resultMap.put("flid", ipgkzbList.get(i).getFlid());
			resultMap.put("xzid", ipgkzbList.get(i).getXzid());
			resultMap.put("lhid", TranslatingUtil.LHID(ipgkzbList.get(i).getLhid(), baseJklhMapper));
			resultMap.put("ydy", TranslatingUtil.YDY(ipgkzbList.get(i).getYdy(),areaCodeTMapper));
			resultMap.put("mddy", TranslatingUtil.MDDY(ipgkzbList.get(i).getMddy(),areaCodeTMapper));
			resultMap.put("pzlx", TranslatingUtil.PZLX(ipgkzbList.get(i).getPzlx()));
			resultMap.put("gklb", TranslatingUtil.GKLB(ipgkzbList.get(i).getGklb()));
			if (ipgkzbList.get(i).getYyzl() != null) {
				resultMap.put("yyzl", TranslatingUtil.YYZL(ipgkzbList.get(i).getYyzl()));
			} else {
				resultMap.put("yyzl", "");
			}
			resultMap.put("qdjip", IPv4Util.longToIp(Long.parseLong(ipgkzbList.get(i).getQdjip() + "")));
			if(ipgkzbList.get(i).getYl1()==4) {
				resultMap.put("sip", IPv4Util.longToIp(Long.parseLong(ipgkzbList.get(i).getSip())));
				resultMap.put("dip", IPv4Util.longToIp(Long.parseLong(ipgkzbList.get(i).getDip())));
			}else if(ipgkzbList.get(i).getYl1()==6) {
				resultMap.put("sip", IPv4Util.longToIp(Long.parseLong(ipgkzbList.get(i).getSip())));
				resultMap.put("dip", IPv4Util.longToIp(Long.parseLong(ipgkzbList.get(i).getDip())));
			}else {
				resultMap.put("sip", IPv4Util.longToIp(Long.parseLong(ipgkzbList.get(i).getSip())));
				resultMap.put("dip", IPv4Util.longToIp(Long.parseLong(ipgkzbList.get(i).getDip())));
			}
			resultMap.put("sport", ipgkzbList.get(i).getSport());
			resultMap.put("dport", ipgkzbList.get(i).getDport());
			resultMap.put("protocol", TranslatingUtil.CSCXY(ipgkzbList.get(i).getProtocol()));
			resultMap.put("protoId", ipgkzbList.get(i).getProtoId());
			resultMap.put("detailId", TranslatingUtil.XXID(ipgkzbList.get(i).getDetailId()));
			resultMap.put("mailSender", ipgkzbList.get(i).getMailSender());
			resultMap.put("receverNum", ipgkzbList.get(i).getReceverNum());
			resultMap.put("ccNum", ipgkzbList.get(i).getCcNum());
			resultMap.put("mailSubject", ipgkzbList.get(i).getMailSubject());
			resultMap.put("accessory", ipgkzbList.get(i).getAccessory());
			resultMap.put("fileName", ipgkzbList.get(i).getFileName());
			resultMap.put("fileContent", ipgkzbList.get(i).getFileContent());
			resultMap.put("pwd", ipgkzbList.get(i).getPwd());
			resultMap.put("fjfws", ipgkzbList.get(i).getFjfws());
			resultMap.put("fjfwsSzd", ipgkzbList.get(i).getFjfwsSzd());
			resultMap.put("sjfws", ipgkzbList.get(i).getSjfws());
			resultMap.put("sjfwsSzd", ipgkzbList.get(i).getSjfwsSzd());
			resultMap.put("xylx", ipgkzbList.get(i).getXylx());
			resultMap.put("gjz", ipgkzbList.get(i).getGjz());

			resultMap.put("yys", TranslatingUtil.YYS(ipgkzbList.get(i).getYys()));
			resultMap.put("yl1", ipgkzbList.get(i).getYl1());
			resultMap.put("yl2", ipgkzbList.get(i).getYl2());
			resultMap.put("yl3", ipgkzbList.get(i).getYl3());
			resultMap.put("yl4", ipgkzbList.get(i).getYl4());
			resultMap.put("yl5", ipgkzbList.get(i).getYl5());
			resultMap.put("mailRecever", ipgkzbList.get(i).getMailRecever());
			resultMap.put("mailCc", ipgkzbList.get(i).getMailCc());
			resultMap.put("content", ipgkzbList.get(i).getContent());
			resultList.add(resultMap);
		}
		map = new HashMap<>();
		map.put("data", resultList);
		map.put("pageSize", pageSize);
		map.put("pageNo", pageNo);
		map.put("totalPage", num / pageSize);
		map.put("totalCount", num);
		map.put("code", 200);
		}
		return map;
	}

	@Override
	public Map<String, Object> JSTXGKqueryLogInfo(String startTime, String PZID, String label, String LHID, String YDY,
			String MDDY, Integer PZLX, String GKLB, String PROTOCOL, String SIP, String DIP, Integer SPORT, Integer DPORT,
			Integer pageNo, Integer pageSize, String logType, String endTime, String qdjip, String content, String host,
			String yyzl, String userAgent, String userId, String url, String reserved, String dzId,String yys,int type,List<String> list) {
		Map<String, Object> map = new HashMap<>();
		ArrayList<Map<String, Object>> resultList = new ArrayList<>();
		if (StringUtils.isNotBlank(startTime)) {
			map.put("startTime", startTime);
		}
		if (StringUtils.isNotBlank(yys)) {
			map.put("YYS", yys);
		}
		if (StringUtils.isNotBlank(endTime)) {
			map.put("endTime", endTime);
		}
		if (StringUtils.isNotBlank(PZID)) {
			map.put("PZID", PZID);
		}
		if (StringUtils.isNotBlank(LHID)) {
			map.put("LHID", LHID);
		}
		if (StringUtils.isNotBlank(YDY)) {
			map.put("YDY", YDY.split(","));
		}
		if (StringUtils.isNotBlank(MDDY)) {
			map.put("MDDY", MDDY.split(","));
		}
		map.put("PZLX", PZLX);
		if (StringUtils.isNotBlank(GKLB)) {
			map.put("GKLB", GKLB);
		}
		if (StringUtils.isNotBlank(SIP)) {
			map.put("SIP", IPv4Util.ipToLong(SIP));
		}
		if (StringUtils.isNotBlank(DIP)) {
			map.put("DIP", IPv4Util.ipToLong(DIP));
		}
		if (StringUtils.isNotBlank(PROTOCOL)) {
			map.put("PROTOCOL", TranslatingUtil.PROTOCOL(PROTOCOL));
		}
		if (SPORT!=null&&SPORT >= 0) {
			map.put("SPORT", SPORT);
		}
		if (DPORT!=null&&DPORT >= 0) {
			map.put("DPORT", DPORT);
		}
		if (StringUtils.isNotBlank(label)) {
			if (StringUtils.isNotBlank(label)) {
				String[] string=new String[label.split(",").length];
				String[] lab=label.split(",");
				for(int i=0;i<lab.length;i++){
					string[i]=lab[i];
				}
				map.put("LABEL", lab);
			}
		}
		if (StringUtils.isNotBlank(qdjip)) {
			map.put("QDJIP", IPv4Util.ipToLong(qdjip));
		}
		if (StringUtils.isNotBlank(content)) {
			map.put("CONTENT", content);
		}
		if (StringUtils.isNotBlank(host)) {
			map.put("HOST", host);
		}
		if (StringUtils.isNotBlank(yyzl)) {
			map.put("YYZL", yyzl);
		}
		if (StringUtils.isNotBlank(userAgent)) {
			map.put("USER_AGENT", userAgent);
		}
		if (StringUtils.isNotBlank(userId)) {
			map.put("USER_ID", userId);
		}
		if (StringUtils.isNotBlank(url)) {
			map.put("URL", url);
		}
		if (StringUtils.isNotBlank(reserved)) {
			map.put("RESERVED", reserved);
		}
		if (StringUtils.isNotBlank(dzId)) {
			map.put("DZ_ID", dzId);
		}
		
		map.put("start", (pageNo-1)*10);
		map.put("length", pageSize);
		if(list!=null&&list.size()>0) {
			map.put("QXDY", list);
		}
		if(type==1){
            JSONObject jsonObject=JSONObject.fromObject(map);
	        String string = jsonObject.toString();
	        ExportCsv record=new ExportCsv();
	       record.setName(sd.format(new Date()));
	        record.setStatus(0);
	        record.setSqls(string);
	        record.setLogType(PZLX);
	        exportCsvMapper.insert(record);
	        map = new HashMap<>();
			map.put("code", 200);
			map.put("message", "成功");
		}else{
		List<JSTXGKZBLogPo> ipgkzbList = jstxGKZBMapper.SelectAll(map);
		Integer num = jstxGKZBMapper.SelectCount(map);
		for (int i = 0; i < ipgkzbList.size(); i++) {
			Map<String, Object> resultMap = new HashMap<>();
			try {
				resultMap.put("bhsj", sdf.format(sdf.parse(ipgkzbList.get(i).getBhsj())));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			resultMap.put("labels", ipgkzbList.get(i).getLabel());
			resultMap.put("pzid", ipgkzbList.get(i).getPzid());
			resultMap.put("flid", ipgkzbList.get(i).getFlid());
			resultMap.put("xzid", ipgkzbList.get(i).getXzid());
			resultMap.put("lhid", TranslatingUtil.LHID(ipgkzbList.get(i).getLhid(), baseJklhMapper));
			resultMap.put("ydy", TranslatingUtil.YDY(ipgkzbList.get(i).getYdy(),areaCodeTMapper));
			resultMap.put("mddy", TranslatingUtil.MDDY(ipgkzbList.get(i).getMddy(),areaCodeTMapper));
			resultMap.put("pzlx", TranslatingUtil.PZLX(ipgkzbList.get(i).getPzlx()));
			resultMap.put("gklb", TranslatingUtil.GKLB(ipgkzbList.get(i).getGklb()));
			if (ipgkzbList.get(i).getYyzl() != null) {
				resultMap.put("yyzl", TranslatingUtil.YYZL(ipgkzbList.get(i).getYyzl()));
			} else {
				resultMap.put("yyzl", "");
			}
			resultMap.put("qdjip", IPv4Util.longToIp(Long.parseLong(ipgkzbList.get(i).getQdjip() + "")));
			if(ipgkzbList.get(i).getYl1()==4) {
				resultMap.put("sip", IPv4Util.longToIp(Long.parseLong(ipgkzbList.get(i).getSip())));
				resultMap.put("dip", IPv4Util.longToIp(Long.parseLong(ipgkzbList.get(i).getDip())));
			}else if(ipgkzbList.get(i).getYl1()==6) {
				resultMap.put("sip", IPv4Util.longToIp(Long.parseLong(ipgkzbList.get(i).getSip())));
				resultMap.put("dip", IPv4Util.longToIp(Long.parseLong(ipgkzbList.get(i).getDip())));
			}else {
				resultMap.put("sip", IPv4Util.longToIp(Long.parseLong(ipgkzbList.get(i).getSip())));
				resultMap.put("dip", IPv4Util.longToIp(Long.parseLong(ipgkzbList.get(i).getDip())));
			}
			resultMap.put("sport", ipgkzbList.get(i).getSport());
			resultMap.put("dport", ipgkzbList.get(i).getDport());
			resultMap.put("protocol", TranslatingUtil.CSCXY(ipgkzbList.get(i).getProtocol()));
			resultMap.put("protoId", ipgkzbList.get(i).getProtoId());
			resultMap.put("detailId", TranslatingUtil.XXID(ipgkzbList.get(i).getDetailId()));
			resultMap.put("dzId", ipgkzbList.get(i).getDzId());
			resultMap.put("host", ipgkzbList.get(i).getHost());
			resultMap.put("userAgent", ipgkzbList.get(i).getUserAgent());
			resultMap.put("userId", ipgkzbList.get(i).getUserId());
			resultMap.put("reserved", ipgkzbList.get(i).getReserved());
			resultMap.put("yys", TranslatingUtil.YYS(ipgkzbList.get(i).getYys()));
			resultMap.put("yl1", ipgkzbList.get(i).getYl1());
			resultMap.put("yl2", ipgkzbList.get(i).getYl2());
			resultMap.put("yl3", ipgkzbList.get(i).getYl3());
			resultMap.put("yl4", ipgkzbList.get(i).getYl4());
			resultMap.put("yl5", ipgkzbList.get(i).getYl5());
			resultMap.put("url", ipgkzbList.get(i).getUrl());
			resultMap.put("content", ipgkzbList.get(i).getContent());
			resultList.add(resultMap);
		}
		map = new HashMap<>();
		map.put("data", resultList);
		map.put("pageSize", pageSize);
		map.put("pageNo", pageNo);
		map.put("totalPage", num / pageSize);
		map.put("totalCount", num);
		map.put("code", 200);
		}
		return map;
	}

	@Override
	public Map<String, Object> VPNGKqueryLogInfo(String startTime, String PZID, String label, String LHID, String YDY,
			String MDDY, Integer PZLX, String GKLB, String PROTOCOL, String SIP, String DIP, Integer SPORT, Integer DPORT,
			Integer pageNo, Integer pageSize, String logType, String endTime, String qdjip, String url, String pwd,
			String username,String yys,int type,List<String> list) {
		Map<String, Object> map = new HashMap<>();
		ArrayList<Map<String, Object>> resultList = new ArrayList<>();
		if (StringUtils.isNotBlank(startTime)) {
			map.put("startTime", startTime);
		}
		if (StringUtils.isNotBlank(yys)) {
			map.put("YYS", yys);
		}
		if (StringUtils.isNotBlank(endTime)) {
			map.put("endTime", endTime);
		}
		if (StringUtils.isNotBlank(PZID)) {
			map.put("PZID", PZID);
		}
		if (StringUtils.isNotBlank(LHID)) {
			map.put("LHID", LHID);
		}
		if (StringUtils.isNotBlank(YDY)) {
			map.put("YDY", YDY.split(","));
		}
		if (StringUtils.isNotBlank(MDDY)) {
			map.put("MDDY", MDDY.split(","));
		}
		map.put("PZLX", PZLX);
		if (StringUtils.isNotBlank(GKLB)) {
			map.put("GKLB", GKLB);
		}
		if (StringUtils.isNotBlank(SIP)) {
			map.put("SIP", IPv4Util.ipToLong(SIP));
		}
		if (StringUtils.isNotBlank(DIP)) {
			map.put("DIP", IPv4Util.ipToLong(DIP));
		}
		if (StringUtils.isNotBlank(PROTOCOL)) {
			map.put("PROTOCOL", TranslatingUtil.PROTOCOL(PROTOCOL));
		}
		if (SPORT!=null&&SPORT >= 0) {
			map.put("SPORT", SPORT);
		}
		if (DPORT!=null&&DPORT >= 0) {
			map.put("DPORT", DPORT);
		}
		
		if (StringUtils.isNotBlank(label)) {
			if (StringUtils.isNotBlank(label)) {
				String[] string=new String[label.split(",").length];
				String[] lab=label.split(",");
				for(int i=0;i<lab.length;i++){
					string[i]=lab[i];
				}
				map.put("LABEL", lab);
			}
		}
		if (StringUtils.isNotBlank(qdjip)) {
			map.put("QDJIP", IPv4Util.ipToLong(qdjip));
		}
		if (StringUtils.isNotBlank(url)) {
			map.put("URL", url);
		}
		if (StringUtils.isNotBlank(pwd)) {
			map.put("PWD", pwd);
		}
		if (StringUtils.isNotBlank(username)) {
			map.put("USERNAME", username);
		}
		
		map.put("start", (pageNo-1)*10);
		map.put("length", pageSize);
		if(list!=null&&list.size()>0) {
			map.put("QXDY", list);
		}
		if(type==1){
            JSONObject jsonObject=JSONObject.fromObject(map);
	        String string = jsonObject.toString();
	        ExportCsv record=new ExportCsv();
	       record.setName(sd.format(new Date()));
	        record.setStatus(0);
	        record.setSqls(string);
	        record.setLogType(PZLX);
	        exportCsvMapper.insert(record);
	        map = new HashMap<>();
			map.put("code", 200);
			map.put("message", "成功");
		}else{
		List<VPNGKZBLogPo> ipgkzbList = vpnGKZBMapper.SelectAll(map);
		Integer num = vpnGKZBMapper.SelectCount(map);
		for (int i = 0; i < ipgkzbList.size(); i++) {
			Map<String, Object> resultMap = new HashMap<>();
			try {
				resultMap.put("bhsj", sdf.format(sdf.parse(ipgkzbList.get(i).getBhsj())));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			resultMap.put("labels", ipgkzbList.get(i).getLabel());
			resultMap.put("pzid", ipgkzbList.get(i).getPzid());
			resultMap.put("flid", ipgkzbList.get(i).getFlid());
			resultMap.put("xzid", ipgkzbList.get(i).getXzid());
			resultMap.put("lhid", TranslatingUtil.LHID(ipgkzbList.get(i).getLhid(), baseJklhMapper));
			resultMap.put("ydy", TranslatingUtil.YDY(ipgkzbList.get(i).getYdy(),areaCodeTMapper));
			resultMap.put("mddy", TranslatingUtil.MDDY(ipgkzbList.get(i).getMddy(),areaCodeTMapper));
			resultMap.put("pzlx", TranslatingUtil.PZLX(ipgkzbList.get(i).getPzlx()));
			resultMap.put("gklb", TranslatingUtil.GKLB(ipgkzbList.get(i).getGklb()));
			resultMap.put("qdjip", IPv4Util.longToIp(Long.parseLong(ipgkzbList.get(i).getQdjip() + "")));
			if(ipgkzbList.get(i).getYl1()==4) {
				resultMap.put("sip", IPv4Util.longToIp(Long.parseLong(ipgkzbList.get(i).getSip())));
				resultMap.put("dip", IPv4Util.longToIp(Long.parseLong(ipgkzbList.get(i).getDip())));
			}else if(ipgkzbList.get(i).getYl1()==6) {
				resultMap.put("sip", IPv4Util.longToIp(Long.parseLong(ipgkzbList.get(i).getSip())));
				resultMap.put("dip", IPv4Util.longToIp(Long.parseLong(ipgkzbList.get(i).getDip())));
			}else {
				resultMap.put("sip", IPv4Util.longToIp(Long.parseLong(ipgkzbList.get(i).getSip())));
				resultMap.put("dip", IPv4Util.longToIp(Long.parseLong(ipgkzbList.get(i).getDip())));
			}
			resultMap.put("sport", ipgkzbList.get(i).getSport());
			resultMap.put("dport", ipgkzbList.get(i).getDport());
			resultMap.put("protocol", TranslatingUtil.CSCXY(ipgkzbList.get(i).getProtocol()));
			resultMap.put("protoId", ipgkzbList.get(i).getProtoId());
			resultMap.put("detailId", TranslatingUtil.XXID(ipgkzbList.get(i).getDetailId()));
			resultMap.put("username", ipgkzbList.get(i).getUsername());
			resultMap.put("pwd", ipgkzbList.get(i).getPwd());
			resultMap.put("yys", TranslatingUtil.YYS(ipgkzbList.get(i).getYys()));
			resultMap.put("yl1", ipgkzbList.get(i).getYl1());
			resultMap.put("yl2", ipgkzbList.get(i).getYl2());
			resultMap.put("yl3", ipgkzbList.get(i).getYl3());
			resultMap.put("yl4", ipgkzbList.get(i).getYl4());
			resultMap.put("yl5", ipgkzbList.get(i).getYl5());
			resultMap.put("url", ipgkzbList.get(i).getUrl());
			resultList.add(resultMap);
		}
		map = new HashMap<>();
		map.put("data", resultList);
		map.put("pageSize", pageSize);
		map.put("pageNo", pageNo);
		map.put("totalPage", num / pageSize);
		map.put("totalCount", num);
		map.put("code", 200);
		}
		return map;
	}

	@Override
	public Map<String, Object> WYGJCGKqueryLogInfo(String startTime, String PZID, String label, String LHID, String YDY,
			String MDDY, Integer PZLX, String GKLB, String PROTOCOL, String SIP, String DIP, Integer SPORT, Integer DPORT,
			Integer pageNo, Integer pageSize, String logType, String endTime, String qdjip, String ssyq, String content,
			String yyzl, String jcUrl, String gjz,String yys,int type,List<String> list) {
		Map<String, Object> map = new HashMap<>();
		ArrayList<Map<String, Object>> resultList = new ArrayList<>();
		if (StringUtils.isNotBlank(startTime)) {
			map.put("startTime", startTime);
		}
		if (StringUtils.isNotBlank(yys)) {
			map.put("YYS", yys);
		}
		if (StringUtils.isNotBlank(endTime)) {
			map.put("endTime", endTime);
		}
		if (StringUtils.isNotBlank(PZID)) {
			map.put("PZID", PZID);
		}
		if (StringUtils.isNotBlank(LHID)) {
			map.put("LHID", LHID);
		}
		if (StringUtils.isNotBlank(YDY)) {
			map.put("YDY", YDY.split(","));
		}
		if (StringUtils.isNotBlank(MDDY)) {
			map.put("MDDY", MDDY.split(","));
		}
		map.put("PZLX", PZLX);
		if (StringUtils.isNotBlank(GKLB)) {
			map.put("GKLB", GKLB);
		}
		if (StringUtils.isNotBlank(SIP)) {
			map.put("SIP", IPv4Util.ipToLong(SIP));
		}
		if (StringUtils.isNotBlank(DIP)) {
			map.put("DIP", IPv4Util.ipToLong(DIP));
		}
		if (StringUtils.isNotBlank(PROTOCOL)) {
			map.put("PROTOCOL", TranslatingUtil.PROTOCOL(PROTOCOL));
		}
		if (SPORT!=null&&SPORT >= 0) {
			map.put("SPORT", SPORT);
		}
		if (DPORT!=null&&DPORT >= 0) {
			map.put("DPORT", DPORT);
		}
		
		if (StringUtils.isNotBlank(label)) {
			if (StringUtils.isNotBlank(label)) {
				String[] string=new String[label.split(",").length];
				String[] lab=label.split(",");
				for(int i=0;i<lab.length;i++){
					string[i]=lab[i];
				}
				map.put("LABEL", lab);
			}
		}
		if (StringUtils.isNotBlank(qdjip)) {
			map.put("QDJIP", IPv4Util.ipToLong(qdjip));
		}
		if (StringUtils.isNotBlank(ssyq)) {
			map.put("SSYQ", ssyq);
		}
		if (StringUtils.isNotBlank(content)) {
			map.put("CONTENT", content);
		}
		if (StringUtils.isNotBlank(yyzl)) {
			map.put("YYZL", yyzl);
		}
		if (StringUtils.isNotBlank(jcUrl)) {
			map.put("JC_URL", jcUrl);
		}
		if (StringUtils.isNotBlank(gjz)) {
			map.put("GJZ", gjz);
		}
		
		map.put("start", (pageNo-1)*10);
		map.put("length", pageSize);
		if(list!=null&&list.size()>0) {
			map.put("QXDY", list);
		}
		if(type==1){
            JSONObject jsonObject=JSONObject.fromObject(map);
	        String string = jsonObject.toString();
	        ExportCsv record=new ExportCsv();
	       record.setName(sd.format(new Date()));
	        record.setStatus(0);
	        record.setSqls(string);
	        record.setLogType(PZLX);
	        exportCsvMapper.insert(record);
	        map = new HashMap<>();
			map.put("code", 200);
			map.put("message", "成功");
		}else{
		List<WYGJCGKRZLogPo> ipgkzbList = wygjGKZBMapper.SelectAll(map);
		Integer num = wygjGKZBMapper.SelectCount(map);
		for (int i = 0; i < ipgkzbList.size(); i++) {
			Map<String, Object> resultMap = new HashMap<>();
			try {
				resultMap.put("bhsj", sdf.format(sdf.parse(ipgkzbList.get(i).getBhsj())));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			resultMap.put("labels", ipgkzbList.get(i).getLabel());
			resultMap.put("pzid", ipgkzbList.get(i).getPzid());
			resultMap.put("flid", ipgkzbList.get(i).getFlid());
			resultMap.put("xzid", ipgkzbList.get(i).getXzid());
			resultMap.put("lhid", TranslatingUtil.LHID(ipgkzbList.get(i).getLhid(), baseJklhMapper));
			resultMap.put("ydy", TranslatingUtil.YDY(ipgkzbList.get(i).getYdy(),areaCodeTMapper));
			resultMap.put("mddy", TranslatingUtil.MDDY(ipgkzbList.get(i).getMddy(),areaCodeTMapper));
			resultMap.put("pzlx", TranslatingUtil.PZLX(ipgkzbList.get(i).getPzlx()));
			resultMap.put("gklb", TranslatingUtil.GKLB(ipgkzbList.get(i).getGklb()));
			if (ipgkzbList.get(i).getYyzl() != null) {
				resultMap.put("yyzl", TranslatingUtil.YYZL(ipgkzbList.get(i).getYyzl()));
			} else {
				resultMap.put("yyzl", "");
			}
			resultMap.put("qdjip", IPv4Util.longToIp(Long.parseLong(ipgkzbList.get(i).getQdjip() + "")));
			if(ipgkzbList.get(i).getYl1()==4) {
				resultMap.put("sip", IPv4Util.longToIp(Long.parseLong(ipgkzbList.get(i).getSip())));
				resultMap.put("dip", IPv4Util.longToIp(Long.parseLong(ipgkzbList.get(i).getDip())));
			}else if(ipgkzbList.get(i).getYl1()==6) {
				resultMap.put("sip", IPv4Util.longToIp(Long.parseLong(ipgkzbList.get(i).getSip())));
				resultMap.put("dip", IPv4Util.longToIp(Long.parseLong(ipgkzbList.get(i).getDip())));
			}else {
				resultMap.put("sip", IPv4Util.longToIp(Long.parseLong(ipgkzbList.get(i).getSip())));
				resultMap.put("dip", IPv4Util.longToIp(Long.parseLong(ipgkzbList.get(i).getDip())));
			}
			resultMap.put("sport", ipgkzbList.get(i).getSport());
			resultMap.put("dport", ipgkzbList.get(i).getDport());
			resultMap.put("protocol", TranslatingUtil.CSCXY(ipgkzbList.get(i).getProtocol()));
			resultMap.put("protoId", ipgkzbList.get(i).getProtoId());
			resultMap.put("detailId", TranslatingUtil.XXID(ipgkzbList.get(i).getDetailId()));
			resultMap.put("ssyq", ipgkzbList.get(i).getSsyq());
			resultMap.put("gjz", ipgkzbList.get(i).getGjz());
			resultMap.put("yys", TranslatingUtil.YYS(ipgkzbList.get(i).getYys()));
			resultMap.put("yl1", ipgkzbList.get(i).getYl1());
			resultMap.put("yl2", ipgkzbList.get(i).getYl2());
			resultMap.put("yl3", ipgkzbList.get(i).getYl3());
			resultMap.put("yl4", ipgkzbList.get(i).getYl4());
			resultMap.put("yl5", ipgkzbList.get(i).getYl5());
			resultMap.put("jcUrl", ipgkzbList.get(i).getJcUrl());
			resultMap.put("content", ipgkzbList.get(i).getContent());
			resultList.add(resultMap);
		}
		map = new HashMap<>();
		map.put("data", resultList);
		map.put("pageSize", pageSize);
		map.put("pageNo", pageNo);
		map.put("totalPage", num / pageSize);
		map.put("totalCount", num);
		map.put("code", 200);
		}
		return map;
	}

	@Override
	public Map<String, Object> FTPGJCGKqueryLogInfo(String startTime, String PZID, String label, String LHID,
			String YDY, String MDDY, Integer PZLX, String GKLB, String PROTOCOL, String SIP, String DIP, Integer SPORT,
			Integer DPORT, Integer pageNo, Integer pageSize, String logType, String endTime, String qdjip, String fileName,
			String yyzl, String gjz, String fileContent,String yys,int type,List<String> list) {
		Map<String, Object> map = new HashMap<>();
		ArrayList<Map<String, Object>> resultList = new ArrayList<>();
		if (StringUtils.isNotBlank(startTime)) {
			map.put("startTime", startTime);
		}
		if (StringUtils.isNotBlank(yys)) {
			map.put("YYS", yys);
		}
		if (StringUtils.isNotBlank(endTime)) {
			map.put("endTime", endTime);
		}
		if (StringUtils.isNotBlank(PZID)) {
			map.put("PZID", PZID);
		}
		if (StringUtils.isNotBlank(LHID)) {
			map.put("LHID", LHID);
		}
		if (StringUtils.isNotBlank(YDY)) {
			map.put("YDY", YDY.split(","));
		}
		if (StringUtils.isNotBlank(MDDY)) {
			map.put("MDDY", MDDY.split(","));
		}
		map.put("PZLX", PZLX);
		if (StringUtils.isNotBlank(GKLB)) {
			map.put("GKLB", GKLB);
		}
		if (StringUtils.isNotBlank(SIP)) {
			map.put("SIP", IPv4Util.ipToLong(SIP));
		}
		if (StringUtils.isNotBlank(DIP)) {
			map.put("DIP", IPv4Util.ipToLong(DIP));
		}
		if (StringUtils.isNotBlank(PROTOCOL)) {
			map.put("PROTOCOL", TranslatingUtil.PROTOCOL(PROTOCOL));
		}
		if (SPORT!=null&&SPORT >= 0) {
			map.put("SPORT", SPORT);
		}
		if (DPORT!=null&&DPORT >= 0) {
			map.put("DPORT", DPORT);
		}
		
		if (StringUtils.isNotBlank(label)) {
			map.put("LABEL", label.split(","));
		}
		if (StringUtils.isNotBlank(qdjip)) {
			map.put("QDJIP", IPv4Util.ipToLong(qdjip));
		}
		if (StringUtils.isNotBlank(fileName)) {
			map.put("FILE_NAME", fileName);
		}
		if (StringUtils.isNotBlank(yyzl)) {
			map.put("YYZL", yyzl);
		}
		if (StringUtils.isNotBlank(gjz)) {
			map.put("GJZ", gjz);
		}
		if (StringUtils.isNotBlank(fileContent)) {
			map.put("FILE_CONTENT", fileContent);
		}
		
		map.put("start", (pageNo-1)*10);
		map.put("length", pageSize);
		if(list!=null&&list.size()>0) {
			map.put("QXDY", list);
		}
		if(type==1){
            JSONObject jsonObject=JSONObject.fromObject(map);
	        String string = jsonObject.toString();
	        ExportCsv record=new ExportCsv();
	       record.setName(sd.format(new Date()));
	        record.setStatus(0);
	        record.setSqls(string);
	        record.setLogType(PZLX);
	        exportCsvMapper.insert(record);
	        map = new HashMap<>();
			map.put("code", 200);
			map.put("message", "成功");
		}else{
		List<FTPGKZBLogPo> ipgkzbList = ftpGKZBMapper.SelectAll(map);
		Integer num = ftpGKZBMapper.SelectCount(map);
		for (int i = 0; i < ipgkzbList.size(); i++) {
			Map<String, Object> resultMap = new HashMap<>();
			try {
				resultMap.put("bhsj", sdf.format(sdf.parse(ipgkzbList.get(i).getBhsj())));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			resultMap.put("labels", ipgkzbList.get(i).getLabel());
			resultMap.put("pzid", ipgkzbList.get(i).getPzid());
			resultMap.put("flid", ipgkzbList.get(i).getFlid());
			resultMap.put("xzid", ipgkzbList.get(i).getXzid());
			resultMap.put("lhid", TranslatingUtil.LHID(ipgkzbList.get(i).getLhid(), baseJklhMapper));
			resultMap.put("ydy", TranslatingUtil.YDY(ipgkzbList.get(i).getYdy(),areaCodeTMapper));
			resultMap.put("mddy", TranslatingUtil.MDDY(ipgkzbList.get(i).getMddy(),areaCodeTMapper));
			resultMap.put("pzlx", TranslatingUtil.PZLX(ipgkzbList.get(i).getPzlx()));
			resultMap.put("gklb", TranslatingUtil.GKLB(ipgkzbList.get(i).getGklb()));
			if (ipgkzbList.get(i).getYyzl() != null) {
				resultMap.put("yyzl", TranslatingUtil.YYZL(ipgkzbList.get(i).getYyzl()));
			} else {
				resultMap.put("yyzl", "");
			}
			resultMap.put("qdjip", IPv4Util.longToIp(Long.parseLong(ipgkzbList.get(i).getQdjip() + "")));
			if(ipgkzbList.get(i).getYl1()==4) {
				resultMap.put("sip", IPv4Util.longToIp(Long.parseLong(ipgkzbList.get(i).getSip())));
				resultMap.put("dip", IPv4Util.longToIp(Long.parseLong(ipgkzbList.get(i).getDip())));
			}else if(ipgkzbList.get(i).getYl1()==6) {
				resultMap.put("sip", IPv4Util.longToIp(Long.parseLong(ipgkzbList.get(i).getSip())));
				resultMap.put("dip", IPv4Util.longToIp(Long.parseLong(ipgkzbList.get(i).getDip())));
			}else {
				resultMap.put("sip", IPv4Util.longToIp(Long.parseLong(ipgkzbList.get(i).getSip())));
				resultMap.put("dip", IPv4Util.longToIp(Long.parseLong(ipgkzbList.get(i).getDip())));
			}
			resultMap.put("sport", ipgkzbList.get(i).getSport());
			resultMap.put("dport", ipgkzbList.get(i).getDport());
			resultMap.put("protocol", TranslatingUtil.CSCXY(ipgkzbList.get(i).getProtocol()));
			resultMap.put("protoId", ipgkzbList.get(i).getProtoId());
			resultMap.put("detailId", TranslatingUtil.XXID(ipgkzbList.get(i).getDetailId()));
			resultMap.put("fileName", ipgkzbList.get(i).getFileName());
			resultMap.put("fileContent", ipgkzbList.get(i).getFileContent());
			resultMap.put("gjz", ipgkzbList.get(i).getGjz());
			resultMap.put("yys", TranslatingUtil.YYS(ipgkzbList.get(i).getYys()));
			resultMap.put("yl1", ipgkzbList.get(i).getYl1());
			resultMap.put("yl2", ipgkzbList.get(i).getYl2());
			resultMap.put("yl3", ipgkzbList.get(i).getYl3());
			resultMap.put("yl4", ipgkzbList.get(i).getYl4());
			resultMap.put("yl5", ipgkzbList.get(i).getYl5());
			resultList.add(resultMap);
		}
		map = new HashMap<>();
		map.put("data", resultList);
		map.put("pageSize", pageSize);
		map.put("pageNo", pageNo);
		map.put("totalPage", num / pageSize);
		map.put("totalCount", num);
		map.put("code", 200);
		}
		return map;
	}

}
