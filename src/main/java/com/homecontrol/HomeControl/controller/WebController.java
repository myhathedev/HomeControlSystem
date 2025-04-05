package com.homecontrol.HomeControl.controller;

import com.homecontrol.HomeControl.service.ApplianceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class WebController {

    private final ApplianceService applianceService;

    @Autowired
    public WebController(ApplianceService applianceService) {
        this.applianceService = applianceService;
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("statuses", applianceService.getStatuses());
        return "home";
    }

    @PostMapping("/light")
    public String toggleLight(@RequestParam String action) {
        if ("on".equalsIgnoreCase(action)) {
            applianceService.turnOn("Light");
        } else if ("off".equalsIgnoreCase(action)) {
            applianceService.turnOff("Light");
        }
        return "redirect:/";
    }

    @PostMapping("/fan")
    public String setFanSpeed(@RequestParam int speed) {
        applianceService.setFanSpeed(speed);
        return "redirect:/";
    }

    @PostMapping("/ac")
    public String setAcMode(@RequestParam String mode) {
        applianceService.setAcMode(mode.toLowerCase());
        return "redirect:/";
    }

    @PostMapping("/turnOffAll")
    public String turnOffAll() {
        applianceService.turnOffAllDevices();
        return "redirect:/";
    }
}
