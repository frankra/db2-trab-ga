
												


-----------------------------------------HomeGroup Project. (Frank@CodingDonuts)


Idea: Create Shared lists with shared tasks among members of a closed group.

Use case 1: Frank and his family use the HomeGroup App. On a beautiful day, Frank woken up and realized that he was needing a few things from the Super Market, such as Milk, Butter and... So he goes to the HomeGroup App, and add on the 'Home Tasks List' a few tasks like: 'Buy Milk' , 'Buy Butter', and flag these as can be done by ALL, so everyone in this group can take over this task and perform it.

Use case 2: Frank and his family use HomeGroup App. On a beautiful day, Frank's Dad received a letter from DAER saying that Frank should pay a traffic ticket, so Frank's Dad can choose on either create a new list, or use an existing one and then create a new task and assing Frank as responsible. This way, only Frank will have the possibility to finish this taks. Additionally, Frank's Dad can fill the 'Due Date' field with the deadline of the payment.





Technical information:


	1. Techonologies used:

		1.1. Back-end:

			1.1.a. Java - Spring MVC
			1.1.b. MysqlDB
			1.1.c. Maven
			
		1.2. Front-end: (Not yet included in this Project folder)

			1.2.a. NodeJS
			1.2.b. Grunt - (Build manager)
			1.2.c. Angular
			1.2.d. Bower - (Javascript Dependency manager)
			1.2.e. Karma-Protractor-Jasmine (Unit Tests/Live Tests/Scenario Tests)


	2. Methodology Used:
		* = Under evaluation

		2.1. Back-end:
			
			2.1.a. TDD*

		2.2. Front-end:

			2.2.a TDD*
			2.2.b BDD*

		2.3. Documentation:

			2.3.a. JSDoc/Javadocs (Comments on code)


	3. Infrastructure:

		3.a. Back-end developed and built by Eclipse using any Build Tool (Currently Maven)

		3.b. Front-end will be developed on Node.js using Grunt and Bower as builder and dependency manager, Karma and Jasmine for unit testing (runtime*)

		3.c. Once Front-end and Back-end development is done (or stable), commit Front-end changes to Back-end package (Eclipse project folder), using either Maven or Grunt (TBD)


			Pros:
			1- Completely separated front-end and back-end development environments, however, interaction among both is still enabled.
			2- Properly build tools for each piece of the application:
			   Back-end -> Maven
			   Front-end -> Node.js, Grunt and Bower

			Cons:
			1- Medium effort for infrastructure and built package on eclipse. (currently the only option is manually transport front-end development back to back-end project folder in order to be committed to HCP server.)-


		TODO: Find an easy and smart way of 'deploying' the front-end files to the back-end package. Maybe Manven or Grunt could do the job.


	4. Entities and Relationships:

		USER as User - User is the Unique entity to maintain a user(person) information.
		MEMBER as Member - Member is a 'relationship instance' of a User to something.
		MEMBER_GROUP as GroupMember or Group - Group is a collection of Members.
		LIST as List - List is a simple list of tasks assigned to a Group, which contains one Member as Owner and several Items.
		ITEM as List Item or Item - Item is a task which is assigned to a List
		


		USER has [0..n] MEMBERS as Members of Groups - MEMBER has USER_ID as Foreign Key

		MEMBER_GROUP has [0..n] MEMBERS as Group Members - MEMBER has GROUP_ID as Foreign Key


