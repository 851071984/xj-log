package iie.cas.po.primary;

public class AreaCodeT {
	private int id;
	private String mc;
	private Integer fid;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMc() {
		return mc;
	}
	public void setMc(String mc) {
		this.mc = mc;
	}
	public Integer getFid() {
		return fid;
	}
	public void setFid(Integer fid) {
		this.fid = fid;
	}
	@Override
	public String toString() {
		return "AreaCodeT [id=" + id + ", mc=" + mc + ", fid=" + fid + "]";
	}
	

}
