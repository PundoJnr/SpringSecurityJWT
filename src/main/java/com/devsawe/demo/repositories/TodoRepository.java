package com.devsawe.demo.repositories;

import com.devsawe.demo.entities.TodoModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TodoRepository extends JpaRepository<TodoModel, Long> {
    Page<TodoModel> findByUserId(Long userId, Pageable pageable);
    List<TodoModel> findByUserId(Long userId);
    Optional<TodoModel> findByIdAndUserId(Long id, Long UserId);
}
