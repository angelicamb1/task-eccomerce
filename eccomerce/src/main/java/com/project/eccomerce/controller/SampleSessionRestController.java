package com.project.eccomerce.controller;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleSessionRestController {

    /**
     * Simple Session controller which will return session ID backed by Spring Session API
     * @param session
     * @return session ID
     */
    @GetMapping("/")
    String uid(HttpSession session) {
        return session.getId();
    }
}
