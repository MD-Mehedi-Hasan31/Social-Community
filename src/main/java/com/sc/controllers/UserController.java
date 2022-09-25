package com.sc.controllers;


import com.sc.Properties;
import com.sc.config.Utils;
import com.sc.dao.LocationDao;
import com.sc.dao.UserDao;
import com.sc.dto.UserRequestDto;
import com.sc.entity.Attachment;
import com.sc.entity.Location;
import com.sc.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/")
public class UserController {

    @Autowired
    private UserDao userDao;

    @Autowired
    private LocationDao locationDao;


    @GetMapping("user/users")
    public String getUser(Model model){
        List<User> users = userDao.findAll();
        model.addAttribute("users", users);
        return "user/users";
    }

    @GetMapping("user/addUser")
    public String addNewUser(Model model){
        UserRequestDto user = new UserRequestDto();
        List<Location> locationList = locationDao.getAllLocation();
        model.addAttribute("user", user);
        model.addAttribute("locationList", locationList);

        return "user/addUser";
    }

    @PostMapping("user/save")
    public String saveNewUser(@ModelAttribute("user") UserRequestDto userRequestDto,
                              @RequestParam("image") MultipartFile file, Model model
            ) throws IOException {


        Location location = locationDao.findById(userRequestDto.getLocationId());

        var user = new User();
        BeanUtils.copyProperties(userRequestDto, user);
        Attachment attachment = Utils.saveFile(file, Properties.USER_FOLDER);

        user.setAttachment(attachment);
        user.setLocation(location);
        userDao.save(user);
        return getUser(model);
    }
   /*
    @PostMapping(value = "/saveUser")
    public String saveNewUser(@ModelAttribute("user") UserRequestDto userRequestDto, Model model) throws IOException {

        Location location = locationDao.findById(userRequestDto.getLocationId());
        //@RequestParam("image") MultipartFile file
      //  Attachment attachment = Utils.saveFile(file, Properties.USER_FOLDER);

        User user = new User();

        user.setId(userRequestDto.getId());
        user.setUsername(userRequestDto.getName());
        user.setEmail(userRequestDto.getEmail());
        user.setPassword(userRequestDto.getPassword());
        user.setLocation(location);
     //   user.setAttachment(attachment);

        userDao.save(user);

        return getUser(model);
    }
    */
}
