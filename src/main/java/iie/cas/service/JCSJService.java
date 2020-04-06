package iie.cas.service;

import java.util.Map;

public interface JCSJService {
	public Map<String, Object> ActionJCSJ(String name);
	public Map<String, Object> DYJCSJ(String name);
	public Map<String, Object> DownCSV(int pageNo,int pageSize,String logType,String userName);

}
