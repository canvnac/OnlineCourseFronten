package cn.canlnac.OnlineCourseFronten.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by HaMi on 2016/12/13.
 */
@Controller
@RequestMapping("setprofile")
public class SetprofileController {
    @RequestMapping("showSetprofile")
    public String showIndex(HttpServletRequest request, HttpServletResponse response, ModelMap model) throws Exception {
        return "/frontend/setprofile";
    }
}
