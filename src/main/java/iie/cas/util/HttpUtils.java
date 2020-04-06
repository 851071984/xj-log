package iie.cas.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import com.alibaba.fastjson.*;

public class HttpUtils {
	static int timeout = 300000;

	/**
	 * 发送http post请求，编码方式UTF-8
	 * 
	 * @param data
	 * @return
	 * @throws MsgsendException
	 */
	public static String sendPost(JSONObject data, String url) {
		OutputStream outputStream = null;
		HttpURLConnection conn = null;
        
		try {
			URL remoteUrl = new URL(url);
			conn = (HttpURLConnection) remoteUrl.openConnection();

			conn.setDoOutput(true);
			conn.setDoInput(true);
			conn.setRequestProperty("Content-Type", "application/json");  
			conn.setRequestMethod("POST");
			conn.setUseCaches(false);
			conn.setConnectTimeout(timeout);
			conn.setReadTimeout(timeout);
      
			conn.connect();

			// 发送数据
			byte[] datas = data.toString().getBytes("UTF-8");
			outputStream = conn.getOutputStream();
			outputStream.write(datas, 0, datas.length);
			outputStream.flush();

			// 读取返回数据
			InputStream inputStream = conn.getInputStream();
			String res = null;
			try (ByteArrayOutputStream bos = new ByteArrayOutputStream()) {
				byte[] buffer = new byte[512];
				int len = 0;
				while ((len=inputStream.read(buffer)) != -1) {
					bos.write(buffer, 0, len);
				}
				byte[] readBytes = bos.toByteArray();
				res = new String(readBytes, "UTF-8");
			}

			return res;
		} catch (MalformedURLException e) {
			 e.printStackTrace();
		} catch (IOException e) {
             e.printStackTrace();
		} finally {
			if (outputStream != null) {
				try {
					outputStream.close();
				} catch (IOException e) {
					e.printStackTrace();;
				}
			}
			if (conn != null) {
				conn.disconnect();
			}
		}
		return null;
	}

}