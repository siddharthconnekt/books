package com.example.books.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.books.entity.Review;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {

}
