$(document).ready(function() {

	$('#frm-assunto').validate({

		rules : {
			"descricao" : {
				required : true
			},
			"disciplina" : {
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
			"descricao" : {
				required : "Campo obrigatório!"
			},
			"disciplina" : {
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

