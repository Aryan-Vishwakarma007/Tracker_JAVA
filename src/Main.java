import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("NO COMMAND GIVEN");
            return;
        }
        String command = args[0];
        if (command.equals("add")) {
            if (args.length < 2) {
                System.out.println("provide a task");
                return;
            }
            String task = args[1];
            saveTask(task);
        } else if (command.equals("show")) {
            showTasks();
        } else if (command.equals("update")) {
            if (args.length < 3) {
                System.out.println("provide a task");
                return;
            }
            String tobereplce = args[1];
            String isreplacing = args[2];
            updatetasks(tobereplce, isreplacing);
        } else if (command.equals("delete")) {
            if (args.length < 2) {
                System.out.println("provide a task");
                return;
            }
            String tobedeleted = args[1];
            deletetask(tobedeleted);
        }


    }

    static void saveTask(String task) {
        try {
            FileWriter fw = new FileWriter("tasks.json", true); // true = append
            fw.write(task + "\n");
            fw.close();
        } catch (Exception e) {
            System.out.println("Error saving task");
        }
    }

    static void showTasks() {
        String filePath = "C:\\CODING\\Java_Project\\Task_Tracker\\Tracker\\src\\tasks.json";
        try (BufferedReader reader = new BufferedReader(new FileReader("tasks.json"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("error ");
        }
    }

    static void updatetasks(String tobereplce, String isreplacing) {
        ArrayList<String> lines = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("tasks.json"))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.equals(tobereplce)){
                    lines.add(isreplacing);          //matlab bc yaha ye hora h ki arraylist me saare line aare h but tobereplace ke jagha par isreplacing aara h
                }
                else {
                    lines.add(line);
                }
            }
        }
        catch (IOException e){
            System.out.println("error in update");
        }
        try(FileWriter wr = new FileWriter("tasks.json")){
            for(String st : lines){
                wr.write(st + "\n");
            }
        }catch (IOException e){
            System.out.println("Error in re writing");
        }

    }
    static void deletetask(String tobedeleted){
        ArrayList<String> lines = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("tasks.json"))){
            String line;
            while ((line = br.readLine()) != null){
                if(line.equals(tobedeleted)){
                    continue;
                }
                else {
                    lines.add(line);
                }
            }
        }
        catch (IOException e){
            System.out.println("error in update");
        }
        try(FileWriter wr = new FileWriter("tasks.json")){
            for(String st : lines){
                wr.write(st + "\n");
            }
        }catch (IOException e){
            System.out.println("Error in re writing");
        }
    }

}