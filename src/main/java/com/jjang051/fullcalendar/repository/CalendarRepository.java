package com.jjang051.fullcalendar.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.jjang051.fullcalendar.entity.Calendar;

public interface CalendarRepository extends JpaRepository<Calendar, Integer> {

}
