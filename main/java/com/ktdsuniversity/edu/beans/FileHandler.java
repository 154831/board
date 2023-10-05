package com.ktdsuniversity.edu.beans;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.UUID;

import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import com.ktdsuniversity.edu.exceptions.FileNotExistsException;

// @Component 라고 붙여서 이 기능을 쓸 수도 있음.
// 스프링이 이 클래스로 bean 을 생성할거냐 말거냐를 결정하는 인자
public class FileHandler {
	
	/**
	 * 파일 저장위치
	 */
	private String baseDir;
	/**
	 * 파일 명 난독화 처리 여부
	 */
	private boolean enableObfuscation;
	/**
	 * 확장자를 숨길지에 대한 여부 
	 */
	private boolean enableObfuscationHideExt;
		
	public void setEnabeObfuscationHideExt(boolean enabeObfuscationHideExt) {
		this.enableObfuscationHideExt = enabeObfuscationHideExt;
	}
	public void setEnableObfuscation(boolean enableObfuscation) {
		this.enableObfuscation = enableObfuscation;
	}
	public void setBaseDir(String baseDir) {
		this.baseDir = baseDir;
	}
	
	/**
	 * 서버에 등록한 파일을 반환한다.
	 * @param fileName 찾아서 다운로드 받을 파일 명
	 * @return 파일 객체
	 */
	public File getStoredFile(String fileName) {
		return new File (baseDir, fileName);
		
	}
	
	/**
	 * 파일 다운로드를 처리한다.
	 * @param downloadFile 다운로드 시킬 서버의 파일 객체.
	 * @param downloadFileName 브라우저에 전달할 파일의 이름
	 * @return 다운로드 리소스
	 */
	public ResponseEntity<Resource> getResponseEntity(File downloadFile, String downloadFileName) {
		
		// HTTP 응답의 Header 정보를 생성한다. 
		HttpHeaders header = new HttpHeaders();
		// HTTP 응답 Header 에 파일을 첨부하여 보내도록 설정한다. 
			header.add(HttpHeaders.CONTENT_DISPOSITION,
					"attachment; filename=" +downloadFileName);
		// 다운로드 할 파일의 리소스 (Byte)를 생성한다.
		InputStreamResource resource;
		try {
			resource = new InputStreamResource(new FileInputStream(downloadFile));
		} catch (FileNotFoundException e) {
			throw new FileNotExistsException ("파일이 존재하지 않습니다.");
		}
		
		// 응답 객체를 직접 생성한다. 
		return ResponseEntity.ok() // status = 200
							 .headers(header) //http header 설정
							 .contentLength(downloadFile.length()) // 다운로드할 파일의 크기
							 // 다운로드할 파일의 타입
							 //application/octet-stream: 모든 파일
							 .contentType(MediaType.parseMediaType("application/octet-stream"))
							 // 다운로드할 파일의 Resource(Byte)
							 .body(resource);
	}

	
	private String getObfuscationFileName(String fileName) {
		if (enableObfuscation) {
			// 파일명에서 확장자를 분리한다.
			String ext = fileName.substring (fileName.lastIndexOf("."));
			//현재 시간을 기준으로 난독화된 ㅌ코드를 받아온다.
			String obfuscationName = UUID.randomUUID().toString();
			//확장자를 숨김처리 설정했다면
			if (enableObfuscationHideExt) {
				return obfuscationName;
			}
			// 확장자 숨김처리 되지 않았다면
			// 난독화된 코드 뒤에 확장자를 붙여 반환한다.
			return obfuscationName + ext;
		}
		return fileName;
	}

	public StoredFile storeFile(MultipartFile multipartFile) {
		
		// 사용자가 파일을 업로드 하지 않았다면 null 을 반환한다. 
		if (multipartFile == null || multipartFile.isEmpty()) {
			return null;
		}
		
		//사용자가 업로드한 파일의 이름
		String originalFileName = multipartFile.getOriginalFilename();
		// 사용자가 업로드 한 파일의 이름을 난독화 설정에 따라 받아온다. 
		String fileName = getObfuscationFileName(originalFileName);
		//파일이 저장될 위치를 지정한다.
		File storePath = new File(baseDir, fileName);
		// 만약 파일이 저장될 위치(폴더)가 존재하지 않는다면, 
		if (!storePath.getParentFile().exists()) {
		// 폴더를 생성해준다.
			storePath.getParentFile().mkdirs();
		}
		// 사용자가 업로드한 파일을 파일이 저장될 위치로 이동시킨다.
		
		try {
			multipartFile.transferTo(storePath);
		} catch (IllegalStateException | IOException e) {
			//업로드한 파일을 이동중에 예외 발생 시,
			// 업로드를 실패한 것이므로 null 반환
			return null;
		}
		// 업로드 결과를 반환한다. 
		return new StoredFile(originalFileName, storePath);	
	}
		
	
	// Nested class = 클래스 안의 클래스 
	public class StoredFile {

		private String fileName;
		private String realFileName;
		private String realFilePath;
		private long fileSize;
		
		/**
		 * 업로드한 파일의 정보를 세팅한다.
		 */
		public StoredFile (String fileName, File storeFile ) {
			this.fileName= fileName;
			this.realFileName = storeFile.getName();
			this.realFilePath = storeFile.getAbsolutePath();
			this.fileSize = storeFile.length();
		}
		public String getFileName() {
			return fileName;
		}
	
		public String getRealFileName() {
			return realFileName;
		}
	
		public String getRealFilePath() {
			return realFilePath;
		}
	
		public long getFileSize() {
			return fileSize;
		}		
	}
}

