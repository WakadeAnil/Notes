package com.gotprint.service;

import com.gotprint.dal.NoteRepository;
import com.gotprint.model.Note;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManagerFactory;
import java.util.List;

@Service
public class NoteServiceImpl implements NoteService {

    @Autowired
    private NoteRepository noteRepository;

    @Autowired
    private EntityManagerFactory entityManagerFactory;

    @Override
    public List<Note> getNotes(String userId) {
        Session session = entityManagerFactory.unwrap(SessionFactory.class).openSession();
        return session.createQuery("select n from Note n join n.user u where u.email = :userId")
                .setParameter("userId", userId)
                .list();
    }
}
