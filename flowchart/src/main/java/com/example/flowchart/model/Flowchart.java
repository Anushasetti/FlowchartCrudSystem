package com.example.flowchart.model;

import jakarta.persistence.*;



import java.util.HashSet;
import java.util.Set;

/*@Entity
public class Flowchart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ElementCollection
    private Set<String> nodes = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Edge> edges = new HashSet<>();

    public Flowchart() {}

    public Flowchart(Set<String> nodes, Set<Edge> edges) {
        this.nodes = nodes;
        this.edges = edges;
    }

    public Long getId() {
        return id;
    }

    public Set<String> getNodes() {
        return nodes;
    }

    public void setNodes(Set<String> nodes) {
        this.nodes = nodes;
    }

    public Set<Edge> getEdges() {
        return edges;
    }

    public void setEdges(Set<Edge> edges) {
        this.edges = edges;
    }
}*/

import jakarta.persistence.*;
import java.util.Set;
import java.util.UUID;

@Entity
public class Flowchart {

    @Id
    private String id;

    @ElementCollection
    private Set<String> nodes;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Edge> edges;

    // Constructor
    public Flowchart(Set<String> nodes, Set<Edge> edges) {
        this.id = UUID.randomUUID().toString(); // Generate a unique ID
        this.nodes = nodes;
        this.edges = edges;
    }

    public Flowchart() {}

    // Getters and setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Set<String> getNodes() {
        return nodes;
    }

    public void setNodes(Set<String> nodes) {
        this.nodes = nodes;
    }

    public Set<Edge> getEdges() {
        return edges;
    }

    public void setEdges(Set<Edge> edges) {
        this.edges = edges;
    }
}


