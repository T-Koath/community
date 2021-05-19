package life.majiang.community.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @ClassName ProfileController
 * @Description TODO
 * @date 2021/5/19 14:49
 * @Version 1.0
 */
@Controller
public class ProfileController {

    @GetMapping("/profile/{action}")
    public String profile(@PathVariable(name = "action")String action,Model model){
        if ("questions".equals(action)){
            model.addAttribute("section","questions");
            model.addAttribute("sectionName","我的提问");
        } else if ("replies".equals(action)){
            model.addAttribute("section","replies");
            model.addAttribute("sectionName","最新回复");
        }

        return "profile";
    }
}
