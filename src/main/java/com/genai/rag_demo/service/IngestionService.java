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

    @Value("src/main/resources/docs")
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

        File docsDir = new File("./src/main/resources/docs");
        if (!docsDir.exists() || !docsDir.isDirectory()) {
            return List.of();
        }

        try (Stream<Path> paths = Files.walk(docsDir.toPath())) {
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

            // Add metadata to each document
            List<Document> documentsWithMetadata = documents.stream().map(doc -> {
                doc.getMetadata().put("filename", file.getFilename());
                try {
                    doc.getMetadata().put("filepath", file.getFile().getAbsolutePath());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                doc.getMetadata().put("source", "document");
                doc.getMetadata().put("ingested_at", String.valueOf(System.currentTimeMillis()));
                return doc;
            }).collect(Collectors.toList());

            // Split the documents into smaller chunks
            List<Document> splitDocuments = new TokenTextSplitter().apply(documentsWithMetadata);

            // Store embeddings along with metadata
            vectorStore.add(splitDocuments);

            log.info("Successfully uploaded: " + file.getFilename());

        } catch (Exception e) {
            log.error("Failed to process file: " + file.getFilename(), e);
        }
    }
}
