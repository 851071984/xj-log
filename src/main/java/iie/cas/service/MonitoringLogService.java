package iie.cas.service;

import java.util.List;
import java.util.Map;

/**
 * 监测日志查询
 * 
 * @author yang
 *
 */
public interface MonitoringLogService {
	// HTTP监测日志
	public Map<String, Object> HTTPJCqueryLogInfo(String startTime, String PZID, String label, String LHID, String YDY,
			String MDDY, Integer PZLX, String GKLB, String PROTOCOL, String SIP, String DIP, Integer SPORT, Integer DPORT,
			Integer pageNo, Integer pageSize, String logType, String endTime, String qdjip, String fileName, Integer scBytes,
			String content, String host, Integer csPkts, String cookie, String yyzl, String userAgent, String url,
			Integer csBytes, Integer scPkts,String yys,int type,List<String> list);

	// DNS监测日志
	public Map<String, Object> DNSJCqueryLogInfo(String startTime, String PZID, String label, String LHID, String YDY,
			String MDDY, Integer PZLX, String GKLB, String PROTOCOL, String SIP, String DIP, Integer SPORT, Integer DPORT,
			Integer pageNo, Integer pageSize, String logType, String endTime, String qdjip, String dnsValue, String dnsName,
			Integer scBytes, Integer csPkts, Integer csBytes, Integer scPkts,String yys,int type,List<String> list);

	// SSL监测日志
	public Map<String, Object> SSLJCqueryLogInfo(String startTime, String PZID, String label, String LHID, String YDY,
			String MDDY, Integer PZLX, String GKLB, String PROTOCOL, String SIP, String DIP, Integer SPORT, Integer DPORT,
			Integer pageNo, Integer pageSize, String logType, String endTime, String qdjip, String fwqmc, Integer scBytes,
			String syz, Integer csPkts, String zsmc, String bfz, Integer csBytes, Integer scPkts,String yys,int type,List<String> list);

	// MAIL监测日志
	public Map<String, Object> MAILJCqueryLogInfo(String startTime, String PZID, String label, String LHID, String YDY,
			String MDDY, Integer PZLX, String GKLB, String PROTOCOL, String SIP, String DIP, Integer SPORT, Integer DPORT,
			Integer pageNo, Integer pageSize, String logType, String endTime, String qdjip, String fileName, String receverNum,
			String mailRecever, Integer scBytes, String sjfws, String content, String mailSubject, String mailSender,
			String sjfwsSzd, Integer csPkts, String fjfwsSzd, String ccNum, String yyzl, String fjfws, String xylx, String gjz,
			Integer csBytes, Integer scPkts, String pwd, String accessory, String fileContent, String mailCc,String yys,int type,List<String> list);

	// 即时通信监测日志
	public Map<String, Object> JSTXJCqueryLogInfo(String startTime, String PZID, String label, String LHID, String YDY,
			String MDDY, Integer PZLX, String GKLB, String PROTOCOL, String SIP, String DIP, Integer SPORT, Integer DPORT,
			Integer pageNo, Integer pageSize, String logType, String endTime, String qdjip, Integer scBytes, String content,
			String host, Integer csPkts, String yyzl, String userAgent, String userId, String url, String reserved,
			Integer csBytes, Integer scPkts, String dzId,String yys,int type,List<String> list);

	// VPN监测
	public Map<String, Object> VPNJCqueryLogInfo(String startTime, String PZID, String label, String LHID, String YDY,
			String MDDY, Integer PZLX, String GKLB, String PROTOCOL, String SIP, String DIP, Integer SPORT, Integer DPORT,
			Integer pageNo, Integer pageSize, String logType, String endTime, String qdjip, Integer scBytes, Integer csPkts, String url,
			Integer csBytes, Integer scPkts, String pwd, String username,String yys,int type,List<String> list);

	// FTP关键词监测
	public Map<String, Object> FTPGJCJCqueryLogInfo(String startTime, String PZID, String label, String LHID,
			String YDY, String MDDY, Integer PZLX, String GKLB, String PROTOCOL, String SIP, String DIP, Integer SPORT,
			Integer DPORT, Integer pageNo, Integer pageSize, String logType, String endTime, String qdjip, String fileName,
			Integer scBytes, Integer csPkts, String yyzl, String gjz, Integer csBytes, Integer scPkts, String fileContent,String yys,int type,List<String> list);

	// 网页关键词监测
	public Map<String, Object> WYGJCJCqueryLogInfo(String startTime, String PZID, String label, String LHID, String YDY,
			String MDDY, Integer PZLX, String GKLB, String PROTOCOL, String SIP, String DIP, Integer SPORT, Integer DPORT,
			Integer pageNo, Integer pageSize, String logType, String endTime, String qdjip, Integer scBytes, String ssyq,
			String content, Integer csPkts, String yyzl, String jcUrl, String gjz, Integer csBytes, Integer scPkts,String yys,int type,List<String> list);

	// IP监测日志
	public Map<String, Object> IPJCqueryLogInfo(String startTime, String PZID, String label, String LHID, String YDY,
			String MDDY, Integer PZLX, String GKLB, String PROTOCOL, String SIP, String DIP, Integer SPORT, Integer DPORT,
			Integer pageNo, Integer pageSize, String logType, String endTime, String qdjip, Integer scBytes, String content,
			String host, Integer csPkts, String url, Integer csBytes, Integer scPkts,String yys,int type,List<String> list);

