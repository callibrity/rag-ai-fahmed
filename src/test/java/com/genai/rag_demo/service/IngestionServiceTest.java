package com.genai.rag_demo.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import java.io.IOException;

import static org.mockito.Mockito.*;

class IngestionServiceTest {

    @Mock
    private VectorStore vectorStore;

    @Mock
    private ResourceLoader resourceLoader;

    @InjectMocks
    private IngestionService ingestionService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testUpload() throws IOException {
        Resource mockResource = mock(Resource.class);
        when(mockResource.getFilename()).thenReturn("test.txt");
        when(mockResource.getInputStream()).thenReturn(getClass().getResourceAsStream("/docs/test.txt"));

        ingestionService.upload(mockResource);

        verify(vectorStore, atLeastOnce()).add(anyList());
    }
}