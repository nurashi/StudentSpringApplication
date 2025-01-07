package kz.nurashi.colourapplication.impl.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface StudentRepository extends CrudRepository<Student, Integer> {

    // Anotate
    @Query("SELECT stu FROM Student stu WHERE stu.email= ?1")
    Optional<Student> findByEmail(String email);
}
