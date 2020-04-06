package iie.cas.task;


import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import iie.cas.dao.primary.ExportCsvMapper;
import iie.cas.po.primary.ExportCsv;
import iie.cas.service.MonitoringLogDownService;
import iie.cas.util.AddFilesWithAESEncryption;
import iie.cas.util.CSVUtils;
import iie.cas.util.ExportCSVUtil;
import net.sf.json.JSONObject;

public class DownCsv implements Runnable{
	private MonitoringLogDownService monitoringLogDownService;
	private ExportCsvMapper exportCsvMapper;
	private ExportCsv exportCsv;
	
	

	public MonitoringLogDownService getMonitoringLogDownService() {
		return monitoringLogDownService;
	}



	public void setMonitoringLogDownService(MonitoringLogDownService monitoringLogDownService) {
		this.monitoringLogDownService = monitoringLogDownService;
	}



	public ExportCsvMapper getExportCsvMapper() {
		return exportCsvMapper;
	}



	public void setExportCsvMapper(ExportCsvMapper exportCsvMapper) {
		this.exportCsvMapper = exportCsvMapper;
	}



	public ExportCsv getExportCsv() {
		return exportCsv;
	}



	public void setExportCsv(ExportCsv exportCsv) {
		this.exportCsv = exportCsv;
	}



