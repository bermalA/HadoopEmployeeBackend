package com.example.homework.Controller;

import com.example.homework.Model.TitleResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HomeController {
    @GetMapping("/title")
    public TitleResponse getTitle(){
        TitleResponse titleResponse = new TitleResponse();
        titleResponse.setTitle("Employee Department Table");
        return titleResponse;
    }
}
