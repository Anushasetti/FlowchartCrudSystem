package com.example.flowchart.controller;

import com.example.flowchart.model.Flowchart;
import com.example.flowchart.model.Edge;
import com.example.flowchart.service.FlowchartService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.HashSet;
import java.util.Set;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;

@WebMvcTest(FlowchartController.class)
public class FlowchartControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private FlowchartService flowchartService;

    // Helper method to create a sample Flowchart
    private Flowchart createSampleFlowchart() {
        Set<String> nodes = Set.of("Node1", "Node2");
        Set<Edge> edges = Set.of(new Edge("Node1", "Node2"));
        Flowchart flowchart = new Flowchart(nodes, edges);
        return flowchart;
    }

    @Test
    public void testCreateFlowchart() throws Exception {
        Flowchart sampleFlowchart = createSampleFlowchart();
        when(flowchartService.createFlowchart(anySet(), anySet())).thenReturn(sampleFlowchart);

        String requestBody = "{" +
                "\"id\": \"1\", " +
                "\"nodes\": [\"Node1\", \"Node2\"], " +
                "\"edges\": [{\"fromNode\": \"Node1\", \"toNode\": \"Node2\"}] " +
                "}";

        mockMvc.perform(post("/api/flowcharts")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value("1"))
                .andExpect(jsonPath("$.nodes").isArray())
                .andExpect(jsonPath("$.edges").isArray())
                .andDo(print());

        verify(flowchartService, times(1)).createFlowchart(anySet(), anySet());
    }

    @Test
    public void testGetFlowchartById() throws Exception {
        Flowchart sampleFlowchart = createSampleFlowchart();
        when(flowchartService.getFlowchartById("1")).thenReturn(sampleFlowchart);

        mockMvc.perform(get("/api/flowcharts/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value("1"))
                .andDo(print());

        verify(flowchartService, times(1)).getFlowchartById("1");
    }

    @Test
    public void testUpdateFlowchart() throws Exception {
        Flowchart sampleFlowchart = createSampleFlowchart();
        when(flowchartService.updateFlowchart(eq("1"), anySet(), anySet())).thenReturn(sampleFlowchart);

        String requestBody = "{" +
                "\"nodes\": [\"Node1\", \"Node3\"], " +
                "\"edges\": [{\"fromNode\": \"Node1\", \"toNode\": \"Node3\"}] " +
                "}";

        mockMvc.perform(put("/api/flowcharts/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value("1"))
                .andExpect(jsonPath("$.nodes").isArray())
                .andDo(print());

        verify(flowchartService, times(1)).updateFlowchart(eq("1"), anySet(), anySet());
    }

    @Test
    public void testDeleteFlowchart() throws Exception {
        when(flowchartService.deleteFlowchart("1")).thenReturn(true);

        mockMvc.perform(delete("/api/flowcharts/1"))
                .andExpect(status().isNoContent())
                .andDo(print());

        verify(flowchartService, times(1)).deleteFlowchart("1");
    }

    @Test
    public void testGetFlowchartByIdNotFound() throws Exception {
        when(flowchartService.getFlowchartById("2")).thenReturn(null);

        mockMvc.perform(get("/api/flowcharts/2"))
                .andExpect(status().isNotFound())
                .andDo(print());

        verify(flowchartService, times(1)).getFlowchartById("2");
    }

    @Test
    public void testDeleteFlowchartNotFound() throws Exception {
        when(flowchartService.deleteFlowchart("2")).thenReturn(false);

        mockMvc.perform(delete("/api/flowcharts/2"))
                .andExpect(status().isNotFound())
                .andDo(print());

        verify(flowchartService, times(1)).deleteFlowchart("2");
    }
}

