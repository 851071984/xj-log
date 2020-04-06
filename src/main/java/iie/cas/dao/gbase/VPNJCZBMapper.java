package iie.cas.dao.gbase;

import java.util.List;
import java.util.Map;

import iie.cas.po.VPNJCZBLogPo;

public interface VPNJCZBMapper {
    int insert(VPNJCZBLogPo record);

    int insertSelective(VPNJCZBLogPo record);
    List<VPNJCZBLogPo> SelectAll(Map<String,Object> map);
    Integer SelectCount(Map<String,Object> map);
}