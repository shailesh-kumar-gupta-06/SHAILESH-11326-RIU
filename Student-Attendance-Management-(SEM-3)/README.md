# Student Attendance Management System

A console-based Student Attendance Management System developed in Java.

## Features

1. Add a student with a unique roll number.
2. Mark attendance as Present (`P`) or Absent (`A`).
3. Search for a student using their roll number.
4. Display students whose attendance is below 75%.
5. Sort students by attendance percentage (high to low).
6. Display all student records.
7. Save records to `students.txt` and load them when the program starts.

## Concepts Used

- Java classes and objects
- `ArrayList`
- Methods
- Searching
- Sorting using `Comparator`
- File handling (`BufferedReader`, `BufferedWriter`)
- Exception handling
- Loops and conditional statements

## Requirements

- JDK 8 or later
- Visual Studio Code
- Java Extension Pack for VS Code (recommended)

## Run in VS Code

1. Open this project folder in VS Code.
2. Open the terminal (`Terminal > New Terminal`).
3. Check Java is installed:

   ```bash
   java -version
   javac -version
   ```

4. Compile:

   ```bash
   javac Main.java
   ```

5. Run:

   ```bash
   java Main
   ```

The program creates `students.txt` in the current working directory when data is saved. Keep this file in the project folder so records remain available the next time you run the program.

## Data File Format

Each line in `students.txt` stores:

```text
roll|name|classes_attended|classes_held
```

Example:

```text
101|Riya|4|4
102|Aman|3|5
```

## Attendance Rule

Attendance percentage is calculated as:

`(Classes Attended / Classes Held) * 100`

A student is a defaulter when their attendance is below 75%. A student with no recorded classes has 0.0% attendance.

## Test Scenarios

- Add student: roll `101`, name `Riya`.
- Search student `101` before recording attendance: `0/0`, `0.0%`.
- Mark attendance for a non-existing roll such as `555`: display `Roll 555 not found.`
- Add Riya and Aman, record their attendance, then check defaulters and sort by percentage.

## Notes

- Duplicate roll numbers are not allowed.
- Attendance input accepts only `P` or `A`.
- Data is saved after changes and again on exit.
