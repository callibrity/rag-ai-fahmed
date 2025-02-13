# RAG AI - File Ingestion and Transcription Service

This project implements a Retrieval-Augmented Generation (RAG) system that ingests documents, processes them, and stores transcribed and tokenized content in a vector store. It is built using Spring AI.

## Features
- **Document Processing**: Extracts text from various document formats using Apache Tika.
- **Vector Store Integration**: Stores extracted/transcribed text in a vector database for retrieval.

## Prerequisites
- **Java 23+**
- **Spring Boot 3+**
- **Maven**
- **Docker** (if using a vector database like Pinecone, Weaviate, or FAISS)
- **OpenAI API Key**

## Installation

1. Clone the repository:
   ```sh
   git clone https://github.com/callibrity/rag-ai-fahmed.git
   cd rag-ai-fahmed
   ```
2. Install dependencies:
   ```sh
   mvn clean install
   ```
3. Set up environment variables:
   ```sh
   export OPENAI_API_KEY=your_openai_api_key
   ```
4. Run the application:
   ```sh
   mvn spring-boot:run
   ```

## Usage
Place documents and audio files in the `src/main/resources/docs` directory. The ingestion service will automatically process and upload them when the application starts.

## Example request
``` 
curl -X POST http://localhost:8080/chat \
     -H "Content-Type: application/json" \
     -d '{"question": "Summarize the amano case study"}'
```
