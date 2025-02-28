package by.iskander;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Component
public class GitInfo {

    @Value("${git.commit.message.short}")
    private String commitMessage;

    @Value("${git.branch}")
    private String branch;

    @Value("${git.commit.id}")
    private String commitId;
}
