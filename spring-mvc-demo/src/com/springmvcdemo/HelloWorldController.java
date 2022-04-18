package com.springmvcdemo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;
@RequestMapping("/hello")
@Controller
public class HelloWorldController {
    @RequestMapping("/showForm") //processForm
    public String showForm(){  //helloword
        return "helloworld-form";
    }
    @RequestMapping("/processForm")
    public String processForm(){
        return  "helloworld";
    }
//    prideyi nauja metoda kad galetume perskaityti duomenis ir sudeti i modeli
@RequestMapping("/processFormVersionTwo")
    public String letsDhoutDude(HttpServletRequest request, Model model){
//       Nuskaityt uzklausos parametra is html formos
        String name = request.getParameter("studentName");
//        Convertuoti duomenis i didziasias raides
        name = name.toUpperCase();
//        Sukurti zinute
        String result = "Eee" + name;
//        Zinutes pridejimas modeliui
        model.addAttribute("message", result);
        return "helloworld";
    }
    @RequestMapping("/processFormVersionThree")
    public String processFormVersionThree(
            @RequestParam("studentName") String name,
            Model model){
//        Convertuoti duomenis i didziasias raides
        name = name.toUpperCase();
//        Sukurti zinute
        String result = "Labas mano drauge" + name;
//        Zinutes pridejimas modeliui
        model.addAttribute("message", result);
        return "helloworld";
    }

}
