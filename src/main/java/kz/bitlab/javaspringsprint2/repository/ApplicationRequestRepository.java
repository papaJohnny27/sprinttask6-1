package kz.bitlab.javaspringsprint2.repository;

import kz.bitlab.javaspringsprint2.model.ApplicationRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface
ApplicationRequestRepository extends JpaRepository<ApplicationRequest,Long> {

    List<ApplicationRequest> findAllByHandled(boolean handled);//select * from application_request where handled =?
}
