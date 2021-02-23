package com.thecaveman.reactfriends.springreactfriends.service;

import com.thecaveman.reactfriends.springreactfriends.model.Friend;
import com.thecaveman.reactfriends.springreactfriends.repository.FriendRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FriendService {
    @Autowired
    private FriendRepository friendRepository;

    public Friend saveFriend(Friend friend){
        return friendRepository.save(friend);
    }

    public List<Friend> getAllFriends(){
        return friendRepository.findAll();
    }

    public Friend getFriendById(Long id){
        return friendRepository.findById(id).get();
    }

    public void deleteFriendById(Long id){
        friendRepository.deleteById(id);
    }

    public void updateFriend(Long id,Friend friend){
        Friend tmpFriend = friendRepository.findById(id).get();
        tmpFriend.setName(friend.getName());
        tmpFriend.setEmail(friend.getEmail());
        tmpFriend.setPhoneNumber(friend.getPhoneNumber());
        friendRepository.save(tmpFriend);
    }
}
