package iie.cas.util;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.model.ZipParameters;
import net.lingala.zip4j.util.Zip4jConstants;

public class AddFilesWithAESEncryption {
    
    public static void AddFilesWithAESEncryption(String zipNamePath,List<String>fileNameList) {
          
        try {
            ZipFile zipFile = new ZipFile(zipNamePath);
  
            ArrayList<File> filesToAdd = new ArrayList<File>();
            for(String str:fileNameList){
            	filesToAdd.add(new File(str));
            }
              
            ZipParameters parameters = new ZipParameters();
            parameters.setCompressionMethod(Zip4jConstants.COMP_DEFLATE);
              
            parameters.setCompressionLevel(Zip4jConstants.DEFLATE_LEVEL_NORMAL); 
            parameters.setEncryptFiles(false);
              
            parameters.setEncryptionMethod(Zip4jConstants.ENC_METHOD_AES);
              
  
            parameters.setAesKeyStrength(Zip4jConstants.AES_STRENGTH_256);
//            parameters.setPassword("1");
      
            zipFile.addFiles(filesToAdd, parameters);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    

      
}