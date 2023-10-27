package kz.bitlab.javaspringsprint2.service.impl;

import kz.bitlab.javaspringsprint2.dto.ApplicationRequestDto;
import kz.bitlab.javaspringsprint2.model.ApplicationRequest;
import kz.bitlab.javaspringsprint2.repository.ApplicationRequestRepository;
import kz.bitlab.javaspringsprint2.service.ApplicationRequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ApplicationRequestServiceImpl implements ApplicationRequestService {

    private final ApplicationRequestRepository requestRepository;

    @Override
    public void addNewRequest(String userName, String courseName, String commentary, String phone) {
        requestRepository.save(
                new ApplicationRequest(
                        null,
                        userName,
                        courseName,
                        commentary,
                        phone,
                       false
                )
        );
    }

    @Override
    public List<ApplicationRequestDto> getAllRequest() {
        return requestRepository.findAll().stream().map(ApplicationRequest::toDto).toList();
    }

    @Override
    public List<ApplicationRequestDto> getAllRequestByHandled(boolean handled) {
        return requestRepository.findAllByHandled(handled).stream().map(ApplicationRequest::toDto).toList();
    }

    @Override
    public ApplicationRequestDto getById(Long id) {
        return requestRepository.findById(id).orElseThrow().toDto();
    }

    @Override
    public void updateRequest(Long id, boolean handled) {
        ApplicationRequest model = requestRepository.findById(id).orElseThrow();
        model.setHandled(handled);

        requestRepository.save(model);
    }

    @Override
    public void deleteRequest(Long id) {
        requestRepository.deleteById(id);
    }

}
