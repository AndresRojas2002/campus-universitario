package co.com.andres.campus_universitario.service;

import java.util.List;

import co.com.andres.campus_universitario.model.Dto.EnrollmentsRequest;
import co.com.andres.campus_universitario.model.Dto.EnrollmentsResponse;

public interface EnrollmentsService {

    EnrollmentsResponse createEnrollments(EnrollmentsRequest enrollmentsRequest);

    List<EnrollmentsResponse> getAllEnrollments();

    EnrollmentsResponse getByIdEnrollments(Long id);

    void deleteEnrollments(Long id );

    void cancelledEnrollments(Long id); 




}
