package handler;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.ReviewVO;
import net.coobird.thumbnailator.Thumbnails;

public class FileHandler {
	private static Logger log = LoggerFactory.getLogger(FileHandler.class);
	private final String UTF8 = "utf-8";
	private int isUp;
	private String insertfileName;
	private String updatefileName;

	public ReviewVO postFile(String savePath, HttpServletRequest req) {

		try {
			File fileDir = new File(savePath);

			DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
			fileItemFactory.setRepository(fileDir);
			fileItemFactory.setSizeThreshold(2 * 1024 * 1024);
			// 여기까지 파일저장수단

			ReviewVO rvo = new ReviewVO();
			ServletFileUpload fileUpload = new ServletFileUpload(fileItemFactory);

			try {
				String old_file = null;
				List<FileItem> itemList = fileUpload.parseRequest(req);
				for (FileItem item : itemList) {
					switch (item.getFieldName()) {
					case "pno":
						rvo.setPno(Integer.parseInt(item.getString(UTF8)));
						break;
					case "rno":
						rvo.setRno(Long.parseLong(item.getString(UTF8)));
						break;
					case "title":
						rvo.setTitle(item.getString(UTF8));
						break;
					case "writer":
						rvo.setWriter(item.getString(UTF8));
						break;
					case "description":
						rvo.setDescription(item.getString(UTF8));
						break;
					case "image_file":
						if (item.getSize() > 0) {
							insertfileName = item.getName() // 아이템이름은 경로가 전체 포함
									.substring(item.getName().lastIndexOf(File.separator) + 1);
							insertfileName = System.currentTimeMillis() + "_" + insertfileName;
							File UploadFilePath = new File(fileDir + File.separator + insertfileName);

							try {
								item.write(UploadFilePath);
								rvo.setImage_file(insertfileName);

								Thumbnails.of(UploadFilePath).size(70, 70)
										.toFile(new File(fileDir + File.separator + "th_" + insertfileName));

								return rvo;
							} catch (Exception e) {

								e.printStackTrace();
							}
						} else {
							return rvo;
						}
						break;
					case "old_file":
						old_file = item.getString(UTF8);
						break;
					case "new_file":
						if (item.getSize() > 0) {

							if (old_file != null) {
								FileHandler fileHandler = new FileHandler();

								isUp = fileHandler.deleteFile(old_file, savePath);
							}
							updatefileName = item.getName().substring(item.getName()
																.lastIndexOf(File.separator) + 1);
							updatefileName = System.currentTimeMillis() + "_" + updatefileName;
							File UploadFilePath = new File(fileDir + File.separator + updatefileName);

							try {

								item.write(UploadFilePath);
								rvo.setImage_file(updatefileName);
								Thumbnails.of(UploadFilePath).size(75, 75)
										.toFile(new File(fileDir + File.separator + "th_" + updatefileName));
								return rvo;

							} catch (Exception e) {
								e.printStackTrace();
							}
						} else {
							rvo.setImage_file(old_file);
							return rvo;
						}
						break;
					default:
						break;
					}

				}
			} catch (NumberFormatException | UnsupportedEncodingException e) {
				e.printStackTrace();
			}

		} catch (FileUploadException e) {
			e.printStackTrace();
		}

		return null;

	}

	public int deleteFile(String imageFileName, String savePath) {
		
		File fileDir = new File(savePath);
		
		File removeFile = new File(fileDir + File.separator + imageFileName);
		File removeThumbFile = new File(fileDir + File.separator + "th_" + imageFileName);
		
		boolean isDel = true;
		
		if(removeFile.exists() || removeThumbFile.exists()) {
			isDel = removeFile.delete();
			log.info(">>> FileHandler Remove {}", isDel ? "OK" : "Fail");
			if(isDel) {
				isDel = removeThumbFile.delete();
				log.info(">>> FileHandler Remove Thumbnail {}", isDel ? "OK" : "Fail");
			}
		}
		
		return isDel ? 1 : 0;
	}
}
