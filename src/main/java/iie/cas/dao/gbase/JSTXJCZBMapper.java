package iie.cas.dao.gbase;


import java.util.List;
import java.util.Map;

import iie.cas.po.JSTXJCZBLogPo;

public interface JSTXJCZBMapper {
    int insert(JSTXJCZBLogPo record);

    int insertSelective(JSTXJCZBLogPo record);
    
    List<JSTXJCZBLogPo> SelectAll(Map<String,Object> map);
    Integer SelectCount(Map<String,Object> map);
}