package com.gotprint.dal;

import com.gotprint.model.Note;
import org.springframework.data.repository.CrudRepository;

public interface NoteRepository extends CrudRepository<Note, Integer> {

}
