package com.aidar.repository;

import com.aidar.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by paradise on 30.03.16.
 */
@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
}
