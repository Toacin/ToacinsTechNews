package com.ToacinsTechNews.repository;

import com.ToacinsTechNews.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Integer> {
    List<Comment> findAllCommentsByPostId(int postId);
}
