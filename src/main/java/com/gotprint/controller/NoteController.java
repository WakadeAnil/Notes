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
        try{
            return new ResponseEntity<>(noteService.getNotes(userId), null, HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(path = "/note/{userId}")
    public ResponseEntity<?> createNote(@PathVariable String userId, @RequestBody Note note){
        try{
            return new ResponseEntity<>(noteService.createNote(userId, note), null, HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(path = "/note/{userId}")
    public ResponseEntity<?> updateNote(@PathVariable String userId, @RequestBody Note note){
        try{
            return new ResponseEntity<>(noteService.updateNote(userId, note), null, HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(path = "/note/{id}/{userId}")
    public ResponseEntity<?> deleteNote(@PathVariable String userId, @PathVariable int id){
        try{
            return new ResponseEntity<>(noteService.deleteNote(userId, id), null, HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
