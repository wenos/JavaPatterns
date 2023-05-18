package com.example.demo15;

import com.example.demo15.departure.Departure;
import com.example.demo15.departure.DepartureRepository;
import com.example.demo15.departure.DepartureService;
import com.example.demo15.email.EmailService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class DepartureServiceTest {
    @Mock
    private DepartureRepository departureRepository;
    @Mock
    private EmailService emailService;
    @InjectMocks
    private DepartureService departureService;

    @BeforeEach
    void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSave() {
        // Arrange
        Departure departure = new Departure();
        departure.setType("Type1");
        when(departureRepository.save(departure)).thenReturn(departure);

        // Act
        Departure savedDeparture = departureService.save(departure);

        // Assert
        assertEquals(departure, savedDeparture);
        verify(departureRepository).save(departure);
        verify(emailService).sendEmail("ramalguseynov03@gmail.com", "New PostOffice Saved", "A new departure has been saved: " + departure.getType());
    }

//    @Test
//    public void testSave_nullDeparture() {
//        // Arrange
//        Departure departure = null;
//
//        // Act
//        Departure savedDeparture = departureService.save(departure);
//
//        // Assert
//        assertEquals(null, savedDeparture);
//        verify(departureRepository, never()).save(departure);
//        verify(emailService, never()).sendEmail(anyString(), anyString(), anyString());
//    }
}
