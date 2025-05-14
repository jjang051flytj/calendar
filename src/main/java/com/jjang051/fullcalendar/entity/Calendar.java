package com.jjang051.fullcalendar.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Table(name="table_calendar")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Calendar {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(name="startDate")
    private String start;

    @Column(name="endDate")
    private String end;
    private String title;
    private Boolean allDay;
    private String priority;
}
