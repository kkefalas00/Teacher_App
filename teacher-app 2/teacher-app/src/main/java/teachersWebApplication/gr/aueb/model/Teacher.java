package teachersWebApplication.gr.aueb.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;


    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Setter
    @EqualsAndHashCode
    @Entity
    @Table(name = "teachers")
    public class Teacher extends BaseEntity {

        @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "teacher")
        private List<Student> students;

        @Override
        public String toString() {
            return "Teacher{" + '}';
        }
    }

