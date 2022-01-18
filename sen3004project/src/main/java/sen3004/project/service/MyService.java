package sen3004.project.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sen3004.project.dao.MyRepository;
import sen3004.project.model.Post;

@Service
@Transactional
public class MyService implements IPost {

	@Autowired
	MyRepository repository;
	
	@Override
	public List<Post> findAll() {
		return repository.findAll();
	}

	@Override
	public Post findById(long id) {
		return repository.findById(id);
	}

	@Override
	public void create(Post post) {
		repository.create(post);
	}

	@Override
	public void delete(long id) {
		repository.delete(id);
		
	}
	
}
