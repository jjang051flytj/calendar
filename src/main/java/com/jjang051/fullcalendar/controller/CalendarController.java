package com.jjang051.fullcalendar.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jjang051.fullcalendar.dto.CalendarDto;
import com.jjang051.fullcalendar.entity.Calendar;
import com.jjang051.fullcalendar.service.CalendarService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@Controller
@RequestMapping("/calendar")
@Slf4j
@RequiredArgsConstructor
public class CalendarController {
    private final CalendarService calendarService;

    @GetMapping("/list")
    public String list() {
        return "calendar/list";
    }

    @GetMapping("/all")
    @ResponseBody
    public List<CalendarDto> all() {
        return calendarService.getAll();
    }


    @PostMapping("/insert")
    @ResponseBody
    public Map<String,String> insert(@RequestBody CalendarDto calendarDto ) {
        log.info("calendarDto==={}",calendarDto);
        Calendar savedCalendar = calendarService.insert(calendarDto);
        Map<String, String> resultMap =  new HashMap<>();
        if(savedCalendar!=null) {
            resultMap.put("isInsert", "ok");
        } else {
            resultMap.put("isInsert", "fail");
        }
        return resultMap; 
        /*
        {
            "isInsert":"fail"
        }
        */
    }
}
