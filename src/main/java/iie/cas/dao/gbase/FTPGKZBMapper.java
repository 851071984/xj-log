package iie.cas.dao.gbase;

import java.util.List;
import java.util.Map;

import iie.cas.po.FTPGKZBLogPo;

public interface FTPGKZBMapper {
    int insert(FTPGKZBLogPo record);

    int insertSelective(FTPGKZBLogPo record);
    List<FTPGKZBLogPo> SelectAll(Map<String,Object> map);
    Integer SelectCount(Map<String,Object> map);
}