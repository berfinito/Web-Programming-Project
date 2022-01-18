package sen3004.project.service;

import java.util.List;

import sen3004.project.model.Post;

public interface IPost {
	public List<Post> findAll();

	public Post findById(long id);
	
	public void create(Post post);
	
	public void delete(long id);
}
