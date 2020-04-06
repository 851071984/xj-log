package iie.cas.dao.gbase;



import java.util.List;
import java.util.Map;

import iie.cas.po.DNSJCZBLogPo;

public interface DNSJCZBMapper {
    int insert(DNSJCZBLogPo record);

    int insertSelective(DNSJCZBLogPo record);
    List<DNSJCZBLogPo> SelectAll(Map<String,Object> map);
    Integer SelectCount(Map<String,Object> map);
}