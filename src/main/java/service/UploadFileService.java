package service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import javax.servlet.http.Part;

public class UploadFileService {
	private static final String UPLOAD_DIR = "D:\\BTLJAVA\\BTLJAVAWEB_N16\\src\\main\\webapp\\img\\";
	
	
	public  String uploadFile(Part filePart,String folder) {	
		File uploadDir = new File(UPLOAD_DIR+folder);
        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }
        
        try {
        	String filename =System.currentTimeMillis()+"-"+Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
			filePart.write(UPLOAD_DIR+folder+File.separator+filename);
			return filename;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}
}
