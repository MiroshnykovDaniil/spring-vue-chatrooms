package com.donationalerts.youtubeparser.repository;

import com.donationalerts.youtubeparser.entity.ChatRoom;
import com.donationalerts.youtubeparser.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface ChatRoomRepository extends CrudRepository<ChatRoom,Long> {

    @Modifying
    @Query("UPDATE ChatRoom chat SET chat.userList=?2 WHERE chat.id=?1")
    void addUsertoRoom(Long id, List<User> users);

}
