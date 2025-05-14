package com.jjang051.fullcalendar.dto;

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
}
