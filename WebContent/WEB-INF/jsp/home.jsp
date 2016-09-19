<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${sessionScope['username']==null}" >
   <c:redirect url="Login.html"/>
</c:if>
<c:if test="${sessionScope['role']!='admin'}" >
     <c:redirect url="Logout.html"/>
</c:if>
<!DOCTYPE html>
<html>
<head>
<title>School Of Rock</title>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
<link href="layout/styles/layout.css" rel="stylesheet" type="text/css"
	media="all">
</head>
<body id="top">
	<!-- ################################################################################################ -->
	<div class="wrapper row0">
		<div id="topbar" class="clear">
			<!-- ################################################################################################ -->
			<nav>
				<ul>
				    <li><a href="User.html">Create Admin</a></li>
					<li><a href="displayTeachers.html">Teachers</a></li>
					<li><a href="displayStudents.html">Students</a>
					<li><a href="Standard.html">Standards</a></li>
					<li><a href="Subject.html">Subjects</a></li>
					<li><a href="TimeTable.html">Time Table</a></li>
					<li><a href="Logout.html">Logout</a></li>
				</ul>
			</nav>
			<!-- ################################################################################################ -->
		</div>
	</div>
	<!-- ################################################################################################ -->
	<div class="wrapper row1">
		<header id="header" class="clear">
			<!-- ################################################################################################ -->
			<div id="logo" class="fl_left">
				<h1>
					<a href="index.jsp">School Of Rock</a>
				</h1>
			</div>
			<!-- ################################################################################################ -->
		</header>
	</div>
	<!-- ################################################################################################ -->
	<div class="wrapper">
		<div id="slider">
			<div id="slide-wrapper" class="rounded clear">
				<!-- ################################################################################################ -->
				<figure id="slide-1">
					<a class="view" href="#"><img src="images/demo/slider/101.jpg"
						alt=""></a>
					<figcaption>
						<h2>All About The School</h2>
						<p>Our school was established in the year 1947 in calcutta.
							Over the years it has expanded to over 20 cities all over India.
							We have top notch quality of faculty</p>
					</figcaption>
				</figure>
				<figure id="slide-2">
					<a class="view" href="#"><img
						src="images/demo/slider/teachers.jpg" alt=""></a>
					<figcaption>
						<h2>Why you should study with us</h2>
						<p>Our school is one of the most prestigious educational
							institute in the country. We have over 500 students. We provide
							the best state of the art education.</p>
					</figcaption>
				</figure>
				<figure id="slide-3">
					<a class="view" href="#"><img src="images/demo/slider/999.jpg"
						alt=""></a>
					<figcaption>
						<h2>Education And Student Experience</h2>
						<p>We provide all around education that focuses not only on
							academics but overall development of the student. We do not
							believe in producing only Einsteins and Newtons but also Picassos
							and DaVincis</p>
					</figcaption>
				</figure>
				<figure id="slide-4">
					<a class="view" href="#"><img
						src="images/demo/slider/index.jpg" alt=""></a>
					<figcaption>
						<h2>Our Teachers</h2>
						<p>The school alumni is always present at our beck and call.
							We have donors from all over the world with donations crossing
							over billions of dollars.</p>
					</figcaption>
				</figure>
				<figure id="slide-5">
					<a class="view" href="#"><img src="images/demo/slider/cu11.jpg"
						alt=""></a>
					<figcaption>
						<h2>Our Coordinates</h2>
						<p>
							Address: School Of Rock<br>No.220, Harington Road, Chennai,
							Tamilnadu, India
						</p>
						<p>Contact No:044-26218190</p>
						<p>E-mail:schoolofrock@gmail.com</p>
					</figcaption>
				</figure>
				<!-- ################################################################################################ -->
				<ul id="slide-tabs">
					<li><a href="#slide-1">All About The School</a></li>
					<li><a href="#slide-2">Why You Should Study With Us</a></li>
					<li><a href="#slide-3">Education And Student Experience</a></li>
					<li><a href="#slide-4">Alumni And Its Donors</a></li>
					<li><a href="#slide-5">Contact Us</a></li>
				</ul>
				<!-- ################################################################################################ -->
			</div>
		</div>
	</div>
	<!-- ################################################################################################ -->

	<!-- JAVASCRIPTS -->
	<script src="layout/scripts/jquery.min.js"></script>
	<script src="layout/scripts/jquery.fitvids.min.js"></script>
	<script src="layout/scripts/jquery.mobilemenu.js"></script>
	<script src="layout/scripts/tabslet/jquery.tabslet.min.js"></script>
</body>
</html>
