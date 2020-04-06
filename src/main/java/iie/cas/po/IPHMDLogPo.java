package iie.cas.po;

import java.text.SimpleDateFormat;
import java.util.Date;

public class IPHMDLogPo {

	private long BHSJ = 0L;// 捕获时间
	private String PZID = "";// 配置ID
	private int FLID = 0;// 分类ID
	private int XZID = 0; // 性质ID
	private int LHID = 0; // 来函ID
	private String YDY = "";// 源地域
	private String MDDY = "";// 目的地域
	private int PZLX = 0;// 配置类型
	private int GKLB = 0;// 管控类别
	private String QDJIP = ""; // 前端机IP
	private String SIP = "";// 源地址
	private String DIP = ""; // 目的地址
	private int SPORT = 0; // 源端口
	private int DPORT = 0; // 目的端口
	private int PROTOCOL = 0;// 传输协议
	private String PROTO_ID = ""; // 大类ID
	private String DETAIL_ID = "";// 详细ID
	private int YYS = 1; // 运营商名称
	private int YL1 = 0;
	private int YL2 = 0;
	private String YL3 = "";
	private String YL4 = "";
	private String YL5 = "";

	public long getBHSJ() {
		return BHSJ;
	}

	public void setBHSJ(long bHSJ) {
		BHSJ = bHSJ;
	}

	public String getPZID() {
		return PZID;
	}

	public void setPZID(String pZID) {
		PZID = pZID;
	}

	public int getFLID() {
		return FLID;
	}

	public void setFLID(int fLID) {
		FLID = fLID;
	}

	public int getXZID() {
		return XZID;
	}

	public void setXZID(int xZID) {
		XZID = xZID;
	}

	public int getLHID() {
		return LHID;
	}

	public void setLHID(int lHID) {
		LHID = lHID;
	}

	public String getYDY() {
		return YDY;
	}

	public void setYDY(String yDY) {
		YDY = yDY;
	}

	public String getMDDY() {
		return MDDY;
	}

	public void setMDDY(String mDDY) {
		MDDY = mDDY;
	}

	public int getPZLX() {
		return PZLX;
	}

	public void setPZLX(int pZLX) {
		PZLX = pZLX;
	}

	public int getGKLB() {
		return GKLB;
	}

	public void setGKLB(int gKLB) {
		GKLB = gKLB;
	}

	public String getQDJIP() {
		return QDJIP;
	}

	public void setQDJIP(String qDJIP) {
		QDJIP = qDJIP;
	}

	public String getSIP() {
		return SIP;
	}

	public void setSIP(String sIP) {
		SIP = sIP;
	}

	public String getDIP() {
		return DIP;
	}

	public void setDIP(String dIP) {
		DIP = dIP;
	}

	public int getSPORT() {
		return SPORT;
	}

	public void setSPORT(int sPORT) {
		SPORT = sPORT;
	}

	public int getDPORT() {
		return DPORT;
	}

	public void setDPORT(int dPORT) {
		DPORT = dPORT;
	}

	public int getPROTOCOL() {
		return PROTOCOL;
	}

	public void setPROTOCOL(int pROTOCOL) {
		PROTOCOL = pROTOCOL;
	}

	public String getPROTO_ID() {
		return PROTO_ID;
	}

	public void setPROTO_ID(String pROTO_ID) {
		PROTO_ID = pROTO_ID;
	}

	public String getDETAIL_ID() {
		return DETAIL_ID;
	}

	public void setDETAIL_ID(String dETAIL_ID) {
		DETAIL_ID = dETAIL_ID;
	}

	public int getYYS() {
		return YYS;
	}

	public void setYYS(int yYS) {
		YYS = yYS;
	}

	public int getYL1() {
		return YL1;
	}

	public void setYL1(int yL1) {
		YL1 = yL1;
	}

	public int getYL2() {
		return YL2;
	}

	public void setYL2(int yL2) {
		YL2 = yL2;
	}

	public String getYL3() {
		return YL3;
	}

	public void setYL3(String yL3) {
		YL3 = yL3;
	}

	public String getYL4() {
		return YL4;
	}

	public void setYL4(String yL4) {
		YL4 = yL4;
	}

	public String getYL5() {
		return YL5;
	}

	public void setYL5(String yL5) {
		YL5 = yL5;
	}

	@Override
	public String toString() {
		return "IpPo [BHSJ=" + BHSJ + ", PZID=" + PZID + ", FLID=" + FLID + ", XZID=" + XZID + ", LHID=" + LHID
				+ ", YDY=" + YDY + ", MDDY=" + MDDY + ", PZLX=" + PZLX + ", GKLB=" + GKLB + ", QDJIP=" + QDJIP
				+ ", SIP=" + SIP + ", DIP=" + DIP + ", SPORT=" + SPORT + ", DPORT=" + DPORT + ", PROTOCOL=" + PROTOCOL
				+ ", PROTO_ID=" + PROTO_ID + ", DETAIL_ID=" + DETAIL_ID + ", YYS=" + YYS + ", YL1=" + YL1 + ", YL2="
				+ YL2 + ", YL3=" + YL3 + ", YL4=" + YL4 + ", YL5=" + YL5 + "]";
	}
	

}
