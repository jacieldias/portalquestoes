$(document).ready(function() {

	$('#frm-instituicao').validate({

		rules : {
			"nome" : {
				required : true
			},
			"nomeUsual" : {
				required : true
			},
		},

		highlight : function(element) {
			$(element).closest('.form-group').addClass('has-error');
		},
		unhighlight : function(element) {
			$(element).closest('.form-group').removeClass('has-error');
		},
		errorElement : 'span',
		errorClass : 'help-block',
		errorPlacement : function(error, element) {
			if (element.parent('.input-group').length) {
				error.insertAfter(element.parent());
			} else {
				error.insertAfter(element);
			}
		},

		messages : {
			"nome" : {
				required : "Campo obrigatório!"
			},
			"nomeUsual" : {
				required : "Campo obrigatório!"
			},
		}
	});
	
	if($('#msgVazia').is(':empty')){ 
		
	    $('#myModal').modal('hide');
    }else{
	    $('#myModal').modal('show');
    }
});

