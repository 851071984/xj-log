package iie.cas.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;

public class CSVUtils {
	@SuppressWarnings("rawtypes") 
	public static File createCSVFile(List exportData, LinkedHashMap map, String outPutPath, String fileName) {
		File csvFile = null;
		BufferedWriter csvFileOutputStream = null;
		try {
			File file = new File(outPutPath);
			if (!file.exists()) {
				file.mkdir();
			}
			//定义文件名格式并创建  
			csvFile = File.createTempFile(fileName, ".csv", new File(outPutPath));
//			System.out.println("csvFile：" + csvFile);
			// UTF-8使正确读取分隔符","    
			csvFileOutputStream = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(csvFile,true), "GBK"),
					1024);
//			System.out.println("csvFileOutputStream：" + csvFileOutputStream);
			// 写入文件头部    
			for (Iterator propertyIterator = map.entrySet().iterator(); propertyIterator.hasNext();) {
				java.util.Map.Entry propertyEntry = (java.util.Map.Entry) propertyIterator.next();
				csvFileOutputStream.write((String) propertyEntry.getValue() != null
						? new String(((String) propertyEntry.getValue()).getBytes("GBK"), "GBK") : "");
				if (propertyIterator.hasNext()) {
					csvFileOutputStream.write(",");
				}
//				System.out.println(new String(((String) propertyEntry.getValue()).getBytes("GBK"), "GBK"));
			}
			csvFileOutputStream.write("\r\n");
			// 写入文件内容    
			for (Iterator iterator = exportData.iterator(); iterator.hasNext();) {
				Object row = iterator.next();
				for (Iterator propertyIterator = map.entrySet().iterator(); propertyIterator.hasNext();) {
					java.util.Map.Entry propertyEntry = (java.util.Map.Entry) propertyIterator.next();
					csvFileOutputStream.write(BeanUtils.getProperty(row,
							((String) propertyEntry.getKey()) != null ? (String) propertyEntry.getKey() : ""));
					if (propertyIterator.hasNext()) {
						csvFileOutputStream.write(",");
					}
				}
				if (iterator.hasNext()) {
					csvFileOutputStream.write("\r\n");
				}
			}
			csvFileOutputStream.write("\r\n");
			csvFileOutputStream.flush();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				csvFileOutputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return csvFile;
	}
	
	public static File addCSVFile(List exportData, LinkedHashMap map, String outPutPath, String fileName,File csvFileOld) {
		File csvFile = csvFileOld;
		BufferedWriter csvFileOutputStream = null;
		try {
			File file = new File(outPutPath);
			if (!file.exists()) {
				file.mkdir();
			}
			//定义文件名格式并创建  
			if(!csvFile.exists()){
				csvFile = File.createTempFile(fileName, ".csv", new File(outPutPath));
				csvFileOutputStream = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(csvFile,true), "GBK"),1024);
				// 写入文件头部    
				for (Iterator propertyIterator = map.entrySet().iterator(); propertyIterator.hasNext();) {
					java.util.Map.Entry propertyEntry = (java.util.Map.Entry) propertyIterator.next();
					csvFileOutputStream.write((String) propertyEntry.getValue() != null
							? new String(((String) propertyEntry.getValue()).getBytes("GBK"), "GBK") : "");
					if (propertyIterator.hasNext()) {
						csvFileOutputStream.write(",");
					}
//					System.out.println(new String(((String) propertyEntry.getValue()).getBytes("GBK"), "GBK"));
				}
				csvFileOutputStream.write("\r\n");
			}else{
				csvFileOutputStream = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(csvFile,true), "GBK"),1024);
			}
			
//			System.out.println("csvFileOutputStream：" + csvFileOutputStream);
			
			// 写入文件内容    
			for (Iterator iterator = exportData.iterator(); iterator.hasNext();) {
				Object row = iterator.next();
				for (Iterator propertyIterator = map.entrySet().iterator(); propertyIterator.hasNext();) {
					java.util.Map.Entry propertyEntry = (java.util.Map.Entry) propertyIterator.next();
					csvFileOutputStream.write(BeanUtils.getProperty(row,
							((String) propertyEntry.getKey()) != null ? (String) propertyEntry.getKey() : ""));
					if (propertyIterator.hasNext()) {
						csvFileOutputStream.write(",");
					}
				}
				if (iterator.hasNext()) {
					csvFileOutputStream.write("\r\n");
				}
			}
			csvFileOutputStream.write("\r\n");
			csvFileOutputStream.flush();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				csvFileOutputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return csvFile;
	}
}
