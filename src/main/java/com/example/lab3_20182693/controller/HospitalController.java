package com.example.lab3_20182693.controller;

import com.example.lab3_20182693.entity.Hospital;
import com.example.lab3_20182693.repository.HospitalRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/hospital")
public class HospitalController {
    final HospitalRepository hospitalRepository;

    public HospitalController(HospitalRepository hospitalRepository) {
        this.hospitalRepository = hospitalRepository;
    }

    @GetMapping(value = {"/list", ""})
    public String listarHospitales(Model model) {

        List<Hospital> lista = hospitalRepository.findAll();
        model.addAttribute("hospitalList", lista);

        return "hospital/list";
    }

    @GetMapping("/new")
    public String nuevoHospitalFrm() {
        return "hospital/newFrm";
    }

    @PostMapping("/save")
    public String guardarNuevoTransportista(Hospital hospital) {
        hospitalRepository.save(hospital);
        return "redirect:/hospital/list";
    }

    @GetMapping("/edit")
    public String editarHospital(Model model,
                                      @RequestParam("id") int id) {

        Optional<Hospital> optHospital = hospitalRepository.findById(id);

        if (optHospital.isPresent()) {
            Hospital hospital = optHospital.get();
            model.addAttribute("hospital", hospital);
            return "hospital/editFrm";
        } else {
            return "redirect:/hospital/list";
        }
    }

    @GetMapping("/delete")
    public String borrarHospital(Model model,
                                      @RequestParam("id") int id) {

        Optional<Hospital> optShipper = hospitalRepository.findById(id);

        if (optShipper.isPresent()) {
            hospitalRepository.deleteById(id);
        }
        return "redirect:/hospital/list";

    }


}
