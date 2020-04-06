package iie.cas.service.impl;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;

import iie.cas.po.IPHMDLogPo;
import iie.cas.service.LogService;
import iie.cas.util.IPv4Util;
import iie.cas.vo.IPLogVo;

@Service
public class LogServiceImpl implements LogService {

	@Override
	public Map<String, Object> queryLogInfo(String startTime, String PZID, String label, String LHID, String YDY,
			String MDDY, String PZLX, String GKLB, String PROTOCOL, String SIP, String DIP, int SPORT, int DPORT,
			int pageNo, int pageSize, String logType, String endTime) {

		Map<String, Object> resultMap = new HashMap<>();
		ArrayList<IPLogVo> resultList = new ArrayList<>();
		try {
			List<String> readLines = FileUtils.readLines(new File("ip.txt"), "utf-8");
			for (int i = 0; i < pageSize; i++) {
				IPLogVo ipLogVo = new IPLogVo();
				IPHMDLogPo parseObject = JSON.parseObject(readLines.get(i), IPHMDLogPo.class);
				BeanUtils.copyProperties(parseObject, ipLogVo);
				ipLogVo.setBHSJ(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
						.format(new Date(new Long(parseObject.getBHSJ() * 1000))));
				ipLogVo.setSPORT(parseObject.getSPORT() + "");
				ipLogVo.setDPORT(parseObject.getDPORT() + "");
				ipLogVo.setLHID(parseObject.getLHID() + "");
				ipLogVo.setSIP(IPv4Util.longToIp(Long.parseLong(parseObject.getSIP())));
				ipLogVo.setDIP(IPv4Util.longToIp(Long.parseLong(parseObject.getDIP())));
				ipLogVo.setQDJIP(IPv4Util.longToIp(Long.parseLong(parseObject.getQDJIP())));
				// TODO
				switch (parseObject.getYDY()) {
				case "652722":
					ipLogVo.setYDY("北京");
					break;
				case "653127":
					ipLogVo.setYDY("上海");
					break;
				default:
					ipLogVo.setYDY("武汉");
					break;
				}
				// TODO
				switch (parseObject.getMDDY()) {
				case "120100":
					ipLogVo.setMDDY("北京");
					break;
				case "110100":
					ipLogVo.setMDDY("上海");
					break;
				default:
					ipLogVo.setMDDY("武汉");
					break;
				}

				// TODO
				switch (parseObject.getPZLX()) {
				case 201:
					ipLogVo.setPZLX("IP黑名单");
					break;
				case 202:
					ipLogVo.setPZLX("IP灰名单");
					break;
				default:
					ipLogVo.setPZLX("IP白名单");
					break;
				}
				switch (parseObject.getGKLB()) {
				case 1:
					ipLogVo.setGKLB("音频");
					break;
				case 2:
					ipLogVo.setGKLB("视频");
					break;
				case 3:
					ipLogVo.setGKLB("图片");
					break;
				case 4:
					ipLogVo.setGKLB("文本");
					break;
				case 5:
					ipLogVo.setGKLB("VPN");
					break;
				case 6:
					ipLogVo.setGKLB("即时通信");
					break;
				case 7:
					ipLogVo.setGKLB("加密网址");
					break;
				default:
					ipLogVo.setGKLB("");
					break;
				}

				// TODO
				switch (parseObject.getPROTOCOL()) {
				case 1:
					ipLogVo.setPROTOCOL("UDP");
					break;
				case 2:
					ipLogVo.setPROTOCOL("UDP");
					break;
				case 3:
					ipLogVo.setPROTOCOL("UDP");
					break;
				case 4:
					ipLogVo.setPROTOCOL("TCP");
					break;
				default:
					ipLogVo.setPROTOCOL("TCP");
					break;
				}
				switch (parseObject.getYYS()) {
				case 1:
					ipLogVo.setYYS("移动");
					break;
				case 2:
					ipLogVo.setYYS("联通");
					break;
				case 3:
					ipLogVo.setYYS("电信");
					break;
				case 4:
					ipLogVo.setYYS("铁通");
					break;
				default:
					ipLogVo.setYYS("教育网");
					break;
				}
				resultList.add(ipLogVo);
			}
			resultMap.put("data", resultList);
			resultMap.put("pageSize", pageSize);
			resultMap.put("pageNo", pageNo);
			resultMap.put("totalPage", readLines.size() / pageSize);
			resultMap.put("totalCount", readLines.size());
			resultMap.put("status", "ok");
		} catch (IOException e) {
			e.printStackTrace();
		}

		return resultMap;

	}

}
