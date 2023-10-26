package com.kr.changepoint.autoreply.controller;

import com.kr.changepoint.autoreply.config.BrowserDriver;
import com.kr.changepoint.autoreply.service.NaverAutoReplyService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@RequiredArgsConstructor
@Controller
@Transactional
public class NaverAutoReplyController {

  @Autowired
  private final NaverAutoReplyService naverAutoReplyService;

  @GetMapping("/reply")
  @ResponseBody
  public void naverAutoReply() throws InterruptedException {
    naverAutoReplyService.replyComment();
  }

}
