package iie.cas.dao.gbase;


import java.util.List;
import java.util.Map;

import iie.cas.po.SSLGKZBLogPo;

public interface SSLGKZBMapper {
    int insert(SSLGKZBLogPo record);

    int insertSelective(SSLGKZBLogPo record);
    List<SSLGKZBLogPo> SelectAll(Map<String,Object> map);
    Integer SelectCount(Map<String,Object> map);
}