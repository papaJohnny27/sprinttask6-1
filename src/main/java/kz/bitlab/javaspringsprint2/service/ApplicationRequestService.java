package kz.bitlab.javaspringsprint2.service;

import kz.bitlab.javaspringsprint2.dto.ApplicationRequestDto;

import java.util.List;

public interface ApplicationRequestService {

    void addNewRequest(String userName,String courseName,String commentary,String phone);

    List<ApplicationRequestDto> getAllRequest();

    List<ApplicationRequestDto> getAllRequestByHandled(boolean handled);

    ApplicationRequestDto getById(Long id);

    void updateRequest(Long id, boolean handled);

    void deleteRequest(Long id);
}
