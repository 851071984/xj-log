package iie.cas.dao.gbase;


import java.util.List;
import java.util.Map;

import iie.cas.po.IPGKZBLogPo;

public interface IPGKZBMapper {
    int insert(IPGKZBLogPo record);

    int insertSelective(IPGKZBLogPo record);
    List<IPGKZBLogPo> SelectAll(Map<String,Object> map);
    Integer SelectCount(Map<String,Object> map);
}