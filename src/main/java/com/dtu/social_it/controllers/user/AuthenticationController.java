package com.dtu.social_it.controllers.user;

import com.dtu.social_it.constants.MyConstants;
import com.dtu.social_it.domains.User;
import com.dtu.social_it.servicesImpl.UserServiceImpl;
import com.dtu.social_it.utils.PasswordMd5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Locale;
import java.util.Random;

@Controller
@RequestMapping("user")
public class AuthenticationController {

    @Autowired
    public UserServiceImpl userService;

    @Autowired
    public JavaMailSender emailSender;

    @Autowired
    MessageSource messageSource;

    public PasswordMd5 passwordMd5 = new PasswordMd5();

    @GetMapping(value = "/register")
    public ModelAndView register(){
        ModelAndView mv = new ModelAndView("user/Register");

        return mv;
    }

    @PostMapping(value = "register")
    public  ModelAndView signUpAccount(HttpServletRequest request){
        ModelAndView mv = new ModelAndView("user/Register");


        String email = request.getParameter("email");
        String username = request.getParameter("username");
        String fullName = request.getParameter("fullName");
        String phoneNumber = request.getParameter("phoneNumber");
        String social = request.getParameter("social");
        String about = request.getParameter("about");
        String password = request.getParameter("password");
        String rePassword = request.getParameter("rePassword");
        if (!password.equalsIgnoreCase(rePassword)){
            mv.addObject(MyConstants.MSG,messageSource.getMessage("password_and_repassword", null, Locale.getDefault()));
        }else{
            String passwordMd5New = passwordMd5.md5(password);
            User user = new User();
            user.setEmail(email);
            user.setFullName(fullName);
            user.setUserName(username);
            user.setSocial(social);
            user.setAbout(about);
            user.setPhoneNumber(phoneNumber);
            user.setPassword(passwordMd5New);
            user.setIdRole(2);
            user.setStatus(0);
            User userExited = userService.findByEmail(email);
            if(userExited != null){
                mv.addObject(MyConstants.MSG,messageSource.getMessage("email_exited",null,Locale.getDefault()));
            }else{
                User userNew = userService.save(user);
                if(userNew != null){
                    mv = new ModelAndView("redirect:verify");
                    SimpleMailMessage message = new SimpleMailMessage();
                    int randomPIN = (int)(Math.random()*9000)+1000;
                    String codeVerify = String.valueOf(randomPIN);

                    message.setTo(email);
                    message.setSubject(MyConstants.VERIFY_ACCOUNT);
                    message.setText(MyConstants.TEXT_VERIFY +" " + codeVerify);

                    HttpSession session = request.getSession();
                    session.setAttribute(MyConstants.SEESION_CODE_VERIFY, codeVerify);
                    session.setAttribute(MyConstants.EMAIL_REGISTER,email);
                    // Send Message!
                    this.emailSender.send(message);
                    return mv;
                }
            }

        }

        return mv;
    }

    @GetMapping(value = "/verify")
    public ModelAndView verify(){
        ModelAndView mv = new ModelAndView("user/VerifyCode");
        return mv;
    }

    @PostMapping (value = "/verify")
    public ModelAndView verifyPost(HttpServletRequest request){
        ModelAndView mv = new ModelAndView("user/VerifyCode");
        String code = request.getParameter("code");
        System.out.println(code);
        HttpSession session = request.getSession();
        String curentCode =  (String)session.getAttribute(MyConstants.SEESION_CODE_VERIFY);
        System.out.println(curentCode);
        String email  = (String) session.getAttribute(MyConstants.EMAIL_REGISTER);
        if(!code.equalsIgnoreCase(curentCode)){
            mv.addObject(MyConstants.MSG,messageSource.getMessage("code_verify_incorret",null,Locale.getDefault()));
        }else{
                userService.activeAccount(email,1);
                mv = new ModelAndView("redirect:login");
                return mv;
        }
        return mv;
    }

    @GetMapping(value = "/login")
    public ModelAndView login(){
        ModelAndView mv = new ModelAndView("user/Login");
        return mv;
    }
}
