package sen3004.project.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import sen3004.project.model.Post;

@Component
public class CustomValidator implements Validator {
    @Override
    public boolean supports(Class<?> myc) {
        return Post.class.equals(myc);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Post post = (Post) o;
        if(post.getMsg().contains("Emray")) {
            errors.rejectValue("message",null,"Message cannot contains word 'Emray'");
        }
    }
}
