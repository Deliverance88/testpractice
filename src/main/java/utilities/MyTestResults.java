package utilities;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class MyTestResults {
    int passed;
    int failed;
    int skipped;

    public int getPassed() {
        return this.passed;
    }

    public int getFailed() {
        return this.failed;
    }

    public int getSkipped() {
        return this.skipped;
    }

    public int totalTests() {
        return this.passed + this.failed + this.skipped;
    }

    public void incrementPassed() {
        this.passed++;
    }

    public void incrementFailed() {
        this.failed++;
    }

    public void incrementSkipped() {
        this.skipped++;
    }

    public void writeToCSV() {
        File file = new File("TestResults.csv");
        try (FileWriter fw = new FileWriter(file); BufferedWriter bWriter = new BufferedWriter(fw);) {
            fw.write("PASSED = " + this.passed + "\n");
            fw.write("FAILED = " + this.failed + "\n");
            fw.write("SKIPPED = " + this.skipped + "\n");
            fw.write("TOTAL = " + this.totalTests());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}