<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>${sessao.espetaculo.nome }</title>
</head>

<body>
	<h1>${sessao.espetaculo.nome }</h1>
	<h4>${sessao.dia } às ${sessao.hora}</h4>
	<div class="form-horizontal">
		<div class="form-group">
			<label class="col-sm-2">Local:</label>
			<div class="col-sm-10">
				${sessao.espetaculo.estabelecimento.nome }</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2">Endereço:</label>
			<div class="col-sm-10">
				${sessao.espetaculo.estabelecimento.endereco}</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2">Descrição:</label>
			<div class="col-sm-10">${sessao.espetaculo.descricao }</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2">Duração:</label>
			<div class="col-sm-10">${sessao.duracaoEmMinutos } minutos</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2">Ingressos disponíveis:</label>
			<div class="col-sm-10">${sessao.ingressosDisponiveis }</div>
		</div>
	</div>
	<c:if test="${sessao.ingressosDisponiveis gt 0}">
		<form action="/sessao/${sessao.id}/reserva" method="post"
			class="form-horizontal" role="form">
			<div class="form-group">
				<div class="col-sm-4">
					<h3>Reservar ingresso</h3>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2" for="qtde">Quantidade</label>
				<div class="col-sm-10">
					<input id="qtde" name="quantidade" class="form-control" />
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<input type="submit" value="Reservar" class="btn btn-primary" />
				</div>
			</div>
		</form>
	</c:if>
</body>

</html>