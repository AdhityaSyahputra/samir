package samir.test.samir.feature;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import samir.test.samir.feature.model.User;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class IncompletedTaskRespDto {
    private String title;
    private String description;
    private boolean completed;
    private Long userId;
}
