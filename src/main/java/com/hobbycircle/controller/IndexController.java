package com.hobbycircle.controller;

import com.hobbycircle.Constants;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @RequestMapping("/")
    public String index() {
        return Constants.INDEX_PAGE_VIEW_NAME;
    }
}
