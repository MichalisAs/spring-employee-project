package com.example.demo.service;

import com.example.demo.dto.VacationRequestDTO;

import java.time.LocalDate;
import java.util.List;

public interface VacationRequestService {

    VacationRequestDTO create(VacationRequestDTO dto);

    VacationRequestDTO getById(Long id);

    List<VacationRequestDTO> getAll();

    VacationRequestDTO createVacationRequest(Long employeeId, LocalDate startDate, LocalDate endDate, Integer holiday);

    VacationRequestDTO updateStatus(Long vacationId, String status);
}
