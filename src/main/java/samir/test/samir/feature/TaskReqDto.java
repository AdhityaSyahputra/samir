package samir.test.samir.feature;

import lombok.Data;
import samir.test.samir.feature.model.User;

@Data
public class TaskReqDto {
    private String title;
    private String description;
    private boolean completed;
}
