package com.gotprint.service;

import com.gotprint.model.Note;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface NoteService {

    List<Note> getNotes(String userId);

    Note createNote(String userId, Note note);

    Note updateNote(String userId, Note note);

    boolean deleteNote(String userId, int id);
}