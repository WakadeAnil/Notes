package com.gotprint.service;

import com.gotprint.dal.NoteDao;
import com.gotprint.model.Note;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteServiceImpl implements NoteService {

    @Autowired
    private NoteDao noteDao;

    @Override
    public List<Note> getNotes(String userId) {
        return noteDao.getNotes();
    }

    @Override
    public Note createNote(String userId, Note note) {
        noteDao.createNote(userId, note);
    }

    @Override
    public Note updateNote(String userId, Note note) {
        return noteDao.updateNote(userId, note);
    }

    @Override
    public boolean deleteNote(String userId, int id) {
        return noteDao.deleteNote(userId, id);
    }
}
