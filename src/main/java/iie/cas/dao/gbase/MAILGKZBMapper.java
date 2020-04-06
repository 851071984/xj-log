package iie.cas.dao.gbase;


import java.util.List;
import java.util.Map;

import iie.cas.po.MAILGKZBLogPo;

public interface MAILGKZBMapper {
    int insert(MAILGKZBLogPo record);

    int insertSelective(MAILGKZBLogPo record);
    List<MAILGKZBLogPo> SelectAll(Map<String,Object> map);
    Integer SelectCount(Map<String,Object> map);
}