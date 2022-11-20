/**
 * validação de formulário
 */
 
 function validar()
 {
	// alert('teste')
	let idcon = frmContato.idcon.value
	let idade = frmContato.idade.value
	let endereço = frmContato.endereço.value
	let escolaridade = frmContato.escolaridade.value
	
	if (idcon === "")
	{
		alert('Preencha o campo nome')
		frmContato.idcon.focus() //retoma o cursor para o campo nome
		return false //não envia os dados
	}
	else if(idade === "")
	{
		alert('Preencha o campo idade')
		frmContato.idade.focus()
		return false
	}
	else if(endereço === "")
	{
		alert('Preencha o campo endereço')
		frmContato.endereço.focus()
		return false
	}
	else if(escolaridade === "")
	{
		alert('Preencha o campo escolaridade')
		frmContato.escolaridade.focus()
		return false
	}
	
	
	else
	{
		document.forms["frmContato"].submit()
	}
	
}