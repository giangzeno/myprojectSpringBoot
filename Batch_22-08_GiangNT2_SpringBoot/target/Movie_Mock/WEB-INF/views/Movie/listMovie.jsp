<%@ page language="java" contentType="text/html; charset=UTF-16"
	pageEncoding="UTF-16"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Movie List</title>
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
.border {
	
}
</style>
</head>

<body>
	<div class="container-fuil">
		<div class="row">
			<div class="col-5"></div>
			<div class="col-5 pl-5">
				<Strong style="font-size: 20px;">Movie list</Strong>
			</div>
		</div>
		<br>
		<div class="row pl-4">
			<div class="col-7">
				<button class="btn btn-primary addnew">
					<i class="fa regular fa-circle-plus pr-1"></i>Add new
				</button>
			</div>
		</div>
		<div class="row pl-4 pt-3">
			<div class="col-9"></div>
			<div class="col-3">
				<form action="${pageContext.request.contextPath}/Movie/List"
					method="post" class="row d-flex pr-5"
					style="display: flex; flex-wrap: nowrap;">
					<button type="submit" class="btn btn-primary">
						<i class="fa solid fa-magnifying-glass"></i>
					</button>
					<input name="search" type="text" class="form-control"
						value="${valueSearch}">
				</form>
			</div>
		</div>
		<div class="row mt-2 pl-4 pr-4">
			<div class="col-12">


				<table class="table">
					<thead>
						<tr>
							<th style="border-top-width: 0;">#</th>
							<th style="border-top-width: 0;">Movie (ENG)</th>
							<th style="border-top-width: 0;">Movie (VN)</th>
							<th style="border-top-width: 0;">Release Date</th>
							<th style="border-top-width: 0;">Movie Production Company</th>
							<th style="border-top-width: 0;">Duration</th>
							<th style="border-top-width: 0;">Version</th>
							<th style="border-top-width: 0;">Detail</th>
							<th style="border-top-width: 0;">Delete</th>
						</tr>
					</thead>
					<tbody>
						<c:choose>
							<c:when test="${empty listMovie}">
								<tr>
									<td class="text-center" colspan="9"
										style="color: red; font-family:;">No data found</td>
								</tr>
							</c:when>

							<c:otherwise>
								<c:forEach items="${listMovie}" var="varVlue" varStatus="var" >
									<tr class="trTable">
										<th scope="row">${var.index+1}</th>
										<td>${varVlue.getMovie_Name_ENG()}</td>
										<td>${varVlue.getMovie_Name_VN()}</td>
										<td>${varVlue.getFrom_Date()}</td>
										<td>${varVlue.getMovie_Production_Company()}</td>
										<td>${varVlue.getDuration()}</td>
										<td>${varVlue.getVersion()}</td>
										<td><a
											href="${pageContext.request.contextPath}/Movie/List/Detail/${varVlue.getMovie_ID()}"><i
												style="color: blue;" class="fa regular fa-circle-info pr-1"></i>Detail</a></td>
										<td><a
											href="${pageContext.request.contextPath}/Movie/List/Delete/${varVlue.getMovie_ID()}"><i
												style="color: blue;" class="fa light fa-trash-can"></i></a></td>
									</tr>
								</c:forEach>
							</c:otherwise>
						</c:choose>

					</tbody>
				</table>
			</div>
		</div>

		<div class="col d-flex">
			<div class="col listPage d-flex"></div>
		</div>
	</div>
