package iie.cas.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
import iie.cas.service.MonitoringLogDownService;
import iie.cas.util.IPv4Util;
import iie.cas.util.TranslatingUtil;
@Service
public class MonitoringLogDownServiceImpl implements MonitoringLogDownService {
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

	@Override
	public Map<String, Object> IPHMDqueryLogInfo(Map<String, Object> map) {
		ArrayList<Map<String, Object>> resultList = new ArrayList<>();
		List<IPGKZBLogPo> ipgkzbList = iPGKZBMapper.SelectAll(map);
		Map<Integer, Object> lhMap=TranslatingUtil.LHIDList(baseJklhMapper.SelectAll());
		Map<Integer, Object> dyMap=TranslatingUtil.YDYList(areaCodeTMapper.selectA());
//		Integer num = iPGKZBMapper.SelectCount(map);
		for (int i = 0; i < ipgkzbList.size(); i++) {
			Map<String, Object> resultMap = new HashMap<>();
			try {
				resultMap.put("12", sdf.format(sdf.parse(ipgkzbList.get(i).getBhsj())));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			resultMap.put("15", StringUtils.isNotBlank(ipgkzbList.get(i).getLabel())?"\""+ipgkzbList.get(i).getLabel()+"\"":"");
			resultMap.put("1",  StringUtils.isNotBlank(ipgkzbList.get(i).getPzid())?"\""+ipgkzbList.get(i).getPzid()+"\"":"");
			resultMap.put("flid", ipgkzbList.get(i).getFlid());
			resultMap.put("xzid", ipgkzbList.get(i).getXzid());
			resultMap.put("10", lhMap.containsKey(ipgkzbList.get(i).getLhid())?"\""+lhMap.get(ipgkzbList.get(i).getLhid())+"\"":"未知");
			resultMap.put("8", dyMap.containsKey(ipgkzbList.get(i).getYdy())?"\""+dyMap.get(ipgkzbList.get(i).getYdy())+"\"":"未知");
			resultMap.put("9", dyMap.containsKey(ipgkzbList.get(i).getMddy())?"\""+dyMap.get(ipgkzbList.get(i).getMddy())+"\"":"未知");
			resultMap.put("pzlx", TranslatingUtil.PZLX(ipgkzbList.get(i).getPzlx()).get("name"));
			resultMap.put("14", TranslatingUtil.GKLB(ipgkzbList.get(i).getGklb()).get("name"));
			resultMap.put("2", IPv4Util.longToIp(Long.parseLong(ipgkzbList.get(i).getQdjip() + "")));
			resultMap.put("4", IPv4Util.longToIp(Long.parseLong(ipgkzbList.get(i).getSip())));
			resultMap.put("5", IPv4Util.longToIp(Long.parseLong(ipgkzbList.get(i).getDip())));
			resultMap.put("6", ipgkzbList.get(i).getSport());
			resultMap.put("7", ipgkzbList.get(i).getDport());
			resultMap.put("11", TranslatingUtil.CSCXY(ipgkzbList.get(i).getProtocol()).get("name"));
			resultMap.put("protoId", ipgkzbList.get(i).getProtoId());
			resultMap.put("3", TranslatingUtil.XXID(ipgkzbList.get(i).getDetailId()).get("name"));
			resultMap.put("13", TranslatingUtil.YYS(ipgkzbList.get(i).getYys()).get("name"));
			resultMap.put("yl1", ipgkzbList.get(i).getYl1());
			resultMap.put("yl2", ipgkzbList.get(i).getYl2());
			resultMap.put("yl3", ipgkzbList.get(i).getYl3());
			resultMap.put("yl4", ipgkzbList.get(i).getYl4());
			resultMap.put("yl5", ipgkzbList.get(i).getYl5());
			resultList.add(resultMap);
		}
		map = new HashMap<>();
		map.put("data", resultList);
		map.put("code", 200);
		return map;
	}

	@Override
	public Map<String, Object> HTTPJCqueryLogInfo(Map<String, Object> map) {

		ArrayList<Map<String, Object>> resultList = new ArrayList<>();
		List<HTTPJCZBLogPo> ipgkzbList = httpJCZBMapper.SelectAll(map);
		Map<Integer, Object> lhMap=TranslatingUtil.LHIDList(baseJklhMapper.SelectAll());
		Map<Integer, Object> dyMap=TranslatingUtil.YDYList(areaCodeTMapper.selectA());
//		Integer num = httpJCZBMapper.SelectCount(map);
		for (int i = 0; i < ipgkzbList.size(); i++) {
			Map<String, Object> resultMap = new HashMap<>();
			try {
				resultMap.put("12", sdf.format(sdf.parse(ipgkzbList.get(i).getBhsj())));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			resultMap.put("15", StringUtils.isNotBlank(ipgkzbList.get(i).getLabel())?"\""+ipgkzbList.get(i).getLabel()+"\"":"");
			resultMap.put("1",  StringUtils.isNotBlank(ipgkzbList.get(i).getPzid())?"\""+ipgkzbList.get(i).getPzid()+"\"":"");
			resultMap.put("10", lhMap.containsKey(ipgkzbList.get(i).getLhid())?"\""+lhMap.get(ipgkzbList.get(i).getLhid())+"\"":"未知");
			resultMap.put("8", dyMap.containsKey(ipgkzbList.get(i).getYdy())?"\""+dyMap.get(ipgkzbList.get(i).getYdy())+"\"":"未知");
			resultMap.put("9", dyMap.containsKey(ipgkzbList.get(i).getMddy())?"\""+dyMap.get(ipgkzbList.get(i).getMddy())+"\"":"未知");
			resultMap.put("14", TranslatingUtil.GKLB(ipgkzbList.get(i).getGklb()).get("name"));
			if (ipgkzbList.get(i).getYyzl() != null) {
				resultMap.put("16", TranslatingUtil.YYZL(ipgkzbList.get(i).getYyzl()).get("name"));
			} else {
				resultMap.put("16", "");
			}

			resultMap.put("2", IPv4Util.longToIp(Long.parseLong(ipgkzbList.get(i).getQdjip() + "")));
			resultMap.put("4", IPv4Util.longToIp(Long.parseLong(ipgkzbList.get(i).getSip())));
			resultMap.put("5", IPv4Util.longToIp(Long.parseLong(ipgkzbList.get(i).getDip())));
			resultMap.put("6", ipgkzbList.get(i).getSport());
			resultMap.put("7", ipgkzbList.get(i).getDport());
			resultMap.put("11", TranslatingUtil.CSCXY(ipgkzbList.get(i).getProtocol()).get("name"));
			resultMap.put("3", TranslatingUtil.XXID(ipgkzbList.get(i).getDetailId()).get("name"));
			resultMap.put("17", StringUtils.isNotBlank(ipgkzbList.get(i).getHost())?"\""+ipgkzbList.get(i).getHost()+"\"":"");
			resultMap.put("19", StringUtils.isNotBlank(ipgkzbList.get(i).getUserAgent())?"\""+ipgkzbList.get(i).getUserAgent()+"\"":"");
			resultMap.put("21", StringUtils.isNotBlank(ipgkzbList.get(i).getFileName())?"\""+ipgkzbList.get(i).getFileName()+"\"":"");
			resultMap.put("13", TranslatingUtil.YYS(ipgkzbList.get(i).getYys()).get("name"));
			resultMap.put("18", StringUtils.isNotBlank(ipgkzbList.get(i).getUrl())?"\""+ipgkzbList.get(i).getUrl()+"\"":"");
			resultMap.put("20", StringUtils.isNotBlank(ipgkzbList.get(i).getCookie())?"\""+ipgkzbList.get(i).getCookie()+"\"":"");
			resultMap.put("22", StringUtils.isNotBlank(ipgkzbList.get(i).getContent())?"\""+ipgkzbList.get(i).getContent()+"\"":"");
			resultList.add(resultMap);
		}
		map = new HashMap<>();
		map.put("data", resultList);
		map.put("code", 200);
		return map;
	}

	@Override
	public Map<String, Object> DNSJCqueryLogInfo(Map<String, Object> map) {
		ArrayList<Map<String, Object>> resultList = new ArrayList<>();
		
		List<DNSJCZBLogPo> ipgkzbList = dnsJCZBMapper.SelectAll(map);
		Map<Integer, Object> lhMap=TranslatingUtil.LHIDList(baseJklhMapper.SelectAll());
		Map<Integer, Object> dyMap=TranslatingUtil.YDYList(areaCodeTMapper.selectA());
//		Integer num = dnsJCZBMapper.SelectCount(map);
		for (int i = 0; i < ipgkzbList.size(); i++) {
			Map<String, Object> resultMap = new HashMap<>();
			try {
				resultMap.put("12", sdf.format(sdf.parse(ipgkzbList.get(i).getBhsj())));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			resultMap.put("15", StringUtils.isNotBlank(ipgkzbList.get(i).getLabel())?"\""+ipgkzbList.get(i).getLabel()+"\"":"");
			resultMap.put("1",  StringUtils.isNotBlank(ipgkzbList.get(i).getPzid())?"\""+ipgkzbList.get(i).getPzid()+"\"":"");
			resultMap.put("10", lhMap.containsKey(ipgkzbList.get(i).getLhid())?"\""+lhMap.get(ipgkzbList.get(i).getLhid())+"\"":"未知");
			resultMap.put("8", dyMap.containsKey(ipgkzbList.get(i).getYdy())?"\""+dyMap.get(ipgkzbList.get(i).getYdy())+"\"":"未知");
			resultMap.put("9", dyMap.containsKey(ipgkzbList.get(i).getMddy())?"\""+dyMap.get(ipgkzbList.get(i).getMddy())+"\"":"未知");
			resultMap.put("14", TranslatingUtil.GKLB(ipgkzbList.get(i).getGklb()).get("name"));
			resultMap.put("2", IPv4Util.longToIp(Long.parseLong(ipgkzbList.get(i).getQdjip() + "")));
			resultMap.put("4", IPv4Util.longToIp(Long.parseLong(ipgkzbList.get(i).getSip())));
			resultMap.put("5", IPv4Util.longToIp(Long.parseLong(ipgkzbList.get(i).getDip())));
			resultMap.put("6", ipgkzbList.get(i).getSport());
			resultMap.put("7", ipgkzbList.get(i).getDport());
			resultMap.put("11", TranslatingUtil.CSCXY(ipgkzbList.get(i).getProtocol()).get("name"));
			resultMap.put("3", TranslatingUtil.XXID(ipgkzbList.get(i).getDetailId()).get("name"));
			resultMap.put("16", StringUtils.isNotBlank(ipgkzbList.get(i).getDnsName())?"\""+ipgkzbList.get(i).getDnsName()+"\"":"");
			resultMap.put("17", StringUtils.isNotBlank(ipgkzbList.get(i).getDnsValue())?"\""+ipgkzbList.get(i).getDnsValue()+"\"":"");
			resultMap.put("13", TranslatingUtil.YYS(ipgkzbList.get(i).getYys()).get("name"));
			resultList.add(resultMap);
		}
		map = new HashMap<>();
		map.put("data", resultList);
		map.put("code", 200);
		return map;
	}

	@Override
	public Map<String, Object> SSLJCqueryLogInfo(Map<String, Object> map) {
		ArrayList<Map<String, Object>> resultList = new ArrayList<>();
		List<SSLJCZBLogPo> ipgkzbList = sslJCZBMapper.SelectAll(map);
		Map<Integer, Object> lhMap=TranslatingUtil.LHIDList(baseJklhMapper.SelectAll());
		Map<Integer, Object> dyMap=TranslatingUtil.YDYList(areaCodeTMapper.selectA());
//		Integer num = sslJCZBMapper.SelectCount(map);
		for (int i = 0; i < ipgkzbList.size(); i++) {
			Map<String, Object> resultMap = new HashMap<>();
			try {
				resultMap.put("12", sdf.format(sdf.parse(ipgkzbList.get(i).getBhsj())));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			resultMap.put("15", StringUtils.isNotBlank(ipgkzbList.get(i).getLabel())?"\""+ipgkzbList.get(i).getLabel()+"\"":"");
			resultMap.put("1",  StringUtils.isNotBlank(ipgkzbList.get(i).getPzid())?"\""+ipgkzbList.get(i).getPzid()+"\"":"");
			resultMap.put("10", lhMap.containsKey(ipgkzbList.get(i).getLhid())?"\""+lhMap.get(ipgkzbList.get(i).getLhid())+"\"":"未知");
			resultMap.put("8", dyMap.containsKey(ipgkzbList.get(i).getYdy())?"\""+dyMap.get(ipgkzbList.get(i).getYdy())+"\"":"未知");
			resultMap.put("9", dyMap.containsKey(ipgkzbList.get(i).getMddy())?"\""+dyMap.get(ipgkzbList.get(i).getMddy())+"\"":"未知");
			resultMap.put("14", TranslatingUtil.GKLB(ipgkzbList.get(i).getGklb()).get("name"));
			resultMap.put("2", IPv4Util.longToIp(Long.parseLong(ipgkzbList.get(i).getQdjip() + "")));
			resultMap.put("4", IPv4Util.longToIp(Long.parseLong(ipgkzbList.get(i).getSip())));
			resultMap.put("5", IPv4Util.longToIp(Long.parseLong(ipgkzbList.get(i).getDip())));
			resultMap.put("6", ipgkzbList.get(i).getSport());
			resultMap.put("7", ipgkzbList.get(i).getDport());
			resultMap.put("11", TranslatingUtil.CSCXY(ipgkzbList.get(i).getProtocol()).get("name"));
			resultMap.put("3", TranslatingUtil.XXID(ipgkzbList.get(i).getDetailId()).get("name"));
			resultMap.put("16", StringUtils.isNotBlank(ipgkzbList.get(i).getZsmc())?"\""+ipgkzbList.get(i).getZsmc()+"\"":"");
			resultMap.put("17", StringUtils.isNotBlank(ipgkzbList.get(i).getBfz())?"\""+ipgkzbList.get(i).getBfz()+"\"":"");
			resultMap.put("18", StringUtils.isNotBlank(ipgkzbList.get(i).getSyz())?"\""+ipgkzbList.get(i).getSyz()+"\"":"");
			resultMap.put("19", StringUtils.isNotBlank(ipgkzbList.get(i).getFwqmc())?"\""+ipgkzbList.get(i).getFwqmc()+"\"":"");
			resultMap.put("13", TranslatingUtil.YYS(ipgkzbList.get(i).getYys()).get("name"));
			resultList.add(resultMap);
		}
		map = new HashMap<>();
		map.put("data", resultList);
		map.put("code", 200);
		return map;
	}

	@Override
	public Map<String, Object> MAILJCqueryLogInfo(Map<String, Object> map) {
		ArrayList<Map<String, Object>> resultList = new ArrayList<>();
		List<MAILJCZBLogPo> ipgkzbList = mailJCZBMapper.SelectAll(map);
		Map<Integer, Object> lhMap=TranslatingUtil.LHIDList(baseJklhMapper.SelectAll());
		Map<Integer, Object> dyMap=TranslatingUtil.YDYList(areaCodeTMapper.selectA());
//		Integer num = mailJCZBMapper.SelectCount(map);
		for (int i = 0; i < ipgkzbList.size(); i++) {
			Map<String, Object> resultMap = new HashMap<>();
			try {
				resultMap.put("12", sdf.format(sdf.parse(ipgkzbList.get(i).getBhsj())));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			resultMap.put("15", StringUtils.isNotBlank(ipgkzbList.get(i).getLabel())?"\""+ipgkzbList.get(i).getLabel()+"\"":"");
			resultMap.put("1",  StringUtils.isNotBlank(ipgkzbList.get(i).getPzid())?"\""+ipgkzbList.get(i).getPzid()+"\"":"");
			resultMap.put("10", lhMap.containsKey(ipgkzbList.get(i).getLhid())?"\""+lhMap.get(ipgkzbList.get(i).getLhid())+"\"":"未知");
			resultMap.put("8", dyMap.containsKey(ipgkzbList.get(i).getYdy())?"\""+dyMap.get(ipgkzbList.get(i).getYdy())+"\"":"未知");
			resultMap.put("9", dyMap.containsKey(ipgkzbList.get(i).getMddy())?"\""+dyMap.get(ipgkzbList.get(i).getMddy())+"\"":"未知");
			resultMap.put("14", TranslatingUtil.GKLB(ipgkzbList.get(i).getGklb()).get("name"));
			if (ipgkzbList.get(i).getYyzl() != null) {
				resultMap.put("16", TranslatingUtil.YYZL(ipgkzbList.get(i).getYyzl()).get("name"));
			} else {
				resultMap.put("16", "");
			}

			resultMap.put("2", IPv4Util.longToIp(Long.parseLong(ipgkzbList.get(i).getQdjip() + "")));
			resultMap.put("4", IPv4Util.longToIp(Long.parseLong(ipgkzbList.get(i).getSip())));
			resultMap.put("5", IPv4Util.longToIp(Long.parseLong(ipgkzbList.get(i).getDip())));
			resultMap.put("6", ipgkzbList.get(i).getSport());
			resultMap.put("7", ipgkzbList.get(i).getDport());
			resultMap.put("11", TranslatingUtil.CSCXY(ipgkzbList.get(i).getProtocol()).get("name"));
			resultMap.put("3", TranslatingUtil.XXID(ipgkzbList.get(i).getDetailId()).get("name"));
			resultMap.put("17", StringUtils.isNotBlank(ipgkzbList.get(i).getMailSender())?"\""+ipgkzbList.get(i).getMailSender()+"\"":"");
			resultMap.put("19", ipgkzbList.get(i).getReceverNum()!=null?ipgkzbList.get(i).getReceverNum():"");
			resultMap.put("21", ipgkzbList.get(i).getCcNum()!=null?ipgkzbList.get(i).getCcNum():"");
			resultMap.put("22", StringUtils.isNotBlank(ipgkzbList.get(i).getMailSubject())?"\""+ipgkzbList.get(i).getMailSubject()+"\"":"");
			resultMap.put("24", ipgkzbList.get(i).getAccessory()!=null?ipgkzbList.get(i).getAccessory():"");
			resultMap.put("25", StringUtils.isNotBlank(ipgkzbList.get(i).getFileName())?"\""+ipgkzbList.get(i).getFileName()+"\"":"");
			resultMap.put("26", StringUtils.isNotBlank(ipgkzbList.get(i).getFileContent())?"\""+ipgkzbList.get(i).getFileContent()+"\"":"");
			resultMap.put("27", StringUtils.isNotBlank(ipgkzbList.get(i).getPwd())?"\""+ipgkzbList.get(i).getPwd()+"\"":"");
			resultMap.put("28", StringUtils.isNotBlank(ipgkzbList.get(i).getFjfws())?"\""+ipgkzbList.get(i).getFjfws()+"\"":"");
			resultMap.put("29", ipgkzbList.get(i).getFjfwsSzd()!=null?ipgkzbList.get(i).getFjfwsSzd():"");
			resultMap.put("30", StringUtils.isNotBlank(ipgkzbList.get(i).getSjfws())?"\""+ipgkzbList.get(i).getSjfws()+"\"":"");
			resultMap.put("31", StringUtils.isNotBlank(ipgkzbList.get(i).getSjfwsSzd())?"\""+ipgkzbList.get(i).getSjfwsSzd()+"\"":"");
			resultMap.put("32", StringUtils.isNotBlank(ipgkzbList.get(i).getXylx())?"\""+ipgkzbList.get(i).getXylx()+"\"":"");
			resultMap.put("33", StringUtils.isNotBlank(ipgkzbList.get(i).getGjz())?"\""+ipgkzbList.get(i).getGjz()+"\"":"");
			resultMap.put("13", TranslatingUtil.YYS(ipgkzbList.get(i).getYys()).get("name"));
			resultMap.put("18", StringUtils.isNotBlank(ipgkzbList.get(i).getMailRecever())?"\""+ipgkzbList.get(i).getMailRecever()+"\"":"");
			resultMap.put("20", StringUtils.isNotBlank(ipgkzbList.get(i).getMailCc())?"\""+ipgkzbList.get(i).getMailCc()+"\"":"");
			resultMap.put("23", StringUtils.isNotBlank(ipgkzbList.get(i).getContent())?"\""+ipgkzbList.get(i).getContent()+"\"":"");
			resultList.add(resultMap);
		}
		map = new HashMap<>();
		map.put("data", resultList);
		map.put("code", 200);
		return map;
	}

	@Override
	public Map<String, Object> JSTXJCqueryLogInfo(Map<String, Object> map) {
		ArrayList<Map<String, Object>> resultList = new ArrayList<>();
		
		List<JSTXJCZBLogPo> ipgkzbList = jstxJCZBMapper.SelectAll(map);
		Map<Integer, Object> lhMap=TranslatingUtil.LHIDList(baseJklhMapper.SelectAll());
		Map<Integer, Object> dyMap=TranslatingUtil.YDYList(areaCodeTMapper.selectA());
//		Integer num = jstxJCZBMapper.SelectCount(map);
		for (int i = 0; i < ipgkzbList.size(); i++) {
			Map<String, Object> resultMap = new HashMap<>();
			try {
				resultMap.put("12", sdf.format(sdf.parse(ipgkzbList.get(i).getBhsj())));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			resultMap.put("15", StringUtils.isNotBlank(ipgkzbList.get(i).getLabel())?"\""+ipgkzbList.get(i).getLabel()+"\"":"");
			resultMap.put("1",  StringUtils.isNotBlank(ipgkzbList.get(i).getPzid())?"\""+ipgkzbList.get(i).getPzid()+"\"":"");
			resultMap.put("10", lhMap.containsKey(ipgkzbList.get(i).getLhid())?"\""+lhMap.get(ipgkzbList.get(i).getLhid())+"\"":"未知");
			resultMap.put("8", dyMap.containsKey(ipgkzbList.get(i).getYdy())?"\""+dyMap.get(ipgkzbList.get(i).getYdy())+"\"":"未知");
			resultMap.put("9", dyMap.containsKey(ipgkzbList.get(i).getMddy())?"\""+dyMap.get(ipgkzbList.get(i).getMddy())+"\"":"未知");
			resultMap.put("14", TranslatingUtil.GKLB(ipgkzbList.get(i).getGklb()).get("name"));
			if (ipgkzbList.get(i).getYyzl() != null) {
				resultMap.put("16", TranslatingUtil.YYZL(ipgkzbList.get(i).getYyzl()).get("name"));
			} else {
				resultMap.put("16", "");
			}

			resultMap.put("2", IPv4Util.longToIp(Long.parseLong(ipgkzbList.get(i).getQdjip() + "")));
			resultMap.put("4", IPv4Util.longToIp(Long.parseLong(ipgkzbList.get(i).getSip())));
			resultMap.put("5", IPv4Util.longToIp(Long.parseLong(ipgkzbList.get(i).getDip())));
			resultMap.put("6", ipgkzbList.get(i).getSport());
			resultMap.put("7", ipgkzbList.get(i).getDport());
			resultMap.put("11", TranslatingUtil.CSCXY(ipgkzbList.get(i).getProtocol()).get("name"));
			resultMap.put("3", TranslatingUtil.XXID(ipgkzbList.get(i).getDetailId()).get("name"));
			resultMap.put("17", StringUtils.isNotBlank(ipgkzbList.get(i).getDzId())?"\""+ipgkzbList.get(i).getDzId()+"\"":"");
			resultMap.put("18", StringUtils.isNotBlank(ipgkzbList.get(i).getHost())?"\""+ipgkzbList.get(i).getHost()+"\"":"");
			resultMap.put("20", StringUtils.isNotBlank(ipgkzbList.get(i).getUserAgent())?"\""+ipgkzbList.get(i).getUserAgent()+"\"":"");
			resultMap.put("21", StringUtils.isNotBlank(ipgkzbList.get(i).getUserId())?"\""+ipgkzbList.get(i).getUserId()+"\"":"");
			resultMap.put("23", StringUtils.isNotBlank(ipgkzbList.get(i).getReserved())?"\""+ipgkzbList.get(i).getReserved()+"\"":"");
			resultMap.put("13", TranslatingUtil.YYS(ipgkzbList.get(i).getYys()).get("name"));
			resultMap.put("22", StringUtils.isNotBlank(ipgkzbList.get(i).getContent())?"\""+ipgkzbList.get(i).getContent()+"\"":"");
			resultMap.put("19", StringUtils.isNotBlank(ipgkzbList.get(i).getUrl())?"\""+ipgkzbList.get(i).getUrl()+"\"":"");
			resultList.add(resultMap);
		}
		map = new HashMap<>();
		map.put("data", resultList);
		map.put("code", 200);
		return map;
	}

	@Override
	public Map<String, Object> VPNJCqueryLogInfo(Map<String, Object> map) {
		ArrayList<Map<String, Object>> resultList = new ArrayList<>();
		List<VPNJCZBLogPo> ipgkzbList = vpnJCZBMapper.SelectAll(map);
		Map<Integer, Object> lhMap=TranslatingUtil.LHIDList(baseJklhMapper.SelectAll());
		Map<Integer, Object> dyMap=TranslatingUtil.YDYList(areaCodeTMapper.selectA());
//		Integer num = vpnJCZBMapper.SelectCount(map);
		for (int i = 0; i < ipgkzbList.size(); i++) {
			Map<String, Object> resultMap = new HashMap<>();
			try {
				resultMap.put("12", sdf.format(sdf.parse(ipgkzbList.get(i).getBhsj())));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			resultMap.put("15", StringUtils.isNotBlank(ipgkzbList.get(i).getLabel())?"\""+ipgkzbList.get(i).getLabel()+"\"":"");
			resultMap.put("1",  StringUtils.isNotBlank(ipgkzbList.get(i).getPzid())?"\""+ipgkzbList.get(i).getPzid()+"\"":"");
			resultMap.put("10", lhMap.containsKey(ipgkzbList.get(i).getLhid())?"\""+lhMap.get(ipgkzbList.get(i).getLhid())+"\"":"未知");
			resultMap.put("8", dyMap.containsKey(ipgkzbList.get(i).getYdy())?"\""+dyMap.get(ipgkzbList.get(i).getYdy())+"\"":"未知");
			resultMap.put("9", dyMap.containsKey(ipgkzbList.get(i).getMddy())?"\""+dyMap.get(ipgkzbList.get(i).getMddy())+"\"":"未知");
			resultMap.put("14", TranslatingUtil.GKLB(ipgkzbList.get(i).getGklb()).get("name"));
			resultMap.put("2", IPv4Util.longToIp(Long.parseLong(ipgkzbList.get(i).getQdjip() + "")));
			resultMap.put("4", IPv4Util.longToIp(Long.parseLong(ipgkzbList.get(i).getSip())));
			resultMap.put("5", IPv4Util.longToIp(Long.parseLong(ipgkzbList.get(i).getDip())));
			resultMap.put("6", ipgkzbList.get(i).getSport());
			resultMap.put("7", ipgkzbList.get(i).getDport());
			resultMap.put("11", TranslatingUtil.CSCXY(ipgkzbList.get(i).getProtocol()).get("name"));
			resultMap.put("3", TranslatingUtil.XXID(ipgkzbList.get(i).getDetailId()).get("name"));
			resultMap.put("17", StringUtils.isNotBlank(ipgkzbList.get(i).getUsername())?"\""+ipgkzbList.get(i).getUsername()+"\"":"");
			resultMap.put("18", StringUtils.isNotBlank(ipgkzbList.get(i).getPwd())?"\""+ipgkzbList.get(i).getPwd()+"\"":"");
			resultMap.put("13", TranslatingUtil.YYS(ipgkzbList.get(i).getYys()).get("name"));
			resultMap.put("16", StringUtils.isNotBlank(ipgkzbList.get(i).getUrl())?"\""+ipgkzbList.get(i).getUrl()+"\"":"");
			resultList.add(resultMap);
		}
		map = new HashMap<>();
		map.put("data", resultList);
		map.put("code", 200);
		return map;
	}

	@Override
	public Map<String, Object> FTPGJCJCqueryLogInfo(Map<String, Object> map) {
		ArrayList<Map<String, Object>> resultList = new ArrayList<>();
		List<FTPJCZBLogPo> ipgkzbList = ftpJCZBMapper.SelectAll(map);
		Map<Integer, Object> lhMap=TranslatingUtil.LHIDList(baseJklhMapper.SelectAll());
		Map<Integer, Object> dyMap=TranslatingUtil.YDYList(areaCodeTMapper.selectA());
//		Integer num = ftpJCZBMapper.SelectCount(map);
		for (int i = 0; i < ipgkzbList.size(); i++) {
			Map<String, Object> resultMap = new HashMap<>();
			try {
				resultMap.put("12", sdf.format(sdf.parse(ipgkzbList.get(i).getBhsj())));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			resultMap.put("15", StringUtils.isNotBlank(ipgkzbList.get(i).getLabel())?"\""+ipgkzbList.get(i).getLabel()+"\"":"");
			resultMap.put("1",  StringUtils.isNotBlank(ipgkzbList.get(i).getPzid())?"\""+ipgkzbList.get(i).getPzid()+"\"":"");
			resultMap.put("10", lhMap.containsKey(ipgkzbList.get(i).getLhid())?"\""+lhMap.get(ipgkzbList.get(i).getLhid())+"\"":"未知");
			resultMap.put("8", dyMap.containsKey(ipgkzbList.get(i).getYdy())?"\""+dyMap.get(ipgkzbList.get(i).getYdy())+"\"":"未知");
			resultMap.put("9", dyMap.containsKey(ipgkzbList.get(i).getMddy())?"\""+dyMap.get(ipgkzbList.get(i).getMddy())+"\"":"未知");
			resultMap.put("14", TranslatingUtil.GKLB(ipgkzbList.get(i).getGklb()).get("name"));

			if (ipgkzbList.get(i).getYyzl() != null) {
				resultMap.put("16", TranslatingUtil.YYZL(ipgkzbList.get(i).getYyzl()).get("name"));
			} else {
				resultMap.put("16", "");
			}
			resultMap.put("2", IPv4Util.longToIp(Long.parseLong(ipgkzbList.get(i).getQdjip() + "")));
			resultMap.put("4", IPv4Util.longToIp(Long.parseLong(ipgkzbList.get(i).getSip())));
			resultMap.put("5", IPv4Util.longToIp(Long.parseLong(ipgkzbList.get(i).getDip())));
			resultMap.put("6", ipgkzbList.get(i).getSport());
			resultMap.put("7", ipgkzbList.get(i).getDport());
			resultMap.put("11", TranslatingUtil.CSCXY(ipgkzbList.get(i).getProtocol()).get("name"));
			resultMap.put("3", TranslatingUtil.XXID(ipgkzbList.get(i).getDetailId()).get("name"));
			resultMap.put("17", StringUtils.isNotBlank(ipgkzbList.get(i).getFileName())?"\""+ipgkzbList.get(i).getFileName()+"\"":"");
			resultMap.put("18", StringUtils.isNotBlank(ipgkzbList.get(i).getFileContent())?"\""+ipgkzbList.get(i).getFileContent()+"\"":"");
			resultMap.put("13", TranslatingUtil.YYS(ipgkzbList.get(i).getYys()).get("name"));
			resultMap.put("19", StringUtils.isNotBlank(ipgkzbList.get(i).getGjz())?"\""+ipgkzbList.get(i).getGjz()+"\"":"");
			resultList.add(resultMap);
		}
		map = new HashMap<>();
		map.put("data", resultList);
		map.put("code", 200);
		return map;
	}

	@Override
	public Map<String, Object> WYGJCJCqueryLogInfo(Map<String, Object> map) {
		ArrayList<Map<String, Object>> resultList = new ArrayList<>();
		List<WYGJCJCRZLogPo> ipgkzbList = wtgjcJCRZMapper.SelectAll(map);
		Map<Integer, Object> lhMap=TranslatingUtil.LHIDList(baseJklhMapper.SelectAll());
		Map<Integer, Object> dyMap=TranslatingUtil.YDYList(areaCodeTMapper.selectA());
//		Integer num = wtgjcJCRZMapper.SelectCount(map);
		for (int i = 0; i < ipgkzbList.size(); i++) {
			Map<String, Object> resultMap = new HashMap<>();
			try {
				resultMap.put("12", sdf.format(sdf.parse(ipgkzbList.get(i).getBhsj())));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			resultMap.put("15", StringUtils.isNotBlank(ipgkzbList.get(i).getLabel())?"\""+ipgkzbList.get(i).getLabel()+"\"":"");
			resultMap.put("1",  StringUtils.isNotBlank(ipgkzbList.get(i).getPzid())?"\""+ipgkzbList.get(i).getPzid()+"\"":"");
			resultMap.put("10", lhMap.containsKey(ipgkzbList.get(i).getLhid())?"\""+lhMap.get(ipgkzbList.get(i).getLhid())+"\"":"未知");
			resultMap.put("8", dyMap.containsKey(ipgkzbList.get(i).getYdy())?"\""+dyMap.get(ipgkzbList.get(i).getYdy())+"\"":"未知");
			resultMap.put("9", dyMap.containsKey(ipgkzbList.get(i).getMddy())?"\""+dyMap.get(ipgkzbList.get(i).getMddy())+"\"":"未知");
			resultMap.put("14", TranslatingUtil.GKLB(ipgkzbList.get(i).getGklb()).get("name"));
			if (ipgkzbList.get(i).getYyzl() != null) {
				resultMap.put("16", TranslatingUtil.YYZL(ipgkzbList.get(i).getYyzl()).get("name"));
			} else {
				resultMap.put("16", "");
			}

			resultMap.put("2", IPv4Util.longToIp(Long.parseLong(ipgkzbList.get(i).getQdjip() + "")));
			resultMap.put("4", IPv4Util.longToIp(Long.parseLong(ipgkzbList.get(i).getSip())));
			resultMap.put("5", IPv4Util.longToIp(Long.parseLong(ipgkzbList.get(i).getDip())));
			resultMap.put("6", ipgkzbList.get(i).getSport());
			resultMap.put("7", ipgkzbList.get(i).getDport());
			resultMap.put("11", TranslatingUtil.CSCXY(ipgkzbList.get(i).getProtocol()).get("name"));
			resultMap.put("3", TranslatingUtil.XXID(ipgkzbList.get(i).getDetailId()).get("name"));
			resultMap.put("19", StringUtils.isNotBlank(ipgkzbList.get(i).getSsyq())?"\""+ipgkzbList.get(i).getSsyq()+"\"":"");
			resultMap.put("13", TranslatingUtil.YYS(ipgkzbList.get(i).getYys()).get("name"));
			resultMap.put("20", StringUtils.isNotBlank(ipgkzbList.get(i).getGjz())?"\""+ipgkzbList.get(i).getGjz()+"\"":"");
			resultMap.put("17", StringUtils.isNotBlank(ipgkzbList.get(i).getJcUrl())?"\""+ipgkzbList.get(i).getJcUrl()+"\"":"");
			resultMap.put("18", StringUtils.isNotBlank(ipgkzbList.get(i).getContent())?"\""+ipgkzbList.get(i).getContent()+"\"":"");
			resultList.add(resultMap);
		}
		map = new HashMap<>();
		map.put("data", resultList);
		map.put("code", 200);
		return map;
	}

	@Override
	public Map<String, Object> IPJCqueryLogInfo(Map<String, Object> map) {
		ArrayList<Map<String, Object>> resultList = new ArrayList<>();
		List<IPJCZBLogPo> ipgkzbList = ipJCZBMapper.SelectAll(map);
		Map<Integer, Object> lhMap=TranslatingUtil.LHIDList(baseJklhMapper.SelectAll());
		Map<Integer, Object> dyMap=TranslatingUtil.YDYList(areaCodeTMapper.selectA());
//		Integer num = ipJCZBMapper.SelectCount(map);
		for (int i = 0; i < ipgkzbList.size(); i++) {
			Map<String, Object> resultMap = new HashMap<>();
			try {
				resultMap.put("12", sdf.format(sdf.parse(ipgkzbList.get(i).getBhsj())));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			resultMap.put("15", StringUtils.isNotBlank(ipgkzbList.get(i).getLabel())?"\""+ipgkzbList.get(i).getLabel()+"\"":"");
			resultMap.put("1",  StringUtils.isNotBlank(ipgkzbList.get(i).getPzid())?"\""+ipgkzbList.get(i).getPzid()+"\"":"");
			resultMap.put("10", lhMap.containsKey(ipgkzbList.get(i).getLhid())?"\""+lhMap.get(ipgkzbList.get(i).getLhid())+"\"":"未知");
			resultMap.put("8", dyMap.containsKey(ipgkzbList.get(i).getYdy())?"\""+dyMap.get(ipgkzbList.get(i).getYdy())+"\"":"未知");
			resultMap.put("9", dyMap.containsKey(ipgkzbList.get(i).getMddy())?"\""+dyMap.get(ipgkzbList.get(i).getMddy())+"\"":"未知");
			resultMap.put("14", TranslatingUtil.GKLB(ipgkzbList.get(i).getGklb()).get("name"));
			resultMap.put("2", IPv4Util.longToIp(Long.parseLong(ipgkzbList.get(i).getQdjip() + "")));
			resultMap.put("4", IPv4Util.longToIp(Long.parseLong(ipgkzbList.get(i).getSip())));
			resultMap.put("5", IPv4Util.longToIp(Long.parseLong(ipgkzbList.get(i).getDip())));
			resultMap.put("6", ipgkzbList.get(i).getSport());
			resultMap.put("7", ipgkzbList.get(i).getDport());
			resultMap.put("11", TranslatingUtil.CSCXY(ipgkzbList.get(i).getProtocol()).get("name"));
			resultMap.put("3", TranslatingUtil.XXID(ipgkzbList.get(i).getDetailId()).get("name"));
			resultMap.put("16", StringUtils.isNotBlank(ipgkzbList.get(i).getHost())?"\""+ipgkzbList.get(i).getHost()+"\"":"");
			resultMap.put("13", TranslatingUtil.YYS(ipgkzbList.get(i).getYys()).get("name"));
			resultMap.put("17", StringUtils.isNotBlank(ipgkzbList.get(i).getUrl())?"\""+ipgkzbList.get(i).getUrl()+"\"":"");
			resultMap.put("18", StringUtils.isNotBlank(ipgkzbList.get(i).getContent())?"\""+ipgkzbList.get(i).getContent()+"\"":"");
			resultList.add(resultMap);
		}
		map = new HashMap<>();
		map.put("data", resultList);
		map.put("code", 200);
		return map;
	}

	@Override
	public Map<String, Object> TPJCqueryLogInfo(Map<String, Object> map) {
		ArrayList<Map<String, Object>> resultList = new ArrayList<>();
		List<PICJCZBLogPo> ipgkzbList = picJCZBMapper.SelectAll(map);
		Map<Integer, Object> lhMap=TranslatingUtil.LHIDList(baseJklhMapper.SelectAll());
		Map<Integer, Object> dyMap=TranslatingUtil.YDYList(areaCodeTMapper.selectA());
//		Integer num = picJCZBMapper.SelectCount(map);
		for (int i = 0; i < ipgkzbList.size(); i++) {
			Map<String, Object> resultMap = new HashMap<>();
			try {
				resultMap.put("12", sdf.format(sdf.parse(ipgkzbList.get(i).getBhsj())));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			resultMap.put("15", StringUtils.isNotBlank(ipgkzbList.get(i).getLabel())?"\""+ipgkzbList.get(i).getLabel()+"\"":"");
			resultMap.put("1",  StringUtils.isNotBlank(ipgkzbList.get(i).getPzid())?"\""+ipgkzbList.get(i).getPzid()+"\"":"");
			resultMap.put("10", lhMap.containsKey(ipgkzbList.get(i).getLhid())?"\""+lhMap.get(ipgkzbList.get(i).getLhid())+"\"":"未知");
			resultMap.put("8", dyMap.containsKey(ipgkzbList.get(i).getYdy())?"\""+dyMap.get(ipgkzbList.get(i).getYdy())+"\"":"未知");
			resultMap.put("9", dyMap.containsKey(ipgkzbList.get(i).getMddy())?"\""+dyMap.get(ipgkzbList.get(i).getMddy())+"\"":"未知");
			resultMap.put("14", TranslatingUtil.GKLB(ipgkzbList.get(i).getGklb()).get("name"));
			if (ipgkzbList.get(i).getYyzl() != null) {
				resultMap.put("16", TranslatingUtil.YYZL(ipgkzbList.get(i).getYyzl()).get("name"));
			} else {
				resultMap.put("16", "");
			}
			resultMap.put("2", IPv4Util.longToIp(Long.parseLong(ipgkzbList.get(i).getQdjip() + "")));
			resultMap.put("4", IPv4Util.longToIp(Long.parseLong(ipgkzbList.get(i).getSip())));
			resultMap.put("5", IPv4Util.longToIp(Long.parseLong(ipgkzbList.get(i).getDip())));
			resultMap.put("6", ipgkzbList.get(i).getSport());
			resultMap.put("7", ipgkzbList.get(i).getDport());
			resultMap.put("11", TranslatingUtil.CSCXY(ipgkzbList.get(i).getProtocol()).get("name"));
			resultMap.put("3", TranslatingUtil.XXID(ipgkzbList.get(i).getDetailId()).get("name"));
			resultMap.put("17", StringUtils.isNotBlank(ipgkzbList.get(i).getPicName())?"\""+ipgkzbList.get(i).getPicName()+"\"":"");
			resultMap.put("20", StringUtils.isNotBlank(ipgkzbList.get(i).getPicType())?"\""+ipgkzbList.get(i).getPicType()+"\"":"");
			resultMap.put("21", StringUtils.isNotBlank(ipgkzbList.get(i).getPicContent())?"\""+ipgkzbList.get(i).getPicContent()+"\"":"");
			resultMap.put("13", TranslatingUtil.YYS(ipgkzbList.get(i).getYys()).get("name"));
			resultMap.put("18", StringUtils.isNotBlank(ipgkzbList.get(i).getPicUrl())?"\""+ipgkzbList.get(i).getPicUrl()+"\"":"");
			resultMap.put("19", StringUtils.isNotBlank(ipgkzbList.get(i).getUrl())?"\""+ipgkzbList.get(i).getUrl()+"\"":"");
			resultList.add(resultMap);
		}
		map = new HashMap<>();
		map.put("data", resultList);
		map.put("code", 200);
		return map;
	}

	@Override
	public Map<String, Object> DMTJCqueryLogInfo(Map<String, Object> map) {
		ArrayList<Map<String, Object>> resultList = new ArrayList<>();
		List<MEDIAJCZBLogPo> ipgkzbList = mediaJCZBMapper.SelectAll(map);
		Map<Integer, Object> lhMap=TranslatingUtil.LHIDList(baseJklhMapper.SelectAll());
		Map<Integer, Object> dyMap=TranslatingUtil.YDYList(areaCodeTMapper.selectA());
//		Integer num = mediaJCZBMapper.SelectCount(map);
		for (int i = 0; i < ipgkzbList.size(); i++) {
			Map<String, Object> resultMap = new HashMap<>();
			try {
				resultMap.put("12", sdf.format(sdf.parse(ipgkzbList.get(i).getBhsj())));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			resultMap.put("15", StringUtils.isNotBlank(ipgkzbList.get(i).getLabel())?"\""+ipgkzbList.get(i).getLabel()+"\"":"");
			resultMap.put("1",  StringUtils.isNotBlank(ipgkzbList.get(i).getPzid())?"\""+ipgkzbList.get(i).getPzid()+"\"":"");
			resultMap.put("10", lhMap.containsKey(ipgkzbList.get(i).getLhid())?"\""+lhMap.get(ipgkzbList.get(i).getLhid())+"\"":"未知");
			resultMap.put("8", dyMap.containsKey(ipgkzbList.get(i).getYdy())?"\""+dyMap.get(ipgkzbList.get(i).getYdy())+"\"":"未知");
			resultMap.put("9", dyMap.containsKey(ipgkzbList.get(i).getMddy())?"\""+dyMap.get(ipgkzbList.get(i).getMddy())+"\"":"未知");
			resultMap.put("14", TranslatingUtil.GKLB(ipgkzbList.get(i).getGklb()).get("name"));
			if (ipgkzbList.get(i).getYyzl() != null) {
				resultMap.put("16", TranslatingUtil.YYZL(ipgkzbList.get(i).getYyzl()).get("name"));
			} else {
				resultMap.put("16", "");
			}
			resultMap.put("2", IPv4Util.longToIp(Long.parseLong(ipgkzbList.get(i).getQdjip() + "")));
			resultMap.put("4", IPv4Util.longToIp(Long.parseLong(ipgkzbList.get(i).getSip())));
			resultMap.put("5", IPv4Util.longToIp(Long.parseLong(ipgkzbList.get(i).getDip())));
			resultMap.put("6", ipgkzbList.get(i).getSport());
			resultMap.put("7", ipgkzbList.get(i).getDport());
			resultMap.put("11", TranslatingUtil.CSCXY(ipgkzbList.get(i).getProtocol()).get("name"));
			resultMap.put("3", TranslatingUtil.XXID(ipgkzbList.get(i).getDetailId()).get("name"));
			resultMap.put("17", StringUtils.isNotBlank(ipgkzbList.get(i).getMediaName())?"\""+ipgkzbList.get(i).getMediaName()+"\"":"");
			resultMap.put("20", StringUtils.isNotBlank(ipgkzbList.get(i).getMediaType())?"\""+ipgkzbList.get(i).getMediaType()+"\"":"");
			resultMap.put("21", StringUtils.isNotBlank(ipgkzbList.get(i).getMediaContent())?"\""+ipgkzbList.get(i).getMediaContent()+"\"":"");
			resultMap.put("13", TranslatingUtil.YYS(ipgkzbList.get(i).getYys()).get("name"));
			resultMap.put("18", StringUtils.isNotBlank(ipgkzbList.get(i).getMediaUrl())?"\""+ipgkzbList.get(i).getMediaUrl()+"\"":"");
			resultMap.put("19", StringUtils.isNotBlank(ipgkzbList.get(i).getUrl())?"\""+ipgkzbList.get(i).getUrl()+"\"":"");
			resultList.add(resultMap);
		}
		map = new HashMap<>();
		map.put("data", resultList);
		map.put("code", 200);
		return map;
	}

	@Override
	public Map<String, Object> HTTPGKqueryLogInfo(Map<String, Object> map) {
		ArrayList<Map<String, Object>> resultList = new ArrayList<>();
		List<HTTPGKZBLogPo> ipgkzbList = httpGKZBMapper.SelectAll(map);
		Map<Integer, Object> lhMap=TranslatingUtil.LHIDList(baseJklhMapper.SelectAll());
		Map<Integer, Object> dyMap=TranslatingUtil.YDYList(areaCodeTMapper.selectA());
//		Integer num = httpGKZBMapper.SelectCount(map);
		for (int i = 0; i < ipgkzbList.size(); i++) {
			Map<String, Object> resultMap = new HashMap<>();
			try {
				resultMap.put("12", sdf.format(sdf.parse(ipgkzbList.get(i).getBhsj())));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			resultMap.put("15", StringUtils.isNotBlank(ipgkzbList.get(i).getLabel())?"\""+ipgkzbList.get(i).getLabel()+"\"":"");
			resultMap.put("1",  StringUtils.isNotBlank(ipgkzbList.get(i).getPzid())?"\""+ipgkzbList.get(i).getPzid()+"\"":"");
			resultMap.put("10", lhMap.containsKey(ipgkzbList.get(i).getLhid())?"\""+lhMap.get(ipgkzbList.get(i).getLhid())+"\"":"未知");
			resultMap.put("8", dyMap.containsKey(ipgkzbList.get(i).getYdy())?"\""+dyMap.get(ipgkzbList.get(i).getYdy())+"\"":"未知");
			resultMap.put("9", dyMap.containsKey(ipgkzbList.get(i).getMddy())?"\""+dyMap.get(ipgkzbList.get(i).getMddy())+"\"":"未知");
			resultMap.put("14", TranslatingUtil.GKLB(ipgkzbList.get(i).getGklb()).get("name"));
			if (ipgkzbList.get(i).getYyzl() != null) {
				resultMap.put("16", TranslatingUtil.YYZL(ipgkzbList.get(i).getYyzl()).get("name"));
			} else {
				resultMap.put("16", "");
			}
			resultMap.put("2", IPv4Util.longToIp(Long.parseLong(ipgkzbList.get(i).getQdjip() + "")));
			resultMap.put("4", IPv4Util.longToIp(Long.parseLong(ipgkzbList.get(i).getSip())));
			resultMap.put("5", IPv4Util.longToIp(Long.parseLong(ipgkzbList.get(i).getDip())));
			resultMap.put("6", ipgkzbList.get(i).getSport());
			resultMap.put("7", ipgkzbList.get(i).getDport());
			resultMap.put("11", TranslatingUtil.CSCXY(ipgkzbList.get(i).getProtocol()).get("name"));
			resultMap.put("3", TranslatingUtil.XXID(ipgkzbList.get(i).getDetailId()).get("name"));
			
			resultMap.put("17", StringUtils.isNotBlank(ipgkzbList.get(i).getHost())?"\""+ipgkzbList.get(i).getHost()+"\"":"");
			resultMap.put("19", StringUtils.isNotBlank(ipgkzbList.get(i).getUserAgent())?"\""+ipgkzbList.get(i).getUserAgent()+"\"":"");
			resultMap.put("21", StringUtils.isNotBlank(ipgkzbList.get(i).getFileName())?"\""+ipgkzbList.get(i).getFileName()+"\"":"");
			resultMap.put("13", TranslatingUtil.YYS(ipgkzbList.get(i).getYys()).get("name"));
			resultMap.put("20", StringUtils.isNotBlank(ipgkzbList.get(i).getCookie())?"\""+ipgkzbList.get(i).getCookie()+"\"":"");
			resultMap.put("22", StringUtils.isNotBlank(ipgkzbList.get(i).getContent())?"\""+ipgkzbList.get(i).getContent()+"\"":"");
			resultMap.put("18", StringUtils.isNotBlank(ipgkzbList.get(i).getUrl())?"\""+ipgkzbList.get(i).getUrl()+"\"":"");
			resultList.add(resultMap);
		}
		map = new HashMap<>();
		map.put("data", resultList);
		map.put("code", 200);
		return map;
	}

	@Override
	public Map<String, Object> DNSGKqueryLogInfo(Map<String, Object> map) {
		ArrayList<Map<String, Object>> resultList = new ArrayList<>();
		List<DNSGKZBLogPo> ipgkzbList = dnsGKZBMapper.SelectAll(map);
		Map<Integer, Object> lhMap=TranslatingUtil.LHIDList(baseJklhMapper.SelectAll());
		Map<Integer, Object> dyMap=TranslatingUtil.YDYList(areaCodeTMapper.selectA());
//		Integer num = dnsGKZBMapper.SelectCount(map);
		for (int i = 0; i < ipgkzbList.size(); i++) {
			Map<String, Object> resultMap = new HashMap<>();
			try {
				resultMap.put("12", sdf.format(sdf.parse(ipgkzbList.get(i).getBhsj())));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			resultMap.put("15", StringUtils.isNotBlank(ipgkzbList.get(i).getLabel())?"\""+ipgkzbList.get(i).getLabel()+"\"":"");
			resultMap.put("1",  StringUtils.isNotBlank(ipgkzbList.get(i).getPzid())?"\""+ipgkzbList.get(i).getPzid()+"\"":"");
//			resultMap.put("3", ipgkzbList.get(i).getFlid());
//			resultMap.put("4", ipgkzbList.get(i).getXzid());
			resultMap.put("10", lhMap.containsKey(ipgkzbList.get(i).getLhid())?"\""+lhMap.get(ipgkzbList.get(i).getLhid())+"\"":"未知");
			resultMap.put("8", dyMap.containsKey(ipgkzbList.get(i).getYdy())?"\""+dyMap.get(ipgkzbList.get(i).getYdy())+"\"":"未知");
			resultMap.put("9", dyMap.containsKey(ipgkzbList.get(i).getMddy())?"\""+dyMap.get(ipgkzbList.get(i).getMddy())+"\"":"未知");
			resultMap.put("14", TranslatingUtil.GKLB(ipgkzbList.get(i).getGklb()).get("name"));
			resultMap.put("2", IPv4Util.longToIp(Long.parseLong(ipgkzbList.get(i).getQdjip() + "")));
			resultMap.put("4", IPv4Util.longToIp(Long.parseLong(ipgkzbList.get(i).getSip())));
			resultMap.put("5", IPv4Util.longToIp(Long.parseLong(ipgkzbList.get(i).getDip())));
			resultMap.put("6", ipgkzbList.get(i).getSport());
			resultMap.put("7", ipgkzbList.get(i).getDport());
			resultMap.put("11", TranslatingUtil.CSCXY(ipgkzbList.get(i).getProtocol()).get("name"));
			resultMap.put("3", TranslatingUtil.XXID(ipgkzbList.get(i).getDetailId()).get("name"));
			resultMap.put("16", StringUtils.isNotBlank(ipgkzbList.get(i).getDnsName())?"\""+ipgkzbList.get(i).getDnsName()+"\"":"");
			resultMap.put("17", StringUtils.isNotBlank(ipgkzbList.get(i).getDnsValue())?"\""+ipgkzbList.get(i).getDnsValue()+"\"":"");
			resultMap.put("13", TranslatingUtil.YYS(ipgkzbList.get(i).getYys()).get("name"));
			resultList.add(resultMap);
		}
		map = new HashMap<>();
		map.put("data", resultList);
		map.put("code", 200);
		return map;
	}

	@Override
	public Map<String, Object> SSLGKqueryLogInfo(Map<String, Object> map) {
		ArrayList<Map<String, Object>> resultList = new ArrayList<>();
		List<SSLGKZBLogPo> ipgkzbList = sslGKZBMapper.SelectAll(map);
		Map<Integer, Object> lhMap=TranslatingUtil.LHIDList(baseJklhMapper.SelectAll());
		Map<Integer, Object> dyMap=TranslatingUtil.YDYList(areaCodeTMapper.selectA());
//		Integer num = sslGKZBMapper.SelectCount(map);
		for (int i = 0; i < ipgkzbList.size(); i++) {
			Map<String, Object> resultMap = new HashMap<>();
			try {
				resultMap.put("12", sdf.format(sdf.parse(ipgkzbList.get(i).getBhsj())));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			resultMap.put("15", StringUtils.isNotBlank(ipgkzbList.get(i).getLabel())?"\""+ipgkzbList.get(i).getLabel()+"\"":"");
			resultMap.put("1",  StringUtils.isNotBlank(ipgkzbList.get(i).getPzid())?"\""+ipgkzbList.get(i).getPzid()+"\"":"");
			resultMap.put("10", lhMap.containsKey(ipgkzbList.get(i).getLhid())?"\""+lhMap.get(ipgkzbList.get(i).getLhid())+"\"":"未知");
			resultMap.put("8", dyMap.containsKey(ipgkzbList.get(i).getYdy())?"\""+dyMap.get(ipgkzbList.get(i).getYdy())+"\"":"未知");
			resultMap.put("9", dyMap.containsKey(ipgkzbList.get(i).getMddy())?"\""+dyMap.get(ipgkzbList.get(i).getMddy())+"\"":"未知");
			resultMap.put("14", TranslatingUtil.GKLB(ipgkzbList.get(i).getGklb()).get("name"));
			resultMap.put("2", IPv4Util.longToIp(Long.parseLong(ipgkzbList.get(i).getQdjip() + "")));
			resultMap.put("4", IPv4Util.longToIp(Long.parseLong(ipgkzbList.get(i).getSip())));
			resultMap.put("5", IPv4Util.longToIp(Long.parseLong(ipgkzbList.get(i).getDip())));
			resultMap.put("6", ipgkzbList.get(i).getSport());
			resultMap.put("7", ipgkzbList.get(i).getDport());
			resultMap.put("11", TranslatingUtil.CSCXY(ipgkzbList.get(i).getProtocol()).get("name"));
			resultMap.put("3", TranslatingUtil.XXID(ipgkzbList.get(i).getDetailId()).get("name"));
			resultMap.put("16", StringUtils.isNotBlank(ipgkzbList.get(i).getZsmc())?"\""+ipgkzbList.get(i).getZsmc()+"\"":"");
			resultMap.put("17", StringUtils.isNotBlank(ipgkzbList.get(i).getBfz())?"\""+ipgkzbList.get(i).getBfz()+"\"":"");
			resultMap.put("18", StringUtils.isNotBlank(ipgkzbList.get(i).getSyz())?"\""+ipgkzbList.get(i).getSyz()+"\"":"");
			resultMap.put("19", StringUtils.isNotBlank(ipgkzbList.get(i).getFwqmc())?"\""+ipgkzbList.get(i).getFwqmc()+"\"":"");
			resultMap.put("13", TranslatingUtil.YYS(ipgkzbList.get(i).getYys()).get("name"));
			resultList.add(resultMap);
		}
		map = new HashMap<>();
		map.put("data", resultList);
		map.put("code", 200);
		return map;
	}

	@Override
	public Map<String, Object> MAILGKqueryLogInfo(Map<String, Object> map) {
		ArrayList<Map<String, Object>> resultList = new ArrayList<>();
		List<MAILGKZBLogPo> ipgkzbList = mailGKZBMapper.SelectAll(map);
		Map<Integer, Object> lhMap=TranslatingUtil.LHIDList(baseJklhMapper.SelectAll());
		Map<Integer, Object> dyMap=TranslatingUtil.YDYList(areaCodeTMapper.selectA());
//		Integer num = mailGKZBMapper.SelectCount(map);
		for (int i = 0; i < ipgkzbList.size(); i++) {
			Map<String, Object> resultMap = new HashMap<>();
			try {
				resultMap.put("12", sdf.format(sdf.parse(ipgkzbList.get(i).getBhsj())));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			resultMap.put("15", StringUtils.isNotBlank(ipgkzbList.get(i).getLabel())?"\""+ipgkzbList.get(i).getLabel()+"\"":"");
			resultMap.put("1",  StringUtils.isNotBlank(ipgkzbList.get(i).getPzid())?"\""+ipgkzbList.get(i).getPzid()+"\"":"");
			resultMap.put("10", lhMap.containsKey(ipgkzbList.get(i).getLhid())?"\""+lhMap.get(ipgkzbList.get(i).getLhid())+"\"":"未知");
			resultMap.put("8", dyMap.containsKey(ipgkzbList.get(i).getYdy())?"\""+dyMap.get(ipgkzbList.get(i).getYdy())+"\"":"未知");
			resultMap.put("9", dyMap.containsKey(ipgkzbList.get(i).getMddy())?"\""+dyMap.get(ipgkzbList.get(i).getMddy())+"\"":"未知");
			resultMap.put("14", TranslatingUtil.GKLB(ipgkzbList.get(i).getGklb()).get("name"));
			if (ipgkzbList.get(i).getYyzl() != null) {
				resultMap.put("16", TranslatingUtil.YYZL(ipgkzbList.get(i).getYyzl()).get("name"));
			} else {
				resultMap.put("16", "");
			}
			resultMap.put("2", IPv4Util.longToIp(Long.parseLong(ipgkzbList.get(i).getQdjip() + "")));
			resultMap.put("4", IPv4Util.longToIp(Long.parseLong(ipgkzbList.get(i).getSip())));
			resultMap.put("5", IPv4Util.longToIp(Long.parseLong(ipgkzbList.get(i).getDip())));
			resultMap.put("6", ipgkzbList.get(i).getSport());
			resultMap.put("7", ipgkzbList.get(i).getDport());
			resultMap.put("11", TranslatingUtil.CSCXY(ipgkzbList.get(i).getProtocol()).get("name"));
			resultMap.put("3", TranslatingUtil.XXID(ipgkzbList.get(i).getDetailId()).get("name"));
			resultMap.put("17", StringUtils.isNotBlank(ipgkzbList.get(i).getMailSender())?"\""+ipgkzbList.get(i).getMailSender()+"\"":"");
			resultMap.put("19", ipgkzbList.get(i).getReceverNum()!=null?ipgkzbList.get(i).getReceverNum():"");
			resultMap.put("21", ipgkzbList.get(i).getCcNum()!=null?ipgkzbList.get(i).getCcNum():"");
			resultMap.put("22", StringUtils.isNotBlank(ipgkzbList.get(i).getMailSubject())?"\""+ipgkzbList.get(i).getMailSubject()+"\"":"");
			resultMap.put("24", ipgkzbList.get(i).getAccessory()!=null?ipgkzbList.get(i).getAccessory():"");
			resultMap.put("25", StringUtils.isNotBlank(ipgkzbList.get(i).getFileName())?"\""+ipgkzbList.get(i).getFileName()+"\"":"");
			resultMap.put("26", StringUtils.isNotBlank(ipgkzbList.get(i).getFileContent())?"\""+ipgkzbList.get(i).getFileContent()+"\"":"");
			resultMap.put("27", StringUtils.isNotBlank(ipgkzbList.get(i).getPwd())?"\""+ipgkzbList.get(i).getPwd()+"\"":"");
			resultMap.put("28", StringUtils.isNotBlank(ipgkzbList.get(i).getFjfws())?"\""+ipgkzbList.get(i).getFjfws()+"\"":"");
			resultMap.put("29", ipgkzbList.get(i).getFjfwsSzd()!=null?ipgkzbList.get(i).getFjfwsSzd():"");
			resultMap.put("30", StringUtils.isNotBlank(ipgkzbList.get(i).getSjfws())?"\""+ipgkzbList.get(i).getSjfws()+"\"":"");
			resultMap.put("31", StringUtils.isNotBlank(ipgkzbList.get(i).getSjfwsSzd())?"\""+ipgkzbList.get(i).getSjfwsSzd()+"\"":"");
			resultMap.put("32", StringUtils.isNotBlank(ipgkzbList.get(i).getXylx())?"\""+ipgkzbList.get(i).getXylx()+"\"":"");
			resultMap.put("33", StringUtils.isNotBlank(ipgkzbList.get(i).getGjz())?"\""+ipgkzbList.get(i).getGjz()+"\"":"");
			resultMap.put("13", TranslatingUtil.YYS(ipgkzbList.get(i).getYys()).get("name"));
			resultMap.put("18", StringUtils.isNotBlank(ipgkzbList.get(i).getMailRecever())?"\""+ipgkzbList.get(i).getMailRecever()+"\"":"");
			resultMap.put("20", StringUtils.isNotBlank(ipgkzbList.get(i).getMailCc())?"\""+ipgkzbList.get(i).getMailCc()+"\"":"");
			resultMap.put("23", StringUtils.isNotBlank(ipgkzbList.get(i).getContent())?"\""+ipgkzbList.get(i).getContent()+"\"":"");
			resultList.add(resultMap);
		}
		map = new HashMap<>();
		map.put("data", resultList);
		map.put("code", 200);
		return map;
	}

	@Override
	public Map<String, Object> JSTXGKqueryLogInfo(Map<String, Object> map) {
		ArrayList<Map<String, Object>> resultList = new ArrayList<>();
		List<JSTXGKZBLogPo> ipgkzbList = jstxGKZBMapper.SelectAll(map);
		Map<Integer, Object> lhMap=TranslatingUtil.LHIDList(baseJklhMapper.SelectAll());
		Map<Integer, Object> dyMap=TranslatingUtil.YDYList(areaCodeTMapper.selectA());
//		Integer num = jstxGKZBMapper.SelectCount(map);
		for (int i = 0; i < ipgkzbList.size(); i++) {
			Map<String, Object> resultMap = new HashMap<>();
			try {
				resultMap.put("12", sdf.format(sdf.parse(ipgkzbList.get(i).getBhsj())));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			resultMap.put("15", StringUtils.isNotBlank(ipgkzbList.get(i).getLabel())?"\""+ipgkzbList.get(i).getLabel()+"\"":"");
			resultMap.put("1",  StringUtils.isNotBlank(ipgkzbList.get(i).getPzid())?"\""+ipgkzbList.get(i).getPzid()+"\"":"");
			resultMap.put("10", lhMap.containsKey(ipgkzbList.get(i).getLhid())?"\""+lhMap.get(ipgkzbList.get(i).getLhid())+"\"":"未知");
			resultMap.put("8", dyMap.containsKey(ipgkzbList.get(i).getYdy())?"\""+dyMap.get(ipgkzbList.get(i).getYdy())+"\"":"未知");
			resultMap.put("9", dyMap.containsKey(ipgkzbList.get(i).getMddy())?"\""+dyMap.get(ipgkzbList.get(i).getMddy())+"\"":"未知");
			resultMap.put("14", TranslatingUtil.GKLB(ipgkzbList.get(i).getGklb()).get("name"));
			if (ipgkzbList.get(i).getYyzl() != null) {
				resultMap.put("16", TranslatingUtil.YYZL(ipgkzbList.get(i).getYyzl()).get("name"));
			} else {
				resultMap.put("16", "");
			}
			resultMap.put("2", IPv4Util.longToIp(Long.parseLong(ipgkzbList.get(i).getQdjip() + "")));
			resultMap.put("4", IPv4Util.longToIp(Long.parseLong(ipgkzbList.get(i).getSip())));
			resultMap.put("5", IPv4Util.longToIp(Long.parseLong(ipgkzbList.get(i).getDip())));
			resultMap.put("6", ipgkzbList.get(i).getSport());
			resultMap.put("7", ipgkzbList.get(i).getDport());
			resultMap.put("11", TranslatingUtil.CSCXY(ipgkzbList.get(i).getProtocol()).get("name"));
			resultMap.put("3", TranslatingUtil.XXID(ipgkzbList.get(i).getDetailId()).get("name"));
			resultMap.put("17", StringUtils.isNotBlank(ipgkzbList.get(i).getDzId())?"\""+ipgkzbList.get(i).getDzId()+"\"":"");
			resultMap.put("18", StringUtils.isNotBlank(ipgkzbList.get(i).getHost())?"\""+ipgkzbList.get(i).getHost()+"\"":"");
			resultMap.put("20", StringUtils.isNotBlank(ipgkzbList.get(i).getUserAgent())?"\""+ipgkzbList.get(i).getUserAgent()+"\"":"");
			resultMap.put("21", StringUtils.isNotBlank(ipgkzbList.get(i).getUserId())?"\""+ipgkzbList.get(i).getUserId()+"\"":"");
			resultMap.put("23", StringUtils.isNotBlank(ipgkzbList.get(i).getReserved())?"\""+ipgkzbList.get(i).getReserved()+"\"":"");
			resultMap.put("13", TranslatingUtil.YYS(ipgkzbList.get(i).getYys()).get("name"));
			resultMap.put("19", StringUtils.isNotBlank(ipgkzbList.get(i).getUrl())?"\""+ipgkzbList.get(i).getUrl()+"\"":"");
			resultMap.put("22", StringUtils.isNotBlank(ipgkzbList.get(i).getContent())?"\""+ipgkzbList.get(i).getContent()+"\"":"");
			resultList.add(resultMap);
		}
		map = new HashMap<>();
		map.put("data", resultList);
		map.put("code", 200);
		return map;
	}

	@Override
	public Map<String, Object> VPNGKqueryLogInfo(Map<String, Object> map) {
		ArrayList<Map<String, Object>> resultList = new ArrayList<>();
		
		List<VPNGKZBLogPo> ipgkzbList = vpnGKZBMapper.SelectAll(map);
		Map<Integer, Object> lhMap=TranslatingUtil.LHIDList(baseJklhMapper.SelectAll());
		Map<Integer, Object> dyMap=TranslatingUtil.YDYList(areaCodeTMapper.selectA());
//		Integer num = vpnGKZBMapper.SelectCount(map);
		for (int i = 0; i < ipgkzbList.size(); i++) {
			Map<String, Object> resultMap = new HashMap<>();
			try {
				resultMap.put("12", sdf.format(sdf.parse(ipgkzbList.get(i).getBhsj())));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			resultMap.put("15", StringUtils.isNotBlank(ipgkzbList.get(i).getLabel())?"\""+ipgkzbList.get(i).getLabel()+"\"":"");
			resultMap.put("1",  StringUtils.isNotBlank(ipgkzbList.get(i).getPzid())?"\""+ipgkzbList.get(i).getPzid()+"\"":"");
			resultMap.put("10", lhMap.containsKey(ipgkzbList.get(i).getLhid())?"\""+lhMap.get(ipgkzbList.get(i).getLhid())+"\"":"未知");
			resultMap.put("8", dyMap.containsKey(ipgkzbList.get(i).getYdy())?"\""+dyMap.get(ipgkzbList.get(i).getYdy())+"\"":"未知");
			resultMap.put("9", dyMap.containsKey(ipgkzbList.get(i).getMddy())?"\""+dyMap.get(ipgkzbList.get(i).getMddy())+"\"":"未知");
			resultMap.put("14", TranslatingUtil.GKLB(ipgkzbList.get(i).getGklb()).get("name"));
			resultMap.put("2", IPv4Util.longToIp(Long.parseLong(ipgkzbList.get(i).getQdjip() + "")));
			resultMap.put("4", IPv4Util.longToIp(Long.parseLong(ipgkzbList.get(i).getSip())));
			resultMap.put("5", IPv4Util.longToIp(Long.parseLong(ipgkzbList.get(i).getDip())));
			resultMap.put("6", ipgkzbList.get(i).getSport());
			resultMap.put("7", ipgkzbList.get(i).getDport());
			resultMap.put("11", TranslatingUtil.CSCXY(ipgkzbList.get(i).getProtocol()).get("name"));
			resultMap.put("3", TranslatingUtil.XXID(ipgkzbList.get(i).getDetailId()).get("name"));
			resultMap.put("17", StringUtils.isNotBlank(ipgkzbList.get(i).getUsername())?"\""+ipgkzbList.get(i).getUsername()+"\"":"");
			resultMap.put("18", StringUtils.isNotBlank(ipgkzbList.get(i).getPwd())?"\""+ipgkzbList.get(i).getPwd()+"\"":"");
			resultMap.put("13", TranslatingUtil.YYS(ipgkzbList.get(i).getYys()).get("name"));
			resultMap.put("16", StringUtils.isNotBlank(ipgkzbList.get(i).getUrl())?"\""+ipgkzbList.get(i).getUrl()+"\"":"");
			resultList.add(resultMap);
		}
		map = new HashMap<>();
		map.put("data", resultList);
		map.put("code", 200);
		return map;
	}

	@Override
	public Map<String, Object> WYGJCGKqueryLogInfo(Map<String, Object> map) {
		
		ArrayList<Map<String, Object>> resultList = new ArrayList<>();
		
		List<WYGJCGKRZLogPo> ipgkzbList = wygjGKZBMapper.SelectAll(map);
		Map<Integer, Object> lhMap=TranslatingUtil.LHIDList(baseJklhMapper.SelectAll());
		Map<Integer, Object> dyMap=TranslatingUtil.YDYList(areaCodeTMapper.selectA());
//		Integer num = wygjGKZBMapper.SelectCount(map);
		for (int i = 0; i < ipgkzbList.size(); i++) {
			Map<String, Object> resultMap = new HashMap<>();
			try {
				resultMap.put("12", sdf.format(sdf.parse(ipgkzbList.get(i).getBhsj())));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			resultMap.put("15", StringUtils.isNotBlank(ipgkzbList.get(i).getLabel())?"\""+ipgkzbList.get(i).getLabel()+"\"":"");
			resultMap.put("1",  StringUtils.isNotBlank(ipgkzbList.get(i).getPzid())?"\""+ipgkzbList.get(i).getPzid()+"\"":"");
			resultMap.put("10", lhMap.containsKey(ipgkzbList.get(i).getLhid())?"\""+lhMap.get(ipgkzbList.get(i).getLhid())+"\"":"未知");
			resultMap.put("8", dyMap.containsKey(ipgkzbList.get(i).getYdy())?"\""+dyMap.get(ipgkzbList.get(i).getYdy())+"\"":"未知");
			resultMap.put("9", dyMap.containsKey(ipgkzbList.get(i).getMddy())?"\""+dyMap.get(ipgkzbList.get(i).getMddy())+"\"":"未知");
			resultMap.put("14", TranslatingUtil.GKLB(ipgkzbList.get(i).getGklb()).get("name"));
			if (ipgkzbList.get(i).getYyzl() != null) {
				resultMap.put("16", TranslatingUtil.YYZL(ipgkzbList.get(i).getYyzl()).get("name"));
			} else {
				resultMap.put("16", "");
			}
			resultMap.put("2", IPv4Util.longToIp(Long.parseLong(ipgkzbList.get(i).getQdjip() + "")));
			resultMap.put("4", IPv4Util.longToIp(Long.parseLong(ipgkzbList.get(i).getSip())));
			resultMap.put("5", IPv4Util.longToIp(Long.parseLong(ipgkzbList.get(i).getDip())));
			resultMap.put("6", ipgkzbList.get(i).getSport());
			resultMap.put("7", ipgkzbList.get(i).getDport());
			resultMap.put("11", TranslatingUtil.CSCXY(ipgkzbList.get(i).getProtocol()).get("name"));
			resultMap.put("3", TranslatingUtil.XXID(ipgkzbList.get(i).getDetailId()).get("name"));
			resultMap.put("19", StringUtils.isNotBlank(ipgkzbList.get(i).getSsyq())?"\""+ipgkzbList.get(i).getSsyq()+"\"":"");
			resultMap.put("20", StringUtils.isNotBlank(ipgkzbList.get(i).getGjz())?"\""+ipgkzbList.get(i).getGjz()+"\"":"");
			resultMap.put("13", TranslatingUtil.YYS(ipgkzbList.get(i).getYys()).get("name"));
			resultMap.put("17", StringUtils.isNotBlank(ipgkzbList.get(i).getJcUrl())?"\""+ipgkzbList.get(i).getJcUrl()+"\"":"");
			resultMap.put("18", StringUtils.isNotBlank(ipgkzbList.get(i).getContent())?"\""+ipgkzbList.get(i).getContent()+"\"":"");
			resultList.add(resultMap);
		}
		map = new HashMap<>();
		map.put("data", resultList);
		map.put("code", 200);
		return map;
	}

	@Override
	public Map<String, Object> FTPGJCGKqueryLogInfo(Map<String, Object> map) {
		ArrayList<Map<String, Object>> resultList = new ArrayList<>();
		List<FTPGKZBLogPo> ipgkzbList = ftpGKZBMapper.SelectAll(map);
		Map<Integer, Object> lhMap=TranslatingUtil.LHIDList(baseJklhMapper.SelectAll());
		Map<Integer, Object> dyMap=TranslatingUtil.YDYList(areaCodeTMapper.selectA());
//		Integer num = ftpGKZBMapper.SelectCount(map);
		for (int i = 0; i < ipgkzbList.size(); i++) {
			Map<String, Object> resultMap = new HashMap<>();
			try {
				resultMap.put("12", sdf.format(sdf.parse(ipgkzbList.get(i).getBhsj())));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			resultMap.put("15", StringUtils.isNotBlank(ipgkzbList.get(i).getLabel())?"\""+ipgkzbList.get(i).getLabel()+"\"":"");
			resultMap.put("1",  StringUtils.isNotBlank(ipgkzbList.get(i).getPzid())?"\""+ipgkzbList.get(i).getPzid()+"\"":"");
			resultMap.put("10", lhMap.containsKey(ipgkzbList.get(i).getLhid())?"\""+lhMap.get(ipgkzbList.get(i).getLhid())+"\"":"未知");
			resultMap.put("8", dyMap.containsKey(ipgkzbList.get(i).getYdy())?"\""+dyMap.get(ipgkzbList.get(i).getYdy())+"\"":"未知");
			resultMap.put("9", dyMap.containsKey(ipgkzbList.get(i).getMddy())?"\""+dyMap.get(ipgkzbList.get(i).getMddy())+"\"":"未知");
			resultMap.put("14", TranslatingUtil.GKLB(ipgkzbList.get(i).getGklb()).get("name"));
			if (ipgkzbList.get(i).getYyzl() != null) {
				resultMap.put("16", TranslatingUtil.YYZL(ipgkzbList.get(i).getYyzl()).get("name"));
			} else {
				resultMap.put("16", "");
			}
			resultMap.put("2", IPv4Util.longToIp(Long.parseLong(ipgkzbList.get(i).getQdjip() + "")));
			resultMap.put("4", IPv4Util.longToIp(Long.parseLong(ipgkzbList.get(i).getSip())));
			resultMap.put("5", IPv4Util.longToIp(Long.parseLong(ipgkzbList.get(i).getDip())));
			resultMap.put("6", ipgkzbList.get(i).getSport());
			resultMap.put("7", ipgkzbList.get(i).getDport());
			resultMap.put("11", TranslatingUtil.CSCXY(ipgkzbList.get(i).getProtocol()).get("name"));
			resultMap.put("3", TranslatingUtil.XXID(ipgkzbList.get(i).getDetailId()).get("name"));
			resultMap.put("17", StringUtils.isNotBlank(ipgkzbList.get(i).getFileName())?"\""+ipgkzbList.get(i).getFileName()+"\"":"");
			resultMap.put("18", StringUtils.isNotBlank(ipgkzbList.get(i).getFileContent())?"\""+ipgkzbList.get(i).getFileContent()+"\"":"");
			resultMap.put("19", StringUtils.isNotBlank(ipgkzbList.get(i).getGjz())?"\""+ipgkzbList.get(i).getGjz()+"\"":"");
			resultMap.put("13", TranslatingUtil.YYS(ipgkzbList.get(i).getYys()).get("name"));
			resultList.add(resultMap);
		}
		map = new HashMap<>();
		map.put("data", resultList);
		map.put("code", 200);
		return map;
	}

	@Override
	public int SelectCount(Map<String, Object> map,int logType) {
        if (logType==101) {
			
		} else if (logType==201) {
			return iPGKZBMapper.SelectCount(map);
		} else if (logType==301) {
			
		} else if (logType==103) {
			
		} else if (logType==303) {
			
		} else if (logType==402) {
			return dnsGKZBMapper.SelectCount(map);
		} else if (logType==403) {
			return  httpGKZBMapper.SelectCount(map);
		} else if (logType==404) {
			return  httpGKZBMapper.SelectCount(map);
		} else if (logType==405) {
			return  sslGKZBMapper.SelectCount(map);
		} else if (logType==406) {
			return   wygjGKZBMapper.SelectCount(map);
		} else if (logType==407) {
			return mailGKZBMapper.SelectCount(map);
		} else if (logType==408) {
			return   ftpGKZBMapper.SelectCount(map);
		} else if (logType==409) {
			return  wygjGKZBMapper.SelectCount(map);
		} else if (logType==410) {
			return   mailGKZBMapper.SelectCount(map);
		} else if (logType==411) {
			return  vpnGKZBMapper.SelectCount(map);
		} else if (logType==412) {
			return   jstxGKZBMapper.SelectCount(map);
		} else if (logType==413) {
			return  jstxGKZBMapper.SelectCount(map);
		} else if (logType==501) {
			return  ipJCZBMapper.SelectCount(map);
		} else if (logType==502) {
			return  dnsJCZBMapper.SelectCount(map);
		} else if (logType==503) {
			return   httpJCZBMapper.SelectCount(map);
		} else if (logType==504) {
			return   httpJCZBMapper.SelectCount(map);
		} else if (logType==505) {
			return   sslJCZBMapper.SelectCount(map);
		} else if (logType==506) {
			return  wtgjcJCRZMapper.SelectCount(map);
		} else if (logType==507) {
			return  mailJCZBMapper.SelectCount(map);
		} else if (logType==508) {
			return  ftpJCZBMapper.SelectCount(map);
		} else if (logType==509) {
			return  wtgjcJCRZMapper.SelectCount(map);
		} else if (logType==510) {
			return  mailJCZBMapper.SelectCount(map);
		} else if (logType==511) {
			return   vpnJCZBMapper.SelectCount(map);
		} else if (logType==512) {
			return  jstxJCZBMapper.SelectCount(map);
		} else if (logType==513) {
			return  jstxJCZBMapper.SelectCount(map);
		} else if (logType==514) {
			return   picJCZBMapper.SelectCount(map);
		} else if (logType==515) {
			return  mediaJCZBMapper.SelectCount(map);
		} else if (logType==601) {
			
		} else if (logType==701) {
			
		} else if (logType==702) {
			
		} else {
			
		}
		return 0;
	}

}
