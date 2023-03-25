package com.lakhan.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lakhan.model.Task;

@Repository
public interface TaskRepo extends JpaRepository<Task, Integer> {

}
