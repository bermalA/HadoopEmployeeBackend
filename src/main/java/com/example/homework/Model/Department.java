package com.example.homework.Model;

public class Department {
   public String deptno;
   public String dname;
   public String loc;

   public Department(String deptno, String dname, String loc) {
      this.deptno = deptno;
      this.dname = dname;
      this.loc = loc;
   }

   public String getDeptno() {
      return deptno;
   }

   public void setDeptno(String deptno) {
      this.deptno = deptno;
   }

   public String getDname() {
      return dname;
   }

   public void setDname(String dname) {
      this.dname = dname;
   }

   public String getLoc() {
      return loc;
   }

   public void setLoc(String loc) {
      this.loc = loc;
   }
}
