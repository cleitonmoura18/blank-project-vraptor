$(document).ready(function(){
        $("#data")
				.datepicker({ inline: true})
				.mask("99/99/9999");
	
	$("#nascimento, #dataEmissaoIdentidade, #dataEmissaoCertidao, #dataEmissaoCarteiraTrabalho").mask("99/99/9999");
	$("#nascimento, #dataEmissaoIdentidade, #dataEmissaoCertidao, #dataEmissaoCarteiraTrabalho").datepicker({
				dateFormat:  "dd/mm/yy"
	});
	
	$("#cpf").mask("999.999.999-99", {placeholder:" "});
	
	
});