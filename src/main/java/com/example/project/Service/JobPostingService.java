package com.example.project.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.project.Entity.JobPosting;
import com.example.project.Repository.JobPostingRepository;

import java.util.List;
import java.util.Optional;

@Service
public class JobPostingService {

    @Autowired
    private JobPostingRepository repository;

    public List<JobPosting> getAllJobPostings() {
        return repository.findAll();
    }

    public Optional<JobPosting> getJobPostingById(Long id) {
        return repository.findById(id);
    }

    public JobPosting createJobPosting(JobPosting jobPosting) {
        return repository.save(jobPosting);
    }

    public JobPosting updateJobPosting(Long id, JobPosting jobPostingDetails) {
        Optional<JobPosting> jobPosting = repository.findById(id);
        if (jobPosting.isPresent()) {
            JobPosting existingJobPosting = jobPosting.get();
            existingJobPosting.setTitle(jobPostingDetails.getTitle());
            existingJobPosting.setDescription(jobPostingDetails.getDescription());
            existingJobPosting.setLocation(jobPostingDetails.getLocation());
            existingJobPosting.setCompany(jobPostingDetails.getCompany());
            existingJobPosting.setSalaryRange(jobPostingDetails.getSalaryRange());
            existingJobPosting.setRequiredSkills(jobPostingDetails.getRequiredSkills());
            existingJobPosting.setApplicationDeadline(jobPostingDetails.getApplicationDeadline());
            return repository.save(existingJobPosting);
        }
        return null;
    }

    public void deleteJobPosting(Long id) {
        repository.deleteById(id);
    }

    public List<JobPosting> searchJobPostings(String keyword, List<String> locations, List<String> skills) {
        return repository.searchJobPostings(keyword, locations, skills);
    }
}