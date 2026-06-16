package my.scripts;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import java.io.*;
import java.util.Objects;


public class WordFile {

    private int count = 0;
    private XWPFDocument doc;

    public void createWordFile(String packagePath) {
        File newFile = new File("FrontEnd.docx");
        try {
            newFile.createNewFile();
        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }
        File dir = new File(packagePath);
        try(FileOutputStream fis = new FileOutputStream(newFile.getAbsolutePath())){
            doc = new XWPFDocument();
            for(File file : Objects.requireNonNull(dir.listFiles())){
                findFiles(file);
            }
            doc.write(fis);
            System.out.println(count);
            doc.close();
        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }

    }

    private void findFiles(File file) throws IOException {
        if(file.isFile() && !file.getName().endsWith(".DS_Store")){
            ++count;
            System.out.println(file.getName());
            addParagraph(file);
        }
        else if(file.isDirectory()){
            for(File dirFile : file.listFiles()){
                if(dirFile == null) return;
                if(dirFile.isDirectory()){
                    findFiles(dirFile);
                }
                else if(!dirFile.getName().endsWith(".DS_Store")) {
                    ++count;
                    System.out.println(dirFile.getName());
                    addParagraph(dirFile);
                }
            }
        }

    }

    private void addParagraph(File file) throws IOException {
        XWPFParagraph paragraph = doc.createParagraph();
        XWPFRun run = paragraph.createRun();
        run.setText(file.getName());
        run.setFontSize(14);
        run.setFontFamily("Times New Roman");
        run.addBreak();
        convertTextFileToString(file);
        paragraph = doc.createParagraph();
        run = paragraph.createRun();
        run.addBreak();
    }

    private void convertTextFileToString(File file) throws IOException {
        try(BufferedReader br = new BufferedReader(new FileReader(file))) {
            while(br.ready()){
                addLine(br.readLine());
            }
        }
    }

    private void addLine(String line) {
        XWPFParagraph paragraph = doc.createParagraph();
        XWPFRun run = paragraph.createRun();
        run.setText(line);
        run.setFontSize(9);
        run.setFontFamily("Courier new");
    }
}
