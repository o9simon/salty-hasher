package com.github.o9simon.saltyhasher;

import java.security.*;

public class Hasher {

	public String md5(String value) {
	   return hash(value, "MD5");
	}
	
	public String sha1(String value) {
	   return hash(value, "SHA1");
	}
	
	private String hash(String value, String algorithm) {
		try {
	        MessageDigest md = MessageDigest.getInstance(algorithm);
	        byte[] array = md.digest(value.getBytes());
	        StringBuffer sb = new StringBuffer();
	        for (int i = 0; i < array.length; ++i) {
	          sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1,3));
	       }
	        return sb.toString();
	    } catch (NoSuchAlgorithmException e) {
	    	return "";
	    }
	}
	
}
