package test.test1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class test {
    @RequestMapping(method = RequestMethod.GET, path = "/")
    public String test1(){
        return "test.html";
        // template에서 경로로 찾음
    }
}