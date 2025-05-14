package com.jjang051.fullcalendar.dto;


import com.jjang051.fullcalendar.entity.Calendar;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class CalendarDto {
    private int id;
    private String title;
    private String start;
    private String end;
    private boolean allDay;
    private String priority;

    public static Calendar toEntity(CalendarDto calendarDto) {
        return Calendar.builder()
                .start(calendarDto.getStart())
                .end(calendarDto.getEnd())
                .allDay(calendarDto.isAllDay())
                .priority(calendarDto.getPriority())
                .title(calendarDto.getTitle())
            .build();
    }

    public CalendarDto(Calendar calendar) {
        this.id= calendar.getId();
        this.title= calendar.getTitle();
        this.start= calendar.getStart();
        this.end= calendar.getEnd();
        this.allDay= calendar.getAllDay();
        this.priority= calendar.getPriority();
    }
}
