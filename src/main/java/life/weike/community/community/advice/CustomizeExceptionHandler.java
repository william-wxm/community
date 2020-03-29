package life.weike.community.community.advice;

import life.weike.community.community.Exception.CustomizeException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class CustomizeExceptionHandler  {
    @ExceptionHandler(Exception.class)
    ModelAndView handle(Throwable e , Model model){
        if (e instanceof CustomizeException){
            model.addAttribute("message",e.getMessage());
        }else {
            model.addAttribute("message","服务器罢工了，您等会再试试吧！！！");
        }
        return new ModelAndView("error");
    }
}
