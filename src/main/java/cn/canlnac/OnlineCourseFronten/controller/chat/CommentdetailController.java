package cn.canlnac.OnlineCourseFronten.controller.chat;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by HaMi on 2016/12/8.
 */
@Controller
@RequestMapping("commentdetail")
public class CommentdetailController {
    @RequestMapping("show")
    public String showIndex(HttpServletRequest request, HttpServletResponse response, ModelMap model) throws Exception {
        return "/frontend/commentdetail";
    }
}