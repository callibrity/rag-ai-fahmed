package com.genai.rag_demo.service;

import org.slf4j.Logger;
import org.springframework.ai.document.Document;
import org.springframework.ai.reader.tika.TikaDocumentReader;
import org.springframework.ai.transformer.splitter.TokenTextSplitter;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class IngestionService implements CommandLineRunner {

    private static final Logger log = org.slf4j.LoggerFactory.getLogger(IngestionService.class);

    private final VectorStore vectorStore;
    private final ResourceLoader resourceLoader;

    @Value("classpath:/docs")
    private Resource docsFolder;

    public IngestionService(VectorStore vectorStore, ResourceLoader resourceLoader) {
        this.vectorStore = vectorStore;
        this.resourceLoader = resourceLoader;
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("Ingestion Service Started");
        List<Resource> files = listFiles(docsFolder);
        for (Resource file : files) {
            upload(file);
        }
        log.info("Vector store upload complete");
    }

    private List<Resource> listFiles(Resource folder) throws IOException {
        File directory = folder.getFile();
        if (!directory.exists() || !directory.isDirectory()) {
            return List.of();
        }

        try (Stream<Path> paths = Files.walk(directory.toPath())) {
            return paths.filter(Files::isRegularFile)
                    .map(Path::toFile)
                    .map(file -> resourceLoader.getResource("file:" + file.getAbsolutePath()))
                    .collect(Collectors.toList());
        }
    }

    public void upload(Resource file) {
        try {
            TikaDocumentReader documentReader = new TikaDocumentReader(file);
            List<Document> documents = documentReader.get();
            List<Document> splitDocuments = new TokenTextSplitter().apply(documents);
            vectorStore.add(splitDocuments);
        } catch (Exception e) {
            log.error("Failed to process file: " + file.getFilename(), e);
        }
    }
}
