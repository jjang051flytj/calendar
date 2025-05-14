package com.jjang051.fullcalendar.service;



import org.springframework.stereotype.Service;

import com.jjang051.fullcalendar.dto.CalendarDto;
import com.jjang051.fullcalendar.entity.Calendar;
import com.jjang051.fullcalendar.repository.CalendarRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class CalendarService {
    private final CalendarRepository calendarRepository;

    public Calendar insert(CalendarDto calendarDto) {
        Calendar calendar = CalendarDto.toEntity(calendarDto);
        return calendarRepository.save(calendar);
    }
}
