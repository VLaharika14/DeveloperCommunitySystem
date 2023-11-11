package com.dcs;

import static org.assertj.core.api.Assertions.assertThat;
import org.assertj.core.api.Assertions;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.dcs.dao.DeveloperDao;
import com.dcs.dao.PostDao;
import com.dcs.dto.DeveloperDTO;
import com.dcs.entity.Comment;
import com.dcs.entity.Developer;
import com.dcs.entity.Post;
import com.dcs.entity.Response;
import com.dcs.entity.Vote;
import com.dcs.service.IDeveloperService;
import com.dcs.util.VoteType;

@SpringBootTest
public class DeveloperServiceTest {
	 // @Test
//      void should_return_developer_list() {
//          Developer[] developer = restTemplate.getForObject("http://localhost:" + randomServerPort + "/api/employees", Employee[].class);
//          
//          assertEquals(6, developer.length);
//          assertEquals("Azhrioun", developer[0].getDevName());
//      }
	  @Autowired
		IDeveloperService developerService;
		
		@MockBean
		DeveloperDao developerDao;
		@MockBean
		PostDao postDao;
		@Autowired
		private ModelMapper modelMapper;
		static final List<Developer> ld1 = new ArrayList<Developer>();
		

		@Test
		void testGetAllDevelopers() {
			Developer d1=new Developer();
			d1.setUserId(1);
			d1.setDevName("Priyanka");
			d1.setDevSkill("Java");
			d1.setReputation(3);
			d1.setStatus("approved");
			Post p=new Post();
			p.setPostId(222);
			p.setQuery("what is java");
			LocalDateTime c=LocalDateTime.of(2022, 10, 12, 7, 7);
			p.setPostDateTime(c);
			p.setTopic("programming Lanaguage");
			p.setDeveloper(d1);
			Response r=new Response();
			r.setRespId(301);
			r.setAnswer("Its a programming lanaguage");
			LocalDateTime c1=LocalDateTime.of(2022, 10, 13, 12, 7);
			r.setRespDateTime(c1);
			r.setPost(p);
			r.setDeveloper(d1);
			Comment cc=new Comment();
			cc.setCommentId(401);
			cc.setText("good");
			cc.setCreatedBy(d1);
			LocalDate lc=LocalDate.of(2022, 11, 5);
			cc.setCreatedDate(lc);
			Vote v=new Vote();
			v.setVoteId(501);
			VoteType downVote=VoteType.DOWNVOTE;
			VoteType upVote=VoteType.UPVOTE;
			v.setVoteType(downVote);
			v.setDeveloperWhoVoted(d1);
			v.setComment(cc);
			v.setPost(p);
			v.setResponse(r);
			List<Vote>lv=new ArrayList<Vote>();
			lv.add(v);
			r.setVote(lv);
			List<Comment>lcc=new ArrayList<Comment>();
			lcc.add(cc);
			p.setListOfComment(lcc);
			p.setNoOfViews(100);
			p.setVote(lv);
			List<Post>lp=new ArrayList<Post>();
			d1.setListOfPosts(lp);
			List<Developer>ld=new ArrayList<Developer>();
			ld.add(d1);
			
			
			Mockito.when(developerDao.findAll()).thenReturn(ld);
			
			assertThat(developerService.getAllDevelopers().equals(ld));
			
		}
		@Test
		void testGetDeveloperById() {
			Developer d1=new Developer();
			d1.setUserId(1);
			d1.setDevName("Priyanka");
			d1.setDevSkill("Java");
			d1.setReputation(3);
			d1.setStatus("approved");
			Post p=new Post();
			p.setPostId(222);
			p.setQuery("what is java");
			LocalDateTime c=LocalDateTime.of(2022, 10, 12, 7, 7);
			p.setPostDateTime(c);
			p.setTopic("programming Lanaguage");
			p.setDeveloper(d1);
			Response r=new Response();
			r.setRespId(301);
			r.setAnswer("Its a programming lanaguage");
			LocalDateTime c1=LocalDateTime.of(2022, 10, 13, 12, 7);
			r.setRespDateTime(c1);
			r.setPost(p);
			r.setDeveloper(d1);
			Comment cc=new Comment();
			cc.setCommentId(401);
			cc.setText("good");
			cc.setCreatedBy(d1);
			LocalDate lc=LocalDate.of(2022, 11, 5);
			cc.setCreatedDate(lc);
			Vote v=new Vote();
			v.setVoteId(501);
			VoteType downVote=VoteType.DOWNVOTE;
			VoteType upVote=VoteType.UPVOTE;
			v.setVoteType(downVote);
			v.setDeveloperWhoVoted(d1);
			v.setComment(cc);
			v.setPost(p);
			v.setResponse(r);
			List<Vote>lv=new ArrayList<Vote>();
			lv.add(v);
			r.setVote(lv);
			List<Comment>lcc=new ArrayList<Comment>();
			lcc.add(cc);
			p.setListOfComment(lcc);
			p.setNoOfViews(100);
			p.setVote(lv);
			List<Post>lp=new ArrayList<Post>();
			d1.setListOfPosts(lp);
			List<Developer>ld=new ArrayList<Developer>();
			ld.add(d1);
			Optional<Developer> d2=Optional.of(d1);
			
			   Mockito.when(developerDao.findById(1)).thenReturn(d2);
			   assertThat(developerService.getDeveloperById(1)).isEqualTo(d2);
				}
		@Test
		void testAddDeveloper()
		{
			Developer d1=new Developer();
			d1.setUserId(1);
			d1.setDevName("Priyanka");
			d1.setDevSkill("Java");
			d1.setReputation(3);
			d1.setStatus("approved");
			Post p=new Post();
			p.setPostId(222);
			p.setQuery("what is java");
			LocalDateTime c=LocalDateTime.of(2022, 10, 12, 7, 7);
			p.setPostDateTime(c);
			p.setTopic("programming Lanaguage");
			p.setDeveloper(d1);
			Response r=new Response();
			r.setRespId(301);
			r.setAnswer("Its a programming lanaguage");
			LocalDateTime c1=LocalDateTime.of(2022, 10, 13, 12, 7);
			r.setRespDateTime(c1);
			r.setPost(p);
			r.setDeveloper(d1);
			Comment cc=new Comment();
			cc.setCommentId(401);
			cc.setText("good");
			cc.setCreatedBy(d1);
			LocalDate lc=LocalDate.of(2022, 11, 5);
			cc.setCreatedDate(lc);
			Vote v=new Vote();
			v.setVoteId(501);
			VoteType downVote=VoteType.DOWNVOTE;
			VoteType upVote=VoteType.UPVOTE;
			v.setVoteType(downVote);
			v.setDeveloperWhoVoted(d1);
			v.setComment(cc);
			v.setPost(p);
			v.setResponse(r);
			List<Vote>lv=new ArrayList<Vote>();
			lv.add(v);
			r.setVote(lv);
			List<Comment>lcc=new ArrayList<Comment>();
			lcc.add(cc);
			p.setListOfComment(lcc);
			p.setNoOfViews(100);
			p.setVote(lv);
			List<Post>lp=new ArrayList<Post>();
			d1.setListOfPosts(lp);
			List<Developer>ld=new ArrayList<Developer>();
			ld.add(d1);
			ld1.add(d1);
			Mockito.when(developerDao.saveAll(ld1)).thenReturn(ld);
	DeveloperDTO dt= modelMapper.map(d1, DeveloperDTO.class);

			
			assertThat(developerService.addDeveloper(dt)).isEqualTo(dt);
		}
		@Test
		void testUpdateDeveloper() {
			Developer d1=new Developer();
			d1.setUserId(1);
			d1.setDevName("Priyanka");
			d1.setDevSkill("Java");
			d1.setReputation(3);
			d1.setStatus("approved");
			Post p=new Post();
			p.setPostId(222);
			p.setQuery("what is java");
			LocalDateTime c=LocalDateTime.of(2022, 10, 12, 7, 7);
			p.setPostDateTime(c);
			p.setTopic("programming Lanaguage");
			p.setDeveloper(d1);
			Response r=new Response();
			r.setRespId(301);
			r.setAnswer("Its a programming lanaguage");
			LocalDateTime c1=LocalDateTime.of(2022, 10, 13, 12, 7);
			r.setRespDateTime(c1);
			r.setPost(p);
			r.setDeveloper(d1);
			Comment cc=new Comment();
			cc.setCommentId(401);
			cc.setText("good");
			cc.setCreatedBy(d1);
			LocalDate lc=LocalDate.of(2022, 11, 5);
			cc.setCreatedDate(lc);
			Vote v=new Vote();
			v.setVoteId(501);
			VoteType downVote=VoteType.DOWNVOTE;
			VoteType upVote=VoteType.UPVOTE;
			v.setVoteType(downVote);
			v.setDeveloperWhoVoted(d1);
			v.setComment(cc);
			v.setPost(p);
			v.setResponse(r);
			List<Vote>lv=new ArrayList<Vote>();
			lv.add(v);
			r.setVote(lv);
			List<Comment>lcc=new ArrayList<Comment>();
			lcc.add(cc);
			p.setListOfComment(lcc);
			p.setNoOfViews(100);
			p.setVote(lv);
			List<Post>lp=new ArrayList<Post>();
			d1.setListOfPosts(lp);
			List<Developer>ld=new ArrayList<Developer>();
			ld.add(d1);
			Optional<Developer> d2=Optional.of(d1);
			
			Mockito.when(developerDao.findById(4)).thenReturn(d2);
			d1.setDevName("Laharika");
	 
			Mockito.when(developerDao.save(d1)).thenReturn(d1);
			DeveloperDTO dt= modelMapper.map(d1, DeveloperDTO.class);

	  
			assertThat(developerService.updateDeveloper(dt)).isEqualTo(dt);
			
		}
		@Test
		void testGetPostByDeveloper() {
			Developer d1=new Developer();
			d1.setUserId(1);
			d1.setDevName("Priyanka");
			d1.setDevSkill("Java");
			d1.setReputation(3);
			d1.setStatus("approved");
			Post p=new Post();
			p.setPostId(222);
			p.setQuery("what is java");
			LocalDateTime c=LocalDateTime.of(2022, 10, 12, 7, 7);
			p.setPostDateTime(c);
			p.setTopic("programming Lanaguage");
			p.setDeveloper(d1);
			Response r=new Response();
			r.setRespId(301);
			r.setAnswer("Its a programming lanaguage");
			LocalDateTime c1=LocalDateTime.of(2022, 10, 13, 12, 7);
			r.setRespDateTime(c1);
			r.setPost(p);
			r.setDeveloper(d1);
			Comment cc=new Comment();
			cc.setCommentId(401);
			cc.setText("good");
			cc.setCreatedBy(d1);
			LocalDate lc=LocalDate.of(2022, 11, 5);
			cc.setCreatedDate(lc);
			Vote v=new Vote();
			v.setVoteId(501);
			VoteType downVote=VoteType.DOWNVOTE;
			VoteType upVote=VoteType.UPVOTE;
			v.setVoteType(downVote);
			v.setDeveloperWhoVoted(d1);
			v.setComment(cc);
			v.setPost(p);
			v.setResponse(r);
			List<Vote>lv=new ArrayList<Vote>();
			lv.add(v);
			r.setVote(lv);
			List<Comment>lcc=new ArrayList<Comment>();
			lcc.add(cc);
			p.setListOfComment(lcc);
			p.setNoOfViews(100);
			p.setVote(lv);
			List<Post>lp=new ArrayList<Post>();
			d1.setListOfPosts(lp);
			List<Developer>ld=new ArrayList<Developer>();
			//Optional<List<Post>> d2=Optional.ofNullable(d1.getListOfPosts());
			Optional<Post>ll=Optional.of(p);
			ld.add(d1);
			Mockito.when(postDao.findById(1)).thenReturn(ll);
			   assertThat(developerService.getDeveloperById(1)).isEqualTo(lp);
			
			
			
		}
		@Test
		void testGetByMaxReputation() {
			Developer d1=new Developer();
			d1.setUserId(1);
			d1.setDevName("Priyanka");
			d1.setDevSkill("Java");
			d1.setReputation(3);
			d1.setStatus("approved");
			Post p=new Post();
			p.setPostId(222);
			p.setQuery("what is java");
			LocalDateTime c=LocalDateTime.of(2022, 10, 12, 7, 7);
			p.setPostDateTime(c);
			p.setTopic("programming Lanaguage");
			p.setDeveloper(d1);
			Response r=new Response();
			r.setRespId(301);
			r.setAnswer("Its a programming lanaguage");
			LocalDateTime c1=LocalDateTime.of(2022, 10, 13, 12, 7);
			r.setRespDateTime(c1);
			r.setPost(p);
			r.setDeveloper(d1);
			Comment cc=new Comment();
			cc.setCommentId(401);
			cc.setText("good");
			cc.setCreatedBy(d1);
			LocalDate lc=LocalDate.of(2022, 11, 5);
			cc.setCreatedDate(lc);
			Vote v=new Vote();
			v.setVoteId(501);
			VoteType downVote=VoteType.DOWNVOTE;
			VoteType upVote=VoteType.UPVOTE;
			v.setVoteType(downVote);
			v.setDeveloperWhoVoted(d1);
			v.setComment(cc);
			v.setPost(p);
			v.setResponse(r);
			List<Vote>lv=new ArrayList<Vote>();
			lv.add(v);
			r.setVote(lv);
			List<Comment>lcc=new ArrayList<Comment>();
			lcc.add(cc);
			p.setListOfComment(lcc);
			p.setNoOfViews(100);
			p.setVote(lv);
			List<Post>lp=new ArrayList<Post>();
			d1.setListOfPosts(lp);
			List<Developer>ld=new ArrayList<Developer>();
			//Optional<List<Post>> d2=Optional.ofNullable(d1.getListOfPosts());
			Optional<Developer>ll=Optional.of(d1);
			ld.add(d1);
			Mockito.when(developerDao.findById(1)).thenReturn(ll);
			   assertThat(developerService.getDeveloperById(1)).isEqualTo(d1.getReputation());
			
			
		}
			
		}



