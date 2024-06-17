import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/courses")
public class coursesController {
    
    private List<Course> courses = new ArrayList<>();

    @GetMapping
    public List<Course> getCourses() {
        return courses;
    }

    @GetMapping("/{id}")
    public Course getCourseById(int id) {
        Optional<Course> course = courses.stream().filter(x -> x.getId() == id).findFirst();
        return course.orElse(null);
    }

   
}
