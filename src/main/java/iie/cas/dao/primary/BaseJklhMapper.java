package iie.cas.dao.primary;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import iie.cas.po.primary.BaseJklh;

public interface BaseJklhMapper {
	BaseJklh Select(@Param("LHID")Integer number);
	List<BaseJklh> SelectAll();
	BaseJklh SelectName(@Param("LHHH")String name);
}
