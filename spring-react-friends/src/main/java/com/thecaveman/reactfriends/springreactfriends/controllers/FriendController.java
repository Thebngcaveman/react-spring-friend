package com.thecaveman.reactfriends.springreactfriends.controllers;

import com.thecaveman.reactfriends.springreactfriends.model.Friend;
import com.thecaveman.reactfriends.springreactfriends.service.FriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/friend")
@CrossOrigin
public class FriendController {
    @Autowired
    private FriendService friendService;

    @PostMapping("")
    public ResponseEntity<Friend> addFriend(@RequestBody Friend friend){
        return new ResponseEntity<>(friendService.saveFriend(friend), HttpStatus.ACCEPTED);
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllFriends(){
        return new ResponseEntity<>(friendService.getAllFriends(),HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Friend> getFriendById(@PathVariable Long id){
        return new ResponseEntity<>(friendService.getFriendById(id),HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public void updateFriend(@PathVariable("id")Long id,@RequestBody Friend friend){
        friendService.updateFriend(id,friend);
        //return new ResponseEntity<>(friendService.updateFriend(id,friend),HttpStatus.OK);
    }

    @DeleteMapping("/del/{id}")
    public void deleteFriendById(@PathVariable("id") Long id){
        friendService.deleteFriendById(id); //,HttpStatus.OK);
    }
}