</body>
<script>
    $(".addnew").click(function () {
        window.location.assign("http://localhost:8000/Movie/Movie/Add");
    })
                    
    //Page
    let list = document.querySelectorAll(".trTable");
    let thisPage = 1;
    let limit = 5;
    loadItem(limit);


    function loadItem(limit) {
        let beginGet = limit * (thisPage - 1);
        let endGet = limit * thisPage - 1;
        list.forEach((item, key) => {
            if (key >= beginGet && key <= endGet) {
                item.style.display = 'table-row';
            } else {
                item.style.display = 'none';
            }
        });
       

        listPage(limit);
    }

    function listPage(limit) {
        let count = Math.ceil(list.length / limit);
        document.querySelector('.listPage').innerHTML = '';
        let prev = document.createElement('button');
        prev.innerText = 'Previous';
        prev.classList.add('btn');
        prev.classList.add('btn-outline-primary');
        if (count > 0) {
            document.querySelector('.listPage').appendChild(prev);
        };
        if (thisPage != 1) {
            prev.setAttribute('onclick', "changePage(" + (thisPage - 1) + "," + limit + ")");
        };


        let shortcutLeft = document.createElement('div');
        shortcutLeft.innerText = "...";
        shortcutLeft.classList.add('btn');
        shortcutLeft.classList.add('btn-outline-primary')

        let shortcutRight = document.createElement('div');
        shortcutRight.innerText = "...";
        shortcutRight.classList.add('btn');
        shortcutRight.classList.add('btn-outline-primary')

        let firstPage = document.createElement('button');
        firstPage.innerText = 1;
        firstPage.classList.add('btn');
        firstPage.classList.add('btn-outline-primary')
        firstPage.setAttribute('onclick', "changePage(" + 1 + "," + limit + ")");

        let lastPage = document.createElement('button');
        lastPage.innerText = count;
        lastPage.classList.add('btn');
        lastPage.classList.add('btn-outline-primary')
        lastPage.setAttribute('onclick', "changePage(" + count + "," + limit + ")");

        if (count > 5) {
            if (thisPage < 5) {
                if (thisPage == 1) {
                    firstPage.classList.add('active');
                }
                document.querySelector('.listPage').appendChild(firstPage);
                for (i = 2; i <= 5; i++) {
                    let newPage = document.createElement('button');
                    newPage.innerText = i;
                    newPage.classList.add('btn');
                    newPage.classList.add('btn-outline-primary')
                    newPage.setAttribute('onclick', "changePage(" + i + "," + limit + ")");
                    if (i == thisPage) {
                        newPage.classList.add('active');
                    }
                    document.querySelector('.listPage').appendChild(newPage);
                }
                document.querySelector('.listPage').appendChild(shortcutRight);
                document.querySelector('.listPage').appendChild(lastPage);
            } else if (thisPage > (count - 4)) {
                document.querySelector('.listPage').appendChild(firstPage);
                document.querySelector('.listPage').appendChild(shortcutRight);
                var a = count - 4;
                for (i = a; i <= count; i++) {
                    let newPage = document.createElement('button');
                    newPage.innerText = i;
                    newPage.classList.add('btn');
                    newPage.classList.add('btn-outline-primary')
                    newPage.setAttribute('onclick', "changePage(" + i + "," + limit + ")");
                    if (i == thisPage) {
                        newPage.classList.add('active');
                    }
                    document.querySelector('.listPage').appendChild(newPage);
                }
            } else {
                if (thisPage == 1) {
                    firstPage.classList.add('active');
                }
                document.querySelector('.listPage').appendChild(firstPage);
                document.querySelector('.listPage').appendChild(shortcutLeft);
                var b = thisPage - 2;
                var c = thisPage + 2;
                for (i = b; i <= c; i++) {
                    let newPage = document.createElement('button');
                    newPage.innerText = i;
                    newPage.classList.add('btn');
                    newPage.classList.add('btn-outline-primary')
                    newPage.setAttribute('onclick', "changePage(" + i + "," + limit + ")");
                    if (i == thisPage) {
                        newPage.classList.add('active');
                    }
                    document.querySelector('.listPage').appendChild(newPage);
                }
                document.querySelector('.listPage').appendChild(shortcutRight);
                document.querySelector('.listPage').appendChild(lastPage);
            }
        } else {
            for (i = 1; i <= count; i++) {
                let newPage = document.createElement('button');
                newPage.innerText = i;
                newPage.classList.add('btn');
                newPage.classList.add('btn-outline-primary')
                newPage.setAttribute('onclick', "changePage(" + i + "," + limit + ")");
                if (i == thisPage) {
                    newPage.classList.add('active');
                }
                document.querySelector('.listPage').appendChild(newPage);
            }
        }
        let next = document.createElement('button');
        next.innerText = 'Next';
        next.classList.add('btn');
        next.classList.add('btn-outline-primary')
        if (count > 0) {
            document.querySelector('.listPage').appendChild(next);
        }
        if (thisPage != count) {
            next.setAttribute('onclick', "changePage(" + (thisPage + 1) + "," + limit + ")");
        }
    }

    function changePage(i, limit) {
        thisPage = i;
        loadItem(limit);
    }
</script>
</html>