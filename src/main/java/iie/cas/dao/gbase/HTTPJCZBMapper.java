package iie.cas.dao.gbase;


import java.util.List;
import java.util.Map;

import iie.cas.po.HTTPJCZBLogPo;

public interface HTTPJCZBMapper {
    int insert(HTTPJCZBLogPo record);

    int insertSelective(HTTPJCZBLogPo record);
    List<HTTPJCZBLogPo> SelectAll(Map<String,Object> map);
    Integer SelectCount(Map<String,Object> map);
}