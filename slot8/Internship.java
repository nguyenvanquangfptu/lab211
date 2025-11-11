/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab211.slot8;

import java.util.Date;

/**
 *
 * @author HP
 */
public class Internship extends Candidate {

    private String majors;
    private int semester;
    private String universityName;

    public Internship() {
        this.candidateType = 2; // Internship
    }

    public String getMajors() {
        return majors;
    }

    public void setMajors(String majors) {
        this.majors = majors;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public String getUniversityName() {
        return universityName;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }

    @Override
    public String getTitle() {
        return "=========== INTERNSHIP CANDIDATE ==========";
    }
}
