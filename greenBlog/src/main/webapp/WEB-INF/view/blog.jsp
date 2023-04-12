<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Insert title here</title>
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@48,400,0,0" />
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@48,400,0,0" />
<style type="text/css">
* {
	padding: 0;
	margin: 0;
	box-sizing: border-box;
}

body {
	width: 1000px;
	display: flex;
	flex-direction: column;
	margin: auto;
}

header {
	width: 1000px;
	background-image: url('/images/title.jpg');
	display: flex;
}

.main {
	display: flex;
	padding: 10px;
	/*확인*/
	align-items: flex-start;
	margin-top: 20px;
}

.navi {
	width: 170px;
	border: 3px solid gray;
	border-radius: 10px;
	border: 3px solid gray;
	/*확인*/
	padding: 10px;

}

.navi-title {
	display: flex;
	justify-content: space-between;
	padding-bottom: 15px;	
}

.content {
	width: 730px;
	display: flex;
	flex-direction: column;
	padding: 10px;
}

.all-post {
	display: flex;
}

.post {
	padding: 20px;
}

ul li {
	list-style: none;
}

.title {
	padding: 10px;
	display: flex;
	justify-content: space-between;
}

.pagination ul li {
	float: left;
}
</style>
</head>
<body>
	<header>
		<h1>Green's Blog</h1>
		<span class="material-symbols-outlined">settings</span>
	</header>

	<div class="main">
		<div class="navi">
			<div class="navi-title">
				전체보기 <span class="material-symbols-outlined">settings</span>
			</div>
			<ul>
				<li>Python(12)</li>
				<li>Java(2)</li>
				<li>Ios(8)</li>
				<li>소프트웨어자료(26)</li>
				<li>자료구조(8)</li>
				<li>리눅스(8)</li>
				<li>Git(4)</li>
				<li>자기계발(3)</li>
				<li>경영전략(20)</li>
				<li>리더쉽(7)</li>
			</ul>
		</div>

		<div class="content">

			<div class="title">
				<h4>경영전략20</h4>
				<span class="material-symbols-outlined">edit_square</span>
			</div>

			<div class="all-post">

				<div class="post">
					<div>
						<img src="/images/image.jpg">
					</div>
					<div>
						<p>효린아</p>
					</div>
					<div>2023.01.31</div>
				</div>
				<div class="post">
					<div>
						<img src="/images/image.jpg">
					</div>
					<div>
						<p>열정은 돌아오는게 아니야</p>
					</div>
					<div>2023.02.28</div>
				</div>
				<div class="post">
					<div>
						<img src="/images/image.jpg">
					</div>
					<div>
						<p>니가 만드는겨</p>
					</div>
					<div>2023.03.31</div>
				</div>
				<div class="post">
					<div>
						<img src="/images/image.jpg">
					</div>
					<div>
						<p>열쩡! 열쩡!! 열쩡!!!</p>
					</div>
					<div>2023.04.12</div>
				</div>
			</div>
			<div class="all-post">

				<div class="post">
					<div>
						<img src="/images/image.jpg">
					</div>
					<div>
						<p>효린아</p>
					</div>
					<div>2023.01.31</div>
				</div>
				<div class="post">
					<div>
						<img src="/images/image.jpg">
					</div>
					<div>
						<p>열정은 돌아오는게 아니야</p>
					</div>
					<div>2023.02.28</div>
				</div>
				<div class="post">
					<div>
						<img src="/images/image.jpg">
					</div>
					<div>
						<p>니가 만드는겨</p>
					</div>
					<div>2023.03.31</div>
				</div>
				<div class="post">
					<div>
						<img src="/images/image.jpg">
					</div>
					<div>
						<p>열쩡! 열쩡!! 열쩡!!!</p>
					</div>
					<div>2023.04.12</div>
				</div>
			</div>
			<div class="all-post">

				<div class="post">
					<div>
						<img src="/images/image.jpg">
					</div>
					<div>
						<p>효린아</p>
					</div>
					<div>2023.01.31</div>
				</div>
				<div class="post">
					<div>
						<img src="/images/image.jpg">
					</div>
					<div>
						<p>열정은 돌아오는게 아니야</p>
					</div>
					<div>2023.02.28</div>
				</div>
				<div class="post">
					<div>
						<img src="/images/image.jpg">
					</div>
					<div>
						<p>니가 만드는겨</p>
					</div>
					<div>2023.03.31</div>
				</div>
				<div class="post">
					<div>
						<img src="/images/image.jpg">
					</div>
					<div>
						<p>열쩡! 열쩡!! 열쩡!!!</p>
					</div>
					<div>2023.04.12</div>
				</div>
			</div>
			<div class="all-post">

				<div class="post">
					<div>
						<img src="/images/image.jpg">
					</div>
					<div>
						<p>효린아</p>
					</div>
					<div>2023.01.31</div>
				</div>
				<div class="post">
					<div>
						<img src="/images/image.jpg">
					</div>
					<div>
						<p>열정은 돌아오는게 아니야</p>
					</div>
					<div>2023.02.28</div>
				</div>
				<div class="post">
					<div>
						<img src="/images/image.jpg">
					</div>
					<div>
						<p>니가 만드는겨</p>
					</div>
					<div>2023.03.31</div>
				</div>
				<div class="post">
					<div>
						<img src="/images/image.jpg">
					</div>
					<div>
						<p>열쩡! 열쩡!! 열쩡!!!</p>
					</div>
					<div>2023.04.12</div>
				</div>
			</div>

			<div class="pagination">
				<ul>
					<li><a href=#>이전</a></li>
					<li><a href=#>1</a></li>
					<li><a href=#>2</a></li>
					<li><a href=#>3</a></li>
					<li><a href=#>4</a></li>
					<li><a href=#>5</a></li>
					<li><a href=#>6</a></li>
					<li><a href=#>7</a></li>
					<li><a href=#>8</a></li>
					<li><a href=#>9</a></li>
					<li><a href=#>10</a></li>
					<li><a href=#>다음</a></li>
				</ul>
			</div>
		</div>
	</div>
</body>
</html>