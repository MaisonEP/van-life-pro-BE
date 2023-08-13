package org.example.DBModel.comments;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface CommentsRepository extends JpaRepository<Comment, UUID> {
        public List<Comment> findAllByPostId(UUID postId);
        }
