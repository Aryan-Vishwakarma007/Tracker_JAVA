📝 Task Tracker (Java CLI)

A simple command-line task manager built using Java.
This project allows users to add, view, and update tasks stored in a file.

🚀 Features
  Add a new task
  View all tasks
  Update an existing task
🛠️ Tech Used
  Java
  File Handling (FileWriter, BufferedReader)
📂 Project Structure
  src/Main.java → Main logic
  tasks.json → Stores tasks (currently plain texts)
▶️ How to Run
  Compile
  javac Main.java
  
Run Commands
Add a task:
java Main add "Buy milk"
Show tasks:
java Main show
Update a task:
java Main update "Buy milk" "Buy coffee"

⚠️ Limitations

  Tasks are stored as plain text (not actual JSON)
  No delete functionality yet
  No task IDs
📌 Future Improvements

  Convert storage to real JSON format
  Add delete feature
  Add task IDs and status (done/pending)
  Build a better CLI interface
