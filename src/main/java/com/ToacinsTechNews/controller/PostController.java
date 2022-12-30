package com.ToacinsTechNews.controller;

import com.ToacinsTechNews.model.Post;
import com.ToacinsTechNews.model.User;
import com.ToacinsTechNews.model.Vote;
import com.ToacinsTechNews.repository.PostRepository;
import com.ToacinsTechNews.repository.UserRepository;
import com.ToacinsTechNews.repository.VoteRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PostController {

    @Autowired
    PostRepository repository;
    @Autowired
    VoteRepository voteRepository;
    @Autowired
    UserRepository userRepository;

    @GetMapping("/api/posts")
    public List<Post> getAllPosts() {
        List<Post> postList = repository.findAll();
        for (Post p : postList) {
            p.setVoteCount(voteRepository.countVotesByPostId(p.getId()));
        }
        return postList;
    }

    @GetMapping("/api/posts/{id}")
    public Post getPost(@PathVariable Integer id) {
        Post returnPost = repository.getReferenceById(id);
        returnPost.setVoteCount(voteRepository.countVotesByPostId(returnPost.getId()));
        return returnPost;
    }

    @PostMapping("/api/posts")
    @ResponseStatus(HttpStatus.CREATED)
    public Post addPost(@RequestBody Post post) {
        repository.save(post);
        return post;
    }

    @PutMapping("/api/posts/{id}")
    public Post updatePost(@PathVariable int id, @RequestBody Post post) {
        Post tempPost = repository.getById(id);
        tempPost.setTitle(post.getTitle());
        return repository.save(tempPost);
    }

    @PutMapping("/api/posts/upvote")
    public String addVote(@RequestBody Vote vote, HttpServletRequest request) {
        String returnValue = "";
        if(request.getSession(false) != null) {
            Post returnPost = null;
            User sessionUser = (User) request.getSession().getAttribute("SESSION_USER");
            vote.setUserId(sessionUser.getId());
            voteRepository.save(vote);
            returnPost = repository.getById(vote.getPostId());
            returnPost.setVoteCount(voteRepository.countVotesByPostId(vote.getPostId()));
            returnValue = "";
        } else {
            returnValue = "login";
        }
        return returnValue;
    }

    @DeleteMapping("/api/posts/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePost(@PathVariable int id) {
        repository.deleteById(id);
    }
}
