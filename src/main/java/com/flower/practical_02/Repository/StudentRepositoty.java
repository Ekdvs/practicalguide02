package com.flower.practical_02.Repository;

import com.flower.practical_02.Model.Student;
import org.apache.catalina.startup.ClassLoaderFactory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepositoty extends JpaRepository<Student, Long> {
}
