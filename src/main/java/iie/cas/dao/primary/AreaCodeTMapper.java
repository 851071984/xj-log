package iie.cas.dao.primary;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import iie.cas.po.primary.AreaCodeT;

public interface AreaCodeTMapper {
	List<AreaCodeT> selectA();
	List<AreaCodeT> SelectAll(Map<String,Object> map);
	AreaCodeT Select(@Param("ID")Integer number);
    Integer SelectCount(Map<String,Object> map);
    List<AreaCodeT> SelectList(List<Integer> list);//根据用户的所属地域查询所有有权限的地域
}
