package com.example.project.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.project.Entity.JobPosting;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

@Repository
public interface JobPostingRepository extends JpaRepository<JobPosting, Long> {
    @Query("SELECT j FROM JobPosting j WHERE " +
           "LOWER(j.title) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
           "LOWER(j.description) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
           "LOWER(j.location) IN :locations OR " +
           "j.requiredSkills IN :skills")
    List<JobPosting> searchJobPostings(String keyword, List<String> locations, List<String> skills);
}