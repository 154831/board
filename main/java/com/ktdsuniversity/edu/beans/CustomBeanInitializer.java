package com.ktdsuniversity.edu.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;

/**
 * Spring 이 직접 Bean으로 만드는 @Component Annotaion 이 적용된
 * Class와 함께 수동으로 Bean 을 만들도록 하는 클래스
 */

@SpringBootConfiguration
public class CustomBeanInitializer {
	
	/**
	 * {@value}는 환경설정파일(application.yml)에서
	 * 설정값을 찾아, 반환하는 Annotation이다.
	 * 문법: ${key.key.key...:기본값} 
	 * 문법: ${key.key.key...:기본값:없다면 차선값} 
	 */
	@Value("${app.multipart.base-dir:C:/uploadFiles}")
	private String baseDir;
	
	@Value("${app.multipart.obfuscation.enable:false}")
	private boolean enableObfuscation;
	
	@Value("${app.multipart.obfuscation.hide-ext.enable:false}")
	private boolean enableObfuscationHideExt;

	/**
	 * @Bean Annotation은 수동으로 Bean을 생성해
	 * Bean Container 에 적재하도록 하는 annotation 입니다.
	 * 
	 * Method 의 반환타입이 Bean타입이 되고,
	 * Method 의 이름이 Bean 이름이 됩니다. 
	 * 
	 * 이 메소드는 반드시 반환이 되어야합니다.
	 * @return
	 */
	
	@Bean
	public FileHandler fileHandler () {
		FileHandler fileHandler = new FileHandler();
		fileHandler.setBaseDir(baseDir);
		fileHandler.setEnableObfuscation(enableObfuscation);
		fileHandler.setEnabeObfuscationHideExt(enableObfuscationHideExt);
		return fileHandler;
	}
}

