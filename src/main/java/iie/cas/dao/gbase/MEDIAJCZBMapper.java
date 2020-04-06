package iie.cas.dao.gbase;


import java.util.List;
import java.util.Map;

import iie.cas.po.MEDIAJCZBLogPo;

public interface MEDIAJCZBMapper {
    int insert(MEDIAJCZBLogPo record);

    int insertSelective(MEDIAJCZBLogPo record);
    List<MEDIAJCZBLogPo> SelectAll(Map<String,Object> map);
    Integer SelectCount(Map<String,Object> map);
}