package com.example.JavaApp.Subject;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SubjectRepository extends JpaRepository<Subject,Long> {


    @Query(value = "SELECT COLUMN_VALUE AS title FROM TABLE(get_subject_titles())", nativeQuery = true)
    List<Long> findSubjects(); //de eliminat

 }
