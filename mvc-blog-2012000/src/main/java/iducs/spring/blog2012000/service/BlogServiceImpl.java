package iducs.spring.blog2012000.service;

import java.util.List;

import iducs.spring.blog2012000.domain.Blog;
import iducs.spring.blog2012000.repository.BlogRepositoryImpl;

public class BlogServiceImpl implements BlogService {
	private BlogRepositoryImpl blogRepository;
	
	public BlogServiceImpl(BlogRepositoryImpl blogRepository) {
		this.blogRepository = blogRepository;
	}
	
	@Override
	public Blog getBlog(long id) {
		Blog blog = new Blog();
		blog.setId(id);		
		return blogRepository.read(blog);
	}

	@Override
	public List<Blog> getBlogs() {
		// TODO Auto-generated method stub
		return blogRepository.readList();
	}

	@Override
	public List<Blog> getBlogsByTitle(String title) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Blog> getBlogByBlogger(String blogger) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Blog> getBlogByPage(int index, int size) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int postBlog(Blog blog) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateBlog(Blog blog) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteBlog(long id) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
}
