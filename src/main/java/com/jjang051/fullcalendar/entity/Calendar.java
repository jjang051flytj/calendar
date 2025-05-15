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
import lombok.Setter;

@Entity
@Getter
//@Setter
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

    public void updateDate(String start, String end) {
        this.start = start;
        this.end = end;
    }
    public void updateTitle(String title) {
        this.title = title;
    }
}
