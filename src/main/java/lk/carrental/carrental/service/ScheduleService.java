package lk.carrental.carrental.service;

import lk.carrental.carrental.dto.ScheduleDTO;

import java.util.List;

public interface ScheduleService {
    void saveSchedule(ScheduleDTO dto);
    void updateSchedule(ScheduleDTO dto);
    ScheduleDTO searchSchedule(String id);
    List<ScheduleDTO> getAllSchedule();
    String generateScheduleIds();
}
