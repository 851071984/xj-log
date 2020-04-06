package iie.cas.task;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;

import iie.cas.dao.gbase.DNSGKZBMapper;
import iie.cas.dao.gbase.DNSJCZBMapper;
import iie.cas.dao.gbase.FTPGKZBMapper;
import iie.cas.dao.gbase.FTPJCZBMapper;
import iie.cas.dao.gbase.HTTPGKZBMapper;
import iie.cas.dao.gbase.HTTPJCZBMapper;
import iie.cas.dao.gbase.IPGKZBMapper;
import iie.cas.dao.gbase.IPJCZBMapper;
import iie.cas.dao.gbase.JSTXGKZBMapper;
import iie.cas.dao.gbase.JSTXJCZBMapper;
import iie.cas.dao.gbase.MAILGKZBMapper;
import iie.cas.dao.gbase.MAILJCZBMapper;
import iie.cas.dao.gbase.MEDIAJCZBMapper;
import iie.cas.dao.gbase.PICJCZBMapper;
import iie.cas.dao.gbase.SSLGKZBMapper;
import iie.cas.dao.gbase.SSLJCZBMapper;
import iie.cas.dao.gbase.VPNGKZBMapper;
import iie.cas.dao.gbase.VPNJCZBMapper;
import iie.cas.dao.gbase.WYGJCGKRZMapper;
import iie.cas.dao.gbase.WYGJCJCRZMapper;
import iie.cas.po.DNSGKZBLogPo;
import iie.cas.po.HTTPGKZBLogPo;
import iie.cas.po.MAILGKZBLogPo;
import iie.cas.po.SSLGKZBLogPo;
import iie.cas.po.WYGJCGKRZLogPo;
@Component
@EnableScheduling
public class ImpolSql implements ApplicationRunner{
	@Autowired
	private IPGKZBMapper iPGKZBMapper;
	@Autowired
	private HTTPJCZBMapper httpJCZBMapper;
	@Autowired
	private DNSJCZBMapper dnsJCZBMapper;
	@Autowired
	private SSLJCZBMapper sslJCZBMapper;
	@Autowired
	private MAILJCZBMapper mailJCZBMapper;
	@Autowired
	private JSTXJCZBMapper jstxJCZBMapper;
	@Autowired
	private VPNJCZBMapper vpnJCZBMapper;
	@Autowired
	private FTPJCZBMapper ftpJCZBMapper;
	@Autowired
	private WYGJCJCRZMapper wtgjcJCRZMapper;
	@Autowired
	private IPJCZBMapper ipJCZBMapper;
	@Autowired
	private PICJCZBMapper picJCZBMapper;
	@Autowired
	private MEDIAJCZBMapper mediaJCZBMapper;
	@Autowired
	private HTTPGKZBMapper httpGKZBMapper;
	@Autowired
	private DNSGKZBMapper dnsGKZBMapper;
	@Autowired
	private SSLGKZBMapper sslGKZBMapper;
	@Autowired
	private MAILGKZBMapper mailGKZBMapper;
	@Autowired
	private JSTXGKZBMapper jstxGKZBMapper;
	@Autowired
	private VPNGKZBMapper vpnGKZBMapper;
	@Autowired
	private WYGJCGKRZMapper wygjGKZBMapper;
	@Autowired
	private FTPGKZBMapper ftpGKZBMapper;
	@Override
	public void run(ApplicationArguments args) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String pzid="0201000000014295";
		String pzid1="0201000000030762";
		String pzid2="0201000000029556";
		String pzid3="0201000000030762";
		String pzid4="0201000000009154";
		for(int i=0;i<10;i++){
			for(int s=1;s<7;s++){
				for(int y=1;y<6;y++){
//	     List<DNSGKZBLogPo>   logpo=new ArrayList<DNSGKZBLogPo>();
//	     for(int p=0;p<10000;p++){
//	    	DNSGKZBLogPo po=new DNSGKZBLogPo();
//	 		po.setBhsj(sdf.format(new Date()));
//	 		po.setPzid(pzid2);
//	 		po.setFlid(999);
//	 		po.setXzid(999);
//	 		po.setLhid(4115);
//	 		po.setYdy("650107");
//	 		po.setMddy("650422");
//	 		po.setPzlx((short) 402);
//	 		po.setGklb((short) s);
//	 		po.setQdjip(569341489);
//	 		po.setSip("569341489");
//	 		po.setDip("1953824438");
//	 		po.setSport(80);
//	 		po.setDport(80);
//	 		po.setProtocol(17);
//	 		po.setProtoId("08");
//	 		po.setDetailId("08001");
//	 		po.setDnsName("www.xinlang.com");
//	 		po.setDnsValue("114.114.114.114");
//	 		po.setYys(y);
//	 		po.setYl1(4);
//	 		po.setLabel("武器");
//	 		logpo.add(po);
//	     }
//		dnsGKZBMapper.insertList(logpo);
//		po.setBhsj(sdf.format(new Date()));
//		po.setPzid(pzid3);
//		po.setFlid(999);
//		po.setXzid(999);
//		po.setLhid(4115);
//		po.setYdy("650205");
//		po.setMddy("650171");
//		po.setPzlx((short) 402);
//		po.setGklb((short) s);
//		po.setQdjip(1176618250);
//		po.setSip("-1297329954");
//		po.setDip("1687786932");
//		po.setSport(7725);
//		po.setDport(8080);
//		po.setProtocol(17);
//		po.setProtoId("08");
//		po.setDetailId("08001");
//		po.setDnsName("www.app.com");
//		po.setDnsValue("110.110.110.110");
//		po.setYys(y);
//		po.setYl1(4);
//		po.setLabel("政权领土");
//		dnsGKZBMapper.insert(po);
		
//		HTTPGKZBLogPo po=new HTTPGKZBLogPo();
//		po.setBhsj(sdf.format(new Date()));
//		po.setPzid(pzid2);
//		po.setFlid(999);
//		po.setXzid(999);
//		po.setLhid(4115);
//		po.setYdy("650104");
//		po.setMddy("650202");
//		po.setPzlx((short) 403);
//		po.setGklb((short) s);
//		po.setQdjip(-1474247414);
//		po.setSip("-2124327718");
//		po.setDip("-514857763");
//		po.setSport(8088);
//		po.setDport(80);
//		po.setProtocol(17);
//		po.setProtoId("08");
//		po.setDetailId("08001");
//		po.setHost("app.www.gov.cn");
//		po.setUserAgent("111.13.49.251-111.13.49.251,111.13.49.245-111.13.49.245,111.13.49.247-111.13.49.247,111.13.45.155-111.13.45.155,111.13.49.246-111.13.49.246,111.13.49.250-111.13.49.250,111.13.49.183-111.13.49.183,111.13.45.156-111.13.45.156");
//		po.setFileName("");
//		po.setUrl("");
//		po.setCookie("");
//		po.setContent("");
//		po.setYys(y);
//		po.setYl1(4);
//		po.setLabel("民族分裂");
//		httpGKZBMapper.insert(po);
//		po.setBhsj(sdf.format(new Date()));
//		po.setPzid(pzid2);
//		po.setFlid(999);
//		po.setXzid(999);
//		po.setLhid(4115);
//		po.setYdy("650171");
//		po.setMddy("650402");
//		po.setPzlx((short) 403);
//		po.setGklb((short) s);
//		po.setQdjip(-1474247414);
//		po.setSip("-2124327718");
//		po.setDip("-514857763");
//		po.setSport(80);
//		po.setDport(80);
//		po.setProtocol(17);
//		po.setProtoId("08");
//		po.setDetailId("08001");
//		po.setHost("appvideoen.media.gov.cn");
//		po.setUserAgent("203.192.7.68-203.192.7.69");
//		po.setFileName("");
//		po.setUrl("");
//		po.setCookie("");
//		po.setContent("");
//		po.setYys(y);
//		po.setYl1(4);
//		po.setLabel("未知");
//		httpGKZBMapper.insert(po);		
//				po.setBhsj(sdf.format(new Date()));
//				po.setPzid(pzid2);
//				po.setFlid(999);
//				po.setXzid(999);
//				po.setLhid(4115);
//				po.setYdy("650104");
//				po.setMddy("650104");
//				po.setPzlx((short) 404);
//				po.setGklb((short) s);
//				po.setQdjip(-1474247414);
//				po.setSip("-2124327718");
//				po.setDip("-514857763");
//				po.setSport(80);
//				po.setDport(80);
//				po.setProtocol(17);
//				po.setProtoId("08");
//				po.setDetailId("08001");
//				po.setHost("www.12371.cn");
//				po.setUserAgent("115.182.61.1-115.182.61.254");
//				po.setFileName("");
//				po.setUrl("");
//				po.setCookie("");
//				po.setContent("");
//				po.setYys(y);
//				po.setYl1(4);
//				po.setLabel("未知");
//				httpGKZBMapper.insert(po);
//				po.setBhsj(sdf.format(new Date()));
//				po.setPzid(pzid2);
//				po.setFlid(999);
//				po.setXzid(999);
//				po.setLhid(4115);
//				po.setYdy("650104");
//				po.setMddy("650104");
//				po.setPzlx((short) 404);
//				po.setGklb((short) s);
//				po.setQdjip(-1474247414);
//				po.setSip("-2124327718");
//				po.setDip("-514857763");
//				po.setSport(80);
//				po.setDport(80);
//				po.setProtocol(17);
//				po.setProtoId("08");
//				po.setDetailId("08001");
//				po.setHost("www.baidu.com");
//				po.setUserAgent("1.1.1.1,2.2.2.2,10.96.127.11,25.24.26.17");
//				po.setFileName("");
//				po.setUrl("");
//				po.setCookie("");
//				po.setContent("");
//				po.setYys(y);
//				po.setYl1(4);
//				po.setLabel("政权领土");
//				httpGKZBMapper.insert(po);

//		SSLGKZBLogPo po=new SSLGKZBLogPo();
//		po.setBhsj(sdf.format(new Date()));
//		po.setPzid(pzid2);
//		po.setFlid(999);
//		po.setXzid(999);
//		po.setLhid(4115);
//		po.setYdy("650107");
//		po.setMddy("650200");
//		po.setPzlx((short) 405);
//		po.setGklb((short) s);
//		po.setQdjip(-1474247414);
//		po.setSip("-2124327718");
//		po.setDip("-514857763");
//		po.setSport(5053);
//		po.setDport(8088);
//		po.setProtocol(17);
//		po.setProtoId("08");
//		po.setDetailId("08001");
//		po.setZsmc("网络安全二级证书");
//		po.setBfz("中国网络安全中心");
//		po.setSyz("新疆分中心");
//		po.setFwqmc("新疆服务器01");
//		po.setYys(y);
//		po.setYl1(4);
//		po.setLabel("宗教");
//		sslGKZBMapper.insert(po);
//		po.setBhsj(sdf.format(new Date()));
//		po.setPzid(pzid2);
//		po.setFlid(999);
//		po.setXzid(999);
//		po.setLhid(12315);
//		po.setYdy("652327");
//		po.setMddy("652700");
//		po.setPzlx((short) 405);
//		po.setGklb((short) s);
//		po.setQdjip(-1052041254);
//		po.setSip("-995396303");
//		po.setDip("1953824438");
//		po.setSport(80);
//		po.setDport(8099);
//		po.setProtocol(6);
//		po.setProtoId("08");
//		po.setDetailId("08001");
//		po.setZsmc("网络安全一级证书");
//		po.setBfz("中国网络安全中心");
//		po.setSyz("新疆分中心");
//		po.setFwqmc("新疆服务器01");
//		po.setYys(y);
//		po.setYl1(4);
//		po.setLabel("宗教");
//		sslGKZBMapper.insert(po);
		
//		WYGJCGKRZLogPo po=new WYGJCGKRZLogPo();
//		po.setBhsj(sdf.format(new Date()));
//		po.setPzid(pzid2);
//		po.setFlid(999);
//		po.setXzid(999);
//		po.setLhid(14715);
//		po.setYyzl((byte) 0);
//		po.setYdy("652327");
//		po.setMddy("652700");
//		po.setPzlx((short) 406);
//		po.setGklb((short) s);
//		po.setQdjip(-1052041254);
//		po.setSip("-995396303");
//		po.setDip("1953824438");
//		po.setSport(80);
//		po.setDport(8099);
//		po.setProtocol(6);
//		po.setProtoId("08");
//		po.setDetailId("08001");
//		po.setJcUrl("http://www.zdns.cn/page_1523801_3713257.html");
//		po.setContent("2019年4月25日~27日，第二届“一带一路”国际合作高峰论坛在北京举行。会议期间，作为“一带一路”官网域名解析服务平台提供方，互联网域名系统国家工程研究中心（ZDNS）组织技术力量，开展专项保障，实时监控分析，借助ZDNS域名全球云解析平台，全面提升“一带一路”官网域名抗攻击能力和全球解析速度，圆满完成了此次保障任务，并收到了国家信息中心的感谢函。");
//		po.setSsyq("域名缓存记录检测");
//		po.setGjz("域名");
//		po.setYys(y);
//		po.setYl1(4);
//		po.setLabel("其他");
//		wygjGKZBMapper.insert(po);
//		po.setBhsj(sdf.format(new Date()));
//		po.setPzid(pzid2);
//		po.setFlid(999);
//		po.setXzid(999);
//		po.setLhid(14715);
//		po.setYyzl((byte) 1);
//		po.setYdy("652327");
//		po.setMddy("652700");
//		po.setPzlx((short) 406);
//		po.setGklb((short) s);
//		po.setQdjip(-1052041254);
//		po.setSip("1554935857");
//		po.setDip("-397650825");
//		po.setSport(80);
//		po.setDport(8099);
//		po.setProtocol(17);
//		po.setProtoId("08");
//		po.setDetailId("08001");
//		po.setJcUrl("http://www.zdns.cn/");
//		po.setContent("作为我国域名领域唯一的一家国家级工程研究中心，ZDNS十年来聚力域名服务领域深研，下苦功夫攻克基础性关键性技术难题，以攻无不克的研究实力和追求卓越的创新能力，取得了相关领域研究的国际领先地位，成为国家在互联网基础资源管理和技术升级改造工程中的大前锋。");
//		po.setSsyq("域名缓存记录检测");
//		po.setGjz("域名");
//		po.setYys(y);
//		po.setYl1(4);
//		po.setLabel("其他");
//		wygjGKZBMapper.insert(po);
		
//		MAILGKZBLogPo po=new MAILGKZBLogPo();
//		po.setBhsj(sdf.format(new Date()));
//		po.setPzid(pzid2);
//		po.setFlid(999);
//		po.setXzid(999);
//		po.setLhid(14715);
//		po.setYyzl((byte) 0);
//		po.setYdy("652327");
//		po.setMddy("652700");
//		po.setPzlx((short) 407);
//		po.setGklb((short) s);
//		po.setQdjip(-1052041254);
//		po.setSip("1554935857");
//		po.setDip("-397650825");
//		po.setSport(80);
//		po.setDport(8099);
//		po.setProtocol(17);
//		po.setProtoId("08");
//		po.setDetailId("08001");
//		po.setMailSender("张三");
//		po.setMailRecever("李四");
//		po.setReceverNum(1);
//		po.setMailCc("李华");
//		po.setCcNum(1);
//		po.setMailSubject("网络安全周报");
//		po.setContent("作为我国域名领域唯一的一家国家级工程研究中心，ZDNS十年来聚力域名服务领域深研，下苦功夫攻克基础性关键性技术难题，以攻无不克的研究实力和追求卓越的创新能力，取得了相关领域研究的国际领先地位，成为国家在互联网基础资源管理和技术升级改造工程中的大前锋。");
//		po.setAccessory(0);
//		po.setFileName("");
//		po.setGjz("域名");
//		po.setYys(y);
//		po.setYl1(4);
//		po.setLabel("其他");
//		mailGKZBMapper.insert(po);
	}
		}
	}
	}

}
