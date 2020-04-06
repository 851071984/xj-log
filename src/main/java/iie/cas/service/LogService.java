package iie.cas.service;

import java.util.Map;

public interface LogService {

	public Map<String, Object> queryLogInfo(String startTime, String PZID, String label, String LHID, String YDY,
			String MDDY, String PZLX, String GKLB, String PROTOCOL, String SIP, String DIP, int SPORT, int DPORT,
			int pageNo, int pageSize, String logType, String endTime);
}
