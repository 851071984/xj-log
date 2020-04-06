package iie.cas.dao.primary;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import iie.cas.po.primary.ExportCsv;

public interface ExportCsvMapper {
    int insert(ExportCsv record);
    ExportCsv SelectId(@Param("id")int id);
    List<ExportCsv> select();
    List<ExportCsv> SelectAll(Map<String,Object> map);
    Integer SelectCount(Map<String,Object> map);
    public int UpdateStatus(@Param("id")int id,@Param("status")int status);
    public int UpdateStime(@Param("id")int id,@Param("stime")String stime);
    public int UpdateEtime(@Param("id")int id,@Param("etime")String etime);
    public int UpdateNum(@Param("id")int id,@Param("num")int num);
    public int UpdateCompleted(@Param("id")int id,@Param("completed")int completed);
    public int UpdatePath(@Param("id")int id,@Param("path")String path);
}
