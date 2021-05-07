<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"    uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">

<head>
  <meta charset="utf-8">
  <meta content="width=device-width, initial-scale=1.0" name="viewport">

  <title>HappyHouse</title>

  <!-- Favicons -->
  <link href="assets/img/favicon.png" rel="icon">
  <link href="assets/img/apple-touch-icon.png" rel="apple-touch-icon">
  <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.8/css/all.css">

  <!-- Google Fonts -->
  <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Raleway:300,300i,400,400i,500,500i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i" rel="stylesheet">

  <!-- Vendor CSS Files -->
  <link href="assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <link href="assets/vendor/icofont/icofont.min.css" rel="stylesheet">
  <link href="assets/vendor/boxicons/css/boxicons.min.css" rel="stylesheet">
  <link href="assets/vendor/owl.carousel/assets/owl.carousel.min.css" rel="stylesheet">
  <link href="assets/vendor/venobox/venobox.css" rel="stylesheet">
  <link href="assets/vendor/aos/aos.css" rel="stylesheet">

  <!-- Template Main CSS File -->
  <link href="assets/css/style.css" rel="stylesheet">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script type="text/javascript">
	function registArticle() {
		if (document.getElementById("title").value == "") {
			alert("제목을 입력해주세요");
			return;
		} else if (document.getElementById("content").value == "") {
			alert("내용을 입력해주세요");
			return;
		} else {
			document.getElementById("articleform").action = "${root}/main.do";
			document.getElementById("articleform").submit();
		}
	}
	</script>
</head>

<body>
 
  <div class="jumbotron jumbotron-fluid">
    <picture >
      <img src="assets/img/bg-index.jpg" class="jumbotron__background">
    </picture>
    <div class="container text-white text-center">
      <h1 class="display-4">공지사항</h1>
      <p class="lead"></p>
    </div>
  </div>
  <!-- /.jumbotron -->
  <!-- ======= Header ======= -->
<jsp:include page="/header.jsp"/>
<!-- End Header -->
  <main id="main">
    <section id="" class="p-1">
      <div class="container">
        <div class="mb-2">
          <button type="button" id="write-notice" class="btn btn-primary" data-toggle="modal" data-target="#postModal" >글쓰기</button>
          <form class="form-inline float-right">
            <div class="form-group mr-sm-2">
              <select class="form-control" id="selectOption">
                <option selected>내용</option>
                <option>작성일</option>
                <option>글 번호</option>
              </select>
            </div>
            <div class="form-group mr-sm-2">
                <input type="text" class="form-control" id="searchKey">
            </div>
            <button type="submit" class="btn btn-secondary">검색</button>
          </form>
        </div>
        <div class="p-2 mb-5">        
            <table class="table table-hover">
            <thead>
                <tr>
                    <th>글번호</th>
                    <th>제목</th>
                    <th>작성자</th>
                    <th>조회수</th>
                    <th>작성일</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>1</td>
                    <td class="selectPost"><a href="/postAdmin.html" style="color: black;">HappyHouse 웹사이트가 서비스를 시작했어요!</a></td>
                    <td>관리자</td>
                    <td>4</td>
                    <td>2021/03/15</td>
                </tr>
                <tr>
                    <td>2</td>
                    <td class="selectPost"><a href="/postAdmin.html" style="color: black;">내일 점심 뭐먹을까 추천해주세요</a></td>
                    <td>관리자</td>
                    <td>2</td>
                    <td>2021/03/13</td>
                </tr>
                <tr>
                    <td>3</td>
                    <td class="selectPost"><a href="/postAdmin.html" style="color: black;">내일 저녁 뭐먹을까 추천해주세요</a></td>
                    <td>관리자</td>
                    <td>12</td>
                    <td>2021/03/10</td>
                </tr>
            </tbody>
            </table>
        </div>  
        <div class="mt-3">
            <ul class="pagination justify-content-center">
                <li class="page-item"><a class="page-link" href="#">최신</a></li>
                <li class="page-item"><a class="page-link" href="#">이전</a></li>
                <li class="page-item"><a class="page-link" href="#">1</a></li>
                <li class="page-item active"><a class="page-link" href="#">2</a></li>
                <li class="page-item"><a class="page-link" href="#">3</a></li>
                <li class="page-item"><a class="page-link" href="#">다음</a></li>
                <li class="page-item"><a class="page-link" href="#">마지막</a></li>
            </ul>
        </div>
    </div>
    </section><!-- End About Section -->
    
  </main><!-- End #main -->

  <!-- ======= Footer ======= -->
  <footer id="footer">
    <div class="footer-top">
      <div class="container">
        <div class="row">

          <div class="col-lg-3 col-md-6">
            <div class="footer-info">
              <h3>HappyHouse</h3>
              <h5>ssafy 5th 서울 8반 </h5>
              <h5>박재준 이서영</h5>
            </div>
          </div>

          <div class="col-lg-2 col-md-6 footer-links">
            <h4>Links</h4>
            <ul>
              <li><i class="bx bx-chevron-right"></i> <a href="#">Home</a></li>
              <li><i class="bx bx-chevron-right"></i> <a href="#">About us</a></li>
              <li><i class="bx bx-chevron-right"></i> <a href="#">Terms of service</a></li>
            </ul>
          </div>
        </div>
      </div>
    </div>

    <div class="container">
      <div class="copyright">
        &copy; Copyright <strong><span>Maxim</span></strong>. All Rights Reserved
      </div>
      <div class="credits">
        Designed by <a href="https://bootstrapmade.com/">BootstrapMade</a>
      </div>
    </div>
  </footer><!-- End Footer -->

  <a href="#" class="back-to-top"><i class="icofont-simple-up"></i></a>

  <div class="modal" id="postModal">
    <div class="modal-dialog">
      <div class="modal-content">
        <div class="modal-header">
          <h4 class="modal-title">공지사항 글쓰기</h4>
          <button type="button" class="close" data-dismiss="modal">&times;</button>
        </div>
        <div class="modal-body">
            <form id="articleform" method="post" action="">
			<input type="hidden" name="action" id="action" value="registArticle">
                <div class="form-group">
                  <label for="title">제목:</label>
                  <input type="text" class="form-control" id="title" name="title">
                </div>
                <div class="form-group">
                  <label for="content">내용:</label>
                  <textarea rows="8" class="form-control" id="content" name="content"></textarea>
                </div>
                <div class="text-center">
                    <button type="button" class="btn btn-primary" onclick="javascript:registArticle();">글작성</button>
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">목록</button>
                </div>
            </form>
        </div>
      </div>
    </div>
  </div>  

  <!-- Vendor JS Files -->
  <script src="assets/vendor/jquery/jquery.min.js"></script>
  <script src="assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
  <script src="assets/vendor/jquery.easing/jquery.easing.min.js"></script>
  <script src="assets/vendor/php-email-form/validate.js"></script>
  <script src="assets/vendor/owl.carousel/owl.carousel.min.js"></script>
  <script src="assets/vendor/isotope-layout/isotope.pkgd.min.js"></script>
  <script src="assets/vendor/venobox/venobox.min.js"></script>
  <script src="assets/vendor/aos/aos.js"></script>

  <script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>

  <!-- Template Main JS File -->
  <script src="assets/js/main.js"></script>
  <script src="assets/js/user.js"></script>

</body>

</html>