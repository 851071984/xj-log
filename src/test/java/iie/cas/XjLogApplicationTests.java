package iie.cas;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import iie.cas.dao.gbase.DNSGKZBMapper;
import iie.cas.dao.primary.AreaCodeTMapper;
import iie.cas.po.DNSGKZBLogPo;
import iie.cas.po.primary.AreaCodeT;

@RunWith(SpringRunner.class)
@SpringBootTest
public class XjLogApplicationTests {

	@Autowired
	private AreaCodeTMapper areaCodeTMapper;

	@Autowired
	private DNSGKZBMapper dNSGKZBMapper;

	@Test
	public void contextLoads() {
		List<AreaCodeT> areaCodeTList = areaCodeTMapper.selectA();
		System.out.println(areaCodeTList.size());
		List<DNSGKZBLogPo> dnsGKZBLogPoList = dNSGKZBMapper.selectA();
		System.out.println(dnsGKZBLogPoList.size());
	}

}
