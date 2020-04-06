package iie.cas.po.primary;

public class ExportCsv {
	private int id;
	private String name;
	private int status; //0-未执行  1-执行中  2-已完成（可下载） 3-无数据
	private String sqls;
	private String stime;
	private String etime;
	private String numSql;
	private String userName;
	private String path;
	private int num;//总数
	private int completed;//已导出的数量
	private int logType;
	
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getCompleted() {
		return completed;
	}
	public void setCompleted(int completed) {
		this.completed = completed;
	}
	public String getStime() {
		return stime;
	}
	public void setStime(String stime) {
		this.stime = stime;
	}
	public String getEtime() {
		return etime;
	}
	public void setEtime(String etime) {
		this.etime = etime;
	}
	public int getLogType() {
		return logType;
	}
	public void setLogType(int logType) {
		this.logType = logType;
	}
	private String yl1;
	private String yl2;
	private String yl3;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	public String getSqls() {
		return sqls;
	}
	public void setSqls(String sqls) {
		this.sqls = sqls;
	}
	public String getNumSql() {
		return numSql;
	}
	public void setNumSql(String numSql) {
		this.numSql = numSql;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getYl1() {
		return yl1;
	}
	public void setYl1(String yl1) {
		this.yl1 = yl1;
	}
	public String getYl2() {
		return yl2;
	}
	public void setYl2(String yl2) {
		this.yl2 = yl2;
	}
	public String getYl3() {
		return yl3;
	}
	public void setYl3(String yl3) {
		this.yl3 = yl3;
	}
	
	

}
