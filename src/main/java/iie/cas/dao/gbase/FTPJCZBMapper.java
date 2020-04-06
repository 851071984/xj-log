package iie.cas.dao.gbase;


import java.util.List;
import java.util.Map;

import iie.cas.po.FTPJCZBLogPo;

public interface FTPJCZBMapper {
    int insert(FTPJCZBLogPo record);

    int insertSelective(FTPJCZBLogPo record);
    List<FTPJCZBLogPo> SelectAll(Map<String,Object> map);
    Integer SelectCount(Map<String,Object> map);
}