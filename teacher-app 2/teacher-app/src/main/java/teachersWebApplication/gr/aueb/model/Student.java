package teachersWebApplication.gr.aueb.model;

import lombok.*;

import javax.persistence.*;

    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Setter
    @ToString
    @EqualsAndHashCode
    @Entity
    @Table(name = "students")
    public class Student extends BaseEntity{

        @ManyToOne(fetch = FetchType.LAZY, optional = false)
        @JoinColumn(name = "teacher_id", nullable = false)
        private Teacher teacher;


    }
