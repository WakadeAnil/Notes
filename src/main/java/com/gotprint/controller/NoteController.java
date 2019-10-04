package com.gotprint.controller;

import com.gotprint.model.Note;
import com.gotprint.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController()
public class NoteController {

    @Autowired
    private NoteService noteService;

    @GetMapping(path = "/note/{userId}")
    public ResponseEntity<?> getNote(@PathVariable String userId){
        return new ResponseEntity<>(noteService.getNotes(userId), null, HttpStatus.OK);
    }

    @PostMapping(path = "/note/{userId}")
    public ResponseEntity<?> createNote(@PathVariable String userId, @RequestBody Note note){
        return new ResponseEntity<>(noteService.createNote(userId, note), null, HttpStatus.OK);
    }

    @PutMapping(path = "/note/{userId}")
    public ResponseEntity<?> updateNote(@PathVariable String userId, @RequestBody Note note){
        return new ResponseEntity<>(noteService.updateNote(userId, note), null, HttpStatus.OK);
    }

    @DeleteMapping(path = "/note/{id}/{userId}")
    public ResponseEntity<?> deleteNote(@PathVariable String userId, @PathVariable int id){
        return new ResponseEntity<>(noteService.deleteNote(userId, id), null, HttpStatus.OK);
    }
}
