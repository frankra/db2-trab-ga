package tests;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.group.Group;
import com.group.GroupDao;
import com.group.member.Member;
import com.group.member.MemberDao;
import com.user.User;
import com.user.UserDao;

@Controller
public class UserToGroupTest {
	
	@Autowired
	private UserDao userDao;
	private List<User> users = new ArrayList<User>();
	@Autowired
	private MemberDao memberDao;
	private List<Member> members = new ArrayList<Member>();;
	@Autowired 
	private GroupDao groupDao;
	private List<Group> groups = new ArrayList<Group>();;
	
	
	@RequestMapping("/startTests")
	public void startTests(){
		System.out.println("Starting Test.");
		createTestUsers();
		System.out.println("Users Created.");
		createTestGroups();
		System.out.println("Groups Created.");
		assignUsersToGroup();
		System.out.println("Users assigned to Groups");
		System.out.println("Test finished.");
	}


	private void createTestUsers(){
		User user;
		for(int i=0 ; i<10; i++){
			String name = "name"+i;
			String login = "user"+i;
			String pwd = "pwd"+i;
			
			user = new User(name,login,pwd);
			users.add(user);
			userDao.persist(user);
		}
	};
	
	private void createTestGroups(){
		Group group;
		for(int i=0 ; i<5; i++){
			String name = "name"+i;
			
			
			group = new Group(name);
			groups.add(group);
			groupDao.persist(group);
		}
	};
	
	private void assignUsersToGroup(){
		Member member;
		member = new Member(groups.get(0),users.get(0));
		memberDao.persist(member);
	};
	
	
}
