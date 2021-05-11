package life.majiang.community.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServlet;

/**
 * @ClassName IndexController
 * @Description TODO
 * @date 2021/5/11 16:59
 * @Version 1.0
 */
@Controller
public class IndexController extends HttpServlet {

    @GetMapping("/")
    public String index(){
        return "index";
    }
}
