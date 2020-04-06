//package iie.cas.task;
//
//import java.io.IOException;
//import java.nio.charset.StandardCharsets;
//import java.nio.file.Files;
//import java.nio.file.Paths;
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.ApplicationArguments;
//import org.springframework.boot.ApplicationRunner;
//import org.springframework.scheduling.annotation.EnableScheduling;
//import org.springframework.stereotype.Component;
//
//import com.alibaba.fastjson.JSONObject;
//
//import iie.cas.dao.gbase.IPGKZBMapper;
//import iie.cas.po.IPGKZBLogPo;
//@Component
//@EnableScheduling
//public class HMDFile implements ApplicationRunner{
//	@Autowired
//	private IPGKZBMapper iPGKZBMapper;
//	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//	@Override
//	public void run(ApplicationArguments args) throws Exception {
//		try {
//			Files.lines(Paths.get("D:/home/block/t_ip_gkzb_log.txt"), StandardCharsets.UTF_8).forEach(data -> {
//				JSONObject jsStr = JSONObject.parseObject(data);
//				IPGKZBLogPo po=new IPGKZBLogPo();
//				po.setBhsj(sdf.format(new Date()));
//				po.setPzid(jsStr.get("PZID")+"");
//				po.setFlid(Integer.valueOf(jsStr.get("FLID")+""));
//				po.setXzid(Integer.valueOf(jsStr.get("XZID")+""));
//				po.setLhid(Integer.valueOf(jsStr.get("LHID")+""));
//				po.setYdy(jsStr.get("YDY")+"");
//				po.setMddy(jsStr.get("MDDY")+"");
//				po.setPzlx((short) 201);
//				po.setGklb(Short.valueOf(jsStr.get("GKLB")+""));
//				po.setQdjip(20974879);
//				po.setSip("1867672612");
//				po.setDip("1114444046");
//				po.setSport(Integer.valueOf(jsStr.get("SPORT")+""));
//				po.setDport(Integer.valueOf(jsStr.get("DPORT")+""));
//				po.setProtocol(6);
//				po.setProtoId(jsStr.get("PROTO_ID")+"");
//				po.setDetailId(jsStr.get("DETAIL_ID")+"");
//				po.setYys(2);
//				po.setYl1(Integer.valueOf(jsStr.get("YL1")+""));
//				po.setYl2(Integer.valueOf(jsStr.get("YL2")+""));
//				po.setYl3(jsStr.get("YL3")+"");
//				po.setYl4(jsStr.get("YL4")+"");
//				po.setYl5(jsStr.get("YL5")+"");
//				po.setLabel("海尔兄弟");
//				iPGKZBMapper.insert(po);
//			});
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//	}
//	public static void main(String[] args) {
//		SimpleDateFormat sd=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		
////			System.out.println(new Date().getTime()/1000);
//
//			System.out.println(sd.format(1563453477*1000L));
//
////			1542295303
//		
//	}
//
//}
