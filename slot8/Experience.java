/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab211.slot8;


/**
 *
 * @author HP
 */
public class Experience extends Candidate {
    private int expInYear;
    private String proSkill;

    public Experience() {
        this.candidateType = 0; // Experience
    }

    public int getExpInYear() {
        return expInYear;
    }

    public void setExpInYear(int expInYear) {
        this.expInYear = expInYear;
    }

    public String getProSkill() {
        return proSkill;
    }

    public void setProSkill(String proSkill) {
        this.proSkill = proSkill;
    }

    @Override
    public String getTitle() {
        return "========== EXPERIENCE CANDIDATE ==========";
    }
}
