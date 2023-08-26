//check validate form employee
var formRegister = $("#form-register");
if (formRegister.length) {
	formRegister.validate({
		// onfocusout: false,
		// onkeyup: false,
		// onclick: false,
		rules: {
			username: {
				required: true,
				maxlength: 28,
			},
			password: {
				required: true,
				maxlength: 28,
			},
			confirmPassword: {
				required: true,
				equalTo: '#password',
				maxlength: 28,
			},
			fullName: {
				required: true,
				maxlength: 28,
			},
			dateOfBirth: {
				required: true,
			},
			identityCard: {
				required: true,
				maxlength: 28,
			},
			email: {
				required: true,
				maxlength: 28,
			},
			address: {
				required: true,
				maxlength: 28,
			},
			phoneNumber: {
				required: true,
				maxlength: 28,
			},
		},
		messages: {
			username: {
				required: "Please input!"
			},
			password: {
				required: "Please input!"
			},
			confirmPassword: {
				required: "Please input!",
				equalTo: "The two passwords must be the same.",
			},
			fullName: {
				required: "Please input!"
			},
			dateOfBirth: {
				required: "Please input!"
			},
			identityCard: {
				required: "Please input!"
			},
			email: {
				required: "Please input!"
			},
			address: {
				required: "Please input!"
			},
			phoneNumber: {
				required: "Please input!"
			},
		},
	});
};

// Set timeout page loader
$(function () {
	setTimeout(function () { $('.page-loader-wrapper').fadeOut(); }, 50);
});

$('#dataTable-listMember').dataTable({
	"ordering": false,
	//searching: false,
	lengthChange: false,
	pageLength: 10,
	bInfo: false,
});

// Date picker

$(function () {
	$('#dateOfBirth').datepicker({
		format: 'dd/mm/yyyy',
		autoclose: true,
		todayHighlight: true
	});
});

//add active
$(function () {
	var loc = window.location.pathname;
	$('#sidebarAdmin').find('a').each(function () {
		if ($(this).attr('href') == loc) {
			$(this).parent().addClass('active');
		}
		if (loc.indexOf('employee') != -1) {
			$('#employee-mana').addClass('active');
		}
		if (loc.indexOf('cinema-room') != -1) {
			$('#cinema-mana').addClass('active');
		}
	});
});

// Drop down hover
$('ul.nav li.dropdown').hover(function () {
	$(this).find('.dropdown-menu').stop(true, true).delay(100).fadeIn(500);
}, function () {
	$(this).find('.dropdown-menu').stop(true, true).delay(10).fadeOut(10);
});

// back page
$("#back").on("click", function () {
	history.back()
});
