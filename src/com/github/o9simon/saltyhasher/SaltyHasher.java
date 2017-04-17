package com.github.o9simon.saltyhasher;

public class SaltyHasher {

	public static final int BEFORE = 0;
	public static final int AFTER = 1;
	public static final int MIDDLE = 2;
	public static final int INTERLACE_0 = 3;
	public static final int INTERLACE_1 = 4;
	
	public static void main(String[] arg) {
		SaltyHasher hasher = new SaltyHasher();
		System.out.println(hasher.sha1("test", "salt", AFTER));
	}
	
	public String md5(String value, String salt, int type) {
		return (new Hasher()).md5(salt(value, salt, type));
	}
	
	public String sha1(String value, String salt, int type) {
		return (new Hasher()).sha1(salt(value, salt, type));
	}
	
	private String salt(String value, String salt, int pos) {
		if (pos == BEFORE) {
			return salt + value;
		} else if (pos == AFTER) {
			return value + salt;
		} else if (pos == MIDDLE) {
			return insertMiddle(value, salt);
		} else if (pos == INTERLACE_0) {
			return interlaceStrings(salt, value);
		} else /* if (pos == INTERLACE_1)*/ {
			return interlaceStrings(value, salt);
		}
	}
	
	private String insertMiddle(String a, String b) {
		int index = a.length() / 2;
	    String aBegin = a.substring(0,index);
	    String aEnd = a.substring(index);
	    return aBegin + b + aEnd;
	}

	// https://stackoverflow.com/questions/5208163/string-alternating-letters
	private String interlaceStrings(String a, String b) {
	    if (a == null) a = "";
	    if (b == null) b = "";

	    char[] chars = new char[a.length() + b.length()];
	    int index = 0, ia = 0, ib = 0;
	    while (ia<a.length() && ib<b.length()) {
	        chars[index++] = a.charAt(ia++);
	        chars[index++] = b.charAt(ib++);
	    }
	    while (ia<a.length()) {
	        chars[index++] = a.charAt(ia++);
	    }
	    while (ib<b.length()) {
	        chars[index++] = b.charAt(ib++);
	    }

	    return new String(chars);
	}
	
}
