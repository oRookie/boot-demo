package com.study.springboot.es.service;

import com.study.springboot.es.entity.Employee;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

/**
 * @author edz
 */
public interface EmployeeRepository extends ElasticsearchRepository<Employee,String> {
    /**
     * @param id
     * @return
     */
    Employee queryEmployeeById(String id);
}
