package com.example.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
public class StudentProperties implements EnvironmentAware {
    private Environment environment;

    @Override
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

    public void printProperties() {
        String name = environment.getProperty("student.name");
        String lastName = environment.getProperty("student.last_name");
        String group = environment.getProperty("student.group");

        System.out.println("Student: " + name + " " + lastName);
        System.out.println("Group: " + group);
    }
}
