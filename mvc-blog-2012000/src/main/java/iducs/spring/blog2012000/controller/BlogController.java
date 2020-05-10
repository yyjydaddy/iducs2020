package iducs.spring.blog2012000.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import iducs.spring.blog2012000.domain.Blog;
import iducs.spring.blog2012000.service.BlogService;

@Controller
public class BlogController {
	private BlogService blogService;
	public BlogController(BlogService blogService)  { // 생성자를 활용한 주입
		this.blogService = blogService;
	}
	
    @GetMapping("/blogs/all")
    public String getBlogs(Model model) {    
    	List<Blog> blogList = blogService.getBlogs();
    	model.addAttribute("blogList", blogList);
        return "/blogs/get-blogs";
    }    
    @GetMapping("/blogs/{id}")
    public String getBlog(@PathVariable("id") Long id, Model model) {    	
        model.addAttribute("blog", blogService.getBlog(id));
        return "/blogs/get-blog";
    }
    @PostMapping("/blogs")
    public String postBlog(Blog blog, Model model) {  
    	System.out.println(blog.toString());
    	/*
    	int rows = blogService.postBlog(blog);
        model.addAttribute("rows", rows);
        */
        return "redirect:/blogs/all";
    }
    @GetMapping("/blogs/new")
    public String newBlog(Model model) {
        return "/blogs/new-form";
    }
    @PutMapping("/blogs/{id}")
    public String updateBlog(@PathVariable("id") Long id, Model model) {
        model.addAttribute("blog", id);
        return "redirect:/blogs/all";
    }
    @GetMapping("/blogs/{id}/edit")
    public String editBlog(Model model) {
        return "/blogs/edit-form";
    }
    @DeleteMapping("/blogs/{id}/del")
    public String deleteBlog(@RequestParam long id, Model model) {
    	int rows = blogService.deleteBlog(id);
        model.addAttribute("rows", rows);
        return "greeting";
    }
}
