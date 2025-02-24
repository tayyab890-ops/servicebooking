package com.company.jobapplication.controller;
import com.company.jobapplication.model.JobApplication;
import com.company.jobapplication.service.JobApplicationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;
@RestController
@RequestMapping("/api/job-applications")
public class JobApplicationController {
    private final JobApplicationService service;
    public JobApplicationController(JobApplicationService service) {
        this.service = service;}
    @PostMapping("/upload")
    public ResponseEntity<JobApplication> uploadJobApplication(
            @RequestParam("applicantName") String applicantName,
            @RequestParam("file") MultipartFile file) {
        try {
            JobApplication application = service.uploadApplication(applicantName, file);
            return ResponseEntity.ok(application);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }}
    @GetMapping
    public List<JobApplication> getAllApplications() {
        return service.getAllApplications();}
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteApplication(@PathVariable Long id) {
        service.deleteApplication(id);
        return ResponseEntity.ok("Application deleted successfully");}
}
