package com.jjang051.fullcalendar.service;



import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    public List<CalendarDto> getAll() {
        List<Calendar> calendarList =calendarRepository.findAll();
        //return calendarList;
        return calendarList.stream().map(calendar -> new CalendarDto(
                calendar.getId(),
                calendar.getTitle(),
                calendar.getStart(),
                calendar.getEnd(),
                calendar.getAllDay(),
                calendar.getPriority()
        ))
        .collect(Collectors.toList());
    }


    //dirty checking  jpa 안에 transation manager에 의해서 체크된다.
    @Transactional
    public Calendar change(CalendarDto calendarDto) {
        //save()를 하면 기존 데이터랑 비교해서 같으면 update쿼리가 나가고 없는거면 insert
        Optional<Calendar> optionalCalendar = calendarRepository.findById(calendarDto.getId()); //기존 데이터 찾아줌....
        if(optionalCalendar.isPresent()) {
            Calendar findedCalendar = optionalCalendar.get();
             findedCalendar.updateDate(calendarDto.getStart(), calendarDto.getEnd());
                return findedCalendar;
            // Calendar changeCalendar = Calendar.builder()
            //     .start(calendarDto.getStart())
            //     .end(calendarDto.getEnd())
            //     .title(calendarDto.getTitle())
            //     .allDay(calendarDto.isAllDay())
            //     .priority(calendarDto.getPriority())
            // .build();


            //이렇게 쓰면 insert query 날아감 같은걸 보장 못받음

            //findedCalendar.setStart(calendarDto.getStart());
            //findedCalendar.setEnd(calendarDto.getEnd());
            //findedCalendar.setTitle(calendarDto.getTitle());
            //findedCalendar.setAllDay(calendarDto.isAllDay());
            //findedCalendar.setPriority(calendarDto.getPriority());

            //만약 calendar entity에 setter가 있으면 써도 된다. 근데 위험하다...
            //return calendarRepository.save(findedCalendar);
           
        }
        return null;
    }
}
