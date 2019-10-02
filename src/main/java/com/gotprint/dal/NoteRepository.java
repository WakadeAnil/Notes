package com.gotprint.dal;

import com.gotprint.model.Note;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface NoteRepository extends CrudRepository<Note, Integer> {

    @Query(value = "select * from note where user_email_id = :userId", nativeQuery = true)
    List<Note> getNotesOfUser(@Param("userId") String userId);
}
