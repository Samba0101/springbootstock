package com.projet.pStock.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projet.pStock.exception.ResourceNotFoundException;
import com.projet.pStock.model.Article;
import com.projet.pStock.repositorie.ArticleRepositorie;



@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class ArticleController {

	 @Autowired
	 ArticleRepositorie repositorie;
	
	@GetMapping("/articles")
	public List<Article> getALLarticle(){
		List<Article> article=new ArrayList<Article>();
		repositorie.findAll().forEach(article ::add);
		return article;
	}
	@DeleteMapping("/articles/{id}")
	public ResponseEntity<Article> getArticleById(@PathVariable(value="id") long articleId) throws ResourceNotFoundException{
		Article article=repositorie.findById(articleId).orElseThrow(()-> new ResourceNotFoundException("Article not fount"));
		return ResponseEntity.ok().body(article);
	}
	@PostMapping("/articles")
	public Article createArticle(@Validated @RequestBody Article article) {
		return repositorie.save(article);
	}
	/*@DeleteMapping("/articles/{id}")
	public Map<String,Boolean> deleteArticle(@PathVariable(value="id") long articleId)throws
	ResourceNotFoundException {
		Article article= repositorie.findById(articleId).orElseThrow(()-> new ResourceNotFoundException("Article n'on trouvé "+ articleId));
		repositorie.delete(article);
		Map<String,Boolean> response=new HashMap<>();
		response.put("deleted",Boolean.TRUE);
		return response;
	}*/
	@DeleteMapping("/articles/delete")
	public ResponseEntity<String> deleteAllArticles(){
		repositorie.deleteAll();
		
		return new ResponseEntity<String>("Tous les articles sont supprimés",HttpStatus.OK);
	}
	@PutMapping("Articles/{id}")
	public ResponseEntity<Article> updateArticle(@PathVariable("id") long id,@RequestBody Article Article){
		
	
	Optional<Article> articleInfo=repositorie.findById(id);
	if(articleInfo.isPresent()) {
		Article article=articleInfo.get();
		article.setCode(Article.getCode());
		article.setLibelle(Article.getLibelle());
		article.setId_cat(Article.getId_cat());
		article.setFodec(Article.getFodec());
		article.setId_souscat(Article.getId_souscat());
		article.setImage(Article.getImage());
		article.setPa(Article.getPa());
		article.setPv(Article.getPv());
		article.setStkinit(Article.getStkinit());
		article.setStock(Article.getStock());
		article.setTva(Article.getTva());
	
		
		return new ResponseEntity<>(repositorie.save(Article), HttpStatus.OK);
	}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
			
	}

	
	public void exportToPDF(HttpServletResponse response ) {
		response.setContentType("application/pdf");
		String HeaderKey="Content-Disposition";
		String HearderValue="attachment; filename=user.pdf";
		
		response.setHeader(HeaderKey, HearderValue);
		
	}
	
	
	
	
}
