package iie.cas.dao.gbase;


import java.util.List;
import java.util.Map;

import iie.cas.po.HTTPGKZBLogPo;

public interface HTTPGKZBMapper {
    int insert(HTTPGKZBLogPo record);

    int insertSelective(HTTPGKZBLogPo record);
    List<HTTPGKZBLogPo> SelectAll(Map<String,Object> map);
    Integer SelectCount(Map<String,Object> map);
}