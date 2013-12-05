<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	<head>
		<title>Lista de Espetáculos</title>
	</head>
	<body>
		
		<h2>Adicionar Espetaculo</h2>
		<form id="addForm" action="" method="post" class="form-horizontal">
			<div class="form-group">
				<label for="nome" class="col-sm-2">Nome:</label> 
					<div class="col-sm-10">
						<input class="form-control" placeholder="Nome" type="text" name="espetaculo.nome" id="nome"/>
					</div>
			</div>
			<div class="form-group">
				<label for="descricao" class="col-sm-2">Descrição:</label> 
					<div class="col-sm-10">
						<input class="form-control" placeholder="Descrição" type="text" name="espetaculo.descricao" id="descricao"/>
					</div>
			</div>
			<div class="form-group">
				<label for="tipo" class="col-sm-2">Tipo:</label> 
					<div class="col-sm-10">
						<select id="tipo" name="espetaculo.tipo" class="form-control">
							<option value="CINEMA">Cinema</option>
							<option value="SHOW">Show</option>
							<option value="TEATRO">Teatro</option>
							<option value="BALLET">Balé</option>
							<option value="ORQUESTRA">Orquestra</option>
						</select>
					</div>
			</div>
			<div class="form-group">
				<label for="tipo" class="col-sm-2">Local:</label> 
					<div class="col-sm-10">
						<select id="tipo" name="espetaculo.estabelecimento.id" class="form-control">
							<c:forEach items="${estabelecimentos}" var="estabelecimento">
								<option value="${estabelecimento.id}">${estabelecimento.nome }</option>
							</c:forEach>
						</select>
					</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<input class="btn btn-primary" type="submit" value="Adicionar"/>
				</div>
			</div>
		</form>
		
		<table cellpadding="0" cellspacing="0" width="100%">
			<caption>Lista de espetáculos</caption>
			<colgroup>
			  <col width="5%">
			  <col width="40%">
			  <col width="30%">
			  <col width="10%">
			  <col width="15%">
			</colgroup>
			<thead>
				<tr>
					<th>Id</th>
					<th>Nome</th>
					<th>Descrição</th>
					<th>Tipo</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${espetaculoList}" var="espetaculo">
					<tr>
						<td>${espetaculo.id }</td>
						<td>${espetaculo.nome }</td>
						<td>${espetaculo.descricao }</td>
						<td>${espetaculo.tipo }</td>
						<td><a href="/espetaculo/${espetaculo.id }/sessoes">Criar sessões</a></td>
					</tr>				
				</c:forEach>
			</tbody>	
		</table>
	</body>
</html>