package bab.filetobase64;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Base64;

public class FileToBase64{
	public static String loadFile(final File file){
		try{
			final InputStream is = new FileInputStream(file);
			final long length = file.length();
			final byte[] bytes = new byte[(int)length];
			for(int offset = 0, numRead = 0; offset < bytes.length && (numRead = is.read(bytes, offset, bytes.length - offset))>=0; offset+=numRead){
				System.out.println("offset: "+offset+"numRead: "+numRead+", bytes: "+bytes);
			}
			final int length2 = bytes.length;
			is.close();
			final String  base64_msg = Base64.getEncoder().encodeToString(bytes);
			System.out.println(">>>>length2:"+length2+", base64: "+base64_msg);
			return base64_msg;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
}