package com.gotprint.service;

import com.gotprint.dal.NoteRepository;
import com.gotprint.model.Note;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NoteServiceImpl implements NoteService {

    @Autowired
    private NoteRepository noteRepository;

    @Override
    public List<Note> getNotes(String userId) {
        List<Note> allNotes = new ArrayList<>();
        noteRepository.getNotesOfUser(userId).forEach(n -> allNotes.add(n));
        return allNotes;
    }
}
