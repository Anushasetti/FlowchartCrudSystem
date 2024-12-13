package com.example.flowchart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.flowchart.model.Edge;

@Repository
public interface EdgeRepository extends JpaRepository<Edge, Long> {
}

