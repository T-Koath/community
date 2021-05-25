package life.majiang.community.advice;

import life.majiang.community.exception.CustomizeException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * @ClassName CustomizeExceptionHandler
 * @Description TODO
 * @date 2021/5/25 15:58
 * @Version 1.0
 */
@ControllerAdvice
public class CustomizeExceptionHandler {

    @ExceptionHandler(Exception.class)
    ModelAndView handle(Throwable e , Model model){
        if (e instanceof CustomizeException){
            model.addAttribute("message" , e.getMessage());
        }else{
            model.addAttribute("message","服务器炸啦，请稍后再试!");
        }
        return new ModelAndView("error");
    }
}
