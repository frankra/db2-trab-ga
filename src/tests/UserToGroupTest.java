package tests;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.group.Group;
import com.group.GroupDao;
import com.group.member.Member;
import com.group.member.MemberDao;
import com.list.ListDao;
import com.list.item.Item;
import com.list.item.ItemDao;
import com.user.User;
import com.user.UserDao;

@Controller
public class UserToGroupTest {
	
	@Autowired
	private UserDao userDao;
	private List<User> users = new ArrayList<User>();
	@Autowired
	private MemberDao memberDao;
	private List<Member> members = new ArrayList<Member>();
	@Autowired 
	private GroupDao groupDao;
	private List<Group> groups = new ArrayList<Group>();
	@Autowired
	private ListDao listDao;
	private List<List> lists = new ArrayList<List>();
	@Autowired
	private ItemDao itemDao;
	private List<Item> items = new ArrayList<Item>();

	
	public static void main(String a[]){
		new UserToGroupTest().startTests();
	}
	
	@RequestMapping("/startTests")
	public String startTests(){
		Timestamp StartedOn = new Timestamp(Calendar.getInstance().getTime().getTime());
		System.out.println("Starting Test.");
		createTestUsers();
		System.out.println("Users Created.");
		createTestGroups();
		System.out.println("Groups Created.");
		assignUsersToGroup();
		System.out.println("Users assigned to Groups.");
		createTestLists();
		System.out.println("Lists Created.");
		addItemsToList();
		System.out.println("Items added to list.");
	
		System.out.println("Starting Relationship Test.");
		for(String str :testUserToGroupRelationship()){
			System.out.println(str);
		}
		
		Timestamp FinishedOn = new Timestamp(Calendar.getInstance().getTime().getTime());
		String time = (FinishedOn.getTime() - StartedOn.getTime())+" ms";
		System.out.println("Test finished.");
		
		try{
			return "Test Passed! Executed in: "+time;
		}catch(Exception e){
			e.printStackTrace();
			return "err";
		}
		
	}


	private void createTestUsers(){
		User user;
		for(int i=0 ; i<10; i++){
			String name = "testUser"+i;
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
			String name = "testGroup"+i;
			group = new Group(name);
			groups.add(group);
			groupDao.persist(group);
		}
	};
	
	private void assignUsersToGroup(){
		Member member;
		member = new Member(groups.get(0),users.get(0));
		members.add(member);
		groups.get(0).addGroupMember(member);
		groupDao.persist(groups.get(0));

		member = new Member(groups.get(1),users.get(0));
		members.add(member);
		groups.get(0).addGroupMember(member);
		groupDao.persist(groups.get(1));
		
		member = new Member(groups.get(2),users.get(0));
		members.add(member);
		groups.get(0).addGroupMember(member);
		groupDao.persist(groups.get(2));

		member = new Member(groups.get(0),users.get(1));
		members.add(member);
		groups.get(0).addGroupMember(member);
		groupDao.persist(groups.get(0));
		
		member = new Member(groups.get(0),users.get(2));
		members.add(member);
		groups.get(0).addGroupMember(member);
		groupDao.persist(groups.get(0));
		
		member = new Member(groups.get(0),users.get(3));
		members.add(member);
		groups.get(0).addGroupMember(member);
		groupDao.persist(groups.get(0));

		
	};
	
	public com.list.List createTestLists(){
		com.list.List list;
		
		list = new com.list.List("To-dos",groups.get(0),members.get(0));
		groups.get(0).addGroupList(list);
		groupDao.persist(groups.get(0));
		
		return list;
		
	};
	
	public void addItemsToList(){
		List<com.list.List> groupLists = new ArrayList<com.list.List>(groupDao.retrieve(groups.get(0).getID()).getGroupLists());
		com.list.List list = groupLists.get(0); 
		Item item;
		
		for(int i=0 ; i<10;i++){
			item = new Item("Item "+i,list,list.getOwner());
			
			if(i>5){
				item.setDone(true);
			};
			
			list.addItem(item);
		}
		listDao.persist(list);
		
	};
	
	public List<String> testUserToGroupRelationship(){
		List<String> resultList = new ArrayList<String>();
		List<Member> memberByUserID = new ArrayList<Member>();
		User user;
		for(int i = 0; i< users.size(); i++){
			user = userDao.retrieve(users.get(i).getID());
			/**User is not persisted, then return.*/
			if(user == null){
				System.out.println("User with ID:"+users.get(i).getID()+" not persisted.");
				continue;
			}
			System.out.println("User with ID:"+user.getID()+" found.");
			memberByUserID = memberDao.getMemberByUserID(user.getID());
			
			if(memberByUserID == null){
				System.out.println("User does not belong to any group.");
			}
			System.out.println("User belongs to "+ memberByUserID.size()+" groups.");
			
			for(Member member: memberByUserID){
				Group group = member.getGroup();
				resultList.add("User: "+user.getFirstName()+" belongs to: "+group.getName()+" via MemberID: "+member.getID());
			}
			
		}
		
		return resultList;
		
	}
	
}
