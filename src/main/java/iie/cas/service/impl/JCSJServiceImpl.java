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

import iie.cas.dao.primary.AreaCodeTMapper;
import iie.cas.dao.primary.DZBMMapper;
import iie.cas.dao.primary.ExportCsvMapper;
import iie.cas.po.primary.AreaCodeT;
import iie.cas.po.primary.DZBM;
import iie.cas.po.primary.ExportCsv;
import iie.cas.service.JCSJService;
@Service
public class JCSJServiceImpl implements JCSJService {
	@Autowired
	private AreaCodeTMapper areaCodeTMapper;
	@Autowired
	private DZBMMapper dZBMMapper;
	@Autowired
	private ExportCsvMapper exportCsvMapper;
	@Override
	public Map<String, Object> ActionJCSJ(String name) {
		Map<String, Object> map = new HashMap<>();
		ArrayList<Map<String, Object>> resultList = new ArrayList<>();
		map.put("start", 0);
		map.put("length", 10);
		if(StringUtils.isNotBlank(name)&&!name.equals("null")){
			try {
				map.put("ID", Integer.valueOf(name));
			} catch (Exception e) {
				map.put("NAME", name);
			}
			
			
		}
		List<DZBM> list=dZBMMapper.SelectAll(map);
		for (int i = 0; i < list.size(); i++) {
			Map<String, Object> resultMap = new HashMap<>();
			resultMap.put("id", list.get(i).getId());
			resultMap.put("name", list.get(i).getName());
			resultList.add(resultMap);
		}
		map = new HashMap<>();
		map.put("data", resultList);
		map.put("status", "ok");
		return map;
	}

	@Override
	public Map<String, Object> DYJCSJ(String name) {
		Map<String, Object> map = new HashMap<>();
		ArrayList<Map<String, Object>> resultList = new ArrayList<>();
		map.put("start", 0);
		map.put("length", 10);
		if(StringUtils.isNotBlank(name)&&!name.equals("null")){
			try {
				map.put("ID", Integer.valueOf(name));
			} catch (Exception e) {
				map.put("MC", name);
			}
			
			
		}
		List<AreaCodeT> list=areaCodeTMapper.SelectAll(map);
		for (int i = 0; i < list.size(); i++) {
			Map<String, Object> resultMap = new HashMap<>();
			resultMap.put("id", list.get(i).getId());
			resultMap.put("name", list.get(i).getMc());
			resultList.add(resultMap);
		}
		map = new HashMap<>();
		map.put("data", resultList);
		map.put("status", "ok");
		return map;
	}

	@Override
	public Map<String, Object> DownCSV(int pageNo,int pageSize,String logType,String userName) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Map<String, Object> map = new HashMap<>();
		ArrayList<Map<String, Object>> resultList = new ArrayList<>();
		map.put("start", (pageNo-1)*10);
		map.put("length", pageSize);
		map.put("logType", Integer.valueOf(logType));
		 List<ExportCsv>  export=exportCsvMapper.SelectAll(map);
		Integer num = exportCsvMapper.SelectCount(map);
		for(int i=0;i<export.size();i++){
			Map<String, Object> resultMap = new HashMap<>();
			resultMap.put("id", export.get(i).getId());
			resultMap.put("name", export.get(i).getName());
			resultMap.put("status", export.get(i).getStatus());
			try {
				resultMap.put("stime", StringUtils.isNotBlank(export.get(i).getStime())?sdf.format(sdf.parse(export.get(i).getStime())):"");
				resultMap.put("etime", StringUtils.isNotBlank(export.get(i).getEtime())?sdf.format(sdf.parse(export.get(i).getEtime())):"");
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			resultMap.put("path", StringUtils.isNotBlank(export.get(i).getPath())?export.get(i).getPath():"");
			resultMap.put("num", export.get(i).getNum());
			resultMap.put("completed", export.get(i).getCompleted());
			resultList.add(resultMap);
		}
		map = new HashMap<>();
		map.put("data", resultList);
		map.put("pageSize", pageSize);
		map.put("pageNo", pageNo);
		map.put("totalPage", num / pageSize);
		map.put("totalCount", num);
		map.put("code", 200);
		return map;
	}

}
