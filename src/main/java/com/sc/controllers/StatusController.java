package com.sc.controllers;


import com.sc.Properties;
import com.sc.config.Utils;
import com.sc.dao.AttachmentDao;
import com.sc.dao.LocationDao;
import com.sc.dao.StatusDao;
import com.sc.dto.StatusDto;
import com.sc.entity.Attachment;
import com.sc.entity.Location;
import com.sc.entity.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/status")
public class StatusController {
    @Autowired
    private StatusDao statusDao;

    @Autowired
    private LocationDao locationDao;

    @Autowired
    private AttachmentDao attachmentDao;

     @GetMapping("/create")
    public ModelAndView create(Model model) {
        List<Location> locations = locationDao.getAllLocation();
        List<String> locationList = new ArrayList<>();

        for (Location location : locations) {
            locationList.add(location.getLocationName());
        }

        model.addAttribute("locationList", locationList);
        model.addAttribute("privacyList", Arrays.asList("Public", "Private"));
        model.addAttribute("status", new StatusDto());

        return new ModelAndView("status/create", "model", model);
    }

    @PostMapping("/store")
        public String store(Model model, @ModelAttribute("status") StatusDto statusModel,
                            @RequestParam("images") MultipartFile[] files) {

            Location location = locationDao.getByName(statusModel.getLocation());
            List<Attachment> attachmentList = new ArrayList<>();

            for (MultipartFile file : files) {

                Attachment attachment = Utils.saveFile(file, Properties.STATUS_FOLDER);
                if (attachment != null) {
                    attachmentList.add(attachment);
                }
            }

            attachmentDao.insertBulk(attachmentList);

            Status status = new Status();
            status.setTitle(statusModel.getTitle());
            status.setDescription(statusModel.getDescription());
            status.setPrivacy(statusModel.getPrivacy());
            status.setLocation(location);
            status.setStatusAttachmentList(attachmentList);

            statusDao.insert(status);

            location.getStatuses().add(status);
            locationDao.update(location);

            model.addAttribute("status", status);

            return "redirect:/status/show/" + status.getId();
        }

        @GetMapping(value = "/show/{id}")
        public String show(Model model, @PathVariable(value = "id")String id){

         Status status= statusDao.getById(Long.parseLong(id));

         model.addAttribute("status",status);

         return "status/show";
        }


        @GetMapping("/list")
        public String maintain(Model model){

         List<Status> statusList= statusDao.getAll();
         model.addAttribute("statusList", statusList);

         return "status/list";
        }
    }

