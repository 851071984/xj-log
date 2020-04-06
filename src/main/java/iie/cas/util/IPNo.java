package iie.cas.util;

public class IPNo {
	 public static String 除去空格(String IP){//去掉IP字符串前后所有的空格  
	        while(IP.startsWith(" ")){  
	               IP= IP.substring(1,IP.length()).trim();  
	            }  
	        while(IP.endsWith(" ")){  
	               IP= IP.substring(0,IP.length()-1).trim();  
	            }  
	        return IP;  
	    }  
	      
	    public static boolean isIp(String IP){//判断是否是一个IP  
	        boolean b = false;  
	        IP = 除去空格(IP);  
	        if(IP.matches("\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}")){  
	            String s[] = IP.split("\\.");  
	            if(Integer.parseInt(s[0])<256)  
	                if(Integer.parseInt(s[1])<256)  
	                    if(Integer.parseInt(s[2])<256)  
	                        if(Integer.parseInt(s[3])<256)  
	                            b = true;  
	        }  
	        return b;  
	    }  
	  
	    public static void main(String[] args) {  
	        String s =" 111.110.133.244 ";  
	        IPNo test = new IPNo();
	        System.out.println(IPNo.isIp(s));  
	    }  
}
