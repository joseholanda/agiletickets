<%@page pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	<head>
		<title>${sessao.espetaculo.nome }</title>
	</head>

	<body>
		<h1>${sessao.espetaculo.nome }</h1>
		<h3>${sessao.dia } às ${sessao.hora}</h3>
		<p><label >Local:</label> ${sessao.espetaculo.estabelecimento.nome }</p>
		<p><label >Endereço:</label> ${sessao.espetaculo.estabelecimento.endereco }</p>
		<p><label >Descrição:</label> ${sessao.espetaculo.descricao }</p>
		<p><label >Duração:</label> ${sessao.duracaoEmMinutos } minutos</p>
		<p><label >Ingressos disponíveis:</label> ${sessao.ingressosDisponiveis }</p>
		<c:if test="${sessao.ingressosDisponiveis gt 0}">
			<form action="/sessao/${sessao.id}/reserva" method="post" class="form-inline" role="form">
				<div class="form-group">
					<h3>Reservar ingresso</h3>
					<label for="qtde">Quantidade</label>
					<input id="qtde" name="quantidade" class="form-control"/>
					<input type="submit" value="Reservar" class="btn btn-primary"/>
				</div>
			</form>
		</c:if>
	</body>

</html>