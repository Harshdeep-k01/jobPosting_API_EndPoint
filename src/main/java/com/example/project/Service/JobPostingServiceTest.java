package com.example.project.Service;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.repository.Repository;

import com.example.project.Entity.JobPosting;
import com.example.project.Repository.JobPostingRepository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class JobPostingServiceTest {

    @Mock
    private JobPostingRepository repository;

    @InjectMocks
    private JobPostingService service;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllJobPostings() {
        List<JobPosting> mockPostings = Arrays.asList(new JobPosting(), new JobPosting());
        when(Repository.findAll()).thenReturn(mockPostings);

        List<JobPosting> result = service.getAllJobPostings();

        assertEquals(2, result.size());
        verify(repository, times(1)).findAll();
    }

    @Test
    void testGetJobPostingById() {
        JobPosting mockPosting = new JobPosting();
        when(Repository.findById(1L)).thenReturn(Optional.of(mockPosting));

        Optional<JobPosting> result = service.getJobPostingById(1L);

        assertTrue(result.isPresent());
        verify(repository, times(1)).findById(1L);
    }

    // Add more tests for other methods
}