package com.example.demo15.postoffice;

import com.example.demo15.departure.Departure;
import com.example.demo15.departure.DepartureRepository;
import com.example.demo15.departure.DepartureService;
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
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class PostOfficeService {
    private static final Logger LOGGER = LoggerFactory.getLogger(PostOfficeService.class);

    @Autowired
    PostOfficeRepository postOfficeRepository;
    @Autowired
    DepartureRepository departureRepository;
    @Autowired
    EmailService emailService;

    @PersistenceContext
    private EntityManager entityManager;

    public List<PostOffice> filterPostOffices(String name, String cityName) {
        LOGGER.info("This is a filterPostOffices");
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<PostOffice> criteriaQuery = builder.createQuery(PostOffice.class);
        Root<PostOffice> root = criteriaQuery.from(PostOffice.class);

        criteriaQuery.select(root);

        if (name != null && !name.isEmpty()) {
            criteriaQuery.where(builder.equal(root.get("name"), name));
        }

        if (cityName != null && !cityName.isEmpty()) {
            criteriaQuery.where(builder.equal(root.get("cityName"), cityName));
        }

        TypedQuery<PostOffice> query = entityManager.createQuery(criteriaQuery);
        return query.getResultList();
    }

    public ResponseEntity<PostOffice> save(Long departureId, PostOffice postOffice) {
        LOGGER.info("This is a PostOffice save");

        Optional<Departure> optionalDeparture = departureRepository.findById(departureId);
        if (optionalDeparture.isPresent()) {
            optionalDeparture.get().getPostOffice().add(postOffice);
            emailService.sendEmail("ramalguseynov03@gmail.com", "New Departure Saved", "A new post-office has been saved: " + postOffice.getName());
            return ResponseEntity.ok(postOfficeRepository.save(postOffice));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public PostOffice findById(Long id) {
        LOGGER.info("This is a PostOffice findById");
        return postOfficeRepository.findById(id).orElse(null);

    }


    public void deleteById(Long id) {
        LOGGER.info("This is a PostOffice deleteById");
        postOfficeRepository.deleteById(id);
    }

    public List<PostOffice> findAll() {
        LOGGER.info("This is a PostOffice findAll");
        return postOfficeRepository.findAll();
    }

}
