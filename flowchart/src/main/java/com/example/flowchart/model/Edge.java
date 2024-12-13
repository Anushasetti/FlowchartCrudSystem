package com.example.flowchart.model;

import jakarta.persistence.*;

@Entity
public class Edge {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    

    private String fromNode;
    private String toNode;

    public Edge() {}

    public Edge(String fromNode, String toNode) {
        this.fromNode = fromNode;
        this.toNode = toNode;
    }

    public Long getId() {
        return id;
    }

    public String getFromNode() {
        return fromNode;
    }

    public void setFromNode(String fromNode) {
        this.fromNode = fromNode;
    }

    public String getToNode() {
        return toNode;
    }

    public void setToNode(String toNode) {
        this.toNode = toNode;
    }
}

