package iie.cas.dao.gbase;

import java.util.List;
import java.util.Map;

import iie.cas.po.MAILJCZBLogPo;

public interface MAILJCZBMapper {
    int insert(MAILJCZBLogPo record);

    int insertSelective(MAILJCZBLogPo record);
    List<MAILJCZBLogPo> SelectAll(Map<String,Object> map);
    Integer SelectCount(Map<String,Object> map);
}