	@Override
	public void run() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat sd = new SimpleDateFormat("yyyyMMddHHmmss");
		JSONObject  jasonObject = JSONObject.fromObject(exportCsv.getSqls());
        Map<String,Object> map = (Map<String,Object>)jasonObject;
        int num=monitoringLogDownService.SelectCount(map, exportCsv.getLogType());
        int start=0;
        int length=1000000;
       List<String> fileName=new ArrayList<String>();
       if(num==0){
    	   exportCsvMapper.UpdateStatus(exportCsv.getId(), 3);
    	   return ;
       }
       exportCsvMapper.UpdateNum(exportCsv.getId(), num);
        while (num>0){
        	 map.put("start", start);
             map.put("length", length);
             System.out.println("开始"+sdf.format(new Date())+" "+exportCsv.getId()+" "+start);
		if (exportCsv.getLogType()==101) {
			
		} else if (exportCsv.getLogType()==201) {
			map=monitoringLogDownService.IPHMDqueryLogInfo(map);
		} else if (exportCsv.getLogType()==301) {
			
		} else if (exportCsv.getLogType()==103) {
			
		} else if (exportCsv.getLogType()==303) {
			
		} else if (exportCsv.getLogType()==402) {
			map=monitoringLogDownService.DNSGKqueryLogInfo(map);
		} else if (exportCsv.getLogType()==403) {
			map=monitoringLogDownService.HTTPGKqueryLogInfo(map);
		} else if (exportCsv.getLogType()==404) {
			map= monitoringLogDownService.HTTPGKqueryLogInfo(map);
		} else if (exportCsv.getLogType()==405) {
			map=monitoringLogDownService.SSLGKqueryLogInfo(map);
		} else if (exportCsv.getLogType()==406) {
			map= monitoringLogDownService.WYGJCGKqueryLogInfo(map);
		} else if (exportCsv.getLogType()==407) {
			map=monitoringLogDownService.MAILGKqueryLogInfo(map);
		} else if (exportCsv.getLogType()==408) {
			map= monitoringLogDownService.FTPGJCGKqueryLogInfo(map);
		} else if (exportCsv.getLogType()==409) {
			map=monitoringLogDownService.WYGJCGKqueryLogInfo(map);
		} else if (exportCsv.getLogType()==410) {
			map= monitoringLogDownService.MAILGKqueryLogInfo(map);
		} else if (exportCsv.getLogType()==411) {
			map=monitoringLogDownService.VPNGKqueryLogInfo(map);
		} else if (exportCsv.getLogType()==412) {
			map= monitoringLogDownService.JSTXGKqueryLogInfo(map);
		} else if (exportCsv.getLogType()==413) {
			map= monitoringLogDownService.JSTXGKqueryLogInfo(map);
		} else if (exportCsv.getLogType()==501) {
			map=monitoringLogDownService.IPJCqueryLogInfo(map);
		} else if (exportCsv.getLogType()==502) {
			map=monitoringLogDownService.DNSJCqueryLogInfo(map);
		} else if (exportCsv.getLogType()==503) {
			map= monitoringLogDownService.HTTPJCqueryLogInfo(map);
		} else if (exportCsv.getLogType()==504) {
			map= monitoringLogDownService.HTTPJCqueryLogInfo(map);
		} else if (exportCsv.getLogType()==505) {
			map= monitoringLogDownService.SSLJCqueryLogInfo(map);
		} else if (exportCsv.getLogType()==506) {
			map= monitoringLogDownService.WYGJCJCqueryLogInfo(map);
		} else if (exportCsv.getLogType()==507) {
			map=monitoringLogDownService.MAILJCqueryLogInfo(map);
		} else if (exportCsv.getLogType()==508) {
			map=monitoringLogDownService.FTPGJCJCqueryLogInfo(map);
		} else if (exportCsv.getLogType()==509) {
			map=monitoringLogDownService.WYGJCJCqueryLogInfo(map);
		} else if (exportCsv.getLogType()==510) {
			map=monitoringLogDownService.MAILJCqueryLogInfo(map);
		} else if (exportCsv.getLogType()==511) {
			map= monitoringLogDownService.VPNJCqueryLogInfo(map);
		} else if (exportCsv.getLogType()==512) {
			map= monitoringLogDownService.JSTXJCqueryLogInfo(map);
		} else if (exportCsv.getLogType()==513) {
			map=monitoringLogDownService.JSTXJCqueryLogInfo(map);
		} else if (exportCsv.getLogType()==514) {
			map= monitoringLogDownService.TPJCqueryLogInfo(map);
		} else if (exportCsv.getLogType()==515) {
			map=monitoringLogDownService.DMTJCqueryLogInfo(map);
		} else if (exportCsv.getLogType()==601) {
			
		} else if (exportCsv.getLogType()==701) {
			
		} else if (exportCsv.getLogType()==702) {
			
		} else {
			
		}
		System.out.println("开始写入文件"+sdf.format(new Date())+" "+exportCsv.getId()+" "+start);
		LinkedHashMap<String, Object> mapValue = new LinkedHashMap<>();
		mapValue=ExportCSVUtil.getMap("0"+exportCsv.getLogType());
		List exportData=new ArrayList<Map>();
		exportData=(List<Map<String, Object>>) map.get("data");
		File file = CSVUtils.createCSVFile(exportData, mapValue, "/home/", sd.format(new Date())+"日志");
		fileName.add("/home/"+file.getName());
		start+=1000000;
		length+=1000000;
		num-=1000000;
		System.out.println("结束"+sdf.format(new Date())+" "+start);
        }
        if (fileName.size() > 0) {
        	System.out.println("压缩文件"+sdf.format(new Date()));
			AddFilesWithAESEncryption.AddFilesWithAESEncryption(
					"/opt/tomcat/xxjj/webapps/xinjiang2/" + exportCsv.getId() + ".zip", fileName);
			for (String filename : fileName) {
				File files = new File(filename);
				files.delete();
			}
        }
//        File fileZip=new File("/home/huangyuchen/" + exportCsv.getId() + ".zip");
//        fileZip.renameTo(new File("/opt/tomcat/xxjj/webapps/xinjiang2/"+ exportCsv.getId() + ".zip"));
        exportCsvMapper.UpdatePath(exportCsv.getId(), "http://172.16.18.17:8082/xinjiang2/"+exportCsv.getId() + ".zip");
        exportCsvMapper.UpdateEtime(exportCsv.getId(), sdf.format(new Date()));
		exportCsvMapper.UpdateStatus(exportCsv.getId(), 2);
		
	}

}
