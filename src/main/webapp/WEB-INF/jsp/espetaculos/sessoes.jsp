<html>
	<head>
		<title>${espetaculo.nome}</title>
	</head>
	<body>
		<h2>Criar novas sess�es</h2>
		<form action="/espetaculo/${espetaculo.id}/sessoes" method="post" class="form-inline" role="form">
			<div class="form-group">
				<label for="inicio">In�cio</label>
				<input type="date" name="inicio" id="inicio" class="form-control"/>
			</div>
			<div class="form-group">				
				<label for="fim">Fim</label>
				<input type="date" name="fim" id="fim" class="form-control"/>
				
			</div>
			<div class="form-group">
				<label for="horario">Hor�rio</label>
				<input type="datetime" name="horario" id="horario" class="form-control"/>
			</div>
			<div class="form-group">
				<label for="periodo">Periodicidade</label>
				<select name="periodo" id="periodo" class="form-control">
					<option value="DIARIA">Di�ria</option>		
					<option value="SEMANAL">Semanal</option>			
				</select>
			</div>
			<p>
				<input class="btn btn-primary" type="submit" value="Criar sess�o"/>
			</p>
		</form>
	
	</body>
</html>