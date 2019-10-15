package com.patients.patientsinfo.repository;

import com.patients.patientsinfo.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
