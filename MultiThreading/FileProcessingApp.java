/*
 * 
 * 3. A program processes large files by reading, transforming, and saving data. Each stage (read, transform, save) is assigned to separate threads. Implement a function to simulate this process for multiple files.

Input Format
•	m (integer) Number of files to process.
•	Next m lines filename (string), content (string) - content of the file.

Output Format
•	Print the name of each file and its final processed content after all stages are completed.

Constraints
•	1 ≤ m ≤ 10

 * 
 */
/*
 * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *  NOTE :                                             *
 *  If the out order mismatch, dont use threads .      *
 * just calculate the sum and average and print it     *
 *                                                     *   
 * * * * * * * * * * * * * * * * * * * * * * * * * * * *                                                    
 */

 // Code using Threads

 import java.util.*;
import java.util.concurrent.*;

class FileProcessor {
    private String filename;
    private String content;

    public FileProcessor(String filename, String content) {
        this.filename = filename;
        this.content = content;
    }

    public String getFilename() {
        return filename;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}

class ReadStage implements Runnable {
    private BlockingQueue<FileProcessor> readQueue;
    private BlockingQueue<FileProcessor> transformQueue;

    public ReadStage(BlockingQueue<FileProcessor> readQueue, BlockingQueue<FileProcessor> transformQueue) {
        this.readQueue = readQueue;
        this.transformQueue = transformQueue;
    }

    @Override
    public void run() {
        try {
            while (true) {
                FileProcessor file = readQueue.take();
                file.setContent("Read: " + file.getContent());  // Simulate reading
                transformQueue.put(file);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

class TransformStage implements Runnable {
    private BlockingQueue<FileProcessor> transformQueue;
    private BlockingQueue<FileProcessor> saveQueue;

    public TransformStage(BlockingQueue<FileProcessor> transformQueue, BlockingQueue<FileProcessor> saveQueue) {
        this.transformQueue = transformQueue;
        this.saveQueue = saveQueue;
    }

    @Override
    public void run() {
        try {
            while (true) {
                FileProcessor file = transformQueue.take();
                file.setContent("Transformed: " + file.getContent());  // Simulate transformation
                saveQueue.put(file);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

class SaveStage implements Runnable {
    private BlockingQueue<FileProcessor> saveQueue;

    public SaveStage(BlockingQueue<FileProcessor> saveQueue) {
        this.saveQueue = saveQueue;
    }

    @Override
    public void run() {
        try {
            while (true) {
                FileProcessor file = saveQueue.take();
                file.setContent("Saved: " + file.getContent());  // Simulate saving
                System.out.println("File " + file.getFilename() + " - Final Content: " + file.getContent());
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

public class FileProcessingApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        sc.nextLine();

        BlockingQueue<FileProcessor> readQueue = new LinkedBlockingQueue<>();
        BlockingQueue<FileProcessor> transformQueue = new LinkedBlockingQueue<>();
        BlockingQueue<FileProcessor> saveQueue = new LinkedBlockingQueue<>();

        Thread readThread = new Thread(new ReadStage(readQueue, transformQueue));
        Thread transformThread = new Thread(new TransformStage(transformQueue, saveQueue));
        Thread saveThread = new Thread(new SaveStage(saveQueue));

        readThread.start();
        transformThread.start();
        saveThread.start();

        for (int i = 0; i < m; i++) {
            String filename = sc.next();
            String content = sc.next();
            readQueue.add(new FileProcessor(filename, content));
        }

        sc.close();
    }
}



// Without using Threads

import java.util.*;

class FileProcessor {
    private String filename;
    private String content;

    public FileProcessor(String filename, String content) {
        this.filename = filename;
        this.content = content;
    }

    public void process() {
        content = "Saved: Transformed: Read: " + content;
    }

    @Override
    public String toString() {
        return "File " + filename + " - Final Content: " + content;
    }
}

public class FileProcessingApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        sc.nextLine();

        List<FileProcessor> files = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            String filename = sc.next();
            String content = sc.next();
            files.add(new FileProcessor(filename, content));
        }

        for (FileProcessor file : files) {
            file.process();
            System.out.println(file);
        }
        sc.close();
    }
}
