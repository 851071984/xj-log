package iie.cas.dao.primary;

import org.apache.ibatis.annotations.Param;
import iie.cas.po.primary.BaseLabel;

public interface BaseLabelMapper {
	BaseLabel Select(@Param("BQID")Integer bqid);
	BaseLabel SelectName(@Param("BQMC")String bqmc);
}
