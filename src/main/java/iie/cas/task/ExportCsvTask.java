package iie.cas.task;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import iie.cas.dao.primary.ExportCsvMapper;
import iie.cas.po.primary.ExportCsv;
import iie.cas.service.MonitoringLogDownService;
import iie.cas.service.MonitoringLogService;
import iie.cas.util.ThreadPoolAll;

@Configuration
@EnableScheduling
public class ExportCsvTask {
	@Autowired
	private ExportCsvMapper exportCsvMapper;
	@Autowired
	private MonitoringLogService monitoringLogService;
	@Autowired
	private MonitoringLogDownService monitoringLogDownService;
	
	@Scheduled(cron = "0 0-59/3 * * * ?")
	public void TaskStart() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		List<ExportCsv> export=exportCsvMapper.select();
		for(int i=0;i<export.size();i++){
			exportCsvMapper.UpdateStatus(export.get(i).getId(), 1);
			exportCsvMapper.UpdateStime(export.get(i).getId(), sdf.format(new Date()));
			DownCsv down=new DownCsv();
			down.setExportCsv(export.get(i));
			down.setExportCsvMapper(exportCsvMapper);
			down.setMonitoringLogDownService(monitoringLogDownService);
			ThreadPoolAll.loadDrivers(down);
		}
	}

}
