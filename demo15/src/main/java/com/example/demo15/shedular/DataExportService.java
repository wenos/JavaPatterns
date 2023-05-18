package com.example.demo15.shedular;

import com.example.demo15.departure.Departure;
import com.example.demo15.departure.DepartureRepository;
import com.example.demo15.postoffice.PostOffice;
import com.example.demo15.postoffice.PostOfficeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.List;
@ManagedResource
@Service
public class DataExportService {

    @Autowired
    private DepartureRepository departureRepository;

    @Autowired
    private PostOfficeRepository postOfficeRepository;

    @Scheduled(fixedRate = 60000) // 30 минут
    public void exportData() throws IOException {
        // очистить директорию
        File exportDir = new File("data_export");
        if (!exportDir.exists()) {
            exportDir.mkdir();
        }
        for (File file : exportDir.listFiles()) {
            file.delete();
        }

        // создать файлы для каждой сущности и записать данные из базы данных в файлы
        List<Departure> departures = departureRepository.findAll();
        File departureFile = new File(exportDir, "my_entities.txt");
        PrintWriter departureWriter = new PrintWriter(new BufferedWriter(new FileWriter(departureFile)));
        for (Departure departure : departures) {
            departureWriter.println(departure.toString());
        }
        departureWriter.close();

        List<PostOffice> postOffices = postOfficeRepository.findAll();
        File postOfficeFile = new File(exportDir, "another_entities.txt");
        PrintWriter postOfficeWriter = new PrintWriter(new BufferedWriter(new FileWriter(postOfficeFile)));
        for (PostOffice postOffice : postOffices) {
            postOfficeWriter.println(postOffice.toString());
        }
        postOfficeWriter.close();
    }

    @ManagedOperation
    public void manualExportData() throws IOException {
        exportData();
    }

}
