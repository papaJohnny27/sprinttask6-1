package kz.bitlab.javaspringsprint2.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import kz.bitlab.javaspringsprint2.dto.ApplicationRequestDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "application_request")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class ApplicationRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_name", nullable = false)
    private String userName;

    @Column(name = "course_name", nullable = false)
    private String courseName;

    @Column(name = "commentary", nullable = false)
    private String commentary;

    @Column(name = "phone", nullable = false)
    private String phone;

    @Column(name = "is_handled", nullable = false)
    private boolean handled;

    public ApplicationRequestDto toDto(){
        return new ApplicationRequestDto(
                this.id,
                this.userName,
                this.courseName,
                this.commentary,
                this.phone,
                this.handled
        );
    }
}
