package iie.cas.dao.gbase;


import java.util.List;
import java.util.Map;

import iie.cas.po.SSLJCZBLogPo;

public interface SSLJCZBMapper {
    int insert(SSLJCZBLogPo record);

    int insertSelective(SSLJCZBLogPo record);
    
    List<SSLJCZBLogPo> SelectAll(Map<String,Object> map);
    Integer SelectCount(Map<String,Object> map);
}