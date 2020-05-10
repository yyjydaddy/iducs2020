package iducs.spring.blog2012000.repository;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import iducs.spring.blog2012000.domain.Blog;

public class BlogRepositoryImpl implements BlogRepository {
	
	private JdbcTemplate jdbcTemplate;
	
	public BlogRepositoryImpl(SimpleDriverDataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public int create(Blog blog) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Blog read(Blog blog) {
		// TODO Auto-generated method stub
		String sql = "select * from blog where id=?";
		Object[] id = new Object[] {blog.getId()};
		Blog b = jdbcTemplate.queryForObject(sql, id, new BeanPropertyRowMapper<Blog>(Blog.class));
		return b;
	}

	@Override
	public List<Blog> readList() {
		// TODO Auto-generated method stub
		String sql = "select * from blog order by id desc";

		List<Blog> blogList = 
        		jdbcTemplate.query(sql, new BeanPropertyRowMapper<Blog>(Blog.class));
        return blogList;
	}

	@Override
	public int update(Blog blog) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Blog blog) {
		// TODO Auto-generated method stub
		return 0;
	}

}
