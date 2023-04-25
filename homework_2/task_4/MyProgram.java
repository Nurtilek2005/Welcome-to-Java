/* Задача №4
 * ==========================================================================================================
 * Напишите программу, которая
 * 1) по указанной строке URL скачивает файл и возвращает строковое содержимое файла
 * 2) изменяет строковое содержимое файла подставляя по маске "%s" ваше имя
 * 3) сохраняет файл локально
 * 4) читает сохраненный файл и выводит содержимое в логгер
 * 5) удаляет сохраненный файл
 * ==========================================================================================================
 */

package homework_2.task_4;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.logging.Logger;

public class MyProgram {
    Logger logger;
    File localFile;

    public void run() {
        String fileUrl = "https://raw.githubusercontent.com/aksodar/JSeminar_2/master/src/main/resources/example.txt";
        String localFilename = "example.txt";
        String name = "Незнакомец";

        String fileContent = download(fileUrl, localFilename);
        String changedContent = change(name, fileContent);
        saveOnLocal(localFilename, changedContent);
        read(localFilename);
        removeFromLocale(localFilename);
    }

    public String download(String url, String localFilename) {
        HttpURLConnection connection;
        try {
            URL fileUrl = new URL(url);
            this.logger.info("Attempting to connect with " + url);
            connection = (HttpURLConnection) fileUrl.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);
            connection.connect();

            this.logger.info("Connection successfully!");
            StringBuilder content = new StringBuilder();
            this.logger.info("Reading content data...");
            InputStream contentStream = connection.getInputStream();
            InputStreamReader contentStreamReader = new InputStreamReader(contentStream);
            try (BufferedReader reader = new BufferedReader(contentStreamReader)) {
                String line;
                while ((line = reader.readLine()) != null) {
                    content.append(line);
                }
            }
            this.logger.info("Completed!");
            return content.toString();
        } catch (MalformedURLException e) {
            this.logger.severe("URL error: " + e.getMessage());
            return null;
        } catch (IOException e) {
            this.logger.severe("IO error: " + e.getMessage());
            return null;
        }
    }

    public String change(String name, String fileContent) {
        return fileContent.replaceAll("%s", name);
    }

    public void read(String localFilename) {
        File localFile = new File(localFilename);
        Path filePath = localFile.toPath();
        this.logger.info("Opening file " + localFilename);
        if (!Files.exists(localFile.toPath())) {
            this.logger.warning("File " + localFilename + " not found!");
            return;
        }
        try {
            List<String> lines = Files.readAllLines(filePath);
            String fileContent = String.join("\n", lines);
            this.logger.info(fileContent);
        } catch (IOException e) {
            this.logger.severe("IO error: " + e.getMessage());
        }
    }

    public void saveOnLocal(String fileName, String fileContent) {
        localFile = new File(fileName);
        try {
            this.logger.info("Opening file " + fileName);
            if (!Files.exists(localFile.toPath())) {
                this.logger.warning("File " + fileName + " not found! Creating a new...");
                Files.createFile(localFile.toPath());
            }
            this.logger.info("Writing content to " + fileName);
            FileWriter fileWriter = new FileWriter(this.localFile);
            fileWriter.write(fileContent);
            this.logger.info("Completed!");
            fileWriter.close();
        } catch (IOException e) {
            this.logger.severe("IO error: " + e.getMessage());
        }
    }

    public boolean removeFromLocale(String fileName) {
        File localFile = new File(fileName);
        Path filePath = localFile.toPath();
        this.logger.info("Finding file " + fileName);
        if (!Files.exists(localFile.toPath())) {
            this.logger.warning("File " + fileName + " not found!");
            return false;
        }
        try {
            Files.delete(filePath);
            this.logger.info("File " + fileName + " deleted successfully!");
            return true;
        } catch (IOException e) {
            this.logger.severe("IO error: " + e.getMessage());
            return false;
        }
    }

    public static void main(String[] args) throws IOException {
        MyProgram program = new MyProgram();
        program.logger = Logger.getLogger(MyProgram.class.getName());
        program.run();
    }
}
