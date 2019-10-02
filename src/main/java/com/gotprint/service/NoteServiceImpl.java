package com.gotprint.service;

import com.gotprint.dal.NoteRepository;
import com.gotprint.model.Note;
import com.gotprint.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManagerFactory;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Service
public class NoteServiceImpl implements NoteService {

    @Autowired
    private NoteRepository noteRepository;

    @Autowired
    private EntityManagerFactory entityManagerFactory;

    @Override
    public List<Note> getNotes(String userId) {
        Session session = getSession();
        return session.createQuery("select n from Note n join n.user u where u.email = :userId")
                .setParameter("userId", userId)
                .list();
    }

    @Override
    public Note createNote(String userId, Note note) {
        Session session = getSession();
        User user  = session.get(User.class, userId);
        note.setUser(user);
        note.setCreateTime(new Date());
        note.setLastUpdateTime(new Date());
        Transaction transaction = session.beginTransaction();
        session.save(note);
        transaction.commit();
        session.close();
        return note;
    }

    private Session getSession() {
        return entityManagerFactory.unwrap(SessionFactory.class).openSession();
    }
}
