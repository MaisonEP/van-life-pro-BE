package org.example.DBModel.posts;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PostsRepository extends JpaRepository<Post, UUID> {
}
