package com.example.homework.Controller;

import com.example.homework.Model.Department;
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
public class DeparmentController {
    @Autowired
    private FileSystem fileSystem;

    @GetMapping("/department")
    public ResponseEntity<List<Department>> readDepartment(){
        List<Department> Error = new ArrayList<>();

        try{
            Path hdfsDeptPath = new Path("/homework/department/dept.csv");

            if(fileSystem.exists(hdfsDeptPath)) {
                FSDataInputStream inputStream = fileSystem.open(hdfsDeptPath);

                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
                List<Department> depts = new ArrayList<>();

                String line;

                while ((line = reader.readLine()) != null) {
                    String[] vals = line.split(",");

                    String deptno = vals[0];
                    String dname = vals[1];
                    String loc= vals[2];

                    Department dept = new Department(deptno,dname,loc);
                    depts.add(dept);
                }

                reader.close();
                inputStream.close();

                return ResponseEntity.ok(depts);
            }
            return ResponseEntity.ok(Error);
        } catch (Exception e) {
            return ResponseEntity.ok(Error);
        }
    }
}
