/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab211.slot4.long21;

import com.mycompany.lab211.Menu;
import com.mycompany.lab211.Utils;
import java.util.*;

/**
 *
 * @author HP
 */
public class Main extends Menu {

    private final StudentDAO dao = new StudentDAO();
    private static final String TITLE = "\n ======= Student Management ============";
    private static final String[] ITEMS = {"Create", "Find and Sort", "Update/ Delete", "Report", "Exit"};

    public Main(String title, String[] mc) {
        super(title, mc);
    }

    @Override
    public void execute(int n) {
        switch (n) {
            case 1: {
                createStudents();
                break;
            }
            case 2: {
                findAndSort();
                break;
            }
            case 3: {
                updateOrDeleteStudent();
                break;
            }
            case 4: {
                reportStudent();
                break;
            }
            case 5: {
                return;
            }
        }
    }

    private void createStudents() {
        int i = 1;
        for (; i < 4; i++) {
            System.out.printf("Enter Student %d\n", i);
            addSudent();

        }
        while (true) {
            boolean check = Utils.readYesNo("Do you want to continue (Y/N)? Choose Y to\n"
                    + "continue (a student one time), N to return main screen.");
            if (check) {
                System.out.printf("Enter Student %d", i++);
                addSudent();
            } else {
                System.out.println("Create students successfully.");
                return;
            }
        }
    }

    private void addSudent() {
        String studentID = Utils.readStudentId("Enter student id: ");
        String studentName = Utils.readString("Enter student name: ");
        String semester = Utils.readSemester("Enter semester: ");
        String courseName = Utils.readCourseName("Enter course name: ");

        Student s = new Student(studentID, studentName, semester, courseName);
        boolean ok = dao.addStudent(s); // ✅ gọi INSERT qua DAO

        if (ok) {
            System.out.println("✅ Student added successfully.");
        } else {
            System.out.println("⚠️ Cannot add (duplicate ID or DB error).");
        }
    }

    private void updateOrDeleteStudent() {
        String sID = Utils.readStudentId("Enter id: ").trim();

        // 1️⃣ Lấy danh sách hiện tại từ DB
        List<Student> all = dao.getAllStudents();
        if (all.isEmpty()) {
            System.out.println("No student to execute.");
            return;
        }

        // 2️⃣ Kiểm tra xem ID này có tồn tại không
        Student exist = findByIdLocal(all, sID);
        if (exist == null) {
            System.out.println("No student found with ID: " + sID);
            return;
        }

        // 3️⃣ Hỏi người dùng muốn update hay delete
        boolean isUpdate = Utils.readUpdateOrDelete("Do you want to update (Y) or delete (N) student?");

        if (isUpdate) {
            // --- UPDATE ---
            String newName = Utils.readString("Enter new student name: ");
            String newSemester = Utils.readSemester("Enter new semester: ");
            String newCourse = Utils.readCourseName("Enter new course name: ");

            // Tạo 1 đối tượng mới với dữ liệu đã sửa
            Student updated = new Student(sID, newName, newSemester, newCourse);

            // Gọi DAO để UPDATE trong SQL
            boolean ok = dao.updateStudent(updated);
            System.out.println(ok ? "✅ Update successfully." : "⚠️ Update failed.");

        } else {
            // --- DELETE ---
            boolean ok = dao.deleteStudent(sID);
            System.out.println(ok ? "✅ Remove successfully." : "⚠️ Remove failed.");
        }
    }

// ================== Helpers ==================
    private Student findByIdLocal(List<Student> list, String id) {
        for (Student s : list) {
            if (s.getId() != null && s.getId().equalsIgnoreCase(id)) {
                return s;  // tìm thấy thì trả về student đó
            }
        }
        return null; // không thấy thì trả null
    }
// ================== REPORT (DAO) ==================

    private void reportStudent() {
        List<Student> all = dao.getAllStudents(); // lấy từ SQL
        if (all.isEmpty()) {
            System.out.println("No students to report.");
            return;
        }

        // Đếm theo ID | Semester | Course (đúng với code cũ của bạn)
        Map<String, Integer> report = new LinkedHashMap<>();
        for (Student st : all) {
            String key = st.getId() + " | " + st.getSemester() + " | " + st.getCourse();
            report.put(key, report.getOrDefault(key, 0) + 1);
        }

        System.out.println("\n------ REPORT (ID | Semester | Course | Total) ------");
        report.forEach((k, v) -> System.out.println(k + " | " + v));
    }
// ================== FIND & SORT (DAO) ==================

    private void findAndSort() {
        String input = Utils.readString("Enter student name (or full name): ").trim().toLowerCase();

        List<Student> all = dao.getAllStudents(); // lấy từ SQL
        if (all.isEmpty()) {
            System.out.println("No student to execute.");
            return;
        }

        // Giữ logic cũ: so khớp theo "last name" của input
        String[] inParts = input.split("\\s+");
        String keyword = inParts[inParts.length - 1]; // last word

        List<Student> result = new ArrayList<>();
        for (Student s : all) {
            String name = s.getName() == null ? "" : s.getName().trim().toLowerCase();
            String[] parts = name.split("\\s+");
            String lastName = parts.length == 0 ? "" : parts[parts.length - 1];
            if (lastName.equalsIgnoreCase(keyword)) {
                result.add(s);
            }
        }

        if (result.isEmpty()) {
            System.out.printf("No student found with name %s%n", input);
            return;
        }

        // Sort theo Name (ignore case), rồi đến ID để ổn định
        result.sort(Comparator
                .comparing(Student::getName, String.CASE_INSENSITIVE_ORDER)
                .thenComparing(Student::getId, String.CASE_INSENSITIVE_ORDER));

        showStudents(result); // dùng helper in danh sách (đã có trong Main ở bản trước)
    }
// ================== Helper: In danh sách sinh viên ==================

    private void showStudents(List<Student> list) {
        System.out.println("\n------ STUDENT LIST ------");
        System.out.printf("%-10s | %-25s | %-10s | %-10s%n",
                "ID", "Name", "Semester", "Course");
        System.out.println("---------------------------------------------------------------");

        for (Student s : list) {
            System.out.printf("%-10s | %-25s | %-10s | %-10s%n",
                    s.getId(),
                    s.getName(),
                    s.getSemester(),
                    s.getCourse());
        }
    }

    public static void main(String[] args) {
        Main app = new Main(TITLE, ITEMS);
        app.run();
    }
}
