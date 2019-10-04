package com.gotprint.dal;

import com.gotprint.model.Note;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoteDao {

    List<Note> getNotes();

    Note createNote(String userId, Note note);

    Note updateNote(String userId, Note note);

    boolean deleteNote(String userId, int id);
}
