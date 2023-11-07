package com.example.homework.Controller;

import com.example.homework.Model.Employee;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/hadoop")
public class EmployeeController {
    @Autowired
    private FileSystem fileSystem;

    @GetMapping("/employee")
    public ResponseEntity<List<Employee>> readEmployee() {
        List<Employee> ErrorList = new ArrayList<>();
        try {
            Path hdfsFilePath = new Path("/homework/employee/emp.csv");

            if (fileSystem.exists(hdfsFilePath)) {
                FSDataInputStream inputStream = fileSystem.open(hdfsFilePath);

                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
                List<Employee> employees =new ArrayList<>();

                String line;

                while ((line = reader.readLine()) != null) {
                    String[] values = line.split(",");

                    String empno = values[0];
                    String ename = values[1];
                    String job = values[2];
                    String mgr = values[3];
                    String hiredate = values[4];
                    String sal = values[5];
                    String comm = values[6];
                    String deptno =  values[7];
                    String img = values[8];

                    Employee employee = new Employee(empno,ename,job,mgr,hiredate,sal,comm,deptno,img);

                    employees.add(employee);
                }

                reader.close();
                inputStream.close();

                return ResponseEntity.ok(employees);
            } else {
                ErrorList.add(new Employee(" ","Fault"," "," "," "," "," "," "," "));
                return ResponseEntity.ok(ErrorList);
            }
        } catch (Exception e) {
            ErrorList.add(new Employee(" ","Hadoop Connection Error",e.getMessage()," "," "," "," "," "," "));
            return ResponseEntity.ok(ErrorList);
        }
    }
}

