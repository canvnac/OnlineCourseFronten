package cn.canlnac.OnlineCourseFronten.controller.message;

import cn.canlnac.OnlineCourseFronten.service.ChatService;
import cn.canlnac.OnlineCourseFronten.service.FavoriteService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by HaMi on 2016/12/30.
 */
@Controller
@RequestMapping("message")
public class MessageController {

    @Autowired
    FavoriteService favoriteService;

    @Autowired
    ChatService chatService;

    @RequestMapping("show")
    public String showIndex(HttpServletRequest request, HttpServletResponse response, ModelMap model) throws Exception {

        return "/frontend/personal";
    }
}
