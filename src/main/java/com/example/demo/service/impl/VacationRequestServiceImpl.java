package com.example.demo.service.impl;

import com.example.demo.dto.VacationRequestDTO;
import com.example.demo.entity.Employee;
import com.example.demo.entity.VacationRequest;
import com.example.demo.enums.VacationStatus;
import com.example.demo.mapper.VacationRequestMapper;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.repository.VacationRequestRepository;
import com.example.demo.service.VacationRequestService;
import org.springframework.stereotype.Service;

import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class VacationRequestServiceImpl implements VacationRequestService {

    private final VacationRequestRepository repository;
    private final EmployeeRepository employeeRepository;
    private final VacationRequestMapper mapper;

    public VacationRequestServiceImpl(VacationRequestRepository repository, EmployeeRepository employeeRepository, VacationRequestMapper mapper) {
        this.repository = repository;
        this.employeeRepository = employeeRepository;
        this.mapper = mapper;
    }

    @Override
    public VacationRequestDTO create(VacationRequestDTO dto) {
        Employee employee = employeeRepository.findById((long) dto.getEmployeeId().intValue()).orElseThrow();
        VacationRequest entity = mapper.toEntity(dto, employee);
        return mapper.toDTO(repository.save(entity));
    }

    @Override
    public VacationRequestDTO getById(Long id) {
        return mapper.toDTO(repository.findById((long) id.intValue()).orElseThrow());
    }

    @Override
    public List<VacationRequestDTO> getAll() {
        return repository.findAll().stream().map(mapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public VacationRequestDTO createVacationRequest(Long employeeId, java.time.LocalDate startDate, java.time.LocalDate endDate, Integer holiday) {
        Employee employee = employeeRepository.findById((long) employeeId.intValue()).orElseThrow();

        long daysRequested = ChronoUnit.DAYS.between(startDate, endDate) + 1 - holiday;

        if (daysRequested > employee.getVacationDays()) {
            throw new IllegalArgumentException("Not enough vacation days.");
        }

        VacationRequest request = new VacationRequest();
        request.setEmployee(employee);
        request.setStartDate(java.sql.Date.valueOf(startDate));
        request.setEndDate(java.sql.Date.valueOf(endDate));
        request.setDays((int) daysRequested);
        request.setStatus(VacationStatus.PENDING.name());

        return mapper.toDTO(repository.save(request));
    }

    @Override
    public VacationRequestDTO updateStatus(Long vacationId, String status) {
        VacationRequest request = repository.findById((long) vacationId.intValue()).orElseThrow();
        Employee employee = request.getEmployee();

        if (status.equalsIgnoreCase("accepted")) {
            if (employee.getVacationDays() < request.getDays()) {
                throw new IllegalArgumentException("Not enough vacation days to approve.");
            }
            employee.setVacationDays(employee.getVacationDays() - request.getDays());
            employeeRepository.save(employee);
            request.setStatus(VacationStatus.APPROVED.name());
        } else if (status.equalsIgnoreCase("rejected")) {
            request.setStatus(VacationStatus.REJECTED.name());
        } else {
            throw new IllegalArgumentException("Invalid status.");
        }

        return mapper.toDTO(repository.save(request));
    }
}
