package kz.bitlab.javaspringsprint2.controller;

import kz.bitlab.javaspringsprint2.dto.ApplicationRequestDto;
import kz.bitlab.javaspringsprint2.service.ApplicationRequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/application-request")
@RequiredArgsConstructor
public class ApplicationRequestController {

    private final ApplicationRequestService applicationRequestService;

    @GetMapping
    public String getAllApplicationRequests(Model model,
                                            @RequestParam(name = "handled_flag",required = false) Boolean handled
                                            ){
        List<ApplicationRequestDto> allRequest;
        if(handled!=null){
            allRequest = applicationRequestService.getAllRequestByHandled(handled);
        }else {
            allRequest = applicationRequestService.getAllRequest();
        }

        model.addAttribute("application_requests",allRequest);

        return "index";
    }

    @PostMapping
    public String addNewApplicationRequest(
            @RequestParam("application_request_user_name") String userName,
            @RequestParam("request_course_name") String courseName,
            @RequestParam("request_commentary") String commentary,
            @RequestParam("request_phone") String phone
    ){
        applicationRequestService.addNewRequest(userName,courseName,commentary,phone);
        return "redirect:/application-request";
    }

    @GetMapping("/{id}")
    public String getApplicationRequestDetails(
            @PathVariable("id") Long id,
            Model model
    ){
        ApplicationRequestDto applicationRequestDto = applicationRequestService.getById(id);
        model.addAttribute("application_request",applicationRequestDto);

        return "details";
    }

    @PostMapping("/{id}/update")
    public String updateApplicationRequest(
            @PathVariable("id") Long id
    ) {
        applicationRequestService.updateRequest(id, true);
        return "redirect:/application-request/" + id;
    }

    @PostMapping("/{id}/delete")
    public String deleteApplicationRequest(
            @PathVariable("id") Long id
    ) {
        applicationRequestService.deleteRequest(id);
        return "redirect:/application-request";
    }
}
