package com.sandeep.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sandeep.entities.Students;

@Repository
public interface StudentRepo  extends JpaRepository<Students, Integer>{

}
