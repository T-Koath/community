package life.majiang.community.controller;

import life.majiang.community.dto.PaginationDTO;
import life.majiang.community.mapper.UserMapper;
import life.majiang.community.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

/**
 * 主页面
 * @ClassName IndexController
 * @Description TODO
 * @date 2021/5/11 16:59
 * @Version 1.0
 */
@Controller
public class IndexController extends HttpServlet {

    @Autowired
    private QuestionService questionService;

    @GetMapping("/")
    public String index(HttpServletRequest request,
                        Model model,
                        @RequestParam(name = "page",defaultValue = "1") Integer page,
                        @RequestParam(name = "size",defaultValue = "5") Integer size
                         ) {
        PaginationDTO paginationDTO = questionService.list(page,size);
        model.addAttribute("pagination",paginationDTO);
        return "index";
    }
}

