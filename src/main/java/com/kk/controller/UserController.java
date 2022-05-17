package com.kk.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.kk.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class UserController {
    private final Logger logger= LoggerFactory.getLogger(UserController.class);

    @RequestMapping("/login")
    @ResponseBody
    public Object login(@RequestBody String data, HttpServletRequest request){
        logger.info("data:{}",data);

        JSONObject json =JSON.parseObject(data);
        String code=json.get("code").toString();
        HttpSession httpsession=request.getSession();
        httpsession.setAttribute("code",code);

        String sessionId=httpsession.getId();
        User user=new User();
        user.setSessionId(sessionId);
        user.setWechatCode(code);
        return user;

    }
}
