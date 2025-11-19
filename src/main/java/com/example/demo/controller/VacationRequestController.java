package com.example.demo.controller;

import com.example.demo.dto.VacationRequestDTO;
import com.example.demo.service.VacationRequestService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/vacation-requests")
public class VacationRequestController {

    private final VacationRequestService service;

    public VacationRequestController(VacationRequestService service) {
        this.service = service;
    }

    @PostMapping
    public VacationRequestDTO create(@RequestBody VacationRequestDTO dto) {
        return service.create(dto);
    }

    @GetMapping("/{id}")
    public VacationRequestDTO getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @GetMapping
    public List<VacationRequestDTO> getAll() {
        return service.getAll();
    }

    @PostMapping("/create")
    public VacationRequestDTO createVacationRequest(@RequestBody Map<String, Object> body) {
        Long employeeId = Long.valueOf(body.get("employeeId").toString());
        LocalDate startDate = LocalDate.parse(body.get("startDate").toString());
        LocalDate endDate = LocalDate.parse(body.get("endDate").toString());
        Integer holiday = Integer.parseInt(body.get("holiday").toString());

        return service.createVacationRequest(employeeId, startDate, endDate, holiday);
    }

    @PutMapping("/update-status")
    public VacationRequestDTO updateStatus(@RequestBody Map<String, Object> body) {
        Long vacationId = Long.valueOf(body.get("vacationId").toString());
        String status = body.get("status").toString();
        return service.updateStatus(vacationId, status);
    }
}
