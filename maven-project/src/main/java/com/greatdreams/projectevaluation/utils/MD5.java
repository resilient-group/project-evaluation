package com.greatdreams.projectevaluation.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/** 
 * 标准MD5加密方法，使用java类库的security包的MessageDigest类处理 <BR> 
 * 也可变为非标准MD5，请修改下面的移位算法 
 *   
 *  
 */  
public class MD5 {
    /** 
     * 获得MD5加密密码的方法 
     */  
	public static String getMD5ofStr(String origStr){
		String origMD5 = null;
		try {
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			byte[] digest = md5.digest(origStr.getBytes());
			origMD5 = byteArray2HexStr(digest);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return origMD5;
	}
	
    /** 
     * 处理字节数组得到MD5密码的方法 
     */
	private static String byteArray2HexStr(byte[] bs) {
		//String hexStr = null;
		StringBuffer sb = new StringBuffer();
		for(byte b : bs){
			sb.append(byte2HexStr(b));
		}
		return sb.toString();
	}
	 /** 
     * 字节标准移位转十六进制方法 
     */  
	private static String byte2HexStr(byte b) {
		String hexStr = null;
		int n = b;
		if(n < 0){
			//若需要自定义加密,修改这个移位算法即可
			n = n & 0x7F + 128;
		}
		hexStr = Integer.toHexString(n/16) + Integer.toHexString(n%16);
		return hexStr;
	}
	
	 /** 
     * 提供一个MD5多次加密方法 
     */  
    public static String getMD5ofStr(String origString, int times) { 
    	String md5Str = origString;
    	for(int i = 0; i < times; i++){
    		md5Str = getMD5ofStr(md5Str);
    	}
    	return md5Str;
    }
    
    /** 
     * 密码验证方法 
     */  
    public static boolean verifyPassword(String inputStr, String MD5Code) { 
    	//return MD5Code.equals(getMD5ofStr(inputStr));
    	return getMD5ofStr(inputStr).equals(MD5Code);
    }
    /** 
     * 多次加密时的密码验证方法 
     */  
    public static boolean verifyPassword(String inputStr, String MD5Code,  
            int times) {  
        return getMD5ofStr(inputStr, times).equals(MD5Code);  
    }  
	public static void main(String[] args){
		//测试byte
		byte b = -5;
		int n = b;
		System.out.println(b);
		System.out.println(n);
		String s = Integer.toHexString(n/16) + Integer.toHexString(n%16);
		System.out.println(s);
		
		//测试移位操作
		int i = -5;
		System.out.println(Integer.toBinaryString(i));
		System.out.println(Integer.toHexString(i));
		i = i & 0x7F + 128;
		System.out.println(i);
		System.out.println(Integer.toBinaryString(i));
	}
}
