package iie.cas.dao.gbase;


import java.util.List;
import java.util.Map;

import iie.cas.po.WYGJCJCRZLogPo;

public interface WYGJCJCRZMapper {
    int insert(WYGJCJCRZLogPo record);

    int insertSelective(WYGJCJCRZLogPo record);
    List<WYGJCJCRZLogPo> SelectAll(Map<String,Object> map);
    Integer SelectCount(Map<String,Object> map);
}