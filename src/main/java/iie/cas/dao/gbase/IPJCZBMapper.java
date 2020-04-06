package iie.cas.dao.gbase;


import java.util.List;
import java.util.Map;
import iie.cas.po.IPJCZBLogPo;

public interface IPJCZBMapper {
    int insert(IPJCZBLogPo record);

    int insertSelective(IPJCZBLogPo record);
    List<IPJCZBLogPo> SelectAll(Map<String,Object> map);
    Integer SelectCount(Map<String,Object> map);
}