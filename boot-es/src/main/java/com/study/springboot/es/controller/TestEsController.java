package com.study.springboot.es.controller;

import com.study.springboot.es.entity.Employee;
import com.study.springboot.es.service.EmployeeRepository;
import com.study.springboot.es.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.web.bind.annotation.*;

/**
 * @author edz
 */
@SpringBootApplication
@RestController
@RequestMapping("employee")
@EnableElasticsearchRepositories(basePackages = "com.study.springboot.es.service")
public class TestEsController {
    private Logger logger = LoggerFactory.getLogger(TestEsController.class);
    @Autowired
    private EmployeeRepository employeeService;

    public static void main(String[] args) {
        SpringApplication.run(TestEsController.class);
    }
    @PutMapping("save")
    public void save(@RequestBody  Employee employee){
        logger.error(employee.toString());
        Employee save = employeeService.save(employee);
        logger.error("save return: ",save);
    }
    @GetMapping("{id}")
    @ResponseBody
    public Employee getBy(@PathVariable String id){
        return employeeService.findById(id).get();
    }

}
