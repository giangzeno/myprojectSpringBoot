<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Add Movie</title>
<link rel="icon" type="images/x-icon"
	href="https://static.vecteezy.com/system/resources/previews/005/903/347/original/gold-abstract-letter-s-logo-for-negative-video-recording-film-production-free-vector.jpg" />
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css">
<link rel="stylesheet" href="/resources/demos/style.css">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css">
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>
<link
	href="https://code.jquery.com/ui/1.10.4/themes/ui-lightness/jquery-ui.css"
	rel="stylesheet">
<script src="https://code.jquery.com/jquery-1.10.2.js"></script>
<script src="https://code.jquery.com/ui/1.10.4/jquery-ui.js"></script>

<style>
.red {
	color: red;
}

.textareastyle {
	border-radius: 5px;
	border: 1px solid #cacaca;
	padding-left: 15px;
	padding-top: 7px;
	width: 1490px;
}

.borderstyle {
	border-color: black;
}

.textareastyle:active {
	border-color: rgb(10, 92, 65);
}

.form-control {
	border: 1px solid #cacaca;
}

.form-select {
	    background-image:        
		url("data:image/svg+xml;charset=utf8,%3Csvg xmlns='http://www.w3.org/2000/svg' version='1.1' height='10px' width='15px'%3E%3Ctext x='0' y='10' fill='gray'%3E%E2%96%BE%3C/text%3E%3C/svg%3E");
}

.form-select.is-valid:not([multiple]):not([size]), .form-select.is-valid:not([multiple])[size="1"],
	    .was-validated .form-select:valid:not([multiple]):not([size]),     .was-validated .form-select:valid:not([multiple])[size="1"]
	{
	    background-image:        
		url("data:image/svg+xml;charset=utf8,%3Csvg xmlns='http://www.w3.org/2000/svg' version='1.1' height='10px' width='15px'%3E%3Ctext x='0' y='10' fill='gray'%3E%E2%96%BE%3C/text%3E%3C/svg%3E"),
		       
		url("data:image/svg+xml,%3csvg xmlns='http://www.w3.org/2000/svg' viewBox='0 0 8 8'%3e%3cpath fill='%23198754' d='M2.3 6.73L.6 4.53c-.4-1.04.46-1.4 1.1-.8l1.1 1.4 3.4-3.8c.6-.63 1.6-.27 1.2.7l-4 4.6c-.43.5-.8.4-1.1.1z'/%3e%3c/svg%3e")
}
</style>
</head>

