package com.example.flowchart.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.flowchart.model.Flowchart;
import com.example.flowchart.service.FlowchartService;

import java.util.Set;


@RestController
@RequestMapping("/api/flowcharts")
@Tag(name = "Flowchart CRUD Management", description = "CRUD operations for managing flowcharts")
public class FlowchartController {

    private final FlowchartService flowchartService;

    @Autowired
    public FlowchartController(FlowchartService flowchartService) {
        this.flowchartService = flowchartService;
    }

    @PostMapping
    @Operation(summary = "Create a new flowchart", description = "Adds a new flowchart with nodes and edges.")
    public ResponseEntity<Flowchart> createFlowchart(@RequestBody Flowchart flowchart) {
        Flowchart createdFlowchart = flowchartService.createFlowchart(flowchart.getNodes(), flowchart.getEdges());
        return ResponseEntity.ok(createdFlowchart);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Fetch a flowchart by ID", description = "Fetches the details of a flowchart given its unique ID.")
    public ResponseEntity<Flowchart> getFlowchartById(@PathVariable String id) {
        Flowchart flowchart = flowchartService.getFlowchartById(id);
        return flowchart != null ? ResponseEntity.ok(flowchart) : ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update an existing flowchart", description = "Updates the nodes and edges of an existing flowchart.")
    public ResponseEntity<Flowchart> updateFlowchart(@PathVariable String id, @RequestBody Flowchart flowchart) {
        Flowchart updatedFlowchart = flowchartService.updateFlowchart(id, flowchart.getNodes(), flowchart.getEdges());
        return updatedFlowchart != null ? ResponseEntity.ok(updatedFlowchart) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a flowchart by ID", description = "Deletes an existing flowchart given its unique ID.")
    public ResponseEntity<Void> deleteFlowchart(@PathVariable String id) {
        if (flowchartService.deleteFlowchart(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}


