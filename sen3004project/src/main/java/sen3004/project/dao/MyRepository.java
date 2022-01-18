package sen3004.project.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import sen3004.project.model.Post;
import sen3004.project.service.IPost;

@Repository
public class MyRepository implements IPost {

	@PersistenceContext
	private EntityManager entityManager;
	
	public List<Post> findAll(){
		return entityManager.createQuery("from Post", Post.class).getResultList();
	}
	
	public Post findById(long id){
		return entityManager.find(Post.class, id);
	}

	public void update(Post post) { entityManager.refresh(post); }

	@Override
	public void create(Post post) {
		entityManager.persist(post);
	}

	@Override
	public void delete(long id) {
		entityManager.remove(entityManager.getReference(Post.class, id));
	} 
}
