package com.example.bai2.Controller;

import jakarta.enterprise.inject.Model;

public class Controller {
    @PostMapping("/hr/add-employee")
    public String saveEmployee(
            @Valid @ModelAttribute("employee") EmployeeDto employee,
            BindingResult bindingResult,
            Model model) {

        if (bindingResult.hasErrors()) {
            return "employee-form";
        }

        return "redirect:/hr/success";
    }
}
