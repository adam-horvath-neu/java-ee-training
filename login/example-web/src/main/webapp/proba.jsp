Skip to content This repository Search Pull requests Issues Marketplace
Explore @ballaati Sign out 0 0 0 anmolkhurana/Login-Registration_Form
Code Issues 0 Pull requests 0 Projects 0 Wiki Insights
Login-Registration_Form/WebContent/register.jsp d362793 on Aug 23 2017
@anmolkhurana anmolkhurana All 31 lines (30 sloc) 1.69 KB
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration_page</title>
<link rel="stylesheet" type="text/css" href="style.css">
</head>

<body>
	<form action="registration" method="post">
		<div class="menu">
			<a href="registration.jsp">Contact</a> 
		</div>
		<br>
		<br>
		<center>
			<h1>
				AnmolKhurana <span style="color: #e6b800">Synergistics</span>
			</h1>
		</center>
		<h2>
			Account
			</h2>
				<hr>
				<center>
					<input id="first" style="text-indent: 20px;" type="text"
						name="firstname" ><br>
				</center>
				<center>
					<input id="last" style="text-indent: 20px;" type="text"
						name="lastname"><br>
				</center>
				<center>
					<input id="user" style="text-indent: 20px;" type="text" name="uid"
						><br>
				</center>
				<center>
					<input id="email" style="text-indent: 20px;" type="email"
						name="emailid" ><br>
					</center>
						<center>
							<input id="password" style="text-indent: 20px;" type="password"
								name="password" ><br>
							</center>
								<center>
									<input id="confirmpass" style="text-indent: 20px;"
										type="password" name="confirm" ><br>
									</center>
										<center>
											<input id="contact" style="text-indent: 20px;" type="text"
												name="contact" ><br>
											</center>
												
														<center>
															<input id="in" type="submit" name="submit"
																value="Sign up"></input>
															</center>
	</form>
</body>
</html>
