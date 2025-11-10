package com.ecommerce.project.repositories;

import com.ecommerce.project.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Category findByCategoryName(String categoryName);
}

//public interface CategoryRepository extends CrudRepository<Category, Long> {
//}

//there is an option of crudRepository(as above). but JpaRepositroy extends crudrepository but offer broad other
// function.
