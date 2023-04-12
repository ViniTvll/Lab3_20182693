package com.example.lab3_20182693.controller;

import com.example.lab3_20182693.entity.Doctor;
import com.example.lab3_20182693.repository.DoctorRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/doctor")
public class DoctorController {

    final DoctorRepository doctorRepository;

    public DoctorController(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    @GetMapping(value = {"/list", ""})
    public String listarDoctores(Model model) {

        List<Doctor> lista = doctorRepository.findAll();
        model.addAttribute("doctorList", lista);

        return "doctor/list";
    }

    @GetMapping("/new")
    public String nuevoDoctorFrm() {
        return "doctor/newFrm";
    }

    @PostMapping("/save")
    public String guardarNuevoTransportista(Doctor doctor) {
        doctorRepository.save(doctor);
        return "redirect:/doctor/list";
    }

    @GetMapping("/edit")
    public String editarDoctor(Model model,
                                 @RequestParam("id") int id) {

        Optional<Doctor> optDoctor = doctorRepository.findById(id);

        if (optDoctor.isPresent()) {
            Doctor doctor = optDoctor.get();
            model.addAttribute("doctor", doctor);
            return "doctor/editFrm";
        } else {
            return "redirect:/doctor/list";
        }
    }

    @GetMapping("/delete")
    public String borrarDoctor(Model model,
                                 @RequestParam("id") int id) {

        Optional<Doctor> optShipper = doctorRepository.findById(id);

        if (optShipper.isPresent()) {
            doctorRepository.deleteById(id);
        }
        return "redirect:/doctor/list";

    }
}
