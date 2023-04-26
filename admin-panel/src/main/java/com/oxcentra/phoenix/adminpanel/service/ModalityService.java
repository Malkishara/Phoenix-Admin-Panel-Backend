package com.oxcentra.phoenix.adminpanel.service;

import com.oxcentra.phoenix.adminpanel.dto.JobModality;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ModalityService {
    List<JobModality> getAllJobModalities();
}
