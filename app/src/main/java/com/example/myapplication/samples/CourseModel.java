package com.example.myapplication.samples;

public class CourseModel {
    private String courseName;
    private String courseDuration;
    private String courseTracks;
    private String courseDescription;
    private int id;

    public CourseModel(String courseName,String courseDuration,String courseTracks,String courseDescription){
        this.courseName = courseName;
        this.courseDuration = courseDuration;
        this.courseTracks = courseTracks;
        this.courseDescription = courseDescription;

    }

    public String getCourseName() {
        return courseName;
    }

    public int getCourseDescription() {
        return 0;
    }

    public int getCourseDuration() {

        return 0;
    }

    public int getCourseTracks() {
        return 0;
    }
}
