package com.nchudinov.keygen.handlers;

import com.nchudinov.keygen.model.LicenseKey;
import org.apache.tomcat.util.codec.binary.Base64;

import java.io.IOException;
import java.nio.charset.StandardCharsets;


public class KeyGenerator {
	
	//todo: add normal keygen :)
	public static String generateKey(LicenseKey licenseKey) {
		return encode(licenseKey.toString().getBytes(StandardCharsets.UTF_8)) + licenseKey.toString();
	}


	private static String encode(byte[] data) {
		return Base64.encodeBase64String(data).replaceAll("(\r\n|\n)", "");
	}

	private static byte[] decode(String data) throws IOException {
		return Base64.decodeBase64(data);
	}
	
//	private static String generateKeyInfo() {
//	}
}
