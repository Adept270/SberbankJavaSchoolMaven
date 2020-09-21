package com.jschool.Day5_Reflection.Task1_Annotations.Base_Reflection;

public class ChildClass extends ParentClass {
    public String myJod;
    private String myRealJob;
    public static final String SEPTEMBER = "SEPTEMBER";
    public static final String NOVEMBER = "SEPTEMBER";

    public ChildClass(String name, int age, String myJod, String myRealJob) {
        super(name, age);
        this.myJod = myJod;
        this.myRealJob = myRealJob;
    }

    public String getMyJod() {
        return myJod;
    }

    public void setMyJod(String myJod) {
        this.myJod = myJod;
    }

    private String getMyRealJob() {
        return myRealJob;
    }

    private void setMyRealJob(String myRealJob) {
        this.myRealJob = myRealJob;
    }
}
