package com.dtu.social_it.controllers.user;

import com.dtu.social_it.constants.MyConstants;
import com.dtu.social_it.domains.CategoryPost;
import com.dtu.social_it.domains.Post;
import com.dtu.social_it.respositorys.CategoryPostRespository;
import com.dtu.social_it.respositorys.PostRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private CategoryPostRespository categoryPostRepo;

    @Autowired
    private PostRespository postRespository;

    @Autowired
    public JavaMailSender emailSender;

    @GetMapping(value = "home")
    public ModelAndView index(){

        ModelAndView mv = new ModelAndView("user/HomePage");
        SimpleMailMessage message = new SimpleMailMessage();

        message.setTo(MyConstants.FRIEND_EMAIL);
        message.setSubject("Test Simple Email");
        message.setText("Hello, Nguyen <3 Oanh");

        // Send Message!
        this.emailSender.send(message);
        List<CategoryPost> list = categoryPostRepo.findAll();
        List<Post> listP = postRespository.findAll();
        mv.addObject("list",listP);
        return mv;
    }
}
