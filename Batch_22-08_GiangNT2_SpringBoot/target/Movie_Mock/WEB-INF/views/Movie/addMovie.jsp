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
</style>
</head>

<body>
	<div class="row"></div>
	<div class="container-fluid">
		<div class="row pl-0">
			<div class="col-5 pl-0"></div>
			<div class="col-4" style="color: red;">${feebackeADD}</div>
			<div class="col-4"></div>
		</div>
		<div class="col-12">
			<form:form action="${pageContext.request.contextPath}//Movie/Add"
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
					<strong class="pb-2">Form date: <span class="red">*</span></strong>
					<form:input type="text" placeholder="Form date"
						class="form-control datepicker-11" path="From_Date" />
					<div style="color: red;">${err_Date}</div>

				</div>

				<div class="row pt-2">
					<strong class="pb-2">To date: <span class="red">*</span></strong>
					<form:input type="text" placeholder="To date"
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
						path="Duration" value=""/>
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
					<div class="col-12">
						<c:choose>
							<c:when test="${empty listType}">
								<div style="color: red; font-family:;">No data found</div>
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
								<div style="color: red; font-family:;">No data found</div>

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
					<div class="borderstyle">
						<form:textarea class="form-control" name="" id="" cols="200"
							rows="2" placeholder="Content" path="Content" />
						<form:errors style="color: red;" path="Content"></form:errors>

					</div>
				</div>


				<div class="row pt-2">
					<strong class="pb-2">Image: <span class="red">*</span></strong> <input
						type="file" placeholder="Không có tệp nào được chọn"
						class="form-control file" name="IMG" style="padding-bottom: 36px;">
					<div style="color: red;">${err_IMG}</div>
				</div>

				<br>
				<div class="row pt-2">
					<button style="width: 90px;" class="btn btn-primary mr-2"
						type="submit">
						<i class="fa solid fa-check pr-1"></i>Save
					</button>
					<button style="width: 90px;" class="btn btn-primary back"
						type="button">
						<i class="fa solid fa-xmark pr-1"></i> Back
					</button>
				</div>
			</form:form>
		</div>
	</div>
</body>

<script>
    $(".back").click(function () {
        window.location.assign("http://localhost:8000/Movie/Movie/List");
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
</script>

</html>