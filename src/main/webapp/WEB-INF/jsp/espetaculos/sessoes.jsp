<html>
	<head>
		<title>${espetaculo.nome}</title>
	</head>
	<body>
		<h2>Criar novas sessões</h2>
		<form action="/espetaculo/${espetaculo.id}/sessoes" method="post" class="form-inline" role="form">
			<div class="form-group">
				<label for="inicio">Início</label>
				<input type="text" name="inicio" id="inicio" class="form-control"/>
			</div>
			<div class="form-group">				
				<label for="fim">Fim</label>
				<input  type="text" name="fim" id="fim" class="form-control"/>
				
			</div>
			<div class="form-group">
				<label for="horario">Horário</label>
				<input type="datetime" name="horario" id="horario" class="form-control"/>
			</div>
			<div class="form-group">
				<label for="periodo">Periodicidade</label>
				<select name="periodicidade" id="periodo" class="form-control">
					<option value="DIARIA">Diária</option>		
					<option value="SEMANAL">Semanal</option>			
				</select>
			</div>
			<p/>
			<p>
				<button class="btn btn-primary" type="submit">Criar sessão</button>
			</p>
		</form>
	
	</body>
</html>