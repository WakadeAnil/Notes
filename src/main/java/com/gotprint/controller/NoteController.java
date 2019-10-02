package com.gotprint.controller;

import com.gotprint.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class NoteController {

    @Autowired
    private NoteService noteService;

    @GetMapping(path = "/note/{userId}")
    public ResponseEntity<?> getNote(@PathVariable String userId){
        return new ResponseEntity<>(noteService.getNotes(userId), null, HttpStatus.OK);
    }
}
