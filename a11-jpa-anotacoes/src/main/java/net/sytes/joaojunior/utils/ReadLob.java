package net.sytes.joaojunior.utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.File;
import java.io.FileInputStream;


public class ReadLob {

	public byte[] getFoto(String path) throws IOException {
		File file = new File(path);
		byte[] foto = new byte[(int) file.length()];
		FileInputStream fileInputStream = null;
		try {
			fileInputStream = new FileInputStream(file);
			fileInputStream.read(foto);
			fileInputStream.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace(); 
		}
		return foto;
	}
}
