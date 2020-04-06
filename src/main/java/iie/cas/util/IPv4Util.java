package iie.cas.util;


public class IPv4Util {

    /**
     * 把IP地址转化为字节数组
     * @param ipAddr
     * @return byte[]
     */
/*    public static byte[] ipToBytesByInet(String ipAddr) {
        try {
        	byte[]bb=InetAddress.getByName(ipAddr).getAddress();
        	System.out.println(InetAddress.getByName(ipAddr).getAddress().toString());
            return InetAddress.getByName(ipAddr).getAddress();
        } catch (Exception e) {
            throw new IllegalArgumentException(ipAddr + " is invalid IP");
        }
    }//JTA实践:Spring+ATOMIKOS
*/
    /**
     * 把IP地址转化为int
     * @param ipAddr
     * @return int
     */
/*    public static byte[] ipToBytesByReg(String ipAddr) {
        byte[] ret = new byte[4];
        try {
            String[] ipArr = ipAddr.split("\\.");
            ret[0] = (byte) (Integer.parseInt(ipArr[0]) & 0xFF);
            ret[1] = (byte) (Integer.parseInt(ipArr[1]) & 0xFF);
            ret[2] = (byte) (Integer.parseInt(ipArr[2]) & 0xFF);
            ret[3] = (byte) (Integer.parseInt(ipArr[3]) & 0xFF);
            return ret;
        } catch (Exception e) {
            throw new IllegalArgumentException(ipAddr + " is invalid IP");
        }

    }
*/
    /**
     * 字节数组转化为IP
     * @param bytes
     * @return int
     */
/*    public static String bytesToIp(byte[] bytes) {
        return new StringBuffer().append(bytes[0] & 0xFF).append('.').append(
                bytes[1] & 0xFF).append('.').append(bytes[2] & 0xFF)
                .append('.').append(bytes[3] & 0xFF).toString();
    }
*/
    /**
     * 根据位运算把 byte[] -> int
     * @param bytes
     * @return int
     */
/*    public static int bytesToInt(byte[] bytes) {
        int addr = bytes[3] & 0xFF;
        addr |= ((bytes[2] << 8) & 0xFF00);
        addr |= ((bytes[1] << 16) & 0xFF0000);
        addr |= ((bytes[0] << 24) & 0xFF000000);
        return addr;
    }*/

    /**
     * 把IP地址转化为int
     * @param ipAddr
     * @return int
     */
/*    public static int ipToInt(String ipAddr) {
        try {
            return bytesToInt(ipToBytesByInet(ipAddr));
        } catch (Exception e) {
            throw new IllegalArgumentException(ipAddr + " is invalid IP");
        }
    }
*/
    /**
     * ipInt -> byte[]
     * @param ipInt
     * @return byte[]
     */
/*    public static byte[] intToBytes(int ipInt) {
        byte[] ipAddr = new byte[INADDRSZ];
        ipAddr[0] = (byte) ((ipInt >>> 24) & 0xFF);
        ipAddr[1] = (byte) ((ipInt >>> 16) & 0xFF);
        ipAddr[2] = (byte) ((ipInt >>> 8) & 0xFF);
        ipAddr[3] = (byte) (ipInt & 0xFF);
        return ipAddr;
    }*/

    /**
     * 把int->ip地址
     * @param ipInt
     * @return String
     */
/*    public static String intToIp(int ipInt) {
        return new StringBuilder().append(((ipInt >> 24) & 0xff)).append('.')
                .append((ipInt >> 16) & 0xff).append('.').append(
                        (ipInt >> 8) & 0xff).append('.').append((ipInt & 0xff))
                .toString();
    }
*/
    /**
     * 把192.168.1.1/24 转化为int数组范围
     * @param ipAndMask
     * @return int[]
     */
/*    public static int[] getIPIntScope(String ipAndMask) {

        String[] ipArr = ipAndMask.split("/");
        if (ipArr.length != 2) {
            throw new IllegalArgumentException("invalid ipAndMask with: "
                    + ipAndMask);
        }
        int netMask = Integer.valueOf(ipArr[1].trim());
        if (netMask < 0 || netMask > 31) {
            throw new IllegalArgumentException("invalid ipAndMask with: "
                    + ipAndMask);
        }
        int ipInt = IPv4Util.ipToInt(ipArr[0]);
        int netIP = ipInt & (0xFFFFFFFF << (32 - netMask));
        int hostScope = (0xFFFFFFFF >>> netMask);
        return new int[] { netIP, netIP + hostScope };

    }*/

