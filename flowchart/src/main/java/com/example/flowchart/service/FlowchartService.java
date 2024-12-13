package com.example.flowchart.service;

import com.example.flowchart.model.Edge;
import com.example.flowchart.model.Flowchart;
import com.example.flowchart.repository.EdgeRepository;
import com.example.flowchart.repository.FlowchartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;


@Service
public class FlowchartService {

    private final FlowchartRepository flowchartRepository;

    @Autowired
    public FlowchartService(FlowchartRepository flowchartRepository) {
        this.flowchartRepository = flowchartRepository;
    }

    //Create
    public Flowchart createFlowchart(Set<String> nodes, Set<Edge> edges) {
        Flowchart flowchart = new Flowchart(nodes, edges);
        return flowchartRepository.save(flowchart);
    }

    // Get
    public Flowchart getFlowchartById(String id) {
        return flowchartRepository.findById(id).orElse(null);
    }

    // Update
    public Flowchart updateFlowchart(String id, Set<String> nodes, Set<Edge> edges) {
        Flowchart flowchart = flowchartRepository.findById(id).orElse(null);
        if (flowchart != null) {
        	 // Update nodes
            flowchart.getNodes().clear();
            flowchart.getNodes().addAll(nodes);

            // Update edges
            flowchart.getEdges().clear();
            flowchart.getEdges().addAll(edges);
            
            return flowchartRepository.save(flowchart);
        }
        return null;
    }

    // Delete
    public boolean deleteFlowchart(String id) {
        if (flowchartRepository.existsById(id)) {
            flowchartRepository.deleteById(id);
            return true;
        }
        return false;
    }
}

