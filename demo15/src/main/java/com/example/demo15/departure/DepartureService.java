package com.example.demo15.departure;

import com.example.demo15.email.EmailService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class DepartureService {
    private static final Logger LOGGER = LoggerFactory.getLogger(DepartureService.class);

    @Autowired
    private EmailService emailService;
    @Autowired
    DepartureRepository departureRepository;
    @PersistenceContext
    private EntityManager entityManager;

    public List<Departure> filterDepartures(String type, String departureDate) {
        LOGGER.info("This is a filterDeparture");
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Departure> criteriaQuery = builder.createQuery(Departure.class);
        Root<Departure> root = criteriaQuery.from(Departure.class);

        criteriaQuery.select(root);

        // Фильтрация по типу
        if (type != null && !type.isEmpty()) {
            criteriaQuery.where(builder.equal(root.get("type"), type));
        }

        // Фильтрация по дате отправки
        if (departureDate != null && !departureDate.isEmpty()) {
            criteriaQuery.where(builder.equal(root.get("departureDate"), departureDate));
        }

        TypedQuery<Departure> query = entityManager.createQuery(criteriaQuery);
        return query.getResultList();
    }

    //    public Departure save(Departure departure) {
//        LOGGER.info("This is a Departure save");
//        emailService.sendEmail("ramalguseynov03@gmail.com", "New PostOffice Saved", "A new departure has been saved: " + departure.getType());
//        return departureRepository.save(departure);
//    }
    public Departure save(Departure departure) {
        LOGGER.info("This is a Departure save");
        if (departure != null) {
            emailService.sendEmail("ramalguseynov03@gmail.com", "New PostOffice Saved", "A new departure has been saved: " + departure.getType());
            return departureRepository.save(departure);
        } else {
            emailService.sendEmail("ramalguseynov03@gmail.com", "New PostOffice Saved", "A new departure has been saved: null");

            LOGGER.warn("Attempted to save null Departure object");
            return null;
        }
    }

    public Departure findById(Long id) {
        LOGGER.info("This is a Departure findById");

        return departureRepository.findById(id).orElse(null);
    }

    public void deleteById(Long id) {
        LOGGER.info("This is a Departure deleteById");
        departureRepository.deleteById(id);
    }

    public List<Departure> findAll() {
        LOGGER.info("This is a Departure findAll");
        return departureRepository.findAll();
    }

}
