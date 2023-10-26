package com.kr.changepoint.autoreply.config;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.context.annotation.Configuration;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;


@Slf4j
@Configuration
@RequiredArgsConstructor
public class ChromiumDriver extends BrowserDriver<ChromeDriver> {

  @PostConstruct
  public void initChromeDriver() {
    ChromeOptions options = new ChromeOptions();
    //options.addArguments("--remote-allow-origins=*"); // 크로스 도메인 허용
    options.addArguments("--remote-debugging-port=9222"); // 포트설정
    options.addArguments("--user-data-dir=C:\\Users\\donghun\\AppData\\Local\\Google\\Chrome\\User Data\\Default\\Cache"); // 쿠키와 캐쉬파일저장
    System.setProperty("webdriver.chrome.driver","C:/workspace/changepoint-autoreply/autoreply/autoreply/src/main/resources/libs/chromedriver-win64/chromedriver.exe");
    //setHeadless();
    //setCustomOption();
    System.out.println("options = " + options);
    this.driver = new ChromeDriver(options);
  }
}

