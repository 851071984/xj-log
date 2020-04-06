package iie.cas.service;

import java.util.Map;

public interface MonitoringLogDownService {
	// HTTP监测日志
	public Map<String, Object> HTTPJCqueryLogInfo(Map<String, Object> map);

	// DNS监测日志
	public Map<String, Object> DNSJCqueryLogInfo(Map<String, Object> map);

	// SSL监测日志
	public Map<String, Object> SSLJCqueryLogInfo(Map<String, Object> map);

	// MAIL监测日志
	public Map<String, Object> MAILJCqueryLogInfo(Map<String, Object> map);

	// 即时通信监测日志
	public Map<String, Object> JSTXJCqueryLogInfo(Map<String, Object> map);

	// VPN监测
	public Map<String, Object> VPNJCqueryLogInfo(Map<String, Object> map);

	// FTP关键词监测
	public Map<String, Object> FTPGJCJCqueryLogInfo(Map<String, Object> map);

	// 网页关键词监测
	public Map<String, Object> WYGJCJCqueryLogInfo(Map<String, Object> map);

	// IP监测日志
	public Map<String, Object> IPJCqueryLogInfo(Map<String, Object> map);

	// 图片监测
	public Map<String, Object> TPJCqueryLogInfo(Map<String, Object> map);

	// 多媒体监测
	public Map<String, Object> DMTJCqueryLogInfo(Map<String, Object> map);

	// HTTP管控
	public Map<String, Object> HTTPGKqueryLogInfo(Map<String, Object> map);

	// DNS管控
	public Map<String, Object> DNSGKqueryLogInfo(Map<String, Object> map);

	// SSL管控
	public Map<String, Object> SSLGKqueryLogInfo(Map<String, Object> map);

	// MAIL管控表(MAIL关键字管控)
	public Map<String, Object> MAILGKqueryLogInfo(Map<String, Object> map);

	// 即时通信管控
	public Map<String, Object> JSTXGKqueryLogInfo(Map<String, Object> map);

	// VPN管控
	public Map<String, Object> VPNGKqueryLogInfo(Map<String, Object> map);

	// 网页关键词管控
	public Map<String, Object> WYGJCGKqueryLogInfo(Map<String, Object> map);

	// FTP关键词管控
	public Map<String, Object> FTPGJCGKqueryLogInfo(Map<String, Object> map);

	// 黑名单管控
	public Map<String, Object> IPHMDqueryLogInfo(Map<String, Object> map);
	public int SelectCount(Map<String, Object> map,int logType);

}
