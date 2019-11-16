package com.donationalerts.youtubeparser.repository;

import com.donationalerts.youtubeparser.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface MessageRepository extends CrudRepository<Message,Long> {

    @Modifying
    @Query("UPDATE Message msg SET msg.text=?2 WHERE msg.id=?1")
    void setMessage(Long id, String text);
}
