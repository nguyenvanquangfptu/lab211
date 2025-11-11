package com.mycompany.lab211.slot8;

/**
 *
 * @author HP
 */
public abstract class Candidate {

    protected String candidateID;
    protected String firstName;
    protected String lastName;
    protected int birthYear;
    protected String address;
    protected String phone;
    protected String email;
    protected int candidateType; // 0: Experience, 1: Fresher, 2: Internship

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public int getCandidateType() {
        return candidateType;
    }

    public String toSearchLine() {
        return String.format("%s | %d | %s | %s | %s | %d",
                getFullName(), birthYear, address, phone, email, candidateType);
    }

    public abstract String getTitle();
}
