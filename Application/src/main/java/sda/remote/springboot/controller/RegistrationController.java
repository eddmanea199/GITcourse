package sda.remote.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import sda.remote.springboot.model.UserDto;
import sda.remote.springboot.service.UserService;

import javax.validation.Valid;

@Controller
@RequestMapping("/registration")
public class RegistrationController {

    @Autowired
    private UserService userService;

    @GetMapping
    public String getRegistrationForm(Model model){
        model.addAttribute("userDto", new UserDto());

        return "registration";
    }

    @PostMapping
    public String postRegistrationForm(Model model,@Valid UserDto userDto,
                                       BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "registration";
        }

        if (!userDto.getPassword().equals(userDto.getConfirmPassword())){
            bindingResult.addError(new FieldError("userDto","password",
                    "Password does not mach password confirmation"));
            bindingResult.addError(new FieldError("userDto","confirmPassword",
                    "Password does not mach password confirmation"));

            return "registration";
        }

        userService.save(userDto);

        return "redirect:/registration?successfull";
    }
}
