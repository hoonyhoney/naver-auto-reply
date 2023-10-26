package com.kr.changepoint.autoreply.service;

import com.kr.changepoint.autoreply.config.ChromiumDriver;
import com.kr.changepoint.autoreply.domain.Login;
import com.kr.changepoint.autoreply.dto.LoginDto;
import com.kr.changepoint.autoreply.repository.LoginRepository;
import jakarta.persistence.EntityManager;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.util.List;
import java.util.NoSuchElementException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Slf4j
@Service
@RequiredArgsConstructor
public class NaverAutoReplyService {

  @Autowired
  LoginRepository loginRepository;

  @Autowired
  ChromiumDriver chromiumDriver;

  EntityManager em;



  /**
   * 1. 'blog' 포함 && ReplyYn 'N'인 refer주소목록을 가져온다.
   * 2. 네이버로그인하기
   * 2. 댓글창 페이지로 이동
   * 3. 댓글입력 등록,(메시지 랜덤하게) 클릭
   * 4. 몇초간 쉬었다가 다음
   */

  public void replyBookComment() throws InterruptedException {

    JavascriptExecutor js = (JavascriptExecutor) chromiumDriver.driver;
    for(int i=1; i<2; i++) {
      chromiumDriver.open("https://section.blog.naver.com/Search/Post.naver?pageNo=" + i + "&rangeType=ALL&orderBy=sim&keyword=%ED%83%9C%EA%B5%AD%20%EC%82%B4%EA%B8%B0");
      WebElement contents = chromiumDriver.findOneByXpath("//*[@id=\"content\"]/section/div[2]");
      List<WebElement> alinkList = contents.findElements(By.xpath("//*[@id=\"content\"]/section/div[2]/div[1]/div/div[1]/div[1]/a[1]"));
      for (WebElement alink : alinkList) {
        String href = alink.getAttribute("href");
        StringBuilder sb = new StringBuilder();
        sb.append(href);
        String mhref = sb.insert(8, "m.").toString();
        chromiumDriver.open(mhref);
        Thread.sleep(2000);
        js.executeScript("window.scrollTo({top:document.body.scrollHeight, behavior:'smooth'})");
        WebElement commentBaloon = chromiumDriver.findOneByXpath("//*[@id=\"ct\"]/div[4]/div[3]/div/div[2]/a[1]");
        commentBaloon.click();
      }

    }

  }

  private void clickCommentBaloon(JavascriptExecutor js) throws InterruptedException {
    try {
      WebElement balloon = chromiumDriver.findOneByXpath("//*[@id=\"ct\"]/div[4]/div[3]/div/div[2]/a[1]");
      Thread.sleep(1000);
      js.executeScript("arguments[0].click();", balloon);
      Thread.sleep(2000);
    }catch(JavascriptException e){
      log.info("오브젝트 없음");
    }
  }

  private void writeComment(JavascriptExecutor js,String message) throws InterruptedException {
    try {
      WebElement replyArea = chromiumDriver.findOneByXpath("//*[@id=\"naverComment\"]/div/div[7]/div[1]/form/fieldset/div/div/div[1]");
      Thread.sleep(1000);
      js.executeScript("window.scrollTo({top:document.body.scrollHeight, behavior:'smooth'})");
      js.executeScript("arguments[0].click();", replyArea);
      Thread.sleep(1000);
      WebElement input = chromiumDriver.findOneByXpath("//*[@id=\"naverComment__write_textarea\"]");
      input.sendKeys(message);
      WebElement regiButton = chromiumDriver.findOneByXpath("//*[@id=\"naverComment\"]/div/div[7]/div[1]/form/fieldset/div/div/div[6]/button");
      Thread.sleep(1000);
      regiButton.click();
    }catch(Exception e){
      log.info("오브젝트 없음");
    }
  }

  private void login() throws InterruptedException {
    WebElement loginButton = chromiumDriver.findOneByXpath("//*[@id=\"account\"]/div/a");
    loginButton.click();
    WebElement idLine = chromiumDriver.findOneByXpath("//*[@id=\"id_line\"]");
    WebElement pwLine = chromiumDriver.findOneByXpath("//*[@id=\"pw_line\"]");
    WebElement inputId= chromiumDriver.findOneByXpath("//*[@id=\"id\"]");
    WebElement inputPw= chromiumDriver.findOneByXpath("//*[@id=\"pw\"]");
    WebElement loginBtn= chromiumDriver.findOneByXpath("//*[@id=\"log.login\"]");

    idLine.click();
    StringSelection id = new StringSelection("85babe");
    System.setProperty("java.awt.headless","false");
    Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
    clipboard.setContents(id, id);

    Thread.sleep(1000);
    inputId.sendKeys(Keys.CONTROL+"v");

    /***
     * 클립보드로 복븥, 직접입력시 capcha로 넘어감
     */
    StringSelection pw = new StringSelection("cpdlswl123!");
    Clipboard clipboard2 = Toolkit.getDefaultToolkit().getSystemClipboard();
    clipboard2.setContents(pw, pw);

    pwLine.click();
    Thread.sleep(1000);
    inputPw.sendKeys(Keys.CONTROL+"v");
    Thread.sleep(1000);
    loginBtn.click();
  }

  public boolean duplicateCommentCheck(){
    try {
      String address = "https://rarecoin.changepoint.kr";
      List<WebElement> spanList = chromiumDriver.findAllByCss("span");
      for (WebElement span : spanList) {
        String text = span.getText();
        if (text.contains(address)) {
          return true;
        }
      }
      return false;
    }catch (Exception e){
      return true;
    }
  }

}
