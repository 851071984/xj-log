package iie.cas.dao.gbase;


import java.util.List;
import java.util.Map;

import iie.cas.po.VPNGKZBLogPo;

public interface VPNGKZBMapper {
    int insert(VPNGKZBLogPo record);

    int insertSelective(VPNGKZBLogPo record);
    List<VPNGKZBLogPo> SelectAll(Map<String,Object> map);
    Integer SelectCount(Map<String,Object> map);
}