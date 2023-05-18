package com.example.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class TestApplication implements CommandLineRunner {

    @Autowired
    private ApplicationContext context;

    public static void main(String[] args) {
        SpringApplication.run(TestApplication.class, args);
    }

    public void run(String... args) {
        if (args.length == 0) {
            System.out.println("Please provide a bean name as a command-line argument.");
            return;
        }

        String beanName = args[0];

        if (!context.containsBean(beanName)) {
            System.out.println("No such bean found: " + beanName);
            return;
        }

        Lighter bean = context.getBean(beanName, Lighter.class);
        bean.doLight();
    }
}

//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.ApplicationContext;
//import java.io.IOException;

//@SpringBootApplication
//public class TestApplication {
//    @Autowired
//    private ApplicationContext context;
//    public static void main(String[] args) throws IOException {
//        String inputFile = "input.txt";
//        String outputFile = "output.txt";
//
//        HashFileProcessor processor = new HashFileProcessor(inputFile, outputFile);
//        try {
//            processor.hashInputFile();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        // здесь выполняем какие-то действия с результатом хеширования,
//        // сохраненным в выходном файле
//
//        processor.deleteInputFile();
//    }
//}
//
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.ConfigurableApplicationContext;
//
//@SpringBootApplication
//public class    TestApplication {
//    public static void main(String[] args) {
//        ConfigurableApplicationContext context = SpringApplication.run(TestApplication.class, args);
//        StudentProperties studentProperties = context.getBean(StudentProperties.class);
//        studentProperties.printProperties();
//        context.close();
//    }
//}
