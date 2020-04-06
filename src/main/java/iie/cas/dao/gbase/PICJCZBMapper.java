package iie.cas.dao.gbase;


import java.util.List;
import java.util.Map;

import iie.cas.po.PICJCZBLogPo;

public interface PICJCZBMapper {
    int insert(PICJCZBLogPo record);

    int insertSelective(PICJCZBLogPo record);
    List<PICJCZBLogPo> SelectAll(Map<String,Object> map);
    Integer SelectCount(Map<String,Object> map);
}