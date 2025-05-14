package com.jjang051.fullcalendar.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jjang051.fullcalendar.dto.CalendarDto;

import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@Controller
@RequestMapping("/calendar")
@Slf4j
public class CalendarController {
    @GetMapping("/list")
    public String list() {
        return "calendar/list";
    }
    @PostMapping("/insert")
    @ResponseBody
    public Map<String,String> insert(@RequestBody CalendarDto calendarDto ) {
        log.info("calendarDto==={}",calendarDto);
        return null;
    }
}
