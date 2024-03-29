package com.example.repository;

import java.util.ArrayList;
import java.util.ArrayList;
import java.util.Optional;

import org.hibernate.mapping.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.entity.Message;

@Repository
public interface MessageRepository extends JpaRepository<Message, Integer>{

    //Optional<Message> findMessageById(long id);

    @Query("FROM Message ORDER BY message_id DESC")
    Optional<ArrayList<Message>> getNewestMessage();

    @Query("FROM Message WHERE posted_by = :PB")
    Optional<ArrayList<Message>> findMessageByPosted_by(@Param("PB") Integer posted_by);
}
