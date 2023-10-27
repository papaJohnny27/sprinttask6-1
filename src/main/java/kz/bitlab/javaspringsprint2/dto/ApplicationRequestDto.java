package kz.bitlab.javaspringsprint2.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class ApplicationRequestDto implements Serializable {
    private Long id;
    private String userName;
    private String courseName;
    private String commentary;
    private String phone;
    private boolean handled;

    public boolean isApplicationUnhandled() {
        return !handled;
    }
}
