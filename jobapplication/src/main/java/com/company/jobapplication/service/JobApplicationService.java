package com.company.jobapplication.service;
import com.company.jobapplication.model.JobApplication;
import com.company.jobapplication.repository.JobApplicationRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.util.Date;
import java.util.List;
import java.util.Optional;
@Service
public class JobApplicationService {
    private final JobApplicationRepository repository;
    public JobApplicationService(JobApplicationRepository repository) {
        this.repository = repository;
    }
    public JobApplication uploadApplication(String applicantName, MultipartFile file) throws Exception {
        JobApplication application = new JobApplication();
        application.setApplicantName(applicantName);
        application.setFileName(file.getOriginalFilename());
        application.setFileType(file.getContentType());
        application.setUploadDate(new Date());
        application.setFileData(file.getBytes());
        return repository.save(application);
    }
    public List<JobApplication> getAllApplications() {
        return repository.findAll();
    }
    public void deleteApplication(Long id) {
        repository.deleteById(id);
    }
}
