package iie.cas.po.primary;

import java.util.Map;

public class UserCheckMorePo {
	private String accessToken;
	private boolean areaCheck;
	private int matchType=0;
	private Map<String,String> modeluAction;
	public String getAccessToken() {
		return accessToken;
	}
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
	public boolean isAreaCheck() {
		return areaCheck;
	}
	public void setAreaCheck(boolean areaCheck) {
		this.areaCheck = areaCheck;
	}
	public int getMatchType() {
		return matchType;
	}
	public void setMatchType(int matchType) {
		this.matchType = matchType;
	}
	public Map<String, String> getModeluAction() {
		return modeluAction;
	}
	public void setModeluAction(Map<String, String> modeluAction) {
		this.modeluAction = modeluAction;
	}
	

}