	// 图片监测
	public Map<String, Object> TPJCqueryLogInfo(String startTime, String PZID, String label, String LHID, String YDY,
			String MDDY, Integer PZLX, String GKLB, String PROTOCOL, String SIP, String DIP, Integer SPORT, Integer DPORT,
			Integer pageNo, Integer pageSize, String logType, String endTime, String qdjip, String picName, Integer scBytes,
			String picUrl, Integer csPkts, String picType, String yyzl, String url, String picContent, Integer csBytes,
			Integer scPkts,String yys,int type,List<String> list);

	// 多媒体监测
	public Map<String, Object> DMTJCqueryLogInfo(String startTime, String PZID, String label, String LHID, String YDY,
			String MDDY, Integer PZLX, String GKLB, String PROTOCOL, String SIP, String DIP, Integer SPORT, Integer DPORT,
			Integer pageNo, Integer pageSize, String logType, String endTime, String qdjip, Integer scBytes, String mediaContent,
			String mediaName, Integer csPkts, String mediaUrl, String yyzl, String mediaType, String url, Integer csBytes,
			Integer scPkts,String yys,int type,List<String> list);

	// HTTP管控
	public Map<String, Object> HTTPGKqueryLogInfo(String startTime, String PZID, String label, String LHID, String YDY,
			String MDDY, Integer PZLX, String GKLB, String PROTOCOL, String SIP, String DIP, Integer SPORT, Integer DPORT,
			Integer pageNo, Integer pageSize, String logType, String endTime, String qdjip, String fileName, String content,
			String host, String cookie, String yyzl, String userAgent, String url,String yys,int type,List<String> list);

	// DNS管控
	public Map<String, Object> DNSGKqueryLogInfo(String startTime, String PZID, String label, String LHID, String YDY,
			String MDDY, Integer PZLX, String GKLB, String PROTOCOL, String SIP, String DIP, Integer SPORT, Integer DPORT,
			Integer pageNo, Integer pageSize, String logType, String endTime, String qdjip, String dnsValue, String dnsName,String yys,int type,List<String> list);

	// SSL管控
	public Map<String, Object> SSLGKqueryLogInfo(String startTime, String PZID, String label, String LHID, String YDY,
			String MDDY, Integer PZLX, String GKLB, String PROTOCOL, String SIP, String DIP, Integer SPORT, Integer DPORT,
			Integer pageNo, Integer pageSize, String logType, String endTime, String qdjip, String fwqmc, String syz,
			String zsmc, String bfz,String yys,int type,List<String> list);

	// MAIL管控表(MAIL关键字管控)
	public Map<String, Object> MAILGKqueryLogInfo(String startTime, String PZID, String label, String LHID, String YDY,
			String MDDY, Integer PZLX, String GKLB, String PROTOCOL, String SIP, String DIP, Integer SPORT, Integer DPORT,
			Integer pageNo, Integer pageSize, String logType, String endTime, String qdjip, String fileName, String receverNum,
			String mailRecever, String sjfws, String content, String mailSubject, String mailSender, String sjfwsSzd,
			String fjfwsSzd, String ccNum, String yyzl, String fjfws, String xylx, String gjz, String pwd,
			String accessory, String fileContent, String mailCc,String yys,int type,List<String> list);

	// 即时通信管控
	public Map<String, Object> JSTXGKqueryLogInfo(String startTime, String PZID, String label, String LHID, String YDY,
			String MDDY, Integer PZLX, String GKLB, String PROTOCOL, String SIP, String DIP, Integer SPORT, Integer DPORT,
			Integer pageNo, Integer pageSize, String logType, String endTime, String qdjip, String content, String host,
			String yyzl, String userAgent, String userId, String url, String reserved, String dzId,String yys,int type,List<String> list);

	// VPN管控
	public Map<String, Object> VPNGKqueryLogInfo(String startTime, String PZID, String label, String LHID, String YDY,
			String MDDY, Integer PZLX, String GKLB, String PROTOCOL, String SIP, String DIP, Integer SPORT, Integer DPORT,
			Integer pageNo, Integer pageSize, String logType, String endTime, String qdjip, String url, String pwd,
			String username,String yys,int type,List<String> list);

	// 网页关键词管控
	public Map<String, Object> WYGJCGKqueryLogInfo(String startTime, String PZID, String label, String LHID, String YDY,
			String MDDY, Integer PZLX, String GKLB, String PROTOCOL, String SIP, String DIP, Integer SPORT, Integer DPORT,
			Integer pageNo, Integer pageSize, String logType, String endTime, String qdjip, String ssyq, String content,
			String yyzl, String jcUrl, String gjz,String yys,int type,List<String> list);

	// FTP关键词管控
	public Map<String, Object> FTPGJCGKqueryLogInfo(String startTime, String PZID, String label, String LHID,
			String YDY, String MDDY, Integer PZLX, String GKLB, String PROTOCOL, String SIP, String DIP, Integer SPORT,
			Integer DPORT, Integer pageNo, Integer pageSize, String logType, String endTime, String qdjip, String fileName,
			String yyzl, String gjz, String fileContent,String yys,int type,List<String> list);

	// 黑名单管控
	public Map<String, Object> IPHMDqueryLogInfo(String startTime, String PZID, String label, String LHID, String YDY,
			String MDDY, Integer PZLX, String GKLB, String PROTOCOL, String SIP, String DIP, Integer SPORT, Integer DPORT,
			Integer pageNo, Integer pageSize, String logType, String endTime, String qdjip,String yys,int type,List<String> list);

}
