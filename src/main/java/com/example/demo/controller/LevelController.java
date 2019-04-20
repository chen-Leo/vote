package com.example.demo.controller;

import com.example.demo.entity.json.LevelJson;
import com.example.demo.service.VoteInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping(value = "/level")
public class LevelController {
    @Autowired
    VoteInfoService voteInfoService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public LevelJson select() {
        return voteInfoService.levelSelect();
    }

}
