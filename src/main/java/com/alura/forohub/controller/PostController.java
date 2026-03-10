package com.alura.forohub.controller;

import com.alura.forohub.entity.Post;
import com.alura.forohub.repository.PostRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {

    private final PostRepository postRepository;

    public PostController(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @GetMapping
    public List<Post> listarPosts() {
        return postRepository.findAll();
    }

    @PostMapping
    public Post crearPost(@RequestBody Post post) {
        return postRepository.save(post);
    }

    @GetMapping("/{id}")
    public Post obtenerPost(@PathVariable Long id) {
        return postRepository.findById(id).orElse(null);
    }

    @DeleteMapping("/{id}")
    public void eliminarPost(@PathVariable Long id) {
        postRepository.deleteById(id);
    }

    @PutMapping("/{id}")
    public Post actualizarPost(@PathVariable Long id, @RequestBody Post postActualizado) {
        return postRepository.findById(id)
                .map(post -> {
                    post.setTitulo(postActualizado.getTitulo());
                    post.setContenido(postActualizado.getContenido());
                    return postRepository.save(post);
                })
                .orElse(null);
    }
}
