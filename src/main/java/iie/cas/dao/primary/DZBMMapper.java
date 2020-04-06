package iie.cas.dao.primary;

import java.util.List;
import java.util.Map;

import iie.cas.po.primary.DZBM;

public interface DZBMMapper {
	List<DZBM> SelectAll(Map<String,Object> map);
    Integer SelectCount(Map<String,Object> map);
}
