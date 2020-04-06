package iie.cas.dao.gbase;

import java.util.List;
import java.util.Map;
import iie.cas.po.WYGJCGKRZLogPo;

public interface WYGJCGKRZMapper {
    int insert(WYGJCGKRZLogPo record);

    int insertSelective(WYGJCGKRZLogPo record);
    List<WYGJCGKRZLogPo> SelectAll(Map<String,Object> map);
    Integer SelectCount(Map<String,Object> map);
}