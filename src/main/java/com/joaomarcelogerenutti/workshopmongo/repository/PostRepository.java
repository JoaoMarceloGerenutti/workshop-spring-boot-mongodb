package com.joaomarcelogerenutti.workshopmongo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.joaomarcelogerenutti.workshopmongo.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

	// Learning-only method.
	@Query("{ 'title': { $regex: ?0, $options: 'i' } }")
	List<Post> searchByTitle(String text);
	
	List<Post> findByTitleContainingIgnoreCase(String text);
}
