package com.dtu.social_it.respositorys;

import com.dtu.social_it.domains.ChatRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatRoomRespository extends JpaRepository<ChatRoom,Integer> {
}
