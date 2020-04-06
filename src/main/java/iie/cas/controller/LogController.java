package iie.cas.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import iie.cas.service.LogService;

@RestController
@RequestMapping("log")
public class LogController {

	@Autowired
	private LogService logService;

	/**
	 * 
	 * @param startTime 起始时间
	 * @param endTime   截止时间
	 * @param pzid      配置ID
	 * @param label     标签
	 * @param lhid      来函ID
	 * @param ydy       源地域
	 * @param mddy      目的地域
	 * @param pzlx      配置类型
	 * @param gklb      管控类别
	 * @param protocol  传输协议
	 * @param sip       源地址
	 * @param dip       目的地址
	 * @param sport     源端口
	 * @param dport     目的端口
	 * @param pageNo    当前页数
	 * @param pageSize  每页日志数
	 * @param logType   日志类型
	 * @return
	 */
	@RequestMapping("/queryLogInfo")
	public Map<String, Object> queryLogInfo(String startTime, String pzid, String label, String lhid, String ydy,
			String mddy, String pzlx, String gklb, String protocol, String sip, String dip,
			@RequestParam(value = "sport", required = false, defaultValue = "80") int sport,
			@RequestParam(value = "dport", required = false, defaultValue = "80") int dport,
			@RequestParam(value = "pageNo", required = true, defaultValue = "1") int pageNo,
			@RequestParam(value = "pageSize", required = true, defaultValue = "10") int pageSize, String logType,
			String endTime) {
		return logService.queryLogInfo(startTime, pzid, label, lhid, ydy, mddy, pzlx, gklb, protocol, sip, dip, sport,
				dport, pageNo, pageSize, logType, endTime);
	}
}
