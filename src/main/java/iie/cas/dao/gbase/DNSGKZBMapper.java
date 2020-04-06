package iie.cas.dao.gbase;



import java.util.List;
import java.util.Map;

import iie.cas.po.DNSGKZBLogPo;

public interface DNSGKZBMapper {
    int insert(DNSGKZBLogPo record);
    int insertList(List<DNSGKZBLogPo> record);

    int insertSelective(DNSGKZBLogPo record);
    List<DNSGKZBLogPo> selectA();
    List<DNSGKZBLogPo> SelectAll(Map<String,Object> map);
    Integer SelectCount(Map<String,Object> map);
}