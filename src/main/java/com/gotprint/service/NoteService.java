package com.gotprint.service;

import com.gotprint.model.Note;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface NoteService {

    List<Note> getNotes(String userId);
}