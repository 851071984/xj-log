package iie.cas.dao.gbase;

import java.util.List;
import java.util.Map;

import iie.cas.po.JSTXGKZBLogPo;

public interface JSTXGKZBMapper {
    int insert(JSTXGKZBLogPo record);

    int insertSelective(JSTXGKZBLogPo record);
    List<JSTXGKZBLogPo> SelectAll(Map<String,Object> map);
    Integer SelectCount(Map<String,Object> map);
}