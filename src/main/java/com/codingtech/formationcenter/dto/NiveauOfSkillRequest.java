package com.codingtech.formationcenter.dto;

public class NiveauOfSkillRequest {
    private String skillName;
    private String niveauOfSkillDeveloper;

    // Constructors, getters, and setters
    public NiveauOfSkillRequest() {
        // Default constructor for deserialization
    }

    public NiveauOfSkillRequest(String skillName, String niveauOfSkillDeveloper) {
        this.skillName = skillName;
        this.niveauOfSkillDeveloper = niveauOfSkillDeveloper;
    }

    // Getters and setters

    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }

    public String getNiveauOfSkillDeveloper() {
        return niveauOfSkillDeveloper;
    }

    public void setNiveauOfSkillDeveloper(String niveauOfSkillDeveloper) {
        this.niveauOfSkillDeveloper = niveauOfSkillDeveloper;
    }
}
