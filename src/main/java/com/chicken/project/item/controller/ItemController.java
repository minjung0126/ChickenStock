package com.chicken.project.item.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("item")
public class ItemController {

    @GetMapping("/admin_item")
    public void itemList(){}
    @GetMapping("/admin_item_new")
    public void itemInsert(){}
}