<body>
	<div class="container-fluid">
		<div class="row pl-0 imgStyle">
			<div class="col-5 pl-0"></div>
			<div class="pt-3">
				<strong class="mb-5">Movie Detail: ${nameENG}</strong><br> <img
					style="width: 220px; height: 200px; padding-left: 50px; margin-top: 25px"
					alt="Refesh lại file  img trong
					file assets"
					src="${pageContext.request.contextPath}/assets/img/${IMG}">
			</div>
			<div class="col-4"></div>
		</div>
		<div class="col-12">
			<form:form action="${pageContext.request.contextPath}/Movie/Add"
				modelAttribute="MovieVlue" method="POST"
				enctype="multipart/form-data">
				<div class="row">
					<strong class="pb-2">Movie ID: <span class="red">*</span></strong>
					<form:input type="text" placeholder="Movie ID" class="form-control"
						path="Movie_ID" maxlength="10" />
					<form:errors style="color: red;" path="Movie_ID"></form:errors>
					<div style="color: red;">${errMovieID}</div>
				</div>

				<div class="row">
					<strong class="pb-2">Movie name (ENG): <span class="red">*</span></strong>
					<form:input type="text" placeholder="Movie name (ENG)"
						class="form-control" path="Movie_Name_ENG" />
					<form:errors style="color: red;" path="Movie_Name_ENG"></form:errors>
				</div>

				<div class="row pt-2">
					<strong class="pb-2">Movie name (VN): <span class="red">*</span></strong>
					<form:input type="text" placeholder="Movie name (VN)"
						class="form-control" path="Movie_Name_VN" />
					<form:errors style="color: red;" path="Movie_Name_VN"></form:errors>

				</div>

				<div class="row pt-2">
					<strong class="pb-2">From date: <span class="red">*</span></strong>
					<form:input type="text" placeholder="dd/mm/yyyy"
						class="form-control datepicker-11" path="From_Date" />
					<div style="color: red;">${err_Date}</div>

				</div>

				<div class="row pt-2">
					<strong class="pb-2">To date: <span class="red">*</span></strong>
					<form:input type="text" placeholder="dd/mm/yyyy"
						class="form-control datepicker-11" path="To_Date" />
					<div style="color: red;">${err_Date}</div>
				</div>

				<div class="row pt-2">
					<strong class="pb-2">Actor: <span class="red">*</span></strong>
					<form:input type="text" placeholder="Actor" class="form-control"
						path="Actor" />
					<form:errors style="color: red;" path="Actor"></form:errors>

				</div>

				<div class="row pt-2">
					<strong class="pb-2">Movie Production Company: <span
						class="red">*</span></strong>
					<form:input type="text" placeholder="Movie Production Company"
						class="form-control" path="Movie_Production_Company" />
					<form:errors style="color: red;" path="Movie_Production_Company"></form:errors>

				</div>

				<div class="row pt-2">
					<strong class="pb-2">Director: <span class="red">*</span></strong>
					<form:input type="text" placeholder="Director" class="form-control"
						path="Director" />
					<form:errors style="color: red;" path="Director"></form:errors>

				</div>

				<div class="row pt-2">
					<strong class="pb-2">Duration: <span class="red">*</span></strong>
					<form:input type="text" placeholder="Duration" class="form-control"
						path="Duration" />
					<form:errors style="color: red;" path="Duration"></form:errors>

				</div>

				<div class="row pt-2">
					<strong class="pb-2">Version: <span class="red">*</span></strong>
					<form:input type="text" placeholder="Version" class="form-control"
						path="Version" />
					<form:errors style="color: red;" path="Version"></form:errors>

				</div>


				<div class="row pt-2">
					<strong class="pb-2">Type: <span class="red">*</span></strong> <br>
				</div>

				<div class="row">
					<div class="col-12 ">
						<c:choose>
							<c:when test="${empty listType}">
								<div style="color: red; font-family:;">
									<button type="button" class="btn btn-outline-warning sampledata mb-2">Add
										Sample Data</button>
								</div>
							</c:when>

							<c:otherwise>
								<c:forEach items="${listType}" var="varVlue">
									<div class="row">
										<c:forEach items="${varVlue}" var="var">
											<c:if test="${not empty var}">

												<div class="checkbox col-2 pl-0">
													<form:checkbox class="mr-1" path="Type_Name" value="${var}" />
													${var}
												</div>
												<br>

											</c:if>
										</c:forEach>
									</div>
								</c:forEach>
							</c:otherwise>
						</c:choose>
					</div>
					<div style="color: red;">${errtype}</div>
				</div>

				<div class="row pt-2">
					<strong class="pb-2">Cinema room: <span class="red">*</span></strong>
					<form:select class="form-control"
						aria-label="Default select example" path="Cinema_Room_Id">
						<form:option value="1">Cinema Room 1</form:option>
						<form:option value="2">Cinema Room 2</form:option>
						<form:option value="3">Cinema Room 3</form:option>
						<form:option value="4">Cinema Room 4</form:option>
					</form:select>
					<form:errors style="color: red;" path="Cinema_Room_Id"></form:errors>

				</div>


				<div class="row pt-4">
					<strong class="pb-2">Schedule: <span class="red">*</span></strong>
					<br>
				</div>
				<div class="row">
					<div class="col-12">

						<c:choose>
							<c:when test="${empty listSchedule}">
								<div style="color: red; font-family:;">
									<button type="button" class="btn btn-outline-warning sampledata mb-2">Add
										Sample Data</button>
								</div>

							</c:when>

							<c:otherwise>
								<c:forEach items="${listSchedule}" var="varVlue">
									<div class="row">
										<c:forEach items="${varVlue}" var="var">
											<c:if test="${not empty var}">

												<div class="checkbox col-2 pl-0">
													<form:checkbox class="mr-1" path="Schedule_Time"
														value="${var}" />
													${var}
												</div>
												<br>

											</c:if>
										</c:forEach>
									</div>
								</c:forEach>
							</c:otherwise>
						</c:choose>
					</div>
					<div style="color: red;">${errSchedule}</div>
				</div>



				<div class="row pt-2">
					<strong class="pb-2">Content: <span class="red">*</span></strong>

				</div>
				<div class="row">
					<div class="borderstyle" style="width: 100%">
						<form:textarea class="form-control" name="" id="" cols="100%"
							rows="2" placeholder="Content" path="Content" />
						<form:errors style="color: red;" path="Content"></form:errors>

					</div>
				</div>


				<div class="row pt-2">
					<strong class="pb-2">Image:</strong> <input type="file"
						placeholder="Không có tệp nào được chọn" class="form-control file"
						name="IMG" style="padding-bottom: 36px;">
					<div style="color: red;">${err_IMG}</div>
				</div>

				<br>
				<div class="row pt-2">
					<button style="width: 90px; background-color: #337AB7"
						class="btn btn-primary mr-2" type="submit">
						<i class="fa solid fa-check pr-1"></i>Save
					</button>
					<button style="width: 90px; background-color: #337AB7"
						class="btn btn-primary back" type="button">
						<i class="fa solid fa-xmark pr-1"></i> Back
					</button>
				</div>
			</form:form>
		</div>
	</div>
</body>

<script>
    $(".back").click(function () {
        window.location.assign("${pageContext.request.contextPath}/Movie/List");
    })

    $(".borderstyle").click(function () {
        $(this).css("border-color", "red")
    })

    $(function () {
        $("#datepicker").datepicker();
    });

    $(function () {
        $(".datepicker-11").datepicker({
            showWeek : true,
            yearSuffix : "-CE",
            showAnim : "slide"
        });
    });

    $(function () {
        $(".datepicker-10").datepicker({
            changeMonth : true,
            changeYear : true,
            numberOfMonths : [ 2, 2 ]
        });
    });
    var img = '${IMG}';
    if (img.length == 0) {
        $(".imgStyle").css("display", "none")
    }
    
    $(".sampledata").click(function name() {
        window.location.assign("${pageContext.request.contextPath}/Movie/SampleData");
        
    })
</script>

</html>