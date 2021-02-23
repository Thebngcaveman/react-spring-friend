package com.thecaveman.reactfriends.springreactfriends.repository;

import com.thecaveman.reactfriends.springreactfriends.model.Friend;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FriendRepository extends JpaRepository<Friend,Long> {
}
