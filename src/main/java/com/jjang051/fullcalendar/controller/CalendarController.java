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

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    public Map<String,Object> insert(@RequestBody CalendarDto calendarDto ) {
        log.info("calendarDto==={}",calendarDto);
        Calendar savedCalendar = calendarService.insert(calendarDto);
        Map<String, Object> resultMap =  new HashMap<>();
        if(savedCalendar!=null) {
            resultMap.put("isInsert", "ok");
            resultMap.put("savedCalendar", savedCalendar);
        } else {
            resultMap.put("isInsert", "fail");
            resultMap.put("savedCalendar", null);
        }
        return resultMap; 
    }

    @PostMapping("/change")
    @ResponseBody
    public Map<String,Object> change(@RequestBody CalendarDto calendarDto) {
        
        log.info("calendarDto==={}",calendarDto);
        Calendar changedCalendar = calendarService.change(calendarDto);
        Map<String, Object> resultMap =  new HashMap<>();
        if(changedCalendar!=null) {
            resultMap.put("isChange", "ok");
            resultMap.put("savedCalendar", changedCalendar);
        } else {
            resultMap.put("isChange", "fail");
            resultMap.put("savedCalendar", null);
        }
        return resultMap; 
    }
    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public Map<String,Object> delete(@PathVariable int id) {
        log.info("id==={}",id);
        calendarService.delete(id);
        Map<String, Object> resultMap =  new HashMap<>();
        resultMap.put("isDelete", "ok");
        return resultMap; 
    }
    
}
