/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab211.slot8;

import com.mycompany.lab211.Utils;
import java.time.LocalDate;
import java.util.*;

/**
 *
 * @author HP
 */
public class CandidateManagement {

    private final List<Candidate> candidates = new ArrayList<>();

    public boolean addCandidates(Candidate c) {
        return candidates.add(c);
    }

//    public void showFresher() {
//        System.out.println("Fresher.");
//        for (Candidate p : candidates) {
//            if (p instanceof Fresher) {
//                System.out.println(p);
//            }
//        }
//    }
//
//    public void showExperience() {
//        System.out.println("Experience.");
//        for (Candidate p : candidates) {
//            if (p instanceof Experience) {
//                System.out.println(p);
//            }
//        }
//    }
//
//    public void showInternship() {
//        System.out.println("Internship.");
//        for (Candidate p : candidates) {
//            if (p instanceof Internship) {
//                System.out.println(p);
//            }
//        }
//    }
    public void inputExperience() {
        Experience e = new Experience();
        inputAll(e);
        e.setExpInYear(Utils.readIntInRange("Experience in years (0-100): ", 0, 100));
        e.setProSkill(Utils.readString("Professional Skill: "));
        if (candidates.add(e)) {
            System.out.println("Add candidate succesfully.");
        } else {
            System.out.println("Cannot add.");
        }
    }

    public void inputFresher() {
        Fresher f = new Fresher();
        inputAll(f);
        f.setGraduationYear(Utils.readIntInRange("Graduation Year: ", 2020, LocalDate.now().getYear()));
        f.setGraduationRank(Utils.readString("Graduation Rank (Excellence/Good/Fair/Poor): "));
        f.setEducation(Utils.readString("Education: "));
        if (candidates.add(f)) {
            System.out.println("Add candidate succesfully.");
        } else {
            System.out.println("Cannot add.");
        }
    }

    public void inputIntern() {
        Internship i = new Internship();
        inputAll(i);
        i.setMajors(Utils.readString("Majors: "));
        i.setSemester(Utils.readIntInRange("Semester (1-12): ", 1, 12));
        i.setUniversityName(Utils.readString("University Name: "));
        if (candidates.add(i)) {
            System.out.println("Add candidate succesfully.");
        } else {
            System.out.println("Cannot add.");
        }
    }

    private void inputAll(Candidate c) {
        c.candidateID = Utils.readString("Candidate ID: ");
        c.firstName = Utils.readString("First Name: ");
        c.lastName = Utils.readString("Last Name: ");
        c.birthYear = Utils.readIntInRange("Birth Year (1900-2025): ", 1900, 2025);
        c.address = Utils.readString("Address: ");
        c.phone = Utils.readString("Phone (>=10 digits): ");
        c.email = Utils.readString("Email: ");
    }

    public boolean isEmpty() {
        return candidates == null;
    }

    public void printGrouped() {
        printGroup(0);
        printGroup(1);
        printGroup(2);
    }

    private void printGroup(int type) {
        String title = switch (type) {
            case 0 ->
                "=========== EXPERIENCE CANDIDATE ===========";
            case 1 ->
                "=========== FRESHER CANDIDATE =============";
            case 2 ->
                "=========== INTERNSHIP CANDIDATE ===========";
            default ->
                "";
        };
        System.out.println(title);
        for (Candidate c : candidates) {
            if (c.getCandidateType() == type) {
                System.out.println(c.getFullName());
            }
        }
        System.out.println();
    }

    public void searchCandidate() {

        String key = Utils.readString("Enter candidate name: ").toLowerCase();
        int type = Utils.readIntInRange("Input type (0-Experience, 1-Fresher, 2-Internship): ", 0, 2);

        System.out.println("\n===== Search Results =====");

        List<Candidate> results = new ArrayList<>();

        for (Candidate c : candidates) {
            String fullName = c.getFullName();

            if (c.getCandidateType() == type && fullName.equalsIgnoreCase(key)) {
                results.add(c);
            }
        }
        if (results.isEmpty()) {
            System.out.println("No candidate found matching the criteria.");
        } else {
            System.out.println("The candidates found:");
            for (Candidate c : results) {
                System.out.println(c.toSearchLine());
            }
        }
        System.out.println();
    }
}