    /**
     * 把192.168.1.1/24 转化为IP数组范围
     * @param ipAndMask
     * @return String[]
     */
/*    public static String[] getIPAddrScope(String ipAndMask) {
        int[] ipIntArr = IPv4Util.getIPIntScope(ipAndMask);
        return new String[] { IPv4Util.intToIp(ipIntArr[0]),
                IPv4Util.intToIp(ipIntArr[0]) };
    }
*/
    /**
     * 根据IP 子网掩码（192.168.1.1 255.255.255.0）转化为IP段
     * @param ipAddr ipAddr
     * @param mask mask
     * @return int[]
     */
/*    public static int[] getIPIntScope(String ipAddr, String mask) {

        int ipInt;
        int netMaskInt = 0, ipcount = 0;
        try {
            ipInt = IPv4Util.ipToInt(ipAddr);
            if (null == mask || "".equals(mask)) {
                return new int[] { ipInt, ipInt };
            }
            netMaskInt = IPv4Util.ipToInt(mask);
            ipcount = IPv4Util.ipToInt("255.255.255.255") - netMaskInt;
            int netIP = ipInt & netMaskInt;
            int hostScope = netIP + ipcount;
            return new int[] { netIP, hostScope };
        } catch (Exception e) {
            throw new IllegalArgumentException("invalid ip scope express  ip:"
                    + ipAddr + "  mask:" + mask);
        }

    }
*/
    /**
     * 根据IP 子网掩码（192.168.1.1 255.255.255.0）转化为IP段
     * @param ipAddr ipAddr
     * @param mask mask
     * @return String[]
     */
/*    public static String[] getIPStrScope(String ipAddr, String mask) {
        int[] ipIntArr = IPv4Util.getIPIntScope(ipAddr, mask);
        return new String[] { IPv4Util.intToIp(ipIntArr[0]),
                IPv4Util.intToIp(ipIntArr[0]) };
    }*/
    public static String packageToStandard(String packageContent){
    	if(packageContent==null||packageContent.length()==0){
    	}
    	String result="<span>";
    	if(packageContent==null||packageContent.length()==0){
    		return "";
    	}
    	for(int i=0;i<packageContent.length();i++){
    		if((i+1)%2==0){
    			result+=packageContent.charAt(i);
    			if((i+1)%32==16){
    				result+="</span><span></span><span>";
    			}else if((i+1)%32==0){
    				result+="</span></br><span>";
    			}else{
    				result+="</span><span>";
    			}
    		}else{
    			result+=packageContent.charAt(i);
    		}
    	}
    	result+="</span></br>";
    	return result;
    }
    public static long ipToLong(String ipString){  
        long result = 0;  
        java.util.StringTokenizer token = new java.util.StringTokenizer(ipString,".");
        result += Long.parseLong(token.nextToken()); 
        result += Long.parseLong(token.nextToken())<<8;
        result += Long.parseLong(token.nextToken())<<16; 
        result += Long.parseLong(token.nextToken())<<24;  
        return result;  
    } 
    public static String longToIp(long ipLong){  
    	StringBuilder sb=new StringBuilder(); 
    	sb.append(String.valueOf(ipLong&0xFF)).append("."); 
    	sb.append(String.valueOf((ipLong>>8)&0xFF)).append("."); 
    	sb.append(String.valueOf((ipLong>>16)&0xFF)).append("."); 
    	sb.append((ipLong>>24)&0xFF); 
/*        StringBuilder sb = new StringBuilder();  
        sb.append(ipLong>>>24);sb.append(".");  
        sb.append(String.valueOf((ipLong&0x00FFFFFF)>>>16));sb.append(".");  
        sb.append(String.valueOf((ipLong&0x0000FFFF)>>>8));sb.append(".");  
        sb.append(String.valueOf(ipLong&0x000000FF));  */
        return sb.toString();  
    }
/*    public static String longToIp(long ipLong) {   
        //long ipLong = 1037591503;   
        long mask[] = {0x000000FF,0x0000FF00,0x00FF0000,0xFF000000};   
        long num = 0;   
        StringBuffer ipInfo = new StringBuffer();   
        for(int i=0;i<4;i++){   
            num = (ipLong & mask[i])>>(i*8);   
            if(i>0) ipInfo.insert(0,".");   
            ipInfo.insert(0,Long.toString(num,10));   
        }   
        return ipInfo.toString();   
    } 
*/
    /**
     * 判断IP地址的合法性，这里采用了正则表达式的方法来判断
     * return true，合法
     * */
    public static boolean ipCheck(String text) {
        if (text != null && !text.isEmpty()) {
            // 定义正则表达式
            String regex = "^(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|[1-9])\\."
                      +"(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\."
                      +"(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\."
                      +"(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)$";
            // 判断ip地址是否与正则表达式匹配
            if (text.matches(regex)) {
                // 返回判断信息
                return true;
            } else {
                // 返回判断信息
                return false;
            }
        }
        return false;
    }
    public static boolean Isipv4(String ipv4){  
        if(ipv4==null || ipv4.length()==0){  
            return false;//字符串为空或者空串  
        }  
        String[] parts=ipv4.split("\\.");//因为java doc里已经说明, split的参数是reg, 即正则表达式, 如果用"|"分割, 则需使用"\\|"  
        if(parts.length!=4){  
            return false;//分割开的数组根本就不是4个数字  
        }  
        for(int i=0;i<parts.length;i++){  
            try{  
            int n=Integer.parseInt(parts[i]);  
            if(n<0 || n>255){  
                return false;//数字不在正确范围内  
            }  
            }catch (NumberFormatException e) {  
                return false;//转换数字不正确  
            }  
        }  
        return true;  
    }  
    /**
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
//    	System.out.println(ipToLong("192.168.0.1"));
    	System.out.println(longToIp(1953824438));
    	System.out.println(ipToLong("182.254.116.116"));
//    	long l=420090028;
//    	System.out.println(longToIp(420090028));
//    	System.out.println(packageToStandard("4500003c057200004011f3d4c0a80019c0a80001c01a00350028572dd80e010000010000000000000377777706676f6f676c6503636f6d000001000100010001"));
//        String ipAddr = "172.16.10.25";

//        byte[] bytearr = IPv4Util.ipToBytesByInet(ipAddr);
//
//        StringBuffer byteStr = new StringBuffer();
//
//        for (byte b : bytearr) {
//            if (byteStr.length() == 0) {
//                byteStr.append(b);
//            } else {
//                byteStr.append("," + b);
//            }
//        }
//        System.out.println("IP: " + ipAddr + " ByInet --> byte[]: [ " + byteStr
//                + " ]");
//
//        bytearr = IPv4Util.ipToBytesByReg(ipAddr);
//        byteStr = new StringBuffer();
//
//        for (byte b : bytearr) {
//            if (byteStr.length() == 0) {
//                byteStr.append(b);
//            } else {
//                byteStr.append("," + b);
//            }
//        }
//        System.out.println("IP: " + ipAddr + " ByReg  --> byte[]: [ " + byteStr
//                + " ]");
//
//        System.out.println("byte[]: " + byteStr + " --> IP: "
//                + IPv4Util.bytesToIp(bytearr));

//        long ipInt = IPv4Util.ipToLong(ipAddr);
//
//        System.out.println("IP: " + ipAddr + "  --> int: " + ipInt);
//
//        Integer a=420090028;
//        System.out.println("int: " + a + " --> IP: "
//                + IPv4Util.longToIp(ipInt));

//        String ipAndMask = "192.168.1.1/24";
//
//        int[] ipscope = IPv4Util.getIPIntScope(ipAndMask);
//        System.out.println(ipAndMask + " --> int地址段：[ " + ipscope[0] + ","
//                + ipscope[1] + " ]");
//
//        System.out.println(ipAndMask + " --> IP 地址段：[ "
//                + IPv4Util.intToIp(ipscope[0]) + ","
//                + IPv4Util.intToIp(ipscope[1]) + " ]");
//
//        String ipAddr1 = "192.168.1.1", ipMask1 = "255.255.255.0";
//
//        int[] ipscope1 = IPv4Util.getIPIntScope(ipAddr1, ipMask1);
//        System.out.println(ipAddr1 + " , " + ipMask1 + "  --> int地址段 ：[ "
//                + ipscope1[0] + "," + ipscope1[1] + " ]");
//
//        System.out.println(ipAddr1 + " , " + ipMask1 + "  --> IP地址段 ：[ "
//                + IPv4Util.intToIp(ipscope1[0]) + ","
//                + IPv4Util.intToIp(ipscope1[1]) + " ]");

    }
}