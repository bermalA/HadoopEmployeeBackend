package com.example.homework.Model;

public class Employee {
    public String empno;
    public String ename;
    public String job;
    public String mgr;
    public String hiredate;
    public String sal;
    public String comm;
    public String deptno;
    public String img;

    public Employee(String empno, String ename, String job, String mgr, String hiredate, String sal, String comm, String deptno, String img) {
        this.empno = empno;
        this.ename = ename;
        this.job = job;
        this.mgr = mgr;
        this.hiredate = hiredate;
        this.sal = sal;
        this.comm = comm;
        this.deptno = deptno;
        this.img = img;
    }

}
