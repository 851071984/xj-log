package iie.cas.task;

import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import iie.cas.po.primary.UserCheckMorePo;
import iie.cas.util.HttpUtils;
import iie.cas.util.HttpsUtils;




public class ce {
	public static void main(String[] args) {
//		net.sf.json.JSONObject dataa=new net.sf.json.JSONObject().fromObject("{" + 
//				"		    'result': 'true'," + 
//				"		    'area': '650000'," + 
//				"		    'code': 200," + 
//				"		    'Access-Token': '257214a8-3e8c-4106-939a-35ac67338ec5'," + 
//				"		    'roleId': '10001'," + 
//				"		    'message': '操作成功'," + 
//				"		    'username': 'yangmeng'" + 
//				"		}");
//		System.out.println(dataa.get("area"));
		
		JSONObject data=new JSONObject();
		Map<String,String> map=new HashMap<>();
		map.put("10", "tycx");
		UserCheckMorePo user=new UserCheckMorePo();
		user.setAccessToken("257214a8-3e8c-4106-939a-35ac67338ec5");
		user.setAreaCheck(true);
		user.setModeluAction(map);
//		JSONObject modeluAction=new JSONObject();
//		modeluAction.put("10", "tycx");
//		data.put("accessToken", "257214a8-3e8c-4106-939a-35ac67338ec5");
//		data.put("areaCheck", true);
//		data.put("modeluAction", modeluAction);
//		data.put("matchType", "root");
		System.out.println(JSON.toJSONString(user));
		String value=HttpsUtils.doPost("http://192.168.66.32:8444/auth/system/check/userCheckMoreAction",JSON.toJSONString(user));
		net.sf.json.JSONObject dataa=net.sf.json.JSONObject.fromObject(value);
		
		System.out.println(dataa);
	
	}

}
