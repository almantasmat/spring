package com.springmvcdemo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class SillyControler {

    @RequestMapping("showForm")
    public String displayForm(){
        return "silly";
    }
}
