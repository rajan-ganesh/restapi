package com.ganesh.restapi.controller;

import com.ganesh.restapi.model.UserModel;
import com.ganesh.restapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class AuthController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public ModelAndView home() {
        System.out.println("REACHED HOME PAGE");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("home.html");
        return modelAndView;
    }

    @GetMapping("/login")
    public ModelAndView login() {
        System.out.println("REACHED LOGIN PAGE");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login.html");
        return modelAndView;
    }

    @GetMapping("/signup")
    public ModelAndView signup() {
        System.out.println("REACHED SIGNUP PAGE");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("signup.html");
        return modelAndView;
    }

    @GetMapping("/token")
    public ModelAndView greeting() {
        System.out.println("REACHED TOKEN PAGE");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("token.html");
        return modelAndView;
    }

    @PostMapping("/api/signup")
    public ResponseEntity<?> signUp(@RequestParam String username, @RequestParam String password) {
        try {
            UserModel userModel = new UserModel();
            userModel.setUsername(username);
            userModel.setPassword(password);

            UserModel newUserModel = userService.signUp(userModel);
            return ResponseEntity.ok("You Have Signed Up Successfully! You may now return to the home page and Log In.");
        } catch (Exception e) {
            // Exception are returned to the front end, where they should be handled by an error page
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error while Signing Up");
        }
    }


    @PostMapping("/api/login")
    public ResponseEntity<String> login(@RequestParam String username, @RequestParam String password) {
        String token;
        try{
            token = userService.login(username, password);
        } catch(Exception e){
            System.out.println(e);
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Error while Logging in, please verify your Credentials and Try Again");
        }
        return ResponseEntity.ok("You've logged in! You can now return to home and use your JWT to access the data. Your JWT Token: " + token);
    }
}